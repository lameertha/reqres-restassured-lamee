package in.regres.users;

import in.regres.model.UserPojo;
import in.regres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/* Created
 * by Lamee */
public class PutUsers extends TestBase {
    String name = "morpheus";
    String job = "zion resident";


    @Test
    public void updateUsers() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .put("/users/2");
        response.then().statusCode(200)
                .log().body();

    }

}
