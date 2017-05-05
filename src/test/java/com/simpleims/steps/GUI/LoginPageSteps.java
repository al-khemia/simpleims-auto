package com.simpleims.steps.GUI;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.simpleims.steps.serenity.AgentSteps;

public class LoginPageSteps {

    @Steps
    AgentSteps jack;

    @Given("agent is on the ims login page")
    public void givenTheAgentIsOnTheIMSLoginPage() {
        jack.is_the_login_page();
    }


    @When("agent enter credentials")
    public void whenTheAgentEnterCredentials() {
        jack.enter_credentials();
    }


    @Then("^agent should see the incidents page \"([^\"]*)\"$")
    public void agentShouldSeeTheIncidentsPage(String url) throws Throwable {
        jack.should_be_incidents_page(url);
    }
}
