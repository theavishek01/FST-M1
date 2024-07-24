package examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostTest {
    final static String BASE_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void addNewPet(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 8787);
        reqBody.put("name", "Truffle");
        reqBody.put("status", "alive");

        Response response = given().contentType(ContentType.JSON).body(reqBody).when().post(BASE_URI);

        String body = response.getBody().asPrettyString();
        System.out.println(body);

        response.then().statusCode(200);
        response.then().body("name", equalTo("Truffle"));
        response.then().body("status", equalTo("alive"));
        response.then().body("id", equalTo(8787));
    }
}
