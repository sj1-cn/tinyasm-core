package cn.sj1.tinyasm;

public interface AdvRuntimeReferNameObject {

	byte get__MagicNumber();

	void set__Context(ThreadLocal<AdvContext> _contextThreadLocal, byte name);

	void set__MagicNumber(byte magicNumber);

	Clazz get__TargetClazz();

}
