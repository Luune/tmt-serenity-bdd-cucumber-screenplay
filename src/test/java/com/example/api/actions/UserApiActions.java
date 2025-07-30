package com.example.api.actions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;

public class UserApiActions {

    @Step("Get user by ID")
    public void getUserById(String endpoint, int userId) {
        SerenityRest.given()
                .baseUri(endpoint)
                .when()
                .get("/{id}", userId)
                .then()
                .log().all();
    }
}