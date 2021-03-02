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

			Label label11OfIFNE = new Label();

			code.visitLabel(label11OfIFNE);

			context.execBlock(block);

			code.LINE();
			eval.gotoWhenSucceed(code, label11OfIFNE);
		});
		context.popAndExec();

	}
}
