package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class DoWhileBuilder implements AfterDo {
	ThreadLocal<AdvContext> _context;
	ConsumerWithException<MethodCode> block;

	public DoWhileBuilder(ThreadLocal<AdvContext> _context, ConsumerWithException<MethodCode> block) {
		this._context = _context;
		this.block = block;
	}

	@Override
	public void while_(CompareEval eval) {
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
