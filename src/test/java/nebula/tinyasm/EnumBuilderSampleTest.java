package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nebula.tinyasm.help.EnumBuilder;

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

		String strCode = toString(code);
		String strCodeExpected = toString(codeExpected);
		assertEquals("Code", strCodeExpected, strCode);
	}

//	@Test
//	public void printClass() throws IOException {
//		System.out.println(toString(ClassBuilderMath.class.getName()));
//	}

}
