package com.simpleims.actions;

import com.simpleims.utils.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.*;

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
        RestAssured.baseURI = prop.getURL();
        RestAssured.port = 9000;
//        cookie = new CookieFilter();
    }

    public void authenticate() {
        request = given().
                log().all().
                filter(cookie).
                redirects().follow(false).
                formParam("username", prop.getAgentUsername()).
                formParam("password", prop.getAgentPassword());

    }

    public void sent_post_login() {
        response = request.when().
                post("login");
    }


    public void validate_status(int code) {
        json = response.then().log().all().
                statusCode(code);
    }

    public void get_agent_info() {
        response = request.when().
                get("/agent");
    }

    public void validate_email(String agent) {

        String agent_query = agent.equalsIgnoreCase("specific") ? prop.getSpecAgentEmail() : prop.getAgentEmail();
        json = response.then().log().all().
                body("email", equalTo(agent_query));
    }

    public void is_active(String agent) {

        boolean agent_query = agent.equalsIgnoreCase("specific") ? prop.getSpecAgentActive() : prop.getAgentActive();
        json = response.then().log().all().
                body("active", equalTo(agent_query));

    }

    public void get_agent_list() {
        response = request.when().
                get("/agents");
    }

    public void validate_usernameList(List<String> current_username) {
//        String response_list = response.getBody().asString();
//        JsonPath jsonPath = new JsonPath(response_list);
//        List<String> username_list = jsonPath.getList("username");
//
//        assertThat(username_list, hasItems(current_username.toArray(new String[0])));

        response.then().body("username", hasItems(current_username.toArray()));
    }

    public void get_specific_agent_info() {
        response = request.when().
                get("/agents/" + prop.getSpecAgentUsername());
    }

    public void get_agent_incidents() {
        response = request.when().log().all().
                get("/agents/" + prop.getAgentUsername() + "/incidents");
    }

    public void validate_incident_numbers() {
        response.then().body("id", hasSize(4));
    }

    public void logout() {
        response = request.when().
                get("/logout");
    }

}

