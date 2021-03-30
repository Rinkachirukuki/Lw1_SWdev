package com.SoftwareDevelopment.TrComp.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Vehicle() {
    }

    public Vehicle(String number, String model, Mark mark, Driver driver) {
        this.number = number;
        this.model = model;
        this.mark = mark;
        this.driver = driver;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<TaxiOrder> getOrders() {
        return taxiOrders;
    }

    public void setOrders(List<TaxiOrder> taxiOrders) {
        this.taxiOrders = taxiOrders;
    }

    @Column(name = "number")
    private String number;

    @Column(name = "model")
    private String model;

    @ManyToOne
    @JoinColumn(name="mark_name")
    private Mark mark;

    @ManyToOne
    @JoinColumn(name="driver_id")
    private Driver driver;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "vehicle",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    private List<TaxiOrder> taxiOrders;

}
