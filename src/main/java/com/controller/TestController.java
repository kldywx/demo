package com.controller;

import com.config.GetConfigByConfigurationProperties;
import com.config.GetConfigByValueComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author
 */
@Controller
@RequestMapping("/test")
public class TestController {

	private static Logger log = LoggerFactory.getLogger(TestController.class);

	private GetConfigByValueComponent valueConfig;

	private GetConfigByConfigurationProperties systemConfig;

	public TestController(GetConfigByValueComponent valueConfig, GetConfigByConfigurationProperties systemConfig) {
		this.valueConfig = valueConfig;
		this.systemConfig = systemConfig;
	}

	/**
	 * Test
	 *
	 * @return String
	 */
	@RequestMapping(value = "/test" ,method = RequestMethod.POST)
	public String testApiController() {
		log.info("测试接口 : testApiController");
		log.info("valueConfig : " + valueConfig.getTest());
		log.info("systemConfig : " + systemConfig.getTest());
		return "Test";
	}
	
}
