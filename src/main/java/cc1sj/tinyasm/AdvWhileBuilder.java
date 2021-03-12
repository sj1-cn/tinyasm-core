package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class AdvWhileBuilder implements AdvAfterWhile {
	ThreadLocal<AdvContext> _contextThreadLocal;
	CompareEval eval;

	public AdvWhileBuilder(ThreadLocal<AdvContext> _contextThreadLocal, CompareEval eval) {
		this._contextThreadLocal = _contextThreadLocal;
		this.eval = eval;
	}

	@Override
	public void block(ConsumerWithException<MethodCode> block) {
		AdvContext context = _contextThreadLocal.get();
		context.execLine(code -> {

			Label labelWhileEval = new Label();

			code.visitLabel(labelWhileEval);

			eval.prepareData(code);

			Label label2OfIF_ICMPLE = new Label();
			eval.gotoWhenFail(code, label2OfIF_ICMPLE);

			context.execBlock(block);

			code.GOTO(labelWhileEval);
			code.visitLabel(label2OfIF_ICMPLE);

		});
	}
}
