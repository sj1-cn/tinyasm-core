package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.signatureOf;

import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.ClassField;
import nebula.tinyasm.data.Field;
import nebula.tinyasm.util.ArrayListMap;

class ClassBuilderImpl extends ClassVisitor implements ClassBuilder, ClassBody, ClassHeader {
	public static String toSimpleName(String className) {
		return className.substring(className.lastIndexOf('.') + 1);
	}

	ArrayListMap<Field> fields = new ArrayListMap<>();

	boolean hadEnd = false;

	private Type superType;

	private Type thisType;

	protected ClassBuilderImpl() {
		super(Opcodes.ASM5, new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS));
	}

	protected ClassBuilderImpl(ClassVisitor cv) {
		super(Opcodes.ASM5, cv);
	}

	ClassBuilderImpl(final int access, ClassVisitor cv, Type thisType, Type superType) {
		super(Opcodes.ASM5, cv);
		initType(thisType, superType);
		cv.visit(52, access, thisType.getInternalName(), null, superType.getInternalName(), null);
		cv.visitSource(toSimpleName(this.thisType.getClassName()) + ".java", null);
	}

	ClassBuilderImpl(final int access, ClassVisitor cv, Type thisType, Type superType, Type interfaceType,
			Type[] interfaceSignatures) {
		super(Opcodes.ASM5, cv);
		initType(thisType, superType);

		cv.visit(52, access, thisType.getInternalName(),
				superType.getDescriptor() + signatureOf(interfaceType, interfaceSignatures),
				superType.getInternalName(), new String[] { interfaceType.getInternalName() });
		cv.visitSource(toSimpleName(this.thisType.getClassName()) + ".java", null);
	}

	ClassBuilderImpl(final int access, ClassVisitor cv, Type thisType, Type superType, Type[] superTypeSignatures) {
		super(Opcodes.ASM5, cv);
		initType(thisType, superType);

		cv.visit(52, access, thisType.getInternalName(), signatureOf(superType, superTypeSignatures),
				superType.getInternalName(), null);
		cv.visitSource(toSimpleName(this.thisType.getClassName()) + ".java", null);
	}

	@Override
	public ClassHeader vmAnnotation(Type annotationType, Object annotationValue) {
		visitAnnotation(cv, annotationType, annotationValue);
		return this;
	}

	void visitAnnotation(ClassVisitor cv, Type annotationType, Object annotationValue) {
		AnnotationVisitor av0 = cv.visitAnnotation(annotationType.getDescriptor(), true);
		if (annotationValue != null) {
			AnnotationVisitor av1 = av0.visitArray("value");
			av1.visit(null, annotationValue);
			av1.visitEnd();
		}
		av0.visitEnd();
	}

	@Override
	public ClassBuilderImpl end() {
		cv.visitEnd();
		hadEnd = true;
		return this;
	}

	public static void visitDefineField(ClassVisitor cw, int access, String fieldName, Type fieldType) {
		FieldVisitor fv = cw.visitField(access, fieldName, fieldType.getDescriptor(), null, null);
		fv.visitEnd();
	}

	@Override
	public ClassBody mvField(int access, String fieldName, Type fieldType) {
		Field field1 = new Field(fieldName, fieldType);
		fields.push(field1.name, field1);
		visitDefineField(cv, access, fieldName, fieldType);
		return this;
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, int access, String fieldName, Type fieldType,
			String signature) {
		FieldVisitor fv = cw.visitField(access, fieldName, fieldType.getDescriptor(), signature, null);
		fv.visitEnd();
		return fv;
	}

	@Override
	public ClassBody mvField(int access, String fieldName, Type fieldType, String signature) {
		Field field1 = new ClassField(access, fieldName, fieldType, signature, null);
		fields.push(field1.name, field1);
		visitDefineField(cv, access, fieldName, fieldType, signature);
		return this;
	}

	public static void visitAnnotation(FieldVisitor fv, Type annotationType, Object value) {
		AnnotationVisitor av0 = fv.visitAnnotation(annotationType.getDescriptor(), true);
		if (value != null) {
			AnnotationVisitor av1 = av0.visitArray("value");
			av1.visit(null, value);
			av1.visitEnd();
		}
		av0.visitEnd();
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, int access, String fieldName, Type fieldType,
			String signature, Type annotationType, Object value) {
		FieldVisitor fv = cw.visitField(access, fieldName, fieldType.getDescriptor(), signature, null);
		if (annotationType != null) visitAnnotation(fv, annotationType, value);
		fv.visitEnd();
		return fv;
	}

	public static FieldVisitor visitDefineField(ClassVisitor cw, int access, String fieldName, Type fieldType,
			Type annotationType, Object value) {

		return visitDefineField(cw, access, fieldName, fieldType, null, annotationType, value);
	}

	@Override
	public ClassBody mvField(int access, Type annotationType, Object annotationValue, String fieldName, Type fieldType) {
		Field field1 = new ClassField(access, fieldName, fieldType, null, null);
		fields.push(field1.name, field1);
		visitDefineField(cv, access, fieldName, fieldType, annotationType, annotationValue);
		return this;
	}

	@Override
	public ClassBody mvField(int access, Type annotationType, Object annotationValue, String fieldName, Type fieldType,
			String signature) {
		Field field1 = new ClassField(access, fieldName, fieldType, signature, null);
		fields.push(field1.name, field1);
		visitDefineField(cv, access, fieldName, fieldType, signature, annotationType, annotationValue);
		return this;
	}

	public Field fieldOfThis(String fieldName) {
		return fields.get(fieldName);
	}

	@Override
	public List<Field> getFields() {
		return this.fields.values();
	}

	@Override
	public Type getSuperType() {
		return superType;
	}

	private void initType(Type thisType, Type superType) {
		this.thisType = thisType;
		this.superType = superType;
	}

	@Override
	public MethodHeader<MethodCodeInstance> mvMethod(int access, Type returnType, String methodName,
			String[] exceptions) {
		return new MethodHeaderInstanceBuilder(this, thisType, access, returnType, methodName, exceptions);
	}

	@Override
	public Type referInnerClass(String name) {
		String internalName = thisType.getInternalName() + "$" + name;

		cv.visitInnerClass(internalName, thisType.getInternalName(), name, 0);

		return Type.getType("L" + internalName + ";");
	}

	@Override
	public MethodHeader<MethodCodeStatic> mvStaticMethod(int access, Type returnType, String methodName,
			String[] exceptionClasses) {
		return new MethodHeaderStaticBuilder(this, thisType, access, returnType, methodName, exceptionClasses);
	}

	@Override
	public byte[] toByteArray() {
		if (!hadEnd) {
			end();
		}
		if (cv instanceof ClassWriter) {
			return ((ClassWriter) cv).toByteArray();
		}
		return null;
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		initType(Type.getObjectType(name), Type.getObjectType(superName));
		super.visit(version, access, name, signature, superName, interfaces);
	}

	@Override
	public void visitEnd() {
		super.visitEnd();
		hadEnd = true;
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
		Field field = new ClassField(access, name, Type.getType(desc), signature, value);
		this.fields.push(field.name, field);
		return super.visitField(access, name, desc, signature, value);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		return cv.visitMethod(access, name, desc, signature, exceptions);
	}

	@Override
	public ClassBody body() {
		return this;
	}

	@Override
	public ClassBuilder body(Consumer<ClassBody> mb) {
		mb.accept(this);
		return this;
	}
}
