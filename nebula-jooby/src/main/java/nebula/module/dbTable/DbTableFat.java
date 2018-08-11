package nebula.module.dbTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class DbTableFat extends DbTable {
	public static class Mapper implements RowMapper<DbTableFat> {
		@Override
		public DbTableFat map(final ResultSet rs, final StatementContext ctx) throws SQLException {
			return new DbTableFat(rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE"), rs.getString("TABLE_CAT"),
					rs.getString("TABLE_SCHEM"), rs.getString("TABLE_NAME"), rs.getString("SELF_REFERENCING_COL_NAME"),
					rs.getString("REF_GENERATION"));
		}
	}
	
	private List<DbColumn> columns;

	public void setColumns(List<DbColumn> columns) {
		this.columns = columns;
	}

	public List<DbColumn> getColumns() {
		return columns;
	}

	public DbTableFat(String id, String tableType, String tableCat, String tableSchema, String tableName,
			String selfReferencingColName, String refGeneration) {
		super(id, tableType, tableCat, tableSchema, tableName, selfReferencingColName, refGeneration);
	}


}
