package cc1sj.tinyasm;

public class TinyAsmBuilderContext {
	public MethodCode code;
	public Object topObject;
	public int _localsLast;

	public TinyAsmBuilderContext(MethodCode code) {
		this.code = code;
	}
}