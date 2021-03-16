package cc1sj.tinyasm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.signature.SignatureReader;

import cc1sj.tinyasm.advasmproxy.simple.PojoClass;

public class ClassSignaturewwwwTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// <T:Ljava/lang/Object;>Ljava/lang/Object;
	// (TT;)V
	@Test
	public void test_typeParamenterClazzes() {
		String signature = "<T:Ljava/lang/Object;>Ljava/lang/Object;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();

		assertEquals("Ljava/lang/Object;", classSignaturewwww.superClazz.toString());
		assertEquals("T:Ljava/lang/Object;", classSignaturewwww.typeParamenterClazzes[0].toString());

		assertEquals(null, classSignaturewwww.returnClazz);
		assertEquals(0, classSignaturewwww.paramsClazzes.length);
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
//		assertEquals(null, classSignaturewwww.superClazz);
//		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);
	}

	@Test
	public void test_typesssParameterClass() {
		String signature = "Ljava/lang/Object;Lcc1sj/tinyasm/hero/helperclass/GenericInterface<Lcc1sj/tinyasm/hero/helperclass/PojoClassSample;Lcc1sj/tinyasm/hero/helperclass/PojoClassSample;>;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals(
				"Lcc1sj/tinyasm/hero/helperclass/GenericInterface<Lcc1sj/tinyasm/hero/helperclass/PojoClassSample;Lcc1sj/tinyasm/hero/helperclass/PojoClassSample;>;",
				classSignaturewwww.interfaceClazzes[0].toString());
		assertEquals("Ljava/lang/Object;", classSignaturewwww.superClazz.toString());

		assertEquals(null, classSignaturewwww.returnClazz);
		assertEquals(0, classSignaturewwww.paramsClazzes.length);
//		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
//		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);
	}

	@Test
	public void test_paramsClazzes() {
		String signature = "(TT;)V";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals("TT;", classSignaturewwww.paramsClazzes[0].toString());

		assertEquals("V", classSignaturewwww.returnClazz.toString());
//		assertEquals(0, classSignaturewwww.paramsClazzes.length);
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);
	}

	@Test
	public void test_paramsClazzes2() {
		String signature = "(TT;Ljava/lang/String;)[Ljava/lang/String;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals("[Ljava/lang/String;", classSignaturewwww.returnClazz.toString());
		assertEquals("TT;", classSignaturewwww.paramsClazzes[0].toString());
		assertEquals("Ljava/lang/String;", classSignaturewwww.paramsClazzes[1].toString());

//		assertEquals(null, classSignaturewwww.returnClazz);
//		assertEquals(0, classSignaturewwww.paramsClazzes.length);
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);
	}

	@Test
	public void test_return() {
		String signature = "()TT;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals("TT;", classSignaturewwww.returnClazz.toString());

//		assertEquals(null, classSignaturewwww.returnClazz);
		assertEquals(0, classSignaturewwww.paramsClazzes.length);
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);

	}

	@Test
	public void test_generic_method() {
		String signature = "<T:Ljava/lang/Object;>([TT;)[TT;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals("[TT;", classSignaturewwww.returnClazz.toString());

//		assertEquals(null, classSignaturewwww.returnClazz);
		assertEquals("[TT;", classSignaturewwww.paramsClazzes[0].toString());
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals("T:Ljava/lang/Object;", classSignaturewwww.typeParamenterClazzes[0].toString());
	}

	@Test
	public void test_basetype() {
		String signature = "(Ljava/util/Collection<*>;)Z";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals("Z", classSignaturewwww.returnClazz.toString());

//		assertEquals(null, classSignaturewwww.returnClazz);
		assertEquals("Ljava/util/Collection<*>;", classSignaturewwww.paramsClazzes[0].toString());
		assertEquals("Ljava/util/Collection<*>;", classSignaturewwww.paramsClazzes[0].signatureOf());
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);
	}
	// <T:Ljava/lang/Object;>([TT;)[TT;
//	

	@Test
	public void test_basetypessssss() {
		String signature = "(ILjava/util/Collection<+Lcc1sj/tinyasm/hero/helperclass/PojoClassSample;>;)Z";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals("Z", classSignaturewwww.returnClazz.toString());

//		assertEquals(null, classSignaturewwww.returnClazz);
		assertEquals("I", classSignaturewwww.paramsClazzes[0].toString());
		assertEquals("Ljava/util/Collection<+Lcc1sj/tinyasm/hero/helperclass/PojoClassSample;>;",
				classSignaturewwww.paramsClazzes[1].toString());
		assertTrue(classSignaturewwww.paramsClazzes[1] instanceof ClazzWithTypeArguments);
		assertTrue(((ClazzWithTypeArguments) classSignaturewwww.paramsClazzes[1]).getTypeArguments()[0] instanceof ClazzTypeArgument);
		assertTrue(((ClazzTypeArgument) ((ClazzWithTypeArguments) classSignaturewwww.paramsClazzes[1])
				.getTypeArguments()[0]).clazz instanceof ClazzSimple);
//		assertEquals("Ljava/util/Collection<*>;", classSignaturewwww.paramsClazzes[0].signatureOf());
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);
	}

	@Test
	public void test_basetypessssss_() {
		String signature = "(Ljava/util/function/Consumer<-TE;>;)V";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals("V", classSignaturewwww.returnClazz.toString());

		List<ClazzFormalTypeParameter> clazzFormalTypeParameters = new ArrayList<>();
		ClazzFormalTypeParameter f = new ClazzFormalTypeParameter("E", Clazz.of(Object.class));
		f.setActualTypeArgument(Clazz.of(PojoClass.class));
		clazzFormalTypeParameters.add(f);

//		assertEquals(null, classSignaturewwww.returnClazz);
		assertEquals("Ljava/util/function/Consumer;", classSignaturewwww.paramsClazzes[0].getDescriptor());
		assertTrue(classSignaturewwww.paramsClazzes[0] instanceof ClazzWithTypeArguments);
		assertEquals("Ljava/util/function/Consumer<-TE;>;", classSignaturewwww.paramsClazzes[0].signatureOf());
		assertEquals("Ljava/util/function/Consumer<-Lcc1sj/tinyasm/advasmproxy/simple/PojoClassSample;>;",
				classSignaturewwww.paramsClazzes[0].signatureOf(clazzFormalTypeParameters));
//		assertEquals("Ljava/util/Collection<*>;", classSignaturewwww.paramsClazzes[0].signatureOf());
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);
	}

	@Test
	public void test_basetypessddddssss_() {
		String signature = "()Ljava/util/Spliterator<TT;>;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		classSignaturewwww.finish();
		assertEquals("Ljava/util/Spliterator<TT;>;", classSignaturewwww.returnClazz.toString());
		assertTrue(classSignaturewwww.returnClazz instanceof ClazzWithTypeArguments);
		assertTrue(((ClazzWithTypeArguments) classSignaturewwww.returnClazz).getTypeArguments()[0] instanceof ClazzTypeArgument);
		assertTrue(((ClazzTypeArgument) ((ClazzWithTypeArguments) classSignaturewwww.returnClazz)
				.getTypeArguments()[0]).clazz instanceof ClazzVariable);

		List<ClazzFormalTypeParameter> clazzFormalTypeParameters = new ArrayList<>();
		ClazzFormalTypeParameter f = new ClazzFormalTypeParameter("E", Clazz.of(Object.class));
		f.setActualTypeArgument(Clazz.of(PojoClass.class));
		clazzFormalTypeParameters.add(f);

//		assertEquals(null, classSignaturewwww.returnClazz);
		assertEquals(0, classSignaturewwww.paramsClazzes.length);
		assertEquals(0, classSignaturewwww.interfaceClazzes.length);
		assertEquals(null, classSignaturewwww.superClazz);
		assertEquals(0, classSignaturewwww.typeParamenterClazzes.length);
	}

}
