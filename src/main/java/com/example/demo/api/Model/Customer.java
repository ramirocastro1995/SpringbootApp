package com.example.demo.api.Model;

import jakarta.persistence.*;

@Entity
@Table (name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name="customername")
    private String name;
    @Column(name="email")
    private String email;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
