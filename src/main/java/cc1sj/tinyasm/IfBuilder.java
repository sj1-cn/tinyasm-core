package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public class IfBuilder implements AfterIf, AfterThen, ConsumerWithException<MethodCode> {
	CompareEval ifEval;
	ConsumerWithException<MethodCode> thenBlock;
	ConsumerWithException<MethodCode> elseBlock;
	AfterIf elseIf;
	ThreadLocal<AdvContext> _contextThreadLocal;

	public IfBuilder(ThreadLocal<AdvContext> _contextThreadLocal, CompareEval eval) {
		this._contextThreadLocal = _contextThreadLocal;
		this.ifEval = eval;
	}

	@Override
	public AfterThen then_(ConsumerWithException<MethodCode> block) {
		this.thenBlock = block;
		return this;
	}

	@Override
	public void else_(ConsumerWithException<MethodCode> block) {
		this.elseBlock = block;
	}

	@Override
	public AfterIf else_if(CompareEval beGood) {
		IfBuilder elseIfBuilder = new IfBuilder(_contextThreadLocal, beGood);
		this.elseIf = elseIfBuilder;
		return elseIfBuilder;

	}

	@Override
	public void accept(MethodCode code) throws Exception {
		AdvContext context = _contextThreadLocal.get();
		if (elseIf != null) {

		} else if (elseBlock != null) {
//			code.LINE(39);
			Label labelElse = new Label();

			ifEval.prepareData(code);
			ifEval.gotoWhenFail(code, labelElse);

			context.execBlock(thenBlock);

			Label label4OfGOTO = new Label();
			Label line = new Label();
			code.visitLabel(line);
			code.visitLineNumber(line);

			code.GOTO(label4OfGOTO);

			code.visitLabel(labelElse);

			context.execBlock(elseBlock);

			code.visitLabel(label4OfGOTO);
		} else if (thenBlock != null) {

			code.LINE();
			Label labelThenEnd = new Label();
			ifEval.prepareData(code);
			ifEval.gotoWhenFail(code, labelThenEnd);

			context.execBlock(thenBlock);

			code.visitLabel(labelThenEnd);
		} else {
			throw new UnsupportedOperationException("if 没有thenblock");
		}

	}

}
