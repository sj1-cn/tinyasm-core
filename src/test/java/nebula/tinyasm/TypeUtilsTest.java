package nebula.tinyasm;

import static org.junit.Assert.*;

import org.junit.Test;
import org.objectweb.asm.Type;

import nebula.tinyasm.TypeUtils;

public class TypeUtilsTest {

//	@Test
//	public void testArrayOfClassOfQ() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testArrayOfClassOfQBoolean() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testArrayOfString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testArrayOfStringBoolean() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testArrayOfType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testArrayOfTypeBoolean() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testArrayTyoeCodeOf() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testBuildOpcodeSize() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCheckMathTypes() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnameOfClassOfQ() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnameOfGenericClazz() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnameOfString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnameOfType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnamesOfClassOfQArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnamesOfGenericClazzArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnamesOfListOfGenericClazz() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnamesOfStringArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClassnamesOfTypeArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testConcat() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFirstOfListOfT() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFirstOfTArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIn() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNamelOfGenericClazz() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNamelOfString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNamelOfStringArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNamelOfType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNamelOfTypeArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNameOfClassOfQ() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNameOfClassOfQArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNamesOfGenericClazzArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInternalNamesOfListOfGenericClazz() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIs() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testMathInnerUserType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRestOfListOfT() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRestOfTArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSignatureOfClassOfQClassOfQArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSignatureOfStringClassOfQArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSignatureOfStringStringArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSignatureOfTypeClassOfQArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSignatureOfTypeTypeArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testStringInnerUserType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToPropertyGetNameStringClassOfQ() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToPropertyGetNameStringString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToPropertyName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToPropertySetNameStringClassOfQ() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToPropertySetNameStringString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToSimpleName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypeOfClassOfQ() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypeOfClassOfQArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypeOfClassOfQBoolean() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypeOfFieldArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypeOfGenericClazz() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypeOfGenericClazzArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypeOfListOfField() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypesOf() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testTypeOfString() {
		assertEquals(Type.VOID_TYPE, TypeUtils.typeOf((Class<?>)null));

		assertEquals("I", TypeUtils.typeOf(int.class).getDescriptor());
	}
//
//	@Test
//	public void testTypeOfStringArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTypeOfStringBoolean() {
//		fail("Not yet implemented");
//	}

}
