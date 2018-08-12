package nebula.tinyasm.analyze;

import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ASM5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.Field;


class AnalyzeMethodParamsClassVisitor extends ClassVisitor {
	public AnalyzeMethodParamsClassVisitor(int api, ClassVisitor cv) {
		super(api, cv);
	}

	public AnalyzeMethodParamsClassVisitor() {
		super(Opcodes.ASM5);
	}

	public AnalyzeMethodParamsClassVisitor(ClassVisitor cv) {
		super(Opcodes.ASM5, cv);
	}

	Map<String, MethodInfo> methods = new HashMap<>();

	public Map<String, MethodInfo> getMethods() {
		return methods;
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		super.visit(version, access, name, signature, superName, interfaces);
	}

	class FillParamsMethodVisitor extends MethodVisitor {
		MethodInfo method;
		boolean staticMethod = false;

		public FillParamsMethodVisitor(int access, MethodVisitor mv, String name, String desc) {
			super(ASM5, mv);
			this.method = new MethodInfo(name);
			AnalyzeMethodParamsClassVisitor.this.methods.put(name, method);

			if (is(access, ACC_STATIC)) {
				staticMethod = true;
			}

			Type[] types = Type.getArgumentTypes(desc);
			this.method.params = new Field[types.length];
			this.method.locals = new ArrayList<>();
			for (int i = 0; i < types.length; i++) {
				this.method.params[i] = new Field("", types[i]);
			}
		}

		@Override
		public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
			if (!staticMethod) {
				if (0 < index && index <= this.method.params.length) {
					this.method.params[index - 1].name = name;
				}
			} else {
				if (0 <= index && index < this.method.params.length) {
					this.method.params[index].name = name;
				}
			}
			this.method.locals.add(new Variable(name, Type.getType(desc), signature));
			super.visitLocalVariable(name, desc, signature, start, end, index);
		}
	}

	static boolean is(int access, int modified) {
		return (access & modified) > 0;
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
		return new FillParamsMethodVisitor(access, methodVisitor, name, desc);
	}

	static String toBeanProperties(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

}
