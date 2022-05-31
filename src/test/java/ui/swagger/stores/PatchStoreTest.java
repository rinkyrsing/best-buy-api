package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.StoresPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class PatchStoreTest extends TestBase {
@Test
   public void UpdateStoreInfo() {

    StoresPojo storesPojo = new StoresPojo();
    storesPojo.setLat(44.96956);
    storesPojo.setLng(-93.4495679);

    Response response = given()
            .header("Content-Type", "application/json")
            .pathParam("id", "7")
            .when()
            .patch("/stores/{id}");
    response.then().statusCode(200);
    response.then().time(lessThan(1400L));
    response.prettyPrint();

}
}
