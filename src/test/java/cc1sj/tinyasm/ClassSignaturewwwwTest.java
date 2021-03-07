package cc1sj.tinyasm;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.signature.SignatureReader;
import org.objectweb.asm.signature.SignatureVisitor;

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
	public void test_typeParameterClass() {
		String signature = "<T:Ljava/lang/Object;>Ljava/lang/Object;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		assertEquals("", classSignaturewwww.returnClass.toString());
		assertEquals("[]", classSignaturewwww.paramsClass.toString());
		assertEquals("[]", classSignaturewwww.interfacesClass.toString());
		assertEquals("Ljava/lang/Object;", classSignaturewwww.superClass.toString());
		assertEquals("[T:Ljava/lang/Object;]", classSignaturewwww.typeParameterClass.toString());
	}

	@Test
	public void test_paramsClass() {
		String signature = "(TT;)V";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		assertEquals("", classSignaturewwww.returnClass.toString());
		assertEquals("[TT;]", classSignaturewwww.paramsClass.toString());
		assertEquals("[]", classSignaturewwww.interfacesClass.toString());
		assertEquals("", classSignaturewwww.superClass.toString());
		assertEquals("[]", classSignaturewwww.typeParameterClass.toString());
	}

	@Test
	public void test_paramsClass2() {
		String signature = "(TT;Ljava/lang/String;)[Ljava/lang/String;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		assertEquals("[Ljava/lang/String;", classSignaturewwww.returnClass.get().toString());
		assertEquals("[TT;, Ljava/lang/String;]", classSignaturewwww.paramsClass.toString());
		assertEquals("[]", classSignaturewwww.interfacesClass.toString());
		assertEquals("", classSignaturewwww.superClass.toString());
		assertEquals("[]", classSignaturewwww.typeParameterClass.toString());

	}

	@Test
	public void test_return() {
		String signature = "()TT;";
		ClassSignaturewwww classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
		SignatureReader sr = new SignatureReader(signature);
		sr.accept(classSignaturewwww);
		assertEquals("TT;", classSignaturewwww.returnClass.get().toString());
		assertEquals("[]", classSignaturewwww.paramsClass.toString());
		assertEquals("[]", classSignaturewwww.interfacesClass.toString());
		assertEquals("", classSignaturewwww.superClass.toString());
		assertEquals("[]", classSignaturewwww.typeParameterClass.toString());

	}
	
}
