package nebula.module.dbTable;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class DbColumn {
	public static class Mapper implements RowMapper<DbColumn> {
		@Override
		public DbColumn map(final ResultSet rs, final StatementContext ctx) throws SQLException {
			return new DbColumn(rs.getString("TABLE_CAT"),
					rs.getString("TABLE_SCHEM"),
					rs.getString("TABLE_NAME"),
					rs.getString("COLUMN_NAME"),
					rs.getInt("DATA_TYPE"),
					rs.getString("TYPE_NAME"),
					rs.getInt("COLUMN_SIZE"),
					rs.getInt("DECIMAL_DIGITS"),
					rs.getInt("NUM_PREC_RADIX"),
					rs.getInt("NULLABLE"),
					rs.getString("REMARKS"),
					rs.getString("COLUMN_DEF"),
					rs.getInt("CHAR_OCTET_LENGTH"),
					rs.getInt("ORDINAL_POSITION"),
					rs.getString("IS_NULLABLE"),
					rs.getString("SCOPE_CATALOG"),
					rs.getString("SCOPE_SCHEMA"),
					rs.getString("SCOPE_TABLE"),
					rs.getShort("SOURCE_DATA_TYPE"),
					rs.getString("IS_AUTOINCREMENT"));
		}
	}

	private String id;
	public String getId() {
		return id;
	}
	private String tableCatalog;
	private String tableSchema;
	private String tableName;
	private String columnName;
	private int dataType;
	private String typeName;
	private int columnSize;
	private int decimalDigits;
	private int numericPrecisionRadix;
	private int nullable;
	private String remarks;
	private String columnDefaultValue;
	private int charOctetMaxLength;
	private int ordinalPosition;
	private String isNullable;
	private String scopeCatalog;
	private String scopeSchema;
	private String scopeTable;
	private short sourceDataType;
	private String isAutoIncrement;
	/*private String isGeneratedColumn;*/
	public String getTableCatalog() {
		return tableCatalog;
	}
	public String getTableSchema() {
		return tableSchema;
	}
	public String getTableName() {
		return tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public int getDataType() {
		return dataType;
	}
	public String getTypeName() {
		return typeName;
	}
	public int getColumnSize() {
		return columnSize;
	}
	public int getDecimalDigits() {
		return decimalDigits;
	}
	public int getNumericPrecisionRadix() {
		return numericPrecisionRadix;
	}
	public int getNullable() {
		return nullable;
	}
	public String getRemarks() {
		return remarks;
	}
	public String getColumnDefaultValue() {
		return columnDefaultValue;
	}
	public int getCharOctetMaxLength() {
		return charOctetMaxLength;
	}
	public int getOrdinalPosition() {
		return ordinalPosition;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public String getScopeCatalog() {
		return scopeCatalog;
	}
	public String getScopeSchema() {
		return scopeSchema;
	}
	public String getScopeTable() {
		return scopeTable;
	}
	public short getSourceDataType() {
		return sourceDataType;
	}
	public String getIsAutoIncrement() {
		return isAutoIncrement;
	}
	public DbColumn(String tableCatalog, String tableSchema, String tableName, String columnName, int dataType,
			String typeName, int columnSize, int decimalDigits, int numericPrecisionRadix, int nullable, String remarks,
			String columnDefaultValue, int charOctetMaxLength, int ordinalPosition, String isNullable,
			String scopeCatalog, String scopeSchema, String scopeTable, short sourceDataType, String isAutoIncrement) {
		super();
		this.id = tableName + "-" + columnName;// For refer as id
		this.tableCatalog = tableCatalog;
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.columnName = columnName;
		this.dataType = dataType;
		this.typeName = typeName;
		this.columnSize = columnSize;
		this.decimalDigits = decimalDigits;
		this.numericPrecisionRadix = numericPrecisionRadix;
		this.nullable = nullable;
		this.remarks = remarks;
		this.columnDefaultValue = columnDefaultValue;
		this.charOctetMaxLength = charOctetMaxLength;
		this.ordinalPosition = ordinalPosition;
		this.isNullable = isNullable;
		this.scopeCatalog = scopeCatalog;
		this.scopeSchema = scopeSchema;
		this.scopeTable = scopeTable;
		this.sourceDataType = sourceDataType;
		this.isAutoIncrement = isAutoIncrement;
	}
	@Override
	public String toString() {
		return "" + columnName + "  " + typeName + "(" + columnSize + ")";
	}



}
