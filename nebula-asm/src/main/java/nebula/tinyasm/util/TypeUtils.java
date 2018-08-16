package nebula.tinyasm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.data.Field;
import nebula.tinyasm.data.GenericClazz;

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

	static public Type stringInnerUserType(Type type) {
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

	static public Type mathInnerUserType(Type type) {
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

	static public String[] internalNameOf(Class<?>... classes) {
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

	static public String signatureOf(String type, String... signatureClasses) {
		return signatureOf(typeOf(type), typeOf(signatureClasses));
	}

	static public String signatureOf(String type, Class<?>... signatureClasses) {
		return signatureOf(typeOf(type), typeOf(signatureClasses));
	}

	static public String signatureOf(Class<?> type, Class<?>... signatureClasses) {
		return signatureOf(typeOf(type), typeOf(signatureClasses));
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

	static public String toPropertyGetName(String name, String clazz) {
		return "get" + toPropertyName(name);
	}

	static public String toPropertyGetName(String name, Class<?> clazz) {
		return "get" + toPropertyName(name);
	}

	static public String toPropertyName(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}

	static public String toPropertySetName(String name, String clazz) {
		return "set" + toPropertyName(name);
	}

	static public String toPropertySetName(String name, Class<?> clazz) {
		return "set" + toPropertyName(name);
	}

	static public String toSimpleName(String name) {
		int index = name.lastIndexOf('.');
		if (index < 0) index = name.lastIndexOf('/');

		return name.substring(index + 1);
	}

	static Map<String, Type> primaryTypeMaps = new HashMap<String, Type>();
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

	static public int arrayTyoeCodeOf(Type type) {
		return arrayTypeMaps.get(type);
	}

	static public Type typeOf(Class<?> clz) {
		if (clz == null) return Type.VOID_TYPE;
		return Type.getType(clz);
	}

	static public Type typeOf(Class<?> clz, boolean isarray) {
		return arrayOf(Type.getType(clz), isarray);
	}

	static public Type typeOf(String name, boolean isarray) {
		return arrayOf(typeOf(name), isarray);
	};

	static public Type typeOf(String name) {
		if (name == null) return Type.VOID_TYPE;
		if (primaryTypeMaps.containsKey(name)) return primaryTypeMaps.get(name);
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

	static public String internalNamelOf(Type types) {
		return types.getInternalName();
	}

	static public String internalNamelOf(GenericClazz clazz) {
		return typeOf(clazz.clazz).getInternalName();
	}

	static public String internalNamelOf(String clazz) {
		return typeOf(clazz).getInternalName();
	}

	static public String[] internalNamelOf(Type[] types) {
		String[] strs = new String[types.length];
		for (int i = 0; i < types.length; i++) {
			strs[i] = types[i].getInternalName();
		}
		return strs;
	}

	static public String[] internalNamesOf(List<GenericClazz> clazzes) {
		String[] strs = new String[clazzes.size()];
		for (int i = 0; i < clazzes.size(); i++) {
			strs[i] = typeOf(clazzes.get(i).clazz).getInternalName();
		}
		return strs;
	}

	static public String[] internalNamesOf(GenericClazz... clazzes) {
		String[] strs = new String[clazzes.length];
		for (int i = 0; i < clazzes.length; i++) {
			strs[i] = typeOf(clazzes[i].clazz).getInternalName();
		}
		return strs;
	}

	static public String[] internalNamelOf(String[] classes) {
		String[] strs = new String[classes.length];
		for (int i = 0; i < classes.length; i++) {
			strs[i] = typeOf(classes[i]).getInternalName();
		}
		return strs;
	}

	static public Type[] typeOf(Field... fields) {
		Type[] types = new Type[fields.length];
		for (int i = 0; i < fields.length; i++) {
			types[i] = typeOf(fields[i].clazz.clazz);
		}
		return types;
	}

	static public Type[] typeOf(List<Field> fields) {
		Type[] types = new Type[fields.size()];
		for (int i = 0; i < fields.size(); i++) {
			types[i] = typeOf(fields.get(i).clazz.clazz);
		}
		return types;
	}


	static public String classnameOf(Class<?> clazz) {
		return clazz.getName();
	}

	static public String[] classnamesOf(Class<?>... clazz) {
		String[] names = new String[clazz.length];
		for (int i = 0; i < names.length; i++) {
			names[i] = clazz[i].getName();
		}
		return names;
	}

	static public String[] classnamesOf(String... clazz) {
		return clazz;
	}

	static public String classnameOf(String clazz) {
		return clazz;
	}

	static public String classnameOf(Type type) {
		return type.getClassName();
	}

	static public String classnameOf(GenericClazz clazz) {
		return clazz.clazz;
	}

	static public String[] classnamesOf(Type[] types) {
		String[] strs = new String[types.length];
		for (int i = 0; i < types.length; i++) {
			strs[i] = types[i].getClassName();
		}
		return strs;
	}

	static public String[] classnamesOf(List<GenericClazz> clazzes) {
		String[] strs = new String[clazzes.size()];
		for (int i = 0; i < clazzes.size(); i++) {
			strs[i] = clazzes.get(i).clazz;
		}
		return strs;
	}

	static public String[] classnamesOf(GenericClazz... clazzes) {
		String[] strs = new String[clazzes.length];
		for (int i = 0; i < clazzes.length; i++) {
			strs[i] = clazzes[i].clazz;
		}
		return strs;
	}

}
