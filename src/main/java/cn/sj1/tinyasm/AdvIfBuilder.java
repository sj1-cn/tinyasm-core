package cn.sj1.tinyasm;

import org.objectweb.asm.Label;

public class AdvIfBuilder implements AdvAfterIf, AdvAfterThen, ConsumerWithException<MethodCode> {
	CompareEval ifEval;
	ConsumerWithException<MethodCode> thenBlock;
	ConsumerWithException<MethodCode> elseBlock;
	AdvAfterIf elseIf;
	ThreadLocal<AdvContext> _contextThreadLocal;

	public AdvIfBuilder(ThreadLocal<AdvContext> _contextThreadLocal, CompareEval eval) {
		this._contextThreadLocal = _contextThreadLocal;
		this.ifEval = eval;
	}

	@Override
	public AdvAfterThen then(ConsumerWithException<MethodCode> block) {
		this.thenBlock = block;
		return this;
	}

	@Override
	public void else_(ConsumerWithException<MethodCode> block) {
		this.elseBlock = block;
		AdvContext context = _contextThreadLocal.get();
		context.clear();
	}

	@Override
	public AdvAfterIf else_if(CompareEval beGood) {
		AdvIfBuilder elseIfBuilder = new AdvIfBuilder(_contextThreadLocal, beGood);
		this.elseIf = elseIfBuilder;
		return elseIfBuilder;
	}

	@Override
	public void accept(MethodCode code) throws Exception {
		AdvContext context = _contextThreadLocal.get();
		if (elseIf != null) {

		} else if (elseBlock != null) {
//			context.clear();
//			code.LINE(39);
			Label labelElse = new Label();

			ifEval.prepareData(code);
			ifEval.gotoWhenFail(code, labelElse);

			context.execBlock(thenBlock);

			Label label4OfGOTO = new Label();
//			Label line = new Label();
//			code.visitLabel(line);
//			code.visitLineNumber(line);

			code.GOTO(label4OfGOTO);

			code.visitLabel(labelElse);

			context.execBlock(elseBlock);

			code.visitLabel(label4OfGOTO);
		} else if (thenBlock != null) {
//			context.clear();

//			code.LINE();
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
