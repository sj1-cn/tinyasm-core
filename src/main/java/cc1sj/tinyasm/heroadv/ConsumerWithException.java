package cc1sj.tinyasm.heroadv;

public interface ConsumerWithException<T> {
	void accept(T code) throws Exception;
}
