package SpotifySeparate;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Shows {
String token = "BQDWp7akE2z-UmesNcOZBrUf0wCxpuiFX2TTALaVqOs87Tskv8x84LxPIXTz35uImgIjop2EBGMBm0qGHbxPgxeJbDZ0-PjUgJWukz9gcY8XMLHrDJj084JONiWat3XGEVj3Vg99e07PmzoUGWiBKOSn_bRaPHL89VXxdrXqW9_DVCp6BFRfxhl2Bjr6H5708TpSdcnMiI-97W2g5YtKQxBlHx7qMXGuHLjaK5XZo4SdTbU5Xe2ncArj3FF9w2rAsjpPdBF4EFh1RD4H8nsB0HKXLfXXSy5YJllrrAXBDjmYlwr661xObQ4AWdRvMc44e4fLSdVfx0XRBW0";
    @Test
    public void getShows(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .pathParam("showId","0jCWG5oU6BvRtlLwusgLv5")
                .queryParam("market","IN")
                .when()
                .get("https://api.spotify.com/v1/shows/{showId}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void getSeveralShows() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("market", "IN")
                .queryParam("ids", "0jCWG5oU6BvRtlLwusgLv5,3ZkMAJOKyYkPpjBlk7tO6L")
                .when()
                .get("https://api.spotify.com/v1/shows");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getShowEpisode() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("limit", 10)
                .queryParam("offset", 5)
                .when()
                .get("https://api.spotify.com/v1/me/shows");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUserSavedShows() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("limit", 10)
                .queryParam("offset", 5)
                .when()
                .get("https://api.spotify.com/v1/me/shows");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveShow() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "0jCWG5oU6BvRtlLwusgLv5,3ZkMAJOKyYkPpjBlk7tO6L")
                .when()
                .put("https://api.spotify.com/v1/me/shows");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeShow() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "3ZkMAJOKyYkPpjBlk7tO6L")
                .queryParam("market", "ES")
                .when()
                .delete("https://api.spotify.com/v1/me/shows");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkSavedShow() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "0jCWG5oU6BvRtlLwusgLv5,3ZkMAJOKyYkPpjBlk7tO6L")
                .when()
                .get("https://api.spotify.com/v1/me/shows/contains");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
}

