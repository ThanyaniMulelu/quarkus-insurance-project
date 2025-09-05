package com.insurance.claims;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Claim extends PanacheEntity {

    @NotBlank(message = "Claim number may not be blank")
    public String claimNumber;

    @NotNull(message = "Policy ID may not be null")
    public Long policyId;

    @NotNull(message = "Claim date may not be null")
    public LocalDate claimDate;

    @NotBlank(message = "Description may not be blank")
    public String description;

    @NotNull(message = "Claim status may not be null")
    public ClaimStatus status;

    public Claim() {
    }

    public Claim(String claimNumber, Long policyId, LocalDate claimDate, String description, ClaimStatus status) {
        this.claimNumber = claimNumber;
        this.policyId = policyId;
        this.claimDate = claimDate;
        this.description = description;
        this.status = status;
    }
}

