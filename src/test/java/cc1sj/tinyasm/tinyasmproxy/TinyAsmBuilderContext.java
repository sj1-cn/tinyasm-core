package cc1sj.tinyasm.tinyasmproxy;

import cc1sj.tinyasm.MethodCode;

public class TinyAsmBuilderContext {
	public MethodCode code;
	public Object topObject;
	public int _localsLast;

	public TinyAsmBuilderContext(MethodCode code) {
		this.code = code;
	}
}