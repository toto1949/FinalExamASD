package com.taoufiq.FinalExamASD.DTOs;

import java.time.LocalDate;

import com.taoufiq.FinalExamASD.Models.OrbitType;

import jakarta.validation.constraints.*;

public class SatelliteDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Launch date is required")
    private LocalDate launchDate;

    @NotBlank(message = "Orbit type is required")
    @Pattern(regexp = "LEO|MEO|GEO", message = "Orbit type must be one of: LEO, MEO, GEO")
    private String orbitType;    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public String getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    

   
}
