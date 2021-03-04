package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class DoWhileBuilder implements AfterDo {
	ThreadLocal<AdvContext> _contextThreadLocal;
	ConsumerWithException<MethodCode> block;

	public DoWhileBuilder(ThreadLocal<AdvContext> _contextThreadLocal, ConsumerWithException<MethodCode> block) {
		this._contextThreadLocal = _contextThreadLocal;
		this.block = block;
	}

	@Override
	public void _while(CompareEval eval) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> c = code -> {

			Label label11OfIFNE = new Label();

			code.visitLabel(label11OfIFNE);

			context.execBlock(block);

			code.LINE();
			eval.prepareData(code);
			code.LINE();
			eval.gotoWhenSucceed(code, label11OfIFNE);
		};
		context.exec(c);

	}
}
