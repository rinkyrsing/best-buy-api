package ui.swagger.categories;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class DeleteCategoryTest extends TestBase {

    @Test
    public void deleteASingleCategoryInfo() {
        Response response = given()
                .pathParam("id", "abcat0020002")
                .when()
                .delete("/services/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }


}
