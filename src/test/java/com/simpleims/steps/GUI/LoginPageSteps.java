package com.simpleims.steps.GUI;

import com.simpleims.pages.LoginAgentPage;
import com.simpleims.pages.MenuPage;
import com.simpleims.utils.ReadProperties;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class LoginPageSteps {

    LoginAgentPage loginPage;
    MenuPage menuPage;
    ReadProperties prop = new ReadProperties();

    public LoginPageSteps() throws IOException {
    }

    @Given("agent is on the ims login page")
    public void givenTheAgentIsOnTheIMSLoginPage() {
        loginPage.open();
    }

    @When("agent enter credentials")
    public void whenTheAgentEnterCredentials() {
        login();
    }

    @Then("^agent should see the incidents page \"([^\"]*)\"$")
    public void agentShouldSeeTheIncidentsPage(String url) throws Throwable {
        assertThat(loginPage.get_current_url(), equalToIgnoringCase(prop.getURL()));
    }

    public void login() {
        loginPage.enter_username();
        loginPage.enter_password();
        loginPage.submit_login();
        menuPage.is_user_visible();

    }

}
