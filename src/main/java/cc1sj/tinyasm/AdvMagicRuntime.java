package cc1sj.tinyasm;

public interface AdvMagicRuntime extends AdvRuntimeReferNameObject {
	void set__ClassBuilder(AdvClassBuilder _classBuilder);

	AdvClassBuilder get__ClassBuilder();

	void set__TargetClazz(Clazz targetClazz);
}
