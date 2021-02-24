package nebula.data.broker;

import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
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
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.LLOAD;
import static org.objectweb.asm.Opcodes.LRETURN;
import static org.objectweb.asm.Opcodes.RETURN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.Method;

class BrokerForInterfaceClassVisitor extends ClassVisitor {
	String name;
	String targetTypeName;
	final static String brokerTypeName = Broker.class.getName().replace('.', '/');
	Map<String, MethodVisitor> dones = new HashMap<String, MethodVisitor>();

	public BrokerForInterfaceClassVisitor(int api) {
		super(api);
	}

	public BrokerForInterfaceClassVisitor(int api, ClassVisitor cv, String name) {
		super(api, cv);
		this.name = name;
	}

	int version = 0;
	boolean done = false;
	List<String> interfaces = new ArrayList<String>();

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		this.version = version;
		this.interfaces.add(name);
		this.targetTypeName = this.interfaces.get(0);
		if (this.interfaces.size() == 1) {
			this.finish();
		}
	}

	public void finish() {
		this.targetTypeName = this.interfaces.get(0);

		super.visit(version, ACC_PUBLIC + ACC_SUPER, this.name,
				"L" + brokerTypeName + "<L" + this.targetTypeName + ";>;L" + this.targetTypeName + ";", "" + brokerTypeName + "",
				new String[] { this.targetTypeName });

		MethodVisitor mv;
		{
			mv = super.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "" + brokerTypeName + "", "<init>", "()V", false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		{
			mv = super.visitMethod(ACC_PUBLIC, "get", "()L" + targetTypeName + ";", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		{
			mv = super.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "get", "()Ljava/lang/Object;", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKEVIRTUAL, this.name, "get", "()L" + targetTypeName + ";", false);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
	}

	@Override
	public void visitSource(String source, String debug) {
		String newSourceName = this.name + ".java";
		super.visitSource(newSourceName, debug);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		String key = name + desc;
		if (dones.containsKey(key)) {
			return null;
		}

		MethodVisitor mv = null;
		{
			if (!!!name.equals("<init>") && !!!name.equals("<clinit>")
					&& (access & (ACC_STATIC | ACC_PRIVATE | ACC_SYNTHETIC | ACC_NATIVE | ACC_BRIDGE)) == 0) {

				if ((access & ACC_FINAL) != 0) throw new RuntimeException("new FinalModifierException(superToCopy, name)");

				mv = super.visitMethod(ACC_PUBLIC, name, desc, signature, exceptions);
				mv.visitCode();
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETFIELD, this.name, "actualValue", "Ljava/lang/Object;");
				mv.visitTypeInsn(CHECKCAST, this.targetTypeName);

				Method currentTransformMethod = new Method(name, desc);
				delegateCall(mv, currentTransformMethod, this.targetTypeName);

				mv.visitMaxs(2, 2);
				mv.visitEnd();
				dones.put(key, mv);
			}
		}
		return mv;
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

		mv.visitMethodInsn(INVOKEINTERFACE, typeName, currentTransformMethod.getName(), currentTransformMethod.getDescriptor(), true);

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
	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
		// return super.visitField(access, name, desc, signature, value);
		return null;
	}

	@Override
	public void visitOuterClass(String owner, String name, String desc) {
	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return super.visitAnnotation(desc, visible);
	}

	@Override
	public void visitAttribute(Attribute attr) {
	}

	@Override
	public void visitInnerClass(String name, String outerName, String innerName, int access) {
	}

	@Override
	public void visitEnd() {
	}
}
