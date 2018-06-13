import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.basic;

public class BaseRestTest {

    @BeforeClass
    public void setup(){

        RestAssured.baseURI  = "https://swapi.co";
        RestAssured.basePath = "/api";
        RestAssured.authentication = basic("", "");

    }


}
