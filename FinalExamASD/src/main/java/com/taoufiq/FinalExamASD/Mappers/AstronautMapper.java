package com.taoufiq.FinalExamASD.Mappers;


import com.taoufiq.FinalExamASD.DTOs.AstronautDTO;
import com.taoufiq.FinalExamASD.Models.Astronaut;
import com.taoufiq.FinalExamASD.Models.Satellite;

import java.util.List;
import java.util.stream.Collectors;

public class AstronautMapper {

    public static Astronaut toEntity(AstronautDTO dto, List<Satellite> satellites) {
        Astronaut astronaut = new Astronaut();
        String[] names = dto.getName().split(" ", 2);
        astronaut.setFirstName(names[0]);
        astronaut.setLastName(names.length > 1 ? names[1] : "");

        astronaut.setExperienceYears(dto.getExperienceYears());
        astronaut.setSatellites(satellites);
        return astronaut;
    }

    public static AstronautDTO toDTO(Astronaut astronaut) {
        AstronautDTO dto = new AstronautDTO();
        dto.setName(astronaut.getFirstName() + " " + astronaut.getLastName());
        dto.setExperienceYears(astronaut.getExperienceYears());
        dto.setSatelliteIds(
            astronaut.getSatellites().stream()
                .map(Satellite::getId)
                .collect(Collectors.toList())
        );
        return dto;
    }
}
