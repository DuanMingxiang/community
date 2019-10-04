package com.bajinzhi.dmx.community1003.controller;

/**
 * @BelongsProject: community1003
 * @BelongsPackage: com.bajinzhi.dmx.community1003.controller
 * @Author: Administrator
 * @CreateTime: 2019-10-03 22:01
 * @Description: ${Description}
 */

import com.bajinzhi.dmx.community1003.dto.AccessTokenDTO;
import com.bajinzhi.dmx.community1003.dto.GithubUser;
import com.bajinzhi.dmx.community1003.mapper.UserMapper;
import com.bajinzhi.dmx.community1003.model.User;
import com.bajinzhi.dmx.community1003.provider.GithubProvider;
import com.bajinzhi.dmx.community1003.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code, @RequestParam(name = "state") String state, HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        System.out.println(accessTokenDTO.toString());
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        System.out.println("accessToken:" + accessToken);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println("githubUser:" + githubUser);

        if(githubUser != null){
            //登录成功，写session cookie
            User user = new User();
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setToken(UUID.randomUUID().toString());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtModified());
            userService.insertUser(user);
            System.out.println( "userMapper insert user over !");

            request.getSession().setAttribute("user",githubUser);
            System.out.println("setAttribute user ：" + githubUser);
            return "redirect:/";
        }else{
            //登录失败，重新登录
            return "redirect:/";
        }
    }
}
