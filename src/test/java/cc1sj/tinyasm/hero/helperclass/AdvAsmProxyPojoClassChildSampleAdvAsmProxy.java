package cc1sj.tinyasm.hero.helperclass;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;
import static cc1sj.tinyasm.Adv.MAGIC_CODES_String;

import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;

public class AdvAsmProxyPojoClassChildSampleAdvAsmProxy extends AdvAsmProxyPojoClassChildSample implements AdvRuntimeReferNameObject {

	private byte _magicNumber;
	private ThreadLocal<AdvContext> _contextThreadLocal;

	@Override
	public byte get__MagicNumber() {
		return this._magicNumber;
	}

	@Override
	public void set__MagicNumber(byte magicNumber) {
		this._magicNumber = magicNumber;
	}

	@Override
	public void set__Context(ThreadLocal<AdvContext> _contextThreadLocal, byte magicNumber) {
		this._contextThreadLocal = _contextThreadLocal;
		this._magicNumber = magicNumber;
	}

	@Override
	public int getIntHelloClassChild() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);

		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getIntHelloClassChild").reTurn(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // String.class);
	}

	@Override
	public void setIntHelloClassChild(int value) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);

		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setIntHelloClassChild").parameter(int.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public String getStringHelloClassChild() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getStringHelloClassChild").reTurn(String.class).INVOKE();
		});
		return new StringBuilder(MAGIC_CODES_String).append(codeIndex).toString(); // String.class);
	}

	@Override
	public void setStringHelloClassChild(String value) {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setStringHelloClassChild").parameter(String.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setTwoParameter(int param1, byte param2) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_2 = context.resolve(param2);
		ConsumerWithException<MethodCode> eval_1 = context.resolve(param1);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			eval_1.accept(c);
			eval_2.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setTwoParameter").parameter(int.class).parameter(byte.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public String getName() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getName").reTurn(String.class).INVOKE();
		});
		return new StringBuilder(MAGIC_CODES_String).append(codeIndex).toString(); // String.class);
	}

	@Override
	public boolean isAgeBoolean() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "isAgeBoolean").reTurn(boolean.class).INVOKE();
		});
		return false;
	}

	@Override
	public char getAgeChar() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeChar").reTurn(char.class).INVOKE();
		});
		return (char) (MAGIC_CODES_NUMBER + codeIndex);// char.class);
	}

	@Override
	public byte getAgeByte() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeByte").reTurn(byte.class).INVOKE();
		});
		return (byte) (MAGIC_CODES_NUMBER + codeIndex); // byte.class);
	}

	@Override
	public short getAgeShort() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeShort").reTurn(short.class).INVOKE();
		});
		return (short) (MAGIC_CODES_NUMBER + codeIndex); // short.class);
	}

	@Override
	public int getAgeInt() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeInt").reTurn(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public long getAgeLong() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeLong").reTurn(long.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // long.class);
	}

	@Override
	public float getAgeFloat() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeFloat").reTurn(float.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // float.class);
	}

	@Override
	public double getAgeDouble() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeDouble").reTurn(double.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // double.class);
	}

	@Override
	public Boolean getAgeBoolean2() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeBoolean2").reTurn(Boolean.class).INVOKE();
		});
		return false;
	}

	@Override
	public Character getAgeCharacter() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeCharacter").reTurn(Character.class).INVOKE();
		});
		return (char) (MAGIC_CODES_NUMBER + codeIndex); // Character.class);
	}

	@Override
	public Byte getAgeByte2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeByte2").reTurn(Byte.class).INVOKE();
		});
		return (byte) (MAGIC_CODES_NUMBER + codeIndex); // Byte.class);
	}

	@Override
	public Short getAgeShort2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeShort2").reTurn(Short.class).INVOKE();
		});
		return (short) (MAGIC_CODES_NUMBER + codeIndex);// Short.class);
	}

	@Override
	public Integer getAgeInteger() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeInteger").reTurn(Integer.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // Integer.class);
	}

	@Override
	public Long getAgeLong2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeLong2").reTurn(Long.class).INVOKE();
		});
		return (long) (MAGIC_CODES_NUMBER + codeIndex);// Long.class);
	}

	@Override
	public Float getAgeFloat2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeFloat2").reTurn(Float.class).INVOKE();
		});
		return (float) (MAGIC_CODES_NUMBER + codeIndex); // Float.class);
	}

	@Override
	public Double getAgeDouble2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(c -> {
			objEval.accept(c);
			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "getAgeDouble2").reTurn(Double.class).INVOKE();
		});
		return (double) (MAGIC_CODES_NUMBER + codeIndex); // Double.class);
	}

	@Override
	public void setName(String value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setName").parameter(String.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeBoolean(boolean value) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objValue = context.getCodeAndPop();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeBoolean").parameter(boolean.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeChar(char value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeChar").parameter(char.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeByte(byte value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeByte").parameter(byte.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeShort(short value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeShort").parameter(short.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeInt(int value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeInt").parameter(int.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeLong(long value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeLong").parameter(long.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeFloat(float value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeFloat").parameter(float.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeDouble(double value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeDouble").parameter(double.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeBoolean2(Boolean value) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objValue = context.getCodeAndPop();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeBoolean2").parameter(Boolean.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeCharacter(Character value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeCharacter").parameter(Character.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeByte2(Byte value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeByte2").parameter(Byte.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeShort2(Short value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeShort2").parameter(Short.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeInteger(Integer value) {
		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeInteger").parameter(Integer.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeLong2(Long value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeLong2").parameter(Long.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeFloat2(Float value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeFloat2").parameter(Float.class).INVOKE();
		});
		context.popAndExec();
	}

	@Override
	public void setAgeDouble2(Double value) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> objValue = context.resolve(value);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(c -> {
			objEval.accept(c);
			objValue.accept(c);

			c.VIRTUAL(AdvAsmProxyPojoClassChildSample.class, "setAgeDouble2").parameter(Double.class).INVOKE();
		});
		context.popAndExec();
	}

}
