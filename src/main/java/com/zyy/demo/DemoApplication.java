package com.zyy.demo;

import com.zyy.demo.util.WeatherReportByCity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        String result =  "21℃~27℃";//WeatherReportByCity.getWeatherByWid("广州");
        System.out.printf("result=" + result);
        SpringApplication.run(DemoApplication.class, args);
    }
}
