import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest extends BaseRestTest {

        @Test (description = "Проверка, что существует персонаж “Luke Skywalker” c home planet Tatooine")
         public void LukeSkywalkerIsAlive(){

          given().contentType(ContentType.JSON)
               .when().get(baseURI+basePath+"/people/1")
               .then().body("name", equalTo("Luke Skywalker"));

          given().contentType(ContentType.JSON)
                  .when().get(baseURI+basePath+"/planets/1")
                  .then().body("name", equalTo("Tatooine"));
          }

        @Test (description = "Проверка, что количество персонажей равно 87")
         public void countOfPersons(){

           given().contentType(ContentType.JSON)
                 .when().get(baseURI+basePath+"/people")
                 .then().body("count", equalTo(87));
           }


         @Test (description = "Проверка, что первые три персонажа это Luke Skywalker, C-3PO и R2-D2")
         public void firstThreePersons(){

             given().contentType(ContentType.JSON)
                     .when().get(baseURI+basePath+"/people")
                     .then().body("results[0].name", equalTo("Luke Skywalker"))
                            .body("results[1].name", equalTo("C-3PO"))
                            .body("results[2].name", equalTo("R2-D2"));
         }
}
