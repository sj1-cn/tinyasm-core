package cc1sj.tinyasm;

import static cc1sj.tinyasm.TypeUtils.typeOf;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class EnumBuilder implements Opcodes {

	public static byte[] dump(String objectType, String... names) {
		return build(objectType, names).end().toByteArray();
	}

	public static ClassBody build(String className, String... names) {
		Clazz enumClazz = Clazz.of(className);

		ClassBody cb = ClassBuilder.make(className).eXtend(Clazz.of(Enum.class, className)).ACC_PUBLIC().ACC_FINAL().ACC_SUPER().ACC_ENUM().body();
		for (String name : names) {
			cb.staticField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC + ACC_ENUM, name, enumClazz);
		}
		cb.staticField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC + ACC_SYNTHETIC, "ENUM$VALUES", Clazz.of(className, true));

		cb.staticMethod(ACC_STATIC,"<clinit>").code(mc -> {
			{
				mc.LINE(4);

				for (int i = 0; i < names.length; i++) {
					mc.NEW(enumClazz);
					mc.DUP();
					mc.LOADConst(names[i]);
					mc.LOADConstByte(i);
					mc.INVOKESPECIAL(typeOf(className), Type.VOID_TYPE, "<init>", typeOf(String.class), Type.INT_TYPE);
					mc.PUTSTATIC(typeOf(className), names[i], typeOf(className));
				}

				mc.LINE(3);
				mc.LOADConstByte(names.length);
				mc.NEWARRAY(typeOf(className));

				for (int i = 0; i < names.length; i++) {
					mc.DUP();
					mc.LOADConstByte(i);
					mc.GETSTATIC(typeOf(className), names[i], typeOf(className));
					mc.ARRAYSTORE();
				}
				mc.PUT_THIS_STATIC("ENUM$VALUES");
				mc.RETURN();
			}
		});

		cb.privateMethod("<init>").parameter("name", String.class).parameter("value", int.class).code(mc -> {
			mc.LINE(3);
			mc.LOAD_THIS();
			mc.LOAD("name");
			mc.LOAD("value");
			mc.INVOKESPECIAL(Enum.class, "<init>", String.class, int.class);
			mc.RETURN();
		});
		cb.staticMethod("values").ACC_STATIC().ACC_PUBLIC().reTurn(className, true).code(mc -> {
			mc.define("vs", className, true);
			mc.define("length", int.class);
			mc.define("newvs", className, true);
			mc.LINE(1);
			mc.GET_THIS_STATIC("ENUM$VALUES");
			mc.DUP();
			mc.STORE("vs");

			mc.LOADConstByte(0);
			mc.LOAD("vs");
			mc.ARRAYLENGTH();
			mc.DUP();
			mc.STORE("length");
			mc.NEWARRAY(typeOf(className));
			mc.DUP();
			mc.STORE("newvs");

			mc.LOADConstByte(0);
			mc.LOAD("length");

			mc.INVOKESTATIC(System.class, "arraycopy", Object.class, int.class, Object.class, int.class, int.class);
			mc.RETURN("newvs");
		});

		cb.staticMethod("valueOf").ACC_STATIC().ACC_PUBLIC().reTurn(className).parameter("name", String.class).code(mc -> {
			mc.LINE(1);
			mc.LOADConst(typeOf(className));
			mc.LOAD("name");
			mc.INVOKESTATIC(Enum.class, Enum.class, "valueOf", Class.class, String.class);
			mc.CHECKCAST(className);
			mc.RETURNTop();
		});
		return cb;
	}
}
