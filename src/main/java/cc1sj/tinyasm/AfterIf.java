package cc1sj.tinyasm;

public interface AfterIf {

	AfterThen then(ConsumerWithException<MethodCode> block);

}
