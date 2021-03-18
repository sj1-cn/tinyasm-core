package cn.sj1.tinyasm.core;

public interface AdvAfterThen {

	void else_(ConsumerWithException<MethodCode> block);

	AdvAfterIf else_if(CompareEval beGood);

}
