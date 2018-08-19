package nebula.tinyasm.util;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RefineCode {

	static enum TYPE {
		STRING, NAME, INT, ACCESS, PARAMS_RET, BOOLEAN
	}

	static final List<String> matches = new ArrayList<>();

	static final List<String> replaces = new ArrayList<>();

	static EnumMap<TYPE, String> mat = new EnumMap<>(TYPE.class);
	static {
		mat.put(TYPE.STRING, "((?:\\\"[^\\\"]*\\\")|null)");
		mat.put(TYPE.NAME, "([\\w|_]+)");
		mat.put(TYPE.INT, "([\\d]+)");
		mat.put(TYPE.ACCESS, "([\\w|_]+(?: \\+ [\\w|_]+)*)");

		String matchObjectName = "(?:L(?:\\w|\\/|\\d)+;)";
		String matchObjectNameOrPrimary = "(?:" + matchObjectName + "|\\w)";
		;
		String matchObjectNameWithArray = "(?:\\[?" + matchObjectNameOrPrimary + ")";
//			String type = "(?:(?:\\[?L(?:\\w|\\/|\\d)*;)|\\w)*";
		mat.put(TYPE.PARAMS_RET, "\\\"\\((" + matchObjectNameWithArray + "*)\\)(" + matchObjectNameWithArray + ")\\\"");
		mat.put(TYPE.BOOLEAN, "(true|false)");

		prepareMatches();

	}

	public static void add(String match, String replace) {
		matches.add(match);
		replaces.add(replace);
		System.out.println("match: " + match + " replace: " + replace);
	}

	public static String excludeLineNumber(String input) {
		input = input.replaceAll("mv.visitParameter[^\\n]*;\\n", "");
		input = input.replaceAll("mv.visitLocalVariable[^\\n]*;\\n", "");
		input = input.replaceAll("LineNumber\\([0-9]*\\,", "LineNumber(1,");

		input = input.replaceAll("Label l1 = new Label\\(\\)[^\\n]*;\\n", "");
		input = input.replaceAll("mv.visitLabel\\(l1\\)[^\\n]*;\\n", "");

		input = input.replaceAll("mv.visitMaxs[^\\n]*;\\n", "");

		return input;
	}

	public static String getClasName(CharSequence source) {
		Pattern p = Pattern
			.compile(visit("cw.visit", TYPE.INT, TYPE.ACCESS, TYPE.STRING, TYPE.STRING, TYPE.STRING, TYPE.STRING));
		Matcher m = p.matcher(source); // 获取 matcher 对象
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
			add("public static class (?:[\\w|\\.|\\d]+) implements Opcodes \\{\\n", "");

			add("public static  byte\\[\\] dump \\(\\) throws Exception \\{\\n", "");

			add("ClassWriter cw = new ClassWriter\\(0\\);\\n", "");
			add("FieldVisitor fv;\\n", "");
			add("MethodVisitor mv;\\n", "");
			add("AnnotationVisitor av0;\\n", "");
			add("cw.visitEnd\\(\\);\\n", "");

			add(visit("cw.visitInnerClass", TYPE.STRING, TYPE.STRING, TYPE.STRING, TYPE.ACCESS),
					"cw.referInnerClass($2,$3);/*$4*/\n");

		}

		// class
		{
			add(visit("cw.visit", TYPE.INT, TYPE.ACCESS, TYPE.STRING, TYPE.STRING, TYPE.STRING, TYPE.STRING),
					"ClassBody cw = ClassBuilder.make($2,$3).eXtend($5).body();");
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
			add(visit("mv = cw.visitMethod", TYPE.ACCESS, TYPE.STRING, TYPE.PARAMS_RET, TYPE.STRING, TYPE.STRING),
					"cw.method($1,$2).parameter(\"name\",\"$3\").reTurn(\"$4\")/*$5*/\n");

			add("mv.visitCode\\(\\);", ".code(mv -> {");
			add("mv.visitEnd\\(\\);", "});");
			add("\\.reTurn\\(V\\)", "");
			add("/\\*null\\*/", "");

			add(".parameter\\(\\\"name\\\",\\\"\\\"\\)", "");

		}
		{
			add("Label l\\d* = new Label\\(\\);\n", "");
			add("mv.visitLabel\\(l\\d*\\);\n", "");
			add(visit("mv.visitLabel", TYPE.NAME), "");
			add(visit("mv.visitLineNumber", TYPE.INT, TYPE.NAME), "mv.line();\n");
			add(visit("mv.visitTypeInsn", "NEW", TYPE.STRING), "mv.NEW($1);\n");
			add(visit("mv.visitInsn", "DUP"), "mv.DUP();\n");
			add(visit("mv.visitInsn", "POP"), "mv.POP();\n");
			add(visit("mv.visitInsn", "RETURN"), "mv.RETURN();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]RETURN"), "mv.RETURNTop();\n");

			add(visit("mv.visitVarInsn", "[A|I|L|F|D]LOAD", TYPE.INT), "mv.LOAD($1);\n");
			add(visit("mv.visitVarInsn", "[A|I|L|F|D]STORE", TYPE.INT), "mv.STORE($1);\n");

			add(visit("mv.visitInsn", "AASTORE"), "mv.ARRAYSTORE();\n");

			add(visit("mv.visitInsn", "[A|I|L|F|D]ADD"), "mv.ADD();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]SUB"), "mv.SUB();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]MUL"), "mv.MUL();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]DIV"), "mv.DIV();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]REM"), "mv.REM();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]AND"), "mv.AND();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]OR"), "mv.OR();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]XOR"), "mv.XOR();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]SHL"), "mv.SHL();\n");
			add(visit("mv.visitInsn", "[A|I|L|F|D]SHR"), "mv.SHR();\n");
			add(visit("mv.visitInsn", "(\\w2\\w)"), "mv.$1();\n");

			add(visit("mv.visitIntInsn", "BIPUSH", TYPE.INT), "mv.LOADConst($1);\n");

			add(visit("mv.visitTypeInsn", "NEW", TYPE.STRING), "mv.NEW($1);\n");
			add(visit("mv.visitTypeInsn", "CHECKCAST", TYPE.STRING), "mv.CHECKCAST($1);\n");

			add("mv.visitInsn\\(ICONST_(\\d*)\\);\n", "mv.LOADConst($1);\n");

			add(visit("mv.visitFieldInsn", "GETSTATIC", TYPE.STRING, TYPE.STRING, TYPE.STRING),
					"mv.GETSTATIC($1,$2,$3);\n");

			add(visit("mv.visitFieldInsn", "PUTFIELD", TYPE.STRING, TYPE.STRING, TYPE.STRING),
					"mv.PUTFIELD($1,$2,$3);\n");

			add(visit("mv.visitFieldInsn", "GETFIELD", TYPE.STRING, TYPE.STRING, TYPE.STRING),
					"mv.PUTFIELD($1,$2,$3);\n");

			add(visit("mv.visitLdcInsn", TYPE.STRING), "mv.LOADConst($1);\n");

			add("mv.visitLdcInsn\\((new Long\\(\\d*L\\))\\);", "mv.LOADConst($1);\n");

			add(visit("mv.visitMethodInsn", "INVOKESPECIAL", TYPE.STRING, TYPE.STRING, TYPE.PARAMS_RET, TYPE.BOOLEAN),
					"mv.VIRTUAL($1,$2).param(\"$3\").reTurn(\"$4\").INVOKE();\n");
			add(visit("mv.visitMethodInsn", "INVOKESTATIC", TYPE.STRING, TYPE.STRING, TYPE.PARAMS_RET, TYPE.BOOLEAN),
					"mv.VIRTUAL($1,$2).param(\"$3\").reTurn(\"$4\").INVOKE();\n");
			add(visit("mv.visitMethodInsn", "INVOKEVIRTUAL", TYPE.STRING, TYPE.STRING, TYPE.PARAMS_RET, TYPE.BOOLEAN),
					"mv.VIRTUAL($1,$2).param(\"$3\").reTurn(\"$4\").INVOKE();\n");
			add(visit("mv.visitMethodInsn", "INVOKEINTERFACE", TYPE.STRING, TYPE.STRING, TYPE.PARAMS_RET, TYPE.BOOLEAN),
					"mv.VIRTUAL($1,$2).param(\"$3\").reTurn(\"$4\").INVOKE();\n");

			add("\\.param\\(\"\"\\)", "");
			add("\\.reTurn\\(\"V\"\\)", "");

		}
	}

	public static String refineCode(String source) {
		String classname = getClasName(source);

		source = replaceAll(source);
		source = matchTypeInternalNameToClassName(source);
		source = matchTypeDescription(source);

		source = source.replaceAll("\\\"" + classname + "\\\"", "clazz");
		source = "String clazz = \"" + classname + "\";" + source;

		return source;
	}
//
//	public static String refineCode(String input) {
//
//		// match by line
//		input = input.replaceAll("Label (l\\d*) = new Label\\(\\);\\s*\\n", "Label $1 = mv.codeNewLabel();");
//		input = input.replaceAll("mv.visitLabel\\((l\\d*)\\);", "mv.codeAccessLabel\\($1\\);");
//		input = input.replaceAll("mv.visitLineNumber\\(\\d, \\w\\d\\);\\s*\\n", "");
//
//		input = input.replaceAll("mv.visitInsn\\(LCMP\\);", "mv.CMP();");
//		input = input.replaceAll("mv.visitInsn\\((?:D|F)CMPG\\);", "mv.CMPG();");
//		input = input.replaceAll("mv.visitInsn\\((?:D|F)CMPL\\);", "mv.CMPL();");
//
//		input = input.replaceAll("mv.visitInsn\\(\\wRETURN\\);", "mv.RETURNTop();");
//		input = input.replaceAll("mv.visitVarInsn\\(\\wLOAD, (\\d*)\\);", "mv.LOAD($1);");
//		input = input.replaceAll("mv.visitInsn\\(\\wALOAD\\);", "mv.ARRAYLOAD();");
//		input = input.replaceAll("mv.visitInsn\\(\\wASTORE\\);", "mv.ARRAYSTORE();");
//		input = input.replaceAll("mv.visitFieldInsn\\(GETFIELD, \"[^\"]*\", (\"[^\"]*\")[^\\n]*;\\n",
//				"mv.GETFIELD($1);");
//		input = input.replaceAll("mv.visitFieldInsn\\(PUTFIELD, \"[^\"]*\", (\"[^\"]*\")[^\\n]*;\\n",
//				"mv.PUTFIELD($1);");
//
//		input = input.replaceAll("mv.visitLdcInsn(\\([^;]*)[^\\n]*;\\n", "mv.LOADConst$1;");
//
//		input = input.replaceAll("mv.visitJumpInsn\\((\\w+), (l\\d+)\\);", "mv.$1($2);");
//
//		input = input.replaceAll("mv.visitLocalVariable\\(\"([\\d\\w]*)\", \"(\\w+)\"[^;]+;",
//				"<def>mv.define(\"$1\",\"$2\"\\);</def>");
//		input = input.replaceAll("mv.visitLocalVariable\\(\\\"this\\\"[^\\n]*\\n", "");
//		input = input.replaceAll("mv.visitFrame[^;]*;\\s*\\n", "");
//		input = input.replaceAll("mv.visitMaxs[^;]*;\\s*\\n", "");
//		input = input.replaceAll("mv.visitInsn\\(ICONST_(\\d)\\);", "mv.LOADConst($1);");
//
//		input = input.replaceAll("mv.visitTypeInsn\\(CHECKCAST,", "mv.CHECKCAST(");
//		input = input.replaceAll("mv.visitMethodInsn\\(INVOKE(\\w*),([^,]*),([^,]*),([^,]*), \\w*\\);",
//				"mv.$1\\($2,$3/*$4*/);");
//
//		input = input.replaceAll("mv.visitInsn\\(DUP\\);", "mv.DUP();");
//		input = input.replaceAll("mv.visitTypeInsn\\(NEW, ([^\\)]*)\\);", "mv.NEW($1);");
//
//		// match by method
//		input = input.replaceAll("\\n", "");
//		input = input.replaceAll("\\{(mv = cw.visitMethod\\()", "\n<method>$1");
//		input = input.replaceAll("(mv.visitCode\\(\\);)", "<code>");
//		input = input.replaceAll("(mv.visitEnd\\(\\);})", "</code></method>\n");
//
//		input = input.replaceAll(";(<def>.*)(?:;</def></code>)", ";<defs>$1;</def></defs></code>");
//		input = input.replaceAll("#def#", ";");
//
//		input = input.replaceAll("(<code>)(.*)(<defs>.*</defs>)", "$1$3$2");
//
//		input = input.replaceAll("</?def>", "");
//		input = input.replaceAll("<defs>(.*)</defs>", "$1");
//
//		input = input.replaceAll("mv = cw.visitMethod\\(([^\\n]*);", "cw.method($1");
//		input = input.replaceAll("<method>(.*)</method>", "$1");
//		input = input.replaceAll("<code>(.*)</code>", ".code(mv -> {\n\t$1});");
//
//		// reformater by line
//		input = input.replaceAll("\\);", ");\n");
//
//		input = input.replaceAll("mv = cw.visitMethod\\(([^,],), (\"[^\"]*\"), \"\\(([^\\)]*)\\)([^\"]*)\",[^;]*;",
//				"\tcw.method($1, $2)/*$4 $3*/");
//
//		input = input.replaceAll("(?:\\})?\\{fv = cw.visitField\\(([^,],), \"([^\"]*)\", \"([^\"]*)\",[^;]*;",
//				"cw.field($1, \"$2\", \"$3\");");
//		input = input.replaceAll("fv.visitEnd\\(\\);", "");
//
//		input = input.replaceAll("/\\* \"\\(\\)V\" \\*/", "");
//		return input;
//	}

	public static String replaceAll(String input) {
		for (int i = 0; i < matches.size(); i++) {
			input = input.replaceAll(matches.get(i), replaces.get(i));
		}
		return input;
	}

	public static String skipToString(String input) {
		input = input.replaceAll("\\n", "<br/>");
		input = input.replaceAll("(\\{<br/>mv = cw.visitMethod\\()", "\n<method>$1");
		input = input.replaceAll("(mv.visitEnd\\(\\);<br/>})", "$1</method>\n");

		input = input.replaceAll("(<method>\\{<br/>mv = cw.visitMethod\\(ACC_PUBLIC, \"toString\",[^\\n]*)", "");

		input = input.replaceAll("\\n<method>", "");
		input = input.replaceAll("</method>\\n", "");
		input = input.replaceAll("<br/>", "\n");
		return input;
	}

	public static String visit(String method, String opcode, TYPE... params) {
//			String matchParam = "([^,]*)";

		StringBuilder sb = new StringBuilder();
		sb.append(method);
		sb.append("\\(");
		sb.append(opcode);
		for (int i = 0; i < params.length; i++) {
			sb.append(", ");
			sb.append(mat.get(params[i]));
		}
		sb.append("\\);\n");

		return sb.toString();

//			String match = "mv.visit(\\w*)\\((\\w*), ([^,]*), ([^,]*), ([^,]*), ([^,]*)\\);";

	}

	public static String visit(String method, TYPE... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(method);
		sb.append("\\(");
		for (int i = 0; i < params.length && i < 1; i++) {
			sb.append(mat.get(params[i]));
		}
		for (int i = 1; i < params.length; i++) {
			sb.append(", ");
			sb.append(mat.get(params[i]));
		}
		sb.append("\\);\n");

		return sb.toString();

//			String match = "mv.visit(\\w*)\\((\\w*), ([^,]*), ([^,]*), ([^,]*), ([^,]*)\\);";

	}
}
