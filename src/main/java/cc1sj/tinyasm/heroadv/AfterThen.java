package cc1sj.tinyasm.heroadv;

import cc1sj.tinyasm.MethodCode;

public interface AfterThen {

	void else_(ConsumerWithException<MethodCode> block);

	AfterIf else_if(CompareEval beGood);

}
