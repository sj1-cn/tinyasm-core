package cn.sj1.tinyasm.core.advmagicbuilder.sourceconverter;

public class AdvJavaSourceCodeConverterASMifierTest {

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
