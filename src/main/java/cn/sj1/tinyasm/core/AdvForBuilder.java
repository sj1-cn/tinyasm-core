package cn.sj1.tinyasm.core;

import org.objectweb.asm.Label;

public class AdvForBuilder implements AdvAfterFor {
	ThreadLocal<AdvContext> _contextThreadLocal;
	CompareEval eval;
	ConsumerWithException<MethodCode> execEveryLoop;

	public AdvForBuilder(ThreadLocal<AdvContext> _contextThreadLocal, CompareEval eval, ConsumerWithException<MethodCode> execEveryLoop) {
		this._contextThreadLocal = _contextThreadLocal;
		this.eval = eval;
		this.execEveryLoop = execEveryLoop;
	}

	@Override
	public void block(ConsumerWithException<MethodCode> block) {
		AdvContext context = _contextThreadLocal.get();
		context.execLine(code -> {

			Label label6OfGOTO = new Label();

			code.visitLabel(label6OfGOTO);
			eval.prepareData(code);
			Label label3OfIF_ICMPGE = new Label();
			eval.gotoWhenFail(code, label3OfIF_ICMPGE);

			context.execBlock(block);

//			code.LINE();
			execEveryLoop.accept(code);
			code.GOTO(label6OfGOTO);

			code.visitLabel(label3OfIF_ICMPGE);

		});
	}

}
