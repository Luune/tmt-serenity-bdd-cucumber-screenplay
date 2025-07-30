package com.example.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class UserApiSteps {

    private String apiEndpoint;
    private int userId;

    @Steps
    private UserApiActions userApiActions;

    @Given("the API endpoint is {string}")
    public void setApiEndpoint(String endpoint) {
        this.apiEndpoint = endpoint;
    }

    @When("I send a GET request with ID {string}")
    public void sendGetRequestWithId(String id) {
        this.userId = Integer.parseInt(id);
        userApiActions.getUserById(apiEndpoint, userId);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        int actualStatusCode = SerenityRest.lastResponse().statusCode();
        assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }

    @And("the response should contain user {string}")
    public void verifyResponseContainsUser(String expectedName) {
        String actualName = SerenityRest.lastResponse().jsonPath().getString("data.first_name");
        assertThat(actualName).isEqualTo(expectedName);
    }
}