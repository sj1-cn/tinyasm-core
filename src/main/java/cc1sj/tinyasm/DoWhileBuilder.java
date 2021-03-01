package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class DoWhileBuilder implements AfterDo, ConsumerWithException<MethodCode> {
	CompareEval eval;
	ConsumerWithException<MethodCode> block;
	AdvContext context;

	public DoWhileBuilder(AdvContext context, ConsumerWithException<MethodCode> block) {
		this.context = context;
		this.block = block;
	}

	@Override
	public void while_(CompareEval eval) {
		this.eval = eval;
	}

	@Override
	public void accept(MethodCode code) throws Exception {
		if (block != null) {

			code.LINE();
			Label labelThenEnd = new Label();
			eval.gotoWhenFail(code, labelThenEnd);

			context.execBlock(block);

			code.visitLabel(labelThenEnd);
		} else {
			throw new UnsupportedOperationException("while 没有thenblock");
		}

	}

}
