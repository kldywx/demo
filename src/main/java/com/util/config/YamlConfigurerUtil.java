package com.util.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * 获取配置信息
 *
 * @author 许文博
 * @date 2022/5/01 10:00
 */
public class YamlConfigurerUtil {

    private Properties ymlProperties = null;

    public YamlConfigurerUtil(){
        this("application.yml");
    }

    public YamlConfigurerUtil(String path){
        //1:加载配置文件
        Resource app = new ClassPathResource(path);
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        // 2:将加载的配置文件交给 YamlPropertiesFactoryBean
        yamlPropertiesFactoryBean.setResources(app);
        // 3：将yml转换成 key：val
        Properties properties = yamlPropertiesFactoryBean.getObject();
        ymlProperties = properties;
    }

    public String getStrYmlVal(String key){
        return ymlProperties.getProperty(key);
    }

    public Integer getIntegerYmlVal(String key){
        return Integer.valueOf(ymlProperties.getProperty(key));
    }

}
