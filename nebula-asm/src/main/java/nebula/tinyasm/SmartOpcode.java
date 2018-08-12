package nebula.tinyasm;

import static nebula.tinyasm.api.TypeUtils.*;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Opcodes.ARRAYLENGTH;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.BIPUSH;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.D2F;
import static org.objectweb.asm.Opcodes.D2I;
import static org.objectweb.asm.Opcodes.D2L;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.DUP2;
import static org.objectweb.asm.Opcodes.F2D;
import static org.objectweb.asm.Opcodes.F2I;
import static org.objectweb.asm.Opcodes.F2L;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.I2B;
import static org.objectweb.asm.Opcodes.I2C;
import static org.objectweb.asm.Opcodes.I2D;
import static org.objectweb.asm.Opcodes.I2F;
import static org.objectweb.asm.Opcodes.I2L;
import static org.objectweb.asm.Opcodes.I2S;
import static org.objectweb.asm.Opcodes.IADD;
import static org.objectweb.asm.Opcodes.IALOAD;
import static org.objectweb.asm.Opcodes.IAND;
import static org.objectweb.asm.Opcodes.IDIV;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.IMUL;
import static org.objectweb.asm.Opcodes.INEG;
import static org.objectweb.asm.Opcodes.INSTANCEOF;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IOR;
import static org.objectweb.asm.Opcodes.IREM;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.ISHR;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.ISUB;
import static org.objectweb.asm.Opcodes.IXOR;
import static org.objectweb.asm.Opcodes.L2D;
import static org.objectweb.asm.Opcodes.L2F;
import static org.objectweb.asm.Opcodes.L2I;
import static org.objectweb.asm.Opcodes.LASTORE;
import static org.objectweb.asm.Opcodes.LCONST_0;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.POP;
import static org.objectweb.asm.Opcodes.POP2;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.PUTSTATIC;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.SIPUSH;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public interface SmartOpcode {
	default void add(String value1, String value2) {
		load(value1);
		load(value2);
		ADD();
	}

	default boolean in(Type type, Type... types) {
		for (Type type2 : types) {
			if (type2 == type) {
				return true;
			}
		}
		return false;
	}

	default Type checkMathTypes(Type right, Type left) {
		assert in(right, Type.BYTE_TYPE, Type.CHAR_TYPE, Type.SHORT_TYPE, Type.INT_TYPE, Type.LONG_TYPE,
				Type.FLOAT_TYPE, Type.DOUBLE_TYPE) : "right value type";
		assert in(left, Type.BYTE_TYPE, Type.CHAR_TYPE, Type.SHORT_TYPE, Type.INT_TYPE, Type.LONG_TYPE, Type.FLOAT_TYPE,
				Type.DOUBLE_TYPE) : "left value type";
		right = mathInnerUserType(right);
		left = mathInnerUserType(left);
		assert left == right : "left type should equal right type";
		Type innerType = mathInnerUserType(left);
		return innerType;
	}

	default void ADD() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);

		codeInst(type.getOpcode(IADD));
		// DADD (value1, value2 → result) : add two doubles
		// FADD (value1, value2 → result) : add two floats
		// IADD (value1, value2 → result) : add two ints
		// LADD (value1, value2 → result) : add two longs
	}

	default void sub(String value1, String value2) {
		load(value1);
		load(value2);
		SUB();
	}

	default void SUB() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		codeInst(type.getOpcode(ISUB));
		// DSUB (value1, value2 → result) : subtract a double from another
		// FSUB (value1, value2 → result) : subtract two floats
		// ISUB (value1, value2 → result) : int subtract
		// LSUB (value1, value2 → result) : subtract two longs
	}

	default void mul(String value1, String value2) {
		load(value1);
		load(value2);
		MUL();
	}

	default void MUL() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		codeInst(type.getOpcode(IMUL));
		// DMUL (value1, value2 → result) : multiply two doubles
		// FMUL (value1, value2 → result) : multiply two floats
		// IMUL (value1, value2 → result) : multiply two integers
		// LMUL (value1, value2 → result) : multiply two longs
	}

	default void div(String value1, String value2) {
		load(value1);
		load(value2);
		DIV();
	}

	default void DIV() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		codeInst(type.getOpcode(IDIV));
		// DDIV (value1, value2 → result) : divide two doubles
		// FDIV (value1, value2 → result) : divide two floats
		// IDIV (value1, value2 → result) : divide two integers
		// LDIV (value1, value2 → result) : divide two longs
	}

	default void rem(String value1, String value2) {
		load(value1);
		load(value2);
		REM();
	}

	default void REM() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		codeInst(type.getOpcode(IREM));
		// DREM (value1, value2 → result) : get the remainder from a division between
		// two doubles
		// FREM (value1, value2 → result) : get the remainder from a division between
		// two floats
		// IREM (value1, value2 → result) : logical int remainder
		// LREM (value1, value2 → result) : remainder of division of two longs
	}

	String _THIS = "this";

	default void initObject(Type type) {
		ALOAD(type, _THIS);
		INVOKESPECIAL(Type.getType(Object.class), Type.VOID_TYPE, "<init>");
	}

	default void and(String value1, String value2) {
		load(value1);
		load(value2);
		AND();
	}

	default void AND() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		codeInst(type.getOpcode(IAND));
		// IAND (value1, value2 → result) : perform a bitwise and on two integers
		// LAND (value1, value2 → result) : bitwise and of two longs
	}

	default void or(String value1, String value2) {
		load(value1);
		load(value2);
		OR();
	}

	default void OR() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		codeInst(type.getOpcode(IOR));
		// IOR (value1, value2 → result) : bitwise int or
		// LOR (value1, value2 → result) : bitwise or of two longs
	}

	default void xor(String value1, String value2) {
		load(value1);
		load(value2);
		XOR();
	}

	default void XOR() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		codeInst(type.getOpcode(IXOR));

		// IXOR (value1, value2 → result) : int xor
		// LXOR (value1, value2 → result) : bitwise exclusive or of two longs
	}

	default void NEWARRAY(Type type) {
		Type count = codePopStack();
		assert in(count, Type.INT_TYPE, Type.BYTE_TYPE, Type.SHORT_TYPE) : "array count type " + type;
//		Type arrayref = Type.getType(Object.class); /* TODO */

		Type arrayType = arrayOf(type);
		codePush(arrayType);

		if (Type.BOOLEAN <= type.getSort() && type.getSort() <= Type.DOUBLE) codeTypeInsn(NEWARRAY, type);
		else if (type.getSort() == Type.ARRAY) codeTypeInsn(ANEWARRAY, type);
		else if (type.getSort() == Type.OBJECT) codeTypeInsn(ANEWARRAY, type);
		else if (type.getSort() == Type.VOID) RETURN();
		else
			throw new UnsupportedOperationException();

		// NEWARRAY (count → arrayref) : create new array with count elements of
		// primitive type identified by atype ANEWARRAY, CHECKCAST or INSTANCEOF
	}

	default void arraylength(String array) {
		load(array);
		ARRAYLENGTH();
	}

	@SuppressWarnings("unused")
	default void ARRAYLENGTH() {
		Type arrayref = codePopStack();
		Type length = Type.INT_TYPE;
		codeInst(ARRAYLENGTH);
		codePush(length);
		// ARRAYLENGTH (arrayref → length) : get the length of an array
	}

	default void arrayload(String arrayref, String index, Type valueType) {
		load(arrayref);
		load(index);
		opArrayload(valueType);
	}

	@SuppressWarnings("unused")
	default void opArrayload(Type value) {
		Type index = codePopStack();
		Type arrayref = codePopStack();
		codeInst(value.getOpcode(IALOAD));
		codePush(value);
		// AALOAD (arrayref, index → value) : load onto the stack a reference from an
		// array
		// BALOAD (arrayref, index → value) : load a byte or Boolean value from an array
		// CALOAD (arrayref, index → value) : load a char from an array
		// DALOAD (arrayref, index → value) : load a double from an array
		// FALOAD (arrayref, index → value) : load a float from an array
		// IALOAD (arrayref, index → value) : load an int from an array
		// LALOAD (arrayref, index → value) : load a long from an array
		// SALOAD (arrayref, index → value) : load short from array
	}

	default void arraystore(String arrayref, String index, String value) {
		load(arrayref);
		load(index);
		load(value);
		AASTORE();
	}

	@SuppressWarnings("unused")
	default void AASTORE() {
		Type value = codePopStack();
		Type index = codePopStack();
		Type arrayref = codePopStack();
		switch (value.getSort()) {

		// AASTORE (arrayref, index, value →) : store into a reference in an array
		case Type.OBJECT:
			codeInst(AASTORE);
			break;
		// BASTORE (arrayref, index, value →) : store a byte or Boolean value into an
		// array
		case Type.BYTE:
			codeInst(value.getOpcode(BASTORE));
			break;
		// CASTORE (arrayref, index, value →) : store a char into an array
		case Type.CHAR:
			codeInst(value.getOpcode(CASTORE));
			break;
		// DASTORE (arrayref, index, value →) : store a double into an array
		case Type.DOUBLE:
			codeInst(value.getOpcode(DASTORE));
			break;
		// FASTORE (arrayref, index, value →) : store a float in an array
		case Type.FLOAT:
			codeInst(value.getOpcode(FASTORE));
			break;
		// IASTORE (arrayref, index, value →) : store an int into an array
		case Type.INT:
			codeInst(value.getOpcode(IASTORE));
			break;
		// LASTORE (arrayref, index, value →) : store a long to an array
		case Type.LONG:
			codeInst(value.getOpcode(LASTORE));
			break;
		// SASTORE (arrayref, index, value →) : store short to array
		case Type.SHORT:
			codeInst(value.getOpcode(SASTORE));
			break;
		default:
			throw new UnsupportedOperationException();
		}

		// AASTORE (arrayref, index, value →) : store into a reference in an array
		// BASTORE (arrayref, index, value →) : store a byte or Boolean value into an
		// array
		// CASTORE (arrayref, index, value →) : store a char into an array
		// DASTORE (arrayref, index, value →) : store a double into an array
		// FASTORE (arrayref, index, value →) : store a float in an array
		// IASTORE (arrayref, index, value →) : store an int into an array
		// LASTORE (arrayref, index, value →) : store a long to an array
		// SASTORE (arrayref, index, value →) : store short to array
	}

	default void CHECKCAST(Type type) {
		Type objectref = codePopStack();
		codePush(objectref);
		codeTypeInsn(CHECKCAST, type);
		// CHECKCAST (objectref → objectref) : checks whether an objectref is of a
		// certain type, the class reference of which is in the constant pool
		// at index (indexbyte1 << 8 + indexbyte2)
	}

	abstract Type codeGetStack(int i);

	abstract void codeInst(int opcode);

	abstract void codeInst(int opcode, int index);

	abstract int codeLocalLoadAccess(String name);

	abstract Type codeLocalLoadAccessType(String name);

	abstract int codeLocalStoreAccess(String name);

	abstract Type codeLocalStoreAccessType(String name);

	abstract Type codePopStack();

	abstract void codePush(Type type);

	@Deprecated
	default void compare(String value1, String value2) {
		load(value1);
		load(value2);
		CMP();

	}

	@Deprecated
	@SuppressWarnings("unused")
	default void CMP() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = value1;
		codePush(result);
		// LCMP (value1, value2 → result) : compare two longs values
		// DCMPG (value1, value2 → result) : compare two doubles
		// FCMPG (value1, value2 → result) : compare two floats
		// DCMPL (value1, value2 → result) : compare two doubles
		// FCMPL (value1, value2 → result) : compare two floats
	}

	default void DUP() {
		Type value1 = codeGetStack(0);
		codePush(value1);
		codeInst(DUP);
		// DUP (value → value, value) : duplicate the value on top of the stack
	}

	default void dup2() {
		DUP2();
	}

	default void DUP2() {
		Type value2 = codeGetStack(-1);
		Type value1 = codeGetStack(0);
		codePush(value2);
		codePush(value1);
		codePush(value2);
		codePush(value1);
		codeInst(DUP2);
		// DUP2 ({value2, value1} → {value2, value1}, {value2, value1}) : duplicate top
		// two stack words (two values, if value1 is not double nor long; a single
		// value, if value1 is double or long)
	}

	default void getfield(String objectname, String fieldname, Type fieldType) {
		load(objectname);
		GETFIELD(fieldname, fieldType);
	}

	default void GETFIELD(String fieldname, Type fieldType) {
		Type objectref = codePopStack();
		codePush(fieldType);
		codeFieldInsn(GETFIELD, objectref, fieldname, fieldType);

		// GETFIELD (objectref → value) : get a field value of an object objectref,
		// where the field is identified by field reference in the constant
		// pool index (index1 << 8 + index2)
	}

	default void putfield(String objectref, String varname, String fieldname, Type fieldType) {
		load(objectref);
		load(varname);
		PUTFIELD(fieldname, fieldType);
	}

	default void putVarToThisField(String varname, String fieldname, Type fieldType) {
		loadThis();
		load(varname);
		PUTFIELD(fieldname, fieldType);
	}

	default void getThisFieldTo(String fieldname, Type fieldType, String varname) {
		loadThis();
		GETFIELD(fieldname, fieldType);
		STORE(varname);
	}

	@SuppressWarnings("unused")
	default void PUTFIELD(String fieldname, Type fieldType) {
		Type value = codePopStack();
		Type objectref = codePopStack();

		codeFieldInsn(PUTFIELD, objectref, fieldname, fieldType);

		// PUTFIELD (objectref, value →) : set field to value in an object objectref,
		// where the field is identified by a field reference index in constant pool
		// (indexbyte1 << 8 + indexbyte2)
	}

	default void getstatic(Type objectType, String fieldName, Type fieldType) {
		GETSTATIC(objectType, fieldName, fieldType);
	}

	default void GETSTATIC(Type objectType, String fieldName, Type fieldType) {
		codePush(fieldType);
		codeFieldInsn(GETSTATIC, objectType, fieldName, fieldType);
		// GETSTATIC (→ value) : get a static field value of a class, where the field is
		// identified by field reference in the constant pool index (index1 << 8 +
		// index2)
	}

	default void putstatic(Type objectType, String varname, String fieldname, Type fieldType) {
		load(varname);
		PUTSTATIC(objectType, fieldname, fieldType);
	}

	@SuppressWarnings("unused")
	default void PUTSTATIC(Type objectType, String fieldName, Type fieldType) {
		Type value = codePopStack();
		codeFieldInsn(PUTSTATIC, objectType, fieldName, fieldType);

		// PUTSTATIC (value →) : set static field to value in a class, where the field
		// is identified by a field reference index in constant pool (indexbyte1 << 8 +
		// indexbyte2)
	}

	@Deprecated
	default void iF(String value) {
		load(value);
		IF();

	}

	@Deprecated
	@SuppressWarnings("unused")
	default void IF() {
		Type value = codePopStack();
		// IFEQ (value →) : if value is 0, branch to instruction at branchoffset (signed
		// short constructed from unsigned bytesbranchbyte1 << 8 + branchbyte2)
		// IFGE (value →) : if value is greater than or equal to 0, branch to
		// instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IFGT (value →) : if value is greater than 0, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytes branchbyte1 <<
		// 8 + branchbyte2)
		// IFLE (value →) : if value is less than or equal to 0, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytes branchbyte1 <<
		// 8 + branchbyte2)
		// IFLT (value →) : if value is less than 0, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytes branchbyte1 <<
		// 8 + branchbyte2)
		// IFNE (value →) : if value is not 0, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytesbranchbyte1 << 8
		// + branchbyte2)
		// IFNONNULL (value →) : if value is not null, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytes branchbyte1 <<
		// 8 + branchbyte2)
		// IFNULL (value →) : if value is null, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytesbranchbyte1 << 8
		// + branchbyte2)
		// IF_ACMPEQ (value1, value2 →) : if references are equal, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytes branchbyte1 <<
		// 8 + branchbyte2)
		// IF_ACMPNE (value1, value2 →) : if references are not equal, branch to
		// instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPEQ (value1, value2 →) : if ints are equal, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytesbranchbyte1 << 8
		// + branchbyte2)
		// IF_ICMPGE (value1, value2 →) : if value1 is greater than or equal to value2,
		// branch to instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPGT (value1, value2 →) : if value1 is greater than value2, branch to
		// instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPLE (value1, value2 →) : if value1 is less than or equal to value2,
		// branch to instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPLT (value1, value2 →) : if value1 is less than value2, branch to
		// instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPNE (value1, value2 →) : if ints are not equal, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytes branchbyte1 <<
		// 8 + branchbyte2)
	}

	@Deprecated
	default void instanceOf(String objectref) {
		load(objectref);
		INSTANCEOF();
	}

	@SuppressWarnings("unused")
	default void INSTANCEOF() {
		Type objectref = codePopStack();
		Type result = Type.getType(Integer.class);
		codePush(result);
		codeInst(INSTANCEOF);
		// INSTANCEOF (objectref → result) : determines if an object objectref is of a
		// given type, identified by class reference index in constant pool (indexbyte1
		// << 8 + indexbyte2)
	}

	default void INVOKESTATIC(Class<?> objectType, String methodName, Class<?>... paramTypes) {
		INVOKESTATIC(typeOf(objectType), Type.VOID_TYPE, methodName, typeOf(paramTypes));
	}

	default void INVOKESTATIC(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKESTATIC(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@SuppressWarnings("unused")
	default void INVOKESTATIC(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			codePopStack();
		}
		visitInvoke(INVOKESTATIC, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);
		// INVOKESTATIC ([arg1, arg2, ...] →) : invoke a static method, where the method
		// is identified by method reference index in constant pool (indexbyte1 << 8 +
		// indexbyte2)

	}

	@SuppressWarnings("unused")
	default void INVOKEINTERFACE(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			codePopStack();
		}
		codePopStack(); // objectType
		visitInvoke(INVOKEINTERFACE, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);
		// INVOKEINTERFACE (objectref, [arg1, arg2, ...] →) : invokes an interface
		// method on object objectref, where the interface method is identified by
		// method reference index in constant pool (indexbyte1 << 8 + indexbyte2)

	}

	default void INVOKESPECIAL(Class<?> objectType, String methodName, Class<?>... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), null, methodName, typeOf(paramTypes));
	}

	default void INVOKESPECIAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@SuppressWarnings("unused")
	default void INVOKESPECIAL(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		if (returnType == null) returnType = Type.VOID_TYPE;
		for (Type type : paramTypes) {
			codePopStack();
		}
		codePopStack(); // objectType
		visitInvoke(INVOKESPECIAL, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);
		// INVOKESPECIAL (objectref, [arg1, arg2, ...] →) : invoke instance method on
		// object objectref, where the method is identified by method reference indexin
		// constant pool (indexbyte1 << 8 + indexbyte2)
	}

	@SuppressWarnings("unused")
	default void invokeVirtual_op(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			codePopStack();
		}
		codePopStack(); // objectType
		visitInvoke(INVOKEVIRTUAL, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);

	}

	@Deprecated
	@SuppressWarnings("unused")
	default void invoke_op(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			codePopStack();
		}
		if (opcode != INVOKESTATIC) codePopStack(); // objectType
		visitInvoke(opcode, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);

	}

	void visitInvoke(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes);

	default void loadThis() {
		load(_THIS);
	}

	default void loadThisField(String fieldname, Type feildtype) {
		loadThis();
		GETFIELD(fieldname, feildtype);
	}

	default void load(String name) {
		Type valueType = codeLocalLoadAccessType(name);
		switch (valueType.getSort()) {
		case Type.OBJECT:
			ALOAD(valueType, name);
			break;
		case Type.ARRAY:
			ALOAD(valueType, name);
			break;
		case Type.VOID:
			throw new UnsupportedOperationException("load VOID");
		default:
			LOAD(valueType, name);
			break;
		}
	}

	default void LOAD(Type value, String name) {
		codePush(value);
		codeInst(value.getOpcode(ILOAD), codeLocalLoadAccess(name));
		// DLOAD (→ value) : load a double value from a local variable #index
		// FLOAD (→ value) : load a float value from a local variable #index
		// ILOAD (→ value) : load an int value from a local variable #index
		// LLOAD (→ value) : load a long value from a local variable #index
		// DLOAD_0 (→ value) : load a double from local variable 0
		// FLOAD_0 (→ value) : load a float value from local variable 0
		// ILOAD_0 (→ value) : load an int value from local variable 0
		// LLOAD_0 (→ value) : load a long value from a local variable 0
		// DLOAD_1 (→ value) : load a double from local variable 1
		// FLOAD_1 (→ value) : load a float value from local variable 1
		// ILOAD_1 (→ value) : load an int value from local variable 1
		// LLOAD_1 (→ value) : load a long value from a local variable 1
		// DLOAD_2 (→ value) : load a double from local variable 2
		// FLOAD_2 (→ value) : load a float value from local variable 2
		// ILOAD_2 (→ value) : load an int value from local variable 2
		// LLOAD_2 (→ value) : load a long value from a local variable 2
		// DLOAD_3 (→ value) : load a double from local variable 3
		// FLOAD_3 (→ value) : load a float value from local variable 3
		// ILOAD_3 (→ value) : load an int value from local variable 3
		// LLOAD_3 (→ value) : load a long value from a local variable 3
	}

	default void aLoadObject(String name) {
		Type valueType = codeLocalLoadAccessType(name);
		ALOAD(valueType, name);
	}

	default void ALOAD(Type value, String name) {
		codePush(value);
		codeInst(ALOAD, codeLocalLoadAccess(name));
		// ALOAD (→ objectref) : load a reference onto the stack from a local
		// variable #index
		// ALOAD_0 (→ objectref) : load a reference onto the stack from local variable 0
		// ALOAD_1 (→ objectref) : load a reference onto the stack from local variable 1
		// ALOAD_2 (→ objectref) : load a reference onto the stack from local variable 2
		// ALOAD_3 (→ objectref) : load a reference onto the stack from local variable 3
	}

	default void STORE(String varname) {
		Type value = codeGetStack(0);
		switch (value.getSort()) {
		case Type.ARRAY:
			_ASTORE(varname);
			break;
		case Type.OBJECT:
			_ASTORE(varname);
			break;
		case Type.VOID:
			throw new UnsupportedOperationException();
		default:
			_ISTORE(varname);
			break;
		}
	}

	@Deprecated
	default void _ISTORE(String varname) {
		Type type = codePopStack();
		codeInst(type.getOpcode(ISTORE), codeLocalStoreAccess(varname));

		// DSTORE (value →) : store a double value into a local variable #index
		// FSTORE (value →) : store a float value into a local variable #index
		// ISTORE (value →) : store int value into variable #index
		// LSTORE (value →) : store a long value in a local variable #index
		// DSTORE_0 (value →) : store a double into local variable 0
		// FSTORE_0 (value →) : store a float value into local variable 0
		// ISTORE_0 (value →) : store int value into variable 0
		// LSTORE_0 (value →) : store a long value in a local variable 0
		// DSTORE_1 (value →) : store a double into local variable 1
		// FSTORE_1 (value →) : store a float value into local variable 1
		// ISTORE_1 (value →) : store int value into variable 1
		// LSTORE_1 (value →) : store a long value in a local variable 1
		// DSTORE_2 (value →) : store a double into local variable 2
		// FSTORE_2 (value →) : store a float value into local variable 2
		// ISTORE_2 (value →) : store int value into variable 2
		// LSTORE_2 (value →) : store a long value in a local variable 2
		// DSTORE_3 (value →) : store a double into local variable 3
		// FSTORE_3 (value →) : store a float value into local variable 3
		// ISTORE_3 (value →) : store int value into variable 3
		// LSTORE_3 (value →) : store a long value in a local variable 3
	}

	@Deprecated
	default void _ASTORE(String varname) {
		codePopStack();
		codeInst(ASTORE, codeLocalStoreAccess(varname));
		// ASTORE (objectref →) : store a reference into a local variable #index
		// ASTORE_0 (objectref →) : store a reference into local variable 0
		// ASTORE_1 (objectref →) : store a reference into local variable 1
		// ASTORE_2 (objectref →) : store a reference into local variable 2
		// ASTORE_3 (objectref →) : store a reference into local variable 3
	}

	default void store(String varname) {
		STORE(varname);
	}

	default Type mathInnerUserType(Type type) {
		switch (type.getSort()) {
		case Type.BYTE:
		case Type.CHAR:
		case Type.SHORT:
			return Type.INT_TYPE;
		default:
			break;
		}
		return type;
	}

	@Deprecated
	default void neg(String value) {
		load(value);
		NEG();

	}

	default void NEG() {
		Type value = codePopStack();
		Type result = value;
		codePush(result);
		codeInst(value.getOpcode(INEG));

		// DNEG (value → result) : negate a double
		// FNEG (value → result) : negate a float
		// INEG (value → result) : negate int
		// LNEG (value → result) : negate a long
	}

	/*
	 * {@link #VOID VOID}, {@link #BOOLEAN BOOLEAN}, {@link #CHAR CHAR}, {@link
	 * #BYTE BYTE}, {@link #SHORT SHORT}, {@link #INT INT}, {@link #FLOAT FLOAT},
	 * {@link #LONG LONG}, {@link #DOUBLE DOUBLE}, {@link #ARRAY ARRAY}, {@link
	 * #OBJECT OBJECT} or {@link #METHOD METHOD}.
	 */
	default void CONVERTTO(Type typeTo) {
		Type typeFrom = codePopStack();
		codePush(typeTo);

		switch (typeFrom.getSort()) {
		case Type.LONG:
			switch (typeTo.getSort()) {
			case Type.INT:
				codeInst(L2I);
				break;
			case Type.FLOAT:
				codeInst(L2F);
				break;
			case Type.DOUBLE:
				codeInst(L2D);
				break;

			default:
				break;
			}
			break;
		case Type.INT:
			switch (typeTo.getSort()) {
			case Type.SHORT:
				codeInst(I2S);
				break;
			case Type.LONG:
				codeInst(I2L);
				break;
			case Type.FLOAT:
				codeInst(I2F);
				break;
			case Type.DOUBLE:
				codeInst(I2D);
				break;
			case Type.CHAR:
				codeInst(I2C);
				break;
			case Type.BYTE:
				codeInst(I2B);
				break;

			default:
				throw new UnsupportedOperationException();
			}
			break;
		case Type.FLOAT:

			switch (typeTo.getSort()) {
			case Type.LONG:
				codeInst(F2L);
				break;
			case Type.INT:
				codeInst(F2I);
				break;
			case Type.DOUBLE:
				codeInst(F2D);
				break;

			default:
				throw new UnsupportedOperationException();
			}
			break;
		case Type.DOUBLE:
			switch (typeTo.getSort()) {
			case Type.LONG:
				codeInst(D2L);
				break;
			case Type.INT:
				codeInst(D2I);
				break;
			case Type.FLOAT:
				codeInst(D2F);
				break;

			default:
				throw new UnsupportedOperationException();
			}
			break;
		default:
			throw new UnsupportedOperationException();

		}

//		Type result = value;
//		codePush(result);
//		codeInst(value.getOpcode(INEG));

		// DNEG (value → result) : negate a double
		// FNEG (value → result) : negate a float
		// INEG (value → result) : negate int
		// LNEG (value → result) : negate a long
	}

//	i2b	convert an int into a byte
//	i2c	convert an int into a character
//	f2d	convert a float to a double
//	i2d	convert an int into a double
//	l2d	convert a long to a double
//	d2f	convert a double to a float
//	i2f	convert an int into a float
//	l2f	convert a long to a float
//	d2i	convert a double to an int
//	f2i	convert a float to an int
//	l2i	convert a long to a int
//	d2l	convert a double to a long
//	f2l	convert a float to a long
//	i2l	convert an int into a long
//	i2s	convert an int into a short

	void codeTypeInsn(int opcode, Type type);

	default void newarray(String count, Type type) {
		load(count);
		NEWARRAY(type);
	}

	public void codeFieldInsn(int opcode, Type ownerType, String name, Type fieldType);

	default void loadConstByte(int value) {
		codeIntInsn(BIPUSH, value);
		codePush(Type.BYTE_TYPE);
	}

	default void ldcShort(int value) {
		codeIntInsn(SIPUSH, value);
		codePush(Type.SHORT_TYPE);
	}

	/**
	 * Visits an instruction with a single int operand.
	 * 
	 * @param opcode  the opcode of the instruction to be visited. This opcode is
	 *                either BIPUSH, SIPUSH or NEWARRAY.
	 * @param operand the operand of the instruction to be visited.<br>
	 *                When opcode is BIPUSH, operand value should be between
	 *                Byte.MIN_VALUE and Byte.MAX_VALUE.<br>
	 *                When opcode is SIPUSH, operand value should be between
	 *                Short.MIN_VALUE and Short.MAX_VALUE.<br>
	 *                When opcode is NEWARRAY, operand value should be one of
	 *                {@link Opcodes#T_BOOLEAN}, {@link Opcodes#T_CHAR},
	 *                {@link Opcodes#T_FLOAT}, {@link Opcodes#T_DOUBLE},
	 *                {@link Opcodes#T_BYTE}, {@link Opcodes#T_SHORT},
	 *                {@link Opcodes#T_INT} or {@link Opcodes#T_LONG}.
	 */
	void codeIntInsn(int opcode, int operand);

	default void loadConst(Object cst) {

		if (cst instanceof Integer) {
			codeLdcInsn(cst);
			codePush(Type.getType(Integer.class));
		} else if (cst instanceof Float) {
			codeLdcInsn(cst);
			codePush(Type.getType(Float.class));
		} else if (cst instanceof Long) {
			int v = ((Long) cst).intValue();
			if (0L == v || 1L == v) {
				codeInst(LCONST_0 + v);
				codePush(Type.getType(Long.class));
			} else {

				codeLdcInsn(cst);
				codePush(Type.getType(Long.class));
			}
		} else if (cst instanceof Double) {
			codeLdcInsn(cst);
			codePush(Type.getType(Double.class));
		} else if (cst instanceof String) {
			codeLdcInsn(cst);
			codePush(Type.getType(String.class));
		} else if (cst instanceof Type) {
			int sort = ((Type) cst).getSort();
			if (sort == Type.OBJECT) {
				codeLdcInsn(cst);
				codePush(Type.getType(String.class));
			} else if (sort == Type.ARRAY) {
				throw new UnsupportedOperationException();
			} else if (sort == Type.METHOD) {
				throw new UnsupportedOperationException();
			} else {
				throw new UnsupportedOperationException();
			}
		} else if (cst instanceof Handle) {
			throw new UnsupportedOperationException();
		} else {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Visits a LDC instruction. Note that new constant types may be added in future
	 * versions of the Java Virtual Machine. To easily detect new constant types,
	 * implementations of this method should check for unexpected constant types,
	 * like this:
	 * 
	 * <pre>
	 * if (cst instanceof Integer) {
	 * 	// ...
	 * } else if (cst instanceof Float) {
	 * 	// ...
	 * } else if (cst instanceof Long) {
	 * 	// ...
	 * } else if (cst instanceof Double) {
	 * 	// ...
	 * } else if (cst instanceof String) {
	 * 	// ...
	 * } else if (cst instanceof Type) {
	 * 	int sort = ((Type) cst).getSort();
	 * 	if (sort == Type.OBJECT) {
	 * 		// ...
	 * 	} else if (sort == Type.ARRAY) {
	 * 		// ...
	 * 	} else if (sort == Type.METHOD) {
	 * 		// ...
	 * 	} else {
	 * 		// throw an exception
	 * 	}
	 * } else if (cst instanceof Handle) {
	 * 	// ...
	 * } else {
	 * 	// throw an exception
	 * }
	 * </pre>
	 * 
	 * @param cst the constant to be loaded on the stack. This parameter must be a
	 *            non null {@link Integer}, a {@link Float}, a {@link Long}, a
	 *            {@link Double}, a {@link String}, a {@link Type} of OBJECT or
	 *            ARRAY sort for <tt>.class</tt> constants, for classes whose
	 *            version is 49.0, a {@link Type} of METHOD sort or a {@link Handle}
	 *            for MethodType and MethodHandle constants, for classes whose
	 *            version is 51.0.
	 */
	void codeLdcInsn(Object cst);

	default void newobject(Type objectref) {
		NEW(objectref);
	}

	default void NEW(Type objectref) {
		codePush(objectref);
		codeTypeInsn(NEW, objectref);
		// NEW (→ objectref) : create new object of type identified by class reference
		// in constant pool index (indexbyte1 << 8 + indexbyte2)
	}

	default void nop() {
		NOP();
	}

	default void NOP() {
		codeInst(Opcodes.NOP);
		// NOP ([No change]) : perform no operation
	}

	default void pop() {
		POP();

	}

	@SuppressWarnings("unused")
	default void POP() {
		Type value1 = codePopStack();
		codeInst(POP);
		// POP (value →) : discard the top value on the stack
	}

	default void pop2() {
		POP2();

	}

	@SuppressWarnings("unused")
	default void POP2() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		codeInst(POP2);
		// POP2 ({value2, value1} →) : discard the top two values on the stack (or one
		// value, if it is a double or long)
	}

	default void returnObject(String objectref) {
		load(objectref);
		ARETURN();
	}

	default void returnTopObject() {
		ARETURN();
	}

	default void ret() {
		RETURN();
	}

	default void ret(String varname) {
		load(varname);
		Type type = codeGetStack(0);
		if (Type.BOOLEAN <= type.getSort() && type.getSort() <= Type.DOUBLE) IRETURN();
		else if (type.getSort() == Type.ARRAY) ARETURN();
		else if (type.getSort() == Type.OBJECT) ARETURN();
		else if (type.getSort() == Type.VOID) RETURN();
		else
			throw new UnsupportedOperationException();
	}

	default void retTop() {
		Type type = codeGetStack(0);
		if (Type.BOOLEAN <= type.getSort() && type.getSort() <= Type.DOUBLE) IRETURN();
		else if (type.getSort() == Type.OBJECT) ARETURN();
		else if (type.getSort() == Type.VOID) RETURN();
		else
			throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unused")
	default void ARETURN() {
		Type objectref = codePopStack();
		codeInst(ARETURN);
		// ARETURN (objectref → [empty]) : return a reference from a method
	}

	default void returnTopValue() {
		IRETURN();
	}

	default void IRETURN() {
		Type type = codePopStack();
		codeInst(type.getOpcode(IRETURN));
		// DRETURN (value → [empty]) : return a double from a method
		// FRETURN (value → [empty]) : return a float
		// IRETURN (value → [empty]) : return an integer from a method
		// LRETURN (value → [empty]) : return a long value
	}

	default void returnValue(String varname) {
		load(varname);
		IRETURN();
	}

	default void returnvoid() {
		RETURN();
	}

	// RETURN (→ [empty]) : return void from method
	default void RETURN() {
		codeInst(RETURN);
	}

	@Deprecated
	default void shl(String value1, String value2) {
		load(value1);
		load(value2);
		SHL();

	}

	@SuppressWarnings("unused")
	default void SHL() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = value1;
		codePush(result);
		codeInst(value1.getOpcode(ISHR));
		// ISHL (value1, value2 → result) : int shift left
		// LSHL (value1, value2 → result) : bitwise shift left of a
		// long value1 by value2 positions
	}

	@SuppressWarnings("unused")
	default void SHR() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = value1;
		codePush(result);
		codeInst(value1.getOpcode(ISHR));
		// ISHR (value1, value2 → result) : int arithmetic shift right
		// LSHR (value1, value2 → result) : bitwise shift right of a
		// long value1 by value2 positions
	}
}
