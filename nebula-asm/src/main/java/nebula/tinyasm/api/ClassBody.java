package nebula.tinyasm.api;

import java.util.List;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.ClassBuilder;

import static nebula.tinyasm.api.TypeUtils.*;

public interface ClassBody extends ToType, Opcodes, ClassDefineField<ClassBody>,
		ClassDefineStaticMethod<StaticMethodCode>, ClassDefineInstanceMethod<InstanceMethodCode> {

	default ClassBody annotation(Class<?> annotationClass) {
		return annotation(typeOf(annotationClass));
	}

	default ClassBody annotation(String annotationClass) {
		return annotation(typeOf(annotationClass));
	}

	default ClassBody annotation(Class<?> annotationClass, Object value) {
		return annotation(typeOf(annotationClass), value);
	}

	default ClassBody annotation(Type annotationType) {
		return annotation(annotationType, null);
	}

	ClassBody annotation(Type annotationType, Object value);

	default ClassBody defineAllPropetyGet() {
		for (Field param : getFields()) {
			definePropertyGet(param);
		}
		return this;
	}

	default ClassBody defineAllPropetySet() {
		for (Field param : getFields()) {
			definePropertySet(param);
		}
		return this;
	}

	default ClassBody definePropertyGet(final Field field) {
		return definePropertyGet(field.name, field.type);
	}

	default ClassBody definePropertyGet(final String fieldName, final Type fieldType) {
		publicMethod(fieldType, toPropertyGetName(fieldName, fieldType)).code(mc -> {
			mc.LOADThis();mc.GETFIELD(fieldName, fieldType);
			mc.RETURNTop();
		});
		return this;
	}

	default ClassBody definePropertySet(final Field field) {
		return definePropertySet(field.name, field.type);
	}

	default ClassBody definePropertySet(final String fieldName, final Class<?> fieldClass) {
		return definePropertySet(fieldName, typeOf(fieldClass));
	}

	default ClassBody definePropertySet(final String fieldName, final Type fieldType) {
		publicMethod(toPropertySetName(fieldName, fieldType)).parameter(fieldName, fieldType).code(mc -> {
			mc.PUTFIELD("this", fieldName, fieldName, fieldType);
			mc.RETURN();
		});
		return this;
	}

	default ClassBody definePropertySet(final Type annotationType, final String fieldName, final Type fieldType) {
		publicMethod(toPropertySetName(fieldName, fieldType)).annotation(annotationType)
			.parameter(fieldName, fieldType)
			.code(mc -> {
				mc.PUTFIELD("this", fieldName, fieldName, fieldType);
				mc.RETURN();
			});
		return this;
	}

	default ClassBody definePropertySet(final Type annotationType, String name, Object value, final String fieldName,
			final Type fieldType) {
		publicMethod(toPropertySetName(fieldName, fieldType)).annotation(annotationType, name, value)
			.parameter(fieldName, fieldType)
			.code(mc -> {
				mc.PUTFIELD("this", fieldName, fieldName, fieldType);
				mc.RETURN();
			});
		return this;
	}

	default ClassBody definePropertySet(final Class<?> annotationClass, final String fieldName, final Type fieldType) {
		return definePropertySet(typeOf(annotationClass), fieldName, fieldType);
	}

	default ClassBody definePropertySet(final Class<?> annotationClass, final String fieldName,
			final Class<?> fieldClass) {
		return definePropertySet(typeOf(annotationClass), fieldName, typeOf(fieldClass));
	}

	ClassBuilder end();

	default ClassBody fields(List<Field> fields) {
		for (Field field : fields) {
			field(field);
		}
		return this;
	}

	default ClassBody fields(Field... fields) {
		for (Field field : fields) {
			field(field);
		}
		return this;
	}

	List<Field> getFields();

	Type getSuperType();

	default ClassBody readonlyPojo() {
		return publicInitAllFields().defineAllPropetyGet().publicToStringWithAllFields();
	}

	default ClassBody pojo() {
		return publicInitAllFields().defineAllPropetyGet().defineAllPropetySet().publicToStringWithAllFields();
	}

	default ClassBody publicInitNone() {
		publicMethod("<init>").code(mc -> {
			mc.init();
			mc.RETURN();
		});
		return this;
	}

	default ClassBody publicInitAllFields() {
		final List<Field> fields = getFields();
		publicMethod("<init>").parameter(fields).code(mc -> {
			mc.init();
			for (Field param : fields) {
				mc.PUTFIELD("this", param.name, param.name,param.type);;
			}
			mc.RETURN();
		});
		return this;
	}

	default ClassBody publicInitWithSuper(Field[] superFields) {
		if (this.getFields().size() > 0) {
			publicMethod("<init>").parameter(this.getFields()).parameter(superFields).code(mc -> {
				mc.LOADThis();
				for (Field param : superFields) {
					mc.LOAD(param.name);
				}
				mc.type(getSuperType()).invokeSpecial("<init>", typeOf(superFields));

				for (Field param : this.getFields()) {
					mc.PUTFIELD("this", param.name, param.name,param.type);;
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
				mc.type(getSuperType()).invokeSpecial("<init>", typeOf(superFields));

				mc.RETURN();
			});
			return this;
		}
	}

	default ClassBody publicInitWithSuper(List<Field> superFields) {
		if (this.getFields().size() > 0) {
			publicMethod("<init>").parameter(this.getFields()).parameter(superFields).code(mc -> {
				mc.LOADThis();
				for (Field param : superFields) {
					mc.LOAD(param.name);
				}
				mc.type(getSuperType()).invokeSpecial("<init>", typeOf(superFields));

				for (Field param : this.getFields()) {
					mc.PUTFIELD("this", param.name, param.name,param.type);
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
				mc.type(getSuperType()).invokeSpecial("<init>", typeOf(superFields));

				mc.RETURN();
			});
			return this;
		}
	}

	default ClassBody publicToStringWithAllFields() {
		final List<Field> fields = getFields();
		publicMethod(String.class, "toString").parameter(fields).code(mc -> {
			mc.NEW(StringBuilder.class);

			mc.DUP();
			mc.LOADConst(toSimpleName(getStackTopType().getClassName()) + "(");
			mc.type(StringBuilder.class).invokeSpecial("<init>", String.class);

			for (int i = 0; i < fields.size(); i++) {
				Field field = fields.get(i);
				if (i != 0) {
					mc.LOADConst(",");
					mc.type(StringBuilder.class).invokeVirtual(StringBuilder.class, "append", String.class);
				}

				mc.LOADConst(field.name + "=");
				mc.type(StringBuilder.class).invokeVirtual(StringBuilder.class, "append", String.class);

				mc.LOADThis();mc.GETFIELD(field.name, field.type);
				
				mc.type(StringBuilder.class).invokeVirtual(StringBuilder.class, "append", field.type);
			}

			mc.LOADConst(")");
			mc.type(StringBuilder.class).invokeVirtual(StringBuilder.class, "append", String.class);
			mc.type(StringBuilder.class).invokeVirtual(String.class, "toString");
			mc.RETURNTop();
		});
		return this;
	}

	Type referInnerClass(String innerClass);

	byte[] toByteArray();

	default ClassBody visitDefine_toString_withAllProperties() {
		final List<Field> fields = getFields();
		publicMethod(String.class, "toString").parameter(fields).code(mc -> {
			mc.NEW(StringBuilder.class);

			mc.DUP();
			mc.LOADConst(toSimpleName(getStackTopType().getClassName()) + "(");
			mc.type(StringBuilder.class).invokeSpecial("<init>", String.class);

			for (int i = 0; i < fields.size(); i++) {
				Field field = fields.get(i);
				if (i != 0) {
					mc.LOADConst(",");
					mc.type(StringBuilder.class).invokeVirtual(StringBuilder.class, "append", String.class);
				}

				mc.LOADConst(field.name + "=");
				mc.type(StringBuilder.class).invokeVirtual(StringBuilder.class, "append", String.class);
				mc.LOADThis();mc.GETFIELD(field.name, field.type);
				mc.type(StringBuilder.class).invokeVirtual(StringBuilder.class, "append", field.type);
			}

			mc.LOADConst(")");
			mc.type(StringBuilder.class).invokeVirtual(StringBuilder.class, "append", String.class);
			mc.type(StringBuilder.class).invokeVirtual(String.class, "toString");
			mc.RETURNTop();
		});
		return this;
	}

	ClassVisitor visitor();

}