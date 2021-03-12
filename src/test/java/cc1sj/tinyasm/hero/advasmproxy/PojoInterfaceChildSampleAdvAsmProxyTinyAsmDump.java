package cc1sj.tinyasm.hero.advasmproxy;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
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
import java.lang.Short;
import java.lang.String;
import java.lang.Byte;
import java.lang.Integer;
import cc1sj.tinyasm.hero.helperclass.PojoInterfaceChildSample;
@SuppressWarnings("unused")
public class PojoInterfaceChildSampleAdvAsmProxyTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new PojoInterfaceChildSampleAdvAsmProxyTinyAsmDump().dump("cc1sj.tinyasm.hero.advasmproxy.PojoInterfaceChildSampleAdvAsmProxy");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.make(className, PojoInterfaceChildSample.class)
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
		MethodCode code = classBody.publicMethod("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getIntHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getIntHelloClassChild")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getIntHelloClassChild")
			.reTurn(int.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _setIntHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setIntHelloClassChild")
			.parameter("intHelloClassChild",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("intHelloClassChild");
		code.SPECIAL(PojoInterfaceChildSample.class, "setIntHelloClassChild")
			.parameter(int.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getStringHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getStringHelloClassChild")
			.return_(String.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getStringHelloClassChild")
			.reTurn(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _setStringHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setStringHelloClassChild")
			.parameter("stringHelloClassChild",String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("stringHelloClassChild");
		code.SPECIAL(PojoInterfaceChildSample.class, "setStringHelloClassChild")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getName(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getName")
			.return_(String.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getName")
			.reTurn(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeChar(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeChar")
			.return_(char.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeChar")
			.reTurn(char.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeByte(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeByte")
			.return_(byte.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeByte")
			.reTurn(byte.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeShort(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeShort")
			.return_(short.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeShort")
			.reTurn(short.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeInt(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeInt")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeInt")
			.reTurn(int.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeLong(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeLong")
			.return_(long.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeLong")
			.reTurn(long.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeFloat(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeFloat")
			.return_(float.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeFloat")
			.reTurn(float.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeDouble(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeDouble")
			.return_(double.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeDouble")
			.reTurn(double.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeCharacter(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeCharacter")
			.return_(Character.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeCharacter")
			.reTurn(Character.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeByte2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeByte2")
			.return_(Byte.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeByte2")
			.reTurn(Byte.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeShort2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeShort2")
			.return_(Short.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeShort2")
			.reTurn(Short.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeInteger(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeInteger")
			.return_(Integer.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeInteger")
			.reTurn(Integer.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeLong2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeLong2")
			.return_(Long.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeLong2")
			.reTurn(Long.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeFloat2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeFloat2")
			.return_(Float.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeFloat2")
			.reTurn(Float.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeDouble2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("getAgeDouble2")
			.return_(Double.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(PojoInterfaceChildSample.class, "getAgeDouble2")
			.reTurn(Double.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

	protected void _setName(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setName")
			.parameter("name",String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("name");
		code.SPECIAL(PojoInterfaceChildSample.class, "setName")
			.parameter(String.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeChar(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeChar")
			.parameter("ageChar",char.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageChar");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeChar")
			.parameter(char.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeByte(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeByte")
			.parameter("ageByte",byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageByte");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeByte")
			.parameter(byte.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeShort(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeShort")
			.parameter("ageShort",short.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageShort");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeShort")
			.parameter(short.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeInt(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeInt")
			.parameter("ageInt",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageInt");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeInt")
			.parameter(int.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeLong(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeLong")
			.parameter("ageLong",long.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageLong");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeLong")
			.parameter(long.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeFloat(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeFloat")
			.parameter("ageFloat",float.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageFloat");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeFloat")
			.parameter(float.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeDouble(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeDouble")
			.parameter("ageDouble",double.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageDouble");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeDouble")
			.parameter(double.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeCharacter(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeCharacter")
			.parameter("ageCharacter",Character.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageCharacter");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeCharacter")
			.parameter(Character.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeByte2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeByte2")
			.parameter("ageByte2",Byte.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageByte2");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeByte2")
			.parameter(Byte.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeShort2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeShort2")
			.parameter("ageShort2",Short.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageShort2");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeShort2")
			.parameter(Short.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeInteger(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeInteger")
			.parameter("ageInteger",Integer.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageInteger");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeInteger")
			.parameter(Integer.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeLong2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeLong2")
			.parameter("ageLong2",Long.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageLong2");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeLong2")
			.parameter(Long.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeFloat2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeFloat2")
			.parameter("agefFloat",Float.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("agefFloat");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeFloat2")
			.parameter(Float.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeDouble2(ClassBody classBody) {
		MethodCode code = classBody.publicMethod("setAgeDouble2")
			.parameter("ageDouble2",Double.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("ageDouble2");
		code.SPECIAL(PojoInterfaceChildSample.class, "setAgeDouble2")
			.parameter(Double.class).INVOKE();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
