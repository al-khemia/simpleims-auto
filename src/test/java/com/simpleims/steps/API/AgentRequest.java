package com.simpleims.steps.API;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.filter.cookie.CookieFilter;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by linfante on 5/3/2017.
 */
public class AgentRequest {
    CookieFilter cookie = new CookieFilter();

    @Given("^I login agent$")
    public void i_login_agent() throws Throwable {

        given().
                log().all().
                filter(cookie).
                redirects().follow(false).
                formParam("username","jacksmith").
                formParam("password", "group123").
        when().
                log().all().
                post("http://localhost:9000/login").
        then().
                statusCode(303).
                log().all();

    }

    @When("^I GET agent info$")
    public void i_GET_agent_info() throws Throwable {
        given().
                log().all().
                filter(cookie).
                when().
                get("http://localhost:9000/agent").
                then().
                statusCode(200).body("email",equalTo("jack@bigsoftware.com")).
                log().all();

    }

    @Then("^Response has a (\\d+) status$")
    public void response_has_a_status(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
