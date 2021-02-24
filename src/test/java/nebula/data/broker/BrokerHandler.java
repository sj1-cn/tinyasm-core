package nebula.data.broker;

public interface BrokerHandler<T> {
	void addWatcher(DataWatcher<T> listener);

	void setNewValue(T newValue);

	/**
	 * 取得当前实际值
	 * 
	 * @return
	 */
	T getActualValue();

	/**
	 * 取得可即时更新的包裹对象
	 * 
	 * @return
	 */
	T get();
}
