package cc1sj.tinyasm.hero.helperclass;

import java.util.Iterator;
import java.util.Spliterator;

public class UsingIterable {
	public void say(Iterable<PojoClassSample> in) {
		Iterable<PojoClassSample> hello = in;

		Iterator<PojoClassSample> iterator = in.iterator();
		
		Spliterator<PojoClassSample> spliterator = in.spliterator();

	}
}
