package cn.sj1.tinyasm.core.sample.MethodCode;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;

import cn.sj1.tinyasm.core.Annotation;
import cn.sj1.tinyasm.core.ClassBody;
import cn.sj1.tinyasm.core.ClassBuilder;
import cn.sj1.tinyasm.core.Clazz;
import cn.sj1.tinyasm.core.MethodCode;

@SuppressWarnings("unused")
public class MethodCodeLoadConstSampleTinyAsmDump {

	public static byte[] dump() {
		return new MethodCodeLoadConstSampleTinyAsmDump().build("cn.sj1.tinyasm.core.sample.MethodCode.MethodCodeLoadConstSample");
	}

	public byte[] build(String className)  {
		ClassBody classBody = ClassBuilder.class_(className)
				.access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_getAll(classBody);
		_getShortMIN_VALUE(classBody);
		_getShortMAX_VALUE(classBody);
		_getByteMIN_VALUE(classBody);
		_getByteMAX_VALUE(classBody);

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

	protected void _getAll(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getAll").begin();

		code.LINE();
		code.LOADConst(-20);
		code.STORE("i1", int.class);

		code.LINE();
		code.LOADConst(-19);
		code.STORE("i2", int.class);

		code.LINE();
		code.LOADConst(-18);
		code.STORE("i3", int.class);

		code.LINE();
		code.LOADConst(-17);
		code.STORE("i4", int.class);

		code.LINE();
		code.LOADConst(-16);
		code.STORE("i5", int.class);

		code.LINE();
		code.LOADConst(-15);
		code.STORE("i6", int.class);

		code.LINE();
		code.LOADConst(-14);
		code.STORE("i7", int.class);

		code.LINE();
		code.LOADConst(-13);
		code.STORE("i8", int.class);

		code.LINE();
		code.LOADConst(-12);
		code.STORE("i9", int.class);

		code.LINE();
		code.LOADConst(-11);
		code.STORE("i10", int.class);

		code.LINE();
		code.LOADConst(-10);
		code.STORE("i11", int.class);

		code.LINE();
		code.LOADConst(-9);
		code.STORE("i12", int.class);

		code.LINE();
		code.LOADConst(-8);
		code.STORE("i13", int.class);

		code.LINE();
		code.LOADConst(-7);
		code.STORE("i14", int.class);

		code.LINE();
		code.LOADConst(-6);
		code.STORE("i15", int.class);

		code.LINE();
		code.LOADConst(-5);
		code.STORE("i16", int.class);

		code.LINE();
		code.LOADConst(-4);
		code.STORE("i25", int.class);

		code.LINE();
		code.LOADConst(-3);
		code.STORE("i26", int.class);

		code.LINE();
		code.LOADConst(-2);
		code.STORE("i27", int.class);

		code.LINE();
		code.LOADConst(-1);
		code.STORE("i28", int.class);

		code.LINE();
		code.LOADConst(0);
		code.STORE("i29", int.class);

		code.LINE();
		code.LOADConst(1);
		code.STORE("i30", int.class);

		code.LINE();
		code.LOADConst(2);
		code.STORE("i31", int.class);

		code.LINE();
		code.LOADConst(3);
		code.STORE("i32", int.class);

		code.LINE();
		code.LOADConst(4);
		code.STORE("i33", int.class);

		code.LINE();
		code.LOADConst(5);
		code.STORE("i34", int.class);

		code.LINE();
		code.LOADConst(6);
		code.STORE("i35", int.class);

		code.LINE();
		code.LOADConst(7);
		code.STORE("i36", int.class);

		code.LINE();
		code.LOADConst(8);
		code.STORE("i37", int.class);

		code.LINE();
		code.LOADConst(9);
		code.STORE("i38", int.class);

		code.LINE();
		code.LOADConst(10);
		code.STORE("i39", int.class);

		code.LINE();
		code.LOADConst(11);
		code.STORE("i40", int.class);

		code.LINE();
		code.LOADConst(12);
		code.STORE("i41", int.class);

		code.LINE();
		code.LOADConst(13);
		code.STORE("i42", int.class);

		code.LINE();
		code.LOADConst(14);
		code.STORE("i43", int.class);

		code.LINE();
		code.LOADConst(15);
		code.STORE("i44", int.class);

		code.LINE();
		code.LOADConst(16);
		code.STORE("i45", int.class);

		code.LINE();
		code.LOADConst(17);
		code.STORE("i46", int.class);

		code.LINE();
		code.LOADConst(18);
		code.STORE("i47", int.class);

		code.LINE();
		code.LOADConst(19);
		code.STORE("i48", int.class);

		code.LINE();
		code.LOADConst(20);
		code.STORE("i49", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getShortMIN_VALUE(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getShortMIN_VALUE").begin();

		code.LINE();
		code.LOADConst(Integer.valueOf(-32788));
		code.STORE("i1", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32787));
		code.STORE("i2", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32786));
		code.STORE("i3", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32785));
		code.STORE("i4", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32784));
		code.STORE("i5", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32783));
		code.STORE("i6", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32782));
		code.STORE("i7", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32781));
		code.STORE("i8", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32780));
		code.STORE("i9", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32779));
		code.STORE("i10", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32778));
		code.STORE("i11", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32777));
		code.STORE("i12", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32776));
		code.STORE("i13", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32775));
		code.STORE("i14", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32774));
		code.STORE("i15", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32773));
		code.STORE("i16", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32772));
		code.STORE("i25", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32771));
		code.STORE("i26", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32770));
		code.STORE("i27", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(-32769));
		code.STORE("i28", int.class);

		code.LINE();
		code.LOADConst(-32768);
		code.STORE("i29", int.class);

		code.LINE();
		code.LOADConst(-32767);
		code.STORE("i30", int.class);

		code.LINE();
		code.LOADConst(-32766);
		code.STORE("i31", int.class);

		code.LINE();
		code.LOADConst(-32765);
		code.STORE("i32", int.class);

		code.LINE();
		code.LOADConst(-32764);
		code.STORE("i33", int.class);

		code.LINE();
		code.LOADConst(-32763);
		code.STORE("i34", int.class);

		code.LINE();
		code.LOADConst(-32762);
		code.STORE("i35", int.class);

		code.LINE();
		code.LOADConst(-32761);
		code.STORE("i36", int.class);

		code.LINE();
		code.LOADConst(-32760);
		code.STORE("i37", int.class);

		code.LINE();
		code.LOADConst(-32759);
		code.STORE("i38", int.class);

		code.LINE();
		code.LOADConst(-32758);
		code.STORE("i39", int.class);

		code.LINE();
		code.LOADConst(-32757);
		code.STORE("i40", int.class);

		code.LINE();
		code.LOADConst(-32756);
		code.STORE("i41", int.class);

		code.LINE();
		code.LOADConst(-32755);
		code.STORE("i42", int.class);

		code.LINE();
		code.LOADConst(-32754);
		code.STORE("i43", int.class);

		code.LINE();
		code.LOADConst(-32753);
		code.STORE("i44", int.class);

		code.LINE();
		code.LOADConst(-32752);
		code.STORE("i45", int.class);

		code.LINE();
		code.LOADConst(-32751);
		code.STORE("i46", int.class);

		code.LINE();
		code.LOADConst(-32750);
		code.STORE("i47", int.class);

		code.LINE();
		code.LOADConst(-32749);
		code.STORE("i48", int.class);

		code.LINE();
		code.LOADConst(-32748);
		code.STORE("i49", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getShortMAX_VALUE(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getShortMAX_VALUE").begin();

		code.LINE();
		code.LOADConst(32747);
		code.STORE("i1", int.class);

		code.LINE();
		code.LOADConst(32748);
		code.STORE("i2", int.class);

		code.LINE();
		code.LOADConst(32749);
		code.STORE("i3", int.class);

		code.LINE();
		code.LOADConst(32750);
		code.STORE("i4", int.class);

		code.LINE();
		code.LOADConst(32751);
		code.STORE("i5", int.class);

		code.LINE();
		code.LOADConst(32752);
		code.STORE("i6", int.class);

		code.LINE();
		code.LOADConst(32753);
		code.STORE("i7", int.class);

		code.LINE();
		code.LOADConst(32754);
		code.STORE("i8", int.class);

		code.LINE();
		code.LOADConst(32755);
		code.STORE("i9", int.class);

		code.LINE();
		code.LOADConst(32756);
		code.STORE("i10", int.class);

		code.LINE();
		code.LOADConst(32757);
		code.STORE("i11", int.class);

		code.LINE();
		code.LOADConst(32758);
		code.STORE("i12", int.class);

		code.LINE();
		code.LOADConst(32759);
		code.STORE("i13", int.class);

		code.LINE();
		code.LOADConst(32760);
		code.STORE("i14", int.class);

		code.LINE();
		code.LOADConst(32761);
		code.STORE("i15", int.class);

		code.LINE();
		code.LOADConst(32762);
		code.STORE("i16", int.class);

		code.LINE();
		code.LOADConst(32763);
		code.STORE("i25", int.class);

		code.LINE();
		code.LOADConst(32764);
		code.STORE("i26", int.class);

		code.LINE();
		code.LOADConst(32765);
		code.STORE("i27", int.class);

		code.LINE();
		code.LOADConst(32766);
		code.STORE("i28", int.class);

		code.LINE();
		code.LOADConst(32767);
		code.STORE("i29", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32768));
		code.STORE("i30", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32769));
		code.STORE("i31", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32770));
		code.STORE("i32", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32771));
		code.STORE("i33", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32772));
		code.STORE("i34", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32773));
		code.STORE("i35", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32774));
		code.STORE("i36", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32775));
		code.STORE("i37", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32776));
		code.STORE("i38", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32777));
		code.STORE("i39", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32778));
		code.STORE("i40", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32779));
		code.STORE("i41", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32780));
		code.STORE("i42", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32781));
		code.STORE("i43", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32782));
		code.STORE("i44", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32783));
		code.STORE("i45", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32784));
		code.STORE("i46", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32785));
		code.STORE("i47", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32786));
		code.STORE("i48", int.class);

		code.LINE();
		code.LOADConst(Integer.valueOf(32787));
		code.STORE("i49", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getByteMIN_VALUE(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getByteMIN_VALUE").begin();

		code.LINE();
		code.LOADConst(-148);
		code.STORE("i1", int.class);

		code.LINE();
		code.LOADConst(-147);
		code.STORE("i2", int.class);

		code.LINE();
		code.LOADConst(-146);
		code.STORE("i3", int.class);

		code.LINE();
		code.LOADConst(-145);
		code.STORE("i4", int.class);

		code.LINE();
		code.LOADConst(-144);
		code.STORE("i5", int.class);

		code.LINE();
		code.LOADConst(-143);
		code.STORE("i6", int.class);

		code.LINE();
		code.LOADConst(-142);
		code.STORE("i7", int.class);

		code.LINE();
		code.LOADConst(-141);
		code.STORE("i8", int.class);

		code.LINE();
		code.LOADConst(-140);
		code.STORE("i9", int.class);

		code.LINE();
		code.LOADConst(-139);
		code.STORE("i10", int.class);

		code.LINE();
		code.LOADConst(-138);
		code.STORE("i11", int.class);

		code.LINE();
		code.LOADConst(-137);
		code.STORE("i12", int.class);

		code.LINE();
		code.LOADConst(-136);
		code.STORE("i13", int.class);

		code.LINE();
		code.LOADConst(-135);
		code.STORE("i14", int.class);

		code.LINE();
		code.LOADConst(-134);
		code.STORE("i15", int.class);

		code.LINE();
		code.LOADConst(-133);
		code.STORE("i16", int.class);

		code.LINE();
		code.LOADConst(-132);
		code.STORE("i25", int.class);

		code.LINE();
		code.LOADConst(-131);
		code.STORE("i26", int.class);

		code.LINE();
		code.LOADConst(-130);
		code.STORE("i27", int.class);

		code.LINE();
		code.LOADConst(-129);
		code.STORE("i28", int.class);

		code.LINE();
		code.LOADConst(-128);
		code.STORE("i29", int.class);

		code.LINE();
		code.LOADConst(-127);
		code.STORE("i30", int.class);

		code.LINE();
		code.LOADConst(-126);
		code.STORE("i31", int.class);

		code.LINE();
		code.LOADConst(-125);
		code.STORE("i32", int.class);

		code.LINE();
		code.LOADConst(-124);
		code.STORE("i33", int.class);

		code.LINE();
		code.LOADConst(-123);
		code.STORE("i34", int.class);

		code.LINE();
		code.LOADConst(-122);
		code.STORE("i35", int.class);

		code.LINE();
		code.LOADConst(-121);
		code.STORE("i36", int.class);

		code.LINE();
		code.LOADConst(-120);
		code.STORE("i37", int.class);

		code.LINE();
		code.LOADConst(-119);
		code.STORE("i38", int.class);

		code.LINE();
		code.LOADConst(-118);
		code.STORE("i39", int.class);

		code.LINE();
		code.LOADConst(-117);
		code.STORE("i40", int.class);

		code.LINE();
		code.LOADConst(-116);
		code.STORE("i41", int.class);

		code.LINE();
		code.LOADConst(-115);
		code.STORE("i42", int.class);

		code.LINE();
		code.LOADConst(-114);
		code.STORE("i43", int.class);

		code.LINE();
		code.LOADConst(-113);
		code.STORE("i44", int.class);

		code.LINE();
		code.LOADConst(-112);
		code.STORE("i45", int.class);

		code.LINE();
		code.LOADConst(-111);
		code.STORE("i46", int.class);

		code.LINE();
		code.LOADConst(-110);
		code.STORE("i47", int.class);

		code.LINE();
		code.LOADConst(-109);
		code.STORE("i48", int.class);

		code.LINE();
		code.LOADConst(-108);
		code.STORE("i49", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

	protected void _getByteMAX_VALUE(ClassBody classBody) {
		MethodCode code = classBody.public_().method("getByteMAX_VALUE").begin();

		code.LINE();
		code.LOADConst(107);
		code.STORE("i1", int.class);

		code.LINE();
		code.LOADConst(108);
		code.STORE("i2", int.class);

		code.LINE();
		code.LOADConst(109);
		code.STORE("i3", int.class);

		code.LINE();
		code.LOADConst(110);
		code.STORE("i4", int.class);

		code.LINE();
		code.LOADConst(111);
		code.STORE("i5", int.class);

		code.LINE();
		code.LOADConst(112);
		code.STORE("i6", int.class);

		code.LINE();
		code.LOADConst(113);
		code.STORE("i7", int.class);

		code.LINE();
		code.LOADConst(114);
		code.STORE("i8", int.class);

		code.LINE();
		code.LOADConst(115);
		code.STORE("i9", int.class);

		code.LINE();
		code.LOADConst(116);
		code.STORE("i10", int.class);

		code.LINE();
		code.LOADConst(117);
		code.STORE("i11", int.class);

		code.LINE();
		code.LOADConst(118);
		code.STORE("i12", int.class);

		code.LINE();
		code.LOADConst(119);
		code.STORE("i13", int.class);

		code.LINE();
		code.LOADConst(120);
		code.STORE("i14", int.class);

		code.LINE();
		code.LOADConst(121);
		code.STORE("i15", int.class);

		code.LINE();
		code.LOADConst(122);
		code.STORE("i16", int.class);

		code.LINE();
		code.LOADConst(123);
		code.STORE("i25", int.class);

		code.LINE();
		code.LOADConst(124);
		code.STORE("i26", int.class);

		code.LINE();
		code.LOADConst(125);
		code.STORE("i27", int.class);

		code.LINE();
		code.LOADConst(126);
		code.STORE("i28", int.class);

		code.LINE();
		code.LOADConst(127);
		code.STORE("i29", int.class);

		code.LINE();
		code.LOADConst(128);
		code.STORE("i30", int.class);

		code.LINE();
		code.LOADConst(129);
		code.STORE("i31", int.class);

		code.LINE();
		code.LOADConst(130);
		code.STORE("i32", int.class);

		code.LINE();
		code.LOADConst(131);
		code.STORE("i33", int.class);

		code.LINE();
		code.LOADConst(132);
		code.STORE("i34", int.class);

		code.LINE();
		code.LOADConst(133);
		code.STORE("i35", int.class);

		code.LINE();
		code.LOADConst(134);
		code.STORE("i36", int.class);

		code.LINE();
		code.LOADConst(135);
		code.STORE("i37", int.class);

		code.LINE();
		code.LOADConst(136);
		code.STORE("i38", int.class);

		code.LINE();
		code.LOADConst(137);
		code.STORE("i39", int.class);

		code.LINE();
		code.LOADConst(138);
		code.STORE("i40", int.class);

		code.LINE();
		code.LOADConst(139);
		code.STORE("i41", int.class);

		code.LINE();
		code.LOADConst(140);
		code.STORE("i42", int.class);

		code.LINE();
		code.LOADConst(141);
		code.STORE("i43", int.class);

		code.LINE();
		code.LOADConst(142);
		code.STORE("i44", int.class);

		code.LINE();
		code.LOADConst(143);
		code.STORE("i45", int.class);

		code.LINE();
		code.LOADConst(144);
		code.STORE("i46", int.class);

		code.LINE();
		code.LOADConst(145);
		code.STORE("i47", int.class);

		code.LINE();
		code.LOADConst(146);
		code.STORE("i48", int.class);

		code.LINE();
		code.LOADConst(147);
		code.STORE("i49", int.class);

		code.LINE();
		code.RETURN();

		code.END();
	}

}
