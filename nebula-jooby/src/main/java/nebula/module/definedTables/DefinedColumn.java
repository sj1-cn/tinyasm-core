package nebula.module.definedTables;

public class DefinedColumn {

	private String columnName;
	private int dataType;
	private String typeName;
	private int size;
	private int decimalDigits;
	private boolean isNullable;
	private boolean isAutoIncrment;

	public String getColumnName() {
		return columnName;
	}

	public int getDataType() {
		return dataType;
	}

	public int getSize() {
		return size;
	}

	public int getDecimalDigits() {
		return decimalDigits;
	}

	public boolean isNullable() {
		return isNullable;
	}

	public boolean isAutoIncrment() {
		return isAutoIncrment;
	}

	public DefinedColumn(String columnName, int dataType, String typeName, int size, int decimalDigits, boolean isNullable,
			boolean isAutoIncrment) {
		super();
		this.columnName = columnName;
		this.dataType = dataType;
		this.typeName = typeName;
		this.size = size;
		this.decimalDigits = decimalDigits;
		this.isNullable = isNullable;
		this.isAutoIncrment = isAutoIncrment;
	}

	public String getTypeName() {
		return typeName;
	}

}
