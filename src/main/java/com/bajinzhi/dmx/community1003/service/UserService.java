package com.bajinzhi.dmx.community1003.service;

import com.bajinzhi.dmx.community1003.mapper.UserMapper;
import com.bajinzhi.dmx.community1003.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: community1003
 * @BelongsPackage: com.bajinzhi.dmx.community1003.service
 * @Author: Administrator
 * @CreateTime: 2019-10-04 17:39
 * @Description: ${Description}
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void  insertUser(User user){
        userMapper.insertUser(user);
    }



}
