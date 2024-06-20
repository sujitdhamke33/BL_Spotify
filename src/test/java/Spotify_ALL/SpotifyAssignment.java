package Spotify_ALL;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyAssignment {
    // User Folder
    String token = "BQAAts_2W5EnQfG8I5ThLWQj-Nddgr7aExG0RGiGXziyib2ZVjyMo8E7XBQ3INXP-46xTNiPKZLf3y4Frcaecj_Pjd8MxHQbDP7IjiDuQa-rG66kupzwWT6CLxQxDakl5exDFozc_ispGghDvH5YmjE2xwebIEJGs7tAJQafF31Spl904DRY8U9pD2gOtYajP2byDvka8eh4YCcz18wXOZ47V5vY-OSmW_-s0pxNwtW08rI0ikefMd2dGDwqc1J8nDmLo36oKAoGhCCJnWSSOSQUgt1J46iOoljHCCoaJQDayc7PMowd8QXjc3tzyfaibu5HZs0op9090MY";

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

    // Album

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

    //Artist

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

    // AudioBooks

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



    // Catogories

    @Test
    public void getCategories() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("locale", "sv_SE")
                .queryParam("limit", 10)
                .queryParam("offset", 5)
                .when()
                .get("https://api.spotify.com/v1/browse/categories");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void singleBrowseHistoryCategory() {
        String categoryId = "dinner";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("category_id", categoryId)
                .queryParam("locale", "sv_SE")
                .when()
                .get("https://api.spotify.com/v1/browse/categories/{category_id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    // Episodes_Spotify

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

    // Genres

    @org.junit.Test
    public void availableSeeds(){
        Response res = given()
                .header("Authorization", "Bearer" + token)
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        res.prettyPrint();
    }

    // Markets

    @Test
    public void getmarket(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/markets");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    // Playlists

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
                        "    \"insert_before\": 3\n" +
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

    // Search

    @Test
    public void searchItem() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("q", "remaster track:Doxy artist:Miles Davis")
                .queryParam("type", "album")
                .queryParam("market", "ES")
                .queryParam("limit", 10)
                .queryParam("offset", 5)
                .when()
                .get("https://api.spotify.com/v1/search");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    // shows

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

    // Tracks

    @Test
    public void getTrack(){
        String trackId = "367wyLNqQMr5e8S2E6Zvpp";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("track_id", trackId)
                .when()
                .get("https://api.spotify.com/v1/tracks/{track_id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralTracks() {
        String trackIds = "72CkpVdvmc8t28o8I9N32J,7lVyNLH739NLN6Rp5R6r9u";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("market", "IN")
                .queryParam("ids", trackIds)
                .when()
                .get("https://api.spotify.com/v1/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void getSavedTracks(){
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveTrackUser(){
        String trackIds = "367wyLNqQMr5e8S2E6Zvpp,1u8c2t2Cy7UBoG4ArRcF5g";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body("{ \"ids\": [" + trackIds + "] }")
                .when()
                .put("https://api.spotify.com/v1/me/tracks?ids=" + trackIds);
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeTrack(){
        String trackIds = "367wyLNqQMr5e8S2E6Zvpp";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .delete("https://api.spotify.com/v1/me/tracks?ids=" + trackIds);
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkUserSavedTrack(){
        String trackIds = "1IIV8jglA0klVZy17q665k";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", trackIds)
                .when()
                .get("https://api.spotify.com/v1/me/tracks/contains");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getTrackAudio(){
        String trackIds = "1htQDV8JxSuXG2QsNj5ttr,4jbmgIyjGoXjY01XxatOx6";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", trackIds)
                .when()
                .get("https://api.spotify.com/v1/audio-features");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void trackAudio(){
        String trackId = "4jbmgIyjGoXjY01XxatOx6";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("track_id", trackId)
                .when()
                .get("https://api.spotify.com/v1/audio-features/{track_id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void trackAudioAnalysis(){
        String trackId = "4jbmgIyjGoXjY01XxatOx6";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("track_id", trackId)
                .when()
                .get("https://api.spotify.com/v1/audio-analysis/{track_id}");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getRecommendation(){
        String seedArtists = "6jJ0s89eD6GaHleKKya26X";
        String seedGenres = "classical";
        String seedTracks = "1htQDV8JxSuXG2QsNj5ttr";

        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("seed_artists", seedArtists)
                .queryParam("seed_genres", seedGenres)
                .queryParam("seed_tracks", seedTracks)
                .when()
                .get("https://api.spotify.com/v1/recommendations");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    //Spotify Player
    @Test
    public void getplayBackState()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("market","IN")
                .when()
                .get("https://api.spotify.com/v1/me/player");

        response.prettyPrint();
        response.then().statusCode(204);
    }
    @Test
    public void TransferPlayback()
    {
        Response response= given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + token)
                .queryParams("market","IN")
                .when()
                .put("https://api.spotify.com/v1/me/player");

        response.prettyPrint();
        response.then().statusCode(403);
        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

    @Test
    public void getAvailableDevice()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("market","IN")
                .when()
                .get("https://api.spotify.com/v1/me/player/devices");

        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getcurrentPlayableTrack()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/player/currently-playing");

        response.prettyPrint();
        response.then().statusCode(204);
    }


    @Test
    public void PausePlayback()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("device_id","0d1841b0976bae2a3a310dd74c0f3df354899bc8")
                .when()
                .put("https://api.spotify.com/v1/me/player/play");

        response.prettyPrint();
        response.then().statusCode(403);

        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

    @Test
    public void pauseTonext()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("device_id","0d1841b0976bae2a3a310dd74c0f3df354899bc8")
                .when()
                .post("https://api.spotify.com/v1/me/player/next");

        response.prettyPrint();
        response.then().statusCode(403);

        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

    @Test
    public void skipToprevious()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("device_id","0d1841b0976bae2a3a310dd74c0f3df354899bc8")
                .when()
                .post("https://api.spotify.com/v1/me/player/previous");

        response.prettyPrint();
        response.then().statusCode(403);

        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

    @Test
    public void seekToposition()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("device_id","0d1841b0976bae2a3a310dd74c0f3df354899bc8",
                        "position_ms","1200")
                .when()
                .put("https://api.spotify.com/v1/me/player/seek");

        response.prettyPrint();
        response.then().statusCode(403);

        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

    @Test
    public void setTorepeat()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("state","true")
                .when()
                .put("https://api.spotify.com/v1/me/player/shuffle?state=true");

        response.prettyPrint();
        response.then().statusCode(403);

        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

    @Test
    public void setPlaybackVolume()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("volume_percent",23,
                        "device_id","0d1841b0976bae2a3a310dd74c0f3df354899bc8")
                .when()
                .put("https://api.spotify.com/v1/me/player/volume");

        response.prettyPrint();
        response.then().statusCode(403);

        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

    @Test
    public void ToggleplaybackShufffle()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("volume_percent",23,
                        "device_id","0d1841b0976bae2a3a310dd74c0f3df354899bc8")
                .when()
                .put("https://api.spotify.com/v1/me/player/shuffle");
        response.prettyPrint();
        response.then().statusCode(403);

        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

    @Test
    public void getRecentlyPlayedTrack()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("limit",8,
                        "after","148")
                .when()
                .get("https://api.spotify.com/v1/me/player/recently-played");

        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getUserQueue()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/player/queue");

        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void addItemstoplayback()
    {
        Response response= given()
                .header("Authorization","Bearer " + token)
                .queryParams("uri","spotify%253Atrack%253A4iV5W9uYEdYUVa79Axb7Rh","device_id","0d1841b0976bae2a3a310dd74c0f3df354899bc8")
                .when()
                .post("https://api.spotify.com/v1/me/player/queue");

        response.prettyPrint();
        String reason=response.path("error.reason");
        Assert.assertEquals(reason,"PREMIUM_REQUIRED");
    }

}
