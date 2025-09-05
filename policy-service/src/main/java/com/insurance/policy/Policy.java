package com.insurance.policy;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Policy extends PanacheEntity {

    @NotBlank(message = "Policy number may not be blank")
    public String policyNumber;

    @NotNull(message = "Customer ID may not be null")
    public Long customerId;

    @NotNull(message = "Start date may not be null")
    public LocalDate startDate;

    @NotNull(message = "End date may not be null")
    public LocalDate endDate;

    @NotNull(message = "Premium may not be null")
    public Double premium;

    @NotNull(message = "Policy status may not be null")
    public PolicyStatus status;

    public Policy() {
    }

    public Policy(String policyNumber, Long customerId, LocalDate startDate, LocalDate endDate, Double premium, PolicyStatus status) {
        this.policyNumber = policyNumber;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.status = status;
    }
}


