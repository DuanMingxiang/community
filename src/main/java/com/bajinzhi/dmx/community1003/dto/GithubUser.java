package com.bajinzhi.dmx.community1003.dto;

/**
 * @BelongsProject: community1003
 * @BelongsPackage: com.bajinzhi.dmx.community1003.dto
 * @Author: Administrator
 * @CreateTime: 2019-10-04 14:18
 * @Description: ${Description}
 */
public class GithubUser {
    private Long id;
    private String name;
    private String bio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
