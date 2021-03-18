package cn.sj1.tinyasm.core;

public interface AdvMagicRuntimeWithTypeArgument extends AdvRuntimeReferNameObject {
	void set__TargetClazz(Clazz _targetClazz);

	void set__TypeArgument(Class<?>[] arguments);
}
