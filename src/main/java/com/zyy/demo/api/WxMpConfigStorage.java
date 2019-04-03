package com.zyy.demo.api;

public interface WxMpConfigStorage {


    String getAppId();

    String getSecret();

    String getToken();

    String getAesKey();

    String getTemplateId();

    long getExpiresTime();
}
