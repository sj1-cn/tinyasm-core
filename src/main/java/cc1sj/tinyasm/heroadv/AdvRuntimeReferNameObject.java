package cc1sj.tinyasm.heroadv;

public interface AdvRuntimeReferNameObject {

	byte get__MagicNumber();

	void __init(ThreadLocal<AdvContext> _context, byte name);

	void set__MagicNumber(byte magicNumber);

}
