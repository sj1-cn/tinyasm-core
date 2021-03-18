package cn.sj1.tinyasm.core.advasmproxy.simple;

import static cn.sj1.tinyasm.core.Adv.MAGIC_CODES_NUMBER;

import cn.sj1.tinyasm.core.Adv;
import cn.sj1.tinyasm.core.AdvContext;
import cn.sj1.tinyasm.core.AdvRuntimeReferNameObject;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.ConsumerWithException;
import cn.sj1.tinyasm.core.MethodCode;

public class ReferSimplePojoClassSampleAdvAsmProxy2 extends ReferSimplePojoClass implements AdvRuntimeReferNameObject {
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
		return Clazz.of(ReferSimplePojoClass.class);
	}

	@Override
	public SimplePojoClass getSimplePojoClassSample() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(SimplePojoClass.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(ReferSimplePojoClass.class, "getSimplePojoClassSample").return_(SimplePojoClass.class).INVOKE();
		});
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(SimplePojoClass.class)) {
			return Adv.buildProxyClass(SimplePojoClass.class, magicNumber);
		} else {
			return null;
		}

	}

}
