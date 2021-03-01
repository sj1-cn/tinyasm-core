package cc1sj.tinyasm;

import java.util.function.Consumer;

public interface AfterIf {

	AfterThen then_(ConsumerWithException<MethodCode> block);

}
