package com.util.http.constants;

/**
 * @author duyunjie
 * @date 2019-09-19 16:37
 */
public class HttpConstants {
    //系统变量，控制HttpClientUtil中连接池的最大连接数
    public static final String SYSTEM_PROPERTY_KEY_HTTP_MAX_TOTAL = "http.max.total";
    //系统变量，控制HttpClientUtil中连接池的每个路由的最大连接数
    public static final String SYSTEM_PROPERTY_KEY_HTTP_MAX_PER_ROUTE = "http.max.per.route";
}
