package com.final_project.stonk_api.controllers.dto;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

public class TeamDTO {

    private String name;
    private String avatar;
//    @CreationTimestamp
//    private Date createdAt;
//    private Integer owner = null;

//    getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

//    public Integer getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Integer owner) {
//        this.owner = owner;
//    }


//    constructors
    public TeamDTO() {

    }

    public TeamDTO(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }
}
