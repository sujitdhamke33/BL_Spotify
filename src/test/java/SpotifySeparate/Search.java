package SpotifySeparate;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Search {

    String token = "BQB09Cl5zazy0VjBDkm5XPyMNMIXu0zQuW-LICQBK4mQ9XwWw2Xz6hzkUsgjkJWFfyUlizlgfEUEpBK_L4JlR2FDKjVRSrZzmr_6Yc_wAL_58wM9txjfhlhidgE--wRkFL8CvII3X0Q_JydacwkoNl69rnfpkgzhZvefzHqX24Lsj5kJyi4AvlEgjenXaHJgqpKgnHXNs2-C39E0OTM-POBY59JHz0vT-Hy9ymKdrbMZUTSVBnkLb35mZ2noi6NaggkXwftmrYb_BpJh9pJ0Yl3axh2ITZdWMfEbyARoUnYUYsEIwrtqH-y4jqymW9MNFLFnmrw4Itccmc0";

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


}
