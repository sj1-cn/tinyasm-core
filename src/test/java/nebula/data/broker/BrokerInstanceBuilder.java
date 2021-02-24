package nebula.data.broker;

public interface BrokerInstanceBuilder {
	<T> T build();
}
