package nebula.tinyasm;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import nebula.tinyasm.api.ClassBody;

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

		String strCode = toString(code);
		String strCodeExpected = toString(codeExpected);
		assertEquals("Code", strCodeExpected, strCode);
	}

	@Test
	public void testInit() throws Exception {

//		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), new PrintWriter(System.out));
		ClassVisitor visitor = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);

		ClassBody cw = ClassBuilder.make(visitor, "com.nebula.cqrs.core.asm.MyBankAccount");
		cw.annotation("com/nebula/cqrs/core/CqrsEntity");
		cw.annotation("org/axonframework/spring/stereotype/Aggregate");

		cw.fieldWithAnnotation("org/axonframework/commandhandling/model/AggregateIdentifier", "axonBankAccountId",
				String.class);
		cw.field("overdraftLimit", long.class);
		cw.field("balance", long.class);
		cw.privateMethod("<init>").code(mc -> {
			mc.line(34).init();
			mc.line(35).returnvoid();
		});
		cw.end();
		byte[] code = cw.toByteArray();
//		byte[] codeExpected = MyBankAccountDump.dump();

		String strCode = toString(code);
//		String strCodeExpected = toString(codeExpected);
//		assertEquals("Code", strCodeExpected, strCode);
	}

	@Test
	public void testInitSimpleMethod() throws Exception {

//		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), new PrintWriter(System.out));
		ClassVisitor visitor = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
		
		ClassBody cw = ClassBuilder.make(visitor,"com.nebula.cqrs.core.asm.MyBankAccount");
		cw.annotation("com/nebula/cqrs/core/CqrsEntity");
		cw.annotation("org/axonframework/spring/stereotype/Aggregate");

		cw.fieldWithAnnotation("org/axonframework/commandhandling/model/AggregateIdentifier", "axonBankAccountId",
				String.class);
		cw.field("overdraftLimit", long.class);
		cw.field("balance", long.class);
		cw.privateMethod("<init>").code(mc -> {
			mc.line(34).init();
			mc.line(35).returnvoid();
		});

		cw.privateMethod("onMoneySubtracted").parameter("amount", long.class).code(mc -> {
			mc.line(113).LOAD("this");
			mc.DUP();
			mc.GETFIELD("balance", Type.getType(long.class));
			mc.LOAD("amount");
			mc.SUB();
			mc.line(114).returnvoid();
		});

		cw.privateMethod("onMoneyAdded").parameter("amount", long.class).code(mc -> {
			mc.def("newbalance", long.class);
			mc.line(107).LOAD("this");
			mc.GETFIELD("balance", Type.getType(long.class));
			mc.LOAD("amount");
			mc.ADD();
			mc.STORE("newbalance");
			mc.line(108).LOAD("this");
			mc.LOAD("newbalance");
			mc.PUTFIELD("balance", Type.getType(long.class));
			mc.line(109).returnvoid();
		});
		cw.end();

		byte[] code = cw.end().toByteArray();
//		byte[] codeExpected = MyBankAccountDump.dump();

		String strCode = toString(code);
//		String strCodeExpected = toString(codeExpected);
//		assertEquals("Code", strCodeExpected, strCode);
	}

	@Test
	public void testInitDefineLocal() throws Exception {
//		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), new PrintWriter(System.out));

		ClassBody cw = ClassBuilder.make("com.nebula.cqrs.core.asm.MyBankAccount");
		cw.annotation("com/nebula/cqrs/core/CqrsEntity");
		cw.annotation("org/axonframework/spring/stereotype/Aggregate");

		cw.fieldWithAnnotation("org/axonframework/commandhandling/model/AggregateIdentifier", "axonBankAccountId",
				String.class);
		cw.privateMethod("<init>").code(mc -> {
			mc.line(34).init();
			mc.line(35).returnvoid();
		});

		cw.privateMethod("onMoneyAdded").parameter("amount", long.class).code(mc -> {
//			mc.def("newbalance", long.class);

			mc.line(107).LOAD("this");
			mc.GETFIELD("balance", Type.getType(long.class));
			mc.LOAD("amount");
			mc.ADD();
//			mc.store_op("newbalance");

//			mc.line(108).load("this");
//			mc.load("newbalance");
//			mc.putfield_op("balance",Type.getType(long.class));
//			mc.pop();
//			mc.line(109).returnvoid();
		});
		cw.end();

		byte[] code = cw.end().toByteArray();
//		byte[] codeExpected = MyBankAccountDump.dump();

//		String strCode = toString(code);
	}

//	@Test
//	public void testMyBankAccountCommandHandlerBuilder_2() throws Exception {
//		byte[] code = MyBankAccountCommandHandlerBuilder.dump();
//		byte[] codeExpected = MyBankAccountCommandHandlerDump.dump();
//
//		String strCode = toString(code);
//		String strCodeExpected = toString(codeExpected);
//		assertEquals("Code", strCodeExpected, strCode);
//	}

	@Test
	public void testStatusBuilder() throws Exception {
		Type type = Type.getObjectType("com/nebula/dropwizard/core/Status");

		byte[] code = EnumBuilder.dump(type, "STARTED", "FAILED", "COMPLETED");
		byte[] codeExpected = EnumBuilderSampleDump.dump();

		String strCode = toString(code);
		String strCodeExpected = toString(codeExpected);
		assertEquals("Code", strCodeExpected, strCode);
	}

	public static String toString(byte[] code) throws IOException {
		ClassReader cr = new ClassReader(code);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), pw);
		cr.accept(visitor, ClassReader.EXPAND_FRAMES);
		return sw.toString();
	}

	@Test
	public void printClass() throws IOException {
		System.out.println(toString(ClassBuilderMath.class.getName()));
	}

	public static String toString(String className) throws IOException {
		ClassReader cr = new ClassReader(className);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ClassVisitor visitor = new TraceClassVisitor(null, new ASMifier(), pw);
		cr.accept(visitor, ClassReader.EXPAND_FRAMES);
		return sw.toString();
	}
}
