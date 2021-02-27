package cc1sj.tinyasm;

import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;
import static cc1sj.tinyasm.TinyAsmBuilder.*;

@SuppressWarnings("unused")
public class TinyAsmBuilder_whileTinyAsmBuilder {

	public static byte[] dump() throws Exception {
		return new TinyAsmBuilder_whileTinyAsmBuilder().dump("cc1sj.tinyasm.TinyAsmBuilder_while");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className).access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_test(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		initThis();

		code.END();
	}

	protected void _test(ClassBody classBody) {
		MethodCode code = classBody.method("test").begin();

		int iGT = cst(20);
		whileEval(cmpGt(iGT, 10), c -> {
			inc(iGT, -1);
		});

		int iGE = cst(20);
		whileEval(cmpGe(iGE, 10), c -> {
			inc(iGE, -1);
		});

		int iEQ = cst(10);
		whileEval(cmpEq(iEQ, 10), c -> {
			inc(iEQ, 1);
		});

		int iLE = cst(0);
		whileEval(cmpLe(iLE, 10), c -> {
			inc(iLE, 1);
		});

		int iLT = cst(0);
		whileEval(cmpLt(iLT, 10), c -> {
			inc(iLT, 1);
		});

		code.END();
	}

}
