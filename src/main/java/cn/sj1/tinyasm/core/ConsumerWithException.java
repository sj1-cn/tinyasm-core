package cn.sj1.tinyasm.core;

public interface ConsumerWithException<T> {
	void accept(T code) throws Exception;
}
