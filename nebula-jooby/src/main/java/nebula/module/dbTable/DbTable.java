package nebula.module.dbTable;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class DbTable {
	/*
	 * <LI><B>REMARKS</B> String {@code =>} explanatory comment on the table
	 * <LI><B>TYPE_CAT</B> String {@code =>} the types catalog (may be
	 * <code>null</code>) <LI><B>TYPE_SCHEM</B> String {@code =>} the types schema
	 * (may be <code>null</code>) <LI><B>TYPE_NAME</B> String {@code =>} type name
	 * (may be <code>null</code>) <LI><B>SELF_REFERENCING_COL_NAME</B> String {@code
	 * =>} name of the designated "identifier" column of a typed table (may be
	 * <code>null</code>) <LI><B>REF_GENERATION</B> String {@code =>} specifies how
	 * values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER",
	 * "DERIVED". (may be <code>null</code>)
	 */
	public static class Mapper implements RowMapper<DbTable> {
		@Override
		public DbTable map(final ResultSet rs, final StatementContext ctx) throws SQLException {
			return new DbTable(rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE"), rs.getString("TABLE_CAT"),
					rs.getString("TABLE_SCHEM"), rs.getString("TABLE_NAME"), rs.getString("SELF_REFERENCING_COL_NAME"),
					rs.getString("REF_GENERATION"));
		}
	}

	private String id;
	private String tableType;
	private String tableCat;
	private String tableSchema;
	private String tableName;
	private String selfReferencingColName;
	private String refGeneration;

	public String getId() {
		return id;
	}

	public String getTableType() {
		return tableType;
	}

	public String getTableCat() {
		return tableCat;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public String getSelfReferencingColName() {
		return selfReferencingColName;
	}

	public String getRefGeneration() {
		return refGeneration;
	}

	public DbTable(String id, String tableType, String tableCat, String tableSchema, String tableName,
			String selfReferencingColName, String refGeneration) {
		super();
		this.id = id;
		this.tableType = tableType;
		this.tableCat = tableCat;
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.selfReferencingColName = selfReferencingColName;
		this.refGeneration = refGeneration;
	}

}
