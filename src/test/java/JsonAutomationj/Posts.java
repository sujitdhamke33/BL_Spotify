package JsonAutomationj;


import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Posts {
    @Test
 public void addPost(){
     Response res = given()
             .header("Content-Type","application/json")
              .header("Accept","*/*")
             .body("{\n" +
                     "                \"id\": \"22\",\n" +
                     "                \"title\":\"test Good \",\n" +
                     "                \"author\": \"Sujit D Dhamke\"\n" +
                     "            }")
             .when()
             .post("http://localhost:3000/posts");
              res.prettyPrint();
 }

    @Test
    public void getpost(){
        Response res = given()
                .header("Accept","*/*")
                .when()
                .get("http://localhost:3000/posts");
        res.prettyPrint();
    }

    @Test
    public void putPost(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Accept","*/*")
                .body("{\n" +
                        "    \"id\": \"22\",\n" +
                        "    \"title\": \"legend \",\n" +
                        "    \"author\": \"Sujit D Dhamke\"\n" +
                        "}")
                .when()
                .put("http://localhost:3000/posts/22");
        res.prettyPrint();
    }
@Test
    public void patch(){
       Response res = given()
                .header("Content-Type","application/json")
                .header("Accept","*/*")
                .body("{\n" +
                        "    \"title\": \"Selenium Testing\"\n" +
                        "}")
                .when()
                .patch("http://localhost:3000/posts/22");
       res.prettyPrint();
       res.then().statusCode(200);

    }

    @Test
    public void deletePost(){
        Response res = given()
                .header("Accept","*/*")
                .when()
                .delete("http://localhost:3000/posts/22");
        res.prettyPrint();
    }
}
