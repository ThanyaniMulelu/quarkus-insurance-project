package com.insurance.claims.client;

import java.time.LocalDate;

public class Policy {
    public Long id;
    public String policyNumber;
    public Long customerId;
    public LocalDate startDate;
    public LocalDate endDate;
    public Double premium;
    public String status;

    public Policy() {
    }

    public Policy(Long id, String policyNumber, Long customerId, LocalDate startDate, LocalDate endDate, Double premium, String status) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.status = status;
    }
}

