package cn.sj1.tinyasm;

public class AdvClassContext {
	AdvClassBuilder classBuilder;

	public AdvClassContext(AdvClassBuilder classBuilder) {
		this.classBuilder = classBuilder;
	}
	public AdvClassBuilder getClassBuilder() {
		return classBuilder;
	}

}
