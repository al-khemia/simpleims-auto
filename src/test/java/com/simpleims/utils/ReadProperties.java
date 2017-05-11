package com.simpleims.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by linfante on 5/9/2017.
 */
public class ReadProperties {

    Properties properties = new Properties();
    FileInputStream properties_file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\simpleims.properties");

    public ReadProperties() throws IOException {
        properties.load(properties_file);
    }

    public String getURL() {
        return properties.getProperty("default.url");
    }

    public String getAgentUsername() {
        return properties.getProperty("agent.username");
    }

    public String getAgentPassword() {
        return properties.getProperty("agent.password");
    }

    public String getAgentEmail() {
        return properties.getProperty("agent.email");
    }

    public Boolean getAgentActive() {
        return Boolean.valueOf(properties.getProperty("spec.agent.active"));
    }

    public String getSpecAgentUsername() {
        return properties.getProperty("spec.agent.username");
    }

    public String getSpecAgentEmail() {
        return properties.getProperty("spec.agent.email");
    }

    public Boolean getSpecAgentActive() {
        return Boolean.valueOf(properties.getProperty("spec.agent.active"));
    }
}
