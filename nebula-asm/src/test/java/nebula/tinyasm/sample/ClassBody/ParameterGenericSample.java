package nebula.tinyasm.sample.ClassBody;

import java.util.ArrayList;
import java.util.List;

import nebula.tinyasm.data.Annotation;

@SuppressWarnings("serial")
public class ParameterGenericSample extends ArrayList<Annotation> implements List<Annotation> {

	@SuppressWarnings("unused")
	private List<String> annotation;

	@SuppressWarnings("unused")
	private List<String> annotationMethod() {
		return null;
	}

	public void method(List<String> annotation) {
		this.annotation = annotation;
	}

	@SuppressWarnings("unused")
	public void methodGenericVar(List<String> annotation) {
		@TestAnnotation List<String> thisannotation = annotation;
		this.annotation = annotation;
	}

}
