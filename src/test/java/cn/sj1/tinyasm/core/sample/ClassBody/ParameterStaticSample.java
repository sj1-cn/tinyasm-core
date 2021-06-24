package cn.sj1.tinyasm.core.sample.ClassBody;

import java.util.List;

@TestAnnotation(name = "name", secondName = "secondName")
public class ParameterStaticSample {
	@TestAnnotation
	static private String annotation;
	@TestAnnotation("value")
	static protected String annotationWithDefaultValue;
	@TestAnnotation(value = "value", name = "name")
	static public String annotationWithDefaultValueAndNamedValue;
	@TestAnnotation(name = "name", secondName = "secondName")
	static String annotationWithDefaultValueAndNamedValue2;
	@TestAnnotation
	static private List<String> genericWithAnnotation;

	@SuppressWarnings("unused")
	static private List<String> genericWithoutAnnotation;

	@TestAnnotation
	static private String annotationMethod() {
		return null;
	}

	@TestAnnotation("value")
	static private String annotationWithDefaultValue() {
		return null;
	}

	@TestAnnotation(value = "value", name = "name")
	static private String annotationWithDefaultValueAndNamedValue() {
		return null;
	}

	@TestAnnotation(name = "name", secondName = "secondName")
	static private String annotationWithDefaultValueAndNamedValue2() {
		return null;
	}

	public static void method(@TestAnnotation String annotation,
			@TestAnnotation("value") String annotationWithDefaultValue,
			@TestAnnotation(value = "value", name = "name") String annotationWithDefaultValueAndNamedValue,
			@TestAnnotation(name = "name", secondName = "secondName") String annotationWithDefaultValueAndNamedValue2) {
		ParameterStaticSample.annotation = "annotation";
		ParameterStaticSample.annotationWithDefaultValue = "annotationWithDefaultValue";
		ParameterStaticSample.annotationWithDefaultValueAndNamedValue = "annotationWithDefaultValueAndNamedValue";
		ParameterStaticSample.annotationWithDefaultValueAndNamedValue2 = "annotationWithDefaultValueAndNamedValue2";

	}
}
