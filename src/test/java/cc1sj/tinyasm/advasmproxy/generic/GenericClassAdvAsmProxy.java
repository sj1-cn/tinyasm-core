package cc1sj.tinyasm.advasmproxy.generic;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.advasmproxy.simple.PojoClassChild;
import cc1sj.tinyasm.advasmproxy.simple.PojoClass;

public class GenericClassAdvAsmProxy extends GenericClass<PojoClass> implements AdvRuntimeReferNameObject {
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
		return Clazz.of(GenericClass.class);
	}

//	code.LINE();
//	code.LOAD("pp");
//	code.VIRTUAL(GenericClass.class, "getT")
//		.return_(Object.class).INVOKE();
//	code.CHECKCAST(PojoClass.class);
//	code.STORE("pojoClassSample2",PojoClass.class);
//	
	@Override
	public PojoClass getT() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClass.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(GenericClass.class, "getT").return_(Object.class).INVOKE();
			c.CHECKCAST(PojoClass.class);
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(PojoClass.class)) {
			return Adv.buildProxyClass(PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

//	code.LINE();
//	code.LOAD("pp");
//	code.LOAD("pojoClassSample");
//	code.VIRTUAL(GenericClass.class, "setT")
//		.parameter(Object.class).INVOKE();
	@Override
	public void setT(PojoClass param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.VIRTUAL(GenericClass.class, "setT").parameter(Object.class).INVOKE();
		});
	}
	
	@Override
	public PojoClassChild getPojoClassChildSample() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClassChild.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(GenericClass.class, "getPojoClassChildSample").return_(PojoClassChild.class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(PojoClassChild.class)) {
			return Adv.buildProxyClass(PojoClassChild.class, magicNumber);
		} else {
			return null;
		}
	}


	@Override
	public void setPojoClassChildSample(PojoClassChild param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(GenericClass.class, "setPojoClassChildSample").parameter(PojoClassChild.class).INVOKE();
		});

	}

}
