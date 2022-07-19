package com.final_project.stonk_api.controllers.dto;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

public class UserDTO {

    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
//    @CreationTimestamp
//    private Date createdAt;
    private Integer teamId = null;

//    getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

//    constructors


    public UserDTO() {

        }


    public UserDTO(String email, String firstName, String lastName, String avatar) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }
}
