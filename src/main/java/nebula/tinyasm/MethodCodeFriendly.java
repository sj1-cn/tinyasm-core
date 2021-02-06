package nebula.tinyasm;

import java.util.function.Consumer;

public interface MethodCodeFriendly extends WithDefineVar {
	Instance loadThis();
	
	Instance boxTop();
	
	Instance unboxTop();

	MethodCodeFriendly line(int line);

	MethodCodeFriendly line();
	
	void initObject();

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

	void arrayStore(String varArray, String index, String value);

	Instance getfield(String objectname, String fieldname, Class<?> fieldType);

	Instance getfield(String objectname, String fieldname, String fieldType);

	Instance loadThisField(String fieldname);

	Instance loadThisField(String fieldname, Class<?> feildtype);

	Instance loadThisField(String fieldname, String feildtype);
	
	void putThisFieldWithVar(String fieldname, String varname);

	void putField(String objectref, String varname, String fieldname, Class<?> fieldType);

	void putField(String objectref, String varname, String fieldname, String fieldType);

	void putStatic(Class<?> objectType, String varname, String fieldname, Class<?> fieldType);

	void putStatic(String objectType, String varname, String fieldname, String fieldType);

	Instance topInstance();

	void set(String varname, Consumer<MethodCode> invocations);

	void setNull(String varname);

	void setConst(String varname, String cst);

	void setConst(String varname, int cst);

	void setConst(String varname, long cst);

	ClazzReference clazz(Class<?> clazz);

	ClazzReference clazz(String clazz);

	Instance load(String varname);

	void ifTrue(Consumer<MethodCode> block);

	void ifFalse(Consumer<MethodCode> block);

	void ifEqual(Consumer<MethodCode> block);

	void ifNotEqual(Consumer<MethodCode> block);

	void ifGreatThan(Consumer<MethodCode> block);

	void wHile(Consumer<MethodCode> cause, Consumer<MethodCode> block);

	void store(String varname);

	Instance dup();

	void ifGreatEqual(Consumer<MethodCode> block);

	void ifLessEqual(Consumer<MethodCode> block);

	void ifLessThan(Consumer<MethodCode> block);

	Instance loadConst(Object cst);

	Instance loadConst(long cst);

	Instance loadConst(int cst);

	Instance arrayload(String arrayref, int index);

	Instance arrayload(String varArray, String varIndex);

	void returnVoid();

	void returnVar(String varname);
	
	void returnNull();

	void setNew(String varname, Class<?> clazz);

	void initTo(Class<?> clazz, String varname);

	void initTo(String clazz, String varname);

	MethodCode line(Consumer<MethodCode> block);

	MethodCode block(Consumer<MethodCode> block);

	void initThis();

	Instance init(Class<?> clazz);

	Instance init(Class<?> clazz, String... varnames);
	
	Instance init(String clazz, String... varnames);

	Instance init(String clazz);

	void ifObjectEqual(Consumer<MethodCode> left, Consumer<MethodCode> right, Consumer<MethodCode> block);

	void ifObjectNotEqual(Consumer<MethodCode> left, Consumer<MethodCode> right, Consumer<MethodCode> block);

	Instance checkcastAndUnbox(Class<?> clazz);

	Instance checkcastAndUnbox(String clazz);


}