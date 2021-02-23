package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cc1sj.tinyasm.util.TinyAsmTestUtils;

public class MyBankAccountBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyBankAccountBuilder() throws Exception {
		byte[] code = MyBankAccountBuilder.dump();
		byte[] codeExpected = MyBankAccountDump.dump();

		String strCode = TinyAsmTestUtils.toString(code);
		String strCodeExpected = TinyAsmTestUtils.toString(codeExpected);
		assertEquals("Code", strCodeExpected, strCode);
	}

//	@Test
//	public void printClass() throws IOException {
//		System.out.println(toString(ClassBuilderMath.class.getName()));
//	}
}
