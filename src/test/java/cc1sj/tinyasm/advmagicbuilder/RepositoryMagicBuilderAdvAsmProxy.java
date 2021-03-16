package cc1sj.tinyasm.advmagicbuilder;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvMagicRuntimeWithTypeArgument;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;

public class RepositoryMagicBuilderAdvAsmProxy<E extends WithIdKey, R> extends RepositoryMagicBuilder<E, R> implements AdvMagicRuntimeWithTypeArgument {
	private byte _magicNumber;
	private ThreadLocal<AdvContext> _contextThreadLocal;
	private Clazz _targetClazz;
	private Class<?>[] _arguments;

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
	public void set__TypeArgument(Class<?>[] _arguments) {
		this._arguments = _arguments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public R update(E param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(_arguments[1], c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(this._targetClazz, "update").parameter(_arguments[0]).return_(_arguments[1]).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		return (R)Adv.proxyReturn(_arguments[1], magicNumber);
	}

	public R $_update(E param0) {
		return super.update(param0);
	}
}
