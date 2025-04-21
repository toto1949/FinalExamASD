package com.taoufiq.FinalExamASD.Mappers;


import com.taoufiq.FinalExamASD.DTOs.SatelliteDTO;
import com.taoufiq.FinalExamASD.Models.OrbitType;
import com.taoufiq.FinalExamASD.Models.Satellite;

public class SatelliteMapper {


    public static Satellite toEntity(SatelliteDTO dto) {
        Satellite satellite = new Satellite();
        satellite.setName(dto.getName());
        satellite.setLaunchDate(dto.getLaunchDate());

        try {
            satellite.setOrbitType(OrbitType.valueOf(dto.getOrbitType()).name());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid orbit type: " + dto.getOrbitType());
        }

        return satellite;
    }

    public static SatelliteDTO toDTO(Satellite satellite) {
        SatelliteDTO dto = new SatelliteDTO();
        dto.setName(satellite.getName());
        dto.setLaunchDate(satellite.getLaunchDate());
        dto.setOrbitType(OrbitType.valueOf(satellite.getOrbitType()).name()); 
        return dto;
    }
    
}
