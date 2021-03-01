package cc1sj.tinyasm.heroadv;

import org.objectweb.asm.Label;

import cc1sj.tinyasm.MethodCode;

public interface CompareEval {
	void gotoWhenSucceed(MethodCode code, Label label) throws Exception;

	void gotoWhenFail(MethodCode code, Label label) throws Exception;
}
