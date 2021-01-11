package com.example.firstcrawler;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 不带参数的post请求
 */
public class HttpPostParamsTest {
    public static void main(String[] args) throws IOException {
        // 打开浏览器，创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 输入网址,发起post请求，创建HttpPost对象
        HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");

        //声明list集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<>();
        //创建表单的entity对象
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("keys", "Java");
        params.add(basicNameValuePair);
        //参数1：表单数据  参数2：编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf8");
        //设置表单的entity对象到httpPost请求中,
        httpPost.setEntity(formEntity);

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
