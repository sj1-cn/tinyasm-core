package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.stringInnerUserType;
import static nebula.tinyasm.util.TypeUtils.toPropertyGetName;
import static nebula.tinyasm.util.TypeUtils.toPropertySetName;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.List;

import nebula.tinyasm.data.Field;

public interface ClassBody extends ClassDefineField<ClassBody>, ClassDefineStaticMethod, ClassDefineInstanceMethod {

	ClassBuilder end();

	List<Field> getFields();

	String getSuperClass();

	String referInnerClass(String innerClass);

	String getName();

	@Deprecated
	void visitInnerClass(String name, String outerName, String innerName, int access);

	default ClassBody constructerEmpty() {
		publicMethod("<init>").code(mc -> {
			mc.line(1).INITObject();
			mc.RETURN();
		});
		return this;
	}

	@Deprecated
	default ClassBody constructerToSuper(Field[] superFields) {
		if (this.getFields().size() > 0) {
			publicMethod("<init>").parameter(this.getFields()).parameter(superFields).code(mc -> {
				mc.LOADThis();
				for (Field param : superFields) {
					mc.LOAD(param.name);
				}
				mc.INVOKESPECIAL(typeOf(getSuperClass()), null, "<init>", typeOf(superFields));

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
				mc.INVOKESPECIAL(typeOf(getSuperClass()), null, "<init>", typeOf(superFields));

				mc.RETURN();
			});
			return this;
		}
	}

	@Deprecated
	default ClassBody constructerToSuper(List<Field> superFields) {
		if (this.getFields().size() > 0) {
			publicMethod("<init>").parameter(this.getFields()).parameter(superFields).code(mc -> {
				mc.LOADThis();
				for (Field param : superFields) {
					mc.LOAD(param.name);
				}
				mc.INVOKESPECIAL(typeOf(getSuperClass()), null, "<init>", typeOf(superFields));

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
				mc.INVOKESPECIAL(typeOf(getSuperClass()), null, "<init>", typeOf(superFields));

				mc.RETURN();
			});
			return this;
		}
	}

	default ClassBody constructerWithAllFields() {
		final List<Field> fields = getFields();
		publicMethod("<init>").parameter(fields).code(mc -> {
			mc.line().INITObject();
			for (Field param : fields) {
				mc.line().putfield("this", param.name, param.name, param.type);
			}
			mc.line().RETURN();
		});
		return this;
	}

	String clazzOfField(String name);

	default ClassBody makePropertyGet(final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).code(mc -> {
			mc.line().LOADThis();
			mc.GETFIELD(fieldName, fieldClass);
			mc.RETURNTop();
		});
		return this;
	}

	default ClassBody makePropertyGet(final Class<?> annotationClazz, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).annotation(typeOf(annotationClazz), null)
			.code(mc -> {
				mc.line().LOADThis();
				mc.GETFIELD(fieldName, fieldClass);
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertyGet(final String annotationClazz, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).annotation(typeOf(annotationClazz), null)
			.code(mc -> {
				mc.line().LOADThis();
				mc.GETFIELD(fieldName, fieldClass);
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertyGet(final Class<?> annotationClazz, Object value, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).annotation(annotationClazz, value)
			.code(mc -> {
				mc.line().LOADThis();
				mc.GETFIELD(fieldName, fieldClass);
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertyGet(final String annotationClazz, Object value, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).annotation(annotationClazz, value)
			.code(mc -> {
				mc.line().LOADThis();
				mc.GETFIELD(fieldName, fieldClass);
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertyGet(final Class<?> annotationClazz, String name, Object value,
			final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).annotation(annotationClazz, name, value)
			.code(mc -> {
				mc.line().LOADThis();
				mc.GETFIELD(fieldName, fieldClass);
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertyGet(final String annotationClazz, String name, Object value, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).annotation(annotationClazz, name, value)
			.code(mc -> {
				mc.line().LOADThis();
				mc.GETFIELD(fieldName, fieldClass);
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertySet(final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(toPropertySetName(fieldName, fieldClass)).parameter(fieldName, fieldClass).code(mc -> {
			mc.line().putfield("this", fieldName, fieldName, fieldClass);
			mc.line().RETURN();
		});
		return this;
	}

	default ClassBody makePropertySet(final Class<?> annotationClazz, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(toPropertySetName(fieldName, fieldClass)).annotation(typeOf(annotationClazz), null)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putfield("this", fieldName, fieldName, fieldClass);
				mc.line().RETURN();
			});
		return this;
	}

	default ClassBody makePropertySet(final String annotationClazz, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(toPropertySetName(fieldName, fieldClass)).annotation(typeOf(annotationClazz), null)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putfield("this", fieldName, fieldName, fieldClass);
				mc.line().RETURN();
			});
		return this;
	}

	default ClassBody makePropertySet(final Class<?> annotationClazz, Object annotationValue, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(toPropertySetName(fieldName, fieldClass)).annotation(annotationClazz, annotationValue)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putfield("this", fieldName, fieldName, fieldClass);
				mc.line().RETURN();
			});
		return this;
	}

	default ClassBody makePropertySet(final String annotationClazz, Object annotationValue, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(toPropertySetName(fieldName, fieldClass)).annotation(annotationClazz, annotationValue)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putfield("this", fieldName, fieldName, fieldClass);
				mc.line().RETURN();
			});
		return this;
	}

	default ClassBody makePropertySet(final Class<?> annotationClazz, String annotationName, Object annotationValue,
			final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(toPropertySetName(fieldName, fieldClass))
			.annotation(annotationClazz, annotationName, annotationValue)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putfield("this", fieldName, fieldName, fieldClass);
				mc.line().RETURN();
			});
		return this;
	}

	default ClassBody makePropertySet(final String annotationClazz, String annotationName, Object annotationValue,
			final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(toPropertySetName(fieldName, fieldClass))
			.annotation(annotationClazz, annotationName, annotationValue)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putfield("this", fieldName, fieldName, fieldClass);
				mc.line().RETURN();
			});
		return this;
	}

	default ClassBody makeAllPropertyGet() {
		for (Field param : getFields()) {
			makePropertyGet(param.name);
		}
		return this;
	}

	default ClassBody makeAllPropertySet() {
		for (Field param : getFields()) {
			final Field field = param;
			String fieldClass = clazzOfField(field.name);
			publicMethod(toPropertySetName(field.name, fieldClass)).parameter(field.name, field.type.getClassName())
				.code(mc -> {
					mc.line().putfield("this", field.name, field.name, fieldClass);
					mc.line().RETURN();
				});
		}
		return this;
	}

	default ClassBody makePojo() {
		constructerEmpty();
		makeAllPropertyGet();
		makeAllPropertySet();
		return toStringWithAllFields();
	}

	default ClassBody makeReadonlyPojo() {
		constructerWithAllFields();
		makeAllPropertyGet();
		return toStringWithAllFields();
	}

	default ClassBody toStringWithAllFields() {
		final List<Field> fields = getFields();
		publicMethod(String.class, "toString").code(mc -> {
			mc.line();
			mc.NEW(StringBuilder.class);

			mc.DUP();

			mc.LOADThis();
			mc.INVOKEVIRTUAL(Object.class, Class.class, "getClass");
			mc.INVOKEVIRTUAL(Class.class, String.class, "getSimpleName");
			mc.INVOKESTATIC(String.class, String.class, "valueOf", Object.class);
			mc.INVOKESPECIAL(StringBuilder.class, "<init>", String.class);

			if (fields.size() > 0) {
				mc.LOADConst(" [" + fields.get(0).name + "=");
			} else {
				mc.LOADConst(" [");
			}
			mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);

			for (int i = 0; i < fields.size(); i++) {
				Field field = fields.get(i);
				if (i > 0) {
					mc.LOADConst(", " + field.name + "=");
					mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
				}

				mc.LOADThis();
				mc.GETFIELD_OF_THIS(field.name);

				mc.INVOKEVIRTUAL(StringBuilder.class.getName(), StringBuilder.class.getName(), "append",
						stringInnerUserType(field.type).getClassName());
			}

			mc.LOADConst("]");
			mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
			mc.INVOKEVIRTUAL(StringBuilder.class, String.class, "toString");
			mc.RETURNTop();
		});
		return this;
	}

	@Deprecated
	default ClassBody toStringWithAllProperties() {
		final List<Field> fields = getFields();
		publicMethod(String.class, "toString").parameter(fields).code(mc -> {
			mc.line();
			mc.NEW(StringBuilder.class);

			mc.DUP();
			mc.LOADConst(getName() + "(");
			mc.INVOKESPECIAL(StringBuilder.class, "<init>", String.class);

			for (int i = 0; i < fields.size(); i++) {
				Field field = fields.get(i);
				mc.line();
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