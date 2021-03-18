package cn.sj1.tinyasm.core.advasmproxy.subclassmethod;

import static cn.sj1.tinyasm.tools.TinyAsmTestUtils.dumpTinyAsm;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.sj1.tinyasm.tools.TinyAsmTestUtils;

public class AdvAsmProxyASMifierTest {


	@Test
	public void ClassB() throws Exception {
		Class<?> expectedClazz = ClassB.class;
		String codeExpected = TinyAsmTestUtils.toString(expectedClazz);

		String codeActual = TinyAsmTestUtils.toString(expectedClazz.getName(), dumpTinyAsm(expectedClazz));

		assertEquals("Code", codeExpected, codeActual);

	}


}
