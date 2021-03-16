package cc1sj.tinyasm.advmagicbuilder.sourceconverter;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvJavaSourceCodeConverterASMifierTest {

	@Test
	public void test_AdvJavaSourceCodeConverterSample_Dump() throws Exception {
		Class<?> expectedClazz = UsingSimplePojoClassSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);
	}

	@Test
	public void test_AdvJavaSourceConverterSampleBuilder_dump() throws Exception {
		Class<?> expectedClazz = UsingSimplePojoClassSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), UsingSimplePojoClassSampleBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_UsingSimplePojoClassSampleMagicBuilder_dump() throws Exception {
		Class<?> expectedClazz = UsingSimplePojoClassSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), UsingSimplePojoClassSampleMagicBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);

	}

	@Test
	public void test_SimpleSampleRefer2BuilderMagic_dump() throws Exception {
		Class<?> expectedClazz = UsingReferSimplePojoClassSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), UsingReferSimplePojoClassSampleMagicBuilder.dump());

		assertEquals("Code", codeExpected, codeActual);

	}
//
//	@Test
//	public void test_AdvJavaSourceConverterSample_ConvertTest() throws Exception {
//		Class<?> expectedClazz = UsingSimplePojoClassSample.class;
//		String source = TinyAsmTestUtils.readJavaSourceFile(expectedClazz);
//
//		String targetClassName = UsingSimplePojoClassSample.class.getName() + "CodeBuilder";
//		String target = convertFrom(targetClassName, source);
//		TinyAsmTestUtils.writeJavaSourceFile(targetClassName, target);
//	}
//
//	private String convertFrom(String targetClassName, String source) {
//		String targetClassSimpleName = targetClassName.substring(targetClassName.lastIndexOf('.') + 1, targetClassName.length());
//		String targetPackageName = targetClassName.substring(0, targetClassName.lastIndexOf('.'));
//		// @formatter:off
//		String d = "package "+targetPackageName+";\n"
//				+ "\n"
//				+ "import static cc1sj.tinyasm.Adv.*;\n"
//				+ "\n"
//				+ "import cc1sj.tinyasm.AdvClassBuilder;\n"
//				+ "\n"
//				+ "public class "  +  targetClassSimpleName +  " {\n"
//				+ "\n"
//				+ "\tpublic static byte[] dump() {\n"
//				+ AdvJavaSourceCodeConverter.convertCode( source)
//				+ "\t}\n"
//				+ "}\n";
//		//@formatter:on
//		return d;
//	}
}
