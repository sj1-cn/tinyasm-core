package cc1sj.tinyasm.advmagicbuilder.sourceconverter;

import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvMagicRuntime;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;

public class UsingSimplePojoClassSampleMagicBuilderAdvAsmProxy extends UsingSimplePojoClassSampleMagicBuilder implements AdvMagicRuntime {
	private byte _magicNumber;
	private ThreadLocal<AdvContext> _contextThreadLocal;
	private Clazz _targetClazz;

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
	public void set__TargetClazz(Clazz _targetClazz) {
		this._targetClazz = _targetClazz;
	}

	@Override
	public Clazz get__TargetClazz() {
		return _targetClazz;
	}
	
	@Override
	public void sayHello() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			c.VIRTUAL(this._targetClazz, "sayHello").INVOKE();
		});
	}

	public void $_sayHello() {
		super.sayHello();
	}
}
