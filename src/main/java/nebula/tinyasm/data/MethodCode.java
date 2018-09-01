package nebula.tinyasm.data;

import static nebula.tinyasm.util.TypeUtils.arrayOf;
import static nebula.tinyasm.util.TypeUtils.arrayTyoeCodeOf;
import static nebula.tinyasm.util.TypeUtils.checkMathTypes;
import static nebula.tinyasm.util.TypeUtils.in;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.AASTORE;
import static org.objectweb.asm.Opcodes.ACONST_NULL;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.ARRAYLENGTH;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.ATHROW;
import static org.objectweb.asm.Opcodes.BIPUSH;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.D2F;
import static org.objectweb.asm.Opcodes.D2I;
import static org.objectweb.asm.Opcodes.D2L;
import static org.objectweb.asm.Opcodes.DCMPG;
import static org.objectweb.asm.Opcodes.DCMPL;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.DUP2;
import static org.objectweb.asm.Opcodes.F2D;
import static org.objectweb.asm.Opcodes.F2I;
import static org.objectweb.asm.Opcodes.F2L;
import static org.objectweb.asm.Opcodes.FCMPG;
import static org.objectweb.asm.Opcodes.FCMPL;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.I2B;
import static org.objectweb.asm.Opcodes.I2C;
import static org.objectweb.asm.Opcodes.I2D;
import static org.objectweb.asm.Opcodes.I2F;
import static org.objectweb.asm.Opcodes.I2L;
import static org.objectweb.asm.Opcodes.I2S;
import static org.objectweb.asm.Opcodes.IADD;
import static org.objectweb.asm.Opcodes.IALOAD;
import static org.objectweb.asm.Opcodes.IAND;
import static org.objectweb.asm.Opcodes.IASTORE;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.IDIV;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFGE;
import static org.objectweb.asm.Opcodes.IFGT;
import static org.objectweb.asm.Opcodes.IFLE;
import static org.objectweb.asm.Opcodes.IFLT;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.IFNONNULL;
import static org.objectweb.asm.Opcodes.IFNULL;
import static org.objectweb.asm.Opcodes.IF_ACMPEQ;
import static org.objectweb.asm.Opcodes.IF_ACMPNE;
import static org.objectweb.asm.Opcodes.IF_ICMPEQ;
import static org.objectweb.asm.Opcodes.IF_ICMPGE;
import static org.objectweb.asm.Opcodes.IF_ICMPGT;
import static org.objectweb.asm.Opcodes.IF_ICMPLE;
import static org.objectweb.asm.Opcodes.IF_ICMPLT;
import static org.objectweb.asm.Opcodes.IF_ICMPNE;
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
import static org.objectweb.asm.Opcodes.LCMP;
import static org.objectweb.asm.Opcodes.LCONST_0;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.NEWARRAY;
import static org.objectweb.asm.Opcodes.POP;
import static org.objectweb.asm.Opcodes.POP2;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.PUTSTATIC;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.SIPUSH;

import java.util.function.Consumer;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.ClazzImpl;
import nebula.tinyasm.InstanceImpl;
import nebula.tinyasm.util.TypeUtils;

public interface MethodCode extends MethodCodeASM, MethodCodeFriendly<MethodCode>, WithInvoke<MethodCode> {

	void visitLabel(Label label);

	void visitLabel(Label label, int line);

	void mvInst(int opcode);

	void mvInst(int opcode, int index);

	void mvIntInsn(int opcode, int operand);

	void mvFieldInsn(int opcode, Type ownerType, String name, Type fieldType);

	void mvInvoke(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes);

	void mvTryCatchBlock(Label start, Label end, Label handler, Type exctpionClazz);

	void mvLdcInsn(Object cst);

	void mvTypeInsn(int opcode, Type type);

	void mvJumpInsn(int opcode, Label label);

	abstract Type codeThisFieldType(String name);

	abstract Type codeThisClassFieldType(String name);

	abstract int codeLocalGetLocals(String name);

//	abstract Type codeLocalGetType(String name);

//	abstract Type codeLocalGetType(int index);

	abstract Type codeLocalLoadAccess(int index);

	abstract Type codeLocalStoreAccess(int index);

	abstract Type codeGetStackType(int i);

	abstract Type codePopStack();

	abstract void codePush(Type type);

	/*
	 * 2.11.2. Load and Store Instructions The load and store instructions transfer
	 * values between the local variables (§2.6.1) and the operand stack (§2.6.2) of
	 * a Java Virtual Machine frame (§2.6):
	 * 
	 * Load a local variable onto the operand stack: iload, iload_<n>, lload,
	 * lload_<n>, fload, fload_<n>, dload, dload_<n>, aload, aload_<n>. Store a
	 * value from the operand stack into a local variable: istore, istore_<n>,
	 * lstore, lstore_<n>, fstore, fstore_<n>, dstore, dstore_<n>, astore,
	 * astore_<n>. Load a constant on to the operand stack: bipush, sipush, ldc,
	 * ldc_w, ldc2_w, aconst_null, iconst_m1, iconst_<i>, lconst_<l>, fconst_<f>,
	 * dconst_<d>. Gain access to more local variables using a wider index, or to a
	 * larger immediate operand: wide. Instructions that access fields of objects
	 * and elements of arrays (§2.11.5) also transfer data to and from the operand
	 * stack.
	 * 
	 * Instruction mnemonics shown above with trailing letters between angle
	 * brackets (for instance, iload_<n>) denote families of instructions (with
	 * members iload_0, iload_1, iload_2, and iload_3 in the case of iload_<n>).
	 * Such families of instructions are specializations of an additional generic
	 * instruction (iload) that takes one operand. For the specialized instructions,
	 * the operand is implicit and does not need to be stored or fetched. The
	 * semantics are otherwise the same (iload_0 means the same thing as iload with
	 * the operand 0). The letter between the angle brackets specifies the type of
	 * the implicit operand for that family of instructions: for <n>, a nonnegative
	 * integer; for <i>, an int; for <l>, a long; for <f>, a float; and for <d>, a
	 * double. Forms for type int are used in many cases to perform operations on
	 * values of type byte, char, and short (§2.11.1).
	 * 
	 * This notation for instruction families is used throughout this specification.
	 */

	default Instance topInstance() {
		return new InstanceImpl(this, codeGetStackType(0));
	}

	@Override
	default Instance loadThis() {
		LOAD(_THIS);
		return topInstance();
	}

	@Override
	default Instance loadThisField(String fieldname, Class<?> feildtype) {
		loadThisField(fieldname, typeOf(fieldname));
		return topInstance();
	}

	default Instance loadThisField(String fieldname, String feildtype) {
		loadThisField(fieldname, typeOf(fieldname));
		return topInstance();
	}

	default Instance loadThisField(String fieldname, Type feildtype) {
		loadThis();
		GETFIELD(fieldname, feildtype);
		return topInstance();
	}

	default void set(String varname, Consumer<MethodCode> invocations) {
		int locals = codeLocalGetLocals(varname);
		if (locals >= 0) {
			invocations.accept(this);
			STORE(varname);
		} else {
			loadThis();
			invocations.accept(this);
			PUTFIELD_OF_THIS(varname);
		}
	}

	default void setNull(String varname) {
		int locals = codeLocalGetLocals(varname);
		if (locals >= 0) {
			LOADConstNULL();
			STORE(varname);
		} else {
			loadThis();
			LOADConstNULL();
			PUTFIELD_OF_THIS(varname);
		}
	}
	default void setConst(String varname, String cst) {
		int locals = codeLocalGetLocals(varname);
		if (locals >= 0) {
			LOADConst(cst);
			STORE(varname);
		} else {
			loadThis();
			LOADConst(cst);
			PUTFIELD_OF_THIS(varname);
		}
	}

	default void setConst(String varname, int cst) {
		int locals = codeLocalGetLocals(varname);
		if (locals >= 0) {
			LOADConst(cst);
			STORE(varname);
		} else {
			loadThis();
			LOADConst(cst);
			PUTFIELD_OF_THIS(varname);
		}
	}

	default Clazz clazz(Class<?> clazz) {
		return new ClazzImpl(this, typeOf(clazz));
	}

	default Clazz clazz(String clazz) {
		return new ClazzImpl(this, typeOf(clazz));
	}

	@Override
	default void LOAD(String firstname, String... names) {
		LOAD(firstname);
		for (String name : names) {
			LOAD(name);
		}
	}

	@Override
	default void LOAD(int index) {
		Type valueType = codeLocalLoadAccess(index);
		switch (valueType.getSort()) {
		case Type.OBJECT:
		case Type.ARRAY:
			codePush(valueType);
			mvInst(ALOAD, index);
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
			mvInst(valueType.getOpcode(ILOAD), index);
			break;
		}
	}

	@Override
	default void LOAD(String varname) {
		int local = codeLocalGetLocals(varname);
		assert local >= 0 : varname + " doesn't exist";
		LOAD(local);
	}

	default Instance load(String varname) {
		int local = codeLocalGetLocals(varname);
		if (local >= 0) {
			LOAD(local);
		} else {
			loadThisField(varname);
		}

		return topInstance();
	}

	default void ifTrue(Consumer<MethodCode> block) {
		Label ifElse = codeNewLabel();
		IFEQ(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	default void ifFalse(Consumer<MethodCode> block) {
		Label ifElse = codeNewLabel();
		IFNE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	default void ifEqual(Consumer<MethodCode> block) {
		Label ifElse = codeNewLabel();
		IFNE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	default void ifNotEqual(Consumer<MethodCode> block) {
		Label ifElse = codeNewLabel();
		IFEQ(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	default void ifGreatThan(Consumer<MethodCode> block) {
		Label ifElse = codeNewLabel();
		IFLE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	default void ifGreatEqual(Consumer<MethodCode> block) {
		Label ifElse = codeNewLabel();
		IFLT(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	default void ifLessEqual(Consumer<MethodCode> block) {
		Label ifElse = codeNewLabel();
		IFGT(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	default void ifLessThan(Consumer<MethodCode> block) {
		Label ifElse = codeNewLabel();
		IFGE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	default Instance dup() {
		DUP();
		return topInstance();
	}

	@Override
	default void STORE(String varname) {
		int local = codeLocalGetLocals(varname);
		assert local >= 0 : varname + " doesn't exist";
		STORE(local);
	}

	default void store(String varname) {
		int local = codeLocalGetLocals(varname);
		if (local >= 0) {
			STORE(local);
		} else {
			define(varname, codeGetStackType(0).getClassName());
		}
	}

	default void STOREException(int local) {
		mvInst(ASTORE, local);
	}

	default void STOREException(String varname) {
		int local = codeLocalGetLocals(varname);
		mvInst(ASTORE, local);
	}

	@Override
	default void STORE(int index) {
		Type localType = codeLocalStoreAccess(index);

		Type valueType = codeGetStackType(0);
		switch (valueType.getSort()) {
		case Type.ARRAY:
			assert valueType.getSort() == localType.getSort() : "type don't match! local: " + localType + "  stack:" + valueType;
			codePopStack();
			mvInst(ASTORE, index);
			// ASTORE (objectref →) : store a reference into a local variable #index
			// ASTORE_0 (objectref →) : store a reference into local variable 0
			// ASTORE_1 (objectref →) : store a reference into local variable 1
			// ASTORE_2 (objectref →) : store a reference into local variable 2
			// ASTORE_3 (objectref →) : store a reference into local variable 3
			break;
		case Type.OBJECT:
			assert valueType.getSort() == localType.getSort() : "type don't match! local: " + localType + "  stack:" + valueType;
			codePopStack();
			mvInst(ASTORE, index);
			// ASTORE (objectref →) : store a reference into a local variable #index
			// ASTORE_0 (objectref →) : store a reference into local variable 0
			// ASTORE_1 (objectref →) : store a reference into local variable 1
			// ASTORE_2 (objectref →) : store a reference into local variable 2
			// ASTORE_3 (objectref →) : store a reference into local variable 3
			break;
		case Type.VOID:
			throw new UnsupportedOperationException();
		default:
			TypeUtils.checkMathTypes(localType, valueType);

			Type type = codePopStack();
			mvInst(type.getOpcode(ISTORE), index);

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

	@Override
	default void LOADConstByte(int value) {
		mvIntInsn(BIPUSH, value);
		codePush(Type.BYTE_TYPE);
	}

	@Override
	default void LOADConstShort(int value) {
		mvIntInsn(SIPUSH, value);
		codePush(Type.SHORT_TYPE);
	}

	@Override
	default void LOADConstNULL() {
		mvInst(ACONST_NULL);
		codePush(Type.getType(Object.class));
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

//	@Override
	default void LOADConst(int cst) {
		if (0L == cst || 1L == cst) {
			mvInst(ICONST_0 + cst);
			codePush(Type.getType(int.class));
		} else if (Byte.MIN_VALUE <= cst && cst <= Byte.MAX_VALUE) {
			mvIntInsn(BIPUSH, cst);
			codePush(Type.getType(int.class));
		} else {
			mvLdcInsn(cst);
			codePush(Type.getType(int.class));
		}
	}

	@Override
	default void LOADConst(Object cst) {

		if (cst instanceof Integer) {
			int v = ((Integer) cst).intValue();
			if (0L == v || 1L == v) {
				mvInst(ICONST_0 + v);
				codePush(Type.getType(int.class));
			} else {
				mvLdcInsn(cst);
				codePush(Type.getType(int.class));
			}
		} else if (cst instanceof Float) {
			mvLdcInsn(cst);
			codePush(Type.getType(float.class));
		} else if (cst instanceof Long) {
			long v = ((Long) cst);
			if (0L == v || 1L == v) {
				mvInst(LCONST_0 + ((Long) cst).intValue());
				codePush(Type.getType(long.class));
			} else {
				mvLdcInsn(cst);
				codePush(Type.getType(long.class));
			}
		} else if (cst instanceof Double) {
			mvLdcInsn(cst);
			codePush(Type.getType(double.class));
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

	/*
	 * 2.11.3. Arithmetic Instructions The arithmetic instructions compute a result
	 * that is typically a function of two values on the operand stack, pushing the
	 * result back on the operand stack. There are two main kinds of arithmetic
	 * instructions: those operating on integer values and those operating on
	 * floating-point values. Within each of these kinds, the arithmetic
	 * instructions are specialized to Java Virtual Machine numeric types. There is
	 * no direct support for integer arithmetic on values of the byte, short, and
	 * char types (§2.11.1), or for values of the boolean type; those operations are
	 * handled by instructions operating on type int. Integer and floating-point
	 * instructions also differ in their behavior on overflow and divide-by-zero.
	 * The arithmetic instructions are as follows:
	 * 
	 * Add: iadd, ladd, fadd, dadd.
	 * 
	 */
	/** MATH **/
	@Override
	default Instance add(String left, String right) {
		LOAD(left);
		LOAD(right);
		ADD();
		return topInstance();
	}

	@Override
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

	/* Subtract: isub, lsub, fsub, dsub. */

	@Override
	default Instance sub(String left, String right) {
		LOAD(left);
		LOAD(right);
		SUB();
		return topInstance();
	}

	@Override
	default void SUB() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(ISUB));
	}

	/* Multiply: imul, lmul, fmul, dmul. */
	@Override
	default Instance mul(String left, String right) {
		LOAD(left);
		LOAD(right);
		MUL();
		return topInstance();
	}

	@Override
	default void MUL() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IMUL));
	}

	/* Divide: idiv, ldiv, fdiv, ddiv. */
	@Override
	default Instance div(String left, String right) {
		LOAD(left);
		LOAD(right);
		DIV();
		return topInstance();
	}

	@Override
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

	/* Remainder: irem, lrem, frem, drem. */
	@Override
	default Instance rem(String left, String right) {
		LOAD(left);
		LOAD(right);
		REM();
		return topInstance();
	}

	@Override
	default void REM() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IREM));
	}

	/* Negate: ineg, lneg, fneg, dneg. */
	@Override
	default Instance neg(String left) {
		LOAD(left);
		REM();
		return topInstance();
	}

	@Override
	default void NEG() {
		Type value = codePopStack();
		Type result = value;
		codePush(result);
		mvInst(value.getOpcode(INEG));
	}

	/* Shift: ishl, ishr, iushr, lshl, lshr, lushr. */
	@SuppressWarnings("unused")
	@Override
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
	@Override
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

	/* Bitwise OR: ior, lor. */
	@Override
	default Instance or(String left, String right) {
		LOAD(left);
		LOAD(right);
		OR();
		return topInstance();
	}

	@Override
	default void OR() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IOR));
	}

	/* Bitwise AND: iand, land. */
	@Override
	default Instance and(String left, String right) {
		LOAD(left);
		LOAD(right);
		AND();
		return topInstance();
	}

	@Override
	default void AND() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IAND));
		// IAND (left, right → result) : perform a bitwise and on two integers
		// LAND (left, right → result) : bitwise and of two longs
	}

	/* Bitwise exclusive OR: ixor, lxor. */
	@Override
	default Instance xor(String left, String right) {
		LOAD(left);
		LOAD(right);
		XOR();
		return topInstance();
	}

	@Override
	default void XOR() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		codePush(type);
		mvInst(type.getOpcode(IXOR));

		// IXOR (left, right → result) : int xor
		// LXOR (left, right → result) : bitwise exclusive or of two longs
	}

	/* Local variable increment: iinc. */
	/* Comparison: dcmpg, dcmpl, fcmpg, fcmpl, lcmp. */

	@Override
	default void LCMP() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		assert typeRightValue.getSort() == Type.LONG : "actual: " + typeRightValue + "  expected:" + Type.LONG;
		assert typeRightValue.getSort() == Type.LONG : "actual: " + typeLeftValue + "  expected:" + Type.LONG;
		codePush(Type.INT_TYPE);
		mvInst(LCMP);
	}

	@Override
	default void CMPL() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		assert in(typeRightValue, Type.FLOAT_TYPE, Type.DOUBLE_TYPE) : "actual: " + typeRightValue + "  expected:" + Type.FLOAT_TYPE + "," + Type.DOUBLE_TYPE;
		assert in(typeLeftValue, Type.FLOAT_TYPE, Type.DOUBLE_TYPE) : "actual: " + typeLeftValue + "  expected:" + Type.FLOAT_TYPE + "," + Type.DOUBLE_TYPE;

		codePush(Type.INT_TYPE);

		if (typeRightValue == Type.FLOAT_TYPE) {
			mvInst(FCMPL);
		} else {
			mvInst(DCMPL);
		}
	}

	@Override
	default void CMPG() {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		assert in(typeRightValue, Type.FLOAT_TYPE, Type.DOUBLE_TYPE) : "actual: " + typeRightValue + "  expected:" + Type.FLOAT_TYPE + "," + Type.DOUBLE_TYPE;
		assert in(typeLeftValue, Type.FLOAT_TYPE, Type.DOUBLE_TYPE) : "actual: " + typeLeftValue + "  expected:" + Type.FLOAT_TYPE + "," + Type.DOUBLE_TYPE;

		codePush(Type.INT_TYPE);

		if (typeRightValue == Type.FLOAT_TYPE) {
			mvInst(FCMPG);
		} else {
			mvInst(DCMPG);
		}
	}

	@Override
	default void CONVERTTO(Class<?> typeTo) {
		CONVERTTO(typeOf(typeTo));
	}

	@Override
	default void CONVERTTO(String typeTo) {
		CONVERTTO(typeOf(typeTo));
	}

	/*
	 * 2.11.4. Type Conversion Instructions
	 * 
	 * int to byte, short, or char long to int float to int or long double to int,
	 * long, or float
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
	}

	/*
	 * 2.11.5. Object Creation and Manipulation Although both class instances and
	 * arrays are objects, the Java Virtual Machine creates and manipulates class
	 * instances and arrays using distinct sets of instructions:
	 */
	/* Create a new class instance: new. */
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
	@Override
	default void NEW(Class<?> objectclazz) {
		NEW(typeOf(objectclazz));
	}

	@Override
	default void NEW(String objectclazz) {
		NEW(typeOf(objectclazz));
	}

	default void NEW(Type objectclazz) {
		codePush(objectclazz);
		mvTypeInsn(NEW, objectclazz);
		// NEW (→ objectref) : create new object of type identified by class reference
		// in constant pool index (indexbyte1 << 8 + indexbyte2)
	}

	/* Create a new array: newarray, anewarray, multianewarray. */

	@Override
	default Instance newarray(Class<?> elementClazz, int count) {
		LOADConst(count);
		NEWARRAY(typeOf(elementClazz));
		return topInstance();
	}

	@Override
	default Instance newarray(String elementClazz, int count) {
		LOADConst(count);
		NEWARRAY(typeOf(elementClazz));
		return topInstance();
	}

	@Override
	default void NEWARRAY(Class<?> type) {
		NEWARRAY(typeOf(type));
	}

	@Override
	default void NEWARRAY(String type) {
		NEWARRAY(typeOf(type));
	}

	default void NEWARRAY(Type type) {
		Type count = codePopStack();
		assert in(count, Type.INT_TYPE, Type.BYTE_TYPE, Type.SHORT_TYPE) : "array count type " + type;
//		Type arrayref = Type.getType(Object.class); /* TODO */

		Type arrayType = arrayOf(type);
		codePush(arrayType);

		if (Type.BOOLEAN <= type.getSort() && type.getSort() <= Type.DOUBLE) {
			int typecode = arrayTyoeCodeOf(type);
			mvIntInsn(NEWARRAY, typecode);
		} else if (type.getSort() == Type.ARRAY) mvTypeInsn(ANEWARRAY, type);
		else if (type.getSort() == Type.OBJECT) mvTypeInsn(ANEWARRAY, type);
		else if (type.getSort() == Type.VOID) RETURN();
		else
			throw new UnsupportedOperationException();
	}

	/*
	 * Access fields of classes (static fields, known as class variables) and fields
	 * of class instances (non-static fields, known as instance variables):
	 * getfield, putfield, getstatic, putstatic. Load an array component onto the
	 * operand stack: baload, caload, saload, iaload, laload, faload, daload,
	 * aaload. Store a value from the operand stack as an array component: bastore,
	 * castore, sastore, iastore, lastore, fastore, dastore, aastore. Get the length
	 * of array: arraylength.
	 */

	@Override
	default void ARRAYLENGTH(String array) {
		LOAD(array);
		ARRAYLENGTH();
	}

	@SuppressWarnings("unused")
	@Override
	default void ARRAYLENGTH() {
		Type arrayref = codePopStack();
		Type length = Type.INT_TYPE;
		mvInst(ARRAYLENGTH);
		codePush(length);
		// ARRAYLENGTH (arrayref → length) : get the length of an array
	}

	@Override
	default Instance arrayload(String arrayref, String index, Class<?> valueType) {
		return arrayload(arrayref, index, typeOf(valueType));
	}

	@Override
	default Instance arrayload(String arrayref, String index, String valueType) {
		return arrayload(arrayref, index, typeOf(valueType));
	}

	default Instance arrayload(String arrayref, String index, Type valueType) {
		LOAD(arrayref);
		LOAD(index);
		ARRAYLOAD(valueType);
		return topInstance();
	}

	default Instance arrayload(String arrayref, int index, Type valueType) {
		LOAD(arrayref);
		LOADConst(index);
		ARRAYLOAD(valueType);
		return topInstance();
	}

	default Instance arrayload(String arrayref, int index) {
		load(arrayref);
		Type arrayType = codeGetStackType(0);
		LOADConst(index);
		ARRAYLOAD(arrayType.getElementType());
		return topInstance();
	}

	default Instance arrayload(String varArray, String varIndex) {
		load(varArray);
		Type arrayType = codeGetStackType(0);
		load(varIndex);
		ARRAYLOAD(arrayType.getElementType());
		return topInstance();
	}

	@Override
	default void ARRAYLOAD(Class<?> value) {
		ARRAYLOAD(typeOf(value));
	}

	@Override
	default void ARRAYLOAD(String elementClazz) {
		ARRAYLOAD(typeOf(elementClazz));
	}

	@SuppressWarnings("unused")
	default void ARRAYLOAD(Type elementClazz) {
		Type index = codePopStack();
		Type arrayref = codePopStack();
		mvInst(elementClazz.getOpcode(IALOAD));
		codePush(elementClazz);
	}

	@Override
	default void arraystore(String varArray, String index, String value) {
		LOAD(varArray);
		LOAD(index);
		LOAD(value);
		ARRAYSTORE();
	}

	@SuppressWarnings("unused")
	@Override
	default void ARRAYSTORE() {
		Type value = codePopStack();
		Type index = codePopStack();
		Type arrayref = codePopStack();
		Type itemType = arrayref.getElementType();

		switch (itemType.getSort()) {
		// BASTORE (arrayref, index, value →) : store a byte or Boolean value into an
		// array
		case Type.BYTE:
			mvInst(itemType.getOpcode(IASTORE));
			break;
		// CASTORE (arrayref, index, value →) : store a char into an array
		case Type.CHAR:
			mvInst(itemType.getOpcode(IASTORE));
			break;
		// DASTORE (arrayref, index, value →) : store a double into an array
		case Type.DOUBLE:
			mvInst(itemType.getOpcode(IASTORE));
			break;
		// FASTORE (arrayref, index, value →) : store a float in an array
		case Type.FLOAT:
			mvInst(itemType.getOpcode(IASTORE));
			break;
		// IASTORE (arrayref, index, value →) : store an int into an array
		case Type.INT:
			mvInst(itemType.getOpcode(IASTORE));
			break;
		// LASTORE (arrayref, index, value →) : store a long to an array
		case Type.LONG:
			mvInst(itemType.getOpcode(IASTORE));
			break;
		// SASTORE (arrayref, index, value →) : store short to array
		case Type.SHORT:
			mvInst(itemType.getOpcode(IASTORE));
			break;
		// AASTORE (arrayref, index, value →) : store into a reference in an array
		case Type.OBJECT:
			mvInst(AASTORE);
			break;
		default:
			throw new UnsupportedOperationException();
		}
	}

	@Override
	default void INSTANCEOF(Class<?> type) {
		INSTANCEOF(typeOf(type));
	}

	@Override
	default void INSTANCEOF(String type) {
		INSTANCEOF(typeOf(type));
	}

	/* Check properties of class instances or arrays: instanceof, checkcast. */
	@SuppressWarnings("unused")
	default void INSTANCEOF(Type type) {
		Type objectref = codePopStack();
		Type result = Type.getType(int.class);
		codePush(result);
		mvTypeInsn(INSTANCEOF, type);
		// INSTANCEOF (objectref → result) : determines if an object objectref is of a
		// given type, identified by class reference index in constant pool (indexbyte1
		// << 8 + indexbyte2)
	}

	@Override
	default void CHECKCAST(Class<?> type) {
		CHECKCAST(typeOf(type));
	}

	@Override
	default void CHECKCAST(String type) {
		CHECKCAST(typeOf(type));
	}

	default void CHECKCAST(Type type) {
//		Type objectref = codePopStack();
		codePush(type);
		mvTypeInsn(CHECKCAST, type);
		// CHECKCAST (objectref → objectref) : checks whether an objectref is of a
		// certain type, the class reference of which is in the constant pool
		// at index (indexbyte1 << 8 + indexbyte2)
	}

	/*
	 * 2.11.6. Operand Stack Management Instructions A number of instructions are
	 * provided for the direct manipulation of the operand stack: pop, pop2, dup,
	 * dup2, dup_x1, dup2_x1, dup_x2, dup2_x2, swap.
	 */
	@SuppressWarnings("unused")
	@Override
	default void POP() {
		Type left = codePopStack();
		mvInst(POP);
	}

	@SuppressWarnings("unused")
	@Override
	default void POP2() {
		Type right = codePopStack();
		Type left = codePopStack();
		mvInst(POP2);
	}

	@Override
	default void DUP() {
		Type left = codeGetStackType(0);
		codePush(left);
		mvInst(DUP);
		// DUP (value → value, value) : duplicate the value on top of the stack
	}

	@Override
	default void DUP2() {
		Type right = codeGetStackType(-1);
		Type left = codeGetStackType(0);
		codePush(right);
		codePush(left);
		codePush(right);
		codePush(left);
		mvInst(DUP2);
	}

	@Override
	default void NOP() {
		mvInst(Opcodes.NOP);
		// NOP ([No change]) : perform no operation
	}

	/*
	 * 2.11.7. Control Transfer Instructions The control transfer instructions
	 * conditionally or unconditionally cause the Java Virtual Machine to continue
	 * execution with an instruction other than the one following the control
	 * transfer instruction. They are:
	 */
	/*
	 * Conditional branch: ifeq, ifne, iflt, ifle, ifgt, ifge, ifnull, ifnonnull,
	 * if_icmpeq, if_icmpne, if_icmplt, if_icmple, if_icmpgt if_icmpge, if_acmpeq,
	 * if_acmpne.
	 */
	@Override
	default void IFEQ(Label falseLabel) {
		Type value = codePopStack();
		assert in(value, Type.BOOLEAN_TYPE, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		mvJumpInsn(IFEQ, falseLabel);
	}

	@Override
	default void IFNE(Label falseLabel) {
		Type value = codePopStack();
		assert in(value, Type.INT_TYPE, Type.BOOLEAN_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE + " | " + Type.BOOLEAN_TYPE;
		mvJumpInsn(IFNE, falseLabel);
	}

	default Label IFNE() {
		Label falseLabel = new Label();
		Type value = codePopStack();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		mvJumpInsn(IFNE, falseLabel);
		return falseLabel;
	}

	@Override
	default void IFLT(Label falseLabel) {
		Type value = codePopStack();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		mvJumpInsn(IFLT, falseLabel);
	}

	@Override
	default void IFLE(Label falseLabel) {
		Type value = codePopStack();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		mvJumpInsn(IFLE, falseLabel);
	}

	@Override
	default void IFGT(Label falseLabel) {
		Type value = codePopStack();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		mvJumpInsn(IFGT, falseLabel);
	}

	@Override
	default void IFGE(Label falseLabel) {
		Type value = codePopStack();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		mvJumpInsn(IFGE, falseLabel);
	}

	@Override
	default void IFNULL(Label falseLabel) {
		Type value = codePopStack();
		assert value.getSort() == Type.OBJECT : "actual: " + value + "  expected:" + Type.OBJECT;
		mvJumpInsn(IFNULL, falseLabel);
	}

	@Override
	default void IFNONNULL(Label falseLabel) {
		Type value = codePopStack();
		assert value.getSort() == Type.OBJECT : "actual: " + value + "  expected:" + Type.OBJECT;
		mvJumpInsn(IFNONNULL, falseLabel);
	}

	@Override
	default void IF_ACMPEQ(Label falseLabel) {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		assert typeRightValue.getSort() == Type.OBJECT;
		assert typeLeftValue.getSort() == Type.OBJECT;
		mvJumpInsn(IF_ACMPEQ, falseLabel);
	}

	@Override
	default void IF_ACMPNE(Label falseLabel) {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		assert typeRightValue.getSort() == Type.OBJECT;
		assert typeLeftValue.getSort() == Type.OBJECT;
		mvJumpInsn(IF_ACMPNE, falseLabel);
	}

	@Override
	default void IF_ICMPEQ(Label falseLabel) {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		checkMathTypes(typeRightValue, typeLeftValue);

		mvJumpInsn(IF_ICMPEQ, falseLabel);
	}

	@Override
	default void IF_ICMPNE(Label falseLabel) {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		checkMathTypes(typeRightValue, typeLeftValue);

		mvJumpInsn(IF_ICMPNE, falseLabel);
	}

	@Override
	default void IF_ICMPLT(Label falseLabel) {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		checkMathTypes(typeRightValue, typeLeftValue);

		mvJumpInsn(IF_ICMPLT, falseLabel);
	}

	@Override
	default void IF_ICMPLE(Label falseLabel) {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		checkMathTypes(typeRightValue, typeLeftValue);

		mvJumpInsn(IF_ICMPLE, falseLabel);
	}

	@Override
	default void IF_ICMPGT(Label falseLabel) {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		checkMathTypes(typeRightValue, typeLeftValue);

		mvJumpInsn(IF_ICMPGT, falseLabel);
	}

	@Override
	default void IF_ICMPGE(Label falseLabel) {
		Type typeRightValue = codePopStack();
		Type typeLeftValue = codePopStack();
		checkMathTypes(typeRightValue, typeLeftValue);

		mvJumpInsn(IF_ICMPGE, falseLabel);
	}

	/* Compound conditional branch: tableswitch, lookupswitch. */
	// TODO

	/* Unconditional branch: goto, goto_w, jsr, jsr_w, ret. */
	@Override
	default void GOTO(Label gotoLabel) {
		mvJumpInsn(GOTO, gotoLabel);
	}

	default void returnVoid() {
		mvInst(RETURN);
	}

	@Override
	default void RETURN() {
		mvInst(RETURN);
	}

	@Override
	default void RETURN(int i) {
		LOADConstByte(i);
		RETURNTop();
	}

	@Override
	default void RETURN(String varname) {
		LOAD(varname);
		RETURNTop();
	}

	default void returnNull() {
		LOADConstNULL();
		RETURNTop();
	}

	@Override
	default void RETURNTop() {
		Type type = codeGetStackType(0);
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

	@Override
	default void ATHROW() {
		mvInst(ATHROW);
	}

	default void tryCatchBlock(Label start, Label end, Label handler, String exctpionClazz) {
		mvTryCatchBlock(start, end, handler, typeOf(exctpionClazz));
	}

	default void tryCatchBlock(Label start, Label end, Label handler, Class<?> exctpionClazz) {
		mvTryCatchBlock(start, end, handler, typeOf(exctpionClazz));
	}

	/*
	 * 2.11.8. Method Invocation and Return Instructions The following five
	 * instructions invoke methods:
	 * 
	 * invokevirtual invokes an instance method of an object, dispatching on the
	 * (virtual) type of the object. This is the normal method dispatch in the Java
	 * programming language. invokeinterface invokes an interface method, searching
	 * the methods implemented by the particular run-time object to find the
	 * appropriate method. invokespecial invokes an instance method requiring
	 * special handling, whether an instance initialization method (§2.9), a private
	 * method, or a superclass method. invokestatic invokes a class (static) method
	 * in a named class. invokedynamic invokes the method which is the target of the
	 * call site object bound to the invokedynamic instruction. The call site object
	 * was bound to a specific lexical occurrence of the invokedynamic instruction
	 * by the Java Virtual Machine as a result of running a bootstrap method before
	 * the first execution of the instruction. Therefore, each occurrence of an
	 * invokedynamic instruction has a unique linkage state, unlike the other
	 * instructions which invoke methods. The method return instructions, which are
	 * distinguished by return type, are ireturn (used to return values of type
	 * boolean, byte, char, short, or int), lreturn, freturn, dreturn, and areturn.
	 * In addition, the return instruction is used to return from methods declared
	 * to be void, instance initialization methods, and class or interface
	 * initialization methods.
	 * 
	 */

	String _THIS = "this";

	@Override
	default void INITObject() {
		loadThis();
		INVOKESPECIAL(Type.getType(Object.class), Type.VOID_TYPE, "<init>");
	}

	default void initThis() {
		LOAD(_THIS);
		INVOKESPECIAL(Type.getType(Object.class), Type.VOID_TYPE, "<init>");
	}

	default void init(String clazz) {
		NEW(clazz);
		DUP();
		SPECIAL(clazz, "<init>").INVOKE();
	}

	default Instance init(Class<?> clazz) {
		NEW(clazz);
		DUP();
		SPECIAL(clazz, "<init>").INVOKE();
		return new InstanceImpl(this, codeGetStackType(0));
	}

	/** ARRAY **/
	@Override
	default Instance getfield(String objectname, String fieldname, Class<?> fieldType) {
		getfield(objectname, fieldname, typeOf(fieldType));
		return topInstance();
	}

	@Override
	default Instance loadThisField(String fieldname) {
		getfield(_THIS, fieldname, codeThisFieldType(fieldname));
		return topInstance();
	}

	@Override
	default Instance getfield(String objectname, String fieldname, String fieldType) {
		getfield(objectname, fieldname, typeOf(fieldType));
		return topInstance();
	}

	default Instance getfield(String objectname, String fieldname, Type fieldType) {
		LOAD(objectname);
		GETFIELD(fieldname, fieldType);
		return topInstance();
	}

	@Override
	default void GET_THIS_FIELD(String fieldname) {
		GETFIELD(fieldname, codeThisFieldType(fieldname));
	}

	@Override
	default void GETFIELD(String fieldname, Class<?> fieldType) {
		GETFIELD(fieldname, typeOf(fieldType));
	}

	@Override
	default void GETFIELD(String fieldname, String fieldType) {
		GETFIELD(fieldname, typeOf(fieldType));
	}

	default void GETFIELD(String fieldname, Type fieldType) {
		Type objectref = codePopStack();
		codePush(fieldType);
		mvFieldInsn(GETFIELD, objectref, fieldname, fieldType);

		// GETFIELD (objectref → value) : get a field value of an object objectref,
		// where the field is identified by field reference in the constant
		// pool index (index1 << 8 + index2)
	}

	@Override
	default void putThisFieldWithVar(String fieldname, String varname) {
		putVarToThisField(varname, fieldname, codeThisFieldType(fieldname));
	}

	default void putThisFieldOfNewObject(String fieldname, String clazz) {
		putThisFieldOfNewObject(fieldname, clazz, codeThisFieldType(fieldname));
	}

	default void putThisFieldOfNewObject(String fieldname, Class<?> clazz) {
		putThisFieldOfNewObject(fieldname, clazz, codeThisFieldType(fieldname));
	}

	default void putThisFieldOfNewObject(String fieldname, Class<?> clazz, Type fieldType) {
		loadThis();
		init(clazz);
		PUTFIELD(fieldname, fieldType);
	}

	default void putThisFieldOfNewObject(String fieldname, String clazz, Type fieldType) {
		loadThis();
		init(clazz);
		PUTFIELD(fieldname, fieldType);
	}

	default void setNew(String varname, Class<?> clazz) {
		init(clazz);
		STORE(varname);
	}

	default void setOfNewObject(String varname, String clazz) {
		loadThis();
		init(clazz);
		STORE(varname);
	}

	default void putVarToThisField(String varname, String fieldname, Type fieldType) {
		loadThis();
		LOAD(varname);
		PUTFIELD(fieldname, fieldType);
	}

	default void getThisFieldTo(String fieldname, Type fieldType, String varname) {
		loadThis();
		GETFIELD(fieldname, fieldType);
		STORE(varname);
	}

	@Override
	default void putfield(String objectref, String varname, String fieldname, Class<?> fieldType) {
		putfield(objectref, varname, fieldname, typeOf(fieldType));
	}

	@Override
	default void putfield(String objectref, String varname, String fieldname, String fieldType) {
		putfield(objectref, varname, fieldname, typeOf(fieldType));

	}

	default void putfield(String objectref, String varname, String fieldname, Type fieldType) {
		LOAD(objectref);
		LOAD(varname);
		PUTFIELD(fieldname, fieldType);
	}

	@Override
	default void PUTFIELD_OF_THIS(String fieldname) {
		PUTFIELD(fieldname, codeThisFieldType(fieldname));
	}

	@Override
	default void PUTFIELD(String fieldname, Class<?> fieldType) {
		PUTFIELD(fieldname, typeOf(fieldType));
	}

	@Override
	default void PUTFIELD(String fieldname, String fieldType) {
		PUTFIELD(fieldname, typeOf(fieldType));
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

	@Override
	default void GETSTATIC(Class<?> objectType, String fieldName, Class<?> fieldType) {
		GETSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	@Override
	default void GET_THIS_STATIC(String objectType, String fieldName) {
		GETSTATIC(typeOf(objectType), fieldName, codeThisClassFieldType(fieldName));
	}

	@Override
	default void GETSTATIC(String objectType, String fieldName, String fieldType) {
		GETSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	default void GETSTATIC(Type objectType, String fieldName, Type fieldType) {
		codePush(fieldType);
		mvFieldInsn(GETSTATIC, objectType, fieldName, fieldType);
		// GETSTATIC (→ value) : get a static field value of a class, where the field is
		// identified by field reference in the constant pool index (index1 << 8 +
		// index2)
	}

	@Override
	default void putstatic(Class<?> objectType, String varname, String fieldname, Class<?> fieldType) {
		putstatic(typeOf(objectType), varname, fieldname, typeOf(fieldType));
	}

	@Override
	default void putstatic(String objectType, String varname, String fieldname, String fieldType) {
		putstatic(typeOf(objectType), varname, fieldname, typeOf(fieldType));
	}

	default void putstatic(Type objectType, String varname, String fieldname, Type fieldType) {
		LOAD(varname);
		PUTSTATIC(objectType, fieldname, fieldType);
	}

	@Override
	default void PUTSTATIC(Class<?> objectType, String fieldName, Class<?> fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	@Override
	default void PUT_THIS_STATIC(String objectType, String fieldName) {
		PUTSTATIC(typeOf(objectType), fieldName, codeThisClassFieldType(fieldName));
	}

	@Override
	default void PUTSTATIC(String objectType, String fieldName, String fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	@SuppressWarnings("unused")
	default void PUTSTATIC(Type objectType, String fieldName, Type fieldType) {
		Type value = codePopStack();
		mvFieldInsn(PUTSTATIC, objectType, fieldName, fieldType);

		// PUTSTATIC (value →) : set static field to value in a class, where the field
		// is identified by a field reference index in constant pool (indexbyte1 << 8 +
		// indexbyte2)
	}

	/** INVOKE **/
	@Override
	default void INVOKESTATIC(Class<?> objectType, String methodName, Class<?>... paramTypes) {
		INVOKESTATIC(typeOf(objectType), Type.VOID_TYPE, methodName, typeOf(paramTypes));
	}

	@Override
	default void INVOKESTATIC(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKESTATIC(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	default void INVOKESTATIC(String objectType, String returnType, String methodName, String... paramTypes) {
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

	@Override
	default void INVOKEINTERFACE(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKEINTERFACE(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	default void INVOKEINTERFACE(String objectType, String returnType, String methodName, String... paramTypes) {
		INVOKEINTERFACE(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
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

	@Override
	default void INVOKESPECIAL(Class<?> objectType, String methodName, Class<?>... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), null, methodName, typeOf(paramTypes));
	}

	@Override
	default void INVOKESPECIAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	default void INVOKESPECIAL(String objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	default void INVOKESPECIAL(String objectType, String returnType, String methodName, String... paramTypes) {
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

	@Override
	default void INVOKEVIRTUAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKEVIRTUAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	default void INVOKEVIRTUAL(String objectType, String returnType, String methodName, String... paramTypes) {
		INVOKEVIRTUAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@SuppressWarnings("unused")
	default void INVOKEVIRTUAL(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			codePopStack();
		}
		codePopStack(); // objectType
		mvInvoke(INVOKEVIRTUAL, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);

	}

	@SuppressWarnings("unused")
	default void INVOKE(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			codePopStack();
		}
		if (opcode != INVOKESTATIC) codePopStack(); // objectType
		mvInvoke(opcode, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) codePush(returnType);

	}

	default MethodCode line(Consumer<MethodCode> invocation) {
		line();
		return block(invocation);
	}

	MethodCode block(Consumer<MethodCode> invocation);

//	@Override
//	default C define(String fieldName, Class<?> clz) {
//		return vmVar(fieldName, typeOf(clz), null);
//	}
//
//	@Override
//	default C define(String fieldName, Class<?> clz, boolean isarray) {
//		return vmVar(fieldName, typeOf(clz), null);
//	}
//
//	@Override
//	default C define(String fieldName, Class<?> clz, boolean isarray, Class<?>... signatureClasses) {
//		return vmVar(fieldName, typeOf(clz, isarray), signatureOf(clz, signatureClasses));
//	}
//
//	@Override
//	default C define(String fieldName, Class<?> clz, Class<?>... signatureClasses) {
//		return vmVar(fieldName, typeOf(clz), signatureOf(clz, signatureClasses));
//	}
//
//	@Override
//	default C define(String fieldName, String clz) {
//		return vmVar(fieldName, typeOf(clz), null);
//	}
//
//	@Override
//	default C define(String fieldName, String clz, boolean isarray) {
//		return vmVar(fieldName, typeOf(clz, isarray), null);
//	}
//
//	@Override
//	default C define(String fieldName, String clz, boolean isarray, Class<?>... signatureClasses) {
//		return vmVar(fieldName, typeOf(clz, isarray), signatureOf(clz, signatureClasses));
//	}
//
//	@Override
//	default C define(String fieldName, String clz, boolean isarray, String... signatureClasses) {
//		return vmVar(fieldName, typeOf(clz, isarray), signatureOf(clz, signatureClasses));
//	}
//
//	@Override
//	default C define(String fieldName, String clz, Class<?>... signatureClasses) {
//		return vmVar(fieldName, typeOf(clz), signatureOf(clz, signatureClasses));
//	}
//
//	@Override
//	default C define(String fieldName, String clz, String... signatureClasses) {
//		return vmVar(fieldName, typeOf(clz), signatureOf(clz, signatureClasses));
//	}
//
//	C vmVar(String fieldName, Type fieldType, String signature);

	void end();

	Label codeNewLabel();

}