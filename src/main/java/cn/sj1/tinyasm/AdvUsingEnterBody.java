package cn.sj1.tinyasm;

public interface AdvUsingEnterBody {
//	MethodCode enterBody();

	AdvAfterCode code(ConsumerWithException<MethodCode> code);
}