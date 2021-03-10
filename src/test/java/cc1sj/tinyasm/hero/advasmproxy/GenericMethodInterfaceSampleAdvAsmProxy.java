package cc1sj.tinyasm.hero.advasmproxy;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

import java.lang.reflect.Array;

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.helperclass.GenericMethodInterface;
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;

public class GenericMethodInterfaceSampleAdvAsmProxy implements GenericMethodInterface<PojoClassSample>, AdvRuntimeReferNameObject {
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

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] param0) {
		Class<?> elementClass = param0.getClass().getComponentType();

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Object[].class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(GenericMethodInterface.class, "toArray").parameter(Object[].class).reTurn(Object[].class).INVOKE();
			c.CHECKCAST(Clazz.of(elementClass, true));
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
		T simplePojoClassSample = null;
		T[] tarray = (T[]) Array.newInstance(elementClass, 1);

		if (Adv.canProxy(elementClass)) {
			simplePojoClassSample = Adv.buildProxyClass((Class<T>) elementClass, magicNumber);
			tarray[0] = simplePojoClassSample;
			return tarray; // int.class);
		} else {
			return null;
		}
	}

}
