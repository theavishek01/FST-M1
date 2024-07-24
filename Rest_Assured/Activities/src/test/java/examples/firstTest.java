package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//https://petstore.swagger.io/v2/pet/findByStatus?status=sold
public class firstTest {
    @Test
    public void getRequestWithQueryParams(){
        Response response =
                given().
                        baseUri("https://petstore.swagger.io/v2/pet").
                        header("Content-Type","application/json").
                        queryParam("status","alive").
                        log().all().
                when().
                        get("/findByStatus");
        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getHeaders().asList());

        String petStatus = response.then().extract().path("[0]['status']");
        Assert.assertEquals(petStatus,"alive");
    }
    @Test
    public void getRequestWithPathParams(){
        given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type","application/json").
                pathParam("petId", 7723).
                log().all().
        when().
                get("/{petId}").
        then().
                statusCode(200).
                body("name",equalTo("Ditto")).
                log().all();
    }
}
