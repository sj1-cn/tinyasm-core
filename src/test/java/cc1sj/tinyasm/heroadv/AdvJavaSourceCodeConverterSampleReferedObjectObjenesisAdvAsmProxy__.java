package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_String;

import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;

public class AdvJavaSourceCodeConverterSampleReferedObjectObjenesisAdvAsmProxy__ extends AdvJavaSourceCodeConverterSampleReferedObject
		implements AdvRuntimeReferNameObject {
	private byte _magicNumber;

	private ThreadLocal<AdvContext> _contextThreadLocal;

	public byte get__MagicNumber() {
		return this._magicNumber;
	}

	public void set__MagicNumber(byte _magicNumber) {
		this._magicNumber = _magicNumber;
	}

	public void set__Context(ThreadLocal<AdvContext> _contextThreadLocal, byte _magicNumber) {
		this._contextThreadLocal = _contextThreadLocal;
		this._magicNumber = _magicNumber;
	}

	public void sayHello() {
		AdvContext context = this._contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvJavaSourceCodeConverterSampleReferedObject.class, "sayHello").INVOKE();
		});
	}

	public String getHelloString() {
		AdvContext context = this._contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(String.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvJavaSourceCodeConverterSampleReferedObject.class, "getHelloString").reTurn(String.class).INVOKE();
		});
		return new StringBuilder(MAGIC_CODES_String).append(codeIndex).toString();
	}

	public void setHelloString(String param0) {
		AdvContext context = this._contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(AdvJavaSourceCodeConverterSampleReferedObject.class, "setHelloString").parameter(String.class).INVOKE();
		});
	}

	public boolean beGood() {
		AdvContext context = this._contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(boolean.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvJavaSourceCodeConverterSampleReferedObject.class, "beGood").reTurn(boolean.class).INVOKE();
		});
		return false;
	}
}
