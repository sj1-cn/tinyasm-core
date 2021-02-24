package nebula.data.broker;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 生成代理Class，代理所有共用方法调用 暂时支持代理接口，以及包含有默认构造器的Class
 * 
 * @author wanglocal
 * 
 * @param <T>
 */
public abstract class Broker<T> implements BrokerHandler<T> {
	static final private BrokerBuilder brokerBuilder = new BrokerBuilder();

	static final private Logger log = LoggerFactory.getLogger(Broker.class);

	static final public <T> BrokerHandler<T> broke(Class<T> clz, T value) {
		log.trace("broke{} : {}", clz.getName(), value);
		BrokerHandler<T> b = brokerBuilder.builder(clz);
		b.setNewValue(value);
		return b;
	}

	@SuppressWarnings("unchecked")
	static final public <T> BrokerHandler<T> brokerOf(T value) {
		return (BrokerHandler<T>) value;
	}

	static final public void clear() {
		brokerBuilder.clear();
	}

	final public static <T> T update(T value, T newvalue) {
		if (!(value instanceof BrokerHandler)) throw new RuntimeException("Should be brokerhandle");
		@SuppressWarnings("unchecked")
		BrokerHandler<T> bt = (BrokerHandler<T>) value;
		bt.setNewValue(newvalue);
		return bt.get();
	}

	@SuppressWarnings("unchecked")
	final public static <T> T valueOf(T value) {
		return ((BrokerHandler<T>) value).getActualValue();
	}

	@SuppressWarnings("unchecked")
	final public static <R, T> R watch(T watch, final DataAdapter<T, R> listener) {
		if (watch instanceof Broker) {

			Method m = listener.getClass().getMethods()[0];
//			Preconditions.checkArgument("watch".equals(m.getName()));
			final BrokerHandler<R> r = brokerBuilder.builder(m.getReturnType());

			Broker<T> watchTo = (Broker<T>) watch;
			watchTo.addWatcher(new DataWatcher<T>() {
				@Override
				public boolean onUpdate(T newData, T oldData) {
					R newValue = listener.watch(newData, oldData);
					r.setNewValue(newValue);
					return false;
				}
			});
			return (R) r;
		} else {
			return listener.watch(watch, watch);
		}
	}

	protected T actualValue;

	protected List<DataWatcher<T>> listeners;

	protected Broker() {
	}

	@Override
	public abstract T get();

	@Override
	public T getActualValue() {
		return this.actualValue;
	}

	public void addWatcher(DataWatcher<T> listener) {
		listeners = _addWatcher(listeners, listener, actualValue);
	}

	@Override
	public void setNewValue(T newValue) {
		this.actualValue = newValue;
		_notify(listeners, newValue, actualValue);
	}

	private <TT> void _notify(List<DataWatcher<TT>> listeners, TT newValue, TT oldValue) {
		boolean hasLostReference = false;
		if (listeners == null) return;
		for (DataWatcher<TT> listener : listeners) {
			if (listener != null) {
				boolean result = listener.onUpdate(newValue, oldValue);
				if (result) break;
			} else {
				hasLostReference = true;
			}
		}
		if (hasLostReference) {
			for (int i = listeners.size() - 1; i >= 0; i--) {
				DataWatcher<TT> listener = listeners.get(i);
				if (listener == null) {
					listeners.remove(i);
				}
			}
		}
	}

	private <TT> List<DataWatcher<TT>> _addWatcher(List<DataWatcher<TT>> listeners, DataWatcher<TT> listener, TT actualValue) {
		if (listeners == null) {
			listeners = new CopyOnWriteArrayList<DataWatcher<TT>>();
		}
		listeners.add(listener);
		listener.onUpdate(actualValue, null);
		return listeners;
	}

}
