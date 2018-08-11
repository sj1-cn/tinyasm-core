package nebula;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.jooby.Request;
import org.jooby.test.JoobyRule;
import org.jooby.test.MockRouter;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author jooby generator
 */
public class AppTest {

	/**
	 * One app/server for all the test of this class. If you want to start/stop a
	 * new server per test, remove the static modifier and replace the
	 * {@link ClassRule} annotation with {@link Rule}.
	 */
	@ClassRule
	public static JoobyRule app = new JoobyRule(new App());

	@Test
	public void integrationTest() {
		get("/")
				.then()
				.assertThat()
				.body(equalTo("\"Hello World!\""))
				.statusCode(200)
				.contentType("application/json;charset=UTF-8");

		given()
				.params("name", "John")
				.when()
				.post("/api/pets")
				.then()
				.body("name", equalTo("John"));

		get("/api/pets")
				.then()
				.assertThat()
				.body(equalTo(
						"[{\"id\":1,\"name\":\"Lala\"},{\"id\":2,\"name\":\"Mandy\"},{\"id\":3,\"name\":\"Sasha\"}]"))
				.statusCode(200)
				.header("Content-Range", "item 0-3/3")
				.contentType("application/json;charset=UTF-8");
	}

	@Test
	public void unitTest() throws Throwable {
		String result = new MockRouter(new App()).get("/");

		assertEquals("Hello World!", result);
	}

}
