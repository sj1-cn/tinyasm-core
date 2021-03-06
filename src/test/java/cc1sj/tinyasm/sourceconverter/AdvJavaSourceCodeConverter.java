package cc1sj.tinyasm.sourceconverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvJavaSourceCodeConverter {

	final static List<String> matches = new ArrayList<>();

	final static List<String> replaces = new ArrayList<>();

	static public String convertCode(String source, Class<?>... KnownClasses) {
		return new AdvJavaSourceCodeConverter().doconvertCode(source, KnownClasses);
	}
//	public class AdvSample extends AdvSampleExtendsClass implements AdvSampleImplmentInterface {

	String thisClassName;
	StringBuilder sb = new StringBuilder();

	void when(boolean check, String text) {
		if (check) sb.append(text);
	}

	static final String name = "([\\w\\d_]+)";
	static final String numberConst = "([\\d_]+)";
	static final String tabs = "([\\t]+)";
	static final String tab1 = "([\\t])";
	static final String Line_start = "^";
	static final String Line_End = "$";
	static final String modifier = "(public|private|protected)";

	static final String SPACE = "                                                                                                                               ";

//	public String?
	public String doconvertCode(String strsource, Class<?>... KnownClasses) {
//		List<String> target = new ArrayList<>();
		String[] source = strsource.split("\\n");
		final StringBuffer buf = new StringBuffer();
		for (String line : source) {
			int len = buf.length();
			buf.append('\t');
			buf.append('\t');
			buf.append(doconvertByLine(line, KnownClasses));
			if (line.strip().length() > 0) {
				etet(buf, line, len);
			}
			buf.append('\n');
		}
		return buf.toString();
	}

	static final int linestart = 80;

	protected void etet(final StringBuffer buf, String line, int len) {
		if (buf.length() - len > linestart) {

		} else {
			int j = 0;
			for (int i = len; i < buf.length(); i++) {
				if (buf.charAt(i) == '\t') {
					j += 4;
				} else {
					j += 1;
				}
			}
			if (j < linestart) {
				buf.append(SPACE.substring(0, linestart - j));
			}
		}

		buf.append("//");
		buf.append(line);
	}

	public String doconvertByLine(String source, Class<?>... KnownClasses) {
		return replaceAll(source);
	}

	static {
		add("package ([^\\n]*);" + Line_End, "//package_(\\\"$1\\\");");


//public class AdvSample extends AdvSampleExtendsClass {
		add(modifier + " class " + name + " extends " + name + " \\{",
				"AdvClassBuilder clazz = $1_().class_(\"$2\").extends_($3.class).enterClassBody();");
		
		add(modifier + " class " + name + " \\{", "AdvClassBuilder clazz = $1_().class_(\"$2\").enterClassBody();");
		add(modifier + " class " + name + " extends " + name + " implements " + name + " \\{",
				"AdvClassBuilder clazz = $1_().class_(\"$2\").extends_($3.class).implements_($4.class).enterClassBody();");
		// Field
		// private String name;
		add(tab1 + modifier + " " + name + " " + name + ";", "$1final $3 $4 = clazz.$2_().field(\"$4\",$3.class);");
		add(tab1 + name + " " + name + ";", "$1final $2 $3 = clazz.field(\"$3\",$2_.class);");

		// Method
		// public void sayHello() {
		add(tab1 + modifier + " (void) " + name + "\\(\\) \\{", "$1clazz.$2_().method(\"$4\").code(code -> {");
		// public int sayHello() {
		add(tab1 + modifier + " " + name + " " + name + "\\(\\) \\{", "$1clazz.$2_().method(\"$4\").code(code -> {");
		

		// 定义本地变量
		add(Line_start + tabs + name + " " + name + " =([^\\n]*);" + Line_End, "$1final $2 $3 =__(\"$3\",$4);");
		add(Line_start + tabs + name + " =([^\\n]*);" + Line_End, "$1__($2,$3);");
		
		add(Line_start + tabs + "for \\(; ([^;]+);([^\\)]+)\\) \\{" + Line_End, "$1_for($2,c->$3).block(c->{");
		add(Line_start + tabs + "if (\\([^\\{]+)\\{" + Line_End, "$1_if$2.then(c->{");
		add(Line_start + tabs + "\\} else \\{" + Line_End, "$1}).else_(c->{");

		add(Line_start + tabs + "while (\\([^\\{]+)\\{" + Line_End, "$1_while$2.block(c->{");
		add(Line_start + tabs + "do \\{" + Line_End, "$1_do(c->{");
		add(Line_start + tabs + "\\} while (\\([^\\n]+)" + Line_End, "$1}).while_$2");

		add(name + " [+] " + name, "add($1,$2)");
		add(name + " [-] " + name, "minus($1,$2)");
		add(name + " [*] " + name, "multi");
		add(name + " [/] " + name, "divide($1,$2)");
		add(name + " > " + name, "isGreaterThan($1,$2)");
		add(name + " == " + name, "isEqual($1,$2)");
		add(name + " < " + name, "isLessThan($1,$2)");
		add(name + " >= " + name, "isGreaterEqual($1,$2)");
		add(name + " <= " + name, "isLessThan($1,$2)");
		add(name + "[+][+]", "_inc($1,1)");

		add(Line_start + tabs + "}" + Line_End, "$1});");


//		for (; k > 10; k++) {

		add(Line_start + "}" + Line_End, "return clazz.end().toByteArray();");

		add(numberConst + "\\) " + name + "\\(\\) \\{", "$1clazz.$2_().method(\"$4\").code(code -> {");

	}

	public static void add(String match, String replace) {
		matches.add(match);
		replaces.add(replace);
	}

	public String excludeLocalVariable(String input) {
		input = input.replaceAll("methodVisitor.visitLocalVariable[^\\n]*;\\n", "");
		return input;
	}

	Class<?>[] predefineKnownClasses = new Class<?>[] { String.class, List.class, ArrayList.class, Map.class, HashMap.class };

	public static String refineCode(String source, Class<?>... KnownClasses) {
		return new AdvJavaSourceCodeConverter().DorefineCode(source, KnownClasses);
	}

	public String DorefineCode(String source, Class<?>... KnownClasses) {

		return source;
	}

	public String replaceAll(String input) {
		for (int i = 0; i < matches.size(); i++) {
			input = input.replaceAll(matches.get(i), replaces.get(i));
		}
		return input;
	}

}
