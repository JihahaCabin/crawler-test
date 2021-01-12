package com.example.firstcrawler.jsoup;


import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.URL;
import java.util.Set;

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


    @Test
    void testFile() throws Exception {
        //解析文件
        Document doc = Jsoup.parse(new File("D:\\Java爬虫\\first-crawler\\src\\main\\resources\\baidu.html"), "utf8");

        //使用标签选择器
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    /**
     * 使用dom.获取元素
     *
     * @throws Exception
     */
    @Test
    void testDOM() throws Exception {
        //解析文件
        Document doc = Jsoup.parse(new File("D:\\Java爬虫\\first-crawler\\src\\main\\resources\\baidu.html"), "utf8");


        //获取元素
        //1.根据id查询元素
        Element element = doc.getElementById("testId");
        System.out.println(element);
        //2.根据标签获取元素
        Elements elementsByTag = doc.getElementsByTag("title");
        System.out.println(elementsByTag);
        //3.根据class获取元素
        Elements elementsByClass = doc.getElementsByClass("s-top-wrap");
        System.out.println(elementsByClass);
        //4 根据属性获取元素
        Elements elementsByAttribute = doc.getElementsByAttribute("src");
        System.out.println(elementsByAttribute);
        Elements src = doc.getElementsByAttributeValue("src", "./baidu_files/sbase-0948aa26f1.js.下载");
        System.out.println(src);

    }

    /**
     * 从元素中获取数据
     *
     * @throws Exception
     */
    @Test
    void testData() throws Exception {
        //解析文件
        Document doc = Jsoup.parse(new File("D:\\Java爬虫\\first-crawler\\src\\main\\resources\\baidu.html"), "utf8");

        //获取元素
        Element element = doc.getElementById("testId");
        System.out.println(element);
        //从元素中获取值
        //从元素中获取id
        String id = element.id();
        System.out.println(id);
        //从元素中获取className
        Set<String> strings = element.classNames();
        System.out.println(strings);
        //从元素中获取属性的值attr
        String rel = element.attr("rel");
        System.out.println(rel);
        //从元素中获取所有属性attributes
        Attributes attributes = element.attributes();
        System.out.println(attributes);
        //从元素中获取文本内容text
        String text = element.text();
        System.out.println(text);

    }

}
