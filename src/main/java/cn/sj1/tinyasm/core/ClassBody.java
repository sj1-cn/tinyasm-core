package cn.sj1.tinyasm.core;

import java.util.List;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;

public interface ClassBody
		extends AfterModifier, UsingModifier, UsingDefineStaticField, UsingDefineField, WithMakeStaticMethod, UsingMethodWithModified, UsingMethodWithoutModified {

	ClassBuilder end();

	<T extends Field> List<T> getFields();

	ClassVisitor getClassWriter();

	String getSuperClass();

	String referInnerClass(String innerClass);

	default String referInnerClass(String objectclazz, String innerClass) {
		return referInnerClass(0, objectclazz, innerClass);
	}

	default String referInnerClass(Class<?> objectclazz, Class<?> innerClass) {
		return referInnerClass(0, objectclazz.getName(), innerClass.getName());
	}

	default String referInnerClass(int access, Class<?> objectclazz, Class<?> innerClass) {
		return referInnerClass(access, objectclazz.getName(), innerClass.getName());
	}

	String referInnerClass(int access, String objectclazz, String innerClass);

	String getName();

	String getSimpleName();

	// TODO constructerEmpty
	default ClassBody constructerEmpty() {
		public_().method("<init>").code(code -> {
			Label label0 = new Label();
			code.visitLabel(label0);
			code.LINE(3);
			code.LOAD("this");
			code.SPECIAL(getSuperClass(), "<init>").INVOKE();
			code.RETURN();
		});
		return this;
	}

	// TODO constructerWithAllFields
	default ClassBody constructerWithAllFields() {
		final List<Field> fields = getFields();
		public_().method("<init>").parameter(fields).code(code -> {
			code.LINE();
			code.LOAD("this");
			code.SPECIAL(getSuperClass(), "<init>").INVOKE();

			for (Field param : fields) {
				code.LINE();
				code.LOAD("this");
				code.LOAD(param.name);
				code.PUTFIELD(param.name, param.clazz.getType().getClassName());
			}
			code.LINE(10);
			code.RETURN();

		});
		return this;
	}

	Clazz clazzOfField(String name);

	public void visitInnerClass(String string, String string2, String string3, int i);

//	Class<?> stringInnerUserType(Clazz clazz);

}