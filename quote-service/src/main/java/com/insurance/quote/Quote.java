package com.insurance.quote;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Quote extends PanacheEntity {

    @NotBlank(message = "Quote number may not be blank")
    public String quoteNumber;

    @NotNull(message = "Customer ID may not be null")
    public Long customerId;

    @NotNull(message = "Policy type may not be null")
    public String policyType;

    @NotNull(message = "Quoted premium may not be null")
    public Double quotedPremium;

    @NotNull(message = "Quote date may not be null")
    public LocalDate quoteDate;

    @NotNull(message = "Expiration date may not be null")
    public LocalDate expirationDate;

    @NotNull(message = "Quote status may not be null")
    public QuoteStatus status;

    public Quote() {
    }

    public Quote(String quoteNumber, Long customerId, String policyType, Double quotedPremium, LocalDate quoteDate, LocalDate expirationDate, QuoteStatus status) {
        this.quoteNumber = quoteNumber;
        this.customerId = customerId;
        this.policyType = policyType;
        this.quotedPremium = quotedPremium;
        this.quoteDate = quoteDate;
        this.expirationDate = expirationDate;
        this.status = status;
    }
}

