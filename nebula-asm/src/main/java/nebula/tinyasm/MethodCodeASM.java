package nebula.tinyasm;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

interface MethodCodeASM {

	void codeAccessLabel(Label label);

	void codeAccessLabel(Label label, int line);

	void LOADThis();

	void LOADThisField(String fieldname, Type feildtype);

	void LOAD(String... names);

	void LOAD(String name);

	void STORE(String varname);

	void LOADConstByte(int value);

	void LOADConstShort(int value);

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

	void LOADConst(Object cst);

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
	void ADD(String left, String right);

	void ADD();

	void SUB(String left, String right);

	void SUB();

	/* Multiply: imul, lmul, fmul, dmul. */
	void MUL(String left, String right);

	void MUL();

	/* Divide: idiv, ldiv, fdiv, ddiv. */
	void DIV(String left, String right);

	void DIV();

	/* Remainder: irem, lrem, frem, drem. */
	void REM(String left, String right);

	void REM();

	/* Negate: ineg, lneg, fneg, dneg. */
	void NEG(String left);

	void NEG();

	/* Shift: ishl, ishr, iushr, lshl, lshr, lushr. */
	void SHL();

	void SHR();

	/* Bitwise OR: ior, lor. */
	void OR(String left, String right);

	void OR();

	/* Bitwise AND: iand, land. */
	void AND(String left, String right);

	void AND();

	/* Bitwise exclusive OR: ixor, lxor. */
	void XOR(String left, String right);

	void XOR();

	void CMP();

	void CMPL();

	void CMPG();

	/*
	 * 2.11.4. Type Conversion Instructions
	 * 
	 * int to byte, short, or char long to int float to int or long double to int,
	 * long, or float
	 */
	void CONVERTTO(Type typeTo);

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
	void NEW(Class<?> objectref);

	void NEW(Type objectref);

	/* Create a new array: newarray, anewarray, multianewarray. */
	void NEWARRAY(String count, Type type);

	void NEWARRAY(Type type);

	void ARRAYLENGTH(String array);

	void ARRAYLENGTH();

	void ARRAYLOAD(String arrayref, String index, Type valueType);

	void ARRAYLOAD(Type value);

	void ARRAYSTORE(String varArray, String index, String value);

	void ARRAYSTORE();

	/* Check properties of class instances or arrays: instanceof, checkcast. */
	void INSTANCEOF(Type type);

	void CHECKCAST(Type type);

	/*
	 * 2.11.6. Operand Stack Management Instructions A number of instructions are
	 * provided for the direct manipulation of the operand stack: pop, pop2, dup,
	 * dup2, dup_x1, dup2_x1, dup_x2, dup2_x2, swap.
	 */
	void POP();

	void POP2();

	void DUP();

	void DUP2();

	void NOP();

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
	void IFEQ(Label falseLabel);

	void IFNE(Label falseLabel);

	void IFLT(Label falseLabel);

	void IFLE(Label falseLabel);

	void IFGT(Label falseLabel);

	void IFGE(Label falseLabel);

	void IFNULL(Label falseLabel);

	void IFNONNULL(Label falseLabel);

	void IF_ACMPEQ(Label falseLabel);

	void IF_ACMPNE(Label falseLabel);

	void IF_ICMPEQ(Label falseLabel);

	void IF_ICMPNE(Label falseLabel);

	void IF_ICMPLT(Label falseLabel);

	void IF_ICMPLE(Label falseLabel);

	void IF_ICMPGT(Label falseLabel);

	void IF_ICMPGE(Label falseLabel);

	/* Unconditional branch: goto, goto_w, jsr, jsr_w, ret. */
	void GOTO(Label gotoLabel);

	void RETURN();

	void RETURN(int i);

	void RETURN(String varname);

	void RETURNTop();

	String _THIS = "this";

	void INITObject();

	/** ARRAY **/
	void GETFIELD(String objectname, String fieldname, Type fieldType);

	void GETFIELD(String fieldname, Type fieldType);

	void PUTFIELD(String objectref, String varname, String fieldname, Type fieldType);

	void PUTFIELD(String fieldname, Type fieldType);

	void GETSTATIC(Type objectType, String fieldName, Type fieldType);

	void PUTSTATIC(Type objectType, String varname, String fieldname, Type fieldType);

	void PUTSTATIC(Type objectType, String fieldName, Type fieldType);

	/** INVOKE **/
	void INVOKESTATIC(Class<?> objectType, String methodName, Class<?>... paramTypes);

	void INVOKESTATIC(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes);

	void INVOKESTATIC(Type objectType, Type returnType, String methodName, Type... paramTypes);

	void INVOKEINTERFACE(Type objectType, Type returnType, String methodName, Type... paramTypes);

	void INVOKESPECIAL(Class<?> objectType, String methodName, Class<?>... paramTypes);

	void INVOKESPECIAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes);

	void INVOKESPECIAL(Type objectType, Type returnType, String methodName, Type... paramTypes);

	void INVOKEVIRTUAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes);

	void INVOKEVIRTUAL(Type objectType, Type returnType, String methodName, Type... paramTypes);
}