package cc1sj.tinyasm.heroadv;

import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.heroadv.AdvSampleReferObject;

public class AdvSampleReferObjectObjenesisAdvAsmProxy extends AdvSampleReferObject implements AdvRuntimeReferNameObject {
	private byte _magicNumber;

	private ThreadLocal<AdvContext> _context;

	public byte get__MagicNumber() {
		return this._magicNumber;
	}

	public void set__MagicNumber(byte _magicNumber) {
		this._magicNumber = _magicNumber;
	}

	public void set__Context(ThreadLocal<AdvContext> context, byte _magicNumber) {
		this._context = context;
		this._magicNumber = _magicNumber;
	}

	public void sayHello() {
		AdvContext context = this._context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(paramMethodCode -> {
			objEval.accept(paramMethodCode);
			paramMethodCode.VIRTUAL(AdvSampleReferObject.class, "sayHello").INVOKE();
		});
		context.execAndPop();
	}

	public String getHelloString() {
		AdvContext context = this._context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(paramMethodCode -> {
			objEval.accept(paramMethodCode);
			paramMethodCode.VIRTUAL(AdvSampleReferObject.class, "getHelloString").reTurn(String.class).INVOKE();
		});
		return "#MAGIC-CODES#" + codeIndex;
	}

	public void setHelloString(String param0) {
		AdvContext context = this._context.get();
		ConsumerWithException consumerWithException = context.resolve(this);
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		context.push(paramMethodCode -> {
			consumerWithException.accept(paramMethodCode);
			eval_param0.accept(paramMethodCode);
			paramMethodCode.VIRTUAL(AdvSampleReferObject.class, "setHelloString").parameter(String.class).INVOKE();
		});
		context.execAndPop();
	}

	public boolean beGood() {
		AdvContext context = this._context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(paramMethodCode -> {
			objEval.accept(paramMethodCode);
			paramMethodCode.VIRTUAL(AdvSampleReferObject.class, "beGood").reTurn(boolean.class).INVOKE();
		});
		return false;
	}
}
