package SpotifySeparate;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Catogories {
    String token = "BQCB9hGVxXCmCV6v_6rxg016TjriLo3XdABS0iA9ZGBH_h8PCodEl3A-NUEnbYJ1nElfrttFZSiudHlE0qfrh3zy3WCGvKH8mPKbgvwo3ANdQTdllcXh5NCaZAcu6adPHDOboqxRMzYuiDxN1ATy2f3NfSTITlqdb-o21crqUXMnIvXZtNmruY9Bs25jp9WINXFxC4lLFc-0MuG0HN1AGgPvHxvtH1mL8Wu23Q1xxBjd3dxEQs6VRbaPPG0I0dXTlItYrFM--G-b-DRA0skqUqEe9KmCiFo3rfRe_xMjpatU-IYrDIGSt3-MRhgNA7EbMwFLdPjmMr9xWh0";


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

}
