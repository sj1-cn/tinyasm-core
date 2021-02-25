package cc1sj.tinyasm.hero.helperclass;
import org.objectweb.asm.Label;
import cc1sj.tinyasm.ClassBody;
import cc1sj.tinyasm.ClassBuilder;
import cc1sj.tinyasm.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cc1sj.tinyasm.Annotation;
import cc1sj.tinyasm.Clazz;
import java.lang.Float;
import java.lang.Double;
import cc1sj.tinyasm.hero.TinyAsmBuilder;
import java.lang.Integer;
import cc1sj.tinyasm.hero.TinyAsmProxyRuntimeReferNameObject;
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

ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.hero.helperclass.HelloClassTinyAsmProxy", HelloClass.class, TinyAsmProxyRuntimeReferNameObject.class).access(ACC_PUBLIC | ACC_SUPER).body();

classBody.field("_referName", Clazz.of(String.class));
classBody.field("_code", Clazz.of(MethodCode.class));
{
	MethodCode code = classBody.method("<init>").begin();

	code.LINE(9);
	code.LOAD("this");
	code.SPECIAL(HelloClass.class, "<init>").INVOKE();
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(String.class, "get__ReferName").begin();

	code.LINE(16);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method("__init")
	.parameter("code",MethodCode.class)
	.parameter("name",String.class).begin();

	code.LINE(21);
	code.LOAD("this");
	code.LOAD("code");
	code.PUTFIELD("_code", MethodCode.class);

	code.LINE(22);
	code.LOAD("this");
	code.LOAD("name");
	code.PUTFIELD("_referName", String.class);

	code.LINE(23);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(String.class, "getName").begin();

	code.LINE(27);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(28);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(29);
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

	code.LINE(30);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/String;"));
	code.STATIC(TinyAsmBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(String.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(char.class, "getAgeChar").begin();

	code.LINE(35);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(36);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(37);
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

	code.LINE(38);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Character.class, "TYPE", Class.class);
	code.STATIC(TinyAsmBuilder.class, "refer")
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

	code.LINE(43);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(44);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(45);
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

	code.LINE(46);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Byte.class, "TYPE", Class.class);
	code.STATIC(TinyAsmBuilder.class, "refer")
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

	code.LINE(51);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(52);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(53);
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

	code.LINE(54);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Short.class, "TYPE", Class.class);
	code.STATIC(TinyAsmBuilder.class, "refer")
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

	code.LINE(59);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(60);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(61);
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

	code.LINE(62);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Integer.class, "TYPE", Class.class);
	code.STATIC(TinyAsmBuilder.class, "refer")
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

	code.LINE(68);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(69);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(70);
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

	code.LINE(71);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Long.class, "TYPE", Class.class);
	code.STATIC(TinyAsmBuilder.class, "refer")
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

	code.LINE(77);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(78);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(79);
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

	code.LINE(80);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Float.class, "TYPE", Class.class);
	code.STATIC(TinyAsmBuilder.class, "refer")
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

	code.LINE(86);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(87);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(88);
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

	code.LINE(89);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.GETSTATIC(Double.class, "TYPE", Class.class);
	code.STATIC(TinyAsmBuilder.class, "refer")
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

	code.LINE(95);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(96);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(97);
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

	code.LINE(98);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Character;"));
	code.STATIC(TinyAsmBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Character.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Byte.class, "getAgeByte2").begin();

	code.LINE(104);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(105);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(106);
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

	code.LINE(107);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Byte;"));
	code.STATIC(TinyAsmBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Byte.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Short.class, "getAgeShort2").begin();

	code.LINE(113);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(114);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(115);
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

	code.LINE(116);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Short;"));
	code.STATIC(TinyAsmBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Short.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Integer.class, "getAgeInteger").begin();

	code.LINE(122);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(123);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(124);
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

	code.LINE(125);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Integer;"));
	code.STATIC(TinyAsmBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Integer.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Long.class, "getAgeLong2").begin();

	code.LINE(131);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(132);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(133);
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

	code.LINE(134);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Long;"));
	code.STATIC(TinyAsmBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Long.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Float.class, "getAgeFloat2").begin();

	code.LINE(140);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(141);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(142);
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

	code.LINE(143);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Float;"));
	code.STATIC(TinyAsmBuilder.class, "refer")
		.reTurn(Object.class)
		.parameter(MethodCode.class)
		.parameter(Class.class).INVOKE();
	code.CHECKCAST(Float.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Double.class, "getAgeDouble2").begin();

	code.LINE(149);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(150);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(151);
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

	code.LINE(152);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOADConst(Type.getType("Ljava/lang/Double;"));
	code.STATIC(TinyAsmBuilder.class, "refer")
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

	code.LINE(157);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(158);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(159);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(160);
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

	code.LINE(161);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeChar")
	.parameter("value",char.class).begin();

	code.LINE(165);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(166);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(167);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(char.class).INVOKE();

	code.LINE(168);
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

	code.LINE(169);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeByte")
	.parameter("value",byte.class).begin();

	code.LINE(174);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(175);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(176);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(byte.class).INVOKE();

	code.LINE(177);
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

	code.LINE(178);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeShort")
	.parameter("value",short.class).begin();

	code.LINE(182);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(183);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(184);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(short.class).INVOKE();

	code.LINE(185);
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

	code.LINE(186);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeInt")
	.parameter("value",int.class).begin();

	code.LINE(191);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(192);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(193);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(int.class).INVOKE();

	code.LINE(194);
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

	code.LINE(195);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeLong")
	.parameter("value",long.class).begin();

	code.LINE(200);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(201);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(202);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(long.class).INVOKE();

	code.LINE(203);
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

	code.LINE(204);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeFloat")
	.parameter("value",float.class).begin();

	code.LINE(209);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(210);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(211);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(float.class).INVOKE();

	code.LINE(212);
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

	code.LINE(213);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeDouble")
	.parameter("value",double.class).begin();

	code.LINE(218);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(219);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(220);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(double.class).INVOKE();

	code.LINE(221);
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

	code.LINE(222);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeCharacter")
	.parameter("value",Character.class).begin();

	code.LINE(227);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(228);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(229);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Character.class).INVOKE();

	code.LINE(230);
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

	code.LINE(231);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeByte2")
	.parameter("value",Byte.class).begin();

	code.LINE(236);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(237);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(238);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Byte.class).INVOKE();

	code.LINE(239);
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

	code.LINE(240);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeShort2")
	.parameter("value",Short.class).begin();

	code.LINE(245);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(246);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(247);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Short.class).INVOKE();

	code.LINE(248);
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

	code.LINE(249);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeInteger")
	.parameter("value",Integer.class).begin();

	code.LINE(254);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(255);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(256);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Integer.class).INVOKE();

	code.LINE(257);
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

	code.LINE(258);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeLong2")
	.parameter("value",Long.class).begin();

	code.LINE(263);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(264);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(265);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Long.class).INVOKE();

	code.LINE(266);
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

	code.LINE(267);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeFloat2")
	.parameter("value",Float.class).begin();

	code.LINE(272);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(273);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(274);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Float.class).INVOKE();

	code.LINE(275);
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

	code.LINE(276);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeDouble2")
	.parameter("value",Double.class).begin();

	code.LINE(281);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.VIRTUAL(MethodCode.class, "LINE").INVOKE();

	code.LINE(282);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("this");
	code.GETFIELD("_referName", String.class);
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(String.class).INVOKE();

	code.LINE(283);
	code.LOAD("this");
	code.GETFIELD("_code", MethodCode.class);
	code.LOAD("value");
	code.STATIC(TinyAsmBuilder.class, "resolve")
		.parameter(MethodCode.class)
		.parameter(Double.class).INVOKE();

	code.LINE(284);
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

	code.LINE(285);
	code.RETURN();
	code.END();
}

return classBody.end().toByteArray();
}
}
