package in.regres.users;

import in.regres.model.UserPojo;
import in.regres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.regres.model.UserPojo.getRandomString;
import static io.restassured.RestAssured.given;

/* Created
 * by Lamee */
public class PostUsers extends TestBase {
    String name = "lamee" + getRandomString(2);
    String job = "thev" + getRandomString(2);
    String email = "lameethev" + getRandomString(2);
    String password = "lameethev" + getRandomString(2);

    @Test
    public void createNewsUser() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/users");
        response.then().statusCode(201)
                .log().body();

    }
    @Test
    public void registerUserSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "eve.holt@reqres.in");
        userPojo.setPassword(password="pistol");
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(200)
                .log().body();

    }

    @Test
    public void userShouldLoginSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "eve.holt@reqres.in");
        userPojo.setPassword(password="cityslicka");
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/login");
        response.then().statusCode(200)
                .log().body();


    }
    @Test
    public void userShouldLoginUnSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "peter@klaven");
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/login");
        response.then().statusCode(400)
                .log().body();


    }
}
