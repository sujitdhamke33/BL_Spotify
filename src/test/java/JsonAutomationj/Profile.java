package JsonAutomationj;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Profile {
    @Test
    public void putProfile(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .body("{\n" +
                        "  \"id\": 25,\n" +
                        "  \"username\": \"sujit\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"sujit\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("http://localhost:3000/profile");
        res.prettyPrint();
    }
    @Test
 public void getProfile(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Accept","*/*")
                .header("Accept","application/json")
                .when()
                .get("http://localhost:3000/profile");
        res.prettyPrint();
 }

}
