package SpotifySeparate;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Episodes_Spotify {

    String token = "BQCB9hGVxXCmCV6v_6rxg016TjriLo3XdABS0iA9ZGBH_h8PCodEl3A-NUEnbYJ1nElfrttFZSiudHlE0qfrh3zy3WCGvKH8mPKbgvwo3ANdQTdllcXh5NCaZAcu6adPHDOboqxRMzYuiDxN1ATy2f3NfSTITlqdb-o21crqUXMnIvXZtNmruY9Bs25jp9WINXFxC4lLFc-0MuG0HN1AGgPvHxvtH1mL8Wu23Q1xxBjd3dxEQs6VRbaPPG0I0dXTlItYrFM--G-b-DRA0skqUqEe9KmCiFo3rfRe_xMjpatU-IYrDIGSt3-MRhgNA7EbMwFLdPjmMr9xWh0";

    @Test
    public void getEpisode(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .pathParam("id","5uyBDQWRrGeIf4z39qnPfz")
                .queryParam("market","IN")
                .when()
                .get("https://api.spotify.com/v1/episodes/{id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }




    @Test
    public void getSeveralEpisode() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                .queryParam("market", "ES")
                .when()
                .get("https://api.spotify.com/v1/episodes");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUsersSavedEpisodes() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("market", "IN")
                .queryParam("limit", 10)
                .queryParam("offset", 5)
                .when()
                .get("https://api.spotify.com/v1/me/episodes");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveEpisode() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"77o6BIVlYM3msb4MMIL1jH\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/episodes");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeEpisode() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .queryParam("ids", "7ouMYWpwJ422jRcDASZB7P")
                .when()
                .delete("https://api.spotify.com/v1/me/episodes");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void userSavedEpisode() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "5uyBDQWRrGeIf4z39qnPfz,3y585gudQpAoFB3cXSiOuR")
                .when()
                .get("https://api.spotify.com/v1/me/episodes/contains");
        res.prettyPrint();

        // Check the response status and content
        res.then().assertThat().statusCode(200);
    }


}
