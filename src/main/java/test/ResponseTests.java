package test;

import io.restassured.response.Response;

import static core.UserGenerator.userDetails;
import static org.hamcrest.Matchers.is;

public class ResponseTests {

    public void checkRegistrationUser(Response response) {
        response.then().statusCode(200).body("resultCode", is("Ok"));
    }

    public void checkUserSignIn(Response response) {
        response.then().statusCode(200).body("resultCode", is("Ok"));
        userDetails.setSessionToken(response.header("X-Session-Id"));
    }

    public void checkUserLogout(Response response) {
        response.then().statusCode(200).body("resultCode", is("Ok"));
    }

    public void checkHelloMassage(Response response) {
        response.then().statusCode(200).body("resultCode", is("Ok"));
        response.then().body("message", is("Hello, "+userDetails.getFullName()+"!"));
    }

    public void checkUserSignIn(Response response, String resultCode, String errorMassage, String statusCode) {
        System.out.println(response.body().print());
        response.then().statusCode(Integer.valueOf(statusCode)).body("resultCode", is(resultCode));
        response.then().body("errorMessage", is(errorMassage));
    }

    public void checkGetHelloResponse(Response response, String resultCode, String statusCode) {
        System.out.println(response.body().print());
        response.then().statusCode(Integer.valueOf(statusCode)).body("resultCode", is(resultCode));
    }
}
