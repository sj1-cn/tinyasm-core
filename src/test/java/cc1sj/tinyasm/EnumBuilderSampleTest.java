package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnumBuilderSampleTest extends TestBase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStatusBuilder() throws Exception {

		byte[] code = EnumBuilder.dump("com.nebula.dropwizard.core.Status", "STARTED", "FAILED", "COMPLETED");
		byte[] codeExpected = EnumBuilderSampleDump.dump();

		String strCodeExpected = toString(codeExpected);
		String strCode = toString(code);
		assertEquals("Code", strCodeExpected, strCode);
	}

//	@Test
//	public void printClass() throws IOException {
//		System.out.println(toString(ClassBuilderMath.class.getName()));
//	}

}
