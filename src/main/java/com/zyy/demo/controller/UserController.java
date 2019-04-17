package com.zyy.demo.controller;

import com.zyy.demo.dao.UserDao;
import com.zyy.demo.entity.User;
import com.zyy.demo.service.UserService;
import com.zyy.demo.util.ImageUtils;
import com.zyy.demo.util.RedisUtil;
import com.zyy.demo.util.wx.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Date;

@RestController
@RequestMapping("/user/add")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value="/get",method={RequestMethod.POST,RequestMethod.GET})
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(@RequestParam(name = "username", required = false) String username,
                          @RequestParam(name = "nickname", required = false) String nickname,
                          @RequestParam(name = "wxid", required = false) String wxid) {
         this.logger.info("\n接收来自服务器的验证信息, [{}, {}, {}]", username, nickname, wxid);
         this.logger.info("\n接收来自服务器的验证信息, [{}, {}, {}]", username, nickname, wxid);
        System.out.println("username="+username);
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setWxid(wxid);
        userService.addUser(user);

        return "添加已完成";
    }


    @RequestMapping(value="/pressText",method={RequestMethod.POST,RequestMethod.GET})
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String pressText() {

        ImageUtils.pressText("D:\\12345.jpg", "阿拉卡夏之眼", "宋体", Font.BOLD|Font.ITALIC, 20, Color.red, 300, 500, 0.6f);

        return "添加已完成";
    }

    @RequestMapping(value = "/message", method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping(produces = "text/plain;charset=utd-8")
    public String broadcastMessage() throws InterruptedException {
        redisUtil.set("accessToken", "abcdef");

        for(int i = 0; i < 80; i++){
            String result = redisUtil.get("accessToken", String.class);
            System.out.println("result = "+ result + i);
            Thread.sleep(1000);
        }
        return "ok";
    }
}
