package com.mgj.newsdemo;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: WeatherMail
 * @classname: RequestApiUtil
 * @description: 访问api工具类
 * @author: Mr.Lee
 * @create: 2019-08-16 12:33
 **/
public class GetNews {

    public static JSONObject result(String type) {
        //接口地址
        String requestUrl = "http://zhouxunwang.cn/data/?id=75";

        //params用于存储要请求的参数
//        Map params = new LinkedHashMap();
        Map params = new LinkedHashMap();

        params.put("key","VOuSrYAyT4n+ip+P84gzR2jAPgTgsJeZ/px16A");

//        params.put("dtype","json");

        params.put("type",type);

//        System.out.println("params == "+params);
        //调用httpRequest方法，这个方法主要用于请求地址，并加上请求参数
        String str = httpRequest(requestUrl,params);
//        System.out.println("这是一个测试"+str);
        //处理返回的JSON数据并返回
        JSONObject pageBean = JSONObject.fromObject(str).getJSONObject("result");
//        System.out.println("这是第二个测试"+pageBean);
        return pageBean;
    }

    private static String httpRequest(String requestUrl,Map params) {
        //buffer用于接受返回的字符
        StringBuffer buffer = new StringBuffer();
        try {
            //建立URL，把请求地址给补全，其中urlencode（）方法用于把params里的参数给取出来
            URL url = new URL(requestUrl+"?"+urlencode(params));
//            System.out.println("最终地址 == "+requestUrl+urlencode(params));
//            System.out.println("url == "+url);
            //打开http连接
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("POST");
            httpUrlConn.connect();

            //获得输入
            InputStream inputStream = httpUrlConn.getInputStream();
//            System.out.println("inputStream == "+inputStream.toString());
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //将bufferReader的值给放到buffer里
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
//            System.out.println(buffer);
            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            //断开连接
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回字符串
        return buffer.toString();
    }

    public static String urlencode(Map<String,Object> data) {
        //将map里的参数变成像 showapi_appid=###&showapi_sign=###&的样子
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append("&").append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

//        System.out.println(sb.toString());
        return sb.toString();
    }
    //测试是否有效
    public static void main(String[] args) {
        GetNews news=new GetNews();
        System.out.println(news.result("top"));
    }
}
