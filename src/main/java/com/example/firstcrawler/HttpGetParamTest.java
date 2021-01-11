package com.example.firstcrawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 带参数的get请求
 */
public class HttpGetParamTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        // 打开浏览器，创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //设置URIbuilder
        URIBuilder uriBuilder = new URIBuilder("http://www.itcast.cn");
        //设置参数
        uriBuilder.addParameter("keys", "Java");
        // 输入网址,发起get请求，创建HttpGet对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        // 按回车，发起请求，返回响应
        CloseableHttpResponse response = httpClient.execute(httpGet);

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
