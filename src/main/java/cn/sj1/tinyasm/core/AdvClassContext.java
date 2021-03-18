package cn.sj1.tinyasm.core;

public class AdvClassContext {
	AdvClassBuilder classBuilder;

	public AdvClassContext(AdvClassBuilder classBuilder) {
		this.classBuilder = classBuilder;
	}
	public AdvClassBuilder getClassBuilder() {
		return classBuilder;
	}

}
