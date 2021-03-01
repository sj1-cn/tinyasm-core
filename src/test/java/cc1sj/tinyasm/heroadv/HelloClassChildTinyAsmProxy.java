package cc1sj.tinyasm.heroadv;

import static cc1sj.tinyasm.TinyAsmBuilder.*;
import static cc1sj.tinyasm.TinyAsmBuilder.storeTopAndRefer;
import static cc1sj.tinyasm.heroadv.Adv.MAGIC_CODES_MAX;
import static cc1sj.tinyasm.heroadv.Adv.MAGIC_CODES_NUMBER;
import static cc1sj.tinyasm.heroadv.Adv.MAGIC_CODES_String;
import static cc1sj.tinyasm.heroadv.Adv.MAGIC_LOCALS_MAX;
import static cc1sj.tinyasm.heroadv.Adv.MAGIC_LOCALS_NUMBER;

import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.TinyAsmBuilderContext;
import cc1sj.tinyasm.TinyAsmProxyRuntimeReferNameObject;
import cc1sj.tinyasm.hero.helperclass.HelloClass;
import cc1sj.tinyasm.hero.helperclass.HelloClassChild;

public class HelloClassChildTinyAsmProxy extends HelloClassChild implements AdvRuntimeReferNameObject {

	private byte _magicNumber;
	private ThreadLocal<AdvContext> _context;

	@Override
	public byte get__MagicNumber() {
		return this._magicNumber;
	}

	@Override
	public void set__MagicNumber(byte magicNumber) {
		this._magicNumber = magicNumber;
	}

	@Override
	public void set__Context(ThreadLocal<AdvContext> context, byte magicNumber) {
		this._context = context;
		this._magicNumber = magicNumber;
	}

	@Override
	public int getIntHelloClassChild() {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);

		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getIntHelloClassChild").reTurn(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // String.class);
	}

	@Override
	public void setIntHelloClassChild(int value) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);
			c.VIRTUAL(HelloClassChild.class, "setIntHelloClassChild").parameter(int.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public String getStringHelloClassChild() {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getStringHelloClassChild").reTurn(String.class).INVOKE();
		});
		return MAGIC_CODES_String + codeIndex; // String.class);
	}

	@Override
	public void setStringHelloClassChild(String value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setStringHelloClassChild").parameter(String.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setTwoParameter(int param1, byte param2) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> eval_1 = context.resolve(param1);
		ConsumerWithException<MethodCode> eval_2 = context.resolve(param2);
		context.push(c -> {
			objEval.accept(c);
			eval_1.accept(c);
			eval_2.accept(c);
			c.VIRTUAL(HelloClassChild.class, "setTwoParameter").parameter(int.class).parameter(byte.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public String getName() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getName").reTurn(String.class).INVOKE();
		});
		return MAGIC_CODES_String + codeIndex; // String.class);
	}

	@Override
	public char getAgeChar() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeChar").reTurn(char.class).INVOKE();
		});
		return (char) (MAGIC_CODES_NUMBER + codeIndex);// char.class);
	}

	@Override
	public byte getAgeByte() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeByte").reTurn(byte.class).INVOKE();
		});
		return (byte) (MAGIC_CODES_NUMBER + codeIndex); // byte.class);
	}

	@Override
	public short getAgeShort() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeShort").reTurn(short.class).INVOKE();
		});
		return (short) (MAGIC_CODES_NUMBER + codeIndex); // short.class);
	}

	@Override
	public int getAgeInt() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeInt").reTurn(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public long getAgeLong() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeLong").reTurn(long.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // long.class);
	}

	@Override
	public float getAgeFloat() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeFloat").reTurn(float.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // float.class);
	}

	@Override
	public double getAgeDouble() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeDouble").reTurn(double.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // double.class);
	}

	@Override
	public Character getAgeCharacter() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeCharacter").reTurn(Character.class).INVOKE();
		});
		return (char) (MAGIC_CODES_NUMBER + codeIndex); // Character.class);
	}

	@Override
	public Byte getAgeByte2() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeByte2").reTurn(Byte.class).INVOKE();
		});
		return (byte) (MAGIC_CODES_NUMBER + codeIndex); // Byte.class);
	}

	@Override
	public Short getAgeShort2() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeShort2").reTurn(Short.class).INVOKE();
		});
		return (short) (MAGIC_CODES_NUMBER + codeIndex);// Short.class);
	}

	@Override
	public Integer getAgeInteger() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeInteger").reTurn(Integer.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // Integer.class);
	}

	@Override
	public Long getAgeLong2() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeLong2").reTurn(Long.class).INVOKE();
		});
		return (long) (MAGIC_CODES_NUMBER + codeIndex);// Long.class);
	}

	@Override
	public Float getAgeFloat2() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeFloat2").reTurn(Float.class).INVOKE();
		});
		return (float) (MAGIC_CODES_NUMBER + codeIndex); // Float.class);
	}

	@Override
	public Double getAgeDouble2() {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(HelloClassChild.class, "getAgeDouble2").reTurn(Double.class).INVOKE();
		});
		return (double) (MAGIC_CODES_NUMBER + codeIndex); // Double.class);
	}

	@Override
	public void setName(String value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setName").parameter(String.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeChar(char value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeChar").parameter(char.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeByte(byte value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeByte").parameter(byte.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeShort(short value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeShort").parameter(short.class).INVOKE();
		});
		context.execAndPop();
	}

//	@Override
//	public void setAgeInt(int value) {
//		AdvContext context = _context.get();ConsumerWithException<MethodCode> objEval = context.resolve(this);ConsumerWithException<MethodCode> objValue = context.resolve(value);context.push(c -> {objEval.accept(c);objValue.accept(c);
//			c.VIRTUAL(HelloClassChild.class, "setAgeInt").parameter(int.class).INVOKE();});context.execAndPop();
//
//	}

	@Override
	public void setAgeInt(int value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeInt").parameter(int.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeLong(long value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeLong").parameter(long.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeFloat(float value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeFloat").parameter(float.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeDouble(double value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeDouble").parameter(double.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeCharacter(Character value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeCharacter").parameter(Character.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeByte2(Byte value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeByte2").parameter(Byte.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeShort2(Short value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeShort2").parameter(Short.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeInteger(Integer value) {
		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeInteger").parameter(Integer.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeLong2(Long value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeLong2").parameter(Long.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeFloat2(Float value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeFloat2").parameter(Float.class).INVOKE();
		});
		context.execAndPop();
	}

	@Override
	public void setAgeDouble2(Double value) {

		AdvContext context = _context.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(HelloClassChild.class, "setAgeDouble2").parameter(Double.class).INVOKE();
		});
		context.execAndPop();
	}

}
