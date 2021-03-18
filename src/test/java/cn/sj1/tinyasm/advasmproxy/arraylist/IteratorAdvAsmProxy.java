package cn.sj1.tinyasm.advasmproxy.arraylist;

import static cn.sj1.tinyasm.Adv.MAGIC_CODES_NUMBER;

import java.util.Iterator;
import java.util.function.Consumer;

import cn.sj1.tinyasm.Adv;
import cn.sj1.tinyasm.AdvContext;
import cn.sj1.tinyasm.AdvRuntimeReferNameObject;
import cn.sj1.tinyasm.Clazz;
import cn.sj1.tinyasm.ConsumerWithException;
import cn.sj1.tinyasm.MethodCode;
import cn.sj1.tinyasm.advasmproxy.simple.PojoClass;

public class IteratorAdvAsmProxy implements Iterator<PojoClass>, AdvRuntimeReferNameObject {
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
		return Clazz.of(Iterator.class);
	}

	@Override
	public boolean hasNext() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(boolean.class, c -> {
			objEval.accept(c);
			c.INTERFACE(Iterator.class, "hasNext").return_(boolean.class).INVOKE();
		});
		return false;
	}

	@Override
	public PojoClass next() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClass.class, c -> {
			objEval.accept(c);
			c.INTERFACE(Iterator.class, "next").return_(Object.class).INVOKE();
			c.CHECKCAST(PojoClass.class);
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(PojoClass.class)) {
			return Adv.buildProxyClass(PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public void remove() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			c.INTERFACE(Iterator.class, "remove").INVOKE();
		});
	}

	@Override
	public void forEachRemaining(Consumer<? super PojoClass> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(Iterator.class, "forEachRemaining").parameter(Consumer.class).INVOKE();
		});

	}
}
