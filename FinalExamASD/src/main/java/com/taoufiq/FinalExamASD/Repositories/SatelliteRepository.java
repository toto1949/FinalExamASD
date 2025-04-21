package com.taoufiq.FinalExamASD.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taoufiq.FinalExamASD.Models.*;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    boolean existsByName(String name);
}
