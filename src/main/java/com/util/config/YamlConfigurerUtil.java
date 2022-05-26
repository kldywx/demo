package com.util.config;

import java.util.Properties;

/**
 * 获取配置信息
 *
 * @author 许文博
 * @date 2022/5/01 10:00
 */
public class YamlConfigurerUtil {

    private static Properties ymlProperties = new Properties();

    public YamlConfigurerUtil(Properties properties){
        ymlProperties = properties;
    }

    public static String getStrYmlVal(String key){
        return ymlProperties.getProperty(key);
    }

    public static Integer getIntegerYmlVal(String key){
        return Integer.valueOf(ymlProperties.getProperty(key));
    }

}
