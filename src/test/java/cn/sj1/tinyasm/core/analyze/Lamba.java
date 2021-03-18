package cn.sj1.tinyasm.core.analyze;

public class Lamba {
//	public static ClassBody invokeConsumer(String objectType, String parentType, String consumeType, String fieldName,
//			String fieldType, Consumer<MethodCodeInstance> invocation) {
//		ClassBody cw = ClassBuilder
//			.make(ACC_SUPER, objectType, Object.class.getName(), Consumer.class.getName(), new String[] { consumeType })
//			.body();
//
//		// TODO
//		// cw.visitor()
////			.visitInnerClass(objectType.getInternalName(), parentType.getInternalName(),
////					objectType.getClassName().substring(parentType.getSize()), 0);
//
//		cw.field(fieldName, fieldType);
//
//		cw.field(ACC_FINAL + ACC_SYNTHETIC, "this$0", parentType, false);
//
//		cw.publicMethod("<init>").parameter("handle", parentType).parameter(fieldName, fieldType).code(mc -> {
//			mc.PUTFIELD("this", "this$0", "this$0", typeOf(objectType));
//			mc.LINE(15).INITObject();
//			mc.PUTFIELD("this", "fieldName", "fieldName", fieldType);
//			mc.RETURN();
//		});
//		cw.publicMethod("accept").parameter("domain", consumeType).code(invocation);
//		Class<?>[] exceptionClasses = {};
//		cw.mvMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, Type.VOID_TYPE, "accept", namesOf(exceptionClasses))
//			.parameter("consumer", Object.class)
//			.code(mc -> {
//				mc.LOAD("this");
//				mc.LOAD("consumer");
//				mc.CHECKCAST( typeOf(consumeType));
//				mc.LOADThis();
//				mc.INVOKEVIRTUAL(typeOf(objectType), typeOf(consumeType), "call");
//				mc.RETURN();
//			});
//
//		return cw;
//	}
//
//	public static ClassBody invokeCallable(Type objectType, Type parentType, Type consumeType, String fieldName,
//			Type fieldType, Consumer<MethodCodeInstance> invocation) {
//		ClassBody cb = ClassBuilder
//			.make(ACC_SUPER, typeOf(objectType), typeOf(Object.class), typeOf(Callable.class), new Type[] { consumeType })
//			.body();
//		// TODO
////		cb.visitor()
////			.visitInnerClass(objectType.getInternalName(), parentType.getInternalName(),
////					objectType.getClassName().substring(parentType.getSize()), 0);
//
//		cb.mvField(ACC_PRIVATE, fieldName, fieldType, false);
//
//		cb.mvField(ACC_FINAL + ACC_SYNTHETIC, "this$0", parentType, false);
//
//		cb.publicMethod("<init>").parameter("handle", parentType).parameter(fieldName, fieldType).code(mc -> {
//			mc.PUTFIELD("this", "this$0", "this$0", objectType);
//			mc.LINE(15).INITObject();
//			mc.PUTFIELD("this", "fieldName", "fieldName", fieldType);
//			mc.RETURN();
//		});
//		Class<?>[] exceptionClasses = { Exception.class };
//
//		cb.mvMethod(ACC_PUBLIC, consumeType, "call", namesOf(exceptionClasses)).code(invocation);
//		cb.method(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, Object.class, "call", Exception.class).code(mc -> {
//			mc.INVOKEVIRTUAL(objectType, consumeType, "call");
//			mc.RETURNTop();
//		});
//
//		return cb;
//	}
}
