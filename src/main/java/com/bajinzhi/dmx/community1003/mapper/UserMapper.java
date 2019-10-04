package com.bajinzhi.dmx.community1003.mapper;

import com.bajinzhi.dmx.community1003.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: community1003
 * @BelongsPackage: com.bajinzhi.dmx.community1003.mapper
 * @Author: Administrator
 * @CreateTime: 2019-10-04 17:12
 * @Description: ${Description}
 */
@Mapper
public interface UserMapper {

//    @Select("select * from user where state = #{state}")
//    public String getUser();

//    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insertUser(User user);


}
