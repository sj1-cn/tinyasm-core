package cn.sj1.tinyasm.core;

import static cn.sj1.tinyasm.core.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.IADD;
import static org.objectweb.asm.Opcodes.IAND;
import static org.objectweb.asm.Opcodes.IDIV;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFGE;
import static org.objectweb.asm.Opcodes.IFGT;
import static org.objectweb.asm.Opcodes.IFLE;
import static org.objectweb.asm.Opcodes.IFLT;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.IF_ACMPEQ;
import static org.objectweb.asm.Opcodes.IF_ACMPNE;
import static org.objectweb.asm.Opcodes.IF_ICMPEQ;
import static org.objectweb.asm.Opcodes.IF_ICMPGE;
import static org.objectweb.asm.Opcodes.IF_ICMPGT;
import static org.objectweb.asm.Opcodes.IF_ICMPLE;
import static org.objectweb.asm.Opcodes.IF_ICMPLT;
import static org.objectweb.asm.Opcodes.IF_ICMPNE;
import static org.objectweb.asm.Opcodes.IMUL;
import static org.objectweb.asm.Opcodes.IOR;
import static org.objectweb.asm.Opcodes.IREM;
import static org.objectweb.asm.Opcodes.ISHL;
import static org.objectweb.asm.Opcodes.ISHR;
import static org.objectweb.asm.Opcodes.ISUB;
import static org.objectweb.asm.Opcodes.IXOR;

import java.util.function.Consumer;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

public interface MethodCodeASM {
	void BOX_Top();

	void UNBOX_Top();

	void BLOCK(Consumer<MethodCode> mc);

	void LINE();

	void LINE(int line);

	void LOAD(String name);

	void LOAD_THIS();

	void LOAD(int local);

	//	void LOAD(String name, String... names);

	int STORE(String varname);

	default void STORE(String varname, Class<?> clazz) {
		STORE(varname, Clazz.of(clazz));
	}

	default void STORE(String varname, String clazz) {
		STORE(varname, Clazz.of(clazz));
	}

	void STORE(String varname, Clazz clazz);

	//	void STORE(int local);
	//
	//	void LOADConstByte(int value);
	//
	//	void LOADConstShort(int value);

	void LOADConstNULL();

	//	/**
	//	 * Visits an instruction with a single int operand.
	//	 * 
	//	 * @param opcode  the opcode of the instruction to be visited. This opcode is
	//	 *                either BIPUSH, SIPUSH or NEWARRAY.
	//	 * @param operand the operand of the instruction to be visited.<br>
	//	 *                When opcode is BIPUSH, operand value should be between
	//	 *                Byte.MIN_VALUE and Byte.MAX_VALUE.<br>
	//	 *                When opcode is SIPUSH, operand value should be between
	//	 *                Short.MIN_VALUE and Short.MAX_VALUE.<br>
	//	 *                When opcode is NEWARRAY, operand value should be one of
	//	 *                {@link Opcodes#T_BOOLEAN}, {@link Opcodes#T_CHAR},
	//	 *                {@link Opcodes#T_FLOAT}, {@link Opcodes#T_DOUBLE},
	//	 *                {@link Opcodes#T_BYTE}, {@link Opcodes#T_SHORT},
	//	 *                {@link Opcodes#T_INT} or {@link Opcodes#T_LONG}.
	//	 */

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
	void ARITHMETIC(int opcode);

	default void ADD() {
		ARITHMETIC(IADD);
	}

	/* Subtract: isub, lsub, fsub, dsub. */

	default void SUB() {
		ARITHMETIC(ISUB);
	}

	/* Multiply: imul, lmul, fmul, dmul. */

	default void MUL() {
		ARITHMETIC(IMUL);
	}

	/* Divide: idiv, ldiv, fdiv, ddiv. */

	default void DIV() {
		ARITHMETIC(IDIV);
	}

	/* Remainder: irem, lrem, frem, drem. */

	default void REM() {
		ARITHMETIC(IREM);
	}

	/* Negate: ineg, lneg, fneg, dneg. */

	void NEG();

	/* Shift: ishl, ishr, iushr, lshl, lshr, lushr. */
	void SH(int opcode);

	default void SHL() {
		SH(ISHL);
	}

	default void SHR() {
		SH(ISHR);
	}

	/* Bitwise OR: ior, lor. */
	/* Bitwise OR: ior, lor. */
	default void OR() {
		ARITHMETIC(IOR);
	}
	/* Bitwise AND: iand, land. */

	default void AND() {
		ARITHMETIC(IAND);
	}

	/* Bitwise exclusive OR: ixor, lxor. */
	default void XOR() {
		ARITHMETIC(IXOR);
	}

	void IINC(String varname, int increment);

	void LCMP();

	void CMPL();

	void CMPG();

	/*
	 * 2.11.4. Class<?> Conversion Instructions
	 * 
	 * int to byte, short, or char long to int float to int or long double to int,
	 * long, or float
	 */
	void CONVERTTO(Type typeTo);

	default void CONVERTTO(Class<?> typeTo) {
		CONVERTTO(typeOf(typeTo));
	}

	default void CONVERTTO(Clazz typeTo) {
		CONVERTTO(typeOf(typeTo));
	}

	default void CONVERTTO(String typeTo) {
		CONVERTTO(typeOf(typeTo));
	}

	//	/*
	//	 * 2.11.5. Object Creation and Manipulation Although both class instances and
	//	 * arrays are objects, the Java Virtual Machine creates and manipulates class
	//	 * instances and arrays using distinct sets of instructions:
	//	 */
	//	/* Create a new class instance: new. */
	//	/**
	//	 * Visits a LDC instruction. Note that new constant types may be added in future
	//	 * versions of the Java Virtual Machine. To easily detect new constant types,
	//	 * implementations of this method should check for unexpected constant types,
	//	 * like this:
	//	 * 
	//	 * <pre>
	//	 * if (cst instanceof Integer) {
	//	 * 	// ...
	//	 * } else if (cst instanceof Float) {
	//	 * 	// ...
	//	 * } else if (cst instanceof Long) {
	//	 * 	// ...
	//	 * } else if (cst instanceof Double) {
	//	 * 	// ...
	//	 * } else if (cst instanceof String) {
	//	 * 	// ...
	//	 * } else if (cst instanceof Class<?>) {
	//	 * 	int sort = ((Class<?>) cst).getSort();
	//	 * 	if (sort == Class<?>.OBJECT) {
	//	 * 		// ...
	//	 * 	} else if (sort == Class<?>.ARRAY) {
	//	 * 		// ...
	//	 * 	} else if (sort == Class<?>.METHOD) {
	//	 * 		// ...
	//	 * 	} else {
	//	 * 		// throw an exception
	//	 * 	}
	//	 * } else if (cst instanceof Handle) {
	//	 * 	// ...
	//	 * } else {
	//	 * 	// throw an exception
	//	 * }
	//	 * </pre>
	//	 */

	void NEW(Type objectclazz);

	default void NEW(Class<?> objectclazz) {
		NEW(typeOf(objectclazz));
	}

	default void NEW(Clazz objectclazz) {
		NEW(objectclazz.getType());
	}

	default void NEW(String objectclazz) {
		NEW(typeOf(objectclazz));
	}

	/* Create a new array: newarray, anewarray, multianewarray. */

	void NEWARRAY(Type clazz);

	default void NEWARRAY(Class<?> type) {
		NEWARRAY(typeOf(type));
	}

	default void NEWARRAY(Clazz type) {
		NEWARRAY(typeOf(type));
	}

	default void NEWARRAY(String type) {
		NEWARRAY(typeOf(type));
	}

//	void ARRAYLENGTH(String array);

	void ARRAYLENGTH();

	void ARRAYLOAD();

	void ARRAYSTORE();

	/* Check properties of class instances or arrays: instanceof, checkcast. */
	void INSTANCEOF(Type clazz);

	default void INSTANCEOF(Class<?> type) {
		INSTANCEOF(typeOf(type));
	}

	default void INSTANCEOF(Clazz type) {
		INSTANCEOF(typeOf(type));
	}

	default void INSTANCEOF(String type) {
		INSTANCEOF(typeOf(type));
	}

	void CHECKCAST(Type clazz);

	default void CHECKCAST(Class<?> type) {
		CHECKCAST(typeOf(type));
	}

	default void CHECKCAST(Clazz type) {
		CHECKCAST(typeOf(type));
	}

	default void CHECKCAST(String type) {
		CHECKCAST(typeOf(type));
	}

	/*
	 * 2.11.6. Operand Stack Management Instructions A number of instructions are
	 * provided for the direct manipulation of the operand stack: pop, pop2, dup,
	 * dup2, dup_x1, dup2_x1, dup_x2, dup2_x2, swap.
	 */
	void POP();

	void DUP();

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
	void IF(int opcode, Label falseLabel);

	default void IFEQ(Label falseLabel) {
		IF(IFEQ, falseLabel);
	}

	default void IFNE(Label falseLabel) {
		IF(IFNE, falseLabel);
	}

	default void IFLT(Label falseLabel) {
		IF(IFLT, falseLabel);
	}

	default void IFLE(Label falseLabel) {
		IF(IFLE, falseLabel);
	}

	default void IFGT(Label falseLabel) {
		IF(IFGT, falseLabel);
	}

	default void IFGE(Label falseLabel) {
		IF(IFGE, falseLabel);
	}

	void IFNULL(Label falseLabel);

	void IFNONNULL(Label falseLabel);

	void IF_ACMP(int opcode, Label falseLabel);

	default void IF_ACMPEQ(Label falseLabel) {
		IF_ACMP(IF_ACMPEQ, falseLabel);
	}

	default void IF_ACMPNE(Label falseLabel) {
		IF_ACMP(IF_ACMPNE, falseLabel);
	}

	void IF_ICMP(int opcode, Label falseLabel);

	default void IF_ICMPEQ(Label falseLabel) {
		IF_ICMP(IF_ICMPEQ, falseLabel);
	}

	default void IF_ICMPNE(Label falseLabel) {
		IF_ICMP(IF_ICMPNE, falseLabel);
	}

	default void IF_ICMPLT(Label falseLabel) {
		IF_ICMP(IF_ICMPLT, falseLabel);
	}

	default void IF_ICMPLE(Label falseLabel) {
		IF_ICMP(IF_ICMPLE, falseLabel);
	}

	default void IF_ICMPGT(Label falseLabel) {
		IF_ICMP(IF_ICMPGT, falseLabel);
	}

	default void IF_ICMPGE(Label falseLabel) {
		IF_ICMP(IF_ICMPGE, falseLabel);
	}

	/* Unconditional branch: goto, goto_w, jsr, jsr_w, ret. */
	void GOTO(Label gotoLabel);

	void RETURN();

	//	void RETURN(int i);

	void RETURN(String varname);

	void RETURNTop();

	String _THIS = "this";

	// ARRAY

	default void GETFIELD_OF_THIS(String fieldname) {
		GETFIELD(fieldname, fieldTypeOfThis(fieldname));
	}

	void GETFIELD(String fieldname, Type fieldType);

	default void GETFIELD(String fieldname, Class<?> fieldType) {
		GETFIELD(fieldname, typeOf(fieldType));
	}

	default void GETFIELD(String fieldname, String fieldType) {
		GETFIELD(fieldname, typeOf(fieldType));
	}

	default void GETFIELD(String fieldname, Clazz fieldType) {
		GETFIELD(fieldname, typeOf(fieldType));
	}

	default void GETFIELD(Class<?> objectType, String fieldName, Class<?> fieldType) {
		GETFIELD(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	default void GETFIELD(Clazz objectType, String fieldName, Clazz fieldType) {
		GETFIELD(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	default void GETFIELD(String objectType, String fieldName, String fieldType) {
		GETFIELD(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	void GETFIELD(Type objectType, String fieldName, Type fieldType);

	default void PUTFIELD_OF_THIS(String fieldname) {
		PUTFIELD(fieldname, fieldTypeOfThis(fieldname));
	}

	default void PUTFIELD(String fieldname, Class<?> fieldType) {
		PUTFIELD(fieldname, typeOf(fieldType));
	}

	default void PUTFIELD(String fieldname, String fieldType) {
		PUTFIELD(fieldname, typeOf(fieldType));
	}

	default void PUTFIELD(String fieldname, Clazz fieldType) {
		PUTFIELD(fieldname, typeOf(fieldType));
	}

	void PUTFIELD(String fieldname, Type fieldType);

	default void PUTFIELD(Class<?> objectType, String fieldName, Class<?> fieldType) {
		PUTFIELD(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	void PUTFIELD(Type objectType, String fieldName, Type fieldType);

	default void GETSTATIC(String fieldName, Class<?> fieldType) {
		GETSTATIC(fieldName, typeOf(fieldType));
	}

	default void GETSTATIC(String fieldName, String fieldType) {
		GETSTATIC(fieldName, typeOf(fieldType));
	}

	default void GETSTATIC(String fieldName, Clazz fieldType) {
		GETSTATIC(fieldName, typeOf(fieldType));
	}

	default void GETSTATIC(Class<?> objectType, String fieldName, Class<?> fieldType) {
		GETSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	default void GETSTATIC(String objectType, String fieldName, String fieldType) {
		GETSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	void GETSTATIC(Type objectType, String fieldName, Type fieldType);

	default void PUT_THIS_STATIC(String fieldName) {
		PUTSTATIC(typeOfThis(), fieldName, staticFieldTypeOfThis(fieldName));
	}

	default void PUTSTATIC(String fieldName, Class<?> fieldType) {
		PUTSTATIC(fieldName, typeOf(fieldType));
	}

	default void PUTSTATIC(String fieldName, String fieldType) {
		PUTSTATIC(fieldName, typeOf(fieldType));
	}

	default void PUTSTATIC(String fieldName, Clazz fieldType) {
		PUTSTATIC(fieldName, typeOf(fieldType));
	}

	default void PUTSTATIC(String fieldName, Type fieldType) {
		PUTSTATIC(typeOfThis(), fieldName, fieldType);
	}

	default void PUTSTATIC(Class<?> objectType, String fieldName, Class<?> fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	default void PUTSTATIC(String objectType, String fieldName, String fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	default void PUTSTATIC(Clazz objectType, String fieldName, Clazz fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	default void PUTSTATIC(String objectType, String fieldName, Class<?> fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	default void PUTSTATIC(String objectType, String fieldName, Clazz fieldType) {
		PUTSTATIC(typeOf(objectType), fieldName, typeOf(fieldType));
	}

	void PUTSTATIC(Type objectType, String fieldName, Type fieldType);

	default void GET_THIS_STATIC(String fieldName) {
		GETSTATIC(typeOfThis(), fieldName, staticFieldTypeOfThis(fieldName));
	}

	default void GETSTATIC(String fieldName, Type fieldType) {
		GETSTATIC(typeOfThis(), fieldName, fieldType);
	}

	void ATHROW();

	// INVOKE
	//
	//	default void INVOKESTATIC(Class<?> objectType, String methodName, Class<?>... paramTypes) {
	//		INVOKESTATIC(typeOf(objectType), Type.VOID_TYPE, methodName, typeOf(paramTypes));
	//	}
	//
	//	default void INVOKESTATIC(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
	//		INVOKESTATIC(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	default void INVOKESTATIC(String objectType, String returnType, String methodName, String... paramTypes) {
	//		INVOKESTATIC(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	void INVOKESTATIC(Type objectType, Type returnType, String methodName, Type... paramTypes);
	//
	//	default void INVOKEINTERFACE(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
	//		INVOKEINTERFACE(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	default void INVOKEINTERFACE(String objectType, String returnType, String methodName, String... paramTypes) {
	//		INVOKEINTERFACE(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	void INVOKEINTERFACE(Type objectType, Type returnType, String methodName, Type... paramTypes);
	//
	//	default void INVOKESPECIAL(Class<?> objectType, String methodName, Class<?>... paramTypes) {
	//		INVOKESPECIAL(typeOf(objectType), null, methodName, typeOf(paramTypes));
	//	}
	//
	//	default void INVOKESPECIAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
	//		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	default void INVOKESPECIAL(String objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
	//		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	default void INVOKESPECIAL(String objectType, String returnType, String methodName, String... paramTypes) {
	//		INVOKESPECIAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	void INVOKESPECIAL(Type objectType, Type returnType, String methodName, Type... paramTypes);
	//
	//	default void INVOKEVIRTUAL(Class<?> objectType, Class<?> returnType, String methodName, Class<?>... paramTypes) {
	//		INVOKEVIRTUAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	default void INVOKEVIRTUAL(String objectType, String returnType, String methodName, String... paramTypes) {
	//		INVOKEVIRTUAL(typeOf(objectType), typeOf(returnType), methodName, typeOf(paramTypes));
	//	}
	//
	//	void INVOKEVIRTUAL(Type objectType, Type returnType, String methodName, Type... paramTypes);

	Type typeOfThis();

	Type staticFieldTypeOfThis(String name);

	Type fieldTypeOfThis(String name);


}
