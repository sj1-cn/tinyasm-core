package cc1sj.tinyasm;

public interface ConsumerWithException<T> {
	void accept(T code) throws Exception;
}
