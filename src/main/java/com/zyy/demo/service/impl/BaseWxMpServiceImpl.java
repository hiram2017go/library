package com.zyy.demo.service.impl;

//import com.google.gson.JsonParser;
import com.zyy.demo.api.WxMpConfigStorage;
import com.zyy.demo.service.WxMpService;
import com.zyy.demo.util.wx.SHA1;
import com.zyy.demo.util.wx.http.RequestHttp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseWxMpServiceImpl<H, P> implements WxMpService, RequestHttp<H, P> {

   // private final JsonParser JSON_PARSER = new JsonParser();

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    protected WxMpConfigStorage wxMpConfigStorage;


    @Override
    public WxMpConfigStorage getWxMpConfigStorage() {
        return this.wxMpConfigStorage;
    }

    @Override
    public void setWxMpConfigStorage(WxMpConfigStorage wxConfigProvider) {
        this.wxMpConfigStorage = wxConfigProvider;
        //this.initHttp();
    }



    /**
     * 验证来自微信服务器
     *
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    @Override
    public boolean checkSignature(String timestamp, String nonce, String signature) {

        return false;
    }

}
