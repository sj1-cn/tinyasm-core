package nebula.module.dbTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.jooby.Env;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Router;
import org.jooby.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.typesafe.config.Config;

public class DbTableModule implements Jooby.Module {
	private final Logger log = LoggerFactory.getLogger(getClass());

	public void configure(Env env, Config conf, Binder binder) {
		Router router = env.router();

		/**
		 *
		 * Everything about your Pets.
		 */
		router.path("/api/dbTables", () -> {
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
				String filter = req.param("filter").value();//filter={}&range=[0,9]&sort=["lastModification","ASC"]
				String sort = req.param("sort").value();
				String range = req.param("range").value();
				
				List<DbTable> tables = jdbi.withHandle(h -> {
					List<DbTable> rowTables = new ArrayList<>();
					Connection c = h.getConnection();
					try (ResultSet rs = c.getMetaData()
							.getTables(null, null, null, new String[] { "TABLE", "SYSTEM TABLE" })) {
						System.out.println("Printing TABLE_TYPE \"TABLE\" ");
						System.out.println("----------------------------------");

						while (rs.next()) {
							DbTable table = new DbTable.Mapper().map(rs, null);
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
				String tableName = req.param("id")
						.value();

				Jdbi jdbi = req.require(Jdbi.class);

				DbTable table = jdbi.withHandle(h -> {
					DbTableFat rawTable = null;
					Connection c = h.getConnection();

					try (ResultSet rs = c.getMetaData()
							.getTables(null, null, tableName, new String[] { "TABLE", "SYSTEM TABLE" })) {

						ResultSetMetaData metaData = rs.getMetaData();
						int count = metaData.getColumnCount();
						System.out.println("count:" + count);
						for (int i = 0; i < count; i++) {
							System.out.println(metaData.getColumnName(i + 1) + " " + metaData.getColumnTypeName(i + 1));
						}

						System.out.println("Printing TABLE_TYPE \"TABLE\" ");
						System.out.println("----------------------------------");
						if (rs.next()) {
							rawTable = new DbTableFat.Mapper().map(rs, null);
						}
					}

					List<DbColumn> columns = new ArrayList<>();

					DbColumn.Mapper mapper = new DbColumn.Mapper();
					try (ResultSet rs = c.getMetaData()
							.getColumns(null, null, tableName, null)) {
						ResultSetMetaData metaData = rs.getMetaData();
						int count = metaData.getColumnCount();
						System.out.println("count:" + count);
						for (int i = 0; i < count; i++) {
							System.out.println(metaData.getColumnName(i + 1) + " " + metaData.getColumnTypeName(i + 1));
						}

						while (rs.next()) {
							DbColumn column = mapper.map(rs, null);
							columns.add(column);
							log.info(column.toString());
						}
					}

					rawTable.setColumns(columns);

					return rawTable;
				});

				if (table == null) {
					throw new Err(Status.NOT_FOUND);
				}
				return table;
			});
		});

		/**
		 *
		 * Everything about your Pets.
		 */
		router.path("/api/dbColumns", () -> {
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

				List<DbColumn> datas = jdbi.withHandle(h -> {
					Connection c = h.getConnection();
					List<DbColumn> rawColumns = new ArrayList<>();

					DbColumn.Mapper mapper = new DbColumn.Mapper();
					try (ResultSet rs = c.getMetaData()
							.getColumns(null, null, null, null)) {
						ResultSetMetaData metaData = rs.getMetaData();

						while (rs.next()) {
							DbColumn column = mapper.map(rs, null);
							rawColumns.add(column);
						}
					}

					return rawColumns;
				});

				if (datas.size() > 0) {
					rsp.header("Content-Range", "item " + 0 + "-" + datas.size() + "/" + datas.size());
				} else {
					rsp.header("Content-Range", "item 0-0/0");
				}
				rsp.send(datas);
			});

			router.get("/:table", (req, rsp) -> {
				String tableName = req.param("table")
						.value();

				Jdbi jdbi = req.require(Jdbi.class);

				List<DbColumn> datas = jdbi.withHandle(h -> {
					Connection c = h.getConnection();
					List<DbColumn> rawColumns = new ArrayList<>();

					DbColumn.Mapper mapper = new DbColumn.Mapper();
					try (ResultSet rs = c.getMetaData()
							.getColumns(null, null, tableName, null)) {
						ResultSetMetaData metaData = rs.getMetaData();

						while (rs.next()) {
							DbColumn column = mapper.map(rs, null);
							rawColumns.add(column);
						}
					}

					return rawColumns;
				});

				if (datas.size() > 0) {
					rsp.header("Content-Range", "item " + 0 + "-" + datas.size() + "/" + datas.size());
				} else {
					rsp.header("Content-Range", "item 0-0/0");
				}
				rsp.send(datas);
			});
			/**
			 *
			 * Find pet by ID
			 *
			 * @param id Pet ID.
			 * @return Returns <code>200</code> with a single pet or <code>404</code>
			 */
			router.get("/:table-:column", req -> {
				String tableName = req.param("table")
						.value();
				String columnName = req.param("column")
						.value();

				Jdbi jdbi = req.require(Jdbi.class);

				DbColumn data = jdbi.withHandle(h -> {
					Connection c = h.getConnection();
					List<DbColumn> rawColumns = new ArrayList<>();
					DbColumn column = null;
					DbColumn.Mapper mapper = new DbColumn.Mapper();
					try (ResultSet rs = c.getMetaData()
							.getColumns(null, null, tableName, null)) {
						ResultSetMetaData metaData = rs.getMetaData();

						if (rs.next()) {
							column = mapper.map(rs, null);
						}
					}

					return column;
				});

				if (data == null) {
					throw new Err(Status.NOT_FOUND);
				}
				return data;
			});
		});
	}

}