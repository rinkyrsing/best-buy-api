package ui.swagger.services;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.ServicesPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class PatchServicesTest extends TestBase {


    @Test
    public void updateSingleServiceInfo() {

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Besties Buy For Business");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "8")
                .when()
                .patch("/services/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}
