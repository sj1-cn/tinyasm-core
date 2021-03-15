package cc1sj.tinyasm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class AdvMagic {

	public static <T> T build(String targetClassName, Class<T> builderClass) {

		T t = Adv.brokerBuilder.buildMagicProxyClass(targetClassName, builderClass, Adv._contextThreadLocal, Adv.MAGIC_LOCALS_NUMBER);
		AdvMagicRuntime magicRuntime = (AdvMagicRuntime) t;
		magicRuntime.set__TargetClazz(Clazz.of(targetClassName));
		return t;
	}

	public static <T> byte[] dump(T magicBuilderProxy) {
		Clazz targetClazz = ((AdvMagicRuntime) magicBuilderProxy).get__TargetClazz();

		Class<?> builderClass = magicBuilderProxy.getClass().getSuperclass();

		AdvClassBuilder classBuilder = Adv.public_class_(targetClazz.getType().getClassName()).extends_(Clazz.of(builderClass.getGenericSuperclass())).implements_(Adv.of(c -> Clazz.of(c), builderClass.getGenericInterfaces()))
				.enterClassBody();

		return AdvMagicBuilderEngine.execMagicBuilder(Adv._contextThreadLocal, classBuilder, magicBuilderProxy);
	}

	public static <T> byte[] dump(T magicBuilderProxy, Class<?> typeArgument) {
		Clazz targetClazz = ((AdvMagicRuntime) magicBuilderProxy).get__TargetClazz();
		Class<?> magicBuilderClass = magicBuilderProxy.getClass().getSuperclass();
		Clazz superClazz = null;
		Type superType = magicBuilderClass.getGenericSuperclass();
		if (superType instanceof ParameterizedType) {
			superClazz = Clazz.of(magicBuilderClass.getSuperclass(), typeArgument);
		} else {
			superClazz = Clazz.of(magicBuilderClass.getSuperclass());
		}
		Type[] interfaceTypes = magicBuilderClass.getGenericInterfaces();
		Clazz[] interfaceClazzes = new Clazz[interfaceTypes.length];

		for (int i = 0; i < interfaceTypes.length; i++) {
			Type type = interfaceTypes[i];
			if (type instanceof ParameterizedType) {
				interfaceClazzes[i] = Clazz.of((Class<?>) ((ParameterizedType) type).getRawType(), typeArgument);
			} else {
				interfaceClazzes[i] = Clazz.of((Class<?>) type);
			}
		}

		AdvClassBuilder classBuilder = Adv.public_class_(targetClazz.getType().getClassName()).extends_(superClazz).implements_(interfaceClazzes).enterClassBody();

		return AdvMagicBuilderEngine.execMagicBuilder(Adv._contextThreadLocal, classBuilder, magicBuilderProxy);
	}

}
