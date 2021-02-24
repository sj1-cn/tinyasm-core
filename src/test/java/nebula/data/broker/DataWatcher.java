package nebula.data.broker;

public interface DataWatcher<T> {
	boolean onUpdate(T newData, T oldData);
}
