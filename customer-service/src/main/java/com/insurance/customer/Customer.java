package com.insurance.customer;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Customer extends PanacheEntity {

    @NotBlank(message = "Name may not be blank")
    public String name;
    @NotBlank(message = "Email may not be blank")
    public String email;
    @NotBlank(message = "Phone number may not be blank")
    public String phoneNumber;

    public Customer() {
    }

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

//thanuaS

