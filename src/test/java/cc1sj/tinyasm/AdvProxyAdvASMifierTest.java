package cc1sj.tinyasm;

import static cc1sj.tinyasm.util.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cc1sj.tinyasm.heroadv.AdvCodeConverter;
import cc1sj.tinyasm.heroadv.AdvSample;
import cc1sj.tinyasm.heroadv.AdvSampleBuilder;
import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class AdvProxyTinyASMifierTest {

	@Test
	public void test_AdvSample_Dump() throws Exception {
		Class<?> expectedClazz = AdvSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

			assertEquals("Code", codeExpected, codeActual);
		} finally {
			System.out.println(codeExpected);
		}
	}

	@Test
	public void test_AdvSampleBuilder_dump() throws Exception {
		Class<?> expectedClazz = AdvSample.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		try {
			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), AdvSampleBuilder.dump());

			assertEquals("Code", codeExpected, codeActual);
		} finally {

			System.out.println(codeExpected);

		}

	}

	@Test
	public void testSource() throws Exception {
		Class<?> expectedClazz = AdvSample.class;
		String source = TinyAsmTestUtils.readJavaSourceFile(expectedClazz);

		String targetClassName = AdvSample.class.getName() + "CodeBuilder";
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
				+ AdvCodeConverter.convertCode( source)
				+ "\t}\n"
				+ "}\n";
		//@formatter:on
		return d;
	}

//
//	@Test
//	public void test_HelloClassTinyAsmProxy_Dump1() throws Exception {
//		Class<?> expectedClazz = HelloClassTinyAsmProxy.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
//					TinyAsmProxyForClassAsmBuilder.dump(HelloClass.class, HelloClassTinyAsmProxy.class.getName()));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}
//
//	@Test
//	public void test_HelloClassTinyAsmProxy_Builder() throws Exception {
//		Class<?> expectedClazz = HelloClassTinyAsmProxy.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
//					TinyAsmProxyForClassAsmBuilder.dump2(HelloClass.class, HelloClassTinyAsmProxy.class.getName()));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}
//
//	@Test
//	public void test_HelloInterfaceTinyAsmProxy_Builder() throws Exception {
//		Class<?> expectedClazz = HelloInterfaceTinyAsmProxy.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
//					TinyAsmProxyForInterfaceAsmBuilder.dump2(HelloInterface.class, HelloInterfaceTinyAsmProxy.class.getName()));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}
//
//	@Test
//	public void test_HelloClassChildTinyAsmProxy_Builder() throws Exception {
//		Class<?> expectedClazz = HelloClassChildTinyAsmProxy.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(),
//					TinyAsmProxyForClassAsmBuilder.dump2(HelloClassChild.class, HelloClassChildTinyAsmProxy.class.getName()));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}
//
//	@Test
//	public void test_HelloInterfaceClassChild_Dump() throws Exception {
//		Class<?> expectedClazz = HelloInterfaceClassChild.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}
//
//	@Test
//	public void test_HelloInterfaceClassChildProxy_Dump() throws Exception {
//		Class<?> expectedClazz = HelloInterfaceClassChildProxy.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}
//
//	@Test
//	public void test_PageWithParametersSample_Dump() throws Exception {
//		Class<?> expectedClazz = PageWithParametersSample.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}
//
//	@Test
//	public void test_PageWithParametersSample_Builder() throws Exception {
//		Class<?> expectedClazz = PageWithParametersSample.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), PageWithParametersSampleTinyAsmBuilder.dump());
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}

//	@Test
//	public void test_HelloClassTinyAsmProxyFactory_dump() throws Exception {
//		Class<?> expectedClazz = HelloClassTinyAsmProxyFactory.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils.toString(dumpTinyAsm(expectedClazz));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}

//	@Test
//	public void test_HelloClassTinyAsmProxyFactory_Builder() throws Exception {
//		Class<?> expectedClazz = HelloClassTinyAsmProxyFactory.class;
//		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);
//
//		try {
//			String codeActual = TinyAsmTestUtils
//					.toString(TinyAsmProxyFactoryAsmBuilder.dump(HelloClassTinyAsmProxy.class.getName(), "Factory"));
//
//			assertEquals("Code", codeExpected, codeActual);
//		} finally {
//
//			System.out.println(codeExpected);
//
//		}
//
//	}

}
