package com.example.firstcrawler.jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

/**
 * jsoup对多线程、连接池、代理支出不太好，一般使用jsoup作为html的解析工具
 */
@SpringBootTest
public class JsoupFirstTest {


    @Test
    void testUrl() throws Exception {
        //解析url地址
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);

        //使用标签选择器
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);

    }
}
