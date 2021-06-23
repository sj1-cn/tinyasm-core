package cn.sj1.tinyasm.core.sample.ClassBody;

public class MakeIntPropertyGetSet {
	private int name;
	private int nameWithAnnotationClazz;
	private int nameWithAnnotationString;
	private int nameWithAnnotationClazzValue;
	private int nameWithAnnotationStringValue;
	private int nameWithAnnotationClazzNameValue;
	private int nameWithAnnotationStringNameValue;

//	public int getIntvalue() {
//		return intvalue;
//	}
//
//	public void setIntvalue(int intvalue) {
//		this.intvalue = intvalue;
//	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	@TestAnnotation
	public int getNameWithAnnotationClazz() {
		return nameWithAnnotationClazz;
	}

	@TestAnnotation
	public void setNameWithAnnotationClazz(int nameWithAnnotationClazz) {
		this.nameWithAnnotationClazz = nameWithAnnotationClazz;
	}

	@TestAnnotation
	public int getNameWithAnnotationString() {
		return nameWithAnnotationString;
	}

	@TestAnnotation
	public void setNameWithAnnotationString(int nameWithAnnotationString) {
		this.nameWithAnnotationString = nameWithAnnotationString;
	}

	@TestAnnotation("@TestAnnotation>nameWithAnnotationClazzValue")
	public int getNameWithAnnotationClazzValue() {
		return nameWithAnnotationClazzValue;
	}

	@TestAnnotation("@TestAnnotation>nameWithAnnotationClazzValue")
	public void setNameWithAnnotationClazzValue(int nameWithAnnotationClazzValue) {
		this.nameWithAnnotationClazzValue = nameWithAnnotationClazzValue;
	}

	@TestAnnotation("@TestAnnotation>nameWithAnnotationStringValue")
	public int getNameWithAnnotationStringValue() {
		return nameWithAnnotationStringValue;
	}

	@TestAnnotation("@TestAnnotation>nameWithAnnotationStringValue")
	public void setNameWithAnnotationStringValue(int nameWithAnnotationStringValue) {
		this.nameWithAnnotationStringValue = nameWithAnnotationStringValue;
	}

	@TestAnnotation(name="@TestAnnotation>nameWithAnnotationClazzNameValue")
	public int getNameWithAnnotationClazzNameValue() {
		return nameWithAnnotationClazzNameValue;
	}

	@TestAnnotation(name="@TestAnnotation>nameWithAnnotationClazzNameValue")
	public void setNameWithAnnotationClazzNameValue(int nameWithAnnotationClazzNameValue) {
		this.nameWithAnnotationClazzNameValue = nameWithAnnotationClazzNameValue;
	}

	@TestAnnotation(name="@TestAnnotation>nameWithAnnotationStringNameValue")
	public int getNameWithAnnotationStringNameValue() {
		return nameWithAnnotationStringNameValue;
	}

	@TestAnnotation(name="@TestAnnotation>nameWithAnnotationStringNameValue")
	public void setNameWithAnnotationStringNameValue(int nameWithAnnotationStringNameValue) {
		this.nameWithAnnotationStringNameValue = nameWithAnnotationStringNameValue;
	}


}
