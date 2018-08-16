package nebula.tinyasm.sample.ClassBody;

@TestAnnotation(name = "name", secondName = "secondName")
public class ParameterAnnotationSample {
	@TestAnnotation
	private String annotation;
	@TestAnnotation("value")
	private String annotationWithDefaultValue;
	@TestAnnotation(value = "value", name = "name")
	private String annotationWithDefaultValueAndNamedValue;
	@TestAnnotation(name = "name", secondName = "secondName")
	private String annotationWithDefaultValueAndNamedValue2;

	@TestAnnotation
	private String annotationMethod() {
		return null;
	}

	@TestAnnotation("value")
	private String annotationWithDefaultValue() {
		return null;
	}

	@TestAnnotation(value = "value", name = "name")
	private String annotationWithDefaultValueAndNamedValue() {
		return null;
	}

	@TestAnnotation(name = "name", secondName = "secondName")
	private String annotationWithDefaultValueAndNamedValue2() {
		return null;
	}

	public void method(@TestAnnotation String annotation, @TestAnnotation("value") String annotationWithDefaultValue,
			@TestAnnotation(value = "value", name = "name") String annotationWithDefaultValueAndNamedValue,
			@TestAnnotation(name = "name", secondName = "secondName") String annotationWithDefaultValueAndNamedValue2) {
		annotation = "annotation";
		annotationWithDefaultValue = "annotationWithDefaultValue";
		annotationWithDefaultValueAndNamedValue = "annotationWithDefaultValueAndNamedValue";
		annotationWithDefaultValueAndNamedValue2 = "annotationWithDefaultValueAndNamedValue2";

	}
}
