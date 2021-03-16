package cc1sj.tinyasm.advasmproxy;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.helperclass.ReferSimplePojoClassOnlySample;
import cc1sj.tinyasm.hero.helperclass.SimplePojoClassSample;

public class ReferSimplePojoClassOnlySampleAdvAsmProxy extends ReferSimplePojoClassOnlySample implements AdvRuntimeReferNameObject {
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
	public Clazz get__TargetClazz() {
		return Clazz.of(ReferSimplePojoClassOnlySample.class);
	}

	@Override
	public SimplePojoClassSample getSimplePojoClassSample() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(SimplePojoClassSample.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(ReferSimplePojoClassOnlySample.class, "getSimplePojoClassSample").return_(SimplePojoClassSample.class).INVOKE();
		});
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
		
		if (Adv.canProxy(SimplePojoClassSample.class)) {
			return Adv.buildProxyClass(SimplePojoClassSample.class, magicNumber);
		} else {
			return null;
		}

	}

}
