package com.simpleims.steps.GUI;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.simpleims.steps.serenity.EndUserSteps;

public class GoToHomePageSteps {

    @Steps
    EndUserSteps jack;

    @Given("agent is on the ims login page")
    public void givenTheAgentIsOnTheIMSLoginPage() {
        jack.is_the_login_page();
    }


    @When("agent enter credentials")
    public void whenTheAgentEnterCredentials() {
        jack.enter_credentials();
    }

    @Then("agent should be in the incidents page")
    public void thenAgentShouldBeInTheIncidentsPage(String definition) {
        jack.should_be_incidents_page();
    }
}
