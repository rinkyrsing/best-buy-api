package ui.swagger.testbase;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import ui.swagger.utils.TestUtils;

public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        //This is environment
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
      //  RestAssured.basePath = "/stores";

    }
}
