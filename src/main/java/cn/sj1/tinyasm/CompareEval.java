package cn.sj1.tinyasm;

import org.objectweb.asm.Label;

public interface CompareEval {

	void prepareData(MethodCode code) throws Exception;

	void gotoWhenSucceed(MethodCode code, Label label) throws Exception;

	void gotoWhenFail(MethodCode code, Label label) throws Exception;
}
