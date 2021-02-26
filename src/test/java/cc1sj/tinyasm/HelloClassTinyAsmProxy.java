package cc1sj.tinyasm;

import static cc1sj.tinyasm.TinyAsmBuilder.refer;
import static cc1sj.tinyasm.TinyAsmBuilder.resolve;

import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.TinyAsmProxyRuntimeReferNameObject;
import cc1sj.tinyasm.hero.helperclass.HelloClass;

public class HelloClassTinyAsmProxy extends HelloClass implements TinyAsmProxyRuntimeReferNameObject {

	private String _referName;
	private TinyAsmBuilderContext _context;
	private MethodCode _code;

	@Override
	public String get__ReferName() {
		return this._referName;
	}

	@Override
	public void __init(TinyAsmBuilderContext context, String name) {
		this._context = context;
		this._code = context.code;
		this._referName = name;
	}

	@Override
	public String getName() {
		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getName").reTurn(String.class).INVOKE();
		return refer(_code, String.class);
	}

	@Override
	public char getAgeChar() {
		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeChar").reTurn(char.class).INVOKE();
		return refer(_code, char.class);
	}

	@Override
	public byte getAgeByte() {
		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeByte").reTurn(byte.class).INVOKE();
		return refer(_code, byte.class);
	}

	@Override
	public short getAgeShort() {
		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeShort").reTurn(short.class).INVOKE();
		return refer(_code, short.class);
	}

	@Override
	public int getAgeInt() {
		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeInt").reTurn(int.class).INVOKE();
		return refer(_code, int.class);
	}

	@Override
	public long getAgeLong() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeLong").reTurn(long.class).INVOKE();
		return refer(_code, long.class);
	}

	@Override
	public float getAgeFloat() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeFloat").reTurn(float.class).INVOKE();
		return refer(_code, float.class);
	}

	@Override
	public double getAgeDouble() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeDouble").reTurn(double.class).INVOKE();
		return refer(_code, double.class);
	}

	@Override
	public Character getAgeCharacter() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeCharacter").reTurn(Character.class).INVOKE();
		return refer(_code, Character.class);
	}

	@Override
	public Byte getAgeByte2() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeByte2").reTurn(Byte.class).INVOKE();
		return refer(_code, Byte.class);
	}

	@Override
	public Short getAgeShort2() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeShort2").reTurn(Short.class).INVOKE();
		return refer(_code, Short.class);
	}

	@Override
	public Integer getAgeInteger() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeInteger").reTurn(Integer.class).INVOKE();
		return refer(_code, Integer.class);
	}

	@Override
	public Long getAgeLong2() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeLong2").reTurn(Long.class).INVOKE();
		return refer(_code, Long.class);
	}

	@Override
	public Float getAgeFloat2() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeFloat2").reTurn(Float.class).INVOKE();
		return refer(_code, Float.class);
	}

	@Override
	public Double getAgeDouble2() {

		_code.LINE();
		resolve(_code, this._referName);
		_code.VIRTUAL(HelloClass.class, "getAgeDouble2").reTurn(Double.class).INVOKE();
		return refer(_code, Double.class);
	}

	@Override
	public void setName(String value) {
		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setName").parameter(String.class).INVOKE();
	}

	@Override
	public void setAgeChar(char value) {
		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeChar").parameter(char.class).INVOKE();
	}

	@Override
	public void setAgeByte(byte value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeByte").parameter(byte.class).INVOKE();
	}

	@Override
	public void setAgeShort(short value) {
		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeShort").parameter(short.class).INVOKE();
	}

	@Override
	public void setAgeInt(int value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeInt").parameter(int.class).INVOKE();
	}

	@Override
	public void setAgeLong(long value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeLong").parameter(long.class).INVOKE();
	}

	@Override
	public void setAgeFloat(float value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeFloat").parameter(float.class).INVOKE();
	}

	@Override
	public void setAgeDouble(double value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeDouble").parameter(double.class).INVOKE();
	}

	@Override
	public void setAgeCharacter(Character value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeCharacter").parameter(Character.class).INVOKE();
	}

	@Override
	public void setAgeByte2(Byte value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeByte2").parameter(Byte.class).INVOKE();
	}

	@Override
	public void setAgeShort2(Short value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeShort2").parameter(Short.class).INVOKE();
	}

	@Override
	public void setAgeInteger(Integer value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeInteger").parameter(Integer.class).INVOKE();
	}

	@Override
	public void setAgeLong2(Long value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeLong2").parameter(Long.class).INVOKE();
	}

	@Override
	public void setAgeFloat2(Float value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeFloat2").parameter(Float.class).INVOKE();
	}

	@Override
	public void setAgeDouble2(Double value) {

		_code.LINE();
		resolve(_code, this._referName);
		resolve(_code, value);
		_code.VIRTUAL(HelloClass.class, "setAgeDouble2").parameter(Double.class).INVOKE();
	}

}
