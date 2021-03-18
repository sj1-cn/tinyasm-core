package cn.sj1.tinyasm.core.advasmproxy.simple;

import cn.sj1.tinyasm.core.AdvContext;
import cn.sj1.tinyasm.core.AdvMagicRuntime;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.ConsumerWithException;
import cn.sj1.tinyasm.core.MethodCode;

public class SimplePojoClassSampleUsingSampleMagicBuilderAdvAsmProxy extends SimplePojoClassUsingSampleMagicBuilder implements AdvMagicRuntime {
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
