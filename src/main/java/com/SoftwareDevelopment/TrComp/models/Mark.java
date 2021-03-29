package com.SoftwareDevelopment.TrComp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mark {
    @Id
    @Column(name = "mark_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "mark",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<Vehicle> vehicles;

    public Mark() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
