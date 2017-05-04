package com.simpleims.steps.serenity;


import com.simpleims.pages.LoginAgentPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;

public class EndUserSteps {

    LoginAgentPage loginPage;

    @Step
    public void is_the_login_page() {
        loginPage.open();
    }

    @Step
    public void enter_credentials() {
        login();
    }

    @Step
    public void should_be_incidents_page(String url) {
        assertThat(url, equals(loginPage.validate_page()));
    }

    public void login() {
        loginPage.enter_username();
        loginPage.enter_password();
        loginPage.submit_login();
    }
}
