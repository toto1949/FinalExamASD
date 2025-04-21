package com.taoufiq.FinalExamASD.DTOs;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class AstronautDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 0, message = "Experience years must be positive")
    private int experienceYears;

    @NotEmpty(message = "At least one satellite must be assigned")
    @Valid
    private List<Long> satelliteIds;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public List<Long> getSatelliteIds() {
        return satelliteIds;
    }

    public void setSatelliteIds(List<Long> satelliteIds) {
        this.satelliteIds = satelliteIds;
    }
}
