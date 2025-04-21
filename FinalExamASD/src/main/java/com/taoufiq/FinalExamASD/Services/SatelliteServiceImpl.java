package com.taoufiq.FinalExamASD.Services;

import org.springframework.stereotype.Service;

import com.taoufiq.FinalExamASD.DTOs.SatelliteDTO;
import com.taoufiq.FinalExamASD.Exception.DuplicateSatelliteNameException;
import com.taoufiq.FinalExamASD.Exception.SatelliteNotFoundException;
import com.taoufiq.FinalExamASD.Mappers.SatelliteMapper;
import com.taoufiq.FinalExamASD.Models.OrbitType;
import com.taoufiq.FinalExamASD.Models.Satellite;
import com.taoufiq.FinalExamASD.Repositories.SatelliteRepository;
import java.util.*;

@Service
public class SatelliteServiceImpl implements SatelliteService {

    private final SatelliteRepository satelliteRepository;

    public SatelliteServiceImpl(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }


    @Override
    public Satellite createSatellite(SatelliteDTO dto) {
        if (satelliteRepository.existsByName(dto.getName())) {
    throw new DuplicateSatelliteNameException("Satellite with name '" + dto.getName() + "' already exists.");
}
        Satellite satellite = SatelliteMapper.toEntity(dto);
        return satelliteRepository.save(satellite);
    }
@Override
public Satellite updateSatellite(Long id, SatelliteDTO dto) {
    Satellite satellite = satelliteRepository.findById(id)
            .orElseThrow(() -> new SatelliteNotFoundException("Satellite with ID " + id + " not found"));

    satellite.setName(dto.getName());
    satellite.setLaunchDate(dto.getLaunchDate());

    try {
        satellite.setOrbitType(OrbitType.valueOf(dto.getOrbitType()).name());
    } catch (IllegalArgumentException e) {
        throw new RuntimeException("Invalid orbit type: " + dto.getOrbitType());
    }

    return satelliteRepository.save(satellite);
}


    @Override
    public Satellite getSatelliteById(Long id) {
        return satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite with ID " + id + " not found"));
    }   

    @Override
    public List<Satellite> getAllSatellites() {
        return satelliteRepository.findAll();
    }
    @Override
    public void deleteSatellite(Long id) {
        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite with ID " + id + " not found"));
        satelliteRepository.delete(satellite);
    }
    
}

