package cn.sj1.tinyasm.core.sample.ClassBody;

public class MakeStringPropertyGetSet {
	//	private int intvalue;
	private String name;
	private String nameWithAnnotationClazz;
	private String nameWithAnnotationString;
	private String nameWithAnnotationClazzValue;
	private String nameWithAnnotationStringValue;
	private String nameWithAnnotationClazzNameValue;
	private String nameWithAnnotationStringNameValue;

	//	public int getIntvalue() {
	//		return intvalue;
	//	}
	//
	//	public void setIntvalue(int intvalue) {
	//		this.intvalue = intvalue;
	//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@TestAnnotation
	public String getNameWithAnnotationClazz() {
		return nameWithAnnotationClazz;
	}

	@TestAnnotation
	public void setNameWithAnnotationClazz(String nameWithAnnotationClazz) {
		this.nameWithAnnotationClazz = nameWithAnnotationClazz;
	}

	@TestAnnotation
	public String getNameWithAnnotationString() {
		return nameWithAnnotationString;
	}

	@TestAnnotation
	public void setNameWithAnnotationString(String nameWithAnnotationString) {
		this.nameWithAnnotationString = nameWithAnnotationString;
	}

	@TestAnnotation("@TestAnnotation>nameWithAnnotationClazzValue")
	public String getNameWithAnnotationClazzValue() {
		return nameWithAnnotationClazzValue;
	}

	@TestAnnotation("@TestAnnotation>nameWithAnnotationClazzValue")
	public void setNameWithAnnotationClazzValue(String nameWithAnnotationClazzValue) {
		this.nameWithAnnotationClazzValue = nameWithAnnotationClazzValue;
	}

	@TestAnnotation("@TestAnnotation>nameWithAnnotationStringValue")
	public String getNameWithAnnotationStringValue() {
		return nameWithAnnotationStringValue;
	}

	@TestAnnotation("@TestAnnotation>nameWithAnnotationStringValue")
	public void setNameWithAnnotationStringValue(String nameWithAnnotationStringValue) {
		this.nameWithAnnotationStringValue = nameWithAnnotationStringValue;
	}

	@TestAnnotation(name = "@TestAnnotation>nameWithAnnotationClazzNameValue")
	public String getNameWithAnnotationClazzNameValue() {
		return nameWithAnnotationClazzNameValue;
	}

	@TestAnnotation(name = "@TestAnnotation>nameWithAnnotationClazzNameValue")
	public void setNameWithAnnotationClazzNameValue(String nameWithAnnotationClazzNameValue) {
		this.nameWithAnnotationClazzNameValue = nameWithAnnotationClazzNameValue;
	}

	@TestAnnotation(name = "@TestAnnotation>nameWithAnnotationStringNameValue")
	public String getNameWithAnnotationStringNameValue() {
		return nameWithAnnotationStringNameValue;
	}

	@TestAnnotation(name = "@TestAnnotation>nameWithAnnotationStringNameValue")
	public void setNameWithAnnotationStringNameValue(String nameWithAnnotationStringNameValue) {
		this.nameWithAnnotationStringNameValue = nameWithAnnotationStringNameValue;
	}

}
