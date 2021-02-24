package cc1sj.tinyasm;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

//import nebula.tinyasm.api.Field;

class TypeUtils {

	/**
	 * The stack size variation corresponding to each JVM instruction. This stack
	 * variation is equal to the size of the values produced by an instruction,
	 * minus the size of the values consumed by this instruction.
	 */
	static protected final int[] SIZE = buildOpcodeSize();

	protected static Map<String, Type> primaryTypeMaps = new HashMap<String, Type>();

	static {
		primaryTypeMaps.put(boolean.class.getName(), Type.BOOLEAN_TYPE);
		primaryTypeMaps.put(byte.class.getName(), Type.BYTE_TYPE);
		primaryTypeMaps.put(char.class.getName(), Type.CHAR_TYPE);
		primaryTypeMaps.put(short.class.getName(), Type.SHORT_TYPE);
		primaryTypeMaps.put(int.class.getName(), Type.INT_TYPE);
		primaryTypeMaps.put(long.class.getName(), Type.LONG_TYPE);
		primaryTypeMaps.put(float.class.getName(), Type.FLOAT_TYPE);
		primaryTypeMaps.put(double.class.getName(), Type.DOUBLE_TYPE);
	}

	static Map<String, String> primaryTypeObjectMap = new HashMap<>();

	static {
		primaryTypeObjectMap.put(boolean.class.getName(), Boolean.class.getName());
		primaryTypeObjectMap.put(byte.class.getName(), Byte.class.getName());
		primaryTypeObjectMap.put(char.class.getName(), Character.class.getName());
		primaryTypeObjectMap.put(short.class.getName(), Short.class.getName());
		primaryTypeObjectMap.put(int.class.getName(), Integer.class.getName());
		primaryTypeObjectMap.put(long.class.getName(), Long.class.getName());
		primaryTypeObjectMap.put(float.class.getName(), Float.class.getName());
		primaryTypeObjectMap.put(double.class.getName(), Double.class.getName());
	}

	static Map<Type, Integer> arrayTypeMaps = new HashMap<Type, Integer>();

	static {
		arrayTypeMaps.put(typeOf(boolean.class), Opcodes.T_BOOLEAN);
		arrayTypeMaps.put(typeOf(byte.class.getName()), Opcodes.T_BYTE);
		arrayTypeMaps.put(typeOf(char.class.getName()), Opcodes.T_CHAR);
		arrayTypeMaps.put(typeOf(short.class.getName()), Opcodes.T_SHORT);
		arrayTypeMaps.put(typeOf(int.class.getName()), Opcodes.T_INT);
		arrayTypeMaps.put(typeOf(long.class.getName()), Opcodes.T_LONG);
		arrayTypeMaps.put(typeOf(float.class.getName()), Opcodes.T_FLOAT);
		arrayTypeMaps.put(typeOf(double.class.getName()), Opcodes.T_DOUBLE);
	}

	static Type arrayOf(Type type, boolean array) {
		if (array) {
			return Type.getType("[" + type.getDescriptor());
		} else {
			return type;
		}
	}

	/**
	 * Computes the stack size variation corresponding to each JVM instruction.
	 */
	static int[] buildOpcodeSize() {
		int i;
		int[] b = new int[202];
		String s = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDD" + "CDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCD"
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
		// NA, //GETstatic , // visitFieldInsn
		// NA, //PUTstatic , // -
		// NA, //GETFIELD, // -
		// NA, //PUTFIELD, // -
		// NA, //INVOKEVIRTUAL, // visitMethodInsn
		// NA, //INVOKESPECIAL, // -
		// NA, //INVOKEstatic , // -
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

	static Type checkMathTypes(Type right, Type left) {
		assert in(right, Type.BOOLEAN_TYPE, Type.BYTE_TYPE, Type.CHAR_TYPE, Type.SHORT_TYPE, Type.INT_TYPE, Type.LONG_TYPE, Type.FLOAT_TYPE, Type.DOUBLE_TYPE)
				: "right type "+right.getClassName()+" is not basic type";
		assert in(left, Type.BOOLEAN_TYPE, Type.BYTE_TYPE, Type.CHAR_TYPE, Type.SHORT_TYPE, Type.INT_TYPE, Type.LONG_TYPE, Type.FLOAT_TYPE, Type.DOUBLE_TYPE)
				: "left type "+left.getClassName()+" is not basic type";
		right = mathInnerUserType(right);
		left = mathInnerUserType(left);
		assert left == right : "left type should equal right type";
		Type innerType = mathInnerUserType(left);
		return innerType;
	}

//	static  Field[] fieldsOf(Field field, Field[] fields) {
//		Field[] newfields = new Field[fields.length + 1];
//		newfields[0] = field;
//		System.arraycopy(fields, 0, newfields, 1, fields.length);
//		return newfields;
//	}
//
//	static  Field[] fieldsOf(Field field, List<Field> fields) {
//		Field[] newfields = new Field[fields.size() + 1];
//		newfields[0] = field;
//		for (int i = 0; i < fields.size(); i++) {
//			newfields[i + 1] = fields.get(i);
//		}
//		return newfields;
//	}

	static String[] classnamesOf(Class<?>... clazz) {
		String[] names = new String[clazz.length];
		for (int i = 0; i < names.length; i++) {
			names[i] = clazz[i].getName();
		}
		return names;
	}

//	static String concat(String... strs) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(strs[0]);
//		for (int i = 1; i < strs.length; i++) {
//			String name = strs[i];
//			sb.append(Character.toUpperCase(name.charAt(0)) + name.substring(1));
//		}
//		return sb.toString();
//	}

	static boolean in(Type type, Type... types) {
		for (Type type2 : types) {
			if (type2 == type) {
				return true;
			}
		}
		return false;
	}

	static private Type mathInnerUserType(Type type) {
		switch (type.getSort()) {
		case Type.BOOLEAN:
		case Type.BYTE:
		case Type.CHAR:
		case Type.SHORT:
			return Type.INT_TYPE;
		default:
			break;
		}
		return type;
	}

	static String signatureOf(Type type, Class<?>... signatureClasses) {
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
	};

	
	static Type stringInnerUserType(Type type) {
		switch (type.getSort()) {
		case Type.BOOLEAN:
		case Type.BYTE:
//		case Type.CHAR:
		case Type.SHORT:
			return Type.INT_TYPE;
		default:
			break;
		}
		return type;
	}

	static Clazz stringInnerUserType(Clazz clazz) {
		switch (clazz.getType().getSort()) {
		case Type.BOOLEAN:
		case Type.BYTE:
//		case Type.CHAR:
		case Type.SHORT:
			return Clazz.of(Type.INT_TYPE);
		default:
			break;
		}
		return clazz;
	}
	
	static String toSimpleName(String name) {
		int index = name.lastIndexOf('.');
		if (index < 0) index = name.lastIndexOf('/');

		return name.substring(index + 1);
	}

	static Type typeOf(Class<?> clz) {
		if (clz == null) return Type.VOID_TYPE;
		return Type.getType(clz);
	}

	static Type[] typeOf(Class<?>... classes) {
		return every(Type.class, classes, c -> typeOf(c));
	}
	
	static Type[] typeOf(Clazz... classes) {
		return every(Type.class, classes, c -> typeOf(c));
	}

//	static Type typeOf(Class<?> clz, boolean isarray) {
//		return arrayOf(Type.getType(clz), isarray);
//	}
//
//	static Type[] typeOf(Field... fields) {
//		return every(Type.class, fields, c -> c.clazz.getType());
//	}

	static Type typeOf(Clazz clazz) {
		if (clazz == null) return Type.VOID_TYPE;
		return clazz.getType();
	}

//	static Type typeOf(GenericClazz clazz) {
//		if (clazz == null) return Type.VOID_TYPE;
//		String name = clazz.originclazzName;
//		if (clazz.isarray) {
//			return Type.getType("[" + Type.getObjectType(name.replace('.', '/')).getDescriptor());
//		} else if (primaryTypeMaps.containsKey(name)) return primaryTypeMaps.get(name);
//		return Type.getType(name.replace('.', '/'));
//	}

//	static Type[] typeOf(Clazz... clazzes) {
//		return every(Type.class, clazzes, c -> c.getType());
//	}
//
//	static Type[] typeOf(List<Field> fields) {
//		return every(Type.class, fields, f -> f.clazz.getType());
//	}

	static Type[] typesOf(List<Clazz> clazzes) {
		return every(Type.class, clazzes, c -> typeOf(c));
	}

	static Type typeOf(String name) {
		if (name == null) return Type.VOID_TYPE;
		if (primaryTypeMaps.containsKey(name)) return primaryTypeMaps.get(name);
		return Type.getObjectType(name.replace('.', '/'));
	}

	static Type[] typeOf(String... classes) {
		return every(Type.class, classes, c -> typeOf(c));
	}

//	static Type typeOf(String name, boolean isarray) {
//		return arrayOf(typeOf(name), isarray);
//	}

//	static   GenericClazz generic(GenericClazz originclazzName) {
//		return originclazzName;
//	}

	public static <T, R> R[] every(Class<R> clazz, List<T> list, Function<T, R> func) {
		@SuppressWarnings("unchecked")
		R[] results = (R[]) Array.newInstance(clazz, list.size());
		for (int i = 0; i < list.size(); i++) {
			results[i] = func.apply(list.get(i));
		}
		return results;
	}

	public static <T, R> R[] every(Class<R> clazz, T[] list, Function<T, R> func) {
		@SuppressWarnings("unchecked")
		R[] results = (R[]) Array.newInstance(clazz, list.length);
		for (int i = 0; i < list.length; i++) {
			results[i] = func.apply(list[i]);
		}
		return results;
	}
}
