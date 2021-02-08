package nebula.tinyasm;

import static nebula.tinyasm.TypeUtils.typeOf;

import java.util.function.Consumer;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public abstract class MethodCodeAdv extends MethodCode implements MethodCodeFriendly {

	public MethodCodeAdv line() {
		LINE();
		return this;
	}

	public MethodCodeAdv line(int line) {
		LINE(line);
		return this;
	}
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

	@Override
	public Instance boxTop() {
		BOX_Top();
		return topInstance();
	}

	@Override
	public Instance unboxTop() {
		UNBOX_Top();
		return topInstance();
	}
//	Instance checkcastAndUnbox(Class<?> clazz);
//
//	Instance checkcastAndUnbox(String clazz);

	@Override
	public Instance checkcastAndUnbox(Class<?> clazz) {
		BoxUnbox.checkcastAndUnbox(typeOf(clazz)).accept(this);
		return topInstance();
	}

	public Instance checkcastAndUnbox(Clazz clazz) {
		BoxUnbox.checkcastAndUnbox(clazz.getType()).accept(this);
		return topInstance();
	}

	@Override
	public Instance checkcastAndUnbox(String clazz) {
		BoxUnbox.checkcastAndUnbox(typeOf(clazz)).accept(this);
		return topInstance();
	}

	@Override
	public Instance topInstance() {
		return new InstanceImpl(this, stackTypeOf(0));
	}

	@Override
	public Instance loadThis() {
		LOAD(_THIS);
		return topInstance();
	}

	@Override
	public Instance loadThisField(String fieldname, Class<?> feildtype) {
		loadThisField(fieldname, typeOf(fieldname));
		return topInstance();
	}

	@Override
	public Instance loadThisField(String fieldname, String feildtype) {
		loadThisField(fieldname, typeOf(fieldname));
		return topInstance();
	}

	public Instance loadThisField(String fieldname, Type feildtype) {
		loadThis();
		GETFIELD(fieldname, feildtype);
		return topInstance();
	}

	@Override
	public void set(String varname, Consumer<MethodCodeAdv> invocations) {
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

	@Override
	public void setNull(String varname) {
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

	@Override
	public void setConst(String varname, String cst) {
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

	@Override
	public void setConst(String varname, int cst) {
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

	@Override
	public void setConst(String varname, long cst) {
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

	@Override
	public ClazzReference clazz(Class<?> clazz) {
		return new ClazzReferenceImpl(this, typeOf(clazz));
	}

	@Override
	public ClazzReference clazz(String clazz) {
		return new ClazzReferenceImpl(this, typeOf(clazz));
	}

	@Override
	public Instance load(String varname) {
		int local = codeLocalGetLocals(varname);
		if (local >= 0) {
			LOAD(local);
		} else {
			loadThisField(varname);
		}

		return topInstance();
	}

	@Override
	public void wHile(Consumer<MethodCodeAdv> cause, Consumer<MethodCodeAdv> block) {
		Label whileStart = codeNewLabel();
		Label whileEnd = codeNewLabel();
		visitLabel(whileStart);
		cause.accept(this);
		IFEQ(whileEnd);
		{
			block.accept(this);
			GOTO(whileStart);
		}
		visitLabel(whileEnd);
	}

	public void ifTrue(Consumer<MethodCodeAdv> block) {
		Label ifElse = codeNewLabel();
		IFEQ(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public void ifFalse(Consumer<MethodCodeAdv> block) {
		Label ifElse = codeNewLabel();
		IFNE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public void ifEqual(Consumer<MethodCodeAdv> block) {
		Label ifElse = codeNewLabel();
		IFNE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public void ifNotEqual(Consumer<MethodCodeAdv> block) {
		Label ifElse = codeNewLabel();
		IFEQ(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public void ifGreatThan(Consumer<MethodCodeAdv> block) {
		Label ifElse = codeNewLabel();
		IFLE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public void ifGreatEqual(Consumer<MethodCodeAdv> block) {
		Label ifElse = codeNewLabel();
		IFLT(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public void ifLessEqual(Consumer<MethodCodeAdv> block) {
		Label ifElse = codeNewLabel();
		IFGT(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public void ifLessThan(Consumer<MethodCodeAdv> block) {
		Label ifElse = codeNewLabel();
		IFGE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public Instance dup() {
		DUP();
		return topInstance();
	}

	@Override
	public void store(String varname) {
		STORE(varname);
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

	@Override
	public Instance loadConst(int cst) {
		LOADConst(cst);
		return topInstance();
	}

	@Override
	public Instance loadConst(long cst) {
		LOADConst(cst);
		return topInstance();
	}

	@Override
	public Instance loadConst(Object cst) {
		LOADConst(cst);
		return topInstance();
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
	@Deprecated
	public Instance add(String left, String right) {
		load(left);
		load(right);
		ADD();
		return topInstance();
	}

	@Deprecated
	public Instance add(String left, Consumer<MethodCodeAdv> right) {
		load(left);
		right.accept(this);
		ADD();
		return topInstance();
	}

	@Deprecated
	public Instance add(Consumer<MethodCodeAdv> left, String right) {
		left.accept(this);
		load(right);
		ADD();
		return topInstance();
	}

	@Deprecated
	public Instance add(Consumer<MethodCodeAdv> left, Consumer<MethodCodeAdv> right) {
		left.accept(this);
		right.accept(this);
		ADD();
		return topInstance();
	}

	/* Subtract: isub, lsub, fsub, dsub. */

	@Override
	@Deprecated
	public Instance sub(String left, String right) {
		LOAD(left);
		LOAD(right);
		SUB();
		return topInstance();
	}

	/* Multiply: imul, lmul, fmul, dmul. */
	@Override
	@Deprecated
	public Instance mul(String left, String right) {
		LOAD(left);
		LOAD(right);
		MUL();
		return topInstance();
	}

	/* Divide: idiv, ldiv, fdiv, ddiv. */
	@Override
	@Deprecated
	public Instance div(String left, String right) {
		LOAD(left);
		LOAD(right);
		DIV();
		return topInstance();
	}

	/* Remainder: irem, lrem, frem, drem. */
	@Override
	@Deprecated
	public Instance rem(String left, String right) {
		LOAD(left);
		LOAD(right);
		REM();
		return topInstance();
	}

	/* Negate: ineg, lneg, fneg, dneg. */
	@Override
	@Deprecated
	public Instance neg(String left) {
		LOAD(left);
		REM();
		return topInstance();
	}

	/* Bitwise OR: ior, lor. */
	@Override
	@Deprecated
	public Instance or(String left, String right) {
		LOAD(left);
		LOAD(right);
		OR();
		return topInstance();
	}

	/* Bitwise AND: iand, land. */
	@Override
	@Deprecated
	public Instance and(String left, String right) {
		LOAD(left);
		LOAD(right);
		AND();
		return topInstance();
	}

	/* Bitwise exclusive OR: ixor, lxor. */
	@Override
	@Deprecated
	public Instance xor(String left, String right) {
		LOAD(left);
		LOAD(right);
		XOR();
		return topInstance();
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

	/* Create a new array: newarray, anewarray, multianewarray. */

	@Override
	public Instance newarray(Class<?> elementClazz, int count) {
		LOADConst(count);
		NEWARRAY(typeOf(elementClazz));
		return topInstance();
	}

	@Override
	public Instance newarray(String elementClazz, int count) {
		LOADConst(count);
		NEWARRAY(typeOf(elementClazz));
		return topInstance();
	}

	@Override
	public Instance arrayload(String arrayref, String index, Class<?> valueType) {
		return arrayload(arrayref, index, typeOf(valueType));
	}

	@Override
	public Instance arrayload(String arrayref, String index, String valueType) {
		return arrayload(arrayref, index, typeOf(valueType));
	}

	public Instance arrayload(String arrayref, String index, Type valueType) {
		LOAD(arrayref);
		LOAD(index);
		ARRAYLOAD(valueType);
		return topInstance();
	}

	public Instance arrayload(String arrayref, int index, Type valueType) {
		LOAD(arrayref);
		LOADConst(index);
		ARRAYLOAD(valueType);
		return topInstance();
	}

	@Override
	public Instance arrayload(String varArray, int index) {
		load(varArray);
		Type arrayType = stackTypeOf(0);
		LOADConst(index);
		ARRAYLOAD(arrayType.getElementType());
		return topInstance();
	}

	@Override
	public Instance arrayload(String varArray, String varIndex) {
		load(varArray);
		Type arrayType = stackTypeOf(0);
		load(varIndex);
		ARRAYLOAD(arrayType.getElementType());
		return topInstance();
	}

	@Override
	public void arrayStore(String varArray, String index, String varValue) {
		LOAD(varArray);
		LOAD(index);
		LOAD(varValue);
		ARRAYSTORE();
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
	public void ifObjectEqual(Consumer<MethodCodeAdv> left, Consumer<MethodCodeAdv> right, Consumer<MethodCodeAdv> block) {
		left.accept(this);
		right.accept(this);
		Label ifElse = codeNewLabel();
		IF_ACMPEQ(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	@Override
	public void ifObjectNotEqual(Consumer<MethodCodeAdv> left, Consumer<MethodCodeAdv> right, Consumer<MethodCodeAdv> block) {
		left.accept(this);
		right.accept(this);
		Label ifElse = codeNewLabel();
		IF_ACMPNE(ifElse);
		block.accept(this);
		visitLabel(ifElse);
	}

	/* Compound conditional branch: tableswitch, lookupswitch. */
	// TODO tableswitch, lookupswitch.

	/* Unconditional branch: goto, goto_w, jsr, jsr_w, ret. */

	@Override
	public void returnVar(String varname) {
		LOAD(varname);
		RETURNTop();
	}

	@Override
	public void returnNull() {
		LOADConstNULL();
		RETURNTop();
	}

	public void tryCatchBlock(Label start, Label end, Label handler, String exctpionClazz) {
		visitTryCatchBlock(start, end, handler, typeOf(exctpionClazz));
	}

	public void tryCatchBlock(Label start, Label end, Label handler, Class<?> exctpionClazz) {
		visitTryCatchBlock(start, end, handler, typeOf(exctpionClazz));
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

	@Override
	public void initThis() {
		LOAD(_THIS);
		INVOKESPECIAL(Type.getType(Object.class), Type.VOID_TYPE, "<init>");
	}

	@Override
	public Instance init(String clazz) {
		NEW(clazz);
		DUP();
		SPECIAL(clazz, "<init>").INVOKE();
		return topInstance();
	}

	@Override
	public Instance init(String clazz, String... varnames) {
		NEW(clazz);
		DUP();
		topInstance().special("<init>").invokeVoid(varnames);
		return topInstance();
	}

	@Override
	public Instance init(Class<?> clazz, String... varnames) {
		NEW(clazz);
		DUP();
		topInstance().special("<init>").invokeVoid(varnames);
		return topInstance();
	}

	@Override
	public Instance init(Class<?> clazz) {
		NEW(clazz);
		DUP();
		SPECIAL(clazz, "<init>").INVOKE();
		return new InstanceImpl(this, stackTypeOf(0));
	}

	/** ARRAY **/
	@Override
	public Instance getfield(String objectname, String fieldname, Class<?> fieldType) {
		getfield(objectname, fieldname, typeOf(fieldType));
		return topInstance();
	}

	@Override
	public Instance loadThisField(String fieldname) {
		getfield("this", fieldname, codeThisFieldType(fieldname));
		return topInstance();
	}

	@Override
	public Instance getfield(String objectname, String fieldname, String fieldType) {
		getfield(objectname, fieldname, typeOf(fieldType));
		return topInstance();
	}

	public Instance getfield(String objectname, String fieldname, Type fieldType) {
		LOAD(objectname);
		GETFIELD(fieldname, fieldType);
		return topInstance();
	}

	@Override
	public void putThisFieldWithVar(String fieldname, String varname) {
		putVarToThisField(varname, fieldname, codeThisFieldType(fieldname));
	}

	public void putThisFieldOfNewObject(String fieldname, String clazz) {
		putThisFieldOfNewObject(fieldname, clazz, codeThisFieldType(fieldname));
	}

	public void putThisFieldOfNewObject(String fieldname, Class<?> clazz) {
		putThisFieldOfNewObject(fieldname, clazz, codeThisFieldType(fieldname));
	}

	public void putThisFieldOfNewObject(String fieldname, Class<?> clazz, Type fieldType) {
		loadThis();
		init(clazz);
		PUTFIELD(fieldname, fieldType);
	}

	public void putThisFieldOfNewObject(String fieldname, String clazz, Type fieldType) {
		loadThis();
		init(clazz);
		PUTFIELD(fieldname, fieldType);
	}

	@Override
	public void setNew(String varname, Class<?> clazz) {
		int locals = codeLocalGetLocals(varname);
		if (locals >= 0) {
			init(clazz);
			STORE(varname);
		} else {
			loadThis();
			init(clazz);
			PUTFIELD_OF_THIS(varname);
		}
	}

	@Override
	public void initTo(Class<?> clazz, String varname) {
		int locals = codeLocalGetLocals(varname);
		if (locals >= 0) {
			init(clazz);
			STORE(varname);
		} else {
			loadThis();
			init(clazz);
			PUTFIELD_OF_THIS(varname);
		}
	}

	@Override
	public void initTo(String clazz, String varname) {
		int locals = codeLocalGetLocals(varname);
		if (locals >= 0) {
			init(clazz);
			STORE(varname);
		} else {
			loadThis();
			init(clazz);
			PUTFIELD_OF_THIS(varname);
		}
	}

	public void putVarToThisField(String varname, String fieldname, Type fieldType) {
		loadThis();
		LOAD(varname);
		PUTFIELD(fieldname, fieldType);
	}

	public void getThisFieldTo(String fieldname, Type fieldType, String varname) {
		loadThis();
		GETFIELD(fieldname, fieldType);
		STORE(varname);
	}

	@Override
	public void putField(String objectref, String varname, String fieldname, Clazz fieldType) {
		putfield(objectref, varname, fieldname, fieldType.getType());
	}

	@Override
	public void putField(String objectref, String varname, String fieldname, Class<?> fieldType) {
		putfield(objectref, varname, fieldname, typeOf(fieldType));
	}

	@Override
	public void putField(String objectref, String varname, String fieldname, String fieldType) {
		putfield(objectref, varname, fieldname, typeOf(fieldType));

	}

	public void putfield(String objectref, String varname, String fieldname, Type fieldType) {
		LOAD(objectref);
		LOAD(varname);
		PUTFIELD(fieldname, fieldType);
	}

	@Override
	public void putStatic(Class<?> objectType, String varname, String fieldname, Class<?> fieldType) {
		putstatic(typeOf(objectType), varname, fieldname, typeOf(fieldType));
	}

	@Override
	public void putStatic(String objectType, String varname, String fieldname, String fieldType) {
		putstatic(typeOf(objectType), varname, fieldname, typeOf(fieldType));
	}

	public void putstatic(Type objectType, String varname, String fieldname, Type fieldType) {
		LOAD(varname);
		PUTSTATIC(objectType, fieldname, fieldType);
	}

	@Override
	public MethodCodeAdv line(Consumer<MethodCodeAdv> block) {
		line();
		return block(block);
	}

	@Override
	public void returnVoid() {
		RETURN();

	}

	@Override
	public MethodCodeAdv block(Consumer<MethodCodeAdv> invocation) {
		invocation.accept(this);
		return this;
	}

//	@Override
//	public MethodCodeAdv block(Consumer<MethodCodeAdv> block) {
//		
//		return null;
//	}
//
//	@Override
//	public MethodCodeAdv line() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public MethodCodeAdv line(int line) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}