package com.util;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * data conversion : 数据转换
 *  String To LinkedHashMap , LinkedHashMap 取 K 、V 、K-V
 */
public class LinkedHashMapUtil {

    /**
     *  String json to LinkedHashMap
     * @return
     */
    public static LinkedHashMap<String, Object> toLinkedHashMap(String jsonString) {
        return JSONObject.parseObject(jsonString, LinkedHashMap.class);
    }

    /**
     * String json to LinkedHashMap to K键、V值、K-V 键-值
     */
    public static void showForEachBy1(LinkedHashMap<String, Object> linkedHashMap) {
        System.out.println("-----第一组: 先取出 所有的Key , 通过Key 取出对应的Value-------");
        Set keyset = linkedHashMap.keySet();
        System.out.println("-----第一种方式 : (1) 增强for-------");
        for (Object key : keyset) {
            System.out.println(key + "-" + linkedHashMap.get(key));
        }
    }

    public static void showForEachBy2(LinkedHashMap<String, Object> linkedHashMap) {
        System.out.println("-----第一组: 先取出 所有的Key , 通过Key 取出对应的Value-------");
        Set keyset = linkedHashMap.keySet();
        System.out.println("-----第二种方式 : (2) 迭代器-------");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + linkedHashMap.get(key));
        }
    }

    public static void showForEachBy3(LinkedHashMap<String, Object> linkedHashMap) {
        System.out.println("-----第二组: 把所有的values取出-------");
        //这里可以使用所有的Collections使用的遍历方法
        Collection values = linkedHashMap.values();
        System.out.println("-----第一种方式 : (1) 增强for 取出所有的value-------");
        for (Object value : values) {
            System.out.println(value);
        }
    }

    public static void showForEachBy4(LinkedHashMap<String, Object> linkedHashMap) {
        System.out.println("-----第二组: 把所有的values取出-------");
        //这里可以使用所有的Collections使用的遍历方法
        Collection values = linkedHashMap.values();
        System.out.println("-----第二种方式 : (2) 迭代器 取出所有的value-------");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println(value);

        }
    }

    public static void showForEachBy5(LinkedHashMap<String, Object> linkedHashMap) {
        System.out.println("-----第三组: 通过EntrySet 来获取 k-v-------");
        // EntrySet<Map.Entry<K,V>>
        Set entrySet = linkedHashMap.entrySet();
        System.out.println("-----第一种方式 : (1) 增强for 使用EntrySet 的 for增强(第3种)-------");
        for (Object entry : entrySet) {
            //将entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }

    public static void showForEachBy6(LinkedHashMap<String, Object> linkedHashMap) {
        System.out.println("-----第三组: 通过EntrySet 来获取 k-v-------");
        // EntrySet<Map.Entry<K,V>>
        Set entrySet = linkedHashMap.entrySet();
        System.out.println("-----第二种方式 : (2) 迭代器 使用EntrySet 的 迭代器(第4种)-------");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry =  iterator3.next();
            //向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }

}
