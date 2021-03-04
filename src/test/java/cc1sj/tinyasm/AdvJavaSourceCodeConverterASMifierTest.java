package cc1sj.tinyasm;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


import cc1sj.tinyasm.heroadv.AdvJavaSourceCodeConverter;
import cc1sj.tinyasm.heroadv.AdvJavaSourceCodeConverterSample;
import cc1sj.tinyasm.heroadv.AdvJavaSourceCodeConverterSampleBuilder;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvJavaSourceCodeConverterASMifierTest {

	@Test
	public void test_AdvJavaSourceCodeConverterSample_Dump() throws Exception {
		Class<?> expectedClazz = AdvJavaSourceCodeConverterSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_AdvJavaSourceConverterSampleBuilder_dump() throws Exception {
		Class<?> expectedClazz = AdvJavaSourceCodeConverterSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvJavaSourceCodeConverterSampleBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void test_AdvJavaSourceConverterSample_ConvertTest() throws Exception {
		Class<?> expectedClazz = AdvJavaSourceCodeConverterSample.class;
		String source = TinyAsmTestUtils.readJavaSourceFile(expectedClazz);

		String targetClassName = AdvJavaSourceCodeConverterSample.class.getName() + "CodeBuilder";
		String target = convertFrom(targetClassName, source);
		TinyAsmTestUtils.writeJavaSourceFile(targetClassName, target);

		System.out.println(target);
	}

	private String convertFrom(String targetClassName, String source) {
		String targetClassSimpleName = targetClassName.substring(targetClassName.lastIndexOf('.') + 1, targetClassName.length());
		String targetPackageName = targetClassName.substring(0, targetClassName.lastIndexOf('.'));
		// @formatter:off
		String d = "package "+targetPackageName+";\n"
				+ "\n"
				+ "import static cc1sj.tinyasm.Adv.*;\n"
				+ "\n"
				+ "import cc1sj.tinyasm.AdvClassBuilder;\n"
				+ "\n"
				+ "public class "  +  targetClassSimpleName +  " {\n"
				+ "\n"
				+ "\tpublic static byte[] dump() {\n"
				+ AdvJavaSourceCodeConverter.convertCode( source)
				+ "\t}\n"
				+ "}\n";
		//@formatter:on
		return d;
	}
}
