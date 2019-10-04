package com.bajinzhi.dmx.community1003.controller;

/**
 * @BelongsProject: community1003
 * @BelongsPackage: com.bajinzhi.dmx.community1003.controller
 * @Author: Administrator
 * @CreateTime: 2019-10-03 22:01
 * @Description: ${Description}
 */

import com.bajinzhi.dmx.community1003.model.User;
import com.bajinzhi.dmx.community1003.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(HttpServletRequest request ){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies)
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                System.out.println("cookie get token :" + token);
                User user = userService.findUserByToken(token);
                System.out.println("cookies get token and find user :" + user);
                if (user != null) {
                    request.getSession().setAttribute("user",user);
                    System.out.println("session set user :" + user);
                }
                break;
            }
        System.out.println(" in to index ...");
        return "index";
    }
}
