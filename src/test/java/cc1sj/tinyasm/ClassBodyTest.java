package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import cc1sj.tinyasm.sample.ClassBody.ConstructerEmpty;
import cc1sj.tinyasm.sample.ClassBody.ConstructerWithAllFields;
import cc1sj.tinyasm.sample.ClassBody.MakeAllPropertyGetSet;
import cc1sj.tinyasm.sample.ClassBody.MakeIntPropertyGetSet;
import cc1sj.tinyasm.sample.ClassBody.MakePojo;
import cc1sj.tinyasm.sample.ClassBody.MakeReadOnlyPojo;
import cc1sj.tinyasm.sample.ClassBody.MakeStringPropertyGetSet;
import cc1sj.tinyasm.sample.ClassBody.TestAnnotation;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class ClassBodyTest  {

	@Test
	public void testGetName() throws IOException {
		String clazz = this.getClass().getPackage().getName() + ".sample.ClassBody.GetName";
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.constructerEmpty();

		assertEquals("getName", clazz, cw.getName());
	}

	@Test
	public void testConstructerEmpty() throws IOException {
		String clazz = ConstructerEmpty.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.constructerEmpty();
		cw.toStringWithAllFields();

		String codeActual = TinyAsmTestUtils.toString(cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testConstructerWithAllFields() throws IOException {
		String clazz = ConstructerWithAllFields.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.field("b", byte.class);
		cw.field("c", char.class);
		cw.field("s", short.class);
		cw.field("i", int.class);
		cw.field("l", long.class);
		cw.field("f", float.class);
		cw.field("d", double.class);
		cw.field("str", String.class);

		cw.constructerWithAllFields();
		cw.makeAllPropertyGet();

		String codeActual = TinyAsmTestUtils.toString(cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testClazzOfField() throws IOException {
		String clazz = MakeIntPropertyGetSet.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.constructerEmpty();
		cw.field("b", byte.class);
		cw.field("c", char.class);
		cw.field("s", short.class);
		cw.field("i", int.class);
		cw.field("l", long.class);
		cw.field("f", float.class);
		cw.field("d", double.class);
		cw.field("str", String.class);

		assertEquals("Class", byte.class.getName(), cw.clazzOfField("b").getType().getClassName());
		assertEquals("Class", char.class.getName(), cw.clazzOfField("c").getType().getClassName());
		assertEquals("Class", short.class.getName(), cw.clazzOfField("s").getType().getClassName());
		assertEquals("Class", int.class.getName(), cw.clazzOfField("i").getType().getClassName());
		assertEquals("Class", long.class.getName(), cw.clazzOfField("l").getType().getClassName());
		assertEquals("Class", float.class.getName(), cw.clazzOfField("f").getType().getClassName());
		assertEquals("Class", double.class.getName(), cw.clazzOfField("d").getType().getClassName());
		assertEquals("Class", String.class.getName(), cw.clazzOfField("str").getType().getClassName());

	}

	@Test
	public void tesMakeIntPropertyGetSet() throws IOException {
		String clazz = MakeIntPropertyGetSet.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.constructerEmpty();
		cw.field("name", int.class);
		cw.field("nameWithAnnotationClazz", int.class);
		cw.field("nameWithAnnotationString", int.class);
		cw.field("nameWithAnnotationClazzValue", int.class);
		cw.field("nameWithAnnotationStringValue", int.class);
		cw.field("nameWithAnnotationClazzNameValue", int.class);
		cw.field("nameWithAnnotationStringNameValue", int.class);

		cw.makePropertyGet("name");
		cw.makePropertySet("name");

		cw.makePropertyGet(TestAnnotation.class, "nameWithAnnotationClazz");
		cw.makePropertySet(TestAnnotation.class, "nameWithAnnotationClazz");

		cw.makePropertyGet(TestAnnotation.class.getName(), "nameWithAnnotationString");
		cw.makePropertySet(TestAnnotation.class.getName(), "nameWithAnnotationString");

		cw.makePropertyGet(TestAnnotation.class, "@TestAnnotation>nameWithAnnotationClazzValue",
				"nameWithAnnotationClazzValue");
		cw.makePropertySet(TestAnnotation.class, "@TestAnnotation>nameWithAnnotationClazzValue",
				"nameWithAnnotationClazzValue");

		cw.makePropertyGet(TestAnnotation.class.getName(), "@TestAnnotation>nameWithAnnotationStringValue",
				"nameWithAnnotationStringValue");
		cw.makePropertySet(TestAnnotation.class.getName(), "@TestAnnotation>nameWithAnnotationStringValue",
				"nameWithAnnotationStringValue");

		cw.makePropertyGet(TestAnnotation.class, "name", "@TestAnnotation>nameWithAnnotationClazzNameValue",
				"nameWithAnnotationClazzNameValue");
		cw.makePropertySet(TestAnnotation.class, "name", "@TestAnnotation>nameWithAnnotationClazzNameValue",
				"nameWithAnnotationClazzNameValue");

		cw.makePropertyGet(TestAnnotation.class.getName(), "name", "@TestAnnotation>nameWithAnnotationStringNameValue",
				"nameWithAnnotationStringNameValue");
		cw.makePropertySet(TestAnnotation.class.getName(), "name", "@TestAnnotation>nameWithAnnotationStringNameValue",
				"nameWithAnnotationStringNameValue");

		String codeActual = TinyAsmTestUtils.toString(cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void tesMakeStringPropertyGetSet() throws IOException {
		String clazz = MakeStringPropertyGetSet.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.constructerEmpty();
		cw.field("name", String.class);
		cw.field("nameWithAnnotationClazz", String.class);
		cw.field("nameWithAnnotationString", String.class);
		cw.field("nameWithAnnotationClazzValue", String.class);
		cw.field("nameWithAnnotationStringValue", String.class);
		cw.field("nameWithAnnotationClazzNameValue", String.class);
		cw.field("nameWithAnnotationStringNameValue", String.class);

		cw.makePropertyGet("name");
		cw.makePropertySet("name");

		cw.makePropertyGet(TestAnnotation.class, "nameWithAnnotationClazz");
		cw.makePropertySet(TestAnnotation.class, "nameWithAnnotationClazz");

		cw.makePropertyGet(TestAnnotation.class.getName(), "nameWithAnnotationString");
		cw.makePropertySet(TestAnnotation.class.getName(), "nameWithAnnotationString");

		cw.makePropertyGet(TestAnnotation.class, "@TestAnnotation>nameWithAnnotationClazzValue",
				"nameWithAnnotationClazzValue");
		cw.makePropertySet(TestAnnotation.class, "@TestAnnotation>nameWithAnnotationClazzValue",
				"nameWithAnnotationClazzValue");

		cw.makePropertyGet(TestAnnotation.class.getName(), "@TestAnnotation>nameWithAnnotationStringValue",
				"nameWithAnnotationStringValue");
		cw.makePropertySet(TestAnnotation.class.getName(), "@TestAnnotation>nameWithAnnotationStringValue",
				"nameWithAnnotationStringValue");

		cw.makePropertyGet(TestAnnotation.class, "name", "@TestAnnotation>nameWithAnnotationClazzNameValue",
				"nameWithAnnotationClazzNameValue");
		cw.makePropertySet(TestAnnotation.class, "name", "@TestAnnotation>nameWithAnnotationClazzNameValue",
				"nameWithAnnotationClazzNameValue");

		cw.makePropertyGet(TestAnnotation.class.getName(), "name", "@TestAnnotation>nameWithAnnotationStringNameValue",
				"nameWithAnnotationStringNameValue");
		cw.makePropertySet(TestAnnotation.class.getName(), "name", "@TestAnnotation>nameWithAnnotationStringNameValue",
				"nameWithAnnotationStringNameValue");

		String codeActual = TinyAsmTestUtils.toString(cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMakeAllPropertyGetSet() throws IOException {
		String clazz = MakeAllPropertyGetSet.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.constructerEmpty();
		cw.field("b", byte.class);
		cw.field("c", char.class);
		cw.field("s", short.class);
		cw.field("i", int.class);
		cw.field("l", long.class);
		cw.field("f", float.class);
		cw.field("d", double.class);
		cw.field("str", String.class);

		cw.makeAllPropertyGet();
		cw.makeAllPropertySet();

		String codeActual = TinyAsmTestUtils.toString(cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMakePojo() throws IOException {
		String clazz = MakePojo.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).annotation(TestAnnotation.class).body();
		cw.field("b", byte.class);
		cw.field("c", char.class);
		cw.field("s", short.class);
		cw.field("i", int.class);
		cw.field("l", long.class);
		cw.field("f", float.class);
		cw.field("d", double.class);
		cw.field("str", String.class);

		cw.makePojo();

		String codeActual = TinyAsmTestUtils.toString(cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void testMakeReadonlyPojo() throws IOException {
		String clazz = MakeReadOnlyPojo.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.field("b", byte.class);
		cw.field("c", char.class);
		cw.field("s", short.class);
		cw.field("i", int.class);
		cw.field("l", long.class);
		cw.field("f", float.class);
		cw.field("d", double.class);
		cw.field("str", String.class);

		cw.makeReadonlyPojo();

		String codeActual = TinyAsmTestUtils.toString(cw.end().toByteArray());
		String codeExpected = TinyAsmTestUtils.toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

}
