package com.zyy.demo.controller;

import com.zyy.demo.message.WxMpXmlMessage;
import com.zyy.demo.message.WxMpXmlOutMessage;
import com.zyy.demo.message.WxMpXmlOutTextMessage;
import com.zyy.demo.util.wx.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/wx/portal/{appid}")
public class WxPortalController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(@PathVariable String appid,
                          @RequestParam(name = "signature", required = false) String signature,
                          @RequestParam(name = "timestamp", required = false) String timestamp,
                          @RequestParam(name = "nonce", required = false) String nonce,
                          @RequestParam(name = "echostr", required = false) String echostr) {
        System.out.println("wx接口验证get请求appid=" + appid);
        this.logger.info("\n接收来自服务器的验证信息, [{}, {}, {}, {}]", signature, timestamp, nonce, echostr);

        if(StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)){
            System.out.println("出现参数为空情况");
            throw new IllegalArgumentException("请求参数非法，请查实");
        }

        if(CheckUtil.checkSignature(signature,timestamp,nonce )) {
            return echostr;
        }

        return "非法請求";
    }

    @PostMapping(produces = "application/xml;charset=UTF-8")
    public String authPost(@PathVariable String appid,
                           @RequestBody String requestBody,
                           @RequestParam(name = "signature", required = false) String signature,
                           @RequestParam(name ="timestamp", required = false) String timestamp,
                           @RequestParam(name = "nonce", required = false) String nonce,
                           @RequestParam(name = "openid", required = false) String openid,
                           @RequestParam(name = "encrypt_type", required = false) String encType,
                           @RequestParam(name = "msg_signature", required = false) String msgSignature){


        this.logger.info("\n接收微信请求：[appid=[{}]] [openid=[{}], [signature=[{}], encType=[{}], msgSignature=[{}],"
                        + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                appid,openid, signature, encType, msgSignature, timestamp, nonce, requestBody);

//        if(StringUtils.isAnyBlank(signature, timestamp, nonce)){
//            throw new IllegalArgumentException("請求參數非法，請核對");
//        }
//
//        if(!CheckUtil.checkSignature(signature,timestamp,nonce )) {
//            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
//        }

        WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);

        WxMpXmlOutTextMessage outMessage = new WxMpXmlOutTextMessage();
        outMessage.setContent("haha"+inMessage.getContent());
        outMessage.setFromUserName(inMessage.getFromUser());
        outMessage.setToUserName(inMessage.getToUser());

        outMessage.setMsgType("text");
        outMessage.setCreateTime(new Date().getTime());
        String result = outMessage.toXml();
        System.out.println("resutl ====="+result);
        return outMessage.toXml();
    }

}
