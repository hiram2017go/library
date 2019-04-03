package com.zyy.demo.api;

import java.io.Serializable;

public class WxMpInMemoryConfigStorage implements WxMpConfigStorage, Serializable {

    private static final long serialVersionUID = -6646519023303395185L;
    protected volatile String appId;
    protected volatile String secret;
    protected volatile String token;
    protected volatile String templateId;
    protected volatile String accessToken;
    protected volatile String aesKey;
    protected volatile long expiresTime;

    public WxMpInMemoryConfigStorage() {
    }

    public String getAppId() {
        return this.appId;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getToken() {
        return this.token;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAesKey() {
        return this.aesKey;
    }

    public long getExpiresTime() {
        return this.expiresTime;
    }


    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }
}
