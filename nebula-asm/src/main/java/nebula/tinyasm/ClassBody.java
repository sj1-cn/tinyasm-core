package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.toPropertyGetName;
import static nebula.tinyasm.util.TypeUtils.toPropertySetName;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.List;

import org.objectweb.asm.Type;

import nebula.tinyasm.data.Field;

public interface ClassBody extends ClassDefineField<ClassBody>, ClassDefineStaticMethod, ClassDefineInstanceMethod {

	ClassBuilder end();

	List<Field> getFields();

	Type getSuperType();

	Type referInnerClass(String innerClass);
	
	String getName();

	@Deprecated
	void visitInnerClass(String name, String outerName, String innerName, int access);

	default ClassBody constructerEmpty() {
		publicMethod("<init>").code(mc -> {
			mc.INITObject();
			mc.RETURN();
		});
		return this;
	}

	default ClassBody constructerToSuper(Field[] superFields) {
		if (this.getFields().size() > 0) {
			publicMethod("<init>").parameter(this.getFields()).parameter(superFields).code(mc -> {
				mc.LOADThis();
				for (Field param : superFields) {
					mc.LOAD(param.name);
				}
				mc.INVOKESPECIAL(getSuperType(), Type.VOID_TYPE, "<init>", typeOf(superFields));

				for (Field param : this.getFields()) {
					mc.putfield("this", param.name, param.name, param.type);
					;
				}
				mc.RETURN();
			});
			return this;
		} else {
			publicMethod("<init>").parameter(superFields).code(mc -> {
				mc.LOADThis();
				for (Field param : superFields) {
					mc.LOAD(param.name);
				}
				mc.INVOKESPECIAL(getSuperType(), Type.VOID_TYPE, "<init>", typeOf(superFields));

				mc.RETURN();
			});
			return this;
		}
	}

	default ClassBody constructerToSuper(List<Field> superFields) {
		if (this.getFields().size() > 0) {
			publicMethod("<init>").parameter(this.getFields()).parameter(superFields).code(mc -> {
				mc.LOADThis();
				for (Field param : superFields) {
					mc.LOAD(param.name);
				}
				mc.INVOKESPECIAL(getSuperType(), Type.VOID_TYPE, "<init>", typeOf(superFields));

				for (Field param : this.getFields()) {
					mc.putfield("this", param.name, param.name, param.type);
				}
				mc.RETURN();
			});
			return this;
		} else {
			publicMethod("<init>").parameter(superFields).code(mc -> {
				mc.LOADThis();
				for (Field param : superFields) {
					mc.LOAD(param.name);
				}
				mc.INVOKESPECIAL(getSuperType(), Type.VOID_TYPE, "<init>", typeOf(superFields));

				mc.RETURN();
			});
			return this;
		}
	}

	default ClassBody constructerWithAllFields() {
		final List<Field> fields = getFields();
		publicMethod("<init>").parameter(fields).code(mc -> {
			mc.INITObject();
			for (Field param : fields) {
				mc.putfield("this", param.name, param.name, param.type);
			}
			mc.RETURN();
		});
		return this;
	}

	default ClassBody definePropertyGet(final String fieldName, final String fieldClass) {
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).code(mc -> {
			mc.LOADThis();
			mc.GETFIELD(fieldName, fieldClass);
			mc.RETURNTop();
		});
		return this;
	}

	default ClassBody definePropertySet(final Class<?> annotationClass, final String fieldName,
			final Class<?> fieldClass) {
		final Type fieldClass1 = typeOf(fieldClass);
		publicMethod(toPropertySetName(fieldName, fieldClass1.getClassName())).annotation(typeOf(annotationClass), null)
			.parameter(fieldName, fieldClass1)
			.code(mc -> {
				mc.putfield("this", fieldName, fieldName, fieldClass1);
				mc.RETURN();
			});
		return this;
	}

	default ClassBody definePropertySet(final String fieldName, final Class<?> fieldClass) {
		publicMethod(toPropertySetName(fieldName, fieldClass)).parameter(fieldName, fieldClass).code(mc -> {
			mc.putfield("this", fieldName, fieldName, fieldClass);
			mc.RETURN();
		});
		return this;
	}

	default ClassBody definePropertySet(final String annotationType, String name, Object value, final String fieldName,
			final Class<?> fieldClass) {
		publicMethod(toPropertySetName(fieldName, fieldClass)).annotation(annotationType, name, value)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.putfield("this", fieldName, fieldName, fieldClass);
				mc.RETURN();
			});
		return this;
	}

	default ClassBody definePropertySet(final String annotationClass, final String fieldName, final String fieldClass) {
		final Type fieldClass1 = typeOf(fieldClass);
		publicMethod(toPropertySetName(fieldName, fieldClass1.getClassName())).annotation(typeOf(annotationClass), null)
			.parameter(fieldName, fieldClass1)
			.code(mc -> {
				mc.putfield("this", fieldName, fieldName, fieldClass1);
				mc.RETURN();
			});
		return this;
	}

	default ClassBody defineAllPropetyGet() {
		for (Field param : getFields()) {
			final Field field = param;
			definePropertyGet(field.name, field.type.getClassName());
		}
		return this;
	}

	default ClassBody defineAllPropetySet() {
		for (Field param : getFields()) {
			final Field field = param;
			publicMethod(toPropertySetName(field.name, field.type.getClassName()))
				.parameter(field.name, field.type.getClassName())
				.code(mc -> {
					mc.putfield("this", field.name, field.name, field.type.getClassName());
					mc.RETURN();
				});
		}
		return this;
	}


	default ClassBody makePojo() {
		constructerWithAllFields();
		defineAllPropetyGet();
		defineAllPropetySet();
		toStringWithAllFields();
		return toStringWithAllFields();
	}

	default ClassBody makeReadonlyPojo() {
		constructerWithAllFields();
		defineAllPropetyGet();
		return toStringWithAllFields();
	}

	default ClassBody toStringWithAllFields() {
		final List<Field> fields = getFields();
		publicMethod(String.class, "toString").parameter(fields).code(mc -> {
			mc.NEW(StringBuilder.class);

			mc.DUP();
			mc.LOADConst(getName() + "(");

			mc.INVOKESPECIAL(StringBuilder.class, "<init>", String.class);

			for (int i = 0; i < fields.size(); i++) {
				Field field = fields.get(i);
				if (i != 0) {
					mc.LOADConst(",");
					mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
				}

				mc.LOADConst(field.name + "=");
				mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);

				mc.LOADThis();
				mc.GETFIELD(field.name, field.type);

				mc.INVOKEVIRTUAL(typeOf(StringBuilder.class), typeOf(StringBuilder.class), "append", field.type);
			}

			mc.LOADConst(")");
			mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
			mc.INVOKEVIRTUAL(StringBuilder.class, String.class, "toString");
			mc.RETURNTop();
		});
		return this;
	}

	default ClassBody toStringWithAllProperties() {
		final List<Field> fields = getFields();
		publicMethod(String.class, "toString").parameter(fields).code(mc -> {
			mc.NEW(StringBuilder.class);

			mc.DUP();
			mc.LOADConst(getName() + "(");
			mc.INVOKESPECIAL(StringBuilder.class, "<init>", String.class);

			for (int i = 0; i < fields.size(); i++) {
				Field field = fields.get(i);
				if (i != 0) {
					mc.LOADConst(",");
					mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
				}

				mc.LOADConst(field.name + "=");
				mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
				mc.LOADThis();
				mc.GETFIELD(field.name, field.type);
				mc.INVOKEVIRTUAL(typeOf(StringBuilder.class), typeOf(StringBuilder.class), "append", field.type);
			}

			mc.LOADConst(")");
			mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
			mc.INVOKEVIRTUAL(StringBuilder.class, String.class, "toString");
			mc.RETURNTop();
		});
		return this;
	}
}