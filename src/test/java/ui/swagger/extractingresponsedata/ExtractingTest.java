package ui.swagger.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.plugin2.os.windows.Windows;
import ui.swagger.testbase.TestBase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractingTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        response = given()
                .when()
                .get()
                .then().statusCode(200);

    }

    // Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    // Extract the names of all the store
    @Test
    public void test004() {
        List<String> name = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all stors is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> sizeList = response.extract().path("data.length");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + sizeList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<String> value = response.extract().path("data.findAll{it.name=='St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store where store name : " + value);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String> addressName = response.extract().path("data.findAll{it.name=='Rochester'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name : " + addressName);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {
        List<String> services = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the services of 8th store : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test0010() {
        List<String> storeServices = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services of the store where service name : " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test0011() {
        List<?> storeId = response.extract().path("data.services.storeservices.findAll{it.storeId}.storeId");
        Iterator<?> itr = storeId.iterator();
        while (itr.hasNext()) {
            // System.out.println(itr.next());
            List<?> check = (List<?>) itr.next();
            System.out.println("List of name of all stores id are : " + check.get(0));
        }
    }
        //12. Get id of all the store
        @Test
        public void test0012 () {
            List<?> idOfStore = response.extract().path("data.services.id");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("Get id of all the store  : " + idOfStore);
            System.out.println("------------------End of Test---------------------------");
        }

        //13. Find the store names Where state = ND
        @Test
        public void test0013 () {
            List<?> storeNd = response.extract().path("data.findAll{it.state=='ND'}.name");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("Get store names Where state = ND  : " + storeNd);
            System.out.println("------------------End of Test---------------------------");
        }

        //14. Find the Total number of services for the store where store name = Rochester
        @Test
        public void test0014() {

            List<?> serviceNameRoc = response.extract().path("data.findAll{it.name=='Rochester'}.services.find{it.name}");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("The total number of services for the store where store name : " + serviceNameRoc.size());
            System.out.println("------------------End of Test---------------------------");
        }

       // 15. Find the createdAt for all services whose name = “Windows Store”
       @Test
       public void test0015() {

           List<?> createdAt = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.createdAt");

           System.out.println("------------------StartingTest---------------------------");
           System.out.println("The the createdAt for all services whose name = 'Windows Store' : " + createdAt);
           System.out.println("------------------End of Test---------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test0016() {

        List<String> name = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services Where store name = Fargo: " + name);
        System.out.println("------------------End of Test---------------------------");
    }
    //17. Find the zip of all the store
    @Test
    public void test0017() {

        List<String> zipStore = response.extract().path("data.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the zip of all the store : " + zipStore);
        System.out.println("------------------End of Test---------------------------");
    }
    //18. Find the zip of store name = Roseville
    @Test
    public void test0018() {

        List<String> zipStoreRos = response.extract().path("data.findAll{it.name=='Roseville'}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of store name = Roseville : " + zipStoreRos);
        System.out.println("------------------End of Test---------------------------");
    }
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test0019() {

        List<HashMap<String, ?>> storeSerName = response.extract().path("data.find{it.services}.services.findAll{it.name='Magnolia Home Theater'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services details of the service name is Magnolia Home Theater : " + storeSerName);
        System.out.println("------------------End of Test---------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void test0020() {

        List<Integer> dataLat = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the lat of all the stores : " + dataLat);
        System.out.println("------------------End of Test---------------------------");
    }

}

