package com.simpleims.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by linfante on 5/4/2017.
 */

//Same incidents page
@DefaultUrl("http://localhost:9000/#/")
public class WelcomePage extends PageObject {


    @FindBy(css = ".btn-success")
    private WebElementFacade btn_create_incident;

}
