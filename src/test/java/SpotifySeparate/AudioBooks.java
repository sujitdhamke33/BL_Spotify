package SpotifySeparate;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AudioBooks {

    String token = "BQBh5wFJMcXYdv1_uHnIxa5Z9nIFEw0PJ_6l14pK1OmD0Ioel_MR3KOFDoxwMTxl0R_uGMNn_N-z22MkgmyZ9HsgiT6BrLtdmU8ZYgaloUohlndMgWjPOABDKzfZ5nXvzOX4lwy6IOS3fiEp2cqFWO2qHb5TyYBV4pjuGQ5yoHYCtzF_Hf5rM0rLxnr8nchAoEb3c9RARCOyefPOm-EZk8g0DnuWqvdeIKDeRyVFoy2QLtjJCSuT7UWBdoAILpDGm-72LPHgaICalS0PH35NLQDtiApXvn97-yUegHHQlLJq7nsHEbFSR4gkGcHlvL4QHyLIa_4uGK_U5wY";

    @Test
    public void getAudiobook() {
        String audiobookId = "7iHfbu1YPACw6oZPAFJtqe";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("audiobook_id", audiobookId)
                .queryParam("market", "ES")
                .when()
                .get("https://api.spotify.com/v1/audiobooks/{audiobook_id}");
        res.then().assertThat().statusCode(404);
        res.prettyPrint();
    }

    @Test
    public void getSeveralAB() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe")
                .queryParam("market", "ES")
                .when()
                .get("https://api.spotify.com/v1/audiobooks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getAudiobookChapters() {
        String audiobookId = "7iHfbu1YPACw6oZPAFJtqe";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("audiobook_id", audiobookId)
                .when()
                .get("https://api.spotify.com/v1/audiobooks/{audiobook_id}/chapters");
        res.then().assertThat().statusCode(404);
        res.prettyPrint();
    }
    @Test
    public void getUserSavedAudiobooks() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("limit", 10)
                .queryParam("offset", 5)
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }


    @Test
    public void savedAudioCurrentUser() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkSavedAudioUser() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks/contains");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }


    @Test
    public void removeSavedAudio() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .delete("https://api.spotify.com/v1/me/audiobooks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

}
