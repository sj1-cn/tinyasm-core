package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyBankAccountBuilderTest extends TestBase {

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

		String strCode = toString(code);
		String strCodeExpected = toString(codeExpected);
		assertEquals("Code", strCodeExpected, strCode);
	}

	@Test
	public void printClass() throws IOException {
		System.out.println(toString(ClassBuilderMath.class.getName()));
	}
}
