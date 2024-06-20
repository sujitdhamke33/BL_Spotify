package SpotifySeparate;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Artist {

    String token = "BQCB9hGVxXCmCV6v_6rxg016TjriLo3XdABS0iA9ZGBH_h8PCodEl3A-NUEnbYJ1nElfrttFZSiudHlE0qfrh3zy3WCGvKH8mPKbgvwo3ANdQTdllcXh5NCaZAcu6adPHDOboqxRMzYuiDxN1ATy2f3NfSTITlqdb-o21crqUXMnIvXZtNmruY9Bs25jp9WINXFxC4lLFc-0MuG0HN1AGgPvHxvtH1mL8Wu23Q1xxBjd3dxEQs6VRbaPPG0I0dXTlItYrFM--G-b-DRA0skqUqEe9KmCiFo3rfRe_xMjpatU-IYrDIGSt3-MRhgNA7EbMwFLdPjmMr9xWh0";

    @Test
    public void getArtist(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .pathParam("id","4YRxDV8wJFPHPTeXepOstw")
                .when()
                .get("https://api.spotify.com/v1/artists/{id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralArtist() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "4YRxDV8wJFPHPTeXepOstw,45PG2L6Fh2XvYL4ONzpdoW,4B9efXsA6sv4w3vts8E0T7")
                .when()
                .get("https://api.spotify.com/v1/artists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getartistalbum(){
        Response res = given()
                .header("Authorization","Bearer " + token)
                .pathParam("artist_id","0TnOYISbd1XYRBk9myaseg")
                .when()
                .get("https://api.spotify.com/v1/artists/{artist_id}/albums");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getArtistTopTrack() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("artist_id", "6jJ0s89eD6GaHleKKya26X")
                .when()
                .get("https://api.spotify.com/v1/artists/{artist_id}/top-tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getrealtedartist(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .pathParam("artist_id","0TnOYISbd1XYRBk9myaseg")
                .when()
                .get("https://api.spotify.com/v1/artists/{artist_id}/related-artists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

}
