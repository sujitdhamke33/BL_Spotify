package JsonAutomationj;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Comments {

    @Test
    public void addComments(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Accept","*/*")
                .body("{\n" +
                        "        \"id\": \"2\",\n" +
                        "        \"body\": \"Nice\",\n" +
                        "        \"postId\": 3\n" +
                        "    }")
                .when()
                .post("http://localhost:3000/comments");
        res.prettyPrint();
    }

    @Test
    public void getComments(){
        Response res = given()
                .header("Accept","*/*")
                .when()
                .get("http://localhost:3000/comments");
        res.prettyPrint();
    }

    @Test
    public void putComments(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Accept","*/*")
                .body("{\n" +
                        "        \"id\": \"1\",\n" +
                        "        \"body\": \"some comment changes here\",\n" +
                        "        \"postId\": 3\n" +
                        "    }")
                .when()
                .put("http://localhost:3000/comments/1");
        res.prettyPrint();
    }

    @Test
    public void patchComments(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Accept","*/*")
                .body("{\n" +
                        "        \"id\": \"1\",\n" +
                        "        \"body\": \"This is the patch test\",\n" +
                        "        \"postId\": 3\n" +
                        "    }")
                .when()
                .patch("http://localhost:3000/comments/1");
        res.prettyPrint();
    }

    @Test
    public void deleteComments(){
        Response res = given()
                .header("Accept","*/*")
                .when()
                .delete("http://localhost:3000/comments/32c2");
        res.prettyPrint();
    }

}
