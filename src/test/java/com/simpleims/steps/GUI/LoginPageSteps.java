package com.simpleims.steps.GUI;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.simpleims.actions.AgentGuiActions;

public class LoginPageSteps {

    @Steps
    AgentGuiActions agent;

    @Given("agent is on the ims login page")
    public void givenTheAgentIsOnTheIMSLoginPage() {
        agent.is_the_login_page();
    }


    @When("agent enter credentials")
    public void whenTheAgentEnterCredentials() {
        agent.enter_credentials();
    }


    @Then("^agent should see the incidents page \"([^\"]*)\"$")
    public void agentShouldSeeTheIncidentsPage(String url) throws Throwable {
        agent.should_be_incidents_page(url);
    }

}
