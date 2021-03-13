package cc1sj.tinyasm;

public interface AdvRuntimeReferNameObject {

	byte get__MagicNumber();

	void set__Context(ThreadLocal<AdvContext> _contextThreadLocal, byte name);

	void set__MagicNumber(byte magicNumber);

	Clazz get__TargetClazz();

}
