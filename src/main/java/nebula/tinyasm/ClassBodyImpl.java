package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.internalNamelOf;
import static nebula.tinyasm.util.TypeUtils.toSimpleName;
import static nebula.tinyasm.util.TypeUtils.typeOf;

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

	final private Type superType;

	final private Type thisType;

	ClassBodyImpl(ClassVisitor cv, ClassHeaderImpl header) {
		super(Opcodes.ASM5, cv);

		this.thisType = typeOf(header.name);
		this.superType = typeOf(header.superClazz.originclazz);
		{
			int version = 53;
			int access = header.access;
			String name = this.thisType.getInternalName();
			String signature = null;
			boolean needSignature = header.superClazz.needSignature();
			String superSignature = header.superClazz.signatureAnyway();
			for (GenericClazz inTerface : header.interfaces) {
				needSignature |= inTerface.needSignature();
				superSignature += inTerface.signatureAnyway();
			}

			if (needSignature) signature = superSignature;

			String superName = this.superType.getInternalName();
			String[] interfaces = new String[header.interfaces.size()];
			for (int i = 0; i < header.interfaces.size(); i++) {
				interfaces[i] = internalNamelOf(header.interfaces.get(i).originclazz);
			}

			cv.visit(version, access, name, signature, superName, interfaces);
		}

		String fileName = this.thisType.getClassName();
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
	public String clazzOfField(String name) {
		return fields.get(name).clazz.originclazz;
	}

	@Override
	public ClassBodyImpl end() {
		cv.visitEnd();
		hadEnd = true;
		return this;
	}

//	public Field fieldOfThis(String fieldName) {
//		return fields.get(fieldName);
//	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Field> List<T> getFields() {
		return (List<T>) this.fields.list();
	}

	@Override
	public String getName() {
		return this.thisType.getClassName();
	}

	@Override
	public String getSimpleName() {
		String name = getName();
		return name.substring(name.lastIndexOf(".") + 1, name.length());
	}

	@Override
	public String getSuperClass() {
		return superType.getClassName();
	}

	@Override
	public ClassBody staticField(int access, String name, GenericClazz clazz) {
		access |= Opcodes.ACC_STATIC;
		ClassField field1 = new ClassField(access, name, clazz, null);
		staticFields.push(field1);
		FieldVisitor fv = cv.visitField(access, name, clazz.getDescriptor(), clazz.signatureWhenNeed(), null);
		fv.visitEnd();
		return this;
	}

	@Override
	public ClassBody staticField(int access, Annotation annotation, String name, GenericClazz clazz) {
		access |= Opcodes.ACC_STATIC;
		ClassField field1 = new ClassField(access, name, clazz, null);
		staticFields.push(field1);
		FieldVisitor fv = cv.visitField(access, name, clazz.getDescriptor(), clazz.signatureWhenNeed(), null);

		assert annotation != null;
		Annotation.visitAnnotation(fv, annotation);

		fv.visitEnd();
		return this;
	}

	@Override
	public ClassBody field(int access, String name, GenericClazz clazz) {
		ClassField field1 = new ClassField(access, name, clazz, null);
		fields.push(field1);
		FieldVisitor fv = cv.visitField(access, name, clazz.getDescriptor(), clazz.signatureWhenNeed(), null);
		fv.visitEnd();
		return this;
	}

	@Override
	public ClassBody field(int access, Annotation annotation, String name, GenericClazz clazz) {
		ClassField field1 = new ClassField(access, name, clazz, null);
		fields.push(field1);
		FieldVisitor fv = cv.visitField(access, name, clazz.getDescriptor(), clazz.signatureWhenNeed(), null);

		assert annotation != null;
		Annotation.visitAnnotation(fv, annotation);

		fv.visitEnd();
		return this;
	}

	@Override
	public MethodHeader staticMethod(int access, String name) {
		return new MethodHeaderBuilder(this, thisType.getClassName(), access |= Opcodes.ACC_STATIC, name);
	}

	@Override
	public MethodHeader staticMethod(int access, String returnType, String name) {
		return new MethodHeaderBuilder(this, thisType.getClassName(), access |= Opcodes.ACC_STATIC, returnType, name);
	}

	@Override
	public MethodHeader method(int access, String name) {
		return new MethodHeaderBuilder(this, thisType.getClassName(), access, name);
	}

	@Override
	public MethodHeader method(int access, String returnType, String name) {
		return new MethodHeaderBuilder(this, thisType.getClassName(), access, returnType, name);
	}

	@Override
	public String referInnerClass(int access, String objectclazz, String innerName) {
		String outerName = typeOf(objectclazz).getInternalName();
		String fullName = outerName + "$" + innerName;
		cv.visitInnerClass(fullName, outerName, innerName, access);

		return Type.getType("L" + fullName + ";").getClassName();
	}

	@Override
	public String referInnerClass(String innerName) {
		if (thisType.getInternalName().indexOf("$") < 0) {
			String outerName = thisType.getInternalName();
			String fullName = outerName + "$" + innerName;
			cv.visitInnerClass(fullName, outerName, innerName, 0);

			return Type.getType("L" + fullName + ";").getClassName();
		} else {
			String fullName = thisType.getInternalName();
			String outerName = fullName.substring(0, fullName.indexOf("$"));
			cv.visitInnerClass(fullName, outerName, innerName, 0);
			return Type.getType("L" + fullName + ";").getClassName();
		}
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
