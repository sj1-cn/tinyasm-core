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

	C line(int line);

	C line();

	void add(String left, String right);

	void sub(String left, String right);

	void mul(String left, String right);

	void div(String left, String right);

	void rem(String left, String right);

	void neg(String left);

	void and(String left, String right);

	void or(String left, String right);

	void xor(String left, String right);

	void newarray(Class<?> elementClazz, int count);

	void newarray(String elementClazz, int count);

	void arrayload(String arrayref, String index, Class<?> valueType);

	void arrayload(String arrayref, String index, String valueType);

	void arraystore(String varArray, String index, String value);

	void getfield(String objectname, String fieldname, Class<?> fieldType);

	void getfield(String objectname, String fieldname, String fieldType);

	void loadThisField(String fieldname);

	void loadThisField(String fieldname, Class<?> feildtype);

	void loadThisField(String fieldname, String feildtype);
	
	void putThisFieldWithVar(String fieldname, String varname);

	void putfield(String objectref, String varname, String fieldname, Class<?> fieldType);

	void putfield(String objectref, String varname, String fieldname, String fieldType);


	void putstatic(Class<?> objectType, String varname, String fieldname, Class<?> fieldType);

	void putstatic(String objectType, String varname, String fieldname, String fieldType);

}