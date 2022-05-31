package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;
import static org.hamcrest.Matchers.lessThan;
import static io.restassured.RestAssured.given;

public class DeleteStoreTest extends TestBase {

    @Test
    public void deleteStoresInfo(){
        Response response = given()
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Accept","application/json")
                .pathParam("id",10)
                .when()
                .delete("/stores/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
}
}
