package cc1sj.tinyasm.heroadv;

import java.util.function.Consumer;

import cc1sj.tinyasm.MethodCode;

public interface AfterIf {

	AfterThen then_(ConsumerWithException<MethodCode> block);

}
