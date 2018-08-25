package nebula.tinyasm.data;

import static nebula.tinyasm.util.TypeUtils.stringInnerUserType;
import static nebula.tinyasm.util.TypeUtils.toPropertyGetName;
import static nebula.tinyasm.util.TypeUtils.toPropertySetName;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.List;

import nebula.tinyasm.ClassBuilder;

public interface ClassBody extends WithDefineStaticField<ClassBody>, WithDefineField<ClassBody>, WithMakeStaticMethod,
		WithMakeInstanceMethod {

	ClassBuilder end();

	<T extends Field> List<T> getFields();

	String getSuperClass();

	String referInnerClass(String innerClass);

	default String referInnerClass(String objectclazz, String innerClass) {
		return referInnerClass(0, objectclazz, innerClass);
	}

	String referInnerClass(int access, String objectclazz, String innerClass);

	String getName();

	String getSimpleName();

	default ClassBody constructerEmpty() {
		publicMethod("<init>").code(mc -> {
			mc.line(1);
			mc.LOADThis();
			mc.SPECIAL(getSuperClass(), "<init>").INVOKE();
			mc.RETURN();
		});
		return this;
	}

	default ClassBody constructerWithAllFields() {
		final List<Field> fields = getFields();
		publicMethod("<init>").parameter(fields).code(mc -> {
			mc.line().INITObject();
			for (Field param : fields) {
				mc.line().putfield("this", param.name, param.name, param.clazz.originclazz);
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
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).annotation(annotationClazz).code(mc -> {
			mc.line().LOADThis();
			mc.GETFIELD(fieldName, fieldClass);
			mc.RETURNTop();
		});
		return this;
	}

	default ClassBody makePropertyGet(final String annotationClazz, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, toPropertyGetName(fieldName, fieldClass)).annotation(annotationClazz).code(mc -> {
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
		publicMethod(toPropertySetName(fieldName, fieldClass)).annotation(annotationClazz)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putfield("this", fieldName, fieldName, fieldClass);
				mc.line().RETURN();
			});
		return this;
	}

	default ClassBody makePropertySet(final String annotationClazz, final String fieldName) {
		String fieldClass = clazzOfField(fieldName);
		publicMethod(toPropertySetName(fieldName, fieldClass)).annotation(annotationClazz)
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
			publicMethod(toPropertySetName(field.name, fieldClass)).parameter(field.name, field.clazz.originclazz)
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
		ClassBody cb = constructerWithAllFields();
		cb = makeAllPropertyGet();
		cb = toStringWithAllFields();
		return cb;
	}

	default ClassBody toStringWithAllFields() {
		final List<Field> fields = getFields();
		publicMethod(String.class, "toString").code(mc -> {
			mc.define("builder", StringBuilder.class);
			mc.line();

			if (fields.size() > 0) {
				mc.NEW(StringBuilder.class);

				mc.DUP();
				mc.INVOKESPECIAL(StringBuilder.class, "<init>");
				mc.STORE("builder");
				mc.line();
				mc.LOAD("builder");

				mc.LOADConst(getSimpleName() + " [" + fields.get(0).name + "=");

				mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);

				for (int i = 0; i < fields.size(); i++) {
					Field field = fields.get(i);
					if (i > 0) {
						mc.LOADConst(", " + field.name + "=");
						mc.line();
						mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
					}
					mc.LOADThis();
					mc.GET_THIS_FIELD(field.name);
					mc.line();
					mc.INVOKEVIRTUAL(StringBuilder.class.getName(), StringBuilder.class.getName(), "append",
							stringInnerUserType(typeOf(field.clazz.originclazz)).getClassName());

				}
				mc.LOADConst("]");
				mc.line();
				mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
				mc.POP();
				mc.line();
				mc.LOAD("builder");
				mc.INVOKEVIRTUAL(StringBuilder.class, String.class, "toString");
			} else {

				mc.NEW(StringBuilder.class);

				mc.DUP();
				mc.INVOKESPECIAL(StringBuilder.class, "<init>");
				mc.STORE("builder");
				mc.line();
				mc.LOAD("builder");

				mc.LOADConst(getSimpleName() + " []");
				mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
				mc.POP();
				mc.line();
				mc.LOAD("builder");
				mc.INVOKEVIRTUAL(StringBuilder.class, String.class, "toString");
			}

			mc.RETURNTop();
		});
		return this;
	}
//
//	@Deprecated
//	default ClassBody toStringWithAllProperties() {
//		final List<Field> fields = getFields();
//		publicMethod(String.class, "toString").parameter(fields).code(mc -> {
//			mc.line();
//			mc.NEW(StringBuilder.class);
//
//			mc.DUP();
//			mc.LOADConst(getName() + "(");
//			mc.INVOKESPECIAL(StringBuilder.class, "<init>", String.class);
//
//			for (int i = 0; i < fields.size(); i++) {
//				Field field = fields.get(i);
//				mc.line();
//				if (i != 0) {
//					mc.LOADConst(",");
//					mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
//				}
//
//				mc.LOADConst(field.name + "=");
//				mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
//				mc.LOADThis();
//				mc.GETFIELD(field.name, field.type);
//				mc.INVOKEVIRTUAL(typeOf(StringBuilder.class), typeOf(StringBuilder.class), "append", field.type);
//			}
//
//			mc.LOADConst(")");
//			mc.INVOKEVIRTUAL(StringBuilder.class, StringBuilder.class, "append", String.class);
//			mc.INVOKEVIRTUAL(StringBuilder.class, String.class, "toString");
//			mc.RETURNTop();
//		});
//		return this;
//	}
}