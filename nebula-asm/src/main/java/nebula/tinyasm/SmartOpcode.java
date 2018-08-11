package nebula.tinyasm;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Opcodes.ARRAYLENGTH;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.DUP2;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
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
import static org.objectweb.asm.Opcodes.LASTORE;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.POP;
import static org.objectweb.asm.Opcodes.POP2;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public interface SmartOpcode {
	default void add(String value1, String value2) {
		load(value1);
		load(value2);
		add_op();

	}

	@SuppressWarnings("unused")
	default void add_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = realUseType(value1);
		codePush(result);
		codeInst(value1.getOpcode(IADD));
		// DADD (value1, value2 → result) : add two doubles
		// FADD (value1, value2 → result) : add two floats
		// IADD (value1, value2 → result) : add two ints
		// LADD (value1, value2 → result) : add two longs
	}

	default void mul(String value1, String value2) {
		load(value1);
		load(value2);
		mul_op();
	}

	@SuppressWarnings("unused")
	default void mul_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = realUseType(value1);
		codePush(result);
		codeInst(value1.getOpcode(IMUL));
		// DMUL (value1, value2 → result) : multiply two doubles
		// FMUL (value1, value2 → result) : multiply two floats
		// IMUL (value1, value2 → result) : multiply two integers
		// LMUL (value1, value2 → result) : multiply two longs
	}

	default void sub(String value1, String value2) {
		load(value1);
		load(value2);
		sub_op();
	}

	@SuppressWarnings("unused")
	default void sub_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = realUseType(value1);
		codePush(result);
		codeInst(value1.getOpcode(ISUB));
		// DSUB (value1, value2 → result) : subtract a double from another
		// FSUB (value1, value2 → result) : subtract two floats
		// ISUB (value1, value2 → result) : int subtract
		// LSUB (value1, value2 → result) : subtract two longs
	}

	default void div(String value1, String value2) {
		load(value1);
		load(value2);
		div_op();
	}

	@SuppressWarnings("unused")
	default void div_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = realUseType(value1);
		codePush(result);
		codeInst(value1.getOpcode(IDIV));
		// DDIV (value1, value2 → result) : divide two doubles
		// FDIV (value1, value2 → result) : divide two floats
		// IDIV (value1, value2 → result) : divide two integers
		// LDIV (value1, value2 → result) : divide two longs
	}

	default void rem(String value1, String value2) {
		load(value1);
		load(value2);
		rem_op();
	}

	@SuppressWarnings("unused")
	default void rem_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = realUseType(value1);
		codePush(result);
		codeInst(value1.getOpcode(IREM));
		// DREM (value1, value2 → result) : get the remainder from a division between
		// two doubles
		// FREM (value1, value2 → result) : get the remainder from a division between
		// two floats
		// IREM (value1, value2 → result) : logical int remainder
		// LREM (value1, value2 → result) : remainder of division of two longs
	}

	default void and(String value1, String value2) {
		load(value1);
		load(value2);
		and_op();
	}

	String _THIS = "this";

	default void initObject(Type type) {
		aLoadObject_op(type, _THIS);
		invokeSpecial_op(Type.getType(Object.class), Type.VOID_TYPE, "<init>");
	}

	@SuppressWarnings("unused")
	default void and_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = value1;
		codeInst(value1.getOpcode(IAND));
		codePush(result);
		// IAND (value1, value2 → result) : perform a bitwise and on two integers
		// LAND (value1, value2 → result) : bitwise and of two longs
	}

	default void arraylength(String array) {
		load(array);
		arraylength_op();
	}

	@SuppressWarnings("unused")
	default void arraylength_op() {
		Type arrayref = codePopStack();
		Type length = Type.getType(Integer.class);
		codeInst(ARRAYLENGTH);
		codePush(length);
		// ARRAYLENGTH (arrayref → length) : get the length of an array
	}

	default void arrayload(String arrayref, String index, Type valueType) {
		load(arrayref);
		load(index);
		arrayload_op(valueType);
	}

	@SuppressWarnings("unused")
	default void arrayload_op(Type value) {
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
		arraystore_op();
	}

	@SuppressWarnings("unused")
	default void arraystore_op() {
		Type value = codePopStack();
		Type index = codePopStack();
		Type arrayref = codePopStack();
		codeInst(value.getOpcode(LASTORE));

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

	@Deprecated
	default void checkcast(String objectref) {
		load(objectref);
		checkcast_op();
	}

	@Deprecated
	default void checkcast_op() {
		Type objectref = codePopStack();
		codeInst(CHECKCAST);
		codePush(objectref);
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
		compare_op();

	}

	@Deprecated
	@SuppressWarnings("unused")
	default void compare_op() {
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

	default void dup() {
		dup_op();
	}

	default void dup_op() {
		Type value1 = codeGetStack(0);
		codePush(value1);
		codeInst(DUP);
		// DUP (value → value, value) : duplicate the value on top of the stack
	}

	default void dup2() {
		dup2_op();
	}

	default void dup2_op() {
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
		getfield_op(fieldname, fieldType);
	}

	default void getfield_op(String fieldname, Type fieldType) {
		Type objectref = codePopStack();
		codePush(fieldType);
		visitFieldInsn(GETFIELD, objectref, fieldname, fieldType);

		// GETFIELD (objectref → value) : get a field value of an object objectref,
		// where the field is identified by field reference in the constant
		// pool index (index1 << 8 + index2)
	}

	default void putfield(String objectref, String varname, String fieldname, Type fieldType) {
		load(objectref);
		load(varname);
		putfield_op(fieldname, fieldType);
	}

	@SuppressWarnings("unused")
	default void putfield_op(String fieldname, Type fieldType) {
		Type value = codePopStack();
		Type objectref = codePopStack();

		visitFieldInsn(PUTFIELD, objectref, fieldname, fieldType);

		// PUTFIELD (objectref, value →) : set field to value in an object objectref,
		// where the field is identified by a field reference index in constant pool
		// (indexbyte1 << 8 + indexbyte2)
	}

	default void getstatic(Type objectType, String fieldName, Type fieldType) {
		getstatic_op(objectType, fieldName, fieldType);
	}

	default void getstatic_op(Type objectType, String fieldName, Type fieldType) {
		codePush(fieldType);
		visitFieldInsn(GETSTATIC, objectType, fieldName, fieldType);
		// GETSTATIC (→ value) : get a static field value of a class, where the field is
		// identified by field reference in the constant pool index (index1 << 8 +
		// index2)
	}

	default void putstatic(Type objectType, String varname, String fieldname, Type fieldType) {
		load(varname);
		putstatic_op(objectType, fieldname, fieldType);
	}

	@SuppressWarnings("unused")
	default void putstatic_op(Type objectType, String fieldName, Type fieldType) {
		Type value = codePopStack();
		visitFieldInsn(PUTFIELD, objectType, fieldName, fieldType);

		// PUTSTATIC (value →) : set static field to value in a class, where the field
		// is identified by a field reference index in constant pool (indexbyte1 << 8 +
		// indexbyte2)
	}

	@Deprecated
	default void iF(String value) {
		load(value);
		iF_op();

	}

	@Deprecated
	@SuppressWarnings("unused")
	default void iF_op() {
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
		instanceOf_op();
	}

	@SuppressWarnings("unused")
	default void instanceOf_op() {
		Type objectref = codePopStack();
		Type result = Type.getType(Integer.class);
		codePush(result);
		codeInst(INSTANCEOF);
		// INSTANCEOF (objectref → result) : determines if an object objectref is of a
		// given type, identified by class reference index in constant pool (indexbyte1
		// << 8 + indexbyte2)
	}

	@SuppressWarnings("unused")
	default void invokeStataic_op(Type objectType, Type returnType, String methodName, Type... paramTypes) {
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
	default void invokeInterface_op(Type objectType, Type returnType, String methodName, Type... paramTypes) {
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

	@SuppressWarnings("unused")
	default void invokeSpecial_op(Type objectType, Type returnType, String methodName, Type... paramTypes) {
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

	@Deprecated
	@SuppressWarnings("unused")
	default void invokeVirtual_op(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			codePopStack();
		}
		codePopStack(); // objectType
		visitInvoke(INVOKEVIRTUAL, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);

	}

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

	@Deprecated
	default void ldc() {
		ldc_op();
	}

	@Deprecated
	default void ldc_op() {
//		push(value);
		// LDC (→ value) : push a constant #index from a constant pool (String, int or
		// float) onto the stack
	}

	@Deprecated
	default void loadConst() {
		loadConst_op();

	}

	@Deprecated
	default void loadConst_op() {
		// ICONST_0 (→ 0) : load the int value 0 onto the stack
		// DCONST_0 (→ 0.0) : push the constant 0.0 onto the stack
		// FCONST_0 (→ 0.0f) : push 0.0f on the stack
		// LCONST_0 (→ 0L) : push the long 0 onto the stack
		// ICONST_1 (→ 1) : load the int value 1 onto the stack
		// ICONST_M1 (→ -1) : load the int value -1 onto the stack
		// DCONST_1 (→ 1.0) : push the constant 1.0 onto the stack
		// FCONST_1 (→ 1.0f) : push 1.0f on the stack
		// LCONST_1 (→ 1L) : push the long 1 onto the stack
		// ICONST_2 (→ 2) : load the int value 2 onto the stack
		// FCONST_2 (→ 2.0f) : push 2.0f on the stack
		// ICONST_3 (→ 3) : load the int value 3 onto the stack
		// ICONST_4 (→ 4) : load the int value 4 onto the stack
		// ICONST_5 (→ 5) : load the int value 5 onto the stack
	}

	default void load(String name) {
		Type valueType = codeLocalLoadAccessType(name);
		switch (valueType.getSort()) {
		case Type.OBJECT:
			aLoadObject_op(valueType, name);
			break;
		case Type.ARRAY:
			throw new UnsupportedOperationException("load ARRAY");
		case Type.VOID:
			throw new UnsupportedOperationException("load VOID");
		default:
			load_op(valueType, name);
			break;
		}
	}

	default void load_op(Type value, String name) {
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
		aLoadObject_op(valueType, name);
	}

	default void aLoadObject_op(Type value, String name) {
		codePush(value);
		codeInst(ALOAD, codeLocalLoadAccess(name));
		// ALOAD (→ objectref) : load a reference onto the stack from a local
		// variable #index
		// ALOAD_0 (→ objectref) : load a reference onto the stack from local variable 0
		// ALOAD_1 (→ objectref) : load a reference onto the stack from local variable 1
		// ALOAD_2 (→ objectref) : load a reference onto the stack from local variable 2
		// ALOAD_3 (→ objectref) : load a reference onto the stack from local variable 3
	}

	default void store_op(String name) {
		Type value = codePopStack();
		switch (value.getSort()) {
		case Type.ARRAY:

			break;
		case Type.OBJECT:
			codeInst(ASTORE, codeLocalStoreAccess(name));
			break;
		case Type.VOID:

			break;

		default:
			codeInst(value.getOpcode(ISTORE), codeLocalStoreAccess(name));
			break;
		}
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

	@SuppressWarnings("unused")
	default void storeObject_op(String name) {
		Type objectref = codePopStack();
		codeInst(ASTORE, codeLocalStoreAccess(name));
		// ASTORE (objectref →) : store a reference into a local variable #index
		// ASTORE_0 (objectref →) : store a reference into local variable 0
		// ASTORE_1 (objectref →) : store a reference into local variable 1
		// ASTORE_2 (objectref →) : store a reference into local variable 2
		// ASTORE_3 (objectref →) : store a reference into local variable 3
	}

	default void storeTo(String value) {
		store_op(value);
	}

	default Type realUseType(Type type) {
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
		neg_op();

	}

	default void neg_op() {
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
	default void convert_op(Type typeTo) {
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

	public void visitTypeInsn(int opcode, Type type);

	@Deprecated
	default void newarray(String count) {
		load(count);
		newarray_op();
	}

	public void visitFieldInsn(int opcode, Type ownerType, String name, Type fieldType);

	@Deprecated
	default void newarray_op() {
//		Type count = codePopStack();
//		Type arrayref = Type.getType(Object.class); /* TODO */
//		codePush(arrayref);
//		visitTypeInsn(NEWARRAY, type);
		// NEWARRAY (count → arrayref) : create new array with count elements of
		// primitive type identified by atype ANEWARRAY, CHECKCAST or INSTANCEOF
	}

	default void newobject(Type objectref) {
		newobject_op(objectref);
	}

	default void newobject_op(Type objectref) {
		codePush(objectref);
		codeInst(NEW);
		visitTypeInsn(NEW, objectref);
		// NEW (→ objectref) : create new object of type identified by class reference
		// in constant pool index (indexbyte1 << 8 + indexbyte2)
	}

	default void nop() {
		nop_op();
	}

	default void nop_op() {
		codeInst(Opcodes.NOP);
		// NOP ([No change]) : perform no operation
	}

	default void or(String value1, String value2) {
		load(value1);
		load(value2);
		or_op();
	}

	@SuppressWarnings("unused")
	default void or_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = value1;
		codePush(result);
		codeInst(value1.getOpcode(IOR));
		// IOR (value1, value2 → result) : bitwise int or
		// LOR (value1, value2 → result) : bitwise or of two longs
	}

	default void pop() {
		pop_op();

	}

	@SuppressWarnings("unused")
	default void pop_op() {
		Type value1 = codePopStack();
		codeInst(POP);
		// POP (value →) : discard the top value on the stack
	}

	default void pop2() {
		pop2_op();

	}

	@SuppressWarnings("unused")
	default void pop2_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		codeInst(POP2);
		// POP2 ({value2, value1} →) : discard the top two values on the stack (or one
		// value, if it is a double or long)
	}

	default void returnObject(String objectref) {
		load(objectref);
		returnTopObject_op();
	}

	default void returnTopObject() {
		returnTopObject_op();
	}

	@SuppressWarnings("unused")
	default void returnTopObject_op() {
		Type objectref = codePopStack();
		codeInst(ARETURN);
		// ARETURN (objectref → [empty]) : return a reference from a method
	}

	default void returnTopValue() {
		returnTopValue_op();
	}

	default void returnTopValue_op() {
		Type type = codePopStack();
		codeInst(type.getOpcode(IRETURN));
		// DRETURN (value → [empty]) : return a double from a method
		// FRETURN (value → [empty]) : return a float
		// IRETURN (value → [empty]) : return an integer from a method
		// LRETURN (value → [empty]) : return a long value
	}

	default void returnValue(String varname) {
		load(varname);
		returnTopValue_op();
	}

	default void returnvoid() {
		returnvoid_op();
	}

	default void returnvoid_op() {
		codeInst(RETURN);
		// RETURN (→ [empty]) : return void from method
	}

	@Deprecated
	default void shl(String value1, String value2) {
		load(value1);
		load(value2);
		shl_op();

	}

	@SuppressWarnings("unused")
	default void shl_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = value1;
		codePush(result);
		codeInst(value1.getOpcode(ISHR));
		// ISHL (value1, value2 → result) : int shift left
		// LSHL (value1, value2 → result) : bitwise shift left of a
		// long value1 by value2 positions
		// ISHR (value1, value2 → result) : int arithmetic shift right
		// LSHR (value1, value2 → result) : bitwise shift right of a
		// long value1 by value2 positions
	}

	default void xor(String value1, String value2) {
		load(value1);
		load(value2);
		xor_op();
	}

	@SuppressWarnings("unused")
	default void xor_op() {
		Type value2 = codePopStack();
		Type value1 = codePopStack();
		Type result = value1;
		codePush(result);
		codeInst(value1.getOpcode(IXOR));

		// IXOR (value1, value2 → result) : int xor
		// LXOR (value1, value2 → result) : bitwise exclusive or of two longs
	}
}
