package SpotifySeparate;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class User {
    String token = "BQDWp7akE2z-UmesNcOZBrUf0wCxpuiFX2TTALaVqOs87Tskv8x84LxPIXTz35uImgIjop2EBGMBm0qGHbxPgxeJbDZ0-PjUgJWukz9gcY8XMLHrDJj084JONiWat3XGEVj3Vg99e07PmzoUGWiBKOSn_bRaPHL89VXxdrXqW9_DVCp6BFRfxhl2Bjr6H5708TpSdcnMiI-97W2g5YtKQxBlHx7qMXGuHLjaK5XZo4SdTbU5Xe2ncArj3FF9w2rAsjpPdBF4EFh1RD4H8nsB0HKXLfXXSy5YJllrrAXBDjmYlwr661xObQ4AWdRvMc44e4fLSdVfx0XRBW0";

    @Test
    public void getUser() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

        String id = res.path("id");
        Assert.assertEquals(id, "31rvknbjilpwjojwvd4l7cosupdm");
    }

    @Test
    public void getUserProfile() {
        String userId = "31ofzxzjxtpqnuy3hu5znlr5mucu";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("user_id", userId)
                .when()
                .get("https://api.spotify.com/v1/users/{user_id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void followPlaylist() {
        String playlistId = "6ullfg71kIlvgYMovb3kyf";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"public\": false\n" +
                        "}")
                .pathParam("playlist_id", playlistId)
                .when()
                .put("https://api.spotify.com/v1/playlists/{playlist_id}/followers");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void unfollowPlaylist() {
        String playlistId = "4J8n9H0SgXHCavOIxkLWCA";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("playlist_id", playlistId)
                .when()
                .delete("https://api.spotify.com/v1/playlists/{playlist_id}/followers");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void followArtist() {
        String artistId = "0y59o4v8uw5crbN9M3JiL1";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .queryParam("type", "artist")
                .queryParam("ids", artistId)
                .when()
                .put("https://api.spotify.com/v1/me/following");
        res.then().assertThat().statusCode(204);
        res.prettyPrint();
    }

    @Test
    public void checkUserFollowArtist() {
        String artistId = "1uNFoZAHBGtllmzznpCI3s";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("type", "artist")
                .queryParam("ids", artistId)
                .when()
                .get("https://api.spotify.com/v1/me/following");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkUserFollowPlaylist() {
        String playlistId = "6vllnRnCww9sc8sBNmqNPZ";
        String userId = "31rvknbjilpwjojwvd4l7cosupdm";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("playlist_id", playlistId)
                .queryParam("ids", userId)
                .when()
                .get("https://api.spotify.com/v1/playlists/{playlist_id}/followers/contains");
        res.prettyPrint();
    }

    @Test
    public void unfollowArtist() {
        String artistId = "1uNFoZAHBGtllmzznpCI3s";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .queryParam("type", "artist")
                .queryParam("ids", artistId)
                .when()
                .delete("https://api.spotify.com/v1/me/following");
        res.then().assertThat().statusCode(204);
        res.prettyPrint();
    }

    @Test
    public void getUserTopItems() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/top/artists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getFollowedArtists() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("type", "artist")
                .when()
                .get("https://api.spotify.com/v1/me/following");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void userUnfollowPlaylist() {
        String playlistId = "6vllnRnCww9sc8sBNmqNPZ";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("playlist_id", playlistId)
                .when()
                .delete("https://api.spotify.com/v1/playlists/{playlist_id}/followers");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }


}
