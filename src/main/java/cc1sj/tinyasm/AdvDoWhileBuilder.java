package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class AdvDoWhileBuilder implements AdvAfterDo {
	ThreadLocal<AdvContext> _contextThreadLocal;
	ConsumerWithException<MethodCode> block;

	public AdvDoWhileBuilder(ThreadLocal<AdvContext> _contextThreadLocal, ConsumerWithException<MethodCode> block) {
		this._contextThreadLocal = _contextThreadLocal;
		this.block = block;
	}

	@Override
	public void while_(CompareEval eval) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> c = code -> {

			Label label3OfIF_ICMPGT = new Label();

			code.visitLabel(label3OfIF_ICMPGT);

			context.execBlock(block);

			code.LINE();
			eval.prepareData(code);
			eval.gotoWhenSucceed(code, label3OfIF_ICMPGT);
		};
		context.exec(c);

	}
}
