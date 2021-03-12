package cc1sj.tinyasm;

public interface AdvUsingField {

	public boolean_ field_boolean(String name);

	public Boolean__ field_Boolean(String name);

	public byte field_byte(String name);

	public short field_short(String name);

	public int field_int(String name);

	public long field_long(String name);

	public float field_float(String name);

	public double field_double(String name);

	public <T> T field(String name, Class<T> t);

}