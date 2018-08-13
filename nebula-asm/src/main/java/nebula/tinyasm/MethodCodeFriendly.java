package nebula.tinyasm;

public interface MethodCodeFriendly<C> {

	C var(String fieldName, Class<?> clz);

	C var(String fieldName, Class<?> clz, boolean isarray);

	C var(String fieldName, Class<?> clz, boolean isarray, Class<?>... signatureClasses);

	C var(String fieldName, Class<?> clz, Class<?>... signatureClasses);

	C var(String fieldName, String clz);

	C var(String fieldName, String clz, boolean isarray);

	C var(String fieldName, String clz, boolean isarray, Class<?>... signatureClasses);

	C var(String fieldName, String clz, boolean isarray, String... signatureClasses);

	C var(String fieldName, String clz, Class<?>... signatureClasses);

	C var(String fieldName, String clz, String... signatureClasses);

	C line(int line);

	C line();

}