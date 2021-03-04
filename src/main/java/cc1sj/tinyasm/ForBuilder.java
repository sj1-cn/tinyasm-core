package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class ForBuilder implements AfterFor {
	ThreadLocal<AdvContext> _contextThreadLocal;
	CompareEval eval;
	ConsumerWithException<MethodCode> execEveryLoop;

	public ForBuilder(ThreadLocal<AdvContext> _contextThreadLocal,  CompareEval eval,
			ConsumerWithException<MethodCode> execEveryLoop) {
		this._contextThreadLocal = _contextThreadLocal;
		this.eval = eval;
		this.execEveryLoop = execEveryLoop;
	}

	@Override
	public void block(ConsumerWithException<MethodCode> block) {
		AdvContext context = _contextThreadLocal.get();
		context.push(code -> {

//			{
//				Label labelWhileEval = new Label();
//
//				code.visitLabel(labelWhileEval);
//
//				eval.prepareData(code);
//
//				Label label2OfIF_ICMPLE = new Label();
//				eval.gotoWhenFail(code, label2OfIF_ICMPLE);
//
//				context.execBlock(block);
//
//				code.GOTO(labelWhileEval);
//				code.visitLabel(label2OfIF_ICMPLE);
//			}
//
//			{
				
				Label label6OfGOTO = new Label();

				code.visitLabel(label6OfGOTO);
				eval.prepareData(code);
				Label label3OfIF_ICMPGE = new Label();
				eval.gotoWhenFail(code, label3OfIF_ICMPGE);
//				code.IF_ICMPGE(label3OfIF_ICMPGE);

				context.execBlock(block);

				code.LINE();
				execEveryLoop.accept(code);
				code.GOTO(label6OfGOTO);

				code.visitLabel(label3OfIF_ICMPGE);
//			}

		});
		context.popAndExec();
	}

}
