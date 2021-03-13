package cc1sj.tinyasm;

import static cc1sj.tinyasm.TypeUtils.toSimpleName;
import static cc1sj.tinyasm.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import java.util.List;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

class ClassBodyImpl extends ClassVisitor implements ClassBuilder, ClassBody {

	FieldList fields = new FieldList();
	FieldList staticFields = new FieldList();

	boolean hadEnd = false;

	final private Clazz superType;

	final private Clazz thisType;
//	private String name;

	ClassBodyImpl(ClassVisitor cv, ClassHeaderImpl header) {
		super(Opcodes.ASM5, cv);

//		this.name = header.name;
		this.thisType = header.clazz;
		this.superType = header.superClazz;
		{
			int version = 53;
			int access = header.access;

			String name = this.thisType.getType().getInternalName();
			String signature = null;
			boolean needSignature = false;
			String superSignature = "";
			if (header.formalTypeParameters.size() > 0) {
				superSignature += "<";
				for (Clazz inTerface : header.formalTypeParameters) {
					needSignature |= inTerface.needSignature();
					superSignature += inTerface.signatureAnyway();
				}
				superSignature += ">";
			}
			needSignature = needSignature |= header.superClazz.needSignature();
			superSignature += header.superClazz.signatureAnyway();

			for (Clazz inTerface : header.interfaces) {
				needSignature |= inTerface.needSignature();
				superSignature += inTerface.signatureAnyway();
			}

			if (needSignature) signature = superSignature;

			String superName = this.superType.getType().getInternalName();
			String[] interfaces = new String[header.interfaces.size()];
			for (int i = 0; i < header.interfaces.size(); i++) {
				interfaces[i] = header.interfaces.get(i).getType().getInternalName();
			}

			cv.visit(version, access, name, signature, superName, interfaces);
		}

		String fileName = this.thisType.getType().getClassName();
		int i = fileName.indexOf("$");
		if (i >= 0) {
			fileName = fileName.substring(0, fileName.indexOf("$"));
		}

		cv.visitSource(toSimpleName(fileName) + ".java", null);

		for (Annotation annotation : header.annotations) {
			Annotation.visitAnnotation(cv, annotation);
		}
	}

	@Override
	public ClassVisitor getClassWriter() {
		return this.cv;
	}

	@Override
	public Clazz clazzOfField(String name) {
		return fields.get(name).clazz;
	}

	@Override
	public ClassBodyImpl end() {
		cv.visitEnd();
		hadEnd = true;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Field> List<T> getFields() {
		return (List<T>) this.fields.list();
	}

	@Override
	public String getName() {
		return this.thisType.getType().getClassName();
	}

	@Override
	public String getSimpleName() {
		String name = getName();
		return name.substring(name.lastIndexOf(".") + 1, name.length());
	}

	@Override
	public String getSuperClass() {
		return superType.getType().getClassName();
	}

	@Override
	public int staticField(int access, String name, Clazz clazz) {
		access |= Opcodes.ACC_STATIC;
		ClassField field1 = new ClassField(access, name, clazz, null);
		staticFields.push(field1);
		FieldVisitor fv = cv.visitField(access, name, clazz.getDescriptor(), clazz.signatureWhenNeed(), null);
		fv.visitEnd();
		return staticFields.size() - 1;
	}

	@Override
	public int staticField(int access, Annotation annotation, String name, Clazz clazz) {
		access |= Opcodes.ACC_STATIC;
		ClassField field1 = new ClassField(access, name, clazz, null);
		staticFields.push(field1);
		FieldVisitor fv = cv.visitField(access, name, clazz.getDescriptor(), clazz.signatureWhenNeed(), null);

		assert annotation != null;
		Annotation.visitAnnotation(fv, annotation);

		fv.visitEnd();
		return staticFields.size() - 1;
	}

	@Override
	public int field(String name, Clazz clazz) {
		return field(memberAccess, name, clazz);
	}

	@Override
	public int field(Annotation annotation, String name, Clazz clazz) {
		return field(memberAccess, annotation, name, clazz);
	}

	@Override
	public int field(int access, String name, Clazz clazz) {
		ClassField field1 = new ClassField(access, name, clazz, null);
		fields.push(field1);
		FieldVisitor fv = cv.visitField(access, name, clazz.getDescriptor(), clazz.signatureWhenNeed(), null);
		fv.visitEnd();
		memberAccess = 0;
		return fields.size() - 1;
	}

	@Override
	public int field(int access, Annotation annotation, String name, Clazz clazz) {
		ClassField field1 = new ClassField(access, name, clazz, null);
		fields.push(field1);
		FieldVisitor fv = cv.visitField(access, name, clazz.getDescriptor(), clazz.signatureWhenNeed(), null);

		assert annotation != null;
		Annotation.visitAnnotation(fv, annotation);

		fv.visitEnd();
		memberAccess = 0;
		return fields.size() - 1;
	}

	@Override
	public MethodHeader staticMethod(int access, String name) {
		return new MethodHeaderBuilder(this, thisType, access |= Opcodes.ACC_STATIC, name);
	}

	@Override
	public MethodHeader staticMethod(int access, Clazz returnType, String name) {
		return new MethodHeaderBuilder(this, thisType, access |= Opcodes.ACC_STATIC, returnType, name);
	}

	@Override
	public MethodHeader method(int access, String name) {
		return new MethodHeaderBuilder(this, thisType, access, name);
	}

	@Override
	public MethodHeader method(String name) {
		MethodHeader mh = new MethodHeaderBuilder(this, thisType, memberAccess, name);
		memberAccess = 0;
		return mh;
	}

//
//	@Override
//	public MethodHeader method(int access, Clazz returnType, String name) {
//		return new MethodHeaderBuilder(this, thisType, access, returnType, name);
//	}

	@Override
	public String referInnerClass(int access, String objectclazz, String innerName) {
		String outerName = typeOf(objectclazz).getInternalName();
		String fullName = outerName + "$" + innerName;
		cv.visitInnerClass(fullName, outerName, innerName, access);
//		classWriter.visitInnerClass("java/lang/invoke/MethodHandles$Lookup", "java/lang/invoke/MethodHandles", "Lookup", ACC_PUBLIC | ACC_FINAL | ACC_STATIC);

		return Type.getType("L" + fullName + ";").getClassName();
	}

	@Override
	public String referInnerClass(String innerName) {
		if (thisType.getType().getInternalName().indexOf("$") < 0) {
			String outerName = thisType.getType().getInternalName();
			String fullName = outerName + "$" + innerName;
			cv.visitInnerClass(fullName, outerName, innerName, 0);

			return Type.getType("L" + fullName + ";").getClassName();
		} else {
			String fullName = thisType.getType().getInternalName();
			String outerName = fullName.substring(0, fullName.indexOf("$"));
			cv.visitInnerClass(fullName, outerName, innerName, 0);
			return Type.getType("L" + fullName + ";").getClassName();
		}
	}

	int memberAccess = 0;

	@Override
	public AfterModifier public_() {
		memberAccess = ACC_PUBLIC;
		return this;
	}

	@Override
	public AfterModifier protected_() {
		memberAccess = ACC_PROTECTED;
		return this;
	}

	@Override
	public AfterModifier private_() {
		memberAccess = ACC_PRIVATE;
		return this;
	}

	@Override
	public AfterModifier package_() {
		memberAccess = 0;
		return this;
	}

	@Override
	public byte[] toByteArray() {
		if (!hadEnd) {
			end();
		}
		assert cv instanceof ClassWriter;
		return ((ClassWriter) cv).toByteArray();
	}
}
