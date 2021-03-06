package cc1sj.tinyasm.hero.helperclass;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.sourceconverter.ReferedObject;

public class AdvAsmProxyWithReferReferAdvAsmProxy extends AdvAsmProxyWithReferRefferSample implements AdvRuntimeReferNameObject {
	private byte _magicNumber;
	private ThreadLocal<AdvContext> _contextThreadLocal;

	@Override
	public byte get__MagicNumber() {
		return this._magicNumber;
	}

	@Override
	public void set__MagicNumber(byte _magicNumber) {
		this._magicNumber = _magicNumber;
	}

	@Override
	public void set__Context(ThreadLocal<AdvContext> _contextThreadLocal, byte _magicNumber) {
		this._contextThreadLocal = _contextThreadLocal;
		this._magicNumber = _magicNumber;
	}

	@Override
	public ReferedObject getRefer() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(ReferedObject.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyWithReferRefferSample.class, "getRefer").reTurn(ReferedObject.class).INVOKE();
		});
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
		
		if (Adv.canProxy(ReferedObject.class)) {
			return Adv.buildProxyClass(ReferedObject.class, magicNumber);
		} else {
			return null;
		}

	}

}
