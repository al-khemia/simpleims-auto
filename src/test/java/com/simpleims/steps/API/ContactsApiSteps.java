package com.simpleims.steps.API;

import com.simpleims.services.ServiceStepsDef;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by linfante on 5/11/2017.
 */
public class ContactsApiSteps {
    @Steps
    ServiceStepsDef service;
    String current_contact;

    @When("^Agent sends a POST to update contact$")
    public void agentSendsAPOSTToUpdateContact() throws Throwable {
        service.sent_post_update_contact(current_contact);
    }

    @When("^Agent sends a DELETE to delete contact$")
    public void agentSendsADELETEToDeleteContact() throws Throwable {
        service.sent_delete_contact();
    }
}
