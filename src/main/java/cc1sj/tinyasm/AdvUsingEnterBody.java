package cc1sj.tinyasm;

public interface AdvUsingEnterBody {
//	MethodCode enterBody();

	AdvAfterCode code(ConsumerWithException<MethodCode> code);
}