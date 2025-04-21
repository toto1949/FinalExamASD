package com.taoufiq.FinalExamASD.Models;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Data
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @Past
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO", message = "Orbit type must be one of: LEO, MEO, GEO")
    private String orbitType;

    private boolean decommissioned;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }


    public boolean isDecommissioned() {
        return decommissioned;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }


    public void setDecommissioned(boolean decommissioned) {
        this.decommissioned = decommissioned;
    }

    public String getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    
}
