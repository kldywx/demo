package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetConfigByValueComponent {

    @Value("${test.test}")
    public String test;

    public GetConfigByValueComponent() {
    }

    public GetConfigByValueComponent(String test) {
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
