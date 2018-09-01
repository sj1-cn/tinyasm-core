package nebula.tinyasm.data;

public interface MethodCodeFriendly<C> extends WithDefineVar<C> {

//	C define(String fieldName, Class<?> clz);
//
//	C define(String fieldName, Class<?> clz, boolean isarray);
//
//	C define(String fieldName, Class<?> clz, boolean isarray, Class<?>... signatureClasses);
//
//	C define(String fieldName, Class<?> clz, Class<?>... signatureClasses);
//
//	C define(String fieldName, String clz);
//
//	C define(String fieldName, String clz, boolean isarray);
//
//	C define(String fieldName, String clz, boolean isarray, Class<?>... signatureClasses);
//
//	C define(String fieldName, String clz, boolean isarray, String... signatureClasses);
//
//	C define(String fieldName, String clz, Class<?>... signatureClasses);
//
//	C define(String fieldName, String clz, String... signatureClasses);
	Instance loadThis();

	C line(int line);

	C line();

	Instance add(String left, String right);

	Instance sub(String left, String right);

	Instance mul(String left, String right);

	Instance div(String left, String right);

	Instance rem(String left, String right);

	Instance neg(String left);

	Instance and(String left, String right);

	Instance or(String left, String right);

	Instance xor(String left, String right);

	Instance newarray(Class<?> elementClazz, int count);

	Instance newarray(String elementClazz, int count);

	Instance arrayload(String arrayref, String index, Class<?> valueType);

	Instance arrayload(String arrayref, String index, String valueType);

	void arraystore(String varArray, String index, String value);

	Instance getfield(String objectname, String fieldname, Class<?> fieldType);

	Instance getfield(String objectname, String fieldname, String fieldType);

	Instance loadThisField(String fieldname);

	Instance loadThisField(String fieldname, Class<?> feildtype);

	Instance loadThisField(String fieldname, String feildtype);
	
	void putThisFieldWithVar(String fieldname, String varname);

	void putfield(String objectref, String varname, String fieldname, Class<?> fieldType);

	void putfield(String objectref, String varname, String fieldname, String fieldType);


	void putstatic(Class<?> objectType, String varname, String fieldname, Class<?> fieldType);

	void putstatic(String objectType, String varname, String fieldname, String fieldType);

}