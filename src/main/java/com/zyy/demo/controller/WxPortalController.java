package com.zyy.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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



        return "fuck";
    }

}
