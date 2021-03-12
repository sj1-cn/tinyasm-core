package cc1sj.tinyasm;

public interface AdvAfterIf {

	AdvAfterThen then(ConsumerWithException<MethodCode> block);

}
