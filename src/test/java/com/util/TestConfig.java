package com.util;

import com.DemoTestApplication;
import com.config.GetConfigByConfigurationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoTestApplication.class)
public class TestConfig {

    private final GetConfigByConfigurationProperties systemConfig;

    public TestConfig(GetConfigByConfigurationProperties systemConfig) {
        this.systemConfig = systemConfig;
    }

    @Test
    void test(){
        System.out.println(systemConfig.toString());
    }

}
