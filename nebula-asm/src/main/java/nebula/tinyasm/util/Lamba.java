package nebula.tinyasm.util;

import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

import org.objectweb.asm.Type;

import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.api.ClassBody;
import nebula.tinyasm.api.InstanceMethodCode;

public class Lamba {
	public static ClassBody invokeConsumer(Type objectType, Type parentType, Type consumeType, String fieldName,
			Type fieldType, Consumer<InstanceMethodCode> invocation) {
		ClassBody cw = ClassBuilder.make(ACC_SUPER, objectType, Object.class, Consumer.class,
				new Type[] { consumeType });
		cw.visitor()
			.visitInnerClass(objectType.getInternalName(), parentType.getInternalName(),
					objectType.getClassName().substring(parentType.getSize()), 0);

		cw.field(fieldName, fieldType);

		cw.field(ACC_FINAL + ACC_SYNTHETIC, "this$0", parentType);

		cw.publicMethod("<init>").parameter("handle", parentType).parameter(fieldName, fieldType).code(mc -> {
			mc.deperatedLoadThis().put("this$0", "this$0");
			mc.line(15).init();
			mc.deperatedLoadThis().put(fieldName, fieldName);
			mc.RETURN();
		});
		cw.publicMethod("accept").parameter("domain", consumeType).code(invocation);
		cw.method(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, Type.VOID_TYPE, "accept")
			.parameter("consumer", Object.class)
			.code(mc -> {
				mc.LOAD("this");
				mc.LOAD("consumer");
				mc.checkCast(consumeType);
				mc.useTopThis().invokeVirtual("accept", consumeType);
				mc.RETURN();
			});

		return cw;
	}

	public static ClassBody invokeCallable(Type objectType, Type parentType, Type consumeType, String fieldName,
			Type fieldType, Consumer<InstanceMethodCode> invocation) {
		ClassBody cb = ClassBuilder.make(ACC_SUPER, objectType, Object.class, Callable.class,
				new Type[] { consumeType });
		cb.visitor()
			.visitInnerClass(objectType.getInternalName(), parentType.getInternalName(),
					objectType.getClassName().substring(parentType.getSize()), 0);

		cb.field(fieldName, fieldType);

		cb.field(ACC_FINAL + ACC_SYNTHETIC, "this$0", parentType);

		cb.publicMethod("<init>").parameter("handle", parentType).parameter(fieldName, fieldType).code(mc -> {
			mc.deperatedLoadThis().put("this$0", "this$0");
			mc.line(15).init();
			mc.deperatedLoadThis().put(fieldName, fieldName);
			mc.RETURN();
		});

		cb.publicMethod(consumeType, "call", Exception.class).code(invocation);
		cb.method(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, Object.class, "call", Exception.class).code(mc -> {
			mc.useThis().invokeVirtual(consumeType, "call");
			mc.RETURNTop();
		});

		return cb;
	}
}
