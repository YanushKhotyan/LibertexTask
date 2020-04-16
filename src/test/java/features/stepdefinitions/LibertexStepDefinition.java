package features.stepdefinitions;

import api.RequestSteps;
import core.UserGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import test.ResponseTests;

import java.util.HashMap;

public class LibertexStepDefinition {
    UserGenerator generator = new UserGenerator();
    RequestSteps requestSteps = new RequestSteps();
    ResponseTests responseTests = new ResponseTests();

    @Then("User sign up with valid data {string}")
    public void userCreateNewAccount(String path) {
        Response response = requestSteps.createPostRequest(this.createUser(), path);
        responseTests.checkRegistrationUser(response);
    }

    @Given("User sign in to portal {string}")
    public void client(String path) {
        Response response = requestSteps.createPostRequest(this.getUserName(), path);
        responseTests.checkUserSignIn(response);
    }


    @Then("Check sign in success massage {string}")
    public void hello(String path) {
        Response response = requestSteps.createGetRequest(path);
        responseTests.checkHelloMassage(response);
    }

    @Then("Post challenge {string}")
    public void postChallenge(String path) {
        Response response = requestSteps.createPostRequest(path);
        responseTests.checkUserLogout(response);
    }

    @When("User logout {string}")
    public void userLogout(String path) {
        Response response = requestSteps.createPostRequest(this.getUserName(), path);
        responseTests.checkUserSignIn(response);
    }

    private HashMap<String, String> createUser() {
        generator.createUser();
        return generator.prepareFullUserDetailForRequest();
    }

    private HashMap<String, String> getUserName() {
        return generator.prepareUsernameForRequest();
    }

    private HashMap<String, String> getNewFullName() {
        generator.createUser();
        return generator.prepareUserFullNameForRequest();
    }

    private HashMap<String, String> getFullName() {
        return generator.prepareUserFullNameForRequest();
    }

    private HashMap<String, String> getUserNameAndFullName() {
        return generator.prepareFullUserDetailForRequest();
    }

    @When("Tries to create user {string} and check {string} and {string} and {string}")
    public void createUserWithFullNameAndCheckAndAnd(String path, String resultCode,
                                                     String errorMassage, String statusCode) {
        Response response = requestSteps.createPostRequest(this.getUserNameAndFullName(), path);
        responseTests.checkUserSignIn(response, resultCode, errorMassage, statusCode);
    }

    @Given("Tries to create user without name {string} and check {string} and {string} and {string}")
    public void triesToCreateUserWithoutNameAndCheckAndAnd(String path, String resultCode,
                                                           String errorMassage, String statusCode) {
        Response response = requestSteps.createPostRequest(this.getNewFullName(), path);
        responseTests.checkUserSignIn(response, resultCode, errorMassage, statusCode);
    }

    @When("User tries to login without token {string} and check {string} and {string}")
    public void userTriesToLoginWithoutTokenAndCheckAnd(String path, String resultCode,
                                                        String statusCode) {
        Response response = requestSteps.createGetRequestWithoutToken(path);
        responseTests.checkGetHelloResponse(response, resultCode, statusCode);
    }
}
