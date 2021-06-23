package cn.sj1.tinyasm.core;

import static cn.sj1.tinyasm.core.TypeUtils.typeOf;

import org.objectweb.asm.Opcodes;

public class EnumBuilder implements Opcodes {

	public static byte[] dump(String objectType, String... names) {
		return build(objectType, names).end().toByteArray();
	}

	public static ClassBody build(String className, String... names) {
		Clazz enumClazz = Clazz.of(className);

		ClassBody cb = ClassBuilder.class_(className).extends_(Clazz.of(Enum.class, className)).public_()
				.access(ACC_FINAL | ACC_SUPER | ACC_ENUM).body();
		for (String name : names) {
			cb.staticField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC + ACC_ENUM, name, enumClazz);
		}
		cb.staticField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC + ACC_SYNTHETIC, "ENUM$VALUES", Clazz.of(className, true));

		cb.staticMethod(ACC_STATIC, "<clinit>").code(mc -> {
			{
				mc.LINE(4);

				for (int i = 0; i < names.length; i++) {
					mc.NEW(enumClazz);
					mc.DUP();
					mc.LOADConst(names[i]);
					mc.LOADConst(i);
					mc.SPECIAL(className, "<init>").parameter(String.class, int.class).INVOKE();
					mc.PUTSTATIC(typeOf(className), names[i], typeOf(className));
				}

				mc.LINE(3);
				mc.LOADConst(names.length);
				mc.NEWARRAY(typeOf(className));

				for (int i = 0; i < names.length; i++) {
					mc.DUP();
					mc.LOADConst(i);
					mc.GETSTATIC(typeOf(className), names[i], typeOf(className));
					mc.ARRAYSTORE();
				}
				mc.PUT_THIS_STATIC("ENUM$VALUES");
				mc.RETURN();
			}
		});

		cb.private_().method("<init>").parameter("name", String.class).parameter("value", int.class).code(mc -> {
			mc.LINE(3);
			mc.LOAD_THIS();
			mc.LOAD("name");
			mc.LOAD("value");
			mc.SPECIAL(Enum.class, "<init>").parameter(String.class, int.class).INVOKE();
			mc.RETURN();
		});
		cb.publicStaticMethod("values").return_(className, true).code(mc -> {
			mc.define("vs", className, true);
			mc.define("length", int.class);
			mc.define("newvs", className, true);
			mc.LINE(1);
			mc.GET_THIS_STATIC("ENUM$VALUES");
			mc.DUP();
			mc.STORE("vs");

			mc.LOADConst(0);
			mc.LOAD("vs");
			mc.ARRAYLENGTH();
			mc.DUP();
			mc.STORE("length");
			mc.NEWARRAY(typeOf(className));
			mc.DUP();
			mc.STORE("newvs");

			mc.LOADConst(0);
			mc.LOAD("length");
			mc.STATIC(System.class, "arraycopy").parameter(Object.class, int.class, Object.class, int.class, int.class).INVOKE();
			mc.RETURN("newvs");
		});

		cb.publicStaticMethod("valueOf").return_(className).parameter("name", String.class).code(mc -> {
			mc.LINE(1);
			mc.LOADConst(typeOf(className));
			mc.LOAD("name");
			mc.STATIC(Enum.class, "valueOf").parameter(Class.class, String.class).return_(Enum.class).INVOKE();
			mc.CHECKCAST(className);
			mc.RETURNTop();
		});
		return cb;
	}
}
