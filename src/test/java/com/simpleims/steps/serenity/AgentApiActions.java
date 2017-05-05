package com.simpleims.steps.serenity;

import io.restassured.filter.cookie.CookieFilter;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by linfante on 5/5/2017.
 */
public class AgentApiActions {
    RequestSpecification request;
    Response response;
    ValidatableResponse json;
    CookieFilter cookie = new CookieFilter();

    public void authenticate() {
        request = given().
                filter(cookie).
                redirects().follow(false).
                formParam("username", "jacksmith").
                formParam("password", "group123");
    }

    public void sent_post_login() {
        response = request.when().
                post("http://localhost:9000/login");
    }

    public void validate_status(int code) {
        json = response.then().log().all().
                statusCode(code);
    }

    public void get_agent_info() {
        response = request.when().
                get("http://localhost:9000/agent");
    }

    public void validate_email(String current_email) {
        json = response.then().log().all().
                body("email", equalTo(current_email));
    }

    public void is_active(Boolean current_active) {
        json = response.then().log().all().
                body("active", equalTo(current_active));
    }
}
