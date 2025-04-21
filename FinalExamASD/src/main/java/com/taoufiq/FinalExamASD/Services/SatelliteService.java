package com.taoufiq.FinalExamASD.Services;

import com.taoufiq.FinalExamASD.DTOs.SatelliteDTO;
import com.taoufiq.FinalExamASD.Models.Satellite;
import java.util.*;

public interface SatelliteService {

    Satellite updateSatellite(Long id, SatelliteDTO dto);
    Satellite createSatellite(SatelliteDTO dto);
    Satellite getSatelliteById(Long id);
    List<Satellite> getAllSatellites();
    void deleteSatellite(Long id);

  
}
