package com.zyy.demo.service;

import com.zyy.demo.api.WxMpConfigStorage;

public interface WxMpService {

    /**
     * 获取access_token.
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    /**
     * 获得各种类型的ticket.
     */
    String GET_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=";
    /**
     * 长链接转短链接接口.
     */
    String SHORTURL_API_URL = "https://api.weixin.qq.com/cgi-bin/shorturl";
    /**
     * 语义查询接口.
     */
    String SEMANTIC_SEMPROXY_SEARCH_URL = "https://api.weixin.qq.com/semantic/semproxy/search";
    /**
     * 用code换取oauth2的access token.
     */
    String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    /**
     * 刷新oauth2的access token.
     */
    String OAUTH2_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";
    /**
     * 用oauth2获取用户信息.
     */
    String OAUTH2_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";
    /**
     * 验证oauth2的access token是否有效.
     */
    String OAUTH2_VALIDATE_TOKEN_URL = "https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s";
    /**
     * 获取微信服务器IP地址.
     */
    String GET_CALLBACK_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip";
    /**
     * 第三方使用网站应用授权登录的url.
     */
    String QRCONNECT_URL = "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";
    /**
     * oauth2授权的url连接.
     */
    String CONNECT_OAUTH2_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s&connect_redirect=1#wechat_redirect";

    /**
     * 获取公众号的自动回复规则.
     */
    String GET_CURRENT_AUTOREPLY_INFO_URL = "https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info";

    /**
     * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零.
     */
    String CLEAR_QUOTA_URL = "https://api.weixin.qq.com/cgi-bin/clear_quota";


    /**
     * 验证来自微信服务器
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public boolean checkSignature(String timestamp, String nonce, String signature);


    /**
     * 获取WxMpConfigStorage 对象.
     *
     * @return WxMpConfigStorage
     */
    WxMpConfigStorage getWxMpConfigStorage();

    /**
     * 注入 {@link WxMpConfigStorage} 的实现.
     */
    void setWxMpConfigStorage(WxMpConfigStorage wxConfigProvider);

    String getAccessToken();


}
