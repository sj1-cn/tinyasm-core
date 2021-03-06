package cc1sj.tinyasm;

import static cc1sj.tinyasm.TypeUtils.arrayOf;
import static cc1sj.tinyasm.TypeUtils.checkMathTypes;
import static cc1sj.tinyasm.TypeUtils.in;
import static cc1sj.tinyasm.TypeUtils.typeOf;
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
import static org.objectweb.asm.Opcodes.DCONST_0;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.DUP2;
import static org.objectweb.asm.Opcodes.F2D;
import static org.objectweb.asm.Opcodes.F2I;
import static org.objectweb.asm.Opcodes.F2L;
import static org.objectweb.asm.Opcodes.FCMPG;
import static org.objectweb.asm.Opcodes.FCMPL;
import static org.objectweb.asm.Opcodes.FCONST_0;
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
import static org.objectweb.asm.Opcodes.ISHL;
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

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public abstract class MethodCode implements MethodCodeASM, WithInvoke<MethodCode>, WithDefineVar {
	public void INIT_OBJECT() {
		LOAD(_THIS);
		SPECIAL(Object.class, "<init>").INVOKE();
	}

	@Override
	public void BOX_Top() {
		Type topType = stackTypeOf(0);
		BoxUnbox.box(topType).accept(this);
	}

	@Override
	public void UNBOX_Top() {
		Type topType = stackTypeOf(0);
		BoxUnbox.unbox(topType).accept(this);
	}

	public abstract void visitLabel(Label label);

	abstract void visitLabel(Label label, int line);

	public abstract void visitInsn(int opcode);

	abstract void visitVarInsn(int opcode, int index);

	abstract void visitInsn(int opcode, int operand);

	abstract void visitFieldInsn(int opcode, Type ownerType, String name, Type fieldType);

//	code.visitFieldInsn(GETSTATIC, "out", "Ljava/io/PrintStream;");

	abstract void visitMethodInsn(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes);

	abstract void visitTryCatchBlock(Label start, Label end, Label handler, Type exctpionClazz);

	abstract void visitLdcInsn(Object cst);

	abstract void visitTypeInsn(int opcode, Type type);

	abstract void visitJumpInsn(int opcode, Label label);

	abstract void visitLineNumber(final int line, final Label start);

	abstract void visitLineNumber(final Label start);

	abstract void visitIincInsn(final int var, final int increment);

	public abstract void visitInvokeDynamicInsn(final String name, final String descriptor, final Handle bootstrapMethodHandle,
			final Object... bootstrapMethodArguments);

	public void InvokeDynamicInsn(final String name, final String descriptor, final Handle bootstrapMethodHandle,
			final Object... bootstrapMethodArguments) {
		stackPop();
		stackPop();
	}

	protected abstract Type typeOfThis();

	protected abstract Type codeThisFieldType(String name);

	protected abstract Type codeThisClassFieldType(String name);

	protected abstract int codeLocalGetLocals(String name);

	public abstract int codeLocalsNextLocal();

	protected abstract Type localsLoadAccess(int index);

	protected abstract Type localsStoreAccess(int index, Type type);

	protected abstract Type stackTypeOf(int i);

	public abstract Type stackPop();

	abstract int stackSize();

	// TODO need to delete
	public int advStackSize() {
		return stackSize();
	}

	public abstract void stackPush(Type type);

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

//	@Override
//	public void LOAD(String firstname, String... names) {
//		LOAD(firstname);
//		for (String name : names) {
//			LOAD(name);
//		}
//	}

	@Override
	public void LOAD(int index) {
		Type valueType = localsLoadAccess(index);
		switch (valueType.getSort()) {
		case Type.OBJECT:
		case Type.ARRAY:
			stackPush(valueType);
			visitVarInsn(ALOAD, index);
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
			stackPush(valueType);
			visitVarInsn(valueType.getOpcode(ILOAD), index);
			break;
		}
	}

	@Override
	public void LOAD_THIS() {
		LOAD(0);
	}

	@Override
	public void LOAD(String varname) {
		int local = codeLocalGetLocals(varname);
		assert local >= 0 : varname + " doesn't exist";
		LOAD(local);
	}

	@Override
	public int STORE(String varname) {
		int local = codeLocalGetLocals(varname);
		if (local >= 0) {
			STORE(local);
		} else {
			define(varname, Clazz.of(stackTypeOf(0)));
			local = codeLocalGetLocals(varname);
			STORE(local);
		}
		return local;
	}

	@Override
	public void STORE(String varname, Class<?> clazz) {
		int local = codeLocalGetLocals(varname);
		if (local < 0) {
			define(varname, clazz);
			local = codeLocalGetLocals(varname);
		}
		STORE(local);
	}

	@Override
	public void STORE(String varname, Clazz clazz) {
		int local = codeLocalGetLocals(varname);
		if (local < 0) {
			define(varname, clazz);
			local = codeLocalGetLocals(varname);
		}
		STORE(local);
	}

	@Override
	public void STORE(String varname, String clazz) {
		int local = codeLocalGetLocals(varname);
		if (local < 0) {
			define(varname, clazz);
			local = codeLocalGetLocals(varname);
		}
		STORE(local);
	}

	public void STOREException(int local) {
		visitVarInsn(ASTORE, local);
	}

	public void STOREException(String varname) {
		int local = codeLocalGetLocals(varname);
		visitVarInsn(ASTORE, local);
	}

	void STORE(int index) {
		Type valueType = stackTypeOf(0);
		Type localType = localsStoreAccess(index, valueType);

		switch (valueType.getSort()) {
		case Type.ARRAY:
//			assert valueType.getSort() == localType.getSort() : "type don't match! local: " + localType + "  stack:" + valueType;
			stackPop();
			visitVarInsn(ASTORE, index);
			// ASTORE (objectref →) : store a reference into a local variable #index
			// ASTORE_0 (objectref →) : store a reference into local variable 0
			// ASTORE_1 (objectref →) : store a reference into local variable 1
			// ASTORE_2 (objectref →) : store a reference into local variable 2
			// ASTORE_3 (objectref →) : store a reference into local variable 3
			break;
		case Type.OBJECT:
			assert valueType.getSort() == localType.getSort() : "type don't match! local: " + localType + "  stack:" + valueType;
			stackPop();
			visitVarInsn(ASTORE, index);
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

			Type type = stackPop();
			visitVarInsn(type.getOpcode(ISTORE), index);

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
	public void LOADConstByte(int value) {
		visitInsn(BIPUSH, value);
		stackPush(Type.INT_TYPE);
	}

	@Override
	public void LOADConstShort(int value) {
		visitInsn(SIPUSH, value);
		stackPush(Type.INT_TYPE);
	}

	@Override
	public void LOADConstNULL() {
		visitInsn(ACONST_NULL);
		stackPush(Type.getType(Object.class));
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
	public void LOADConst(int cst) {
		if (0L == cst || 1L == cst) {
			visitInsn(ICONST_0 + cst);
			stackPush(Type.getType(int.class));
		} else if (Byte.MIN_VALUE <= cst && cst <= Byte.MAX_VALUE) {
			visitInsn(BIPUSH, cst);
			stackPush(Type.getType(int.class));
		} else if (Short.MIN_VALUE <= cst && cst <= Short.MAX_VALUE) {
			visitInsn(SIPUSH, cst);
			stackPush(Type.getType(int.class));
		} else {
			visitLdcInsn(cst);
			stackPush(Type.getType(int.class));
		}
	}

	@Override
	public void LOADConst(Object cst) {

		if (cst instanceof Integer) {
			int v = ((Integer) cst).intValue();
			if (0L == v || 1L == v) {
				visitInsn(ICONST_0 + v);
				stackPush(Type.getType(int.class));
			} else {
				visitLdcInsn(cst);
				stackPush(Type.getType(int.class));
			}
		} else if (cst instanceof Long) {
			long v = ((Long) cst);
			if (0L == v || 1L == v) {
				visitInsn(LCONST_0 + ((Long) cst).intValue());
				stackPush(Type.getType(long.class));
			} else {
				visitLdcInsn(cst);
				stackPush(Type.getType(long.class));
			}
		} else if (cst instanceof Float) {
			float v = ((Float) cst);
			if (0L == v || 1L == v) {
				visitInsn(FCONST_0 + ((Float) cst).intValue());
				stackPush(Type.getType(float.class));
			} else {
				visitLdcInsn(cst);
				stackPush(Type.getType(float.class));
			}
		} else if (cst instanceof Double) {
			double v = ((Double) cst);
			if (0L == v || 1L == v) {
				visitInsn(DCONST_0 + ((Double) cst).intValue());
				stackPush(Type.getType(double.class));
			} else {
				visitLdcInsn(cst);
				stackPush(Type.getType(double.class));
			}
		} else if (cst instanceof String) {
			visitLdcInsn(cst);
			stackPush(Type.getType(String.class));
		} else if (cst instanceof Class<?>) {
			Type cstType = typeOf((Class<?>) cst);

			int sort = ((Type) cstType).getSort();
			if (sort == Type.OBJECT) {
				visitLdcInsn(cstType);
				stackPush(Type.getType(String.class));
			} else if (sort == Type.ARRAY) {
				throw new UnsupportedOperationException();
			} else if (sort == Type.METHOD) {
				throw new UnsupportedOperationException();
			} else {
				throw new UnsupportedOperationException();
			}
		} else if (cst instanceof Clazz) {
			Type cstType = ((Clazz) cst).getType();
			int sort = cstType.getSort();
			if (sort == Type.OBJECT) {
				visitLdcInsn(cst);
				stackPush(Type.getType(String.class));
			} else if (sort == Type.ARRAY) {
				throw new UnsupportedOperationException();
			} else if (sort == Type.METHOD) {
				throw new UnsupportedOperationException();
			} else {
				throw new UnsupportedOperationException();
			}
		} else if (cst instanceof Type) {
			int sort = ((Type) cst).getSort();
			if (sort == Type.BOOLEAN || sort == Type.CHAR || sort == Type.BYTE || sort == Type.SHORT || sort == Type.INT
					|| sort == Type.LONG || sort == Type.FLOAT || sort == Type.DOUBLE) {
				visitLdcInsn(cst);
				stackPush(Type.getType(String.class));
			} else if (sort == Type.OBJECT) {
				visitLdcInsn(cst);
				stackPush(Type.getType(String.class));
			} else if (sort == Type.ARRAY) {
				visitLdcInsn(cst);
				stackPush(Type.getType(String.class));
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
	public void ADD() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);

		visitInsn(type.getOpcode(IADD));
		// DADD (left, right → result) : add two doubles
		// FADD (left, right → result) : add two floats
		// IADD (left, right → result) : add two ints
		// LADD (left, right → result) : add two longs
	}

	public void MATH(int op) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);

		visitInsn(type.getOpcode(op));
	}

	/* Subtract: isub, lsub, fsub, dsub. */
	@Override
	public void SUB() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);
		visitInsn(type.getOpcode(ISUB));
	}

	/* Multiply: imul, lmul, fmul, dmul. */
	@Override
	public void MUL() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);
		visitInsn(type.getOpcode(IMUL));
	}

	/* Divide: idiv, ldiv, fdiv, ddiv. */

	@Override
	public void DIV() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);
		visitInsn(type.getOpcode(IDIV));
		// DDIV (left, right → result) : divide two doubles
		// FDIV (left, right → result) : divide two floats
		// IDIV (left, right → result) : divide two integers
		// LDIV (left, right → result) : divide two longs
	}

	/* Remainder: irem, lrem, frem, drem. */
	@Override
	public void REM() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);
		visitInsn(type.getOpcode(IREM));
	}

	/* Negate: ineg, lneg, fneg, dneg. */
	@Override
	public void NEG() {
		Type value = stackPop();
		Type result = value;
		stackPush(result);
		visitInsn(value.getOpcode(INEG));
	}

	/* Shift: ishl, ishr, iushr, lshl, lshr, lushr. */
	@SuppressWarnings("unused")
	@Override
	public void SHL() {
		Type right = stackPop();
		Type left = stackPop();
		Type result = left;
		stackPush(result);
		visitInsn(left.getOpcode(ISHL));
		// ISHL (left, right → result) : int shift left
		// LSHL (left, right → result) : bitwise shift left of a
		// long left by right positions
	}

	@SuppressWarnings("unused")
	@Override
	public void SHR() {
		Type right = stackPop();
		Type left = stackPop();
		Type result = left;
		stackPush(result);
		visitInsn(left.getOpcode(ISHR));
		// ISHR (left, right → result) : int arithmetic shift right
		// LSHR (left, right → result) : bitwise shift right of a
		// long left by right positions
	}

	/* Bitwise OR: ior, lor. */

	@Override
	public void OR() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);
		visitInsn(type.getOpcode(IOR));
	}

	/* Bitwise AND: iand, land. */

	@Override
	public void AND() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);
		visitInsn(type.getOpcode(IAND));
		// IAND (left, right → result) : perform a bitwise and on two integers
		// LAND (left, right → result) : bitwise and of two longs
	}

	/* Bitwise exclusive OR: ixor, lxor. */
	@Override
	public void XOR() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();

		Type type = checkMathTypes(typeRightValue, typeLeftValue);
		stackPush(type);
		visitInsn(type.getOpcode(IXOR));

		// IXOR (left, right → result) : int xor
		// LXOR (left, right → result) : bitwise exclusive or of two longs
	}

	/* Local variable increment: iinc. */
	/* Comparison: dcmpg, dcmpl, fcmpg, fcmpl, lcmp. */
	@Override
	public void IINC(String varname, int increment) {
		int local = codeLocalGetLocals(varname);
//		Type typeRightValue = stackPop();
//		Type typeLeftValue = stackPop();
//		assert typeRightValue.getSort() == Type.LONG : "actual: " + typeRightValue + "  expected:" + Type.LONG;
//		assert typeRightValue.getSort() == Type.LONG : "actual: " + typeLeftValue + "  expected:" + Type.LONG;
//		stackPush(Type.INT_TYPE);
		visitIincInsn(local, increment);
	}

	public void IINC(int local, int increment) {
//		int local = codeLocalGetLocals(varname);
		Type type = localsLoadAccess(local);
		localsStoreAccess(local, type);
		visitIincInsn(local, increment);
	}

	@Override
	public void LCMP() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		assert typeRightValue.getSort() == Type.LONG : "actual: " + typeRightValue + "  expected:" + Type.LONG;
		assert typeRightValue.getSort() == Type.LONG : "actual: " + typeLeftValue + "  expected:" + Type.LONG;
		stackPush(Type.INT_TYPE);
		visitInsn(LCMP);
	}

	@Override
	public void CMPL() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		assert in(typeRightValue, Type.FLOAT_TYPE, Type.DOUBLE_TYPE)
				: "actual: " + typeRightValue + "  expected:" + Type.FLOAT_TYPE + "," + Type.DOUBLE_TYPE;
		assert in(typeLeftValue, Type.FLOAT_TYPE, Type.DOUBLE_TYPE)
				: "actual: " + typeLeftValue + "  expected:" + Type.FLOAT_TYPE + "," + Type.DOUBLE_TYPE;

		stackPush(Type.INT_TYPE);

		if (typeRightValue == Type.FLOAT_TYPE) {
			visitInsn(FCMPL);
		} else {
			visitInsn(DCMPL);
		}
	}

	@Override
	public void CMPG() {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		assert in(typeRightValue, Type.FLOAT_TYPE, Type.DOUBLE_TYPE)
				: "actual: " + typeRightValue + "  expected:" + Type.FLOAT_TYPE + "," + Type.DOUBLE_TYPE;
		assert in(typeLeftValue, Type.FLOAT_TYPE, Type.DOUBLE_TYPE)
				: "actual: " + typeLeftValue + "  expected:" + Type.FLOAT_TYPE + "," + Type.DOUBLE_TYPE;

		stackPush(Type.INT_TYPE);

		if (typeRightValue == Type.FLOAT_TYPE) {
			visitInsn(FCMPG);
		} else {
			visitInsn(DCMPG);
		}
	}

	@Override
	public void CONVERTTO(Class<?> typeTo) {
		CONVERTTO(typeOf(typeTo));
	}

	@Override
	public void CONVERTTO(Clazz typeTo) {
		CONVERTTO(typeOf(typeTo));
	}

	@Override
	public void CONVERTTO(String typeTo) {
		CONVERTTO(typeOf(typeTo));
	}

	/*
	 * 2.11.4. Type Conversion Instructions
	 * 
	 * int to byte, short, or char long to int float to int or long double to int,
	 * long, or float
	 */
	public void CONVERTTO(Type typeTo) {
		Type typeFrom = stackPop();
		stackPush(typeTo);

		switch (typeFrom.getSort()) {
		case Type.LONG:
			switch (typeTo.getSort()) {
			case Type.INT:
				visitInsn(L2I);
				break;
			case Type.FLOAT:
				visitInsn(L2F);
				break;
			case Type.DOUBLE:
				visitInsn(L2D);
				break;

			default:
				break;
			}
			break;
		case Type.BYTE:
		case Type.SHORT:
		case Type.CHAR:
		case Type.INT:
			switch (typeTo.getSort()) {
			case Type.BOOLEAN:
				visitInsn(I2B);
				break;
			case Type.SHORT:
				visitInsn(I2S);
				break;
			case Type.LONG:
				visitInsn(I2L);
				break;
			case Type.FLOAT:
				visitInsn(I2F);
				break;
			case Type.DOUBLE:
				visitInsn(I2D);
				break;
			case Type.CHAR:
				visitInsn(I2C);
				break;
			case Type.BYTE:
				visitInsn(I2B);
				break;

			default:
//				throw new UnsupportedOperationException();
			}
			break;
		case Type.FLOAT:

			switch (typeTo.getSort()) {
			case Type.LONG:
				visitInsn(F2L);
				break;
			case Type.INT:
				visitInsn(F2I);
				break;
			case Type.DOUBLE:
				visitInsn(F2D);
				break;

			default:
//				throw new UnsupportedOperationException();
			}
			break;
		case Type.DOUBLE:
			switch (typeTo.getSort()) {
			case Type.LONG:
				visitInsn(D2L);
				break;
			case Type.INT:
				visitInsn(D2I);
				break;
			case Type.FLOAT:
				visitInsn(D2F);
				break;

			default:
//				throw new UnsupportedOperationException();
			}
			break;
		default:
//			throw new UnsupportedOperationException("Cannot " + typeFrom.getClassName() + " - " + typeTo.getClassName());

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
	public void NEW(Class<?> objectclazz) {
		NEW(typeOf(objectclazz));
	}

	@Override
	public void NEW(Clazz objectclazz) {
		NEW(objectclazz.getType());
	}

	@Override
	public void NEW(String objectclazz) {
		NEW(typeOf(objectclazz));
	}

	public void NEW(Type objectclazz) {
		stackPush(objectclazz);
		visitTypeInsn(NEW, objectclazz);
		// NEW (→ objectref) : create new object of type identified by class reference
		// in constant pool index (indexbyte1 << 8 + indexbyte2)
	}

	/* Create a new array: newarray, anewarray, multianewarray. */
	@Override
	public void NEWARRAY(Class<?> type) {
		NEWARRAY(typeOf(type));
	}

	@Override
	public void NEWARRAY(Clazz type) {
		NEWARRAY(typeOf(type));
	}

	@Override
	public void NEWARRAY(String type) {
		NEWARRAY(typeOf(type));
	}

	public void NEWARRAY(Type type) {
		Type count = stackPop();
		assert in(count, Type.INT_TYPE, Type.BYTE_TYPE, Type.SHORT_TYPE) : "array count type " + type;
//		 TODO NEWARRAY Type arrayref = Type.getType(Object.class);

		Type arrayType = arrayOf(type, true);
		stackPush(arrayType);

		if (Type.BOOLEAN <= type.getSort() && type.getSort() <= Type.DOUBLE) {
			int typecode = TypeUtils.arrayTypeMaps.get(type);
			visitInsn(NEWARRAY, typecode);
		} else if (type.getSort() == Type.ARRAY) visitTypeInsn(ANEWARRAY, type);
		else if (type.getSort() == Type.OBJECT) visitTypeInsn(ANEWARRAY, type);
		else if (type.getSort() == Type.VOID) RETURN();
		else throw new UnsupportedOperationException();
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
	public void ARRAYLENGTH(String array) {
		LOAD(array);
		ARRAYLENGTH();
	}

	@SuppressWarnings("unused")
	@Override
	public void ARRAYLENGTH() {
		Type arrayref = stackPop();
		Type length = Type.INT_TYPE;
		visitInsn(ARRAYLENGTH);
		stackPush(length);
		// ARRAYLENGTH (arrayref → length) : get the length of an array
	}

//	@Override
//	@SuppressWarnings("unused")
//	public void ARRAYLOAD(Class<?> elementClazz) {
//		Type elementType= typeOf(elementClazz);
//		Type index = stackPop();
//		Type arrayref = stackPop();
//		visitInsn(elementType.getOpcode(IALOAD));
//		stackPush(elementType);
//	}
//
//	@Override
//	@SuppressWarnings("unused")
//	public void ARRAYLOAD(String elementClazz) {
//		Type elementType= typeOf(elementClazz);
//		Type index = stackPop();
//		Type arrayref = stackPop();
//		visitInsn(elementType.getOpcode(IALOAD));
//		stackPush(elementType);
//	}
	@Override
	@SuppressWarnings("unused")
	public void ARRAYLOAD() {
		Type index = stackPop();
		Type arrayref = stackPop();
		Type elementType = arrayref.getElementType();
		visitInsn(elementType.getOpcode(IALOAD));
		stackPush(elementType);
	}

	@SuppressWarnings("unused")
	@Override
	public void ARRAYSTORE() {
		Type value = stackPop();
		Type index = stackPop();
		Type arrayref = stackPop();
		Type elementType = arrayref.getElementType();

		visitInsn(elementType.getOpcode(IASTORE));

//		switch (itemType.getSort()) {
//		// BASTORE (arrayref, index, value →) : store a byte or Boolean value into an
//		// array
//		case Type.BYTE:
//			visitInsn(itemType.getOpcode(IASTORE));
//			break;
//		// CASTORE (arrayref, index, value →) : store a char into an array
//		case Type.CHAR:
//			visitInsn(itemType.getOpcode(IASTORE));
//			break;
//		// DASTORE (arrayref, index, value →) : store a double into an array
//		case Type.DOUBLE:
//			visitInsn(itemType.getOpcode(IASTORE));
//			break;
//		// FASTORE (arrayref, index, value →) : store a float in an array
//		case Type.FLOAT:
//			visitInsn(itemType.getOpcode(IASTORE));
//			break;
//		// IASTORE (arrayref, index, value →) : store an int into an array
//		case Type.INT:
//			visitInsn(itemType.getOpcode(IASTORE));
//			break;
//		// LASTORE (arrayref, index, value →) : store a long to an array
//		case Type.LONG:
//			visitInsn(itemType.getOpcode(IASTORE));
//			break;
//		// SASTORE (arrayref, index, value →) : store short to array
//		case Type.SHORT:
//			visitInsn(itemType.getOpcode(IASTORE));
//			break;
//		// AASTORE (arrayref, index, value →) : store into a reference in an array
//		case Type.OBJECT:
//			visitInsn(AASTORE);
//			break;
//		default:
//			throw new UnsupportedOperationException();
//		}
	}

	@Override
	public void INSTANCEOF(Class<?> type) {
		INSTANCEOF(typeOf(type));
	}

	@Override
	public void INSTANCEOF(Clazz type) {
		INSTANCEOF(typeOf(type));
	}

	@Override
	public void INSTANCEOF(String type) {
		INSTANCEOF(typeOf(type));
	}

	/* Check properties of class instances or arrays: instanceof, checkcast. */
	@SuppressWarnings("unused")
	public void INSTANCEOF(Type type) {
		Type objectref = stackPop();
		Type result = Type.getType(int.class);
		stackPush(result);
		visitTypeInsn(INSTANCEOF, type);
		// INSTANCEOF (objectref → result) : determines if an object objectref is of a
		// given type, identified by class reference index in constant pool (indexbyte1
		// << 8 + indexbyte2)
	}

	@Override
	public void CHECKCAST(Class<?> type) {
		CHECKCAST(typeOf(type));
	}

	@Override
	public void CHECKCAST(Clazz type) {
		CHECKCAST(typeOf(type));
	}

	@Override
	public void CHECKCAST(String type) {
		CHECKCAST(typeOf(type));
	}

	public void CHECKCAST(Type type) {
		stackPop();
		stackPush(type);
		visitTypeInsn(CHECKCAST, type);
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
	public void POP() {
		Type left = stackPop();
		visitInsn(POP);
	}

	@SuppressWarnings("unused")
	@Override
	public void POP2() {
		Type right = stackPop();
		Type left = stackPop();
		visitInsn(POP2);
	}

	@Override
	public void DUP() {
		Type left = stackTypeOf(0);
		stackPush(left);
		visitInsn(DUP);
		// DUP (value → value, value) : duplicate the value on top of the stack
	}

	@Override
	public void DUP2() {
		Type right = stackTypeOf(-1);
		Type left = stackTypeOf(0);
		stackPush(right);
		stackPush(left);
		stackPush(right);
		stackPush(left);
		visitInsn(DUP2);
	}

	@Override
	public void NOP() {
		visitInsn(Opcodes.NOP);
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
	public void IFEQ(Label falseLabel) {
		Type value = stackPop();
		assert in(value, Type.BOOLEAN_TYPE, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		visitJumpInsn(IFEQ, falseLabel);
	}

	public void JUMP(int opcode, Label falseLabel) {
		Type value = stackPop();
		assert in(value, Type.BOOLEAN_TYPE, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		visitJumpInsn(opcode, falseLabel);
	}

	@Override
	public void IFNE(Label falseLabel) {
		Type value = stackPop();
		assert in(value, Type.INT_TYPE, Type.BOOLEAN_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE + " | " + Type.BOOLEAN_TYPE;
		visitJumpInsn(IFNE, falseLabel);
	}

	public Label IFNE() {
		Label falseLabel = new Label();
		Type value = stackPop();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		visitJumpInsn(IFNE, falseLabel);
		return falseLabel;
	}

	@Override
	public void IFLT(Label falseLabel) {
		Type value = stackPop();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		visitJumpInsn(IFLT, falseLabel);
	}

	@Override
	public void IFLE(Label falseLabel) {
		Type value = stackPop();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		visitJumpInsn(IFLE, falseLabel);
	}

	@Override
	public void IFGT(Label falseLabel) {
		Type value = stackPop();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		visitJumpInsn(IFGT, falseLabel);
	}

	@Override
	public void IFGE(Label falseLabel) {
		Type value = stackPop();
		assert in(value, Type.INT_TYPE) : "actual: " + value + "  expected:" + Type.INT_TYPE;
		visitJumpInsn(IFGE, falseLabel);
	}

	@Override
	public void IFNULL(Label falseLabel) {
		Type value = stackPop();
		assert value.getSort() == Type.OBJECT : "actual: " + value + "  expected:" + Type.OBJECT;
		visitJumpInsn(IFNULL, falseLabel);
	}

	@Override
	public void IFNONNULL(Label falseLabel) {
		Type value = stackPop();
		assert value.getSort() == Type.OBJECT : "actual: " + value + "  expected:" + Type.OBJECT;
		visitJumpInsn(IFNONNULL, falseLabel);
	}

	@Override
	public void IF_ACMPEQ(Label falseLabel) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		assert typeRightValue.getSort() == Type.OBJECT;
		assert typeLeftValue.getSort() == Type.OBJECT;
		visitJumpInsn(IF_ACMPEQ, falseLabel);
	}

	@Override
	public void IF_ACMPNE(Label falseLabel) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		assert typeRightValue.getSort() == Type.OBJECT;
		assert typeLeftValue.getSort() == Type.OBJECT;
		visitJumpInsn(IF_ACMPNE, falseLabel);
	}

	@Override
	public void IF_ICMPEQ(Label falseLabel) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		checkMathTypes(typeRightValue, typeLeftValue);

		visitJumpInsn(IF_ICMPEQ, falseLabel);
	}

	@Override
	public void IF_ICMPNE(Label falseLabel) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		checkMathTypes(typeRightValue, typeLeftValue);

		visitJumpInsn(IF_ICMPNE, falseLabel);
	}

	@Override
	public void IF_ICMPLT(Label falseLabel) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		checkMathTypes(typeRightValue, typeLeftValue);

		visitJumpInsn(IF_ICMPLT, falseLabel);
	}

	@Override
	public void IF_ICMPLE(Label falseLabel) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		checkMathTypes(typeRightValue, typeLeftValue);

		visitJumpInsn(IF_ICMPLE, falseLabel);
	}

	@Override
	public void IF_ICMPGT(Label falseLabel) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		checkMathTypes(typeRightValue, typeLeftValue);

		visitJumpInsn(IF_ICMPGT, falseLabel);
	}

	@Override
	public void IF_ICMPGE(Label falseLabel) {
		Type typeRightValue = stackPop();
		Type typeLeftValue = stackPop();
		checkMathTypes(typeRightValue, typeLeftValue);

		visitJumpInsn(IF_ICMPGE, falseLabel);
	}

	/* Compound conditional branch: tableswitch, lookupswitch. */
	// TODO tableswitch, lookupswitch.

	/* Unconditional branch: goto, goto_w, jsr, jsr_w, ret. */
	@Override
	public void GOTO(Label gotoLabel) {
		visitJumpInsn(GOTO, gotoLabel);
	}

	@Override
	public void RETURN() {
		visitInsn(RETURN);
	}

//	@Override
//	public void RETURN(int i) {
//		LOADConstByte(i);
//		RETURNTop();
//	}

	@Override
	public void RETURN(String varname) {
		LOAD(varname);
		RETURNTop();
	}

	@Override
	public void RETURNTop() {
		Type type = stackTypeOf(0);
		if (Type.BOOLEAN <= type.getSort() && type.getSort() <= Type.DOUBLE) {
			Type objectref = stackPop();
			visitInsn(objectref.getOpcode(IRETURN));
			// DRETURN (value → [empty]) : return a double from a method
			// FRETURN (value → [empty]) : return a float
			// IRETURN (value → [empty]) : return an integer from a method
			// LRETURN (value → [empty]) : return a long value
		} else if (type.getSort() == Type.OBJECT) {
			// ARETURN (objectref → [empty]) : return a reference from a method
			stackPop();
			visitInsn(ARETURN);
		} else if (type.getSort() == Type.ARRAY) {
			// ARETURN (objectref → [empty]) : return a reference from a method
			stackPop();
			visitInsn(ARETURN);
		} else throw new UnsupportedOperationException();
	}

	@Override
	public void ATHROW() {
		visitInsn(ATHROW);
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

	int _THIS = 0;

	@Override
	public void GETFIELD_OF_THIS(String fieldname) {
		GETFIELD(fieldname, codeThisFieldType(fieldname));
	}

	@Override
	public void GETFIELD(String fieldname, Class<?> fieldType) {
		GETFIELD(fieldname, typeOf(fieldType));
	}

	@Override
	public void GETFIELD(String fieldname, String fieldType) {
		GETFIELD(fieldname, typeOf(fieldType));
	}

	@Override
	public void GETFIELD(String fieldname, Clazz fieldType) {
		GETFIELD(fieldname, typeOf(fieldType));
	}

	public void GETFIELD(String fieldname, Type fieldType) {
		Type objectref = stackPop();
		stackPush(fieldType);
		visitFieldInsn(GETFIELD, objectref, fieldname, fieldType);

		// GETFIELD (objectref → value) : get a field value of an object objectref,
		// where the field is identified by field reference in the constant
		// pool index (index1 << 8 + index2)
	}

	@Override
	public void PUTFIELD_OF_THIS(String fieldname) {
		PUTFIELD(fieldname, codeThisFieldType(fieldname));
	}

	@Override
	public void PUTFIELD(String fieldname, Class<?> fieldType) {
		PUTFIELD(fieldname, typeOf(fieldType));
	}

	@Override
	public void PUTFIELD(String fieldname, String fieldType) {
		PUTFIELD(fieldname, typeOf(fieldType));
	}

	@SuppressWarnings("unused")
	public void PUTFIELD(String fieldname, Type fieldType) {
		Type value = stackPop();
		Type objectref = stackPop();

		visitFieldInsn(PUTFIELD, objectref, fieldname, fieldType);

		// PUTFIELD (objectref, value →) : set field to value in an object objectref,
		// where the field is identified by a field reference index in constant pool
		// (indexbyte1 << 8 + indexbyte2)
	}

	@Override
	public void GETSTATIC(Class<?> objectType, String fieldName, Class<?> fieldType) {
		GETSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	@Override
	public void GET_THIS_STATIC(String fieldName) {
		Type objectRef = typeOfThis();
		Type valueType = codeThisClassFieldType(fieldName);
		visitFieldInsn(GETSTATIC, objectRef, fieldName, valueType);
		stackPush(valueType);
	}

	@Override
	public void GETSTATIC(String objectType, String fieldName, String fieldType) {
		GETSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	public void GETSTATIC(Type objectType, String fieldName, Type fieldType) {
		stackPush(fieldType);
		visitFieldInsn(GETSTATIC, objectType, fieldName, fieldType);
		// GETSTATIC (→ value) : get a static field value of a class, where the field is
		// identified by field reference in the constant pool index (index1 << 8 +
		// index2)
	}

	@Override
	public void PUTSTATIC(Class<?> objectType, String fieldName, Class<?> fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	@Override
	@SuppressWarnings("unused")
	public void PUT_THIS_STATIC(String fieldName) {
		Type objectRef = typeOfThis();
		Type value = stackPop();
		Type valueType = codeThisClassFieldType(fieldName);
		visitFieldInsn(PUTSTATIC, objectRef, fieldName, valueType);
	}

	@Override
	public void PUTSTATIC(String objectType, String fieldName, String fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	@SuppressWarnings("unused")
	public void PUTSTATIC(Type objectType, String fieldName, Type fieldType) {
		Type value = stackPop();
		visitFieldInsn(PUTSTATIC, objectType, fieldName, fieldType);

		// PUTSTATIC (value →) : set static field to value in a class, where the field
		// is identified by a field reference index in constant pool (indexbyte1 << 8 +
		// indexbyte2)
	}

	/** INVOKE **/
	@Override
	public void INVOKESTATIC(Class<?> objectType, String methodName, Class<?>... paramTypes) {
		INVOKESTATIC(typeOf(objectType), Type.VOID_TYPE, methodName, typeOf(paramTypes));
	}

	@Override
	public void INVOKESTATIC(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKESTATIC(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	public void INVOKESTATIC(String objectType, String returnType, String methodName, String... paramTypes) {
		INVOKESTATIC(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@SuppressWarnings("unused")
	public void INVOKESTATIC(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			stackPop();
		}
		visitMethodInsn(INVOKESTATIC, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) stackPush(returnType);
		// INVOKESTATIC ([arg1, arg2, ...] →) : invoke a static method, where the method
		// is identified by method reference index in constant pool (indexbyte1 << 8 +
		// indexbyte2)

	}

	@Override
	public void INVOKEINTERFACE(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKEINTERFACE(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	public void INVOKEINTERFACE(String objectType, String returnType, String methodName, String... paramTypes) {
		INVOKEINTERFACE(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@SuppressWarnings("unused")
	public void INVOKEINTERFACE(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			stackPop();
		}
		stackPop(); // objectType
		visitMethodInsn(INVOKEINTERFACE, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) stackPush(returnType);
		// INVOKEINTERFACE (objectref, [arg1, arg2, ...] →) : invokes an interface
		// method on object objectref, where the interface method is identified by
		// method reference index in constant pool (indexbyte1 << 8 + indexbyte2)

	}

	@Override
	public void INVOKESPECIAL(Class<?> objectType, String methodName, Class<?>... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), null, methodName, typeOf(paramTypes));
	}

	@Override
	public void INVOKESPECIAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	public void INVOKESPECIAL(String objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	public void INVOKESPECIAL(String objectType, String returnType, String methodName, String... paramTypes) {
		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@SuppressWarnings("unused")
	public void INVOKESPECIAL(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		if (returnType == null) returnType = Type.VOID_TYPE;
		for (Type type : paramTypes) {
			stackPop();
		}
		stackPop(); // objectType
		visitMethodInsn(INVOKESPECIAL, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) stackPush(returnType);
		// INVOKESPECIAL (objectref, [arg1, arg2, ...] →) : invoke instance method on
		// object objectref, where the method is identified by method reference indexin
		// constant pool (indexbyte1 << 8 + indexbyte2)
	}

	@Override
	public void INVOKEVIRTUAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
		INVOKEVIRTUAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@Override
	public void INVOKEVIRTUAL(String objectType, String returnType, String methodName, String... paramTypes) {
		INVOKEVIRTUAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	}

	@SuppressWarnings("unused")
	public void INVOKEVIRTUAL(Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			stackPop();
		}
		stackPop(); // objectType
		visitMethodInsn(INVOKEVIRTUAL, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) stackPush(returnType);

	}

	@SuppressWarnings("unused")
	public void INVOKE(int opcode, Type objectType, Type returnType, String methodName, Type... paramTypes) {
		for (Type type : paramTypes) {
			stackPop();
		}
		if (opcode != INVOKESTATIC) stackPop(); // objectType
		visitMethodInsn(opcode, objectType, returnType, methodName, paramTypes);
		if (returnType != Type.VOID_TYPE) stackPush(returnType);

	}

	@Override
	public MethodCaller<MethodCode> SPECIAL(String methodName) {
		return SPECIAL(Clazz.of(typeOfThis()), methodName);
	}
	
	@Override
	public MethodCaller<MethodCode> VIRTUAL(String methodName) {
		return VIRTUAL(Clazz.of(typeOfThis()), methodName);
	}

	public abstract void END();

	abstract Label codeNewLabel();

}