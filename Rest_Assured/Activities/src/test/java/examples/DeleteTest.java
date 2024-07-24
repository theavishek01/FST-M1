package examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteTest {
    final static String BASE_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void deletePet(){
        Response response = given().contentType(ContentType.JSON).when().delete(BASE_URI +"/8787");

        String body = response.getBody().asPrettyString();
        System.out.println(body);

        response = given().contentType(ContentType.JSON).when().get(BASE_URI+"/8787");

        System.out.println(response.getBody().asPrettyString());

        response.then().statusCode(404);
        response.then().body("message",equalTo("Pet not found"));
    }
}
