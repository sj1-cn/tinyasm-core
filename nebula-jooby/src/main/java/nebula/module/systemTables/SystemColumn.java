package nebula.module.systemTables;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class SystemColumn {
	public static class Mapper implements RowMapper<SystemColumn> {
		@Override
		public SystemColumn map(final ResultSet rs, final StatementContext ctx) throws SQLException {
			return new SystemColumn(rs.getString("TABLE_CATALOG"), rs.getString("TABLE_SCHEMA"),
					rs.getString("TABLE_NAME"), rs.getString("COLUMN_NAME"), rs.getInt("ORDINAL_POSITION"),
					rs.getString("COLUMN_DEFAULT"), rs.getString("IS_NULLABLE"), rs.getInt("DATA_TYPE"),
					rs.getInt("CHARACTER_MAXIMUM_LENGTH"), rs.getInt("CHARACTER_OCTET_LENGTH"),
					rs.getInt("NUMERIC_PRECISION"), rs.getInt("NUMERIC_PRECISION_RADIX"), rs.getInt("NUMERIC_SCALE"),
					rs.getString("CHARACTER_SET_NAME"), rs.getString("COLLATION_NAME"), rs.getString("TYPE_NAME"),
					rs.getInt("NULLABLE"), rs.getBoolean("IS_COMPUTED"), rs.getInt("SELECTIVITY"),
					rs.getString("CHECK_CONSTRAINT"), rs.getString("SEQUENCE_NAME"), rs.getString("REMARKS"),
					rs.getShort("SOURCE_DATA_TYPE"), rs.getString("COLUMN_TYPE"), rs.getString("COLUMN_ON_UPDATE"));
		}
	}

	private String tableCatalog;
	private String tableSchema;
	private String tableName;
	private String columnName;
	private int ordinalPosition;
	private String columnDefault;
	private String isNullable;
	private int dataType;
	private int characterMaximumLength;
	private int characterOctetLength;
	private int numericPrecision;
	private int numericPrecisionRadix;
	private int numericScale;
	private String characterSetName;
	private String collationName;
	private String typeName;
	private int nullable;
	private boolean isComputed;
	private int selectivity;
	private String checkConstraint;
	private String sequenceName;
	private String remarks;
	private short sourceDataType;
	private String columnType;
	private String columnOnUpdate;

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

	public int getOrdinalPosition() {
		return ordinalPosition;
	}

	public String getColumnDefault() {
		return columnDefault;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public int getDataType() {
		return dataType;
	}

	public int getCharacterMaximumLength() {
		return characterMaximumLength;
	}

	public int getCharacterOctetLength() {
		return characterOctetLength;
	}

	public int getNumericPrecision() {
		return numericPrecision;
	}

	public int getNumericPrecisionRadix() {
		return numericPrecisionRadix;
	}

	public int getNumericScale() {
		return numericScale;
	}

	public String getCharacterSetName() {
		return characterSetName;
	}

	public String getCollationName() {
		return collationName;
	}

	public String getTypeName() {
		return typeName;
	}

	public int getNullable() {
		return nullable;
	}

	public boolean isComputed() {
		return isComputed;
	}

	public int getSelectivity() {
		return selectivity;
	}

	public String getCheckConstraint() {
		return checkConstraint;
	}

	public String getSequenceName() {
		return sequenceName;
	}

	public String getRemarks() {
		return remarks;
	}

	public short getSourceDataType() {
		return sourceDataType;
	}

	public String getColumnType() {
		return columnType;
	}

	public String getColumnOnUpdate() {
		return columnOnUpdate;
	}

	public SystemColumn(String tableCatalog, String tableSchema, String tableName, String columnName,
			int ordinalPosition, String columnDefault, String isNullable, int dataType, int characterMaximumLength,
			int characterOctetLength, int numericPrecision, int numericPrecisionRadix, int numericScale,
			String characterSetName, String collationName, String typeName, int nullable, boolean isComputed,
			int selectivity, String checkConstraint, String sequenceName, String remarks, short sourceDataType,
			String columnType, String columnOnUpdate) {
		super();
		this.tableCatalog = tableCatalog;
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.columnName = columnName;
		this.ordinalPosition = ordinalPosition;
		this.columnDefault = columnDefault;
		this.isNullable = isNullable;
		this.dataType = dataType;
		this.characterMaximumLength = characterMaximumLength;
		this.characterOctetLength = characterOctetLength;
		this.numericPrecision = numericPrecision;
		this.numericPrecisionRadix = numericPrecisionRadix;
		this.numericScale = numericScale;
		this.characterSetName = characterSetName;
		this.collationName = collationName;
		this.typeName = typeName;
		this.nullable = nullable;
		this.isComputed = isComputed;
		this.selectivity = selectivity;
		this.checkConstraint = checkConstraint;
		this.sequenceName = sequenceName;
		this.remarks = remarks;
		this.sourceDataType = sourceDataType;
		this.columnType = columnType;
		this.columnOnUpdate = columnOnUpdate;
	}

}
