package com.deusto.strava.facade;

import com.deusto.strava.dto.SesionEntrenamientoDTO;
import com.deusto.strava.service.SesionEntrenamientoService;
import com.deusto.strava.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
@Tag(name = "Sesiones de Entrenamiento", description = "Gestión de sesiones de entrenamiento")
public class SesionEntrenamientoController {

    @Autowired
    private SesionEntrenamientoService sesionEntrenamientoService;

    @Autowired
    private TokenService tokenService;

//    @PostMapping("/crear")
//    @Operation(summary = "Crear una nueva sesión de entrenamiento")
//    public ResponseEntity<SesionEntrenamientoDTO> crearSesionEntrenamiento(
//            @RequestHeader("Authorization") String token,
//            @RequestBody SesionEntrenamientoDTO sesionEntrenamientoDTO) {
//        
//        validarToken(token); // Validar que el token es válido.
//        SesionEntrenamientoDTO nuevaSesionDTO = sesionEntrenamientoService.crearSesionEntrenamiento(sesionEntrenamientoDTO);
//        return ResponseEntity.ok(nuevaSesionDTO);
//    }

//    @GetMapping("/mis-sesiones")
//    @Operation(summary = "Obtener las sesiones de entrenamiento del usuario")
//    public ResponseEntity<List<SesionEntrenamientoDTO>> obtenerMisSesiones(
//            @RequestHeader("Authorization") String token) {
//        
//        validarToken(token); // Validar que el token es válido.
//        List<SesionEntrenamientoDTO> sesiones = sesionEntrenamientoService.obtenerMisSesiones();
//        return ResponseEntity.ok(sesiones);
//    }

}