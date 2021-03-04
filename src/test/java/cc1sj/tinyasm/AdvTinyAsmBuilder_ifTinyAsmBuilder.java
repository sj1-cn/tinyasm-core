package cc1sj.tinyasm;

import org.objectweb.asm.Label;
import cc1sj.tinyasm.AdvClassBuilder;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;

import static cc1sj.tinyasm.Adv.*;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Object;

@SuppressWarnings("unused")
public class AdvTinyAsmBuilder_ifTinyAsmBuilder {

	public static byte[] dump() throws Exception {
		return new AdvTinyAsmBuilder_ifTinyAsmBuilder().dump("cc1sj.tinyasm.TinyAsmBuilder_if");
	}

	public byte[] dump(String className) throws Exception {
		AdvClassBuilder classBody = public_().class_(className).enterClassBody();

		__init_(classBody);
		_testIfThen(classBody);
		_testIfThenElse(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(AdvClassBuilder classBody) {
		classBody.method("<init>").code(code -> {

//			initThis();
		});
	}

	protected void _testIfThen(AdvClassBuilder classBody) {
		classBody.method("testIfThen").code(code -> {

			int iGT = cst(20);
			if_(isGreaterThan(iGT, 10)).then_(c -> {
				inc(iGT, -1);
			});

			int iGE = cst(20);
			if_(isGreaterEqual(iGE, 10)).then_(c -> {
				inc(iGE, -1);
			});

			int iEQ = cst(10);
			if_(isEqual(iEQ, 10)).then_(c -> {
				inc(iEQ, 1);
			});

			int iNE = cst(10);
			if_(isNotEqual(iNE, 10)).then_(c -> {
				inc(iNE, 1);
			});

			int iLE = cst(0);
			if_(isLessEqual(iLE, 10)).then_(c -> {
				inc(iLE, 1);
			});

			int iLT = cst(0);
			if_(isLessThan(iLT, 10)).then_(c -> {
				inc(iLT, 1);
			});

		});

	}

	protected void _testIfThenElse(AdvClassBuilder classBody) {
		classBody.method("testIfThenElse").code(code -> {

			int iGT = cst(20);
			if_(isGreaterThan(iGT, 10)).then_(c -> {
				inc(iGT, -1);
			}).else_(c -> {
				inc(iGT, 1);
			});

			int iGE = cst(20);
			if_(isGreaterEqual(iGE, 10)).then_(c -> {
				inc(iGE, -1);
			}).else_(c -> {
				inc(iGE, 1);
			});

			int iEQ = cst(10);
			if_(isEqual(iEQ, 10)).then_(c -> {
				inc(iEQ, 1);
			}).else_(c -> {
				inc(iEQ, 1);
			});

			int iNE = cst(10);
			if_(isNotEqual(iNE, 10)).then_(c -> {
				inc(iNE, 1);
			}).else_(c -> {
				inc(iNE, -1);
			});

			int iLE = cst(0);
			if_(isLessEqual(iLE, 10)).then_(c -> {
				inc(iLE, 1);
			}).else_(c -> {
				inc(iLE, 1);
			});

			int iLT = cst(0);
			if_(isLessThan(iLT, 10)).then_(c -> {
				inc(iLT, 1);
			}).else_(c -> {
				inc(iLT, 1);
			});
		});
	}

}
