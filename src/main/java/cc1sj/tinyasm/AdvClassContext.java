package cc1sj.tinyasm;

public class AdvClassContext {
	AdvClassBuilder classBuilder;

	public AdvClassContext(AdvClassBuilder classBuilder) {
		this.classBuilder = classBuilder;
	}
	public AdvClassBuilder getClassBuilder() {
		return classBuilder;
	}

}
