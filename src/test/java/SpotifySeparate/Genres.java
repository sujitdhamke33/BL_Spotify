package SpotifySeparate;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Genres {

    String token = "BQC6AmtzY63ZB0RtyS4BV8H6wZpgHkRD725VF4pJuiUQrOJrZl3adeO3WKHQMHk49aVUlOOFCNZMhNyIIui-44c45VDd8VPMLQV8CuU7tv6qatD1AS-oliZVdnXmueThvy2VryhzbnaoGG0qbLjJ4ARmSs3RYOE9eyvrBEby_Qu3r5g6hKg3cE819m7Z3EnVlh5qoqzGfg7UVguMKgREmjqXXscajnxGOklAOos96nJZlbYxXooORDODex6ar5Mw_AEUx55Fy4kXBZYXu6BiHLoU5p3RQu4dJUHB6SV0eb1DXffYA6Ulqk2h4rwswkQzVH9irctUj8VV3w4";

    @Test
    public void availableSeeds(){
        Response res = given()
                .header("Authorization", "Bearer" + token)
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        res.prettyPrint();
    }

}
