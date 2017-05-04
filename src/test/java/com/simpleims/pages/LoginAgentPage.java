package com.simpleims.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://localhost:9000/")
public class HomePage extends PageObject {

    @FindBy(name="username")
    private  WebElementFacade username;

    @FindBy(name="password")
    private  WebElementFacade password;

    @FindBy(css = "button")
    private  WebElementFacade btn_submit;

    String key_username="jacksmith";
    String key_password="group123";

    public void enter_username() {
        username.type(key_username);
    }

    public void enter_password() {
        password.sendKeys(key_password);
    }

    public void submit_login() {
        btn_submit.click();
    }

    public void login() {
        enter_username();
        enter_password();
        submit_login();
    }

}