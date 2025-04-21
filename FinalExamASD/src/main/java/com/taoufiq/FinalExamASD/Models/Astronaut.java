package com.taoufiq.FinalExamASD.Models;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @Min(0)
    @Max(50)
    private int experienceYears;

  @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
@JoinTable(
    name = "astronaut_satellite",
    joinColumns = @JoinColumn(name = "astronaut_id"),
    inverseJoinColumns = @JoinColumn(name = "satellite_id")
)
private List<Satellite> satellites;


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }


}

