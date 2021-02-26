package cc1sj.tinyasm;

class TinyAsmBuilderContext {
	MethodCode code;
	Object topObject;

	public TinyAsmBuilderContext(MethodCode code) {
		this.code = code;
	}
}