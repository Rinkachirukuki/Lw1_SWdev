package com.SoftwareDevelopment.TrComp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Privilege {
    @Id
    @Column(name = "privilege_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    @Column(name = "discount_size")
    private Integer discountSize;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "privilege",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    private List<Customer> customers;

    public Privilege() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscountSize() {
        return discountSize;
    }

    public void setDiscountSize(Integer discountSize) {
        this.discountSize = discountSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
