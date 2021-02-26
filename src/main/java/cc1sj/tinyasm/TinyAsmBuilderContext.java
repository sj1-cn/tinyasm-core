package cc1sj.tinyasm;

public class TinyAsmBuilderContext {
	public MethodCode code;
	Object topObject;

	public TinyAsmBuilderContext(MethodCode code) {
		this.code = code;
	}
}