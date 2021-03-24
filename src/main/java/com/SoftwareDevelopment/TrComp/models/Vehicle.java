package com.SoftwareDevelopment.TrComp.models;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String number;

    private String model;

    private String mark;

    //@ForeignKey
    private Integer garageId;

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public String getMark() {
        return mark;
    }

    public Integer getGarageId() {
        return garageId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setGarageId(Integer garageId) {
        this.garageId = garageId;
    }
}
