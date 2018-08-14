package nebula.tinyasm;

public interface MethodCodeFriendly<C> {

	C define(String fieldName, Class<?> clz);

	C define(String fieldName, Class<?> clz, boolean isarray);

	C define(String fieldName, Class<?> clz, boolean isarray, Class<?>... signatureClasses);

	C define(String fieldName, Class<?> clz, Class<?>... signatureClasses);

	C define(String fieldName, String clz);

	C define(String fieldName, String clz, boolean isarray);

	C define(String fieldName, String clz, boolean isarray, Class<?>... signatureClasses);

	C define(String fieldName, String clz, boolean isarray, String... signatureClasses);

	C define(String fieldName, String clz, Class<?>... signatureClasses);

	C define(String fieldName, String clz, String... signatureClasses);

	C line(int line);

	C line();

}