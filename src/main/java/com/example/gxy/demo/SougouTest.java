package com.example.gxy.demo;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GXY
 * @Package com.example.gxy.demo
 * @date 2020/11/24 17:06
 * @Copyright © 2020-2021 新流通
 * @Description: 搜狗翻译
 * https://deepi.sogou.com/doccenter/texttranslatedoc?fr=process
 */
public class SougouTest {
    public static void main(String[] args) throws IOException {

        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(400);
        manager.setDefaultMaxPerRoute(30);
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(manager)
                .build();
        HttpPost httpPost = new HttpPost("http://fanyi.sogou.com:80/reventondc/api/sogouTranslate");
        String pid = "c80240419010b44c73444b769d0eabd9";     //平台分配的PID，可前往用户中心申请
        String key = "116ecb0f4ac9695921171dc4312dd129";     //平台分配的key，可前往用户中心申请
        String q = "天下大势，为我所控";     //待翻译文本
        String salt = String.valueOf(System.currentTimeMillis());      //随机数，可以填入时间戳
        String sign = DigestUtils.md5Hex(pid + q + salt + key);

        List nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("from", "zh-CHS"));     //源语言：61种语言互译，支持源语言自动检测，详情见语种列表
        nvps.add(new BasicNameValuePair("to", "en"));   //目标语言:61种语言互译 详情见语种列表
        nvps.add(new BasicNameValuePair("pid", pid));
        nvps.add(new BasicNameValuePair("q", q));
        nvps.add(new BasicNameValuePair("salt", salt));
        nvps.add(new BasicNameValuePair("sign", sign));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        HttpRequestBase requestBase = httpPost;
        requestBase.addHeader("content-type", "application/x-www-form-urlencoded");
        requestBase.addHeader("accept", "application/json");
        CloseableHttpResponse response = httpClient.execute(requestBase);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        System.out.println(result);
    }
}
