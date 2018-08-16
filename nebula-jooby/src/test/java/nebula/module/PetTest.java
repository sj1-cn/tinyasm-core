package nebula.module;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.data.ClassBody;

public class PetTest extends TestBase {

//	@Test
//	public void testPrint() throws IOException {
//		String clazz = Pet.class.getName();
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

	@Test
	public void testConstructerEmpty() throws IOException {
		String clazz = Pet.class.getName();
		ClassBody cw = ClassBuilder.make(clazz).body();
		cw.field("id", Long.class);
		cw.field("name", String.class);
		cw.field("desciption", String.class);
		cw.makeReadonlyPojo();

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}

//	@Test
//	public void testConstructerWithAllFields() throws IOException {
//		String clazz = ConstructerWithAllFields.class.getName();
//		ClassBody cw = ClassBuilder.make(clazz).body();
//		cw.field("b", byte.class);
//		cw.field("c", char.class);
//		cw.field("s", short.class);
//		cw.field("i", int.class);
//		cw.field("l", long.class);
//		cw.field("f", float.class);
//		cw.field("d", double.class);
//		cw.field("str", String.class);
//
//		cw.constructerWithAllFields();
//		cw.makeAllPropertyGet();
//
//		String codeActual = toString(cw.end().toByteArray());
//		String codeExpected = toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}
}
