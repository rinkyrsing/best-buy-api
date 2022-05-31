package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetStoreTest extends TestBase {

    @Test
    public void getAllStoreInfo(){
        Response response = given()
                .header("Accept","application/json")
                .header("Authorization","Bearer abc123")
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.time();
        response.prettyPrint();

    }


}
