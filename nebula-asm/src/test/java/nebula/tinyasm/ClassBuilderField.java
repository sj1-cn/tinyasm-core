package nebula.tinyasm;

public class ClassBuilderField {
	private byte b;
	private char c;
	private short s;
	private int i;
	private long l;
	private float f;
	private double d;
	private String str;

	public int getField() {
		int x = this.b + this.i;
		return x;
	}
}
