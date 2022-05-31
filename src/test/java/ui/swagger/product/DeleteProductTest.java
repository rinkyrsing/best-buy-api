package ui.swagger.product;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class DeleteProductTest extends TestBase {

    @Test
    public void deleteSingleProductInfo() {
        Response response = given()
                .pathParam("id", "127687")
                .when()
                .delete("/products/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }

}
