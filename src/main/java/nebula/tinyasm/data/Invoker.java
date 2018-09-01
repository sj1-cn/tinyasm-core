package nebula.tinyasm.data;

import java.util.function.Consumer;

public interface Invoker {
	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCode> p0) {
		return invoke(new Consumer[] { p0 });
	}

	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCode> p0, Consumer<MethodCode> p1) {
		return invoke(new Consumer[] { p0, p1, });
	}

	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCode> p0, Consumer<MethodCode> p1, Consumer<MethodCode> p2) {
		return invoke(new Consumer[] { p0, p1, p2 });
	}

	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCode> p0, Consumer<MethodCode> p1, Consumer<MethodCode> p2,
			Consumer<MethodCode> p3) {
		return invoke(new Consumer[] { p0, p1, p2, p3 });
	}

	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCode> p0, Consumer<MethodCode> p1, Consumer<MethodCode> p2,
			Consumer<MethodCode> p3, Consumer<MethodCode> p4) {
		return invoke(new Consumer[] { p0, p1, p2, p3, p4 });
	}

	Instance invoke(Consumer<MethodCode>[] invocations);

	Instance invoke(String... varname);

	Instance invoke();

}