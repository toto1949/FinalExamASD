package com.taoufiq.FinalExamASD.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taoufiq.FinalExamASD.Models.*;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}
