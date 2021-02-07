package nebula.tinyasm.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.objectweb.asm.Type;
import static nebula.tinyasm.util.Types.*;

public class TypeTest {
	@Test
	public void testName() throws Exception {
		Type type;
		type = Type.getType(int.class);
		assertEquals("I", type.getInternalName());
		assertEquals("int", type.getClassName());
		assertEquals("I", type.getDescriptor());


		type = Type.getType(int[].class);
		assertEquals("[I", type.getInternalName());
		assertEquals("int[]", type.getClassName());
		assertEquals("[I", type.getDescriptor());
		
		type = Type.getType(String.class);
		assertEquals("java/lang/String", type.getInternalName());
		assertEquals("java.lang.String", type.getClassName());
		assertEquals("Ljava/lang/String;", type.getDescriptor());
		
		type = Type.getType(String[].class);
		assertEquals("[Ljava/lang/String;", type.getInternalName());
		assertEquals("java.lang.String[]", type.getClassName());
		assertEquals("[Ljava/lang/String;", type.getDescriptor());

		assertEquals("I", typeOf(int.class).getInternalName());
		assertEquals("int", typeOf(int.class).getClassName());
		assertEquals("I", typeOf(int.class).getDescriptor());
		
		assertEquals("[I", typeOf(int.class,true).getInternalName());
		assertEquals("int[]", typeOf(int.class,true).getClassName());
		assertEquals("[I", typeOf(int.class,true).getDescriptor());
	}
}
