package com.example.firstcrawler.jsoup;


import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
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

    @Test
    void testString() throws Exception {
        //使用工具类读取文件，获取字符串
        String content = FileUtils.readFileToString(new File("D:\\Java爬虫\\first-crawler\\src\\main\\resources\\baidu.html"), "utf8");

        //解析字符串
        Document doc = Jsoup.parse(content);

        //使用标签选择器
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }
}
