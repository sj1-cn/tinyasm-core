package nebula.tinyasm;

import static nebula.tinyasm.TypeUtils.stringInnerUserType;
import static nebula.tinyasm.TypeUtils.typeOf;

import java.util.List;

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
			mc.loadThis();
			mc.SPECIAL(getSuperClass(), "<init>").INVOKE();
			mc.returnVoid();
		});
		return this;
	}

	default ClassBody constructerWithAllFields() {
		final List<Field> fields = getFields();
		publicMethod("<init>").parameter(fields).code(mc -> {
			mc.line().initObject();
			for (Field param : fields) {
				mc.line().putField("this", param.name, param.name, param.clazz);
			}
			mc.line().returnVoid();
		});
		return this;
	}

	Clazz clazzOfField(String name);

	default ClassBody makePropertyGet(final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, "get" + toPropertyName(fieldName)).code(mc -> {
			mc.line().loadThis();
			mc.GETFIELD(fieldName, fieldClass.getType());
			mc.RETURNTop();
		});
		return this;
	}

	default ClassBody makePropertyGet(final Class<?> annotationClazz, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, "get" + toPropertyName(fieldName)).annotation(annotationClazz).code(mc -> {
			mc.line().loadThis();
			mc.GETFIELD(fieldName, fieldClass.getType());
			mc.RETURNTop();
		});
		return this;
	}

	default ClassBody makePropertyGet(final String annotationClazz, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, "get" + toPropertyName(fieldName)).annotation(annotationClazz).code(mc -> {
			mc.line().loadThis();
			mc.GETFIELD(fieldName, fieldClass.getType());
			mc.RETURNTop();
		});
		return this;
	}

	//TODO need do now
	default String toPropertyName(String fieldName) {
		return Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
	}
	
	default ClassBody makePropertyGet(final Class<?> annotationClazz, Object value, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, "get" + toPropertyName(fieldName)).annotation(annotationClazz, value)
			.code(mc -> {
				mc.line().loadThis();
				mc.GETFIELD(fieldName, fieldClass.getType());
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertyGet(final String annotationClazz, Object value, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, "get" + toPropertyName(fieldName)).annotation(annotationClazz, value)
			.code(mc -> {
				mc.line().loadThis();
				mc.GETFIELD(fieldName, fieldClass.getType());
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertyGet(final Class<?> annotationClazz, String name, Object value,
			final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, "get" + toPropertyName(fieldName)).annotation(annotationClazz, name, value)
			.code(mc -> {
				mc.line().loadThis();
				mc.GETFIELD(fieldName, fieldClass.getType());
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertyGet(final String annotationClazz, String name, Object value, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod(fieldClass, "get" + toPropertyName(fieldName)).annotation(annotationClazz, name, value)
			.code(mc -> {
				mc.line().loadThis();
				mc.GETFIELD(fieldName, fieldClass.getType());
				mc.RETURNTop();
			});
		return this;
	}

	default ClassBody makePropertySet(final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1)).parameter(fieldName, fieldClass).code(mc -> {
			mc.line().putField("this", fieldName, fieldName, fieldClass);
			mc.line().returnVoid();
		});
		return this;
	}

	default ClassBody makePropertySet(final Class<?> annotationClazz, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1)).annotation(annotationClazz)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putField("this", fieldName, fieldName, fieldClass);
				mc.line().returnVoid();
			});
		return this;
	}

	default ClassBody makePropertySet(final String annotationClazz, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1)).annotation(annotationClazz)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putField("this", fieldName, fieldName, fieldClass);
				mc.line().returnVoid();
			});
		return this;
	}

	default ClassBody makePropertySet(final Class<?> annotationClazz, Object annotationValue, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1)).annotation(annotationClazz, annotationValue)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putField("this", fieldName, fieldName, fieldClass);
				mc.line().returnVoid();
			});
		return this;
	}

	default ClassBody makePropertySet(final String annotationClazz, Object annotationValue, final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1)).annotation(annotationClazz, annotationValue)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putField("this", fieldName, fieldName, fieldClass);
				mc.line().returnVoid();
			});
		return this;
	}

	default ClassBody makePropertySet(final Class<?> annotationClazz, String annotationName, Object annotationValue,
			final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1))
			.annotation(annotationClazz, annotationName, annotationValue)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putField("this", fieldName, fieldName, fieldClass);
				mc.line().returnVoid();
			});
		return this;
	}

	default ClassBody makePropertySet(final String annotationClazz, String annotationName, Object annotationValue,
			final String fieldName) {
		Clazz fieldClass = clazzOfField(fieldName);
		publicMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1))
			.annotation(annotationClazz, annotationName, annotationValue)
			.parameter(fieldName, fieldClass)
			.code(mc -> {
				mc.line().putField("this", fieldName, fieldName, fieldClass);
				mc.line().returnVoid();
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
			Clazz fieldClass = clazzOfField(field.name);
			String name = field.name;
			publicMethod("set" + Character.toUpperCase(name.charAt(0)) + name.substring(1)).parameter(field.name, field.clazz)
				.code(mc -> {
					mc.line().putField("this", field.name, field.name, fieldClass);
					mc.line().returnVoid();
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
					mc.loadThis();
					mc.GET_THIS_FIELD(field.name);
					mc.line();
					mc.INVOKEVIRTUAL(StringBuilder.class.getName(), StringBuilder.class.getName(), "append",
							stringInnerUserType(field.clazz.getType()).getClassName());

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