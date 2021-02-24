package nebula.data.broker;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class BrokerInstanceBuilderClassMaker implements Opcodes {

	private final static String interfaceName = BrokerInstanceBuilder.class.getName();

	public byte[] dump(String brokerName, String builderName) {
//		String name = interfaceName +"_" + brokerName.replace('.', '_');
		String brokerInnerName = brokerName.replace('.', '/');
		String nameInner = builderName.replace('.', '/');
		String interfaceInnerName = interfaceName.replace('.', '/');

		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;

		cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, nameInner, null, "java/lang/Object", new String[] { interfaceInnerName });

		cw.visitSource(builderName, null);

		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "build", "()Ljava/lang/Object;", "<T:Ljava/lang/Object;>()TT;", null);
			mv.visitCode();
			mv.visitTypeInsn(NEW, brokerInnerName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, brokerInnerName, "<init>", "()V", false);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}
}
