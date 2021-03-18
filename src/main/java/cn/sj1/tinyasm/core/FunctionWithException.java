package cn.sj1.tinyasm.core;

public interface FunctionWithException<T, R> {
	R accept(T t) throws Exception;
}
