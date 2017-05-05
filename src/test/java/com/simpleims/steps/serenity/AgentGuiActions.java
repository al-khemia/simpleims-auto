package com.simpleims.steps.serenity;


import com.simpleims.pages.LoginAgentPage;
import com.simpleims.pages.MenuPage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class AgentGuiActions {

    LoginAgentPage loginPage;
    MenuPage menuPage;

    public void is_the_login_page() {
        loginPage.open();
    }

    public void enter_credentials() {
        login();

    }

    public void should_be_incidents_page(String url) {
        assertThat(loginPage.get_current_url(),equalToIgnoringCase(url));
    }

    public void login() {
        loginPage.enter_username();
        loginPage.enter_password();
        loginPage.submit_login();
        menuPage.is_user_visible();

    }
}
