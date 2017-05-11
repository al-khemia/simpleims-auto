package com.simpleims.steps.API;


import com.simpleims.actions.AgentApiActions;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;


/**
 * Created by linfante on 5/3/2017.
 */
public class AgentApiSteps{
    @Steps
    AgentApiActions action;

    @Before
    @Given("^Agent has been authenticated$")
    public void agentHasBeenAuthenticated() throws Throwable {
        action.authenticate();
        action.sent_post_login();
    }

    @Step
    @Then("^Response has status code (\\d+)$")
    public void response_has_status_code(int code) throws Throwable {
        action.validate_status(code);
    }

    @Step
    @Given("^Agent set an authentication request$")
    public void agent_set_an_authentication_request() throws Throwable {
        action.authenticate();
    }

    @Step
    @When("^Agent sends a POST login request$")
    public void agent_sends_a_POST_login_request() throws Throwable {
        action.sent_post_login();
    }

    @Step
    @When("^I GET agent info$")
    public void i_GET_agent_info() throws Throwable {
        action.get_agent_info();
    }

    @Step
    @Then("^Agent info is accurate$")
    public void agent_info_is_accurate() throws Throwable {
        action.validate_email("current");
        action.is_active("current");
    }

    @Step
    @Then("^Specific agent info is accurate$")
    public void specific_agent_info_is_accurate() throws Throwable {
        action.validate_email("specific");
        action.is_active("specific");
    }

    @When("^I GET agents list$")
    public void iGETAgentsList() throws Throwable {
        action.get_agent_list();
    }

    @Then("^username should be <username>$")
    public void username_should_be_username(List<String> usernameList) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        action.validate_usernameList(usernameList);

    }

    @When("^I GET specific agent info$")
    public void iGETSpecificAgentInfo() throws Throwable {
        action.get_specific_agent_info();
    }

    @When("^I GET incidents associated with agent$")
    public void iGETIncidentsAssociatedWithAgent() throws Throwable {
        action.get_agent_incidents();
    }

    @And("^Number of incidents is correct$")
    public void numberOfIncidentsIsCorrect() throws Throwable {
        action.validate_incident_numbers();
    }

    @When("^I GET logout from simpleims$")
    public void iGETLogoutFromSimpleims() throws Throwable {
        action.logout();
    }
}

