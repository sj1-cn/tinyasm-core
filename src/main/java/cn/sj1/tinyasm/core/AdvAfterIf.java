package cn.sj1.tinyasm.core;

public interface AdvAfterIf {

	AdvAfterThen then(ConsumerWithException<MethodCode> block);

}
