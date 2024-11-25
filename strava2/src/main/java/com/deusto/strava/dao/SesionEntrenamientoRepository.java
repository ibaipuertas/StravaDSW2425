package com.deusto.strava.dao;

import com.deusto.strava.entity.SesionEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SesionEntrenamientoRepository extends JpaRepository<SesionEntrenamiento, Long> {
    List<SesionEntrenamiento> findByUsuarioId(Long usuarioId);
}
