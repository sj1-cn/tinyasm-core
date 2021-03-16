package cc1sj.tinyasm.ana.generatedsources.BankAccount.api;

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

		String strCode = TinyAsmTestUtils.toString("com.nebula.cqrs.core.asm.MyBankAccount",code);
		String strCodeExpected = TinyAsmTestUtils.toString("com.nebula.cqrs.core.asm.MyBankAccount",codeExpected);
		assertEquals("Code", strCodeExpected, strCode);
	}

}
