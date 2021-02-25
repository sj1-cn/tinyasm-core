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
import java.lang.Long;
import java.lang.Double;
import cc1sj.tinyasm.hero.helperclass.HelloInterface;
import java.lang.Short;
import java.lang.Object;
import java.lang.String;
import java.lang.Byte;
import java.lang.Integer;
@SuppressWarnings("unused")
public class HelloInterfaceClassChildTinyAsmDump {

public static byte[] dump () throws Exception {

ClassBody classBody = ClassBuilder.make("cc1sj.tinyasm.hero.helperclass.HelloInterfaceClassChild", null, HelloInterface.class).access(ACC_PUBLIC | ACC_SUPER).body();

classBody.field(0, "intHelloClassChild", Clazz.of(int.class));
classBody.field(0, "stringHelloClassChild", Clazz.of(String.class));
{
	MethodCode code = classBody.method("<init>").begin();

	code.LINE(3);
	code.LOAD("this");
	code.SPECIAL(Object.class, "<init>").INVOKE();
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(int.class, "getIntHelloClassChild").begin();

	code.LINE(9);
	code.LOAD("this");
	code.GETFIELD("intHelloClassChild", int.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method("setIntHelloClassChild")
	.parameter("intHelloClassChild",int.class).begin();

	code.LINE(13);
	code.LOAD("this");
	code.LOAD("intHelloClassChild");
	code.PUTFIELD("intHelloClassChild", int.class);

	code.LINE(14);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(String.class, "getStringHelloClassChild").begin();

	code.LINE(17);
	code.LOAD("this");
	code.GETFIELD("stringHelloClassChild", String.class);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method("setStringHelloClassChild")
	.parameter("stringHelloClassChild",String.class).begin();

	code.LINE(21);
	code.LOAD("this");
	code.LOAD("stringHelloClassChild");
	code.PUTFIELD("stringHelloClassChild", String.class);

	code.LINE(22);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method(String.class, "getName").begin();

	code.LINE(27);
	code.LOADConstNULL();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(char.class, "getAgeChar").begin();

	code.LINE(33);
	code.LOADConst(0);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(byte.class, "getAgeByte").begin();

	code.LINE(39);
	code.LOADConst(0);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(short.class, "getAgeShort").begin();

	code.LINE(45);
	code.LOADConst(0);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(int.class, "getAgeInt").begin();

	code.LINE(51);
	code.LOADConst(0);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(long.class, "getAgeLong").begin();

	code.LINE(57);
	code.LOADConst(0L);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(float.class, "getAgeFloat").begin();

	code.LINE(63);
	code.LOADConst(0F);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(double.class, "getAgeDouble").begin();

	code.LINE(69);
	code.LOADConst(0D);
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Character.class, "getAgeCharacter").begin();

	code.LINE(75);
	code.LOADConstNULL();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Byte.class, "getAgeByte2").begin();

	code.LINE(81);
	code.LOADConstNULL();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Short.class, "getAgeShort2").begin();

	code.LINE(87);
	code.LOADConstNULL();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Integer.class, "getAgeInteger").begin();

	code.LINE(93);
	code.LOADConstNULL();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Long.class, "getAgeLong2").begin();

	code.LINE(99);
	code.LOADConstNULL();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Float.class, "getAgeFloat2").begin();

	code.LINE(105);
	code.LOADConstNULL();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method(Double.class, "getAgeDouble2").begin();

	code.LINE(111);
	code.LOADConstNULL();
	code.RETURNTop();
	code.END();
}

{
	MethodCode code = classBody.method("setName")
	.parameter("name",String.class).begin();

	code.LINE(118);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeChar")
	.parameter("ageChar",char.class).begin();

	code.LINE(124);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeByte")
	.parameter("ageByte",byte.class).begin();

	code.LINE(130);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeShort")
	.parameter("ageShort",short.class).begin();

	code.LINE(136);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeInt")
	.parameter("ageInt",int.class).begin();

	code.LINE(142);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeLong")
	.parameter("ageLong",long.class).begin();

	code.LINE(148);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeFloat")
	.parameter("ageFloat",float.class).begin();

	code.LINE(154);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeDouble")
	.parameter("ageDouble",double.class).begin();

	code.LINE(160);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeCharacter")
	.parameter("ageCharacter",Character.class).begin();

	code.LINE(166);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeByte2")
	.parameter("ageByte2",Byte.class).begin();

	code.LINE(172);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeShort2")
	.parameter("ageShort2",Short.class).begin();

	code.LINE(178);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeInteger")
	.parameter("ageInteger",Integer.class).begin();

	code.LINE(184);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeLong2")
	.parameter("ageLong2",Long.class).begin();

	code.LINE(190);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeFloat2")
	.parameter("agefFloat",Float.class).begin();

	code.LINE(196);
	code.RETURN();
	code.END();
}

{
	MethodCode code = classBody.method("setAgeDouble2")
	.parameter("ageDouble2",Double.class).begin();

	code.LINE(202);
	code.RETURN();
	code.END();
}

return classBody.end().toByteArray();
}
}
