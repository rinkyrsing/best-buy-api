package ui.swagger.categories;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class GetCategoryTest extends TestBase {

    @Test
    public void getAllCategoriesInformation() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .get("/categories");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }

    @Test
    public void getASingleCategoryInfo() {
        Response response = given()
                .pathParam("id","abcat0010000")
                .when()
                .get("/categories/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}
