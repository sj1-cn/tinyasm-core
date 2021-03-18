package cn.sj1.tinyasm.advasmproxy.simple;

import static cn.sj1.tinyasm.Adv.MAGIC_CODES_NUMBER;

import cn.sj1.tinyasm.Adv;
import cn.sj1.tinyasm.AdvContext;
import cn.sj1.tinyasm.AdvRuntimeReferNameObject;
import cn.sj1.tinyasm.Clazz;
import cn.sj1.tinyasm.ConsumerWithException;
import cn.sj1.tinyasm.MethodCode;

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
	public SimplePojoClass getSimplePojoClassSample() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(SimplePojoClass.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(ReferSimplePojoClassOnlySample.class, "getSimplePojoClassSample").return_(SimplePojoClass.class).INVOKE();
		});
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
		
		if (Adv.canProxy(SimplePojoClass.class)) {
			return Adv.buildProxyClass(SimplePojoClass.class, magicNumber);
		} else {
			return null;
		}

	}

}
