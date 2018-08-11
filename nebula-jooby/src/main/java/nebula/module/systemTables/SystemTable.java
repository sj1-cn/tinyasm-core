package nebula.module.systemTables;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class SystemTable {
	public static class Mapper implements RowMapper<SystemTable> {
		@Override
		public SystemTable map(final ResultSet rs, final StatementContext ctx) throws SQLException {
			return new SystemTable(rs.getString("TABLE_CATALOG"), rs.getString("TABLE_SCHEMA"),
					rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE"), rs.getString("STORAGE_TYPE"),
					rs.getString("SQL"), rs.getString("REMARKS"), rs.getLong("LAST_MODIFICATION"), rs.getInt("ID"),
					rs.getString("TYPE_NAME"), rs.getString("TABLE_CLASS"), rs.getLong("ROW_COUNT_ESTIMATE"));
		}
	}

	private String id;
	private String tableCatalog;
	private String tableSchema;
	private String tableName;
	private String tableType;
	private String storageType;
	private String sql;
	private String remarks;
	private long lastModification;
	private int tableId;
	private String typeName;
	private String tableClass;
	private long rowCountEstimate;

	public String getId() {
		return id;
	}

	public String getTableCatalog() {
		return tableCatalog;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public String getTableType() {
		return tableType;
	}

	public String getStorageType() {
		return storageType;
	}

	public String getSql() {
		return sql;
	}

	public String getRemarks() {
		return remarks;
	}

	public long getLastModification() {
		return lastModification;
	}

	public int getTableId() {
		return tableId;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getTableClass() {
		return tableClass;
	}

	public long getRowCountEstimate() {
		return rowCountEstimate;
	}

	public SystemTable(String tableCatalog, String tableSchema, String tableName, String tableType, String storageType,
			String sql, String remarks, long lastModification, int tableId, String typeName, String tableClass,
			long rowCountEstimate) {
		super();
		this.id = tableName;
		this.tableCatalog = tableCatalog;
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.tableType = tableType;
		this.storageType = storageType;
		this.sql = sql;
		this.remarks = remarks;
		this.lastModification = lastModification;
		this.tableId = tableId;
		this.typeName = typeName;
		this.tableClass = tableClass;
		this.rowCountEstimate = rowCountEstimate;
	}

}
