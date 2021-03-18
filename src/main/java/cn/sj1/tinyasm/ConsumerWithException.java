package cn.sj1.tinyasm;

public interface ConsumerWithException<T> {
	void accept(T code) throws Exception;
}
