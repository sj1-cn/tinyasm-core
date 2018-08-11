package nebula;

import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.ftl.Ftl;
import org.jooby.handlers.Cors;
import org.jooby.handlers.CorsHandler;
import org.jooby.jdbc.Jdbc;
import org.jooby.jdbi.Jdbi3;
import org.jooby.jdbi.TransactionalRequest;
import org.jooby.json.Jackson;
import org.jooby.rocker.Rockerby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nebula.module.dbTable.DbTableModule;
import nebula.module.definedTables.DefinedDBModule;
import nebula.module.pet.PetModule;
import nebula.module.pet.PetRepository;
import nebula.module.systemTables.SystemModule;
import views.Resources;
import views.ViewsModule;

public class App extends Jooby {
	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(getClass());
	{
		
		use(new Jackson());

		use(new Jdbc());
				
		use(new Jdbi3()
				/** Install SqlObjectPlugin */
				.doWith(jdbi -> {
					jdbi.installPlugin(new SqlObjectPlugin());
				})
				/** Creates a transaction per request and attach PetRepository */
				.transactionPerRequest(new TransactionalRequest().attach(PetRepository.class)));

		use("*", new CorsHandler(new Cors()
				.withOrigin("*")
				.withMethods("*")
				.withHeaders("*")
				.withoutCreds()
				.withExposedHeaders("X-Total-Count", "Content-Range", "Content-Type", "Accept", "X-Requested-With",
						"remember-me")
				.withMaxAge(-1)));

		assets("/assets/**");
		
		get("/", () -> "Hello World!");

		use(new PetModule());
		use(new DbTableModule());
		use(new SystemModule());
		use(new DefinedDBModule());
		use(new ViewsModule());
		use(new Ftl("/", ".ftl"));
		get("/bundle.js",req -> Results.html("views/bundle"));
		get("/ftl",req -> Results.html("views/index").put("model", "say hello"));
		get("/ftl2",req -> new JsView("views/index").put("model", "say hello"));

		get("/math.js",req -> new JsView("views/index").put("model", "say hello"));
		
		post("/resources",req -> {
			String[] str =  {"posts","post2"};
			Resources data = new Resources(str);
			return data;
		});
		get("/resources",req -> {
			String[] str =  {"posts","post2"};
			Resources data = new Resources(str);
			return data;
		});

	}

	public static void main(final String[] args) {
		run(App::new, args);
	}

}
