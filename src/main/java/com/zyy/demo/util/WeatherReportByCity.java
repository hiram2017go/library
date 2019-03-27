package com.zyy.demo.util;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONObject;

public class WeatherReportByCity {

    /**
     * 根据城市名获取
     */
    public static String excute(String cityName){
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
                "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=***a7558b2e0bedaa19673f74a6809ce";

        return PureNetUtil.get(url);
    }

    public static String getWeatherByWid(String city) {
        String result=excute(city);
        if(result!=null){
            JSONObject obj= JSONObject.fromObject(result);
            /*获取返回状态码*/
            result=obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if(result!=null&&result.equals("200")){
                result=obj.getString("result");
                //此时result中数据有多个key,可以对其key进行遍历,得到对个属性
                obj=JSONObject.fromObject(result);
                //今日温度对应的key是today
                result=obj.getString("today");
                obj=JSONObject.fromObject(result);
                //今日温度对应当key是temperature
                result=obj.getString("temperature");
                return result;
            }
        }
        return result;
    }
}
