package anderson.com;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OrdemServicoResourceTest {

    @Test
    public void testOrdemServicoEndpoint() {
        given()
          .when().get("/ordemservico")
          .then()
             .statusCode(200);
    }

}