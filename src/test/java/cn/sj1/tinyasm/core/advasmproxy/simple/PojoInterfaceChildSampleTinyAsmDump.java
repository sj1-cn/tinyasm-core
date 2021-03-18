package cn.sj1.tinyasm.core.advasmproxy.simple;
import org.objectweb.asm.Label;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.MethodCode;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;
import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.Clazz;
import java.lang.Float;
import java.lang.Character;
import java.lang.Long;
import java.lang.Double;
import java.lang.Short;
import java.lang.Boolean;
import java.lang.Object;
import cn.sj1.tinyasm.core.advasmproxy.simple.PojoInterfaceSample;
import java.lang.String;
import java.lang.Byte;
import java.lang.Integer;
@SuppressWarnings("unused")
public class PojoInterfaceChildSampleTinyAsmDump {

	public static byte[] dump () throws Exception {
		return new PojoInterfaceChildSampleTinyAsmDump().dump("cn.sj1.tinyasm.core.advasmproxy.simple.PojoInterfaceChildSample");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className, Object.class, PojoInterfaceSample.class)
			.access(ACC_PUBLIC | ACC_SUPER).body();

		classBody.field("intHelloClassChild", Clazz.of(int.class));
		classBody.field("stringHelloClassChild", Clazz.of(String.class));
		__init_(classBody);
		_getIntHelloClassChild(classBody);
		_setIntHelloClassChild(classBody);
		_getStringHelloClassChild(classBody);
		_setStringHelloClassChild(classBody);
		_getName(classBody);
		_isAgeBoolean(classBody);
		_getAgeChar(classBody);
		_getAgeByte(classBody);
		_getAgeShort(classBody);
		_getAgeInt(classBody);
		_getAgeLong(classBody);
		_getAgeFloat(classBody);
		_getAgeDouble(classBody);
		_getAgeBoolean2(classBody);
		_getAgeCharacter(classBody);
		_getAgeByte2(classBody);
		_getAgeShort2(classBody);
		_getAgeInteger(classBody);
		_getAgeLong2(classBody);
		_getAgeFloat2(classBody);
		_getAgeDouble2(classBody);
		_setName(classBody);
		_setAgeBoolean(classBody);
		_setAgeChar(classBody);
		_setAgeByte(classBody);
		_setAgeShort(classBody);
		_setAgeInt(classBody);
		_setAgeLong(classBody);
		_setAgeFloat(classBody);
		_setAgeDouble(classBody);
		_setAgeBoolean2(classBody);
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
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _getIntHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getIntHelloClassChild")
			.return_(int.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("intHelloClassChild");
		code.RETURNTop();

		code.END();
	}

	protected void _setIntHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setIntHelloClassChild")
			.parameter("intHelloClassChild",int.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("intHelloClassChild");
		code.PUTFIELD_OF_THIS("intHelloClassChild");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getStringHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getStringHelloClassChild")
			.return_(String.class ).begin();

		code.LINE();
		code.LOAD("this");
		code.GETFIELD_OF_THIS("stringHelloClassChild");
		code.RETURNTop();

		code.END();
	}

	protected void _setStringHelloClassChild(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setStringHelloClassChild")
			.parameter("stringHelloClassChild",String.class).begin();

		code.LINE();
		code.LOAD("this");
		code.LOAD("stringHelloClassChild");
		code.PUTFIELD_OF_THIS("stringHelloClassChild");

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getName(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getName")
			.return_(String.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _isAgeBoolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("isAgeBoolean")
			.return_(boolean.class ).begin();

		code.LINE();
		code.LOADConst(0);
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeChar(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeChar")
			.return_(char.class ).begin();

		code.LINE();
		code.LOADConst(0);
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeByte(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeByte")
			.return_(byte.class ).begin();

		code.LINE();
		code.LOADConst(0);
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeShort(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeShort")
			.return_(short.class ).begin();

		code.LINE();
		code.LOADConst(0);
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeInt(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeInt")
			.return_(int.class ).begin();

		code.LINE();
		code.LOADConst(0);
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeLong(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeLong")
			.return_(long.class ).begin();

		code.LINE();
		code.LOADConst(0L);
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeFloat(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeFloat")
			.return_(float.class ).begin();

		code.LINE();
		code.LOADConst(0F);
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeDouble(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeDouble")
			.return_(double.class ).begin();

		code.LINE();
		code.LOADConst(0D);
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeBoolean2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeBoolean2")
			.return_(Boolean.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeCharacter(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeCharacter")
			.return_(Character.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeByte2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeByte2")
			.return_(Byte.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeShort2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeShort2")
			.return_(Short.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeInteger(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeInteger")
			.return_(Integer.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeLong2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeLong2")
			.return_(Long.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeFloat2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeFloat2")
			.return_(Float.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _getAgeDouble2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAgeDouble2")
			.return_(Double.class ).begin();

		code.LINE();
		code.LOADConstNULL();
		code.RETURNTop();

		code.END();
	}

	protected void _setName(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setName")
			.parameter("name",String.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeBoolean(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeBoolean")
			.parameter("ageBoolean",boolean.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeChar(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeChar")
			.parameter("ageChar",char.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeByte(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeByte")
			.parameter("ageByte",byte.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeShort(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeShort")
			.parameter("ageShort",short.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeInt(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeInt")
			.parameter("ageInt",int.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeLong(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeLong")
			.parameter("ageLong",long.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeFloat(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeFloat")
			.parameter("ageFloat",float.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeDouble(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeDouble")
			.parameter("ageDouble",double.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeBoolean2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeBoolean2")
			.parameter("ageBoolean2",Boolean.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeCharacter(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeCharacter")
			.parameter("ageCharacter",Character.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeByte2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeByte2")
			.parameter("ageByte2",Byte.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeShort2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeShort2")
			.parameter("ageShort2",Short.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeInteger(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeInteger")
			.parameter("ageInteger",Integer.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeLong2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeLong2")
			.parameter("ageLong2",Long.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeFloat2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeFloat2")
			.parameter("agefFloat",Float.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _setAgeDouble2(ClassBody classBody) {
		MethodCode code = classBody.public_().method("setAgeDouble2")
			.parameter("ageDouble2",Double.class).begin();

		code.LINE();
		code.RETURN();

		code.END();
	}

}
