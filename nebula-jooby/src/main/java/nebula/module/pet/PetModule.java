package nebula.module.pet;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.jooby.Env;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Results;
import org.jooby.Router;
import org.jooby.Status;

import com.google.inject.Binder;
import com.typesafe.config.Config;

public class PetModule implements Jooby.Module {
	public void configure(Env env, Config conf, Binder binder) {
		Router router = env.router();

		/** Create table + pets: */
		env.onStart(registry -> {
			Jdbi jdbi = registry.require(Jdbi.class);
			jdbi.useHandle(h -> {
				h.createUpdate("create table pets (id bigint auto_increment, name varchar(255), desciption varchar(255))").execute();

				PetRepository repo = h.attach(PetRepository.class);
				repo.insert(new Pet(1L, "Lala", "Lala"));
				repo.insert(new Pet(2L, "Mandy", "Mandy"));
				repo.insert(new Pet(3L, "Sasha", "Sasha"));
			});
		});

		/**
		 *
		 * Everything about your Pets.
		 */
		router.path("/api/pets", () -> {
			/**
			 *
			 * List pets ordered by id.
			 *
			 * @param start Start offset, useful for paging. Default is <code>0</code>.
			 * @param max   Max page size, useful for paging. Default is <code>50</code>.
			 * @return Pets ordered by name.
			 */
			router.get((req, rsp) -> {
				PetRepository db = req.require(PetRepository.class);

				int start = req.param("start").intValue(0);
				int max = req.param("max").intValue(20);
				List<Pet> pets = db.list(start, max);

				if (pets.size() > 0) {
					rsp.header("Content-Range", "item " + 0 + "-" + pets.size() + "/" + pets.size());
				} else {
					rsp.header("Content-Range", "item 0-0/0");
				}

				rsp.send(pets);
			});

			/**
			 *
			 * Find pet by ID
			 *
			 * @param id Pet ID.
			 * @return Returns <code>200</code> with a single pet or <code>404</code>
			 */
			router.get("/:id", req -> {
				PetRepository db = req.require(PetRepository.class);

				long id = req.param("id").longValue();

				Pet pet = db.findById(id);
				if (pet == null) {
					throw new Err(Status.NOT_FOUND);
				}
				return pet;
			});
			/**
			 *
			 * Find pet by ID
			 *
			 * @param id Pet ID.
			 * @return Returns <code>200</code> with a single pet or <code>404</code>
			 */
			router.put("/:id", req -> {
				PetRepository db = req.require(PetRepository.class);

				long id = req.param("id").longValue();

				Pet oldpet = db.findById(id);
				if (oldpet == null) {
					throw new Err(Status.NOT_FOUND);
				}

				Pet pet = req.body(Pet.class);
				if (!db.update(pet)) {
					throw new Err(Status.NOT_FOUND);
				}
				return pet;
			});
			/**
			 *
			 * Add a new pet to the store.
			 *
			 * @param body Pet object that needs to be added to the store.
			 * @return Returns a saved pet.
			 */
			router.post(req -> {
				PetRepository db = req.require(PetRepository.class);

				Pet pet = req.body(Pet.class);

				long id = db.insert(pet);
				return new Pet(id, pet.getName(),pet.getDesciption());
			});

			/**
			 *
			 * Update an existing pet.
			 *
			 * @param body Pet object that needs to be updated.
			 * @return Returns a saved pet.
			 */
			router.put(req -> {
				PetRepository db = req.require(PetRepository.class);

				Pet pet = req.body(Pet.class);
				if (!db.update(pet)) {
					throw new Err(Status.NOT_FOUND);
				}
				return pet;
			});

			/**
			 *
			 * Deletes a pet by ID.
			 *
			 * @param id Pet ID.
			 * @return A <code>204</code>
			 */
			router.delete("/:id", req -> {
				PetRepository db = req.require(PetRepository.class);

				long id = req.param("id").longValue();

				if (!db.delete(id)) {
					throw new Err(Status.NOT_FOUND);
				}
				return Results.noContent();
			});
		});
	}

}