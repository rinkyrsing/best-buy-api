package ui.swagger.services;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class GetServiceTest extends TestBase {

    @Test
    public void getAllServicesInformation() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .get("/services");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }

    @Test
    public void getASingleServiceInfo() {
        Response response = given()
                .pathParam("id",8)
                .when()
                .get("/services/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}
