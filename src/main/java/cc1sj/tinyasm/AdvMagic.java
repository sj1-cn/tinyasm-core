package cc1sj.tinyasm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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

	@SuppressWarnings("unchecked")
	public static <T> T build(String targetClassName, Class<?> magicBuilderClass, Class<?> typeArgument) {
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

		AdvClassBuilder classBuilder = Adv.public_class_(targetClassName).extends_(superClazz).implements_(interfaceClazzes).enterClassBody();

		Object t = Adv.brokerBuilder.buildMagicProxyClass(targetClassName, magicBuilderClass, Adv._contextThreadLocal, Adv.MAGIC_LOCALS_NUMBER);
		AdvMagicRuntime magicRuntime = (AdvMagicRuntime) t;
		magicRuntime.set__ClassBuilder(classBuilder);
		return (T)t;
	}

	public static <T> byte[] dump(T magicBuilderProxy, Class<?> typeArgument) {
		AdvClassBuilder classBuilder = ((AdvMagicRuntime) magicBuilderProxy).get__ClassBuilder();
		return AdvMagicBuilderEngine.execMagicBuilder(Adv._contextThreadLocal, classBuilder, magicBuilderProxy);
	}

}
