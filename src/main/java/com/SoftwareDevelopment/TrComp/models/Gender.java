package com.SoftwareDevelopment.TrComp.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gender {
    @Id
    @Column(name = "gender_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "gender",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    private List<Customer> customers;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "gender",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    private List<Driver> drivers;

    public Gender() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
