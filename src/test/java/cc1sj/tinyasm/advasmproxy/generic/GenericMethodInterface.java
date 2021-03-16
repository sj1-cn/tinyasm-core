package cc1sj.tinyasm.advasmproxy.generic;

public interface GenericMethodInterface<E> {
	<T> T[] arrayToArray(T[] a);
	<T> T arrayToObject(T[] a);

	<T> T objectToObject(T a);
	
	<T> T[] objectToArray(T a);
	
//	<T> T classToObject(Class<T> c);
}
