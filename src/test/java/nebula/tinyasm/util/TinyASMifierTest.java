package nebula.tinyasm.util;

import static nebula.tinyasm.util.RefineCode.excludeLineNumber;
import static nebula.tinyasm.util.RefineCode.skipToString;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.util.TraceClassVisitor;

import nebula.tinyasm.TestBase;

public class TinyASMifierTest extends TestBase {
//	public static String toString(byte[] code) {
//		try {
//			ClassReader cr = new ClassReader(code);
//			StringWriter sw = new StringWriter();
//			PrintWriter pw = new PrintWriter(sw);
//			ClassVisitor visitor = new TraceClassVisitor(null, new TinyASMifier(), pw);
//			cr.accept(visitor, ClassReader.EXPAND_FRAMES);
//			return skipToString(excludeLineNumber(sw.toString()));
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	private static String tinyasmToString(Class<?> clazz) {
		try {
			ClassReader cr = new ClassReader(clazz.getName());
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ClassVisitor visitor = new TraceClassVisitor(null, new TinyASMifier(), pw);
			cr.accept(visitor, ClassReader.EXPAND_FRAMES);
			return skipToString(excludeLineNumber(sw.toString()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void testCreate() {
		// TODO Auto-generated method stub

	}
	
//	@Test
//	public void testCreate() throws Exception {
//		String clazz = MethodCodeASMMathSample.class.getName();
//
//		FileOutputStream os = new FileOutputStream(new File("src/test/java", clazz.replace('.', '/') + "TinyAsmDump.java"));
//		String str = tinyasmToString(MethodCodeASMMathSample.class);
//		os.write(str.getBytes("utf-8"));
//		os.close();
//		
//		System.out.println(str);
//	}
//	@Test
//	public void testMethodCodeASMLogicSample() throws Exception {
//		String clazz = MethodCodeASMLogicSample.class.getName();
//
//		FileOutputStream os = new FileOutputStream(new File("src/test/java", clazz.replace('.', '/') + "TinyAsmDump.java"));
//		String str = tinyasmToString(MethodCodeASMLogicSample.class);
//		os.write(str.getBytes("utf-8"));
//		os.close();
//		
//		System.out.println(str);
//	}
//	@Test
//	public void testCompare() throws Exception {
//		String clazz = MethodCodeASMLogicSample.class.getName();
//
//
//		String codeActual = toString(MethodCodeASMLogicSampleTinyAsmDump.dump());
//		String codeExpected = toString(clazz);
//		assertEquals("Code", codeExpected, codeActual);
//	}

	
	
	
}
