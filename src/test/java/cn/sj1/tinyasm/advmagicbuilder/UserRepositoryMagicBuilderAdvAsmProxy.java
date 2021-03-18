package cn.sj1.tinyasm.advmagicbuilder;

import static cn.sj1.tinyasm.Adv.MAGIC_CODES_String;

import cn.sj1.tinyasm.AdvContext;
import cn.sj1.tinyasm.AdvMagicRuntime;
import cn.sj1.tinyasm.ClassBody;
import cn.sj1.tinyasm.Clazz;
import cn.sj1.tinyasm.ConsumerWithException;
import cn.sj1.tinyasm.MethodCode;
import cn.sj1.tinyasm.MethodHeader;

public class UserRepositoryMagicBuilderAdvAsmProxy extends RepositoryMagicBuilder<User, String> implements AdvMagicRuntime {
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
	public String update(User param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(String.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(this._targetClazz, "update").parameter(WithIdKey.class).return_(Object.class).INVOKE();
			c.CHECKCAST(String.class);
		});

		return new StringBuilder( MAGIC_CODES_String).append(codeIndex).toString();
	}

	public String $_update(User param0) {
		return super.update(param0);
	}
	public void _update(ClassBody classBody) {
		MethodCode code = ((MethodHeader) classBody.method(4161, "update").return_(Object.class).parameter("params0", WithIdKey.class)).begin();
		code.LINE();
		code.LOAD("this");
		code.LOAD("params0");
		code.CHECKCAST(User.class);
		code.VIRTUAL("update").parameter(User.class).return_(String.class).INVOKE();
		code.RETURNTop();
		code.END();
	}
}
