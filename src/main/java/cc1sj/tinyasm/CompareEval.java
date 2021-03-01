package cc1sj.tinyasm;

import org.objectweb.asm.Label;

public interface CompareEval {
	void gotoWhenSucceed(MethodCode code, Label label) throws Exception;

	void gotoWhenFail(MethodCode code, Label label) throws Exception;
}
