package cc1sj.tinyasm.advasmproxy.arraylist;

import java.util.Iterator;
import java.util.Spliterator;

import cc1sj.tinyasm.advasmproxy.simple.PojoClass;

public class IterableUsingSample {
	@SuppressWarnings("unused")
	public void say(Iterable<PojoClass> in) {
		Iterable<PojoClass> hello = in;

		Iterator<PojoClass> iterator = in.iterator();
		
		Spliterator<PojoClass> spliterator = in.spliterator();

	}
}
