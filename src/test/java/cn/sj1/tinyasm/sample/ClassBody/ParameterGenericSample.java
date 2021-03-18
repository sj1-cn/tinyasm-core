package cn.sj1.tinyasm.sample.ClassBody;

import java.util.ArrayList;
import java.util.List;

import cn.sj1.tinyasm.Annotation;

@SuppressWarnings("serial")
public class ParameterGenericSample extends ArrayList<Annotation> implements TestInerface, List<Annotation> {

	@SuppressWarnings("unused")
	private List<String> annotation;

	@SuppressWarnings("unused")
	private List<String> annotationMethod() {
		return null;
	}

	void method(List<String> annotation) {
		this.annotation = annotation;
	}

	@SuppressWarnings("unused")
	void methodGenericVar(List<String> annotation) {
		@TestAnnotation
		List<String> thisannotation = annotation;
		this.annotation = annotation;
	}

}
