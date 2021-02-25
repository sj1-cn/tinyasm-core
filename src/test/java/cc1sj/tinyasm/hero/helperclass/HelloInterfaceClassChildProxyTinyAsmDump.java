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
import java.lang.Character;
import cc1sj.tinyasm.hero.helperclass.HelloInterfaceClassChild;
import java.lang.Long;
import java.lang.Double;
import java.lang.Short;
import java.lang.String;
import java.lang.Byte;
import java.lang.Integer;
@SuppressWarnings("unused")
public class HelloInterfaceClassChildProxyTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.hero.helperclass.HelloInterfaceClassChildProxy", HelloInterfaceClassChild.class).access(ACC_PUBLIC | ACC_SUPER).body();

{
	MethodCode code = classBody.method("<init>").begin();

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "<init>").INVOKE();
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(int.class, "getIntHelloClassChild").begin();

	code.LINE(8);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getIntHelloClassChild")
		.reTurn(int.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method("setIntHelloClassChild")
	.parameter("intHelloClassChild",int.class).begin();

	code.LINE(14);
	code.LOAD("this");
	code.LOAD("intHelloClassChild");
	code.SPECIAL(HelloInterfaceClassChild.class, "setIntHelloClassChild")
		.parameter(int.class).INVOKE();

	code.LINE(15);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(String.class, "getStringHelloClassChild").begin();

	code.LINE(20);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getStringHelloClassChild")
		.reTurn(String.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method("setStringHelloClassChild")
	.parameter("stringHelloClassChild",String.class).begin();

	code.LINE(26);
	code.LOAD("this");
	code.LOAD("stringHelloClassChild");
	code.SPECIAL(HelloInterfaceClassChild.class, "setStringHelloClassChild")
		.parameter(String.class).INVOKE();

	code.LINE(27);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(String.class, "getName").begin();

	code.LINE(32);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getName")
		.reTurn(String.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(char.class, "getAgeChar").begin();

	code.LINE(38);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeChar")
		.reTurn(char.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(byte.class, "getAgeByte").begin();

	code.LINE(44);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeByte")
		.reTurn(byte.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(short.class, "getAgeShort").begin();

	code.LINE(50);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeShort")
		.reTurn(short.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(int.class, "getAgeInt").begin();

	code.LINE(56);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeInt")
		.reTurn(int.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(long.class, "getAgeLong").begin();

	code.LINE(62);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeLong")
		.reTurn(long.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(float.class, "getAgeFloat").begin();

	code.LINE(68);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeFloat")
		.reTurn(float.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(double.class, "getAgeDouble").begin();

	code.LINE(74);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeDouble")
		.reTurn(double.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Character.class, "getAgeCharacter").begin();

	code.LINE(80);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeCharacter")
		.reTurn(Character.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Byte.class, "getAgeByte2").begin();

	code.LINE(86);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeByte2")
		.reTurn(Byte.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Short.class, "getAgeShort2").begin();

	code.LINE(92);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeShort2")
		.reTurn(Short.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Integer.class, "getAgeInteger").begin();

	code.LINE(98);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeInteger")
		.reTurn(Integer.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Long.class, "getAgeLong2").begin();

	code.LINE(104);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeLong2")
		.reTurn(Long.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Float.class, "getAgeFloat2").begin();

	code.LINE(110);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeFloat2")
		.reTurn(Float.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Double.class, "getAgeDouble2").begin();

	code.LINE(116);
	code.LOAD("this");
	code.SPECIAL(HelloInterfaceClassChild.class, "getAgeDouble2")
		.reTurn(Double.class).INVOKE();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method("setName")
	.parameter("name",String.class).begin();

	code.LINE(122);
	code.LOAD("this");
	code.LOAD("name");
	code.SPECIAL(HelloInterfaceClassChild.class, "setName")
		.parameter(String.class).INVOKE();

	code.LINE(123);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeChar")
	.parameter("ageChar",char.class).begin();

	code.LINE(128);
	code.LOAD("this");
	code.LOAD("ageChar");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeChar")
		.parameter(char.class).INVOKE();

	code.LINE(129);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeByte")
	.parameter("ageByte",byte.class).begin();

	code.LINE(134);
	code.LOAD("this");
	code.LOAD("ageByte");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeByte")
		.parameter(byte.class).INVOKE();

	code.LINE(135);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeShort")
	.parameter("ageShort",short.class).begin();

	code.LINE(140);
	code.LOAD("this");
	code.LOAD("ageShort");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeShort")
		.parameter(short.class).INVOKE();

	code.LINE(141);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeInt")
	.parameter("ageInt",int.class).begin();

	code.LINE(146);
	code.LOAD("this");
	code.LOAD("ageInt");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeInt")
		.parameter(int.class).INVOKE();

	code.LINE(147);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeLong")
	.parameter("ageLong",long.class).begin();

	code.LINE(152);
	code.LOAD("this");
	code.LOAD("ageLong");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeLong")
		.parameter(long.class).INVOKE();

	code.LINE(153);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeFloat")
	.parameter("ageFloat",float.class).begin();

	code.LINE(158);
	code.LOAD("this");
	code.LOAD("ageFloat");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeFloat")
		.parameter(float.class).INVOKE();

	code.LINE(159);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeDouble")
	.parameter("ageDouble",double.class).begin();

	code.LINE(164);
	code.LOAD("this");
	code.LOAD("ageDouble");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeDouble")
		.parameter(double.class).INVOKE();

	code.LINE(165);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeCharacter")
	.parameter("ageCharacter",Character.class).begin();

	code.LINE(170);
	code.LOAD("this");
	code.LOAD("ageCharacter");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeCharacter")
		.parameter(Character.class).INVOKE();

	code.LINE(171);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeByte2")
	.parameter("ageByte2",Byte.class).begin();

	code.LINE(176);
	code.LOAD("this");
	code.LOAD("ageByte2");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeByte2")
		.parameter(Byte.class).INVOKE();

	code.LINE(177);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeShort2")
	.parameter("ageShort2",Short.class).begin();

	code.LINE(182);
	code.LOAD("this");
	code.LOAD("ageShort2");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeShort2")
		.parameter(Short.class).INVOKE();

	code.LINE(183);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeInteger")
	.parameter("ageInteger",Integer.class).begin();

	code.LINE(188);
	code.LOAD("this");
	code.LOAD("ageInteger");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeInteger")
		.parameter(Integer.class).INVOKE();

	code.LINE(189);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeLong2")
	.parameter("ageLong2",Long.class).begin();

	code.LINE(194);
	code.LOAD("this");
	code.LOAD("ageLong2");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeLong2")
		.parameter(Long.class).INVOKE();

	code.LINE(195);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeFloat2")
	.parameter("agefFloat",Float.class).begin();

	code.LINE(200);
	code.LOAD("this");
	code.LOAD("agefFloat");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeFloat2")
		.parameter(Float.class).INVOKE();

	code.LINE(201);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeDouble2")
	.parameter("ageDouble2",Double.class).begin();

	code.LINE(206);
	code.LOAD("this");
	code.LOAD("ageDouble2");
	code.SPECIAL(HelloInterfaceClassChild.class, "setAgeDouble2")
		.parameter(Double.class).INVOKE();

	code.LINE(207);
	code.RETURN();
	code.END();
}

return classBody.end().toByteArray();
}
}
