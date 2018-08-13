package nebula.tinyasm.help;

import static nebula.tinyasm.util.TypeUtils.arrayOf;
import static nebula.tinyasm.util.TypeUtils.namesOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.api.ClassBody;

public class EnumBuilder implements Opcodes {

	public static byte[] dump(String objectType, String... names) {
		return build(objectType, names).end().toByteArray();
	}

	public static ClassBody build(String objectType, String... names) {
		String superType = "java.lang.Enum";

		ClassBody cb = ClassBuilder
			.make(ACC_PUBLIC + ACC_FINAL + ACC_SUPER + ACC_ENUM, objectType, superType, new String[] { objectType })
			.body();

		for (String name : names) {
			cb.field(ACC_PUBLIC + ACC_FINAL + ACC_STATIC + ACC_ENUM, name, objectType);
		}
		cb.field(ACC_PRIVATE + ACC_FINAL + ACC_STATIC + ACC_SYNTHETIC, "ENUM$VALUES", objectType, true);

		cb.staticMethod("<clinit>").code(mc -> {
			{
				mc.line(4);

				for (int i = 0; i < names.length; i++) {
					mc.NEW(typeOf(objectType));
					mc.DUP();
					mc.LOADConst(names[i]);
					mc.LOADConstByte(i);
					mc.INVOKESPECIAL(typeOf(objectType), Type.VOID_TYPE, "<init>", typeOf(String.class),
							Type.INT_TYPE);
					mc.PUTSTATIC(typeOf(objectType), names[i], typeOf(objectType));
				}

				mc.line(3).LOADConstByte(names.length);
				mc.NEWARRAY(typeOf(objectType));

				for (int i = 0; i < names.length; i++) {
					mc.DUP();
					mc.LOADConstByte(i);
					mc.GETSTATIC(typeOf(objectType), names[i], typeOf(objectType));
					mc.ARRAYSTORE();
				}
				mc.PUTSTATIC(typeOf(objectType), "ENUM$VALUES", arrayOf(typeOf(objectType)));
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

		cb.mvStaticMethod(ACC_STATIC + ACC_PUBLIC, arrayOf(typeOf(objectType), true), "values",
				namesOf(exceptionClasses))
			.code(mc -> {
				mc.def("vs", typeOf(objectType), true);
				mc.def("length", int.class);
				mc.def("newvs", typeOf(objectType), true);
				mc.line(1);
				mc.GETSTATIC(typeOf(objectType), "ENUM$VALUES", arrayOf(typeOf(objectType)));
				mc.DUP();
				mc.STORE("vs");

				mc.LOADConstByte(0);
				mc.LOAD("vs");
				mc.ARRAYLENGTH();
				mc.DUP();
				mc.STORE("length");
				mc.NEWARRAY(typeOf(objectType));
				mc.DUP();
				mc.STORE("newvs");

				mc.LOADConstByte(0);
				mc.LOAD("length");

				mc.INVOKESTATIC(System.class, "arraycopy", Object.class, int.class, Object.class, int.class, int.class);
				mc.RETURN("newvs");
			});
		Class<?>[] exceptionClasses1 = {};

		cb.mvStaticMethod(ACC_STATIC + ACC_PUBLIC, typeOf(objectType), "valueOf", namesOf(exceptionClasses1))
			.parameter("name", String.class)
			.code(mc -> {
				mc.line(1);
				mc.LOADConst(typeOf(objectType));
				mc.LOAD("name");
				mc.INVOKESTATIC(Enum.class, Enum.class, "valueOf", Class.class, String.class);
				mc.CHECKCAST(typeOf(objectType));
				mc.RETURNTop();
			});
		return cb;
	}
}
