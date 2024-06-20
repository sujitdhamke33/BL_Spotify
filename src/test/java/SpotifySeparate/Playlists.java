package SpotifySeparate;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Playlists {

    String token = "BQB09Cl5zazy0VjBDkm5XPyMNMIXu0zQuW-LICQBK4mQ9XwWw2Xz6hzkUsgjkJWFfyUlizlgfEUEpBK_L4JlR2FDKjVRSrZzmr_6Yc_wAL_58wM9txjfhlhidgE--wRkFL8CvII3X0Q_JydacwkoNl69rnfpkgzhZvefzHqX24Lsj5kJyi4AvlEgjenXaHJgqpKgnHXNs2-C39E0OTM-POBY59JHz0vT-Hy9ymKdrbMZUTSVBnkLb35mZ2noi6NaggkXwftmrYb_BpJh9pJ0Yl3axh2ITZdWMfEbyARoUnYUYsEIwrtqH-y4jqymW9MNFLFnmrw4Itccmc0";

    @Test
    public void createplaylist(){

        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .pathParam("id","31rvknbjilpwjojwvd4l7cosupdm")
                .when()
                .get("https://api.spotify.com/v1/users/{id}/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getPlaylist() {
        String playlistId = "6ullfg71kIlvgYMovb3kyf";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("playlist_id", playlistId)
                .when()
                .get("https://api.spotify.com/v1/playlists/{playlist_id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getPlaylistItems() {
        String playlistId = "6ullfg71kIlvgYMovb3kyf";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("playlist_id", playlistId)
                .when()
                .get("https://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void addItemToPlaylist() {
        String playlistId = "6vllnRnCww9sc8sBNmqNPZ";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"uris\": [\n" +
                        "        \"spotify:track:7m4CgL81VVIHaaiSxyH922\"\n" +
                        "    ],\n" +
                        "    \"position\": 0\n" +
                        "}")
                .pathParam("playlist_id", playlistId)
                .when()
                .post("https://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void getCurrentUserPlaylists() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUserPlaylists() {
        String userId = "312jqdjelnjctt7ckomd3bzbopla";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("user_id", userId)
                .when()
                .get("https://api.spotify.com/v1/users/{user_id}/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removePlaylistItem() {
        String playlistId = "6vllnRnCww9sc8sBNmqNPZ";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"tracks\": [\n" +
                        "        {\n" +
                        "            \"uri\": \"spotify:track:6vllnRnCww9sc8sBNmqNPZ\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"snapshot_id\": \"AAAABg7AFiwJHrz1HJQDXaKVRoQdnD7Y\"\n" +
                        "}")
                .pathParam("playlist_id", playlistId)
                .when()
                .delete("https://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void changePlaylistDetails() {
        String playlistId = "6ullfg71kIlvgYMovb3kyf";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .pathParam("playlist_id", playlistId)
                .when()
                .get("https://api.spotify.com/v1/playlists/{playlist_id}/tracks/");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getCoverImage() {
        String playlistId = "6ullfg71kIlvgYMovb3kyf";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("playlist_id", playlistId)
                .when()
                .get("https://api.spotify.com/v1/playlists/{playlist_id}/images");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void updatePlaylistItem() {
        String playlistId = "6vllnRnCww9sc8sBNmqNPZ";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"range_start\": 1,\n" +
                        "    \"insert_before\": 3\n" +  // insert_before value should be within the valid range
                        "}")
                .pathParam("playlist_id", playlistId)
                .when()
                .put("https://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getFeaturedPlaylists() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getCategoryPlaylists() {
        String categoryId = "0JQ5DAt0tbjZptfcdMSKl3";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("category_id", categoryId)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/{category_id}/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
}
