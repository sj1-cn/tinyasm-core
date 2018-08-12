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

	void mvInst(int opcode);

	void mvInst(int opcode, int index);

	void mvIntInsn(int opcode, int operand);

	void mvFieldInsn(int opcode, Type ownerType, String name, Type fieldType);

	void mvInvoke(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes);

	void mvLdcInsn(Object cst);

	void mvTypeInsn(int opcode, Type type);

	abstract int codeLocalLoadAccess(String name);

	abstract Type codeLocalLoadAccessType(String name);

	abstract int codeLocalStoreAccess(String name);

	abstract Type codeLocalStoreAccessType(String name);

	abstract Type codeGetStack(int i);

	abstract Type codePopStack();

	abstract void codePush(Type type);

	/** MATH **/
	default void ADD(String left, String right) {
		LOAD(left);
		LOAD(right);
		ADD();
	}

	default void ADD() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);

		mvInst(type.getOpcode(IADD));
		// DADD (left, right → result) : add two doubles
		// FADD (left, right → result) : add two floats
		// IADD (left, right → result) : add two ints
		// LADD (left, right → result) : add two longs
	}

	default void SUB(String left, String right) {
		LOAD(left);
		LOAD(right);
		SUB();
	}

	default void SUB() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(ISUB));
		// DSUB (left, right → result) : subtract a double from another
		// FSUB (left, right → result) : subtract two floats
		// ISUB (left, right → result) : int subtract
		// LSUB (left, right → result) : subtract two longs
	}

	default void MUL(String left, String right) {
		LOAD(left);
		LOAD(right);
		MUL();
	}

	default void MUL() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IMUL));
		// DMUL (left, right → result) : multiply two doubles
		// FMUL (left, right → result) : multiply two floats
		// IMUL (left, right → result) : multiply two integers
		// LMUL (left, right → result) : multiply two longs
	}

	default void DIV(String left, String right) {
		LOAD(left);
		LOAD(right);
		DIV();
	}

	default void DIV() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IDIV));
		// DDIV (left, right → result) : divide two doubles
		// FDIV (left, right → result) : divide two floats
		// IDIV (left, right → result) : divide two integers
		// LDIV (left, right → result) : divide two longs
	}

	default void REM(String left, String right) {
		LOAD(left);
		LOAD(right);
		REM();
	}

	default void REM() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IREM));
		// DREM (left, right → result) : get the remainder from a division between
		// two doubles
		// FREM (left, right → result) : get the remainder from a division between
		// two floats
		// IREM (left, right → result) : logical int remainder
		// LREM (left, right → result) : remainder of division of two longs
	}

	String _THIS = "this";

	default void INITObject() {
		LOADThis();
		INVOKESPECIAL(Type.getType(Object.class), Type.VOID_TYPE, "<init>");
	}

	default void AND(String left, String right) {
		LOAD(left);
		LOAD(right);
		AND();
	}

	default void AND() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IAND));
		// IAND (left, right → result) : perform a bitwise and on two integers
		// LAND (left, right → result) : bitwise and of two longs
	}

	default void OR(String left, String right) {
		LOAD(left);
		LOAD(right);
		OR();
	}

	default void OR() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IOR));
		// IOR (left, right → result) : bitwise int or
		// LOR (left, right → result) : bitwise or of two longs
	}

	default void XOR(String left, String right) {
		LOAD(left);
		LOAD(right);
		XOR();
	}

	default void XOR() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IXOR));

		// IXOR (left, right → result) : int xor
		// LXOR (left, right → result) : bitwise exclusive or of two longs
	}

	@Deprecated
	default void CMP(String left, String right) {
		LOAD(left);
		LOAD(right);
		CMP();
	}

	@Deprecated
	@SuppressWarnings("unused")
	default void CMP() {
		Type right = codePopStack();
		Type left = codePopStack();
		Type result = left;
		codePush(result);
		// LCMP (left, right → result) : compare two longs values
		// DCMPG (left, right → result) : compare two doubles
		// FCMPG (left, right → result) : compare two floats
		// DCMPL (left, right → result) : compare two doubles
		// FCMPL (left, right → result) : compare two floats
	}

	@SuppressWarnings("unused")
	default void SHL() {
		Type right = codePopStack();
		Type left = codePopStack();
		Type result = left;
		codePush(result);
		mvInst(left.getOpcode(ISHR));
		// ISHL (left, right → result) : int shift left
		// LSHL (left, right → result) : bitwise shift left of a
		// long left by right positions
	}

	@SuppressWarnings("unused")
	default void SHR() {
		Type right = codePopStack();
		Type left = codePopStack();
		Type result = left;
		codePush(result);
		mvInst(left.getOpcode(ISHR));
		// ISHR (left, right → result) : int arithmetic shift right
		// LSHR (left, right → result) : bitwise shift right of a
		// long left by right positions
	}

	default void NEG() {
		Type value = codePopStack();
		Type result = value;
		codePush(result);
		mvInst(value.getOpcode(INEG));

		// DNEG (value → result) : negate a double
		// FNEG (value → result) : negate a float
		// INEG (value → result) : negate int
		// LNEG (value → result) : negate a long
	}

	/** ARRAY **/
	default void NEWARRAY(String count, Type type) {
		LOAD(count);
		NEWARRAY(type);
	}

	default void NEWARRAY(Type type) {
		Type count = codePopStack();
		assert in(count, Type.INT_TYPE, Type.BYTE_TYPE, Type.SHORT_TYPE) : "array count type " + type;
//		Type arrayref = Type.getType(Object.class); /* TODO */

		Type arrayType = arrayOf(type);
		codePush(arrayType);

		if (Type.BOOLEAN <= type.getSort() && type.getSort() <= Type.DOUBLE) mvTypeInsn(NEWARRAY, type);
		else if (type.getSort() == Type.ARRAY) mvTypeInsn(ANEWARRAY, type);
		else if (type.getSort() == Type.OBJECT) mvTypeInsn(ANEWARRAY, type);
		else if (type.getSort() == Type.VOID) RETURN();
		else
			throw new UnsupportedOperationException();

		// NEWARRAY (count → arrayref) : create new array with count elements of
		// primitive type identified by atype ANEWARRAY, CHECKCAST or INSTANCEOF
	}

	default void ARRAYLENGTH(String array) {
		LOAD(array);
		ARRAYLENGTH();
	}

	@SuppressWarnings("unused")
	default void ARRAYLENGTH() {
		Type arrayref = codePopStack();
		Type length = Type.INT_TYPE;
		mvInst(ARRAYLENGTH);
		codePush(length);
		// ARRAYLENGTH (arrayref → length) : get the length of an array
	}

	default void ARRAYLOAD(String arrayref, String index, Type valueType) {
		LOAD(arrayref);
		LOAD(index);
		ARRAYLOAD(valueType);
	}

	@SuppressWarnings("unused")
	default void ARRAYLOAD(Type value) {
		Type index = codePopStack();
		Type arrayref = codePopStack();
		mvInst(value.getOpcode(IALOAD));
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

	default void ARRAYSTORE(String varArray, String index, String value) {
		LOAD(varArray);
		LOAD(index);
		LOAD(value);
		ARRAYSTORE();
	}

	@SuppressWarnings("unused")
	default void ARRAYSTORE() {
		Type value = codePopStack();
		Type index = codePopStack();
		Type arrayref = codePopStack();
		switch (value.getSort()) {

		// AASTORE (arrayref, index, value →) : store into a reference in an array
		case Type.OBJECT:
			mvInst(AASTORE);
			break;
		// BASTORE (arrayref, index, value →) : store a byte or Boolean value into an
		// array
		case Type.BYTE:
			mvInst(value.getOpcode(BASTORE));
			break;
		// CASTORE (arrayref, index, value →) : store a char into an array
		case Type.CHAR:
			mvInst(value.getOpcode(CASTORE));
			break;
		// DASTORE (arrayref, index, value →) : store a double into an array
		case Type.DOUBLE:
			mvInst(value.getOpcode(DASTORE));
			break;
		// FASTORE (arrayref, index, value →) : store a float in an array
		case Type.FLOAT:
			mvInst(value.getOpcode(FASTORE));
			break;
		// IASTORE (arrayref, index, value →) : store an int into an array
		case Type.INT:
			mvInst(value.getOpcode(IASTORE));
			break;
		// LASTORE (arrayref, index, value →) : store a long to an array
		case Type.LONG:
			mvInst(value.getOpcode(LASTORE));
			break;
		// SASTORE (arrayref, index, value →) : store short to array
		case Type.SHORT:
			mvInst(value.getOpcode(SASTORE));
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
	default void NEW(Type objectref) {
		codePush(objectref);
		mvTypeInsn(NEW, objectref);
		// NEW (→ objectref) : create new object of type identified by class reference
		// in constant pool index (indexbyte1 << 8 + indexbyte2)
	}

	default void CHECKCAST(Type type) {
		Type objectref = codePopStack();
		codePush(objectref);
		mvTypeInsn(CHECKCAST, type);
		// CHECKCAST (objectref → objectref) : checks whether an objectref is of a
		// certain type, the class reference of which is in the constant pool
		// at index (indexbyte1 << 8 + indexbyte2)
	}

	@SuppressWarnings("unused")
	default void INSTANCEOF(Type type) {
		Type objectref = codePopStack();
		Type result = Type.getType(Integer.class);
		codePush(result);
		mvTypeInsn(INSTANCEOF, type);
		// INSTANCEOF (objectref → result) : determines if an object objectref is of a
		// given type, identified by class reference index in constant pool (indexbyte1
		// << 8 + indexbyte2)
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
				mvInst(L2I);
				break;
			case Type.FLOAT:
				mvInst(L2F);
				break;
			case Type.DOUBLE:
				mvInst(L2D);
				break;

			default:
				break;
			}
			break;
		case Type.INT:
			switch (typeTo.getSort()) {
			case Type.SHORT:
				mvInst(I2S);
				break;
			case Type.LONG:
				mvInst(I2L);
				break;
			case Type.FLOAT:
				mvInst(I2F);
				break;
			case Type.DOUBLE:
				mvInst(I2D);
				break;
			case Type.CHAR:
				mvInst(I2C);
				break;
			case Type.BYTE:
				mvInst(I2B);
				break;

			default:
				throw new UnsupportedOperationException();
			}
			break;
		case Type.FLOAT:

			switch (typeTo.getSort()) {
			case Type.LONG:
				mvInst(F2L);
				break;
			case Type.INT:
				mvInst(F2I);
				break;
			case Type.DOUBLE:
				mvInst(F2D);
				break;

			default:
				throw new UnsupportedOperationException();
			}
			break;
		case Type.DOUBLE:
			switch (typeTo.getSort()) {
			case Type.LONG:
				mvInst(D2L);
				break;
			case Type.INT:
				mvInst(D2I);
				break;
			case Type.FLOAT:
				mvInst(D2F);
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

	/** ARRAY **/
	default void GETFIELD(String objectname, String fieldname, Type fieldType) {
		LOAD(objectname);
		GETFIELD(fieldname, fieldType);
	}

	default void GETFIELD(String fieldname, Type fieldType) {
		Type objectref = codePopStack();
		codePush(fieldType);
		mvFieldInsn(GETFIELD, objectref, fieldname, fieldType);

		// GETFIELD (objectref → value) : get a field value of an object objectref,
		// where the field is identified by field reference in the constant
		// pool index (index1 << 8 + index2)
	}

	default void putVarToThisField(String varname, String fieldname, Type fieldType) {
		LOADThis();
		LOAD(varname);
		PUTFIELD(fieldname, fieldType);
	}

	default void getThisFieldTo(String fieldname, Type fieldType, String varname) {
		LOADThis();
		GETFIELD(fieldname, fieldType);
		STORE(varname);
	}

	default void PUTFIELD(String objectref, String varname, String fieldname, Type fieldType) {
		LOAD(objectref);
		LOAD(varname);
		PUTFIELD(fieldname, fieldType);
	}

	@SuppressWarnings("unused")
	default void PUTFIELD(String fieldname, Type fieldType) {
		Type value = codePopStack();
		Type objectref = codePopStack();

		mvFieldInsn(PUTFIELD, objectref, fieldname, fieldType);

		// PUTFIELD (objectref, value →) : set field to value in an object objectref,
		// where the field is identified by a field reference index in constant pool
		// (indexbyte1 << 8 + indexbyte2)
	}

	default void GETSTATIC(Type objectType, String fieldName, Type fieldType) {
		codePush(fieldType);
		mvFieldInsn(GETSTATIC, objectType, fieldName, fieldType);
		// GETSTATIC (→ value) : get a static field value of a class, where the field is
		// identified by field reference in the constant pool index (index1 << 8 +
		// index2)
	}

	default void PUTSTATIC(Type objectType, String varname, String fieldname, Type fieldType) {
		LOAD(varname);
		PUTSTATIC(objectType, fieldname, fieldType);
	}

	@SuppressWarnings("unused")
	default void PUTSTATIC(Type objectType, String fieldName, Type fieldType) {
		Type value = codePopStack();
		mvFieldInsn(PUTSTATIC, objectType, fieldName, fieldType);

		// PUTSTATIC (value →) : set static field to value in a class, where the field
		// is identified by a field reference index in constant pool (indexbyte1 << 8 +
		// indexbyte2)
	}

	@Deprecated
	default void iF(String value) {
		LOAD(value);
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
		// IF_ACMPEQ (left, right →) : if references are equal, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytes branchbyte1 <<
		// 8 + branchbyte2)
		// IF_ACMPNE (left, right →) : if references are not equal, branch to
		// instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPEQ (left, right →) : if ints are equal, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytesbranchbyte1 << 8
		// + branchbyte2)
		// IF_ICMPGE (left, right →) : if left is greater than or equal to right,
		// branch to instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPGT (left, right →) : if left is greater than right, branch to
		// instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPLE (left, right →) : if left is less than or equal to right,
		// branch to instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPLT (left, right →) : if left is less than right, branch to
		// instruction at branchoffset (signed short constructed from unsigned
		// bytes branchbyte1 << 8 + branchbyte2)
		// IF_ICMPNE (left, right →) : if ints are not equal, branch to instruction
		// at branchoffset (signed short constructed from unsigned bytes branchbyte1 <<
		// 8 + branchbyte2)
	}

	/** INVOKE **/
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
		mvInvoke(INVOKESTATIC, objectType, returnType, methodName, paramTypes);
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
		mvInvoke(INVOKEINTERFACE, objectType, returnType, methodName, paramTypes);
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
		mvInvoke(INVOKESPECIAL, objectType, returnType, methodName, paramTypes);
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
		mvInvoke(INVOKEVIRTUAL, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);

	}

	@Deprecated
	@SuppressWarnings("unused")
	default void invoke_op(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			codePopStack();
		}
		if (opcode != INVOKESTATIC) codePopStack(); // objectType
		mvInvoke(opcode, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);

	}

	default void LOADThis() {
		LOAD(_THIS);
	}

	default void LOADThisField(String fieldname, Type feildtype) {
		LOADThis();
		GETFIELD(fieldname, feildtype);
	}

	default void LOAD(String name) {
		Type valueType = codeLocalLoadAccessType(name);
		switch (valueType.getSort()) {
		case Type.OBJECT:
		case Type.ARRAY:
			codePush(valueType);
			mvInst(ALOAD, codeLocalLoadAccess(name));
			// ALOAD (→ objectref) : load a reference onto the stack from a local
			// variable #index
			// ALOAD_0 (→ objectref) : load a reference onto the stack from local variable 0
			// ALOAD_1 (→ objectref) : load a reference onto the stack from local variable 1
			// ALOAD_2 (→ objectref) : load a reference onto the stack from local variable 2
			// ALOAD_3 (→ objectref) : load a reference onto the stack from local variable 3
			break;
		case Type.VOID:
			throw new UnsupportedOperationException("load VOID");
		default:
			codePush(valueType);
			mvInst(valueType.getOpcode(ILOAD), codeLocalLoadAccess(name));
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
			break;
		}
	}

	default void STORE(String varname) {
		Type value = codeGetStack(0);
		switch (value.getSort()) {
		case Type.ARRAY:
			codePopStack();
			mvInst(ASTORE, codeLocalStoreAccess(varname));
			// ASTORE (objectref →) : store a reference into a local variable #index
			// ASTORE_0 (objectref →) : store a reference into local variable 0
			// ASTORE_1 (objectref →) : store a reference into local variable 1
			// ASTORE_2 (objectref →) : store a reference into local variable 2
			// ASTORE_3 (objectref →) : store a reference into local variable 3
			break;
		case Type.OBJECT:
			codePopStack();
			mvInst(ASTORE, codeLocalStoreAccess(varname));
			// ASTORE (objectref →) : store a reference into a local variable #index
			// ASTORE_0 (objectref →) : store a reference into local variable 0
			// ASTORE_1 (objectref →) : store a reference into local variable 1
			// ASTORE_2 (objectref →) : store a reference into local variable 2
			// ASTORE_3 (objectref →) : store a reference into local variable 3
			break;
		case Type.VOID:
			throw new UnsupportedOperationException();
		default:
			Type type = codePopStack();
			mvInst(type.getOpcode(ISTORE), codeLocalStoreAccess(varname));

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
			break;
		}
	}

	default void LOADConstByte(int value) {
		mvIntInsn(BIPUSH, value);
		codePush(Type.BYTE_TYPE);
	}

	default void LOADConstShort(int value) {
		mvIntInsn(SIPUSH, value);
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

	default void LOADConst(Object cst) {

		if (cst instanceof Integer) {
			mvLdcInsn(cst);
			codePush(Type.getType(Integer.class));
		} else if (cst instanceof Float) {
			mvLdcInsn(cst);
			codePush(Type.getType(Float.class));
		} else if (cst instanceof Long) {
			int v = ((Long) cst).intValue();
			if (0L == v || 1L == v) {
				mvInst(LCONST_0 + v);
				codePush(Type.getType(Long.class));
			} else {

				mvLdcInsn(cst);
				codePush(Type.getType(Long.class));
			}
		} else if (cst instanceof Double) {
			mvLdcInsn(cst);
			codePush(Type.getType(Double.class));
		} else if (cst instanceof String) {
			mvLdcInsn(cst);
			codePush(Type.getType(String.class));
		} else if (cst instanceof Type) {
			int sort = ((Type) cst).getSort();
			if (sort == Type.OBJECT) {
				mvLdcInsn(cst);
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

	/** STACK **/
	default void NOP() {
		mvInst(Opcodes.NOP);
		// NOP ([No change]) : perform no operation
	}

	@SuppressWarnings("unused")
	default void POP() {
		Type left = codePopStack();
		mvInst(POP);
		// POP (value →) : discard the top value on the stack
	}

	default void DUP() {
		Type left = codeGetStack(0);
		codePush(left);
		mvInst(DUP);
		// DUP (value → value, value) : duplicate the value on top of the stack
	}

	default void DUP2() {
		Type right = codeGetStack(-1);
		Type left = codeGetStack(0);
		codePush(right);
		codePush(left);
		codePush(right);
		codePush(left);
		mvInst(DUP2);
		// DUP2 ({right, left} → {right, left}, {right, left}) : duplicate top
		// two stack words (two values, if left is not double nor long; a single
		// value, if left is double or long)
	}

	@SuppressWarnings("unused")
	default void POP2() {
		Type right = codePopStack();
		Type left = codePopStack();
		mvInst(POP2);
		// POP2 ({right, left} →) : discard the top two values on the stack (or one
		// value, if it is a double or long)
	}

	// RETURN (→ [empty]) : return void from method
	default void RETURN() {
		mvInst(RETURN);
	}

	default void RETURN(String varname) {
		LOAD(varname);
		RETURNTop();
	}

	default void RETURNTop() {
		Type type = codeGetStack(0);
		if (Type.BOOLEAN <= type.getSort() && type.getSort() <= Type.DOUBLE) {
			Type objectref = codePopStack();
			mvInst(objectref.getOpcode(IRETURN));
			// DRETURN (value → [empty]) : return a double from a method
			// FRETURN (value → [empty]) : return a float
			// IRETURN (value → [empty]) : return an integer from a method
			// LRETURN (value → [empty]) : return a long value
		} else if (type.getSort() == Type.OBJECT) {
			// ARETURN (objectref → [empty]) : return a reference from a method
			codePopStack();
			mvInst(ARETURN);
		} else if (type.getSort() == Type.ARRAY) {
			// ARETURN (objectref → [empty]) : return a reference from a method
			codePopStack();
			mvInst(ARETURN);
		} else
			throw new UnsupportedOperationException();
	}

}
