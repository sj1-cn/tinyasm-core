package nebula.tinyasm;

import java.util.function.Consumer;

public interface Invoker {
	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCodeAdv> p0) {
		return invoke(new Consumer[] { p0 });
	}

	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCodeAdv> p0, Consumer<MethodCodeAdv> p1) {
		return invoke(new Consumer[] { p0, p1, });
	}

	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCodeAdv> p0, Consumer<MethodCodeAdv> p1, Consumer<MethodCodeAdv> p2) {
		return invoke(new Consumer[] { p0, p1, p2 });
	}

	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCodeAdv> p0, Consumer<MethodCodeAdv> p1, Consumer<MethodCodeAdv> p2,
			Consumer<MethodCodeAdv> p3) {
		return invoke(new Consumer[] { p0, p1, p2, p3 });
	}

	@SuppressWarnings("unchecked")
	default Instance invoke(Consumer<MethodCodeAdv> p0, Consumer<MethodCodeAdv> p1, Consumer<MethodCodeAdv> p2,
			Consumer<MethodCodeAdv> p3, Consumer<MethodCodeAdv> p4) {
		return invoke(new Consumer[] { p0, p1, p2, p3, p4 });
	}

	Instance invoke(Consumer<MethodCodeAdv>[] invocations);

	Instance invoke(String... varname);

	Instance invoke();
}