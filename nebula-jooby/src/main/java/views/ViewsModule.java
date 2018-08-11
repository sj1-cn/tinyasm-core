package views;

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

import nebula.module.dbTable.DbColumn;
import nebula.module.dbTable.DbTable;
import nebula.module.dbTable.DbTableFat;
import nebula.module.definedTables.DefinedColumn;
import nebula.module.definedTables.DefinedTable;

public class ViewsModule implements Jooby.Module {
	private final Logger log = LoggerFactory.getLogger(getClass());

	public void configure(Env env, Config conf, Binder binder) {
		Router router = env.router();
//		.render((value, ctx) -> {
//			  if (ctx.accepts("json")) {
//			     ctx
//			       .type("json")
//			       .text(toJson(value));
//			  }
//		});

		router.path("/views", () -> {
			router.get("/:id", req -> {
				String tableName = req.param("id").value().toUpperCase();

				Jdbi jdbi = req.require(Jdbi.class);

				DbTableFat table = jdbi.withHandle(h -> {
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
				
				List<Field> fields=  new ArrayList<>();
				
				for(DbColumn c : table.getColumns()) {
					fields.add(new Field(c.getColumnName().toLowerCase(), "TextInput"));
				}
				
				View view = new View(fields.toArray(new Field[0]));
				return view;
			});
		});

	}
}