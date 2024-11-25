package com.deusto.strava.dao;

import com.deusto.strava.entity.Reto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RetoRepository extends JpaRepository<Reto, Long> {
    List<Reto> findByFechaFinAfter(LocalDate fecha);
}
