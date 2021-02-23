package cc1sj.tinyasm.util;

public class PojoSample {
	private int i1;
	private int i2;
	private int i3;
	private int i4;
	private String str;
	public PojoSample(int i1, int i2, int i3, int i4, String str) {
		super();
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
		this.str = str;
	}
	public int getI1() {
		return i1;
	}
	public void setI1(int i1) {
		this.i1 = i1;
	}
	public int getI2() {
		return i2;
	}
	public void setI2(int i2) {
		this.i2 = i2;
	}
	public int getI3() {
		return i3;
	}
	public void setI3(int i3) {
		this.i3 = i3;
	}
	public int getI4() {
		return i4;
	}
	public void setI4(int i4) {
		this.i4 = i4;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pojo [i1=").append(i1)
			.append(", i2=").append(i2)
			.append(", i3=").append(i3)
			.append(", i4=").append(i4)
			.append(", str=").append(str)
			.append("]");
		return builder.toString();
	}

	
}
