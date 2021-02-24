package cc1sj.tinyasm.hero;

import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.hero.Hello;
import cc1sj.tinyasm.hero.HeroObject;
import java.lang.Float;
import java.lang.Double;
import java.lang.Integer;
import cc1sj.tinyasm.hero.HeroASMBuilder;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodCaller;
import java.lang.Character;
import java.lang.Long;
import java.lang.Short;
import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.lang.Byte;

@SuppressWarnings("unused")
public class HelloInnerTinyAsmDump {

	static Map<Class<?>, Class<?>> primativeToBoxedClazzMaps = new HashMap<>();
	static {
		primativeToBoxedClazzMaps.put(boolean.class, Boolean.class);
		primativeToBoxedClazzMaps.put(byte.class, Byte.class);
		primativeToBoxedClazzMaps.put(char.class, Character.class);
		primativeToBoxedClazzMaps.put(short.class, Short.class);
		primativeToBoxedClazzMaps.put(int.class, Integer.class);
		primativeToBoxedClazzMaps.put(long.class, Long.class);
		primativeToBoxedClazzMaps.put(float.class, Float.class);
		primativeToBoxedClazzMaps.put(double.class, Double.class);

	}
	static Map<Class<?>, String> primativeToValueMaps = new HashMap<>();
	static {
		primativeToValueMaps.put(boolean.class, "booleanValue");
		primativeToValueMaps.put(byte.class, "byteValue");
		primativeToValueMaps.put(char.class, "charValue");
		primativeToValueMaps.put(short.class, "shortValue");
		primativeToValueMaps.put(int.class, "intValue");
		primativeToValueMaps.put(long.class, "longValue");
		primativeToValueMaps.put(float.class, "floatValue");
		primativeToValueMaps.put(double.class, "doubleValue");

	}

	public static byte[] dump(Type targetType) throws Exception {

		String clazzName = targetType.getClassName() + "Inner";
		ClassBody classWriter = ClassBuilder.make(clazzName).eXtend(Clazz.of(targetType)).implement(HeroObject.class)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		classWriter.field(ACC_FINAL, "_referName", Clazz.of(String.class));
		classWriter.field(0, "_code", Clazz.of(MethodCode.class));
		classWriter.method("<init>").parameter("code", MethodCode.class).parameter("__referName", String.class).code(code -> {

			code.LINE(14);
			code.LOAD("this");
			code.SPECIAL(Hello.class, "<init>").INVOKE();

			code.LINE(15);
			code.LOAD("this");
			code.LOAD("__referName");
			code.PUTFIELD("_referName", String.class);

			code.LINE(17);
			code.LOAD("this");
			code.LOAD("code");
			code.PUTFIELD("_code", MethodCode.class);

			code.LINE(18);
			code.RETURN();
		});

		method_getProperty(classWriter, targetType, String.class, "getName");
		method_setProperty(targetType, classWriter, "setName", String.class);
//		method_getName(targetType, classWriter, "getName", String.class);
//		methos_setName(targetType, classWriter);

		classWriter.method(String.class, "get_______Hero").code(code -> {

			code.LINE(38);
			code.LOAD("this");
			code.GETFIELD("_referName", String.class);
			code.RETURNTop();
		});
//		method_getAgeChar(targetType, classWriter, "getAgeChar", char.class);

		method_getProperty(classWriter, targetType, char.class, "getAgeChar");
		method_getProperty(classWriter, targetType, byte.class, "getAgeByte");
		method_getProperty(classWriter, targetType, short.class, "getAgeShort");
		method_getProperty(classWriter, targetType, int.class, "getAgeInt");
		method_getProperty(classWriter, targetType, long.class, "getAgeLong");
		method_getProperty(classWriter, targetType, float.class, "getAgeFloat");
		method_getProperty(classWriter, targetType, double.class, "getAgeDouble");

		method_getProperty(classWriter, targetType, Character.class, "getAgeCharacter");
		method_getProperty(classWriter, targetType, Byte.class, "getAgeByte2");
		method_getProperty(classWriter, targetType, Short.class, "getAgeShort2");
		method_getProperty(classWriter, targetType, Integer.class, "getAgeInteger");
		method_getProperty(classWriter, targetType, Long.class, "getAgeLong2");
		method_getProperty(classWriter, targetType, Float.class, "getAgeFloat2");
		method_getProperty(classWriter, targetType, Double.class, "getAgeDouble2");

		method_setProperty(targetType, classWriter, "setAgeChar", char.class);
		method_setProperty(targetType, classWriter, "setAgeByte", byte.class);
		method_setProperty(targetType, classWriter, "setAgeShort", short.class);
		method_setProperty(targetType, classWriter, "setAgeInt", int.class);
		method_setProperty(targetType, classWriter, "setAgeLong", long.class);
		method_setProperty(targetType, classWriter, "setAgeFloat", float.class);
		method_setProperty(targetType, classWriter, "setAgeDouble", double.class);

		method_setProperty(targetType, classWriter, "setAgeCharacter", Character.class);
		method_setProperty(targetType, classWriter, "setAgeByte2", Byte.class);
		method_setProperty(targetType, classWriter, "setAgeShort2", Short.class);
		method_setProperty(targetType, classWriter, "setAgeInteger", Integer.class);
		method_setProperty(targetType, classWriter, "setAgeLong2", Long.class);
		method_setProperty(targetType, classWriter, "setAgeFloat2", Float.class);
		method_setProperty(targetType, classWriter, "setAgeDouble2", Double.class);

		return classWriter.end().toByteArray();
	}

	private static void method_setProperty(Type targetType, ClassBody classWriter, String methodName, Class<?> paramsClass) {
		final boolean returnValueNeedBoxing = primativeToBoxedClazzMaps.containsKey(paramsClass);
		Class<?> returnValueboxedClazz = returnValueNeedBoxing ? primativeToBoxedClazzMaps.get(paramsClass) : null;
		String returnValueUnboxValueMethodName = returnValueNeedBoxing ? primativeToValueMaps.get(paramsClass) : null;
		String param1 = "value";

		classWriter.method(methodName).parameter(param1, paramsClass).code(code -> {

			code.LINE(182);
			code.LOAD("this");
			code.GETFIELD("_code", MethodCode.class);
			code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

			code.LINE(183);
			code.LOAD("this");
			code.GETFIELD("_code", MethodCode.class);
			code.LOAD("this");
			code.GETFIELD("_referName", String.class);
			code.STATIC(HeroASMBuilder.class, "resolve").parameter(MethodCode.class).parameter(String.class).INVOKE();

			code.LINE(184);
			code.LOAD("this");
			code.GETFIELD("_code", MethodCode.class);
			code.LOAD(param1);
			code.STATIC(HeroASMBuilder.class, "resolve").parameter(MethodCode.class).parameter(paramsClass).INVOKE();

			code.LINE(185);
			code.LOAD("this");
			code.GETFIELD("_code", MethodCode.class);
			code.LOADConst(targetType);
			code.LOADConst(methodName);
			code.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();
			if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Class.class);
			else code.LOADConst(Type.getType(paramsClass));
			code.INTERFACE(MethodCaller.class, "parameter").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

			code.LINE(186);
			code.RETURN();
		});
	}


	private static void method_getProperty(ClassBody classWriter, Type targetType, Class<?> returnClass, String methodName) {
		final boolean returnValueNeedBoxing = primativeToBoxedClazzMaps.containsKey(returnClass);
		Class<?> returnValueboxedClazz = returnValueNeedBoxing ? primativeToBoxedClazzMaps.get(returnClass) : null;
		String returnValueUnboxValueMethodName = returnValueNeedBoxing ? primativeToValueMaps.get(returnClass) : null;

		classWriter.method(returnClass, methodName).code(code -> {

			code.LINE(59);
			code.LOAD("this");
			code.GETFIELD("_code", MethodCode.class);
			code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

			code.LINE(60);
			code.LOAD("this");
			code.GETFIELD("_code", MethodCode.class);
			code.LOAD("this");
			code.GETFIELD("_referName", String.class);
			code.STATIC(HeroASMBuilder.class, "resolve").parameter(MethodCode.class).parameter(String.class).INVOKE();

			code.LINE(61);
			code.LOAD("this");
			code.GETFIELD("_code", MethodCode.class);
			code.LOADConst(targetType);
			code.LOADConst(methodName);
			code.VIRTUAL(MethodCode.class, "VIRTUAL").reTurn(MethodCaller.class).parameter(Class.class).parameter(String.class).INVOKE();

			if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Class.class);
			else code.LOADConst(Type.getType(returnClass));

			code.INTERFACE(MethodCaller.class, "reTurn").reTurn(MethodCaller.class).parameter(Class.class).INVOKE();
			code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

			code.LINE(62);
			code.LOAD("this");
			code.GETFIELD("_code", MethodCode.class);

			if (returnValueNeedBoxing) code.GETSTATIC(returnValueboxedClazz, "TYPE", Class.class);
			else code.LOADConst(Type.getType(returnClass));

			code.STATIC(HeroASMBuilder.class, "refer").reTurn(Object.class).parameter(MethodCode.class).parameter(Class.class).INVOKE();
			if (returnValueNeedBoxing) {
				code.CHECKCAST(returnValueboxedClazz);
				code.VIRTUAL(returnValueboxedClazz, returnValueUnboxValueMethodName).reTurn(returnClass).INVOKE();
			} else {
				code.CHECKCAST(returnClass);
			}
			code.RETURNTop();
		});
	}

}
