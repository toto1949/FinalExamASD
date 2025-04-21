package com.taoufiq.FinalExamASD.Services;

import java.util.List;

import com.taoufiq.FinalExamASD.DTOs.AstronautDTO;
import com.taoufiq.FinalExamASD.Models.Astronaut;

public interface AstronautService {
 Astronaut createAstronaut(AstronautDTO dto);
Astronaut getAstronautById(Long id);
List<Astronaut> getAllAstronautsSorted(String sort, String order);
Astronaut updateAstronaut(Long id, AstronautDTO dto);
void deleteAstronaut(Long id);
    
}

