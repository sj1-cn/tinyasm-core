package nebula.tinyasm.help;

import static nebula.tinyasm.util.TypeUtils.*;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.api.ClassBody;

public class EnumBuilder implements Opcodes {

	public static byte[] dump(Type objectType, String... names) {
		return build(objectType, names).end().toByteArray();
	}

	public static ClassBody build(Type objectType, String... names) {
		Type superType = Type.getObjectType("java/lang/Enum");

		ClassBody cb = ClassBuilder
			.make(ACC_PUBLIC + ACC_FINAL + ACC_SUPER + ACC_ENUM, objectType, superType, new Type[] { objectType })
			.body();

		for (String name : names) {
			cb.mvField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC + ACC_ENUM, name, objectType);
		}
		cb.mvField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC + ACC_SYNTHETIC, "ENUM$VALUES", arrayOf(objectType, true));

		cb.staticMethod("<clinit>").code(mc -> {
			{
				mc.line(4);

				for (int i = 0; i < names.length; i++) {
					mc.NEW(objectType);
					mc.DUP();
					mc.LOADConst(names[i]);
					mc.LOADConstByte(i);
					mc.INVOKESPECIAL(objectType, Type.VOID_TYPE, "<init>", Type.getType(String.class), Type.INT_TYPE);
					mc.PUTSTATIC(objectType, names[i], objectType);
				}

				mc.line(3).LOADConstByte(names.length);
				mc.NEWARRAY(objectType);

				for (int i = 0; i < names.length; i++) {
					mc.DUP();
					mc.LOADConstByte(i);
					mc.GETSTATIC(objectType, names[i], objectType);
					mc.ARRAYSTORE();
				}
				mc.PUTSTATIC(objectType, "ENUM$VALUES", arrayOf(objectType));
				mc.RETURN();
			}
		});

		cb.privateMethod("<init>").parameter("name", String.class).parameter("value", int.class).code(mc -> {
			mc.line(3).LOADThis();
			mc.LOAD("name");
			mc.LOAD("value");
			mc.INVOKESPECIAL(Enum.class, "<init>", String.class, int.class);
			mc.RETURN();
		});
		Class<?>[] exceptionClasses = {};

		cb.mvStaticMethod(ACC_STATIC + ACC_PUBLIC, arrayOf(objectType, true), "values", namesOf(exceptionClasses)).code(mc -> {
			mc.def("vs", objectType, true);
			mc.def("length", int.class);
			mc.def("newvs", objectType, true);
			mc.line(1);
			mc.GETSTATIC(objectType, "ENUM$VALUES", arrayOf(objectType));
			mc.DUP();
			mc.STORE("vs");

			mc.LOADConstByte(0);
			mc.LOAD("vs");
			mc.ARRAYLENGTH();
			mc.DUP();
			mc.STORE("length");
			mc.NEWARRAY(objectType);
			mc.DUP();
			mc.STORE("newvs");

			mc.LOADConstByte(0);
			mc.LOAD("length");

			mc.INVOKESTATIC(System.class, "arraycopy", Object.class, int.class, Object.class, int.class, int.class);
			mc.RETURN("newvs");
		});
		Class<?>[] exceptionClasses1 = {};

		cb.mvStaticMethod(ACC_STATIC + ACC_PUBLIC, objectType, "valueOf", namesOf(exceptionClasses1)).parameter("name", String.class).code(mc -> {
			mc.line(1);
			mc.LOADConst(objectType);
			mc.LOAD("name");
			mc.INVOKESTATIC(Enum.class, Enum.class, "valueOf", Class.class, String.class);
			mc.CHECKCAST(objectType);
			mc.RETURNTop();
		});
		return cb;
	}
}
