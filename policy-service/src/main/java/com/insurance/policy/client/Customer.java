package com.insurance.policy.client;

public class Customer {
    public Long id;
    public String name;
    public String email;
    public String phoneNumber;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

