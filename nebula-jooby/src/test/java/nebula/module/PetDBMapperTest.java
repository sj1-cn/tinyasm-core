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

import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.data.ClassBody;

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

		cw.publicMethod(targetClazz, "map")
			.tHrow(SQLException.class)
			.parameter("rs", ResultSet.class)
			.parameter("ctx", StatementContext.class)
			.code(mv -> {
				mv.line();
				mv.NEW(targetClazz);
				mv.DUP();

				mv.LOAD("rs");
				mv.LOADConst("id");
				mv.INTERFACE(ResultSet.class, "getLong").param(String.class).reTurn(long.class).INVOKE();
				mv.STATIC(Long.class, "valueOf").param(long.class).reTurn(Long.class).INVOKE();

				mv.LOAD("rs");
				mv.LOADConst("name");
				mv.INTERFACE(ResultSet.class, "getString").param(String.class).reTurn(String.class).INVOKE();
				mv.LOAD("rs");
				mv.LOADConst("desciption");
				mv.INTERFACE(ResultSet.class, "getString").param(String.class).reTurn(String.class).INVOKE();

				mv.INVOKESPECIAL(targetClazz, null, "<init>", Long.class.getName(), String.class.getName(),
						String.class.getName());

				mv.RETURNTop();
			});

		cw.method(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, Object.class.getName(), "map")
			.tHrow(SQLException.class)
			.parameter("rs", ResultSet.class)
			.parameter("ctx", StatementContext.class)
			.code(mv -> {
				mv.line();
				mv.LOAD(0);
				mv.LOAD(1);
				mv.LOAD(2);
				mv.INVOKEVIRTUAL(cw.getName(), targetClazz, "map", ResultSet.class.getName(),
						StatementContext.class.getName());
				mv.RETURNTop();
			});

		String codeActual = toString(cw.end().toByteArray());
		String codeExpected = toString(clazz);
		assertEquals("Code", codeExpected, codeActual);
	}
}
