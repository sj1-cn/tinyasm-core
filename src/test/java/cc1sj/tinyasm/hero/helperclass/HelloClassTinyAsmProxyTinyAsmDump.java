package cc1sj.tinyasm.hero.helperclass;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.hero.HeroObject;
import java.lang.Float;
import cc1sj.tinyasm.hero.TinyASMBuilder;
import java.lang.Double;
import java.lang.Integer;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.MethodCaller;
import java.lang.Character;
import cc1sj.tinyasm.hero.helperclass.HelloClass;
import java.lang.Long;
import java.lang.Short;
import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import java.lang.Byte;
@SuppressWarnings("unused")
public class HelloClassTinyAsmProxyTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.hero.helperclass.HelloClassTinyAsmProxy", HelloClass.class, HeroObject.class).access(ACC_PUBLIC | ACC_SUPER).body();

classBody.field(ACC_FINAL, "_referName", Clazz.of(String.class));
classBody.field(0, "_code", Clazz.of(MethodCode.class));
{
	MethodCode code = classBody.method("<init>")
	.parameter("code",MethodCode.class)
	.parameter("__referName",String.class).begin();

	code.LINE(16);
	code.LOAD("this");
	code.SPECIAL(HelloClass.class, "<init>").INVOKE();

	code.LINE(17);
	code.LOAD("this");
	code.LOAD("__referName");
	code.PUTFIELD("_referName", String.class);

	code.LINE(19);
	code.LOAD("this");
	code.LOAD("code");
	code.PUTFIELD("_code", MethodCode.class);

	code.LINE(20);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(String.class, "get_______Hero").begin();

	code.LINE(24);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(String.class, "getName").begin();

	code.LINE(29);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(30);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(31);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getName");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/String;"));
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(32);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/String;"));
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(String.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(char.class, "getAgeChar").begin();

	code.LINE(38);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(39);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(40);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeChar");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Character.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(41);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Character.class, "TYPE", Class.class);
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Character.class);
	code.VIRTUAL(Character.class, "charValue")
		.reTurn(char.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(byte.class, "getAgeByte").begin();

	code.LINE(46);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(47);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(48);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeByte");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Byte.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(49);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Byte.class, "TYPE", Class.class);
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Byte.class);
	code.VIRTUAL(Byte.class, "byteValue")
		.reTurn(byte.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(short.class, "getAgeShort").begin();

	code.LINE(54);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(55);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(56);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeShort");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Short.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(57);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Short.class, "TYPE", Class.class);
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Short.class);
	code.VIRTUAL(Short.class, "shortValue")
		.reTurn(short.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(int.class, "getAgeInt").begin();

	code.LINE(62);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(63);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(64);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeInt");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Integer.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(65);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Integer.class, "TYPE", Class.class);
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Integer.class);
	code.VIRTUAL(Integer.class, "intValue")
		.reTurn(int.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(long.class, "getAgeLong").begin();

	code.LINE(71);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(72);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(73);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeLong");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Long.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(74);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Long.class, "TYPE", Class.class);
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Long.class);
	code.VIRTUAL(Long.class, "longValue")
		.reTurn(long.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(float.class, "getAgeFloat").begin();

	code.LINE(80);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(81);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(82);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeFloat");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Float.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(83);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Float.class, "TYPE", Class.class);
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Float.class);
	code.VIRTUAL(Float.class, "floatValue")
		.reTurn(float.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(double.class, "getAgeDouble").begin();

	code.LINE(89);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(90);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(91);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeDouble");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Double.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(92);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Double.class, "TYPE", Class.class);
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Double.class);
	code.VIRTUAL(Double.class, "doubleValue")
		.reTurn(double.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Character.class, "getAgeCharacter").begin();

	code.LINE(98);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(99);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(100);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeCharacter");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Character;"));
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(101);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Character;"));
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Character.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Byte.class, "getAgeByte2").begin();

	code.LINE(107);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(108);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(109);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeByte2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Byte;"));
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(110);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Byte;"));
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Byte.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Short.class, "getAgeShort2").begin();

	code.LINE(116);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(117);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(118);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeShort2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Short;"));
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(119);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Short;"));
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Short.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Integer.class, "getAgeInteger").begin();

	code.LINE(125);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(126);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(127);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeInteger");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Integer;"));
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(128);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Integer;"));
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Integer.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Long.class, "getAgeLong2").begin();

	code.LINE(134);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(135);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(136);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeLong2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Long;"));
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(137);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Long;"));
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Long.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Float.class, "getAgeFloat2").begin();

	code.LINE(143);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(144);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(145);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeFloat2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Float;"));
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(146);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Float;"));
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Float.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Double.class, "getAgeDouble2").begin();

	code.LINE(152);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(153);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(154);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("getAgeDouble2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Double;"));
	code.INTERFACE(MethodCaller.class, "reTurn")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(155);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Double;"));
	code.STATIC(TinyASMBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Double.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method("setName")
	.parameter("value",String.class).begin();

	code.LINE(160);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(161);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(162);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(163);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setName");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/String;"));
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(164);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeChar")
	.parameter("value",char.class).begin();

	code.LINE(168);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(169);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(170);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(char.class).INVOKE();

	code.LINE(171);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeChar");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Character.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(172);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeByte")
	.parameter("value",byte.class).begin();

	code.LINE(177);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(178);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(179);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(byte.class).INVOKE();

	code.LINE(180);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeByte");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Byte.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(181);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeShort")
	.parameter("value",short.class).begin();

	code.LINE(185);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(186);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(187);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(short.class).INVOKE();

	code.LINE(188);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeShort");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Short.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(189);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeInt")
	.parameter("value",int.class).begin();

	code.LINE(194);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(195);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(196);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(int.class).INVOKE();

	code.LINE(197);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeInt");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Integer.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(198);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeLong")
	.parameter("value",long.class).begin();

	code.LINE(203);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(204);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(205);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(long.class).INVOKE();

	code.LINE(206);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeLong");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Long.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(207);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeFloat")
	.parameter("value",float.class).begin();

	code.LINE(212);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(213);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(214);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(float.class).INVOKE();

	code.LINE(215);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeFloat");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Float.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(216);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeDouble")
	.parameter("value",double.class).begin();

	code.LINE(221);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(222);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(223);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(double.class).INVOKE();

	code.LINE(224);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeDouble");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.GETSTATIC(Double.class, "TYPE", Class.class);
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(225);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeCharacter")
	.parameter("value",Character.class).begin();

	code.LINE(230);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(231);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(232);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Character.class).INVOKE();

	code.LINE(233);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeCharacter");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Character;"));
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(234);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeByte2")
	.parameter("value",Byte.class).begin();

	code.LINE(239);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(240);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(241);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Byte.class).INVOKE();

	code.LINE(242);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeByte2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Byte;"));
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(243);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeShort2")
	.parameter("value",Short.class).begin();

	code.LINE(248);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(249);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(250);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Short.class).INVOKE();

	code.LINE(251);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeShort2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Short;"));
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(252);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeInteger")
	.parameter("value",Integer.class).begin();

	code.LINE(257);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(258);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(259);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Integer.class).INVOKE();

	code.LINE(260);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeInteger");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Integer;"));
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(261);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeLong2")
	.parameter("value",Long.class).begin();

	code.LINE(266);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(267);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(268);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Long.class).INVOKE();

	code.LINE(269);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeLong2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Long;"));
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(270);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeFloat2")
	.parameter("value",Float.class).begin();

	code.LINE(275);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(276);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(277);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Float.class).INVOKE();

	code.LINE(278);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeFloat2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Float;"));
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(279);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeDouble2")
	.parameter("value",Double.class).begin();

	code.LINE(284);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(285);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(286);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyASMBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Double.class).INVOKE();

	code.LINE(287);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Lcc1sj/tinyasm/hero/helperclass/HelloClass;"));
	code.LOADConst("setAgeDouble2");
	code.VIRTUAL(MethodCode.class, "VIRTUAL")
		.reTurn(MethodCaller.class)
		.parameter(Class.class)
		.parameter(String.class).INVOKE();
	code.LOADConst(Type.getType("Ljava/lang/Double;"));
	code.INTERFACE(MethodCaller.class, "parameter")
		.reTurn(MethodCaller.class)
		.parameter(Class.class).INVOKE();
	code.INTERFACE(MethodCaller.class, "INVOKE").INVOKE();

	code.LINE(288);
	code.RETURN();
	code.END();
}

return classBody.end().toByteArray();
}
}
