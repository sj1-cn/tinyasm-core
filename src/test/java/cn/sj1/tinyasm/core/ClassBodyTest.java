package cn.sj1.tinyasm.core;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import cn.sj1.tinyasm.core.sample.ClassBody.MakeIntPropertyGetSet;

public class ClassBodyTest {

	@Test
	public void testGetName() throws IOException {
		String clazz = this.getClass().getPackage().getName() + ".sample.ClassBody.GetName";
		ClassBody cw = ClassBuilder.class_(clazz).body();
		cw.constructerEmpty();

		assertEquals("getName", clazz, cw.getName());
	}

//	@Test
//	public void testConstructerEmpty() throws IOException {
//		String clazz = ConstructerEmpty.class.getName();
//		ClassBody cw = ClassBuilder.class_(clazz).body();
//		cw.constructerEmpty();
//		cw.toStringWithAllFields();
//
//		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
//		String codeExpected = TinyAsmTestUtils.toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}
//
//	@Test
//	public void testConstructerWithAllFields() throws IOException {
//		String clazz = ConstructerWithAllFields.class.getName();
//		ClassBody cw = ClassBuilder.class_(clazz).body();
//		cw.private_().field("b", byte.class);
//		cw.private_().field("c", char.class);
//		cw.private_().field("s", short.class);
//		cw.private_().field("i", int.class);
//		cw.private_().field("l", long.class);
//		cw.private_().field("f", float.class);
//		cw.private_().field("d", double.class);
//		cw.private_().field("str", String.class);
//
//		cw.constructerWithAllFields();
//		cw.makeAllPropertyGet();
//
//		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
//		String codeExpected = TinyAsmTestUtils.toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}

	@Test
	public void testClazzOfField() throws IOException {
		String clazz = MakeIntPropertyGetSet.class.getName();
		ClassBody cw = ClassBuilder.class_(clazz).body();
		cw.constructerEmpty();
		cw.private_().field("b", byte.class);
		cw.private_().field("c", char.class);
		cw.private_().field("s", short.class);
		cw.private_().field("i", int.class);
		cw.private_().field("l", long.class);
		cw.private_().field("f", float.class);
		cw.private_().field("d", double.class);
		cw.private_().field("str", String.class);

		assertEquals("Class", byte.class.getName(), cw.clazzOfField("b").getType().getClassName());
		assertEquals("Class", char.class.getName(), cw.clazzOfField("c").getType().getClassName());
		assertEquals("Class", short.class.getName(), cw.clazzOfField("s").getType().getClassName());
		assertEquals("Class", int.class.getName(), cw.clazzOfField("i").getType().getClassName());
		assertEquals("Class", long.class.getName(), cw.clazzOfField("l").getType().getClassName());
		assertEquals("Class", float.class.getName(), cw.clazzOfField("f").getType().getClassName());
		assertEquals("Class", double.class.getName(), cw.clazzOfField("d").getType().getClassName());
		assertEquals("Class", String.class.getName(), cw.clazzOfField("str").getType().getClassName());

	}
//
//	@Test
//	public void tesMakeIntPropertyGetSet() throws IOException {
//		String clazz = MakeIntPropertyGetSet.class.getName();
//		ClassBody cw = ClassBuilder.class_(clazz).body();
//		cw.constructerEmpty();
//		cw.private_().field("name", int.class);
//		cw.private_().field("nameWithAnnotationClazz", int.class);
//		cw.private_().field("nameWithAnnotationString", int.class);
//		cw.private_().field("nameWithAnnotationClazzValue", int.class);
//		cw.private_().field("nameWithAnnotationStringValue", int.class);
//		cw.private_().field("nameWithAnnotationClazzNameValue", int.class);
//		cw.private_().field("nameWithAnnotationStringNameValue", int.class);
//
//		cw.makePropertyGet("name");
//		cw.makePropertySet("name");
//
//		cw.makePropertyGet(TestAnnotation.class, "nameWithAnnotationClazz");
//		cw.makePropertySet(TestAnnotation.class, "nameWithAnnotationClazz");
//
//		cw.makePropertyGet(TestAnnotation.class.getName(), "nameWithAnnotationString");
//		cw.makePropertySet(TestAnnotation.class.getName(), "nameWithAnnotationString");
//
//		cw.makePropertyGet(TestAnnotation.class, "@TestAnnotation>nameWithAnnotationClazzValue", "nameWithAnnotationClazzValue");
//		cw.makePropertySet(TestAnnotation.class, "@TestAnnotation>nameWithAnnotationClazzValue", "nameWithAnnotationClazzValue");
//
//		cw.makePropertyGet(TestAnnotation.class.getName(), "@TestAnnotation>nameWithAnnotationStringValue",
//				"nameWithAnnotationStringValue");
//		cw.makePropertySet(TestAnnotation.class.getName(), "@TestAnnotation>nameWithAnnotationStringValue",
//				"nameWithAnnotationStringValue");
//
//		cw.makePropertyGet(TestAnnotation.class, "name", "@TestAnnotation>nameWithAnnotationClazzNameValue",
//				"nameWithAnnotationClazzNameValue");
//		cw.makePropertySet(TestAnnotation.class, "name", "@TestAnnotation>nameWithAnnotationClazzNameValue",
//				"nameWithAnnotationClazzNameValue");
//
//		cw.makePropertyGet(TestAnnotation.class.getName(), "name", "@TestAnnotation>nameWithAnnotationStringNameValue",
//				"nameWithAnnotationStringNameValue");
//		cw.makePropertySet(TestAnnotation.class.getName(), "name", "@TestAnnotation>nameWithAnnotationStringNameValue",
//				"nameWithAnnotationStringNameValue");
//
//		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
//		String codeExpected = TinyAsmTestUtils.toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}
//
//	@Test
//	public void tesMakeStringPropertyGetSet() throws IOException {
//		String clazz = MakeStringPropertyGetSet.class.getName();
//		ClassBody cw = ClassBuilder.class_(clazz).body();
//		cw.constructerEmpty();
//		cw.private_().field("name", String.class);
//		cw.private_().field("nameWithAnnotationClazz", String.class);
//		cw.private_().field("nameWithAnnotationString", String.class);
//		cw.private_().field("nameWithAnnotationClazzValue", String.class);
//		cw.private_().field("nameWithAnnotationStringValue", String.class);
//		cw.private_().field("nameWithAnnotationClazzNameValue", String.class);
//		cw.private_().field("nameWithAnnotationStringNameValue", String.class);
//
//		cw.makePropertyGet("name");
//		cw.makePropertySet("name");
//
//		cw.makePropertyGet(TestAnnotation.class, "nameWithAnnotationClazz");
//		cw.makePropertySet(TestAnnotation.class, "nameWithAnnotationClazz");
//
//		cw.makePropertyGet(TestAnnotation.class.getName(), "nameWithAnnotationString");
//		cw.makePropertySet(TestAnnotation.class.getName(), "nameWithAnnotationString");
//
//		cw.makePropertyGet(TestAnnotation.class, "@TestAnnotation>nameWithAnnotationClazzValue", "nameWithAnnotationClazzValue");
//		cw.makePropertySet(TestAnnotation.class, "@TestAnnotation>nameWithAnnotationClazzValue", "nameWithAnnotationClazzValue");
//
//		cw.makePropertyGet(TestAnnotation.class.getName(), "@TestAnnotation>nameWithAnnotationStringValue",
//				"nameWithAnnotationStringValue");
//		cw.makePropertySet(TestAnnotation.class.getName(), "@TestAnnotation>nameWithAnnotationStringValue",
//				"nameWithAnnotationStringValue");
//
//		cw.makePropertyGet(TestAnnotation.class, "name", "@TestAnnotation>nameWithAnnotationClazzNameValue",
//				"nameWithAnnotationClazzNameValue");
//		cw.makePropertySet(TestAnnotation.class, "name", "@TestAnnotation>nameWithAnnotationClazzNameValue",
//				"nameWithAnnotationClazzNameValue");
//
//		cw.makePropertyGet(TestAnnotation.class.getName(), "name", "@TestAnnotation>nameWithAnnotationStringNameValue",
//				"nameWithAnnotationStringNameValue");
//		cw.makePropertySet(TestAnnotation.class.getName(), "name", "@TestAnnotation>nameWithAnnotationStringNameValue",
//				"nameWithAnnotationStringNameValue");
//
//		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
//		String codeExpected = TinyAsmTestUtils.toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}
//
//	@Test
//	public void testMakeAllPropertyGetSet() throws IOException {
//		String clazz = MakeAllPropertyGetSet.class.getName();
//		ClassBody cw = ClassBuilder.class_(clazz).body();
//		cw.constructerEmpty();
//		cw.private_().field("b", byte.class);
//		cw.private_().field("c", char.class);
//		cw.private_().field("s", short.class);
//		cw.private_().field("i", int.class);
//		cw.private_().field("l", long.class);
//		cw.private_().field("f", float.class);
//		cw.private_().field("d", double.class);
//		cw.private_().field("str", String.class);
//
//		cw.makeAllPropertyGet();
//		cw.makeAllPropertySet();
//
//		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
//		String codeExpected = TinyAsmTestUtils.toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}
//
//	@Test
//	public void testMakePojo() throws IOException {
//		String clazz = MakePojo.class.getName();
//		ClassBody cw = ClassBuilder.class_(clazz).annotation(TestAnnotation.class).body();
//		cw.private_().field("b", byte.class);
//		cw.private_().field("c", char.class);
//		cw.private_().field("s", short.class);
//		cw.private_().field("i", int.class);
//		cw.private_().field("l", long.class);
//		cw.private_().field("f", float.class);
//		cw.private_().field("d", double.class);
//		cw.private_().field("str", String.class);
//
//		cw.makePojo();
//
//		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
//		String codeExpected = TinyAsmTestUtils.toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}
//
//	@Test
//	public void testMakeReadonlyPojo() throws IOException {
//		String clazz = MakeReadOnlyPojo.class.getName();
//		ClassBody cw = ClassBuilder.class_(clazz).body();
//		cw.private_().field("b", byte.class);
//		cw.private_().field("c", char.class);
//		cw.private_().field("s", short.class);
//		cw.private_().field("i", int.class);
//		cw.private_().field("l", long.class);
//		cw.private_().field("f", float.class);
//		cw.private_().field("d", double.class);
//		cw.private_().field("str", String.class);
//
//		cw.makeReadonlyPojo();
//
//		String codeActual = TinyAsmTestUtils.toString(clazz, cw.end().toByteArray());
//		String codeExpected = TinyAsmTestUtils.toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}

}
