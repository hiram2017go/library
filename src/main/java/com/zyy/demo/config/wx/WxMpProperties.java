package com.zyy.demo.config.wx;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "wx.mp")
public class WxMpProperties {

    private List<MpConfig> configs;

    //wx公众号相关参数
    @Data
    public class MpConfig{

        private String appId;

        private String secert;

        private String token;

        private String aesKey;
    }
}
