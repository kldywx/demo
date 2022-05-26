package com.util;

import com.DemoTestApplication;
import com.util.LinkedHashMapUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;

@SpringBootTest(classes = DemoTestApplication.class)
public class UtilTest {

    @Test
    public void linkedHashMapUtil() {
        String jsonString = "{\"SJ1\":200,\"SJ2\":\"身份证号码\"}";

        LinkedHashMap<String, Object> linkedHashMap = LinkedHashMapUtil.toLinkedHashMap(jsonString);

        LinkedHashMapUtil.showForEachBy1(linkedHashMap);
        LinkedHashMapUtil.showForEachBy2(linkedHashMap);
        LinkedHashMapUtil.showForEachBy3(linkedHashMap);
        LinkedHashMapUtil.showForEachBy4(linkedHashMap);
        LinkedHashMapUtil.showForEachBy5(linkedHashMap);
        LinkedHashMapUtil.showForEachBy6(linkedHashMap);

    }

}
