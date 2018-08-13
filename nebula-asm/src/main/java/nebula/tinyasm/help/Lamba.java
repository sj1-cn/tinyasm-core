package nebula.tinyasm.help;

import static nebula.tinyasm.util.TypeUtils.namesOf;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

import org.objectweb.asm.Type;

import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.api.ClassBody;
import nebula.tinyasm.api.MethodCodeInstance;

public class Lamba {
	public static ClassBody invokeConsumer(Type objectType, Type parentType, Type consumeType, String fieldName,
			Type fieldType, Consumer<MethodCodeInstance> invocation) {
		ClassBody cw = ClassBuilder.make(ACC_SUPER, objectType, Object.class, Consumer.class,
				new Type[] { consumeType }).body();

		//TODO
		//		cw.visitor()
//			.visitInnerClass(objectType.getInternalName(), parentType.getInternalName(),
//					objectType.getClassName().substring(parentType.getSize()), 0);

		cw.mvField(ACC_PRIVATE, fieldName, fieldType);

		cw.mvField(ACC_FINAL + ACC_SYNTHETIC, "this$0", parentType);

		cw.publicMethod("<init>").parameter("handle", parentType).parameter(fieldName, fieldType).code(mc -> {
			mc.PUTFIELD("this", "this$0", "this$0", objectType);
			mc.line(15).INITObject();
			mc.PUTFIELD("this", "fieldName", "fieldName", fieldType);
			mc.RETURN();
		});
		cw.publicMethod("accept").parameter("domain", consumeType).code(invocation);
		Class<?>[] exceptionClasses = {};
		cw.mvMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, Type.VOID_TYPE, "accept", namesOf(exceptionClasses))
			.parameter("consumer", Object.class)
			.code(mc -> {
				mc.LOAD("this");
				mc.LOAD("consumer");
				mc.CHECKCAST(consumeType);
				mc.LOADThis();
				mc.INVOKEVIRTUAL(objectType, consumeType, "call");
				mc.RETURN();
			});

		return cw;
	}

	public static ClassBody invokeCallable(Type objectType, Type parentType, Type consumeType, String fieldName,
			Type fieldType, Consumer<MethodCodeInstance> invocation) {
		ClassBody cb = ClassBuilder.make(ACC_SUPER, objectType, Object.class, Callable.class,
				new Type[] { consumeType }).body();
		//TODO
//		cb.visitor()
//			.visitInnerClass(objectType.getInternalName(), parentType.getInternalName(),
//					objectType.getClassName().substring(parentType.getSize()), 0);

		cb.mvField(ACC_PRIVATE, fieldName, fieldType);

		cb.mvField(ACC_FINAL + ACC_SYNTHETIC, "this$0", parentType);

		cb.publicMethod("<init>").parameter("handle", parentType).parameter(fieldName, fieldType).code(mc -> {
			mc.PUTFIELD("this", "this$0", "this$0", objectType);
			mc.line(15).INITObject();
			mc.PUTFIELD("this", "fieldName", "fieldName", fieldType);
			mc.RETURN();
		});
		Class<?>[] exceptionClasses = { Exception.class };

		cb.mvMethod(ACC_PUBLIC, consumeType, "call", namesOf(exceptionClasses)).code(invocation);
		cb.method(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, Object.class, "call", Exception.class).code(mc -> {
			mc.INVOKEVIRTUAL(objectType, consumeType, "call");
			mc.RETURNTop();
		});

		return cb;
	}
}
