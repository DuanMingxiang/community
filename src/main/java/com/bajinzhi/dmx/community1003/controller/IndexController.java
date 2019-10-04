package com.bajinzhi.dmx.community1003.controller;

/**
 * @BelongsProject: community1003
 * @BelongsPackage: com.bajinzhi.dmx.community1003.controller
 * @Author: Administrator
 * @CreateTime: 2019-10-03 22:01
 * @Description: ${Description}
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        System.out.println(" in to index ...");
        return "index";
    }
}
