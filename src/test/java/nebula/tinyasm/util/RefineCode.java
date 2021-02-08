package nebula.tinyasm.util;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RefineCode {

	static enum TYPE {
		STRING, NAME, INT, ACCESS, PARAMS_RET, BOOLEAN, CLAZZARRAY, NORMAL_CLASS_ACCESS, ACC_PUBLIC, CLASSDESCRIPTION,
		CLASSNAME
	}

	static final List<String> matches = new ArrayList<>();

	static final List<String> replaces = new ArrayList<>();

	static EnumMap<TYPE, String> mat = new EnumMap<>(TYPE.class);
	static {
		mat.put(TYPE.STRING, "((?:\\\"[^\\\"]*\\\")|null)");
		mat.put(TYPE.NAME, "([\\w|_|\\d]+)");
		mat.put(TYPE.INT, "([\\d]+)");
		mat.put(TYPE.ACCESS, "([\\w|_]+(?: \\+ [\\w|_]+)*)");

		String matchInntenalName = "(?:[\\w\\d_]+(?:\\/[\\w\\d_]+)*)";

		String matchObjectDescription = "(?:L" + matchInntenalName + ";)";
		String matchObjectDescriptionOrPrimary = "(?:" + matchObjectDescription + "|\\w)";
		String matchObjectDescriptionWithArray = "(?:\\[?" + matchObjectDescriptionOrPrimary + ")";
		String matchObjectDescriptionGeneric = "(?:" + matchObjectDescriptionWithArray + "(?:<"
				+ matchObjectDescriptionWithArray + "+>)?)";

//			String type = "(?:(?:\\[?L(?:\\w|\\/|\\d)*;)|\\w)*";
		mat.put(TYPE.PARAMS_RET,
				"\\\"\\((" + matchObjectDescriptionGeneric + "*)\\)(" + matchObjectDescriptionGeneric + ")\\\"");
		mat.put(TYPE.CLASSDESCRIPTION, "(\\\"" + matchObjectDescriptionGeneric + "*\\\")");
		mat.put(TYPE.CLASSNAME, "(\\\"" + matchInntenalName + "\\\")");
		mat.put(TYPE.BOOLEAN, "(true|false)");
		mat.put(TYPE.CLAZZARRAY, "((?:new String\\[\\] \\{ \\\"[\\d|\\w|\\.\\/]*\\\" \\})|null)");
		mat.put(TYPE.NORMAL_CLASS_ACCESS, "(ACC_PUBLIC \\+ ACC_SUPER)");
		mat.put(TYPE.ACC_PUBLIC, "(ACC_PUBLIC)");

//		"Ljava/lang/Object;Lnebula/module/JdbcRowMapper<Lnebula/module/User;>;"
		prepareMatches();
	}

	public static void add(String match, String replace) {
		matches.add(match);
		replaces.add(replace);
//		System.out.println("match: " + match + " replace: " + replace);
	}

	public static String excludeLocalVariable(String input) {
		input = input.replaceAll("methodVisitor.visitLocalVariable[^\\n]*;\\n", "");
		return input;
	}
	public static String excludeLineNumber(String input) {
		input = input.replaceAll("methodVisitor.visitParameter[^\\n]*;\\n", "");
//		input = input.replaceAll("methodVisitor.visitLocalVariable[^\\n]*;\\n", "");
		input = input.replaceAll("LineNumber\\([0-9]*\\,", "LineNumber(1,");

//		input = input.replaceAll("Label l1 = new Label\\(\\)[^\\n]*;\\n", "");
//		input = input.replaceAll("methodVisitor.visitLabel\\(l1\\)[^\\n]*;\\n", "");

//		input = input.replaceAll("methodVisitor.visitMaxs[^\\n]*;\\n", "");
		input = input.replaceAll("methodVisitor.visitFrame[^\\n]*;\\n", "");

		input = input.replaceAll("methodVisitor.visitLocalVariable\\(\\\"this\\$0\\\"[^\\n]*;\\n", "");
		
		input = input.replaceAll(
				visit("methodVisitor.visitLocalVariable", TYPE.STRING, TYPE.STRING, TYPE.STRING, TYPE.NAME, TYPE.NAME, TYPE.NAME),
				"methodVisitor.visitLocalVariable($1,$2,$3,l0,l1,$6);\n");
//		add(,
//				);
//		
//		methodVisitor.visitLocalVariable("this", "Lnebula/module/UserJdbcRepository;", null, l0, l1, 0);

		return input;
	}

	public static String getClasName(CharSequence source) {
		Pattern p = Pattern.compile(
				visit("cw.visit", TYPE.INT, TYPE.ACCESS, TYPE.CLASSNAME, TYPE.STRING, TYPE.CLASSNAME, TYPE.CLAZZARRAY));
		Matcher m = p.matcher(source);
		while (m.find()) {
			return m.group(3).replaceAll("\"", "").replaceAll("/", ".");
		}
		return null;
	}

	public static String matchTypeDescription(String input) {
		StringBuilder source = new StringBuilder(input);
		Pattern p = Pattern.compile("L[\\w|\\d]+(?:\\/[\\w|\\d|\\/]+)*;");
		Matcher m = p.matcher(source); // 获取 matcher 对象
		while (m.find()) {
			for (int i = m.start(); i < m.end(); i++) {
				if (source.charAt(i) == '/') {
					source.setCharAt(i, '.');
				}
			}
		}
		return source.toString().replaceAll("L([\\w|\\d]+(?:\\.[\\w|\\d|\\/]+)*);", "$1");
	}

	public static String matchTypeInternalNameToClassName(String input) {
		StringBuilder source = new StringBuilder(input);
		Pattern p = Pattern.compile("\\\"[\\w|\\d]+(?:\\/[\\w|\\d|\\/]+)*\\\"");
		Matcher m = p.matcher(source); // 获取 matcher 对象
		while (m.find()) {
			for (int i = m.start(); i < m.end(); i++) {
				if (source.charAt(i) == '/') {
					source.setCharAt(i, '.');
				}
			}
		}
		return source.toString();
	}

	public static void prepareMatches() {
		// remove header
		{
			add("package (?:[\\w|\\.|\\d]+);\\n", "");
			add("import java.util.*;\\n", "");
			add("import org.objectweb.asm.*;\\n", "");
			add("public class (?:[\\w|\\.|\\d]+) implements Opcodes \\{\\n", "");

			add("public static byte\\[\\] dump \\(\\) throws Exception \\{\\n", "");

			add("ClassWriter cw = new ClassWriter\\(0\\);\\n", "");
			add("FieldVisitor fv;\\n", "");
			add("MethodVisitor mv;\\n", "");
			add("AnnotationVisitor av0;\\n", "");
			add("cw.visitEnd\\(\\);\\n", "");
			add("return cw.toByteArray\\(\\);\\n", "return cw.end().toByteArray();\n");

			add(visit("cw.visitInnerClass", TYPE.STRING, TYPE.STRING, TYPE.STRING, TYPE.ACCESS),
					"cw.referInnerClass($2,$3);/*$4*/\n");

		}

		// class
		{

			add(visit("cw.visit", TYPE.INT, TYPE.NORMAL_CLASS_ACCESS, TYPE.CLASSNAME, TYPE.STRING, TYPE.CLASSNAME,
					TYPE.CLAZZARRAY), "ClassBody cw = ClassBuilder.make($3).eXtend($5).body()/*$4 $6*/;");
			add(visit("cw.visit", TYPE.INT, TYPE.ACCESS, TYPE.CLASSNAME, TYPE.CLASSNAME, TYPE.CLASSDESCRIPTION,
					TYPE.CLAZZARRAY), "ClassBody cw = ClassBuilder.make($2,$3).eXtend($5).body()/*$4 $6*/;");
			add(".eXtend\\(\\\"java/lang/Object\\\"\\)", "");
			add("cw.visitSource\\(" + mat.get(TYPE.STRING) + ", null\\);\n", "");
		}

		// field
		{

			add(visit("fv = cw.visitField", TYPE.ACCESS, TYPE.STRING, TYPE.STRING, TYPE.STRING, TYPE.STRING),
					"cw.field($1,$2,$3);\n");
			add("fv.visitEnd\\(\\);\n", "");
		}
		// method
		// mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "dump", "()[B", null, new
		// String[] { "java/lang/Exception" });
		{
			add(visit("mv = cw.visitMethod", TYPE.ACC_PUBLIC, TYPE.STRING, TYPE.PARAMS_RET, TYPE.STRING,
					TYPE.CLAZZARRAY), "cw.method($2).parameter(\"name\",\"$3\").reTurn(\"$4\")/*$5*//*$6*/\n");

			add(visit("mv = cw.visitMethod", TYPE.ACCESS, TYPE.STRING, TYPE.PARAMS_RET, TYPE.STRING, TYPE.CLAZZARRAY),
					"cw.method($1,$2).parameter(\"name\",\"$3\").reTurn(\"$4\")/*$5*//*$6*/\n");

			add("methodVisitor.visitCode\\(\\);", ".code(mv -> {");
			add("methodVisitor.visitEnd\\(\\);", "});");
			add("\\.reTurn\\(V\\)", "");
			add("/\\*null\\*/", "");

			add(".parameter\\(\\\"name\\\",\\\"\\\"\\)", "");

		}
		{
			add("Label l\\d* = new Label\\(\\);\n", "");
			add("methodVisitor.visitLabel\\(l\\d*\\);\n", "");
			add(visit("methodVisitor.visitLabel", TYPE.NAME), "");
			add(visit("methodVisitor.visitLineNumber", TYPE.INT, TYPE.NAME), "methodVisitor.line();\n");
			add(visit("methodVisitor.visitMaxs", TYPE.INT, TYPE.INT), "");
			add(visit("methodVisitor.visitTypeInsn", "NEW", TYPE.STRING), "methodVisitor.NEW($1);\n");
			add(visit("methodVisitor.visitInsn", "DUP"), "methodVisitor.DUP();\n");
			add(visit("methodVisitor.visitInsn", "POP"), "methodVisitor.POP();\n");
			add(visit("methodVisitor.visitInsn", "RETURN"), "methodVisitor.RETURN();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]RETURN"), "methodVisitor.RETURNTop();\n");

			add(visit("methodVisitor.visitVarInsn", "[A|I|L|F|D]LOAD", TYPE.INT), "methodVisitor.LOAD($1);\n");
			add(visit("methodVisitor.visitVarInsn", "[A|I|L|F|D]STORE", TYPE.INT), "methodVisitor.STORE($1);\n");

			add(visit("methodVisitor.visitInsn", "AASTORE"), "methodVisitor.ARRAYSTORE();\n");

			add(visit("methodVisitor.visitInsn", "ATHROW"), "methodVisitor.ATHROW();\n");

			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]ADD"), "methodVisitor.ADD();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]SUB"), "methodVisitor.SUB();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]MUL"), "methodVisitor.MUL();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]DIV"), "methodVisitor.DIV();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]REM"), "methodVisitor.REM();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]AND"), "methodVisitor.AND();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]OR"), "methodVisitor.OR();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]XOR"), "methodVisitor.XOR();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]SHL"), "methodVisitor.SHL();\n");
			add(visit("methodVisitor.visitInsn", "[A|I|L|F|D]SHR"), "methodVisitor.SHR();\n");
			add(visit("methodVisitor.visitInsn", "(\\w2\\w)"), "methodVisitor.$1();\n");

			add(visit("methodVisitor.visitIntInsn", "BIPUSH", TYPE.INT), "methodVisitor.LOADConst($1);\n");

			add(visit("methodVisitor.visitTypeInsn", "NEW", TYPE.STRING), "methodVisitor.NEW($1);\n");
			add(visit("methodVisitor.visitTypeInsn", "CHECKCAST", TYPE.STRING), "methodVisitor.CHECKCAST($1);\n");

			add("methodVisitor.visitInsn\\(ICONST_(\\d*)\\);\n", "methodVisitor.LOADConst($1);\n");

			add(visit("methodVisitor.visitFieldInsn", "PUTSTATIC", TYPE.STRING, TYPE.STRING, TYPE.STRING),
					"methodVisitor.PUTSTATIC($1,$2,$3);\n");

			add(visit("methodVisitor.visitFieldInsn", "GETSTATIC", TYPE.STRING, TYPE.STRING, TYPE.STRING),
					"methodVisitor.GETSTATIC($1,$2,$3);\n");

			add(visit("methodVisitor.visitFieldInsn", "PUTFIELD", TYPE.STRING, TYPE.STRING, TYPE.STRING), "methodVisitor.PUTFIELD($2,$3);\n");

			add(visit("methodVisitor.visitFieldInsn", "GETFIELD", TYPE.STRING, TYPE.STRING, TYPE.STRING), "methodVisitor.GETFIELD($2,$3);\n");

			add(visit("methodVisitor.visitLdcInsn", TYPE.STRING), "methodVisitor.LOADConst($1);\n");

			add("methodVisitor.visitLdcInsn\\((new Long\\(\\d*L\\))\\);", "methodVisitor.LOADConst($1);\n");

			add(visit("methodVisitor.visitLocalVariable", "\\\"this\\\"", TYPE.STRING, TYPE.STRING, TYPE.NAME, TYPE.NAME,
					TYPE.INT), "");

			add(visit("methodVisitor.visitLocalVariable", TYPE.STRING, TYPE.STRING, TYPE.STRING, TYPE.NAME, TYPE.NAME, TYPE.INT),
					"methodVisitor.define($1,$2);/*$6*/\n");

			add(visit("methodVisitor.visitMethodInsn", "INVOKESPECIAL", TYPE.STRING, TYPE.STRING, TYPE.PARAMS_RET, TYPE.BOOLEAN),
					"methodVisitor.SPECIAL($1,$2).parameter(\"$3\").reTurn(\"$4\").INVOKE();\n");
			add(visit("methodVisitor.visitMethodInsn", "INVOKESTATIC", TYPE.STRING, TYPE.STRING, TYPE.PARAMS_RET, TYPE.BOOLEAN),
					"methodVisitor.STATIC($1,$2).parameter(\"$3\").reTurn(\"$4\").INVOKE();\n");
			add(visit("methodVisitor.visitMethodInsn", "INVOKEVIRTUAL", TYPE.STRING, TYPE.STRING, TYPE.PARAMS_RET, TYPE.BOOLEAN),
					"methodVisitor.VIRTUAL($1,$2).parameter(\"$3\").reTurn(\"$4\").INVOKE();\n");
			add(visit("methodVisitor.visitMethodInsn", "INVOKEINTERFACE", TYPE.STRING, TYPE.STRING, TYPE.PARAMS_RET, TYPE.BOOLEAN),
					"methodVisitor.INTERFACE($1,$2).parameter(\"$3\").reTurn(\"$4\").INVOKE();\n");

			add("\\.parameter\\(\"\"\\)", "");
			add("\\.parameter\\(\"J\"\\)", ".parameter(long.class)");
			add("\\.parameter\\(\"I\"\\)", ".parameter(int.class)");
			add("\\.reTurn\\(\"V\"\\)", "");
			add("\\.reTurn\\(\"Z\"\\)", ".reTurn(boolean.class)");
			add("\\.reTurn\\(\"I\"\\)", ".reTurn(int.class)");
			add("\\.reTurn\\(\"J\"\\)", ".reTurn(long.class)");

			add("\\\"Ljava/lang/String;\\\"", "String.class");
			add("\\\"Ljava/lang/Object;\\\"", "Object.class");
			add("\\\"java/lang/String\\\"", "String.class");
			add("\\\"java/lang/Object\\\"", "Object.class");
		}
	}

	static Class<?>[] predefineKnownClasses = new Class<?>[] { String.class, List.class, ArrayList.class, Map.class,
			HashMap.class };

	public static String refineCode(String source, Class<?>... KnownClasses) {
		String classname = getClasName(source);

		source = replaceAll(source);

		for (Class<?> clazz : KnownClasses) {
			String string = clazz.getName();
			String iname = string.replace(".", "/");
			String clzname = string.substring(string.lastIndexOf('.') + 1, string.length());
			source = source.replaceAll("\\\"L" + iname + ";\\\"", clzname + ".class");
			source = source.replaceAll("\\\"" + iname + "\\\"", clzname + ".class");
		}
		for (Class<?> clazz : predefineKnownClasses) {
			String string = clazz.getName();
			String iname = string.replace(".", "/");
			String clzname = string.substring(string.lastIndexOf('.') + 1, string.length());
			source = source.replaceAll("\\\"L" + iname + ";\\\"", clzname + ".class");
			source = source.replaceAll("\\\"" + iname + "\\\"", clzname + ".class");
		}

		source = matchTypeInternalNameToClassName(source);
		source = matchTypeDescription(source);

		source = source.replaceAll("\\\"" + classname + "\\\"", "clazz");
		source = "String clazz = \"" + classname + "\";" + source;

		return source;
	}

	public static String replaceAll(String input) {
		for (int i = 0; i < matches.size(); i++) {
			input = input.replaceAll(matches.get(i), replaces.get(i));
		}
		return input;
	}

	public static String skipToString(String input) {
//		input = input.replaceAll("\\n", "<br/>");
//		input = input.replaceAll("(\\{<br/>mv = cw.visitMethod\\()", "\n<method>$1");
//		input = input.replaceAll("(methodVisitor.visitEnd\\(\\);<br/>})", "$1</method>\n");
//
//		input = input.replaceAll("(<method>\\{<br/>mv = cw.visitMethod\\(ACC_PUBLIC, \"toString\",[^\\n]*)", "");
//
//		input = input.replaceAll("\\n<method>", "");
//		input = input.replaceAll("</method>\\n", "");
//		input = input.replaceAll("<br/>", "\n");
		return input;
	}

	public static String visit(String method, String opcode, TYPE... params) {
//			String matchParam = "([^,]*)";

		StringBuilder sb = new StringBuilder();
		sb.append(method);
		sb.append("\\(");
		sb.append(opcode);
		for (int i = 0; i < params.length; i++) {
			sb.append(",(?: ?)");
			sb.append(mat.get(params[i]));
		}
		sb.append("\\);\n");

		return sb.toString();

//			String match = "methodVisitor.visit(\\w*)\\((\\w*), ([^,]*), ([^,]*), ([^,]*), ([^,]*)\\);";

	}

	public static String visit(String method, TYPE... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(method);
		sb.append("\\(");
		for (int i = 0; i < params.length && i < 1; i++) {
			sb.append(mat.get(params[i]));
		}
		for (int i = 1; i < params.length; i++) {
			sb.append(",(?: ?)");
			sb.append(mat.get(params[i]));
		}
		sb.append("\\);\n");

		return sb.toString();

//			String match = "methodVisitor.visit(\\w*)\\((\\w*), ([^,]*), ([^,]*), ([^,]*), ([^,]*)\\);";

	}
}
