package com.example.firstcrawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 不带参数的post请求
 */
public class HttpPostTest {
    public static void main(String[] args) throws IOException {
        // 打开浏览器，创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 输入网址,发起post请求，创建HttpPost对象
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");

        // 按回车，发起请求，返回响应
        CloseableHttpResponse response = httpClient.execute(httpPost);

        //解析响应，获取数据
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "utf8");
            System.out.println(content.length());
        }

        response.close();
        httpClient.close();
    }
}
