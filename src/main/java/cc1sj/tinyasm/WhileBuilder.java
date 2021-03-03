package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class WhileBuilder implements AfterWhile {
	ThreadLocal<AdvContext> _context;
	CompareEval eval;

	public WhileBuilder(ThreadLocal<AdvContext> _context, CompareEval eval) {
		this._context = _context;
		this.eval = eval;
	}

	@Override
	public void block(ConsumerWithException<MethodCode> block) {
		AdvContext context = _context.get();
		context.push(code -> {
			Label labelWhileEval = new Label();
			code.GOTO(labelWhileEval);
			Label labelWhileBegin = new Label();

			code.visitLabel(labelWhileBegin);

			context.execBlock(block);

			code.LINE();
			code.visitLabel(labelWhileEval);

			eval.prepareData(code);
			eval.gotoWhenSucceed(code, labelWhileBegin);

		});
		context.popAndExec();
	}
}
