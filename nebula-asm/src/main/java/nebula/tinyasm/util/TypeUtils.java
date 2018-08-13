package nebula.tinyasm.util;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Type;

import nebula.tinyasm.data.Field;

//import nebula.tinyasm.api.Field;

public class TypeUtils {

	static public boolean is(int access, int modified) {
		return (access & modified) > 0;
	}

	/**
	 * The stack size variation corresponding to each JVM instruction. This stack
	 * variation is equal to the size of the values produced by an instruction,
	 * minus the size of the values consumed by this instruction.
	 */
	static public final int[] SIZE = buildOpcodeSize();

	static public boolean in(Type type, Type... types) {
		for (Type type2 : types) {
			if (type2 == type) {
				return true;
			}
		}
		return false;
	}

	static public Type checkMathTypes(Type right, Type left) {
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

	static public Type mathInnerUserType(Type type) {
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

	static public Type arrayOf(Class<?> clz) {
		return arrayOf(typeOf(clz), true);
	}

	static public Type arrayOf(String clz) {
		return arrayOf(typeOf(clz), true);
	}

	static public Type arrayOf(String clz, boolean array) {
		return arrayOf(typeOf(clz), array);
	}

	static public Type arrayOf(Class<?> clz, boolean array) {
		return arrayOf(typeOf(clz), array);
	}

	static public Type arrayOf(Type type) {
		return arrayOf(type, true);
	}

	static public Type arrayOf(Type type, boolean array) {
		if (array) {
			return Type.getType("[" + type.getDescriptor());
		} else {
			return type;
		}
	}

	/**
	 * Computes the stack size variation corresponding to each JVM instruction.
	 */
	static public int[] buildOpcodeSize() {
		int i;
		int[] b = new int[202];
		String s = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDD"
				+ "CDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCD"
				+ "CDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFED" + "DDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE";
		for (i = 0; i < b.length; ++i) {
			b[i] = s.charAt(i) - 'E';
		}
		return b;

		// code to generate the above string
		//
		// int NA = 0; // not applicable (unused opcode or variable size opcode)
		//
		// b = new int[] {
		// 0, //NOP, // visitInsn
		// 1, //ACONST_NULL, // -
		// 1, //ICONST_M1, // -
		// 1, //ICONST_0, // -
		// 1, //ICONST_1, // -
		// 1, //ICONST_2, // -
		// 1, //ICONST_3, // -
		// 1, //ICONST_4, // -
		// 1, //ICONST_5, // -
		// 2, //LCONST_0, // -
		// 2, //LCONST_1, // -
		// 1, //FCONST_0, // -
		// 1, //FCONST_1, // -
		// 1, //FCONST_2, // -
		// 2, //DCONST_0, // -
		// 2, //DCONST_1, // -
		// 1, //BIPUSH, // visitIntInsn
		// 1, //SIPUSH, // -
		// 1, //LDC, // visitLdcInsn
		// NA, //LDC_W, // -
		// NA, //LDC2_W, // -
		// 1, //ILOAD, // visitVarInsn
		// 2, //LLOAD, // -
		// 1, //FLOAD, // -
		// 2, //DLOAD, // -
		// 1, //ALOAD, // -
		// NA, //ILOAD_0, // -
		// NA, //ILOAD_1, // -
		// NA, //ILOAD_2, // -
		// NA, //ILOAD_3, // -
		// NA, //LLOAD_0, // -
		// NA, //LLOAD_1, // -
		// NA, //LLOAD_2, // -
		// NA, //LLOAD_3, // -
		// NA, //FLOAD_0, // -
		// NA, //FLOAD_1, // -
		// NA, //FLOAD_2, // -
		// NA, //FLOAD_3, // -
		// NA, //DLOAD_0, // -
		// NA, //DLOAD_1, // -
		// NA, //DLOAD_2, // -
		// NA, //DLOAD_3, // -
		// NA, //ALOAD_0, // -
		// NA, //ALOAD_1, // -
		// NA, //ALOAD_2, // -
		// NA, //ALOAD_3, // -
		// -1, //IALOAD, // visitInsn
		// 0, //LALOAD, // -
		// -1, //FALOAD, // -
		// 0, //DALOAD, // -
		// -1, //AALOAD, // -
		// -1, //BALOAD, // -
		// -1, //CALOAD, // -
		// -1, //SALOAD, // -
		// -1, //ISTORE, // visitVarInsn
		// -2, //LSTORE, // -
		// -1, //FSTORE, // -
		// -2, //DSTORE, // -
		// -1, //ASTORE, // -
		// NA, //ISTORE_0, // -
		// NA, //ISTORE_1, // -
		// NA, //ISTORE_2, // -
		// NA, //ISTORE_3, // -
		// NA, //LSTORE_0, // -
		// NA, //LSTORE_1, // -
		// NA, //LSTORE_2, // -
		// NA, //LSTORE_3, // -
		// NA, //FSTORE_0, // -
		// NA, //FSTORE_1, // -
		// NA, //FSTORE_2, // -
		// NA, //FSTORE_3, // -
		// NA, //DSTORE_0, // -
		// NA, //DSTORE_1, // -
		// NA, //DSTORE_2, // -
		// NA, //DSTORE_3, // -
		// NA, //ASTORE_0, // -
		// NA, //ASTORE_1, // -
		// NA, //ASTORE_2, // -
		// NA, //ASTORE_3, // -
		// -3, //IASTORE, // visitInsn
		// -4, //LASTORE, // -
		// -3, //FASTORE, // -
		// -4, //DASTORE, // -
		// -3, //AASTORE, // -
		// -3, //BASTORE, // -
		// -3, //CASTORE, // -
		// -3, //SASTORE, // -
		// -1, //POP, // -
		// -2, //POP2, // -
		// 1, //DUP, // -
		// 1, //DUP_X1, // -
		// 1, //DUP_X2, // -
		// 2, //DUP2, // -
		// 2, //DUP2_X1, // -
		// 2, //DUP2_X2, // -
		// 0, //SWAP, // -
		// -1, //IADD, // -
		// -2, //LADD, // -
		// -1, //FADD, // -
		// -2, //DADD, // -
		// -1, //ISUB, // -
		// -2, //LSUB, // -
		// -1, //FSUB, // -
		// -2, //DSUB, // -
		// -1, //IMUL, // -
		// -2, //LMUL, // -
		// -1, //FMUL, // -
		// -2, //DMUL, // -
		// -1, //IDIV, // -
		// -2, //LDIV, // -
		// -1, //FDIV, // -
		// -2, //DDIV, // -
		// -1, //IREM, // -
		// -2, //LREM, // -
		// -1, //FREM, // -
		// -2, //DREM, // -
		// 0, //INEG, // -
		// 0, //LNEG, // -
		// 0, //FNEG, // -
		// 0, //DNEG, // -
		// -1, //ISHL, // -
		// -1, //LSHL, // -
		// -1, //ISHR, // -
		// -1, //LSHR, // -
		// -1, //IUSHR, // -
		// -1, //LUSHR, // -
		// -1, //IAND, // -
		// -2, //LAND, // -
		// -1, //IOR, // -
		// -2, //LOR, // -
		// -1, //IXOR, // -
		// -2, //LXOR, // -
		// 0, //IINC, // visitIincInsn
		// 1, //I2L, // visitInsn
		// 0, //I2F, // -
		// 1, //I2D, // -
		// -1, //L2I, // -
		// -1, //L2F, // -
		// 0, //L2D, // -
		// 0, //F2I, // -
		// 1, //F2L, // -
		// 1, //F2D, // -
		// -1, //D2I, // -
		// 0, //D2L, // -
		// -1, //D2F, // -
		// 0, //I2B, // -
		// 0, //I2C, // -
		// 0, //I2S, // -
		// -3, //LCMP, // -
		// -1, //FCMPL, // -
		// -1, //FCMPG, // -
		// -3, //DCMPL, // -
		// -3, //DCMPG, // -
		// -1, //IFEQ, // visitJumpInsn
		// -1, //IFNE, // -
		// -1, //IFLT, // -
		// -1, //IFGE, // -
		// -1, //IFGT, // -
		// -1, //IFLE, // -
		// -2, //IF_ICMPEQ, // -
		// -2, //IF_ICMPNE, // -
		// -2, //IF_ICMPLT, // -
		// -2, //IF_ICMPGE, // -
		// -2, //IF_ICMPGT, // -
		// -2, //IF_ICMPLE, // -
		// -2, //IF_ACMPEQ, // -
		// -2, //IF_ACMPNE, // -
		// 0, //GOTO, // -
		// 1, //JSR, // -
		// 0, //RET, // visitVarInsn
		// -1, //TABLESWITCH, // visiTableSwitchInsn
		// -1, //LOOKUPSWITCH, // visitLookupSwitch
		// -1, //IRETURN, // visitInsn
		// -2, //LRETURN, // -
		// -1, //FRETURN, // -
		// -2, //DRETURN, // -
		// -1, //ARETURN, // -
		// 0, //RETURN, // -
		// NA, //GETstatic public , // visitFieldInsn
		// NA, //PUTstatic public , // -
		// NA, //GETFIELD, // -
		// NA, //PUTFIELD, // -
		// NA, //INVOKEVIRTUAL, // visitMethodInsn
		// NA, //INVOKESPECIAL, // -
		// NA, //INVOKEstatic public , // -
		// NA, //INVOKEINTERFACE, // -
		// NA, //INVOKEDYNAMIC, // visitInvokeDynamicInsn
		// 1, //NEW, // visitTypeInsn
		// 0, //NEWARRAY, // visitIntInsn
		// 0, //ANEWARRAY, // visitTypeInsn
		// 0, //ARRAYLENGTH, // visitInsn
		// NA, //ATHROW, // -
		// 0, //CHECKCAST, // visitTypeInsn
		// 0, //INSTANCEOF, // -
		// -1, //MONITORENTER, // visitInsn
		// -1, //MONITOREXIT, // -
		// NA, //WIDE, // NOT VISITED
		// NA, //MULTIANEWARRAY, // visitMultiANewArrayInsn
		// -1, //IFNULL, // visitJumpInsn
		// -1, //IFNONNULL, // -
		// NA, //GOTO_W, // -
		// NA, //JSR_W, // -
		// };
		// for (i = 0; i < b.length; ++i) {
		// System.err.print((char)('E' + b[i]));
		// }
		// System.err.println();
	}

	static public String concat(String... strs) {
		StringBuilder sb = new StringBuilder();
		sb.append(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			sb.append(toPropertyName(strs[i]));
		}
		return sb.toString();
	}

//	static public Field[] fieldsOf(Field field, Field[] fields) {
//		Field[] newfields = new Field[fields.length + 1];
//		newfields[0] = field;
//		System.arraycopy(fields, 0, newfields, 1, fields.length);
//		return newfields;
//	}
//
//	static public Field[] fieldsOf(Field field, List<Field> fields) {
//		Field[] newfields = new Field[fields.size() + 1];
//		newfields[0] = field;
//		for (int i = 0; i < fields.size(); i++) {
//			newfields[i + 1] = fields.get(i);
//		}
//		return newfields;
//	}

	static public <T> T firstOf(List<T> values) {
		return values.get(0);
	}

	static public <T> T firstOf(T[] values) {
		return values[0];
	}

	static public String[] namesOf(Class<?>... classes) {
		String[] types = new String[classes.length];
		for (int i = 0; i < classes.length; i++) {
			types[i] = Type.getInternalName(classes[i]);
		}
		return types;
	}

	static public <T> List<T> restOf(List<T> values) {
		List<T> newvalues = new ArrayList<>();
		for (int i = 1; i < values.size(); i++) {
			newvalues.add(values.get(i));
		}
		return newvalues;
	};

	static public <T> List<T> restOf(T[] values) {
		List<T> newvalues = new ArrayList<>();
		for (int i = 1; i < values.length; i++) {
			newvalues.add(values[i]);
		}
		return newvalues;
	}

	static public String signatureOf(Type type, Class<?>... signatureClasses) {
		String signature = null;
		if (signatureClasses != null && signatureClasses.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("L");
			sb.append(type.getInternalName());
			sb.append("<");
			for (Class<?> signatureClass : signatureClasses) {
				sb.append(Type.getDescriptor(signatureClass));
			}
			sb.append(">;");
			signature = sb.toString();
		}
		return signature;
	}

	static public String signatureOf(Type type, Type... signatureTypes) {
		String signature = null;
		if (signatureTypes != null && signatureTypes.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("L");
			sb.append(type.getInternalName());
			sb.append("<");
			for (Type signatureType : signatureTypes) {
				sb.append(signatureType.getDescriptor());
			}
			sb.append(">;");
			signature = sb.toString();
		}
		return signature;
	}

	static public String toPropertyGetName(String fieldName, Type FieldType) {
		return "get" + toPropertyName(fieldName);
	}

	static public String toPropertyName(String fieldName) {
		return Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
	}

	static public String toPropertySetName(String fieldName, Type FieldType) {
		return "set" + toPropertyName(fieldName);
	}

	static public String toSimpleName(String name) {
		int index = name.lastIndexOf('.');
		if (index < 0) index = name.lastIndexOf('/');

		return name.substring(index + 1);
	}

	static public Type typeOf(Class<?> clz) {
		return Type.getType(clz);
	}

	static public Type typeOf(Class<?> clz, boolean isarray) {
		return arrayOf(Type.getType(clz), isarray);
	}

	static public Type typeOf(String name, boolean isarray) {
		return arrayOf(Type.getObjectType(name.replace('.', '/')), isarray);
	};

	static public Type typeOf(String name) {
		return Type.getObjectType(name.replace('.', '/'));
	};

	static public Type[] typeOf(Class<?>... classes) {
		Type[] types = new Type[classes.length];
		for (int i = 0; i < classes.length; i++) {
			types[i] = typeOf(classes[i]);
		}
		return types;
	};

	static public Type[] typeOf(String... classes) {
		Type[] types = new Type[classes.length];
		for (int i = 0; i < classes.length; i++) {
			types[i] = typeOf(classes[i]);
		}
		return types;
	};

	static public Type[] typeOf(Field... fields) {
		Type[] types = new Type[fields.length];
		for (int i = 0; i < fields.length; i++) {
			types[i] = fields[i].type;
		}
		return types;
	}

	static public Type[] typeOf(List<Field> fields) {
		Type[] types = new Type[fields.size()];
		for (int i = 0; i < fields.size(); i++) {
			types[i] = fields.get(i).type;
		}
		return types;
	}

	//
	// static public int[] getStackCompact() {
	// int[] stackCompack = new int[200];
//		// @formatter:off
//		// https://en.wikipedia.org/wiki/Java_bytecode_instruction_listings
//		stackCompack[AALOAD] = (1+1 )-(1); // [arrayref, index 鈫� value]    load onto the stack a reference from an array
//		stackCompack[AASTORE] = (1+1+1 )-(0); // [arrayref, index, value 鈫抅    store into a reference in an array
//		stackCompack[ACONST_NULL] = (0)-(1); // [鈫� null]    push a聽null聽reference onto the stack
//		stackCompack[ALOAD] = (0)-(1); // [鈫� objectref]    load a reference onto the stack from a local variable聽#index
//		//locals[ALOAD_0] = (0)-(1); // [鈫� objectref]    load a reference onto the stack from local variable 0
//		//locals[ALOAD_1] = (0)-(1); // [鈫� objectref]    load a reference onto the stack from local variable 1
//		//locals[ALOAD_2] = (0)-(1); // [鈫� objectref]    load a reference onto the stack from local variable 2
//		//locals[ALOAD_3] = (0)-(1); // [鈫� objectref]    load a reference onto the stack from local variable 3
//		stackCompack[ANEWARRAY] = (1 )-(1); // [count 鈫� arrayref]    create a new array of references of length聽count聽and component type identified by the class referenceindex聽(indexbyte1 << 8 + indexbyte2) in the constant pool
//		stackCompack[ARETURN] = (1 )-(0); // [objectref 鈫� [empty]]    return a reference from a method
//		stackCompack[ARRAYLENGTH] = (1 )-(1); // [arrayref 鈫� length]    get the length of an array
//		stackCompack[ASTORE] = (1 )-(0); // [objectref 鈫抅    store a reference into a local variable聽#index
//		//locals[ASTORE_0] = (1 )-(0); // [objectref 鈫抅    store a reference into local variable 0
//		//locals[ASTORE_1] = (1 )-(0); // [objectref 鈫抅    store a reference into local variable 1
//		//locals[ASTORE_2] = (1 )-(0); // [objectref 鈫抅    store a reference into local variable 2
//		//locals[ASTORE_3] = (1 )-(0); // [objectref 鈫抅    store a reference into local variable 3
//		stackCompack[ATHROW] = 1000; // [objectref 鈫� [empty], objectref]    throws an error or exception (notice that the rest of the stack is cleared, leaving only a reference to the Throwable)
//		stackCompack[BALOAD] = (1+1 )-(1); // [arrayref, index 鈫� value]    load a byte or Boolean value from an array
//		stackCompack[BASTORE] = (1+1+1 )-(0); // [arrayref, index, value 鈫抅    store a byte or Boolean value into an array
//		stackCompack[BIPUSH] = (0)-(1); // [鈫� value]    push a聽byte聽onto the stack as an integer聽value
//		//locals[BREAKPOINT] = 0; // []    reserved for breakpoints in Java debuggers; should not appear in any class file
//		stackCompack[CALOAD] = (1+1 )-(1); // [arrayref, index 鈫� value]    load a char from an array
//		stackCompack[CASTORE] = (1+1+1 )-(0); // [arrayref, index, value 鈫抅    store a char into an array
//		stackCompack[CHECKCAST] = (1 )-(1); // [objectref 鈫� objectref]    checks whether an聽objectref聽is of a certain type, the class reference of which is in the constant pool at聽index聽(indexbyte1 << 8 + indexbyte2)
//		stackCompack[D2F] = (1 -1); // [value 鈫� result]    convert a double to a float
//		stackCompack[D2I] = (1 -1); // [value 鈫� result]    convert a double to an int
//		stackCompack[D2L] = (1 -1); // [value 鈫� result]    convert a double to a long
//		stackCompack[DADD] = (1+1 -1); // [value1, value2 鈫� result]    add two doubles
//		stackCompack[DALOAD] = (1+1 )-(1); // [arrayref, index 鈫� value]    load a double from an array
//		stackCompack[DASTORE] = (1+1+1 )-(0); // [arrayref, index, value 鈫抅    store a double into an array
//		stackCompack[DCMPG] = (1+1 -1); // [value1, value2 鈫� result]    compare two doubles
//		stackCompack[DCMPL] = (1+1 -1); // [value1, value2 鈫� result]    compare two doubles
//		stackCompack[DCONST_0] = (0)-(1); // [鈫� 0.0]    push the constant聽0.0聽onto the stack
//		stackCompack[DCONST_1] = (0)-(1); // [鈫� 1.0]    push the constant聽1.0聽onto the stack
//		stackCompack[DDIV] = (1+1 -1); // [value1, value2 鈫� result]    divide two doubles
//		stackCompack[DLOAD] = (0)-(1); // [鈫� value]    load a double聽value聽from a local variable聽#index
//		//locals[DLOAD_0] = (0)-(1); // [鈫� value]    load a double from local variable 0
//		//locals[DLOAD_1] = (0)-(1); // [鈫� value]    load a double from local variable 1
//		//locals[DLOAD_2] = (0)-(1); // [鈫� value]    load a double from local variable 2
//		//locals[DLOAD_3] = (0)-(1); // [鈫� value]    load a double from local variable 3
//		stackCompack[DMUL] = (1+1 -1); // [value1, value2 鈫� result]    multiply two doubles
//		stackCompack[DNEG] = (1 -1); // [value 鈫� result]    negate a double
//		stackCompack[DREM] = (1+1 -1); // [value1, value2 鈫� result]    get the remainder from a division between two doubles
//		stackCompack[DRETURN] = (1 )-(0); // [value 鈫� [empty]]    return a double from a method
//		stackCompack[DSTORE] = (1 )-(0); // [value 鈫抅    store a double聽value聽into a local variable聽#index
//		//locals[DSTORE_0] = (1 )-(0); // [value 鈫抅    store a double into local variable 0
//		//locals[DSTORE_1] = (1 )-(0); // [value 鈫抅    store a double into local variable 1
//		//locals[DSTORE_2] = (1 )-(0); // [value 鈫抅    store a double into local variable 2
//		//locals[DSTORE_3] = (1 )-(0); // [value 鈫抅    store a double into local variable 3
//		stackCompack[DSUB] = (1+1 -1); // [value1, value2 鈫� result]    subtract a double from another
//		stackCompack[DUP] = (1 )-(1+1); // [value 鈫� value, value]    duplicate the value on top of the stack
//		stackCompack[DUP_X1] = (1+1 )-(1+1+1); // [value2, value1 鈫� value1, value2, value1]    insert a copy of the top value into the stack two values from the top. value1 and value2 must not be of the type double or long.
//		stackCompack[DUP_X2] = (1+1+1 )-(1+1+1+1); // [value3, value2, value1 鈫� value1, value3, value2, value1]    insert a copy of the top value into the stack two (if value2 is double or long it takes up the entry of value3, too) or three values (if value2 is neither double nor long) from the top
//		stackCompack[DUP2] = ((1+1) )-((1+1)+(1+1)); // [{value2, value1} 鈫� {value2, value1}, {value2, value1}]    duplicate top two stack words (two values, if value1 is not double nor long; a single value, if value1 is double or long)
//		stackCompack[DUP2_X1] = (1+(1+1) )-((1+1)+1+(1+1)); // [value3, {value2, value1} 鈫� {value2, value1}, value3, {value2, value1}]    duplicate two words and insert beneath third word (see explanation above)
//		stackCompack[DUP2_X2] = ((1+1)+(1+1) )-((1+1)+(1+1)+(1+1)); // [{value4, value3}, {value2, value1} 鈫� {value2, value1}, {value4, value3}, {value2, value1}]    duplicate two words and insert beneath fourth word
//		stackCompack[F2D] = (1 -1); // [value 鈫� result]    convert a float to a double
//		stackCompack[F2I] = (1 -1); // [value 鈫� result]    convert a float to an int
//		stackCompack[F2L] = (1 -1); // [value 鈫� result]    convert a float to a long
//		stackCompack[FADD] = (1+1 -1); // [value1, value2 鈫� result]    add two floats
//		stackCompack[FALOAD] = (1+1 )-(1); // [arrayref, index 鈫� value]    load a float from an array
//		stackCompack[FASTORE] = (1+1+1 )-(0); // [arrayref, index, value 鈫抅    store a float in an array
//		stackCompack[FCMPG] = (1+1 -1); // [value1, value2 鈫� result]    compare two floats
//		stackCompack[FCMPL] = (1+1 -1); // [value1, value2 鈫� result]    compare two floats
//		stackCompack[FCONST_0] = (0)-(1); // [鈫� 0.0f]    push聽0.0f聽on the stack
//		stackCompack[FCONST_1] = (0)-(1); // [鈫� 1.0f]    push聽1.0f聽on the stack
//		stackCompack[FCONST_2] = (0)-(1); // [鈫� 2.0f]    push聽2.0f聽on the stack
//		stackCompack[FDIV] = (1+1 -1); // [value1, value2 鈫� result]    divide two floats
//		stackCompack[FLOAD] = (0)-(1); // [鈫� value]    load a float聽value聽from a local variable聽#index
//		//locals[FLOAD_0] = (0)-(1); // [鈫� value]    load a float聽value聽from local variable 0
//		//locals[FLOAD_1] = (0)-(1); // [鈫� value]    load a float聽value聽from local variable 1
//		//locals[FLOAD_2] = (0)-(1); // [鈫� value]    load a float聽value聽from local variable 2
//		//locals[FLOAD_3] = (0)-(1); // [鈫� value]    load a float聽value聽from local variable 3
//		stackCompack[FMUL] = (1+1 -1); // [value1, value2 鈫� result]    multiply two floats
//		stackCompack[FNEG] = (1 -1); // [value 鈫� result]    negate a float
//		stackCompack[FREM] = (1+1 -1); // [value1, value2 鈫� result]    get the remainder from a division between two floats
//		stackCompack[FRETURN] = (1 )-(0); // [value 鈫� [empty]]    return a float
//		stackCompack[FSTORE] = (1 )-(0); // [value 鈫抅    store a float聽value聽into a local variable聽#index
//		//locals[FSTORE_0] = (1 )-(0); // [value 鈫抅    store a float聽value聽into local variable 0
//		//locals[FSTORE_1] = (1 )-(0); // [value 鈫抅    store a float聽value聽into local variable 1
//		//locals[FSTORE_2] = (1 )-(0); // [value 鈫抅    store a float聽value聽into local variable 2
//		//locals[FSTORE_3] = (1 )-(0); // [value 鈫抅    store a float聽value聽into local variable 3
//		stackCompack[FSUB] = (1+1 -1); // [value1, value2 鈫� result]    subtract two floats
//		stackCompack[GETFIELD] = (1 )-(1); // [objectref 鈫� value]    get a field聽value聽of an object聽objectref, where the field is identified by field reference in the constant pool聽index聽(index1 << 8 + index2)
//		stackCompack[GETstatic public ] = (0)-(1); // [鈫� value]    get a static public  field聽value聽of a class, where the field is identified by field reference in the constant pool聽index聽(index1 << 8 + index2)
//		stackCompack[GOTO] = 0; // [[no change]]    goes to another instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		//locals[GOTO_W] = 0; // [[no change]]    goes to another instruction at聽branchoffset聽(signed int constructed from unsigned bytes聽branchbyte1 << 24 +聽branchbyte2 << 16 +聽branchbyte3 << 8 + branchbyte4)
//		stackCompack[I2B] = (1 -1); // [value 鈫� result]    convert an int into a byte
//		stackCompack[I2C] = (1 -1); // [value 鈫� result]    convert an int into a character
//		stackCompack[I2D] = (1 -1); // [value 鈫� result]    convert an int into a double
//		stackCompack[I2F] = (1 -1); // [value 鈫� result]    convert an int into a float
//		stackCompack[I2L] = (1 -1); // [value 鈫� result]    convert an int into a long
//		stackCompack[I2S] = (1 -1); // [value 鈫� result]    convert an int into a short
//		stackCompack[IADD] = (1+1 -1); // [value1, value2 鈫� result]    add two ints
//		stackCompack[IALOAD] = (1+1 )-(1); // [arrayref, index 鈫� value]    load an int from an array
//		stackCompack[IAND] = (1+1 -1); // [value1, value2 鈫� result]    perform a bitwise and on two integers
//		stackCompack[IASTORE] = (1+1+1 )-(0); // [arrayref, index, value 鈫抅    store an int into an array
//		stackCompack[ICONST_M1] = (0)-(-1); // [鈫� -1]    load the int value -1 onto the stack
//		stackCompack[ICONST_0] = (0)-(0); // [鈫� 0]    load the int value 0 onto the stack
//		stackCompack[ICONST_1] = (0)-(1); // [鈫� 1]    load the int value 1 onto the stack
//		stackCompack[ICONST_2] = (0)-(2); // [鈫� 2]    load the int value 2 onto the stack
//		stackCompack[ICONST_3] = (0)-(3); // [鈫� 3]    load the int value 3 onto the stack
//		stackCompack[ICONST_4] = (0)-(4); // [鈫� 4]    load the int value 4 onto the stack
//		stackCompack[ICONST_5] = (0)-(5); // [鈫� 5]    load the int value 5 onto the stack
//		stackCompack[IDIV] = (1+1 -1); // [value1, value2 鈫� result]    divide two integers
//		stackCompack[IF_ACMPEQ] = (1+1 )-(0); // [value1, value2 鈫抅    if references are equal, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IF_ACMPNE] = (1+1 )-(0); // [value1, value2 鈫抅    if references are not equal, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IF_ICMPEQ] = (1+1 )-(0); // [value1, value2 鈫抅    if ints are equal, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytesbranchbyte1 << 8 + branchbyte2)
//		stackCompack[IF_ICMPGE] = (1+1 )-(0); // [value1, value2 鈫抅    if聽value1聽is greater than or equal to聽value2, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IF_ICMPGT] = (1+1 )-(0); // [value1, value2 鈫抅    if聽value1聽is greater than聽value2, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IF_ICMPLE] = (1+1 )-(0); // [value1, value2 鈫抅    if聽value1聽is less than or equal to聽value2, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IF_ICMPLT] = (1+1 )-(0); // [value1, value2 鈫抅    if聽value1聽is less than聽value2, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IF_ICMPNE] = (1+1 )-(0); // [value1, value2 鈫抅    if ints are not equal, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IFEQ] = (1 )-(0); // [value 鈫抅    if聽value聽is 0, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytesbranchbyte1 << 8 + branchbyte2)
//		stackCompack[IFGE] = (1 )-(0); // [value 鈫抅    if聽value聽is greater than or equal to 0, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IFGT] = (1 )-(0); // [value 鈫抅    if聽value聽is greater than 0, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IFLE] = (1 )-(0); // [value 鈫抅    if聽value聽is less than or equal to 0, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IFLT] = (1 )-(0); // [value 鈫抅    if聽value聽is less than 0, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IFNE] = (1 )-(0); // [value 鈫抅    if聽value聽is not 0, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytesbranchbyte1 << 8 + branchbyte2)
//		stackCompack[IFNONNULL] = (1 )-(0); // [value 鈫抅    if聽value聽is not null, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2)
//		stackCompack[IFNULL] = (1 )-(0); // [value 鈫抅    if聽value聽is null, branch to instruction at聽branchoffset聽(signed short constructed from unsigned bytesbranchbyte1 << 8 + branchbyte2)
//		stackCompack[IINC] = 0; // [[No change]]    increment local variable聽#index聽by signed byte聽const
//		stackCompack[ILOAD] = (0)-(1); // [鈫� value]    load an int聽value聽from a local variable聽#index
//		//locals[ILOAD_0] = (0)-(1); // [鈫� value]    load an int聽value聽from local variable 0
//		//locals[ILOAD_1] = (0)-(1); // [鈫� value]    load an int聽value聽from local variable 1
//		//locals[ILOAD_2] = (0)-(1); // [鈫� value]    load an int聽value聽from local variable 2
//		//locals[ILOAD_3] = (0)-(1); // [鈫� value]    load an int聽value聽from local variable 3
//		//locals[IMPDEP1] = 0; // []    reserved for implementation-dependent operations within debuggers; should not appear in any class file
//		//locals[IMPDEP2] = 0; // []    reserved for implementation-dependent operations within debuggers; should not appear in any class file
//		stackCompack[IMUL] = (1+1 -1); // [value1, value2 鈫� result]    multiply two integers
//		stackCompack[INEG] = (1 -1); // [value 鈫� result]    negate int
//		stackCompack[INSTANCEOF] = (1 -1); // [objectref 鈫� result]    determines if an object聽objectref聽is of a given type, identified by class reference聽index聽in constant pool (indexbyte1 << 8 + indexbyte2)
//		stackCompack[INVOKEDYNAMIC] = 1000; // [[arg1, [arg2 ...]] 鈫抅    invokes a dynamic method identified by method reference聽index聽in constant pool (indexbyte1 << 8 + indexbyte2)
//		stackCompack[INVOKEINTERFACE] = 1000; // [objectref, [arg1, arg2, ...] 鈫抅    invokes an interface method on object聽objectref, where the interface method is identified by method reference聽index聽in constant pool (indexbyte1 << 8 + indexbyte2)
//		stackCompack[INVOKESPECIAL] = 1000; // [objectref, [arg1, arg2, ...] 鈫抅    invoke instance method on object聽objectref, where the method is identified by method reference聽indexin constant pool (indexbyte1 << 8 + indexbyte2)
//		stackCompack[INVOKEstatic public ] = 1000; // [[arg1, arg2, ...] 鈫抅    invoke a static public  method, where the method is identified by method reference聽index聽in constant pool (indexbyte1 << 8 + indexbyte2)
//		stackCompack[INVOKEVIRTUAL] = 1000; // [objectref, [arg1, arg2, ...] 鈫抅    invoke virtual method on object聽objectref, where the method is identified by method reference聽index聽in constant pool (indexbyte1 << 8 + indexbyte2)
//		stackCompack[IOR] = (1+1 -1); // [value1, value2 鈫� result]    bitwise int or
//		stackCompack[IREM] = (1+1 -1); // [value1, value2 鈫� result]    logical int remainder
//		stackCompack[IRETURN] = (1 )-(0); // [value 鈫� [empty]]    return an integer from a method
//		stackCompack[ISHL] = (1+1 -1); // [value1, value2 鈫� result]    int shift left
//		stackCompack[ISHR] = (1+1 -1); // [value1, value2 鈫� result]    int arithmetic shift right
//		stackCompack[ISTORE] = (1 )-(0); // [value 鈫抅    store int聽value聽into variable聽#index
//		//locals[ISTORE_0] = (1 )-(0); // [value 鈫抅    store int聽value聽into variable 0
//		//locals[ISTORE_1] = (1 )-(0); // [value 鈫抅    store int聽value聽into variable 1
//		//locals[ISTORE_2] = (1 )-(0); // [value 鈫抅    store int聽value聽into variable 2
//		//locals[ISTORE_3] = (1 )-(0); // [value 鈫抅    store int聽value聽into variable 3
//		stackCompack[ISUB] = (1+1 -1); // [value1, value2 鈫� result]    int subtract
//		stackCompack[IUSHR] = (1+1 -1); // [value1, value2 鈫� result]    int logical shift right
//		stackCompack[IXOR] = (1+1 -1); // [value1, value2 鈫� result]    int xor
//		stackCompack[JSR] = (-1); // [鈫� address]    jump to subroutine at聽branchoffset聽(signed short constructed from unsigned bytes聽branchbyte1 << 8 + branchbyte2) and place the return address on the stack
//	//	locals[JSR_W] = (-1); // [鈫� address]    jump to subroutine at聽branchoffset聽(signed int constructed from unsigned bytes聽branchbyte1 << 24 + branchbyte2 << 16 + branchbyte3 << 8 + branchbyte4) and place the return address on the stack
//		stackCompack[L2D] = (1 -1); // [value 鈫� result]    convert a long to a double
//		stackCompack[L2F] = (1 -1); // [value 鈫� result]    convert a long to a float
//		stackCompack[L2I] = (1 -1); // [value 鈫� result]    convert a long to a int
//		stackCompack[LADD] = (1+1 -1); // [value1, value2 鈫� result]    add two longs
//		stackCompack[LALOAD] = (1+1 )-(1); // [arrayref, index 鈫� value]    load a long from an array
//		stackCompack[LAND] = (1+1 -1); // [value1, value2 鈫� result]    bitwise and of two longs
//		stackCompack[LASTORE] = (1+1+1 )-(0); // [arrayref, index, value 鈫抅    store a long to an array
//		stackCompack[LCMP] = (1+1 -1); // [value1, value2 鈫� result]    compare two longs values
//		stackCompack[LCONST_0] = (0)-(0); // [鈫� 0L]    push the long 0 onto the stack
//		stackCompack[LCONST_1] = (0)-(1); // [鈫� 1L]    push the long 1 onto the stack
//		stackCompack[LDC] = (0)-(1); // [鈫� value]    push a constant聽#index聽from a constant pool (String, int or float) onto the stack
//		//locals[LDC_W] = (0)-(1); // [鈫� value]    push a constant聽#index聽from a constant pool (String, int or float) onto the stack (wide聽index聽is constructed as聽indexbyte1 << 8 + indexbyte2)
//		//locals[LDC2_W] = (0)-(1); // [鈫� value]    push a constant聽#index聽from a constant pool (double or long) onto the stack (wide聽index聽is constructed as聽indexbyte1 << 8 + indexbyte2)
//		stackCompack[LDIV] = (1+1 -1); // [value1, value2 鈫� result]    divide two longs
//		stackCompack[LLOAD] = (0)-(1); // [鈫� value]    load a long value from a local variable聽#index
//		//locals[LLOAD_0] = (0)-(1); // [鈫� value]    load a long value from a local variable 0
//		//locals[LLOAD_1] = (0)-(1); // [鈫� value]    load a long value from a local variable 1
//		//locals[LLOAD_2] = (0)-(1); // [鈫� value]    load a long value from a local variable 2
//		//locals[LLOAD_3] = (0)-(1); // [鈫� value]    load a long value from a local variable 3
//		stackCompack[LMUL] = (1+1 -1); // [value1, value2 鈫� result]    multiply two longs
//		stackCompack[LNEG] = (1 -1); // [value 鈫� result]    negate a long
//		stackCompack[LOOKUPSWITCH] = 1000; // [key 鈫抅    a target address is looked up from a table using a key and execution continues from the instruction at that address
//		stackCompack[LOR] = (1+1 -1); // [value1, value2 鈫� result]    bitwise or of two longs
//		stackCompack[LREM] = (1+1 -1); // [value1, value2 鈫� result]    remainder of division of two longs
//		stackCompack[LRETURN] = (1 )-(0); // [value 鈫� [empty]]    return a long value
//		stackCompack[LSHL] = (1+1 -1); // [value1, value2 鈫� result]    bitwise shift left of a long聽value1聽by聽value2聽positions
//		stackCompack[LSHR] = (1+1 -1); // [value1, value2 鈫� result]    bitwise shift right of a long聽value1聽by聽value2聽positions
//		stackCompack[LSTORE] = (1 )-(0); // [value 鈫抅    store a long聽value聽in a local variable聽#index
//		//locals[LSTORE_0] = (1 )-(0); // [value 鈫抅    store a long聽value聽in a local variable 0
//		//locals[LSTORE_1] = (1 )-(0); // [value 鈫抅    store a long聽value聽in a local variable 1
//		//locals[LSTORE_2] = (1 )-(0); // [value 鈫抅    store a long聽value聽in a local variable 2
//		//locals[LSTORE_3] = (1 )-(0); // [value 鈫抅    store a long聽value聽in a local variable 3
//		stackCompack[LSUB] = (1+1 -1); // [value1, value2 鈫� result]    subtract two longs
//		stackCompack[LUSHR] = (1+1 -1); // [value1, value2 鈫� result]    bitwise shift right of a long聽value1聽by聽value2聽positions, unsigned
//		stackCompack[LXOR] = (1+1 -1); // [value1, value2 鈫� result]    bitwise exclusive or of two longs
//		stackCompack[MONITORENTER] = (1 )-(0); // [objectref 鈫抅    enter monitor for object ("grab the lock" - start of synchronized() section)
//		stackCompack[MONITOREXIT] = (1 )-(0); // [objectref 鈫抅    exit monitor for object ("release the lock" - end of synchronized() section)
//		stackCompack[MULTIANEWARRAY] = 1000; // [count1, [count2,...] 鈫� arrayref]    create a new array of聽dimensions聽dimensions with elements of type identified by class reference in constant pool聽index聽(indexbyte1 << 8 + indexbyte2); the sizes of each dimension is identified bycount1, [count2, etc.]
//		stackCompack[NEW] = (0)-(1); // [鈫� objectref]    create new object of type identified by class reference in constant pool聽index聽(indexbyte1 << 8 + indexbyte2)
//		stackCompack[NEWARRAY] = 1000; // [count 鈫� arrayref]    create new array with聽count聽elements of primitive type identified by聽atype
//		stackCompack[NOP] = (0); // [[No change]]    perform no operation
//		stackCompack[POP] = (1 )-(0); // [value 鈫抅    discard the top value on the stack
//		stackCompack[POP2] = ((1+1) )-(0); // [{value2, value1} 鈫抅    discard the top two values on the stack (or one value, if it is a double or long)
//		stackCompack[PUTFIELD] = (1+1 )-(0); // [objectref, value 鈫抅    set field to聽value聽in an object聽objectref, where the field is identified by a field reference聽index聽in constant pool (indexbyte1 << 8 + indexbyte2)
//		stackCompack[PUTstatic public ] = (1 )-(0); // [value 鈫抅    set static public  field to聽value聽in a class, where the field is identified by a field reference聽index聽in constant pool (indexbyte1 << 8 + indexbyte2)
//		stackCompack[RET] = (0); // [[No change]]    continue execution from address taken from a local variable聽#index聽(the asymmetry with jsr is intentional)
//		stackCompack[RETURN] = (0)-(0); // [鈫� [empty]]    return void from method
//		stackCompack[SALOAD] = (1+1 )-(1); // [arrayref, index 鈫� value]    load short from array
//		stackCompack[SASTORE] = (1+1+1 )-(0); // [arrayref, index, value 鈫抅    store short to array
//		stackCompack[SIPUSH] = (0)-(1); // [鈫� value]    push a short onto the stack
//		stackCompack[SWAP] = (1+1 )-(1+1); // [value2, value1 鈫� value1, value2]    swaps two top words on the stack (note that value1 and value2 must not be double or long)
//		stackCompack[TABLESWITCH] = (1 )-(0); // [index 鈫抅    continue execution from an address in the table at offset聽index
//		//locals[WIDE] = 1000; // [[same as for corresponding instructions]]    execute聽opcode, where聽opcode聽is either iload, fload, aload, lload, dload, istore, fstore, astore, lstore, dstore, or ret, but assume the聽index聽is 16 bit; or execute iinc, where the聽index聽is 16 bits and the constant to increment by is a signed 16 bit short
//		// @formatter:on
	// return stackCompack;
	// }
}
