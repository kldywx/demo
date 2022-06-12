package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "test")
public class GetConfigByConfigurationProperties {

    public String test;

    public GetConfigByConfigurationProperties() {
    }

    public GetConfigByConfigurationProperties(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
                "test='" + test + '\'' +
                '}';
    }

}
