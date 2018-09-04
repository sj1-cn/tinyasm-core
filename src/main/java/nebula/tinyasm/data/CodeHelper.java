package nebula.tinyasm.data;

import java.util.function.Consumer;

public class CodeHelper {
	public static Consumer<MethodCode> Const(int cst) {
		return p -> p.loadConst(cst);
	}

	public static Consumer<MethodCode> Const(long cst) {
		return p -> p.loadConst(cst);
	}

	public static Consumer<MethodCode> Const(String cst) {
		return p -> p.loadConst(cst);
	}

	public static Consumer<MethodCode> Var(String name) {
		return p -> p.load(name);
	}
}
