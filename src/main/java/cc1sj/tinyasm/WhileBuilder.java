package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class WhileBuilder implements AfterWhile, ConsumerWithException<MethodCode> {
	CompareEval eval;
	ConsumerWithException<MethodCode> thenBlock;
	AdvContext context;

	public WhileBuilder(AdvContext context, CompareEval eval) {
		this.context = context;
		this.eval = eval;
	}

	@Override
	public void block(ConsumerWithException<MethodCode> block) {
		this.thenBlock = block;
	}

	@Override
	public void accept(MethodCode code) throws Exception {
		if (thenBlock != null) {

			code.LINE();
			Label labelThenEnd = new Label();
			eval.gotoWhenFail(code, labelThenEnd);

			context.execBlock(thenBlock);

			code.visitLabel(labelThenEnd);
		} else {
			throw new UnsupportedOperationException("while 没有thenblock");
		}

	}

}
