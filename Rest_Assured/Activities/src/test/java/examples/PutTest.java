package examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutTest {
    final static String BASE_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void modifyPet(){
        String reqBody = "{\"id\":8787, \"name\": \"Duffer\", \"status\":\"alive\"}";

        Response response = given().contentType(ContentType.JSON).body(reqBody).when().put(BASE_URI);

        String body = response.getBody().asPrettyString();
        System.out.println(body);

        response.then().body("name", equalTo("Duffer"));
    }
}
