package SpotifySeparate;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Album {

static String token = "BQCB9hGVxXCmCV6v_6rxg016TjriLo3XdABS0iA9ZGBH_h8PCodEl3A-NUEnbYJ1nElfrttFZSiudHlE0qfrh3zy3WCGvKH8mPKbgvwo3ANdQTdllcXh5NCaZAcu6adPHDOboqxRMzYuiDxN1ATy2f3NfSTITlqdb-o21crqUXMnIvXZtNmruY9Bs25jp9WINXFxC4lLFc-0MuG0HN1AGgPvHxvtH1mL8Wu23Q1xxBjd3dxEQs6VRbaPPG0I0dXTlItYrFM--G-b-DRA0skqUqEe9KmCiFo3rfRe_xMjpatU-IYrDIGSt3-MRhgNA7EbMwFLdPjmMr9xWh0";
    @Test
    public void getalbum(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .pathParam("id","3g35NyznPvksBecm94JhG3")
                .queryParam("market","IN")
                .when()
                .get("https://api.spotify.com/v1/albums/{id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getseveralalbum(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .queryParam("ids", "3g35NyznPvksBecm94JhG3,6LWZ330atfYF43nk7m3pKW")
                .queryParam("market", "IN")
                .when()
                .get("https://api.spotify.com/v1/album");
        res.then().assertThat().statusCode(400);
        res.prettyPrint();
    }

    @Test
    public void getAlbumsTrack(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .queryParam("ids", "3g35NyznPvksBecm94JhG3,6LWZ330atfYF43nk7m3pKW")
                .queryParam("market", "IN")
                .when()
                .get("https://api.spotify.com/v1/albums");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void savedAlbum() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("limit", 10)
                .queryParam("offset", 5)
                .queryParam("market", "IN")
                .when()
                .get("https://api.spotify.com/v1/me/albums");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveAlbum() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{ \"ids\": [ \"47zMF6LrXQ8odi6Xv1unC0\" ] }")
                .when()
                .put("https://api.spotify.com/v1/me/albums");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeUserSavedAlbum() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .queryParam("ids", "3g35NyznPvksBecm94JhG3")
                .when()
                .delete("https://api.spotify.com/v1/me/albums");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void userSavedAlbum() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "3g35NyznPvksBecm94JhG3")
                .when()
                .get("https://api.spotify.com/v1/me/albums/contains");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getNewReleases() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
}
