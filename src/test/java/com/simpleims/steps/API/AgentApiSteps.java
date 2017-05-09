package com.simpleims.steps.API;


import com.simpleims.steps.serenity.AgentApiActions;
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
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by linfante on 5/3/2017.
 */
public class AgentApiSteps {
    @Steps
    AgentApiActions agent;

    @Before
    @Given("^Agent has been authenticated$")
    public void agentHasBeenAuthenticated() throws Throwable {
        agent.authenticate();
        agent.sent_post_login();
    }

    @Step
    @Given("^Agent set an authentication request$")
    public void agent_set_an_authentication_request() throws Throwable {
        agent.authenticate();
    }

    @Step
    @When("^Agent sends a POST login request$")
    public void agent_sends_a_POST_login_request() throws Throwable {
        agent.sent_post_login();
    }

    @Step
    @Then("^Response has status code (\\d+)$")
    public void response_has_status_code(int code) throws Throwable {
        agent.validate_status(code);
    }

    @Step
    @When("^I GET agent info$")
    public void i_GET_agent_info() throws Throwable {
        agent.get_agent_info();
    }

    @Step
    @Then("^Agent info is accurate$")
    public void agent_info_is_accurate() throws Throwable {
        agent.validate_email();
        agent.is_active();
    }

    @When("^I GET agents list$")
    public void iGETAgentsList() throws Throwable {
        agent.get_agent_list();
    }

    @Then("^username should be <username>$")
    public void username_should_be_username(List<String> usernameList) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        agent.validate_usernameList(usernameList);

    }

}

