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
			code.LINE();
			Label labelThenEnd = new Label();
			eval.gotoWhenFail(code, labelThenEnd);

			context.execBlock(block);

			code.visitLabel(labelThenEnd);
		});
		context.execAndPop();
	}
}
