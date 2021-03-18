package cn.sj1.tinyasm;

public interface AdvAfterIf {

	AdvAfterThen then(ConsumerWithException<MethodCode> block);

}
