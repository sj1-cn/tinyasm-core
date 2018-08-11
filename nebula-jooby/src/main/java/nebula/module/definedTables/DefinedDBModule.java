package nebula.module.definedTables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.jooby.Env;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.Router;
import org.jooby.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.typesafe.config.Config;

public class DefinedDBModule implements Jooby.Module {
	private final Logger log = LoggerFactory.getLogger(getClass());

	public void configure(Env env, Config conf, Binder binder) {
		Router router = env.router();

		/** Create table + pets: */
		env.onStart(registry -> {
			Jdbi jdbi = registry.require(Jdbi.class);

			jdbi.useHandle(h -> {
				Connection c = h.getConnection();
				try (ResultSet tables = c.getMetaData().getTables(null, null, null, new String[] { "TABLE" })) {
					System.out.println("Printing TABLE_TYPE \"TABLE\" ");
					System.out.println("----------------------------------");
					while (tables.next()) {
						// Print
						System.out.println(tables.getString("TABLE_NAME"));
					}
				}
			});
		});

		/**
		 *
		 * Everything about your Pets.
		 */
		router.path("/api/definedTables", () -> {
			/**
			 *
			 * List pets ordered by id.
			 *
			 * @param start Start offset, useful for paging. Default is <code>0</code>.
			 * @param max   Max page size, useful for paging. Default is <code>50</code>.
			 * @return Pets ordered by name.
			 */
			router.get((req, rsp) -> {
				Jdbi jdbi = req.require(Jdbi.class);
				List<DefinedTableThin> tables = jdbi.withHandle(h -> {
					List<DefinedTableThin> rowTables = new ArrayList<>();
					Connection c = h.getConnection();
					try (ResultSet tablesResultSet = c
							.getMetaData()
							.getTables(null, null, null, new String[] { "TABLE" })) {
						System.out.println("Printing TABLE_TYPE \"TABLE\" ");
						System.out.println("----------------------------------");

						while (tablesResultSet.next()) {
							DefinedTableThin table = new DefinedTableThin(tablesResultSet.getString("TABLE_NAME"));
							rowTables.add(table);
						}
					}
					return rowTables;
				});

				if (tables.size() > 0) {
					rsp.header("Content-Range", "item " + 0 + "-" + tables.size() + "/" + tables.size());
				} else {
					rsp.header("Content-Range", "item 0-0/0");
				}

				rsp.send(tables);
			});

			/**
			 *
			 * Find pet by ID
			 *
			 * @param id Pet ID.
			 * @return Returns <code>200</code> with a single pet or <code>404</code>
			 */
			router.get("/:id", req -> {
				String tableName = req.param("id").value();

				Jdbi jdbi = req.require(Jdbi.class);

				List<DefinedColumn> columns = jdbi.withHandle(h -> {
					List<DefinedColumn> rowColumns = new ArrayList<>();
					Connection c = h.getConnection();
					try (ResultSet rs = c.getMetaData().getColumns(null, null, tableName, null)) {

						while (rs.next()) {
							String columnName = rs.getString("COLUMN_NAME");
							int datatype = rs.getInt("DATA_TYPE");
							String typeName = rs.getString("TYPE_NAME");
							int columnsize = rs.getInt("COLUMN_SIZE");
							int decimaldigits = rs.getInt("DECIMAL_DIGITS");
							boolean isNullable = "YES".equals(rs.getString("IS_NULLABLE"));
							boolean isAutoIncrment = "YES".equals(rs.getString("IS_AUTOINCREMENT"));
							log.info(columnName + " " + datatype + " " + typeName + "(" + columnsize + (decimaldigits>0?"."+ decimaldigits:"") + ")"
											 + " " + (isNullable?"Nullable":"") + " " +  (isAutoIncrment?"AutoIncrment":"") + ";" );

							DefinedColumn column = new DefinedColumn(columnName, datatype, typeName, columnsize, decimaldigits,
									isNullable, isAutoIncrment);
							rowColumns.add(column);
						}
					}

					return rowColumns;
				});

				if (columns.size() == 0) {
					throw new Err(Status.NOT_FOUND);
				}
				DefinedTable table = new DefinedTable(tableName, columns);
				return table;
			});
		});
	}

}