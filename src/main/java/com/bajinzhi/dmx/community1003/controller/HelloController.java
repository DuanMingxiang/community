package com.bajinzhi.dmx.community1003.controller;

/**
 * @BelongsProject: community1003
 * @BelongsPackage: com.bajinzhi.dmx.community1003.controller
 * @Author: Administrator
 * @CreateTime: 2019-10-03 22:01
 * @Description: ${Description}
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
//    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name",required = false,defaultValue = "张三")String name, Model model){
        System.out.println("11111111111111111111111");
        model.addAttribute("name",name);
        System.out.println("name :" + name);
        return  "hello";
    }


}
