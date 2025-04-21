package com.taoufiq.FinalExamASD.Services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.taoufiq.FinalExamASD.DTOs.AstronautDTO;
import com.taoufiq.FinalExamASD.Exception.AstronautNotFoundException;
import com.taoufiq.FinalExamASD.Exception.SatelliteNotFoundException;
import com.taoufiq.FinalExamASD.Mappers.AstronautMapper;
import com.taoufiq.FinalExamASD.Models.Astronaut;
import com.taoufiq.FinalExamASD.Models.Satellite;
import com.taoufiq.FinalExamASD.Repositories.AstronautRepository;
import com.taoufiq.FinalExamASD.Repositories.SatelliteRepository;

@Service
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;

    public AstronautServiceImpl(AstronautRepository astronautRepository, SatelliteRepository satelliteRepository) {
        this.astronautRepository = astronautRepository;
        this.satelliteRepository = satelliteRepository;
    }

    @Override
    public Astronaut createAstronaut(AstronautDTO dto) {
        List<Satellite> satellites = getSatellitesByIds(dto.getSatelliteIds());
        Astronaut astronaut = AstronautMapper.toEntity(dto, satellites);
        return astronautRepository.save(astronaut);
    }

    @Override
    public Astronaut getAstronautById(Long id) {
        return astronautRepository.findById(id)
                .orElseThrow(() -> new AstronautNotFoundException("Astronaut with ID " + id + " not found"));
    }

    @Override
    public List<Astronaut> getAllAstronautsSorted(String sort, String order) {
        List<Astronaut> astronauts = astronautRepository.findAll();

        Comparator<Astronaut> comparator;

        switch (sort) {
            case "experienceYears":
                comparator = Comparator.comparing(Astronaut::getExperienceYears);
                break;
            case "firstName":
                comparator = Comparator.comparing(Astronaut::getFirstName);
                break;
            case "lastName":
                comparator = Comparator.comparing(Astronaut::getLastName);
                break;
            default:
                comparator = Comparator.comparing(Astronaut::getExperienceYears);
                break;
        }

        if (order.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
        }

        return astronauts.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public Astronaut updateAstronaut(Long id, AstronautDTO dto) {
        Astronaut astronaut = astronautRepository.findById(id)
                .orElseThrow(() -> new AstronautNotFoundException("Astronaut with ID " + id + " not found"));

        List<Satellite> satellites = getSatellitesByIds(dto.getSatelliteIds());

        String[] names = dto.getName().split(" ", 2);
        astronaut.setFirstName(names[0]);
        astronaut.setLastName(names.length > 1 ? names[1] : "");

        astronaut.setExperienceYears(dto.getExperienceYears());
        astronaut.setSatellites(satellites);

        return astronautRepository.save(astronaut);
    }

    @Override
    public void deleteAstronaut(Long id) {
        Astronaut astronaut = astronautRepository.findById(id)
                .orElseThrow(() -> new AstronautNotFoundException("Astronaut with ID " + id + " not found"));

        astronautRepository.delete(astronaut);
    }

    // Helper method to validate satellite IDs
    private List<Satellite> getSatellitesByIds(List<Long> satelliteIds) {
        List<Satellite> satellites = satelliteRepository.findAllById(satelliteIds);

        if (satellites.size() != satelliteIds.size()) {
            List<Long> foundIds = satellites.stream().map(Satellite::getId).collect(Collectors.toList());
            List<Long> missingIds = satelliteIds.stream()
                    .filter(id -> !foundIds.contains(id))
                    .collect(Collectors.toList());

            throw new SatelliteNotFoundException("Satellites not found with IDs: " + missingIds);
        }

        return satellites;
    }
}
