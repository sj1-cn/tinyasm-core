package nebula.data.broker;

import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DLOAD;
import static org.objectweb.asm.Opcodes.DRETURN;
import static org.objectweb.asm.Opcodes.FLOAD;
import static org.objectweb.asm.Opcodes.FRETURN;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.LLOAD;
import static org.objectweb.asm.Opcodes.LRETURN;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;

import java.io.IOException;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.Method;

class BrokerForClassClassVisitor extends ClassVisitor {
	final static String ActualInstanceFieldName = "_actualValue";
	String clzInternalName;
	String targetTypeName;
	String targetTypeDescriptor;
	private boolean hasDefaultConstract;
	final static String brokerTypeName = Type.getInternalName(BrokerHandler.class);

	public BrokerForClassClassVisitor(int api) {
		super(api);
	}

	public BrokerForClassClassVisitor(int api, ClassVisitor cv, String name) {
		super(api, cv);
		this.clzInternalName = name;
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		this.targetTypeName = name;
		this.targetTypeDescriptor = "L" + this.targetTypeName + ";";
		FieldVisitor fv;
		MethodVisitor mv;

		cv.visit(version, ACC_PUBLIC + ACC_SUPER, this.clzInternalName,
				"L" + this.targetTypeName + ";L" + brokerTypeName + "<L" + this.targetTypeName + ";>;", this.targetTypeName,
				new String[] { brokerTypeName });

		{
			fv = cv.visitField(ACC_PROTECTED, "_actualValue", this.targetTypeDescriptor, null, null);
			fv.visitEnd();
		}
		{
			fv = cv.visitField(ACC_PROTECTED, "_listeners", "Ljava/util/List;",
					"Ljava/util/List<Lnebula/data/DataWatcher<" + this.targetTypeDescriptor + ">;>;", null);
			fv.visitEnd();
		}
		{
			mv = cv.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, this.targetTypeName, "<init>", "()V", false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cv.visitMethod(ACC_PUBLIC, "get", "()" + this.targetTypeDescriptor, null, null);
			mv.visitCode();

			mv.visitVarInsn(ALOAD, 0);
			mv.visitInsn(ARETURN);

			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		ClassReader cr2;
		try {
			cr2 = new ClassReader(Broker.class.getName());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		BrokerInClassVisitor bw2 = new BrokerInClassVisitor(Opcodes.ASM4, cv, name);
		cr2.accept(bw2, 0);

		{
			mv = cv.visitMethod(ACC_PUBLIC, "getActualValue", "()" + this.targetTypeDescriptor, null, null);
			mv.visitCode();

			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, this.clzInternalName, "_actualValue", this.targetTypeDescriptor);
			mv.visitInsn(ARETURN);

			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cv.visitMethod(ACC_PUBLIC, "addWatcher", "(Lnebula/data/DataWatcher;)V",
					"(Lnebula/data/DataWatcher<" + this.targetTypeDescriptor + ">;)V", null);
			mv.visitCode();

			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, this.clzInternalName, "_listeners", "Ljava/util/List;");
			mv.visitVarInsn(ALOAD, 1);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, this.clzInternalName, "_actualValue", this.targetTypeDescriptor);
			mv.visitMethodInsn(INVOKESPECIAL, this.clzInternalName, "_addWatcher",
					"(Ljava/util/List;Lnebula/data/DataWatcher;Ljava/lang/Object;)Ljava/util/List;", false);
			mv.visitFieldInsn(PUTFIELD, this.clzInternalName, "_listeners", "Ljava/util/List;");

			mv.visitInsn(RETURN);

			mv.visitMaxs(5, 2);
			mv.visitEnd();
		}
		{
			mv = cv.visitMethod(ACC_PUBLIC, "setNewValue", "(" + this.targetTypeDescriptor + ")V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitFieldInsn(PUTFIELD, this.clzInternalName, "_actualValue", this.targetTypeDescriptor);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, this.clzInternalName, "_listeners", "Ljava/util/List;");
			mv.visitVarInsn(ALOAD, 1);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, this.clzInternalName, "_actualValue", this.targetTypeDescriptor);
			mv.visitMethodInsn(INVOKESPECIAL, this.clzInternalName, "_notify", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V",
					false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(4, 2);
			mv.visitEnd();
		}
		{
			mv = cv.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "get", "()Ljava/lang/Object;", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKEVIRTUAL, this.clzInternalName, "get", "()" + this.targetTypeDescriptor, false);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cv.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "getActualValue", "()Ljava/lang/Object;", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKEVIRTUAL, this.clzInternalName, "getActualValue", "()" + this.targetTypeDescriptor, false);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cv.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "setNewValue", "(Ljava/lang/Object;)V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitTypeInsn(CHECKCAST, this.targetTypeName);
			mv.visitMethodInsn(INVOKEVIRTUAL, this.clzInternalName, "setNewValue", "(" + this.targetTypeDescriptor + ")V", false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(2, 2);
			mv.visitEnd();
		}
	}

	@Override
	public void visitSource(String source, String debug) {
		String newSourceName = this.clzInternalName + ".java";
		cv.visitSource(newSourceName, debug);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor mv = null;
		{
			if (name.equals("<init>")) {
				if ("()V".equals(desc)) {
					this.hasDefaultConstract = true;
				}
			} else if (!name.equals("<clinit>") && (access & (ACC_STATIC | ACC_PRIVATE | ACC_SYNTHETIC | ACC_NATIVE | ACC_BRIDGE)) == 0) {

//TODO				if ((access & ACC_FINAL) != 0) throw new RuntimeException("new FinalModifierException(superToCopy, name)");

				mv = cv.visitMethod(ACC_PUBLIC, name, desc, signature, exceptions);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, this.clzInternalName, "_actualValue", this.targetTypeDescriptor);
				mv.visitTypeInsn(CHECKCAST, this.targetTypeName);

				Method currentTransformMethod = new Method(name, desc);
				delegateCall(mv, currentTransformMethod, this.targetTypeName);

				mv.visitMaxs(2, 2);
				mv.visitEnd();
			}

		}
		return null;
	}

	/**
	 * This method loads this, any args, then invokes the super version of this
	 */
	private final void delegateCall(MethodVisitor mv, Method currentTransformMethod, String typeName) {
		int nargs = currentTransformMethod.getArgumentTypes().length;

		for (int i = 1; i <= nargs; i++) {
			switch (currentTransformMethod.getArgumentTypes()[i - 1].getSort()) {
			case (Type.BOOLEAN):
			case (Type.BYTE):
			case (Type.CHAR):
			case (Type.SHORT):
			case (Type.INT):
				mv.visitVarInsn(ILOAD, i);
				break;
			case (Type.FLOAT):
				mv.visitVarInsn(FLOAD, i);
				break;
			case (Type.DOUBLE):
				mv.visitVarInsn(DLOAD, i);
				break;
			case (Type.LONG):
				mv.visitVarInsn(LLOAD, i);
				break;
			default:
				mv.visitVarInsn(ALOAD, i);
			}
		}

		mv.visitMethodInsn(INVOKEVIRTUAL, typeName, currentTransformMethod.getName(), currentTransformMethod.getDescriptor(), false);

		switch (currentTransformMethod.getReturnType().getSort()) {
		case (Type.BOOLEAN):
		case (Type.BYTE):
		case (Type.CHAR):
		case (Type.SHORT):
		case (Type.INT):
			mv.visitInsn(IRETURN);
			break;
		case (Type.VOID):
			mv.visitInsn(RETURN);
			break;
		case (Type.FLOAT):
			mv.visitInsn(FRETURN);
			break;
		case (Type.DOUBLE):
			mv.visitInsn(DRETURN);
			break;
		case (Type.LONG):
			mv.visitInsn(LRETURN);
			break;
		default:
			mv.visitInsn(ARETURN);
		}
	}

	@Override
	public void visitEnd() {
		if (!this.hasDefaultConstract) {
			throw new RuntimeException("cannot support class with default(no arguement) constructor");
		}
		cv.visitEnd();
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
		// return cv.visitField(access, name, desc, signature, value);
		return null;
	}

	static class BrokerInClassVisitor extends ClassVisitor {

		public BrokerInClassVisitor(int api) {
			super(api);
		}

		public BrokerInClassVisitor(int api, ClassVisitor cv, String name) {
			super(api, cv);
		}

		@Override
		public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
			if (!name.equals("<init>") && !name.equals("<clinit>") && (access & ACC_PRIVATE) != 0
					&& (access & (ACC_STATIC | ACC_SYNTHETIC | ACC_NATIVE | ACC_BRIDGE)) == 0) {
				return cv.visitMethod(access, name, desc, signature, exceptions);
			} else {
				return null;
			}
		}

		@Override
		public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		}

		@Override
		public void visitSource(String source, String debug) {
		}

		@Override
		public void visitOuterClass(String owner, String name, String desc) {
		}

		@Override
		public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
			return null;
		}

		@Override
		public void visitAttribute(Attribute attr) {
		}

		@Override
		public void visitInnerClass(String name, String outerName, String innerName, int access) {
		}

		@Override
		public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
			return null;
		}

		@Override
		public void visitEnd() {
		}
	}
}
