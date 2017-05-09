package com.simpleims.steps.serenity;

import com.simpleims.utils.ReadProperties;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.jruby.RubyProcess;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

/**
 * Created by linfante on 5/5/2017.
 */
public class AgentApiActions {
    RequestSpecification request;
    Response response;
    ValidatableResponse json;
    CookieFilter cookie = new CookieFilter();
    ReadProperties prop = new ReadProperties();

    public AgentApiActions() throws IOException {
    }

    public void authenticate(){
        request = given().
                filter(cookie).
                redirects().follow(false).
                formParam("username", prop.getAgentUsername()).
                formParam("password", prop.getAgentPassword());

    }

    public void sent_post_login() {
        response = request.when().
                post(prop.getURL()+"login");
    }

    public void validate_status(int code) {
        json = response.then().log().all().
                statusCode(code);
    }

    public void get_agent_info() {
        response = request.when().
                get(prop.getURL()+"agent");
    }

    public void validate_email() {
        json = response.then().log().all().
                body("email", equalTo(prop.getAgentEmail()));
    }

    public void is_active() {
        json = response.then().log().all().
                body("active", equalTo(prop.getAgentActive()));
    }

    public void get_agent_list() {
        response = request.when().
                get(prop.getURL()+"agents");
    }

    public void validate_usernameList(List<String> current_username) {
        String rta = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(rta);
        List<String> username_list = jsonPath.getList("username");

        assertThat(username_list, hasItems(current_username.toArray(new String[0])));
    }
}
