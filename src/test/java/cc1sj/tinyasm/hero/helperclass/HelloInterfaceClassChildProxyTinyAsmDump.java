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
		return new HelloInterfaceClassChildProxyTinyAsmDump().dump("cc1sj.tinyasm.hero.helperclass.HelloInterfaceClassChildProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, HelloInterfaceClassChild.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_getIntHelloClassChild(classBody);
		_setIntHelloClassChild(classBody);
		_getStringHelloClassChild(classBody);
		_setStringHelloClassChild(classBody);
		_getName(classBody);
		_getAgeChar(classBody);
		_getAgeByte(classBody);
		_getAgeShort(classBody);
		_getAgeInt(classBody);
		_getAgeLong(classBody);
		_getAgeFloat(classBody);
		_getAgeDouble(classBody);
		_getAgeCharacter(classBody);
		_getAgeByte2(classBody);
		_getAgeShort2(classBody);
		_getAgeInteger(classBody);
		_getAgeLong2(classBody);
		_getAgeFloat2(classBody);
		_getAgeDouble2(classBody);
		_setName(classBody);
		_setAgeChar(classBody);
		_setAgeByte(classBody);
		_setAgeShort(classBody);
		_setAgeInt(classBody);
		_setAgeLong(classBody);
		_setAgeFloat(classBody);
		_setAgeDouble(classBody);
		_setAgeCharacter(classBody);
		_setAgeByte2(classBody);
		_setAgeShort2(classBody);
		_setAgeInteger(classBody);
		_setAgeLong2(classBody);
		_setAgeFloat2(classBody);
		_setAgeDouble2(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getIntHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getIntHelloClassChild").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getIntHelloClassChild")
			.reTurn(int.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _setIntHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.method("setIntHelloClassChild")
			.parameter("intHelloClassChild",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("intHelloClassChild");
		code.SPECIAL(HelloInterfaceClassChild.class, "setIntHelloClassChild")
			.parameter(int.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getStringHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.method(String.class, "getStringHelloClassChild").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getStringHelloClassChild")
			.reTurn(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _setStringHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.method("setStringHelloClassChild")
			.parameter("stringHelloClassChild",String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("stringHelloClassChild");
		code.SPECIAL(HelloInterfaceClassChild.class, "setStringHelloClassChild")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getName(ClassBody classBody) {
		MethodCode code = classBody.method(String.class, "getName").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getName")
			.reTurn(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeChar(ClassBody classBody) {
		MethodCode code = classBody.method(char.class, "getAgeChar").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeChar")
			.reTurn(char.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeByte(ClassBody classBody) {
		MethodCode code = classBody.method(byte.class, "getAgeByte").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeByte")
			.reTurn(byte.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeShort(ClassBody classBody) {
		MethodCode code = classBody.method(short.class, "getAgeShort").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeShort")
			.reTurn(short.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeInt(ClassBody classBody) {
		MethodCode code = classBody.method(int.class, "getAgeInt").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeInt")
			.reTurn(int.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeLong(ClassBody classBody) {
		MethodCode code = classBody.method(long.class, "getAgeLong").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeLong")
			.reTurn(long.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeFloat(ClassBody classBody) {
		MethodCode code = classBody.method(float.class, "getAgeFloat").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeFloat")
			.reTurn(float.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeDouble(ClassBody classBody) {
		MethodCode code = classBody.method(double.class, "getAgeDouble").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeDouble")
			.reTurn(double.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeCharacter(ClassBody classBody) {
		MethodCode code = classBody.method(Character.class, "getAgeCharacter").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeCharacter")
			.reTurn(Character.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeByte2(ClassBody classBody) {
		MethodCode code = classBody.method(Byte.class, "getAgeByte2").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeByte2")
			.reTurn(Byte.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeShort2(ClassBody classBody) {
		MethodCode code = classBody.method(Short.class, "getAgeShort2").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeShort2")
			.reTurn(Short.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeInteger(ClassBody classBody) {
		MethodCode code = classBody.method(Integer.class, "getAgeInteger").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeInteger")
			.reTurn(Integer.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeLong2(ClassBody classBody) {
		MethodCode code = classBody.method(Long.class, "getAgeLong2").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeLong2")
			.reTurn(Long.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeFloat2(ClassBody classBody) {
		MethodCode code = classBody.method(Float.class, "getAgeFloat2").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeFloat2")
			.reTurn(Float.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeDouble2(ClassBody classBody) {
		MethodCode code = classBody.method(Double.class, "getAgeDouble2").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(HelloInterfaceClassChild.class, "getAgeDouble2")
			.reTurn(Double.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _setName(ClassBody classBody) {
		MethodCode code = classBody.method("setName")
			.parameter("name",String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("name");
		code.SPECIAL(HelloInterfaceClassChild.class, "setName")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeChar(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeChar")
			.parameter("ageChar",char.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageChar");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeChar")
			.parameter(char.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeByte(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeByte")
			.parameter("ageByte",byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageByte");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeByte")
			.parameter(byte.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeShort(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeShort")
			.parameter("ageShort",short.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageShort");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeShort")
			.parameter(short.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeInt(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeInt")
			.parameter("ageInt",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageInt");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeInt")
			.parameter(int.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeLong(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeLong")
			.parameter("ageLong",long.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageLong");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeLong")
			.parameter(long.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeFloat(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeFloat")
			.parameter("ageFloat",float.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageFloat");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeFloat")
			.parameter(float.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeDouble(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeDouble")
			.parameter("ageDouble",double.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageDouble");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeDouble")
			.parameter(double.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeCharacter(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeCharacter")
			.parameter("ageCharacter",Character.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageCharacter");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeCharacter")
			.parameter(Character.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeByte2(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeByte2")
			.parameter("ageByte2",Byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageByte2");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeByte2")
			.parameter(Byte.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeShort2(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeShort2")
			.parameter("ageShort2",Short.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageShort2");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeShort2")
			.parameter(Short.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeInteger(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeInteger")
			.parameter("ageInteger",Integer.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageInteger");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeInteger")
			.parameter(Integer.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeLong2(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeLong2")
			.parameter("ageLong2",Long.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageLong2");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeLong2")
			.parameter(Long.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeFloat2(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeFloat2")
			.parameter("agefFloat",Float.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("agefFloat");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeFloat2")
			.parameter(Float.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeDouble2(ClassBody classBody) {
		MethodCode code = classBody.method("setAgeDouble2")
			.parameter("ageDouble2",Double.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageDouble2");
		code.SPECIAL(HelloInterfaceClassChild.class, "setAgeDouble2")
			.parameter(Double.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
