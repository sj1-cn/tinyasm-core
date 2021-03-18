package cn.sj1.tinyasm.core;

public interface AdvUsingEnterBody {
//	MethodCode enterBody();

	AdvAfterCode code(ConsumerWithException<MethodCode> code);
}