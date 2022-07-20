package com.final_project.stonk_api.entities;

import com.final_project.stonk_api.controllers.dto.HoldingDTO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    private String name;
    private Double purchasePrice = null;
    @CreationTimestamp
    private Date purchaseDate;
    private Double targetPrice;
    private Integer portId = null;

//    getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(Double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }


//    constructors

    public Holding() {

    }


    public Holding(HoldingDTO holdingDTO) {
        this.name = holdingDTO.getName();
//        We're going to use default price from the API for the time being
        this.purchasePrice = holdingDTO.getPurchasePrice();
        this.targetPrice = holdingDTO.getTargetPrice();
        this.portId = holdingDTO.getPortId();
    }
}
