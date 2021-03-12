package cc1sj.tinyasm;

public interface AdvAfterThen {

	void else_(ConsumerWithException<MethodCode> block);

	AdvAfterIf else_if(CompareEval beGood);

}
