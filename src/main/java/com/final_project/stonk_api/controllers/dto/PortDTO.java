package com.final_project.stonk_api.controllers.dto;

public class PortDTO {

    private String name;


//    getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    constructors
    public PortDTO() {
    }

    public PortDTO(String name) {
        this.name = name;
    }
}
