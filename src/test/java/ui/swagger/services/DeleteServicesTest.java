package ui.swagger.services;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class DeleteServicesTest extends TestBase {


    @Test
    public void deleteASingleServiceInfo() {
        Response response = given()
                .pathParam("id", "7")
                .when()
                .delete("/services/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }


}
