package com.simpleims.steps.serenity;


import com.simpleims.pages.LoginAgentPage;
import com.simpleims.pages.MenuPage;
import com.simpleims.utils.ReadProperties;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class AgentGuiActions {

    LoginAgentPage loginPage;
    MenuPage menuPage;

    ReadProperties prop = new ReadProperties();

    public AgentGuiActions() throws IOException {
    }

    public void is_the_login_page() {
        loginPage.open();
    }

    public void enter_credentials() {
        login();

    }

    public void should_be_incidents_page(String url) {
        assertThat(loginPage.get_current_url(),equalToIgnoringCase(prop.getURL()));
    }

    public void login() {
        loginPage.enter_username();
        loginPage.enter_password();
        loginPage.submit_login();
        menuPage.is_user_visible();

    }
}
