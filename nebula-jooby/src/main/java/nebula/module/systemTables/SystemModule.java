package nebula.module.systemTables;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.jooby.Env;
import org.jooby.Jooby;
import org.jooby.Router;

import com.google.inject.Binder;
import com.typesafe.config.Config;

public class SystemModule implements Jooby.Module {
	public void configure(Env env, Config conf, Binder binder) {
		Router router = env.router();

		/** Create table + pets: */
		env.onStart(registry -> {

		});
		/**
		 *
		 * Everything about your SystemTables.
		 */
		router.path("/api/systemTables", () -> {
			router.get((req, rsp) -> {

				Jdbi jdbi = req.require(Jdbi.class);

				List<SystemTable> datas = jdbi.withHandle(handle -> {
					return handle.createQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES")
							.map(new SystemTable.Mapper())
							.list();
				});

				if (datas.size() > 0) {
					rsp.header("Content-Range", "item " + 0 + "-" + datas.size() + "/" + datas.size());
				} else {
					rsp.header("Content-Range", "item 0-0/0");
				}

				rsp.send(datas);
			});
			router.get("/:id", req -> {
				String id = req.param("id")
						.value();

				Jdbi jdbi = req.require(Jdbi.class);

				SystemTable table = jdbi.withHandle(handle -> {
					return handle.createQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME=? ORDER BY id ASC")
							.bind(0, id)
							.map(new SystemTable.Mapper())
							.findOnly();
				});

				return table;
			});
		});
		router.path("/api/systemColumns", () -> {
			router.get((req, rsp) -> {

				Jdbi jdbi = req.require(Jdbi.class);

				List<SystemColumn> datas = jdbi.withHandle(handle -> {
					return handle.createQuery("SELECT * FROM INFORMATION_SCHEMA.COLUMNS")
							.map(new SystemColumn.Mapper())
							.list();
				});
				if (datas.size() > 0) {
					rsp.header("Content-Range", "item " + 0 + "-" + datas.size() + "/" + datas.size());
				} else {
					rsp.header("Content-Range", "item 0-0/0");
				}
				rsp.send(datas);
			});
			router.get("/:id", req -> {
				int id = req.param("id")
						.intValue();

				Jdbi jdbi = req.require(Jdbi.class);

				SystemColumn table = jdbi.withHandle(handle -> {
					return handle.createQuery("SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE ID=? ")
							.bind(0, id)
							.map(new SystemColumn.Mapper())
							.findOnly();
				});

				return table;
			});
		});
	}

}