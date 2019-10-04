package com.bajinzhi.dmx.community1003.provider;

import com.alibaba.fastjson.JSON;
import com.bajinzhi.dmx.community1003.dto.AccessTokenDTO;
import com.bajinzhi.dmx.community1003.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @BelongsProject: community1003
 * @BelongsPackage: com.bajinzhi.dmx.community1003.provider
 * @Author: Administrator
 * @CreateTime: 2019-10-04 13:36
 * @Description: ${Description}
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String ss = response.body().string();
            String[] split = ss.split("&");
            String token = split[0].split("=")[1];
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public  GithubUser getUser(String accessToken ){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }
}
