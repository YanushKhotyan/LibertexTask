package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static core.RequestHandler.*;
import static core.UserGenerator.userDetails;
import static io.restassured.RestAssured.given;

public class RequestSteps {


    public Response createPostRequest(HashMap<String, String> user, String path) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .body(user).
                        when()
                        .post(URI + PORT + PATH + path);
    }

    public Response createGetRequest(String path) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .header("X-Session-Id", userDetails.getSessionToken()).
                        when()
                        .get(URI + PORT + PATH + path);
    }

    public Response createPostRequest(String path) {
        return
                given()
                        .contentType(ContentType.JSON).
                        when()
                        .post(URI + PORT + PATH + path);
    }

    public Response createGetRequestWithoutToken(String path) {
        return
                given()
                        .contentType(ContentType.JSON).
                        when()
                        .get(URI + PORT + PATH + path);
    }
}
