package cc1sj.tinyasm.advasmproxy.simple;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;
import static cc1sj.tinyasm.Adv.MAGIC_CODES_String;

import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.Clazz;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;

public class PojoInterfaceSampleAdvAsmProxy implements PojoInterfaceSample, AdvRuntimeReferNameObject {
	private byte _magicNumber;
	private ThreadLocal<AdvContext> _contextThreadLocal;

	@Override
	public byte get__MagicNumber() {
		return this._magicNumber;
	}

	@Override
	public void set__MagicNumber(byte _magicNumber) {
		this._magicNumber = _magicNumber;
	}

	@Override
	public void set__Context(ThreadLocal<AdvContext> _contextThreadLocal, byte _magicNumber) {
		this._contextThreadLocal = _contextThreadLocal;
		this._magicNumber = _magicNumber;
	}

	@Override
	public Clazz get__TargetClazz() {
		return Clazz.of(PojoInterfaceSample.class);
	}

	@Override
	public String getName() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(String.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getName").return_(String.class).INVOKE();
		});
		return new StringBuilder( MAGIC_CODES_String).append(codeIndex).toString(); // String.class);
	}

	@Override
	public boolean isAgeBoolean() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(boolean.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "isAgeBoolean").return_(boolean.class).INVOKE();
		});
		return false;
	}

	@Override
	public byte getAgeByte() {
	
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(byte.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeByte").return_(byte.class).INVOKE();
		});
		return (byte) (MAGIC_CODES_NUMBER + codeIndex); // byte.class);
	}

	@Override
	public char getAgeChar() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(char.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeChar").return_(char.class).INVOKE();
		});
		return (char) (MAGIC_CODES_NUMBER + codeIndex);// char.class);
	}

	@Override
	public short getAgeShort() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(short.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeShort").return_(short.class).INVOKE();
		});
		return (short) (MAGIC_CODES_NUMBER + codeIndex); // short.class);
	}

	@Override
	public int getAgeInt() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeInt").return_(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public long getAgeLong() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(long.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeLong").return_(long.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // long.class);
	}

	@Override
	public float getAgeFloat() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(float.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeFloat").return_(float.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // float.class);
	}

	@Override
	public double getAgeDouble() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(double.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeDouble").return_(double.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // double.class);
	}

	@Override
	public Boolean getAgeBoolean2() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(Boolean.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeBoolean2").return_(Boolean.class).INVOKE();
		});
		return false;
	}

	@Override
	public Byte getAgeByte2() {
	
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Byte.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeByte2").return_(Byte.class).INVOKE();
		});
		return (byte) (MAGIC_CODES_NUMBER + codeIndex); // Byte.class);
	}

	@Override
	public Character getAgeCharacter() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Character.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeCharacter").return_(Character.class).INVOKE();
		});
		return (char) (MAGIC_CODES_NUMBER + codeIndex); // Character.class);
	}

	@Override
	public Short getAgeShort2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Short.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeShort2").return_(Short.class).INVOKE();
		});
		return (short) (MAGIC_CODES_NUMBER + codeIndex);// Short.class);
	}

	@Override
	public Integer getAgeInteger() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Integer.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeInteger").return_(Integer.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // Integer.class);
	}

	@Override
	public Long getAgeLong2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Long.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeLong2").return_(Long.class).INVOKE();
		});
		return (long) (MAGIC_CODES_NUMBER + codeIndex);// Long.class);
	}

	@Override
	public Float getAgeFloat2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Float.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeFloat2").return_(Float.class).INVOKE();
		});
		return (float) (MAGIC_CODES_NUMBER + codeIndex); // Float.class);
	}

	@Override
	public Double getAgeDouble2() {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Double.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PojoInterfaceSample.class, "getAgeDouble2").return_(Double.class).INVOKE();
		});
		return (double) (MAGIC_CODES_NUMBER + codeIndex); // Double.class);
	}

	@Override
	public void setName(String param0) {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setName").parameter(String.class).INVOKE();
		});
	}

	@Override
	public void setAgeBoolean(boolean param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.getCodeAndPop();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeBoolean").parameter(boolean.class).INVOKE();
		});
	}

	@Override
	public void setAgeByte(byte param0) {
	
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
	
			c.INTERFACE(PojoInterfaceSample.class, "setAgeByte").parameter(byte.class).INVOKE();
		});
	
	}

	@Override
	public void setAgeChar(char param0) {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeChar").parameter(char.class).INVOKE();
		});
	}

	@Override
	public void setAgeShort(short param0) {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeShort").parameter(short.class).INVOKE();
		});

	}

	@Override
	public void setAgeInt(int param0) {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeInt").parameter(int.class).INVOKE();
		});

	}

	@Override
	public void setAgeLong(long param0) {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeLong").parameter(long.class).INVOKE();
		});

	}

	@Override
	public void setAgeFloat(float param0) {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeFloat").parameter(float.class).INVOKE();
		});

	}

	@Override
	public void setAgeDouble(double param0) {

		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeDouble").parameter(double.class).INVOKE();
		});

	}

	@Override
	public void setAgeBoolean2(Boolean param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.getCodeAndPop();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeBoolean2").parameter(Boolean.class).INVOKE();
		});

	}

	@Override
	public void setAgeByte2(Byte param0) {
	
		AdvContext context = _contextThreadLocal.get();
	
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
	
			c.INTERFACE(PojoInterfaceSample.class, "setAgeByte2").parameter(Byte.class).INVOKE();
		});
	
	}

	@Override
	public void setAgeCharacter(Character param0) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeCharacter").parameter(Character.class).INVOKE();
		});

	}

	@Override
	public void setAgeShort2(Short param0) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeShort2").parameter(Short.class).INVOKE();
		});

	}

	@Override
	public void setAgeInteger(Integer param0) {
		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeInteger").parameter(Integer.class).INVOKE();
		});

	}

	@Override
	public void setAgeLong2(Long param0) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeLong2").parameter(Long.class).INVOKE();
		});

	}

	@Override
	public void setAgeFloat2(Float param0) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeFloat2").parameter(Float.class).INVOKE();
		});

	}

	@Override
	public void setAgeDouble2(Double param0) {

		AdvContext context = _contextThreadLocal.get();

		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);

			c.INTERFACE(PojoInterfaceSample.class, "setAgeDouble2").parameter(Double.class).INVOKE();
		});

	}

}