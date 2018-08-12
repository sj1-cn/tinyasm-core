package nebula.tinyasm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import static nebula.tinyasm.api.TypeUtils.*;

import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.api.ClassBody;

public class EnumBuilder implements Opcodes {

	public static byte[] dump(Type objectType, String... names) {
		return build(objectType, names).toByteArray();
	}

	public static ClassBody build(Type objectType, String... names) {
		Type superType = Type.getObjectType("java/lang/Enum");

		ClassBody cb = ClassBuilder.make(ACC_PUBLIC + ACC_FINAL + ACC_SUPER + ACC_ENUM, objectType, superType,
				new Type[] { objectType });

		for (String name : names) {
			cb.field(ACC_PUBLIC + ACC_FINAL + ACC_STATIC + ACC_ENUM, name, objectType);
		}
		cb.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC + ACC_SYNTHETIC, "ENUM$VALUES", objectType, true);

		cb.staticMethod("<clinit>").code(mc -> {
			{
				mc.line(4);

				for (int i = 0; i < names.length; i++) {
					mc.NEW(objectType);
					mc.DUP();
					mc.loadConst(names[i]);
					mc.loadConstByte(i);
					mc.INVOKESPECIAL(objectType, Type.VOID_TYPE, "<init>", Type.getType(String.class), Type.INT_TYPE);
					mc.PUTSTATIC(objectType, names[i], objectType);
				}

				mc.line(3).loadConstByte(names.length);
				mc.NEWARRAY(objectType);

				for (int i = 0; i < names.length; i++) {
					mc.DUP();
					mc.loadConstByte(i);
					mc.GETSTATIC(objectType, names[i], objectType);
					mc.AASTORE();
				}
				mc.PUTSTATIC(objectType, "ENUM$VALUES", arrayOf(objectType));
				mc.ret();
			}
		});

		cb.privateMethod("<init>").parameter("name", String.class).parameter("value", int.class).code(mc -> {
			mc.line(3).loadThis();
			mc.load("name");
			mc.load("value");
			mc.INVOKESPECIAL(Enum.class, "<init>", String.class, int.class);
			mc.ret();
		});

		cb.publicStaticMethod(objectType, true, "values").code(mc -> {
			mc.def("vs", objectType, true);
			mc.def("length", int.class);
			mc.def("newvs", objectType, true);
			mc.line(1);
			mc.GETSTATIC(objectType, "ENUM$VALUES", arrayOf(objectType));
			mc.DUP();
			mc.STORE("vs");

			mc.loadConstByte(0);
			mc.load("vs");
			mc.ARRAYLENGTH();
			mc.DUP();
			mc.store("length");
			mc.NEWARRAY(objectType);
			mc.DUP();
			;
			mc.store("newvs");

			mc.loadConstByte(0);
			mc.load("length");

			mc.INVOKESTATIC(System.class, "arraycopy", Object.class, int.class, Object.class, int.class, int.class);
			mc.ret("newvs");
		});

		cb.publicStaticMethod(objectType, "valueOf").parameter("name", String.class).code(mc -> {
			mc.line(1);
			mc.loadConst(objectType);
			mc.load("name");
			mc.INVOKESTATIC(Enum.class, Enum.class, "valueOf", Class.class, String.class);
			mc.CHECKCAST(objectType);
			mc.retTop();
		});
		return cb;
	}
}
