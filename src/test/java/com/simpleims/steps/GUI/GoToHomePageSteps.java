package com.simpleims.steps.GUI;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.simpleims.steps.serenity.EndUserSteps;

public class GoToHomePageSteps {

    @Steps
    EndUserSteps jack;

    @Given("the user is on the ims home page")
    public void givenTheUserIsOnTheIMSHomePage() {
        jack.is_the_home_page();
    }

/*
    @When("the user looks up the definition of the word '(.*)'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        anna.looks_for(word);
    }

    @Then("they should see the definition '(.*)'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        anna.should_see_definition(definition);
    }
*/

}