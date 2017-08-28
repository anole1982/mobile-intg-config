/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icss.regie.dingtalk;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Administrator
 */
public class TokenUtils {

    public static AccessToken getAccessToken(String appId, String appSecret) throws ClientProtocolException, IOException {
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append("https://oapi.dingtalk.com/sns/gettoken?appid=")
                .append(appId)
                .append("&secret=")
                .append(appSecret);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl.toString());
        CloseableHttpResponse response = client.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity);
            return new ObjectMapper().readValue(res, AccessToken.class);
        } finally {
            response.close();
        }
    }

    public static JsapiTicket getJSApiTicket(AccessToken acessToken) throws ClientProtocolException, IOException {
        String requestUrl = "https://oapi.dingtalk.com/get_jsapi_ticket?access_token=" + acessToken.getAccess_token() + "&type=jsapi";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        CloseableHttpResponse response = client.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity);
            return new ObjectMapper().readValue(res, JsapiTicket.class);
        } finally {
            response.close();
        }
    }
    
    public static DingtalkSign getSign(String url,JsapiTicket ticket){
        Random random = new Random();
        String noncestr =  DigestUtils.md2Hex(String.valueOf(random.nextInt(10000)));
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);  
        String sign = "jsapi_ticket=" + ticket.getTicket() + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url;  
        DingtalkSign ddsign = new DingtalkSign();
//        ddsign.setNoncestr(noncestr);
//        ddsign.setTicket(ticket.getTicket());
//        ddsign.setTimestamp(timestamp);
//        ddsign.setUrl(url);
        ddsign.setSignature(DigestUtils.sha1Hex(sign));
        return ddsign;
    }

}
