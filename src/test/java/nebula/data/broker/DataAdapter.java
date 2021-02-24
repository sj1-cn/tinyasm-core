package nebula.data.broker;

public interface DataAdapter<T, R> {
	R watch(T newData, T oldData);
}
