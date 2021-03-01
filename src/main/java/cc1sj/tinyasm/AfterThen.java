package cc1sj.tinyasm;

public interface AfterThen {

	void else_(ConsumerWithException<MethodCode> block);

	AfterIf else_if(CompareEval beGood);

}
