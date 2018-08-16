package nebula.module;

import static org.junit.Assert.assertEquals;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.junit.Test;
import org.objectweb.asm.Label;

import nebula.tinyasm.ClassBody;
import nebula.tinyasm.ClassBuilder;

public class PetDBMapperTest extends TestBase {

	String clazz = PetDBMapper.class.getName();

//	@Test
//	public void testPrint() throws IOException {
//		System.out.println(RefineCode.refineCode(toString(clazz)));
//	}

	@Test
	public void testConstructerEmpty() throws IOException {
		String targetClazz = Pet.class.getName();

		ClassBody cw = ClassBuilder.make(clazz).imPlements(RowMapper.class, targetClazz).body();

		cw.constructerEmpty();

//		public Pet map(final ResultSet rs, final StatementContext ctx) throws SQLException {

		cw.publicMethod(targetClazz, "map", SQLException.class)
			.parameter("rs", ResultSet.class)
			.parameter("ctx", StatementContext.class)
			.code(mv -> {
				Label l0 = mv.codeNewLabel();
				mv.line();
				mv.codeAccessLabel(l0);
				mv.NEW(targetClazz);
				mv.DUP();

				mv.LOAD("rs");
				mv.LOADConst("id");
				mv.INVOKEINTERFACE(ResultSet.class, long.class, "getLong", String.class);
				mv.INVOKESTATIC(Long.class, Long.class, "valueOf", long.class);

				mv.LOAD("rs");
				mv.LOADConst("name");
				mv.INVOKEINTERFACE(ResultSet.class, String.class, "getString", String.class);
				mv.LOAD("rs");
				mv.LOADConst("desciption");
				mv.INVOKEINTERFACE(ResultSet.class, String.class, "getString", String.class);

				mv.INVOKESPECIAL(targetClazz, null, "<init>", Long.class.getName(), String.class.getName(),
						String.class.getName());

				mv.RETURNTop();
				Label l1 = mv.codeNewLabel();
				mv.codeAccessLabel(l1);
			});
//		(int access, Type returnType, String methodName,
//				String... exceptionClasses);
//		"(Ljava/sql/ResultSet;Lorg/jdbi/v3/core/statement/StatementContext;)Ljava/lang/Object;", null,
		cw.method(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, Object.class.getName(), "map", SQLException.class)
			.parameter("rs", ResultSet.class)
			.parameter("ctx", StatementContext.class)
			.code(mv -> {
				Label l0 = mv.codeNewLabel();
				mv.line();
				mv.codeAccessLabel(l0);
				mv.LOAD(0);
				mv.LOAD(1);
				mv.LOAD(2);
				mv.INVOKEVIRTUAL(cw.getName(), targetClazz, "map", ResultSet.class.getName(),
						StatementContext.class.getName());
				mv.RETURNTop();
				Label l1 = mv.codeNewLabel();
				mv.codeAccessLabel(l1);
			});

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
