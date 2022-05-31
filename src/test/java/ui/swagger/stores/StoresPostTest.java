package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.StoresPojo;
import ui.swagger.testbase.TestBase;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class StoresPostTest extends TestBase {

@Test
    public void createStoreInfo(){

    StoresPojo storesPojo = new StoresPojo();
    storesPojo.setName("Amy");
    storesPojo.setType("Smith");
    storesPojo.setAddress("xyz");
    storesPojo.setAddress2("abc");
    storesPojo.setCity("London");
    storesPojo.setState("Dooo");
    storesPojo.setZip("1111");
    storesPojo.setLat(76453);
    storesPojo.setLng(4234);
    storesPojo.setHours("10");
    storesPojo.setServices("?");

        Response response = given()
               .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
               .header("Content-Type","application/json")
               .body(storesPojo)
               .post("/stores");
       response.then().statusCode(201);
       response.then().time(lessThan(1400L));
       response.prettyPrint();

}


}
