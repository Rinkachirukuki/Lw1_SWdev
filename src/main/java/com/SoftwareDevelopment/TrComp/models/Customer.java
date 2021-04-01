package com.SoftwareDevelopment.TrComp.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "gender_name")
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "privilege_name")
    private Privilege privilege;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    @JoinTable(name = "customer_achievement",
            joinColumns = { @JoinColumn(name = "customer_fk")},
            inverseJoinColumns = { @JoinColumn(name = "achievement_fk")})
    private Set<Achievement> achievements;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "customer",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    private List<TaxiOrder> taxiOrders;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "customer",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    private List<Review> reviews;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }

    public List<TaxiOrder> getOrders() {
        return taxiOrders;
    }

    public void setOrders(List<TaxiOrder> taxiOrders) {
        this.taxiOrders = taxiOrders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @PreRemove
    private void preRemove() {
        gender.getCustomers().remove(this);
        privilege.getCustomers().remove(this);
        for (Achievement s : achievements){
            s.getCustomers().remove(this);
        }
        for (TaxiOrder s : taxiOrders){
            s.setCustomer(null);
        }
        for (Achievement s : achievements){
            s.getCustomers().remove(this);
        }
        for (Review s : reviews){
            s.setCustomer(null);
        }
}

}
