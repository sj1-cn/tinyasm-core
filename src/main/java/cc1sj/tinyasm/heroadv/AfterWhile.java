package cc1sj.tinyasm.heroadv;

import cc1sj.tinyasm.MethodCode;

public interface AfterWhile {
	void block(ConsumerWithException<MethodCode> block);
}
