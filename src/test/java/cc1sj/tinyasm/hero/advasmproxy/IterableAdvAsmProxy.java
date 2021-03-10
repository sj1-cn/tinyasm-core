package cc1sj.tinyasm.hero.advasmproxy;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

import java.util.Iterator;

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.helperclass.GenericInterface;
import cc1sj.tinyasm.hero.helperclass.PojoClassChildSample;
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;

public class IterableAdvAsmProxy implements Iterable<PojoClassSample>, AdvRuntimeReferNameObject {
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
	public Iterator<PojoClassSample> iterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Iterator.class, c -> {
			objEval.accept(c);
			c.INTERFACE(Iterable.class, "iterator").reTurn(Object.class).INVOKE();
			c.CHECKCAST(Iterator.class);
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(Iterator.class)) {
			return Adv.buildProxyClass(Iterator.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

//
//	@Override
//	public PojoClassSample getT() {
//		AdvContext context = _contextThreadLocal.get();
//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
//		byte codeIndex = context.push(PojoClassSample.class, c -> {
//			objEval.accept(c);
//			c.INTERFACE(GenericInterface.class, "getT").reTurn(Object.class).INVOKE();
//			c.CHECKCAST(PojoClassSample.class);
//		});
//
//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
//
//		if (Adv.canProxy(PojoClassSample.class)) {
//			return Adv.buildProxyClass(PojoClassSample.class, magicNumber);
//		} else {
//			return null;
//		}
//	}
//
//	@Override
//	public PojoClassChildSample getPojoClassChildSample() {
//		AdvContext context = _contextThreadLocal.get();
//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
//		byte codeIndex = context.push(PojoClassChildSample.class, c -> {
//			objEval.accept(c);
//			c.INTERFACE(GenericInterface.class, "getPojoClassChildSample").reTurn(PojoClassChildSample.class).INVOKE();
//		});
//
//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
//
//		if (Adv.canProxy(PojoClassChildSample.class)) {
//			return Adv.buildProxyClass(PojoClassChildSample.class, magicNumber);
//		} else {
//			return null;
//		}
//	}
//
//	@Override
//	public void setT(PojoClassSample param0) {
//		AdvContext context = _contextThreadLocal.get();
//		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
//		context.execLine(c -> {
//			objEval.accept(c);
//			eval_param0.accept(c);
//
//			c.INTERFACE(GenericInterface.class, "setT").parameter(Object.class).INVOKE();
//		});
//	}
//
//	@Override
//	public void setPojoClassChildSample(PojoClassChildSample param0) {
//		AdvContext context = _contextThreadLocal.get();
//		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
//		context.execLine(c -> {
//			objEval.accept(c);
//			eval_param0.accept(c);
//			c.INTERFACE(GenericInterface.class, "setPojoClassChildSample").parameter(PojoClassChildSample.class).INVOKE();
//		});
//
//	}

}
