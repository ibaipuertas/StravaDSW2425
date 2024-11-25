package com.deusto.strava.service;

import com.deusto.strava.dao.SesionEntrenamientoRepository;
import com.deusto.strava.dto.SesionEntrenamientoDTO;
import com.deusto.strava.entity.SesionEntrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SesionEntrenamientoService {

    @Autowired
    private SesionEntrenamientoRepository sesionEntrenamientoRepository;

    public SesionEntrenamientoDTO crearSesionEntrenamiento(SesionEntrenamientoDTO sesionEntrenamientoDTO) {
        // Crear entidad de sesión de entrenamiento a partir del DTO
        SesionEntrenamiento sesion = new SesionEntrenamiento();
        sesion.setTitulo(sesionEntrenamientoDTO.getTitulo());
        sesion.setDeporte(sesionEntrenamientoDTO.getDeporte());
        sesion.setDistancia(sesionEntrenamientoDTO.getDistancia());
        sesion.setFechaInicio(sesionEntrenamientoDTO.getFechaInicio());
        sesion.setDuracion(sesionEntrenamientoDTO.getDuracion());

        // Guardar sesión en la base de datos
        SesionEntrenamiento sesionGuardada = sesionEntrenamientoRepository.save(sesion);

        // Convertir la entidad a DTO y devolver
        return new SesionEntrenamientoDTO(sesionGuardada.getId(), sesionGuardada.getTitulo(), sesionGuardada.getDeporte(),
                sesionGuardada.getDistancia(), sesionGuardada.getFechaInicio(), sesionGuardada.getDuracion());
    }

    public List<SesionEntrenamientoDTO> obtenerMisSesiones() {
        // Obtener todas las sesiones de entrenamiento
        List<SesionEntrenamiento> sesiones = sesionEntrenamientoRepository.findAll();

        // Convertir las entidades a DTOs
        return sesiones.stream().map(sesion -> new SesionEntrenamientoDTO(sesion.getId(), sesion.getTitulo(), sesion.getDeporte(),
                sesion.getDistancia(), sesion.getFechaInicio(), sesion.getDuracion())).collect(Collectors.toList());
    }
}
