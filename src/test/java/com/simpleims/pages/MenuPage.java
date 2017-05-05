package com.simpleims.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by linfante on 5/4/2017.
 */
public class MenuPage extends PageObject {
    @FindBy(css="[href='/']")
    private WebElementFacade nav_incidents;

    @FindBy(css="[href='#/contacts']")
    private WebElementFacade nav_contacts;

    @FindBy(css="[href='#/companies']")
    private WebElementFacade nav_companies;

    @FindBy(css="[href='#/reports']")
    private WebElementFacade nav_reports;

    @FindBy(css = "[href='/logout']")
    private  WebElementFacade btn_logout;

    public void is_user_visible() {
        btn_logout.waitUntilVisible();
    }
}
