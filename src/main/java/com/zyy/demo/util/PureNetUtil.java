package com.zyy.demo.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Map;

public class PureNetUtil {

    //请求网络地址，返回网络数据
    public static String get(String url){
        return post(url, null);
    }

    public static <K, V> String post(String url, Map<K, V> param) {

        HttpsURLConnection conn = null;

        try{
            URL u = new URL(null, url,new sun.net.www.protocol.https.Handler());
            conn = (HttpsURLConnection) u.openConnection();
            StringBuffer sb = null;
            if(param !=null){
                sb = new StringBuffer();
                //post方法需要写入参数，设定为true
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                //获得输出流
                OutputStream out = conn.getOutputStream();
                //对输出流封装成高级输出流
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                //将参数封装成键值对的形式
                for(Map.Entry s:param.entrySet()){
                    sb.append(s.getKey()).append("=").append(s.getValue()).append("&");
                }
                //将参数通过输出流写入
                writer.write(sb.deleteCharAt(sb.toString().length()-1).toString());
                writer.close();
                sb = null;
            }
            conn.connect();
            sb = new StringBuffer();
            //获取连接状态码
            int recode = conn.getResponseCode();
            BufferedReader reader = null;
            if(recode == 200){
                //从连接中获取输入流
                InputStream in = conn.getInputStream();
                //对输入流进行封装
                reader = new BufferedReader(new InputStreamReader(in));
                String str = null;
                sb = new StringBuffer();
                //从输入流中读取数据
                while ((str = reader.readLine()) != null){
                    sb.append(str).append(System.getProperty("line.separator"));
                }
                reader.close();
                if(sb.toString().length() == 0){
                    return null;
                }

                return  sb.toString().substring(0, sb.toString().length() - System.getProperty("line.separator").length());
            }


        }catch (Exception ex){
            ex.printStackTrace();
            return  null;
        }finally {
            if(conn != null) {
                conn.disconnect();
            }
        }

        return null;
    }
}
