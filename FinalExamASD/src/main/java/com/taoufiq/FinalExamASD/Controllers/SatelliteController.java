package com.taoufiq.FinalExamASD.Controllers;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taoufiq.FinalExamASD.DTOs.SatelliteDTO;
import com.taoufiq.FinalExamASD.Mappers.SatelliteMapper;
import com.taoufiq.FinalExamASD.Models.Satellite;
import com.taoufiq.FinalExamASD.Services.*;

import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1/satellites")
public class SatelliteController {

    private final SatelliteService satelliteService;

    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @PostMapping
public ResponseEntity<SatelliteDTO> createSatellite(@Valid @RequestBody SatelliteDTO satellite) {
    Satellite createdSatellite = satelliteService.createSatellite(satellite);
    SatelliteDTO satellitedto = SatelliteMapper.toDTO(createdSatellite);
    return ResponseEntity.status(HttpStatus.CREATED).body(satellitedto);
}


    @PutMapping("/{id}")
    public ResponseEntity<SatelliteDTO> updateSatellite(@PathVariable Long id, @Valid @RequestBody SatelliteDTO satellite) {
        Satellite updatedSatellite = satelliteService.updateSatellite(id, satellite);
        SatelliteDTO satellitedto = SatelliteMapper.toDTO(updatedSatellite);
        return ResponseEntity.ok(satellitedto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SatelliteDTO> getSatelliteById(@PathVariable Long id) {
        Satellite satellite = satelliteService.getSatelliteById(id);
        SatelliteDTO satelliteDTO = SatelliteMapper.toDTO(satellite);
        return ResponseEntity.ok(satelliteDTO);
    }

    @GetMapping
    public ResponseEntity<List<SatelliteDTO>> getAllSatellites() {
        List<Satellite> satellites = satelliteService.getAllSatellites();
        List<SatelliteDTO> satelliteDTOs = satellites.stream()
                .map(SatelliteMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(satelliteDTOs);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSatellite(@PathVariable Long id) {
        satelliteService.deleteSatellite(id);
        return ResponseEntity.noContent().build();
    }
}
