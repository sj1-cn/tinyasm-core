package cc1sj.tinyasm;

import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class AdvAsmProxyMagicClassAdvAsmBuilder extends AdvAsmProxyClassAdvAsmBuilder {

	public static byte[] dumpMagic(Class<?> target, String proxyClassName) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		AdvAsmProxyMagicClassAdvAsmBuilder bw = new AdvAsmProxyMagicClassAdvAsmBuilder(Opcodes.ASM9, cw);

		bw.dumpMagic(Clazz.of(target), new Clazz[] {}, proxyClassName);

		return cw.toByteArray();
	}

	public AdvAsmProxyMagicClassAdvAsmBuilder(int api) {
		super(api);
	}

	public AdvAsmProxyMagicClassAdvAsmBuilder(int api, ClassVisitor classVisitor) {
		super(api, classVisitor);
	}

	protected void dumpMagic(ClazzSimple targetClazz, Clazz[] actualTypeArguments, String proxyClassName) throws IOException {
		this.proxyClassName = proxyClassName;
		this.targetClazz = targetClazz;
		INTERFACE_OR_VIRTUAL = VIRTUAL;

		ClassHeader ch = ClassBuilder.make(cv, proxyClassName);
//		if(superName)
		if (actualTypeArguments.length > 0) {
			ch.eXtend(Clazz.of(targetClazz, actualTypeArguments));
		} else {
			ch.eXtend(targetClazz);
		}
		ch.implement(AdvRuntimeReferNameObject.class);
//		ch.access(access);
		proxyClassBody = ch.body();

		proxyClassBody.referInnerClass(ACC_PUBLIC | ACC_FINAL | ACC_STATIC, MethodHandles.class.getName(), "Lookup");

		proxyClassBody.field("_magicNumber", Clazz.of(byte.class));
		proxyClassBody.field("_contextThreadLocal", Clazz.of(ThreadLocal.class, Clazz.of(AdvContext.class)));

		__init_TargetClass(proxyClassBody, targetClazz);
		_get__MagicNumber(proxyClassBody);
		_set__MagicNumber(proxyClassBody);
		_set__Context(proxyClassBody);

		resolveClass(targetClazz, actualTypeArguments);

		resolveMagicClass(targetClazz, actualTypeArguments);

		finish();
	}

	protected void resolveMagicClass(Clazz target, Clazz[] actualTypeArguments) {
		Current last = this.current;
		this.current = new Current();
//		current.targetClazz = target;
		current.actualTypeArguments = actualTypeArguments;

		try {
			ClassReader cr = new ClassReader(target.getType().getClassName());
			cr.accept(new ClassVisitor(Opcodes.ASM9) {

				@Override
				public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
					if (name.startsWith("_") || name.startsWith("<")) return null;
					extracted(access, name, descriptor, exceptions);
					return null;
				}

			}, ClassReader.SKIP_CODE);
		} catch (IOException e) {
			throw new UnsupportedOperationException(e);
		}

		this.current = last;
	}

	@Override
	public MethodVisitor visitMethod(int access, String methodName, String descriptor, String signature, String[] exceptions) {
		if (methodName.startsWith("_") || methodName.startsWith("<") || methodName.startsWith("dump")) return null;

		return super.visitMethod(access, methodName, descriptor, signature, exceptions);
	}

	protected void extracted(int access, String methodName, String descriptor, String[] exceptions) {
		if (access == ACC_PUBLIC) {
			MethodHeader mh = proxyClassBody.method(access, "$_" + methodName);

			Type returnType = Type.getReturnType(descriptor);
			Type[] params = Type.getArgumentTypes(descriptor);

			mh.reTurn(Clazz.of(returnType));

			for (int i = 0; i < params.length; i++) {
				mh.parameter("param" + i, Clazz.of(params[i]));
			}
			if (exceptions != null && exceptions.length > 0) {
				mh.tHrow(exceptions);
			}
//			if(ex)

			MethodCode code = mh.begin();
			code.LINE();
			code.LOAD("this");
			Clazz[] clazzes = new Clazz[params.length];
			for (int i = 0; i < params.length; i++) {
				code.LOAD("param" + i);
				clazzes[i] = Clazz.of(params[i]);
//				if(params[i].getSort() == Type.LONG) {
//					code.CHECKCAST(long.class);
//				}
			}
			if (returnType != Type.VOID_TYPE) {
				code.SPECIAL(targetClazz, methodName).parameter(clazzes).reTurn(Clazz.of(returnType)).INVOKE();
				code.RETURNTop();
			} else {
				code.SPECIAL(targetClazz, methodName).parameter(clazzes).INVOKE();
				code.LINE();
				code.RETURN();
			}
			code.END();
		}
	}

}
