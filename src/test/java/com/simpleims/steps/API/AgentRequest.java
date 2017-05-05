package com.simpleims.steps.API;


import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by linfante on 5/3/2017.
 */
public class AgentRequest {
    RequestSpecification request;
    Response response;
    ValidatableResponse json;
    CookieFilter cookie = new CookieFilter();

    @Before
    @Given("^Agent set an authentication request$")
    public void agent_set_an_authentication_request() throws Throwable {

        request = given().
                log().all().
                filter(cookie).
                redirects().follow(false).
                formParam("username", "jacksmith").
                formParam("password", "group123");
//        when().
//                log().all().
//                post("http://localhost:9000/login").
//        then().
//                statusCode(303).
//                log().all();

    }

    @When("^Agent sends a POST login request$")
    public void agent_sends_a_POST_login_request() throws Throwable {
        response = request.when().
                post("http://localhost:9000/login");
    }

    @Then("^Response has status code (\\d+)$")
    public void response_has_status_code(int code) throws Throwable {
        json = response.then().
                statusCode(code).
                log().all();
    }

    @When("^I GET agent info$")
    public void i_GET_agent_info() throws Throwable {
//        given().
//                log().all().
//                filter(cookie).
        response = request.when().
                get("http://localhost:9000/agent");


    }


    @Then("^Email should be \"([^\"]*)\"$")
    public void email_should_be(String current_email) throws Throwable {
        json = response.then().body("email", equalTo(current_email)).
                log().all();
    }
}
