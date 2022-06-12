package com.util.config;

public class ConfigUtilTest {

    public static void main(String[] args) {
        System.out.println(new YamlConfigurerUtil().getStrYmlVal("test.test"));
        System.out.println(new YamlConfigurerUtil().getIntegerYmlVal("test.num"));

        System.out.println(new YamlConfigurerUtil("application-dev.yml").getStrYmlVal("server.port.servlet.context-path"));
    }

}
