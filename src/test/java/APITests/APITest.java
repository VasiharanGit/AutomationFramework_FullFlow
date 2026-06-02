package APITests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APITest {

    @Test
    public void verifyGetUser() {

        RestAssured
                .given()

                .when()

                .get(
                  "https://jsonplaceholder.typicode.com/posts/1")

                .then()

                //.log().all()

                .statusCode(200);
    }
}