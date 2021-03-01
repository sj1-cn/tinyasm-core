package cc1sj.tinyasm.heroadv;

public interface FunctionWithException<T, R> {
	R accept(T t) throws Exception;
}
