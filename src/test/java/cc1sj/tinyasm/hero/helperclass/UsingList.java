package cc1sj.tinyasm.hero.helperclass;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class UsingList {
	@SuppressWarnings("unused")
	public void say(List<PojoClassSample> in) {
		Iterable<PojoClassSample> hello = in;

		Iterator<PojoClassSample> iterator = in.iterator();

		Spliterator<PojoClassSample> spliterator = in.spliterator();

		PojoClassSample pojoClassSample = in.remove(0);

	}
}
