package cc1sj.tinyasm;

public interface FunctionWithException<T, R> {
	R accept(T t) throws Exception;
}
