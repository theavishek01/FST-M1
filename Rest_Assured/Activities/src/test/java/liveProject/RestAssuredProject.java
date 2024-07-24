package liveProject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class RestAssuredProject {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String sshkey= "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIMKY891F85pskdepWSQjWvntXMYmlTEJ2sZ/WFJnVSzT"
    int keyId ;

    @BeforeClass
    public void setup(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Content-Type","application/json")
                .setAuth(RestAssured.oauth2("token <GitHub access token>"))
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .expectResponseTime(lessThanOrEqualTo(3000L))
                .build();
    }
    @Test(priority = 1)
    public void postRequest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIMKY891F85pskdepWSQjWvntXMYmlTEJ2sZ/WFJnVSzT");

        Response response = given().spec(requestSpec).body(reqBody).when().post();
        keyId = response.then().extract().path("id");

        response.then().statusCode(200);
    }
    @Test(priority = 2)
    public void getRequest(){
        given().spec(requestSpec).pathParam("keyId",keyId).
                when().get("/{keyId}").
                then().spec(responseSpec).log().all();
        Response res = given().when().get("https://api.github.com/user/keys/{keyId}");
        res.then().statusCode(200);
    }
    @Test(priority = 3)
    public void deleteRequest(){
        given().spec(requestSpec).pathParam("keyId",keyId).
                when().get("/{keyId}").
                then().statusCode(204).body("message", equalTo(""+keyId));
    }

}
