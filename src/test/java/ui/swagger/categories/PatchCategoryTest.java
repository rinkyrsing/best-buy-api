package ui.swagger.categories;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.ServicesPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class PatchCategoryTest extends TestBase {

    @Test
    public void UpdateSingleCategoryInfo() {

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Besties Buy For Business");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "abcat0010000")
                .when()
                .patch("/categories/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}