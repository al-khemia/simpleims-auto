package com.simpleims.steps.serenity;


import com.simpleims.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class EndUserSteps {

    HomePage homePage;

//    @Step
//    public void enters(String keyword) {
//        dictionaryPage.enter_keywords(keyword);
//    }
//
//    @Step
//    public void starts_search() {
//        dictionaryPage.lookup_terms();
//    }
//
//    @Step
//    public void should_see_definition(String definition) {
//        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
//    }

    @Step
    public void is_the_home_page() {
        homePage.open();
        homePage.login();
    }

//    @Step
//    public void looks_for(String term) {
//        enters(term);
//        starts_search();
//    }
}