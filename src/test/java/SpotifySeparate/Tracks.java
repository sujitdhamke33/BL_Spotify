package SpotifySeparate;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Tracks {

    String token = "BQDWp7akE2z-UmesNcOZBrUf0wCxpuiFX2TTALaVqOs87Tskv8x84LxPIXTz35uImgIjop2EBGMBm0qGHbxPgxeJbDZ0-PjUgJWukz9gcY8XMLHrDJj084JONiWat3XGEVj3Vg99e07PmzoUGWiBKOSn_bRaPHL89VXxdrXqW9_DVCp6BFRfxhl2Bjr6H5708TpSdcnMiI-97W2g5YtKQxBlHx7qMXGuHLjaK5XZo4SdTbU5Xe2ncArj3FF9w2rAsjpPdBF4EFh1RD4H8nsB0HKXLfXXSy5YJllrrAXBDjmYlwr661xObQ4AWdRvMc44e4fLSdVfx0XRBW0";

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

}
