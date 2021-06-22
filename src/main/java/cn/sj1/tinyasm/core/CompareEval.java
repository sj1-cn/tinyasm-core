package cn.sj1.tinyasm.core;

import org.objectweb.asm.Label;

public interface CompareEval {

	void prepareData(MethodCodeASM code) throws Exception;

	void gotoWhenSucceed(MethodCodeASM code, Label label) throws Exception;

	void gotoWhenFail(MethodCodeASM code, Label label) throws Exception;
}
