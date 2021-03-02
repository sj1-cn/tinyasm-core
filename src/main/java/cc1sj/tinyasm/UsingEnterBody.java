package cc1sj.tinyasm;

public interface UsingEnterBody {
//	MethodCode enterBody();

	AfterCode code(ConsumerWithException<MethodCode> code);
}