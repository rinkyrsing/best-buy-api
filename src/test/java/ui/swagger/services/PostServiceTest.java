package ui.swagger.services;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.ServicesPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class PostServiceTest extends TestBase {

    @Test
    public void createAService() {

        ServicesPojo servicesPojo = new ServicesPojo();

        servicesPojo.setName("Bill Gates Business");


        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 8bc13c20a8ab19fdf152065554a0e38e1545013fd1c3feb811568f9a151005f7")
                .body(servicesPojo)
                .when()
                .post("/services");
        response.then().statusCode(201);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}
