package cc1sj.tinyasm;

public class AdvMagic {

	public static <T> T build(String targetClassName, Class<T> builderClass) {
		AdvClassBuilder classBuilder = Adv.public_class_(targetClassName).extends_(Clazz.of(builderClass.getGenericSuperclass())).implements_(Adv.of(c -> Clazz.of(c), builderClass.getGenericInterfaces())).enterClassBody();

		T t = Adv.brokerBuilder.buildMagicProxyClass(targetClassName, builderClass, Adv._contextThreadLocal, Adv.MAGIC_LOCALS_NUMBER);
		AdvMagicRuntime magicRuntime = (AdvMagicRuntime) t;
		magicRuntime.set__ClassBuilder(classBuilder);
		return t;
	}

	public static <T> byte[] dump(T magicBuilderProxy) {
		AdvClassBuilder classBuilder = ((AdvMagicRuntime) magicBuilderProxy).get__ClassBuilder();
		return AdvMagicBuilderEngine.execMagicBuilder(Adv._contextThreadLocal, classBuilder, magicBuilderProxy);
	}

}
