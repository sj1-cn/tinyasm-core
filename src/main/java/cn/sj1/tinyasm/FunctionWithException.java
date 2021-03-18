package cn.sj1.tinyasm;

public interface FunctionWithException<T, R> {
	R accept(T t) throws Exception;
}
