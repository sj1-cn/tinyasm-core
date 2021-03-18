package cc1sj.tinyasm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class AdvMagic {

	public static <T> T buildMagicProxyInstance(Class<T> builderClass) {

		T t = Adv.brokerBuilder.buildMagicProxyClass(Adv._contextThreadLocal, builderClass, Adv.MAGIC_LOCALS_NUMBER);
		return t;
	}

	public static <T> T buildMagicProxyInstance(Class<T> builderClass, Class<?>... typeArgument) {
		T t = Adv.brokerBuilder.buildMagicProxyClass(Adv._contextThreadLocal, builderClass, Adv.MAGIC_LOCALS_NUMBER, typeArgument);
		return t;
	}

	public static <T> byte[] dump(String targetClassName, Class<T> builderClass) {
		T magicBuilderProxy = buildMagicProxyInstance(builderClass);
		((AdvMagicRuntime) magicBuilderProxy).set__TargetClazz(Clazz.of(targetClassName));

		AdvClassBuilder classBuilder = Adv.public_class_(targetClassName).extends_(Clazz.of(builderClass.getGenericSuperclass())).implements_(Adv.of(c -> Clazz.of(c), builderClass.getGenericInterfaces())).enterClassBody();

		return AdvMagicBuilderEngine.execMagicBuilder(Adv._contextThreadLocal, classBuilder, magicBuilderProxy);
	}

	public static <T> byte[] dump(String targetClassName, Class<T> builderClass, Class<?>... typeArgument) {
		T magicBuilderProxy = buildMagicProxyInstance(builderClass, typeArgument);

		return dumpTargetFromMagicBuilderInstance(targetClassName, builderClass, magicBuilderProxy, typeArgument);
	}

	public static <T> byte[] dumpTargetFromMagicBuilderInstance(String targetClassName, T magicBuilderProxy) {
		((AdvMagicRuntime) magicBuilderProxy).set__TargetClazz(Clazz.of(targetClassName));

		Class<?> builderClass = magicBuilderProxy.getClass().getSuperclass();

		AdvClassBuilder classBuilder = Adv.public_class_(targetClassName).extends_(Clazz.of(builderClass.getGenericSuperclass())).implements_(Adv.of(c -> Clazz.of(c), builderClass.getGenericInterfaces())).enterClassBody();

		return AdvMagicBuilderEngine.execMagicBuilder(Adv._contextThreadLocal, classBuilder, magicBuilderProxy);
	}

	public static <T> byte[] dumpTargetFromMagicBuilderInstance(String targetClassName, Class<T> builderClass, T magicBuilderProxy, Class<?>... typeArguments) {
		((AdvMagicRuntime) magicBuilderProxy).set__TargetClazz(Clazz.of(targetClassName));

		Map<String, Class<?>> para = new HashMap<>();
		TypeVariable<Class<T>>[] ta = builderClass.getTypeParameters();
		for (int i = 0; i < ta.length; i++) {
			TypeVariable<Class<T>> typeVariable = ta[i];
			para.put(typeVariable.getName(), typeArguments[i]);
		}

		Clazz superClazz = null;
		Type superType = builderClass.getGenericSuperclass();
		if (superType instanceof ParameterizedType) {
			Type[] superTypeArguments = ((ParameterizedType) superType).getActualTypeArguments();
			Clazz[] superTypeArgumentClazzes = new Clazz[superTypeArguments.length];

			for (int j = 0; j < superTypeArguments.length; j++) {
				Type superTypeArgument = superTypeArguments[j];
				if (superTypeArgument instanceof Class) {
					superTypeArgumentClazzes[j] = Clazz.of((Class<?>) superTypeArgument);
				} else if (superTypeArgument instanceof TypeVariable) {
					String variableName = ((TypeVariable<?>) superTypeArgument).getName();
					Class<?> clazz = para.get(variableName);
					superTypeArgumentClazzes[j] = Clazz.of(clazz);
				}

			}
			superClazz = Clazz.of((Class<?>) ((ParameterizedType) superType).getRawType(), superTypeArgumentClazzes);
		} else {
			superClazz = Clazz.of(builderClass.getSuperclass());
		}

		Type[] interfaceTypes = builderClass.getGenericInterfaces();
		Clazz[] interfaceClazzes = new Clazz[interfaceTypes.length];

		for (int i = 0; i < interfaceTypes.length; i++) {
			Type interfaceType = interfaceTypes[i];
			if (interfaceType instanceof ParameterizedType) {
				Type[] interfaceTypeArguments = ((ParameterizedType) interfaceType).getActualTypeArguments();
				Clazz[] interfaceTypeArgumentClazzes = new Clazz[interfaceTypeArguments.length];

				for (int j = 0; j < interfaceTypeArguments.length; j++) {
					Type interfaceTypeArgument = interfaceTypeArguments[j];
					if (interfaceTypeArgument instanceof Class) {
						interfaceTypeArgumentClazzes[j] = Clazz.of((Class<?>) interfaceTypeArgument);
					} else if (interfaceTypeArgument instanceof TypeVariable) {
						String variableName = ((TypeVariable<?>) interfaceTypeArgument).getName();
						Class<?> clazz = para.get(variableName);
						interfaceTypeArgumentClazzes[j] = Clazz.of(clazz);
					}

				}
				interfaceClazzes[i] = Clazz.of((Class<?>) ((ParameterizedType) interfaceType).getRawType(), interfaceTypeArgumentClazzes);
			} else {
				interfaceClazzes[i] = Clazz.of((Class<?>) interfaceType);
			}
		}

		AdvClassBuilder classBuilder = Adv.public_class_(targetClassName).extends_(superClazz).implements_(interfaceClazzes).enterClassBody();

		return AdvMagicBuilderEngine.execMagicBuilder(Adv._contextThreadLocal, classBuilder, magicBuilderProxy, typeArguments);
//		return new byte[0];
	}

	static public <T> Clazz clazzOf(T t) {
		return ((AdvRuntimeReferNameObject)t).get__TargetClazz();
	}

}
