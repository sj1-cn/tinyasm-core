package cc1sj.tinyasm.advmagicbuilder;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvMagicRuntime;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;

public class RepositoryMagicBuilderAdvAsmProxy<T extends WithIdKey> extends RepositoryMagicBuilder<T> implements AdvMagicRuntime {
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

	@SuppressWarnings("unchecked")
	@Override
	public T update(T param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(param0.getClass(), c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(this._targetClazz, "update").parameter(param0.getClass()).return_(param0.getClass()).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(param0.getClass())) {
			return (T) Adv.buildProxyClass(param0.getClass(), magicNumber);
		} else {
			return null;
		}
	}

}
