package com.final_project.stonk_api.controllers.dto;

public class HoldingDTO {

    private String name;
//    We're going to use default price from the API for the time being
    private Double purchasePrice;
    private Double targetPrice;

    private Integer purchaseQuantity;

//    getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(Double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    //    constructors

    public HoldingDTO() {
        System.out.println("ERROR!!!!!!!!!!!");
    }

//    public HoldingDTO(String name, Double targetPrice) {
//        this.name = name;
//        this.targetPrice = targetPrice;
//    }


    public HoldingDTO(String name, Double purchasePrice, Double targetPrice, Integer purchaseQuantity) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.targetPrice = targetPrice;
        this.purchaseQuantity = purchaseQuantity;
    }
}
