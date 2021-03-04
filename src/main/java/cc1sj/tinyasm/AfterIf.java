package cc1sj.tinyasm;

import java.util.function.Consumer;

public interface AfterIf {

	AfterThen _then(ConsumerWithException<MethodCode> block);

}
