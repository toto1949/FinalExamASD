package com.taoufiq.FinalExamASD.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taoufiq.FinalExamASD.DTOs.AstronautDTO;
import com.taoufiq.FinalExamASD.Mappers.AstronautMapper;
import com.taoufiq.FinalExamASD.Models.Astronaut;
import com.taoufiq.FinalExamASD.Services.AstronautService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/astronauts")
public class AstronautController {

    private final AstronautService astronautService;

    public AstronautController(AstronautService astronautService) {
        this.astronautService = astronautService;
    }

    // Create Astronaut (POST)
    @PostMapping
    public ResponseEntity<AstronautDTO> createAstronaut(@Valid @RequestBody AstronautDTO astronautDTO) {
        Astronaut createdAstronaut = astronautService.createAstronaut(astronautDTO);
        AstronautDTO responseDTO = AstronautMapper.toDTO(createdAstronaut);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // Get all Astronauts (GET) with sorting
    @GetMapping
    public ResponseEntity<List<AstronautDTO>> getAllAstronauts(
            @RequestParam(defaultValue = "experienceYears") String sort,
            @RequestParam(defaultValue = "asc") String order) {
        List<Astronaut> astronauts = astronautService.getAllAstronautsSorted(sort, order);
        List<AstronautDTO> astronautDTOs = astronauts.stream()
                .map(AstronautMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(astronautDTOs);
    }

    // Get Astronaut by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<AstronautDTO> getAstronautById(@PathVariable Long id) {
        Astronaut astronaut = astronautService.getAstronautById(id);
        AstronautDTO astronautDTO = AstronautMapper.toDTO(astronaut);
        return ResponseEntity.ok(astronautDTO);
    }

    // Update Astronaut (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<AstronautDTO> updateAstronaut(
            @PathVariable Long id,
            @Valid @RequestBody AstronautDTO astronautDTO) {
        Astronaut updatedAstronaut = astronautService.updateAstronaut(id, astronautDTO);
        AstronautDTO responseDTO = AstronautMapper.toDTO(updatedAstronaut);
        return ResponseEntity.ok(responseDTO);
    }

    // Delete Astronaut (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAstronaut(@PathVariable Long id) {
        astronautService.deleteAstronaut(id);
        return ResponseEntity.noContent().build();
    }
}
