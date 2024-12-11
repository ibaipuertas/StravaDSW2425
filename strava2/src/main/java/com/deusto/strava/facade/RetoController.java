package com.deusto.strava.facade;

import com.deusto.strava.dto.RetoDTO;
import com.deusto.strava.dto.RetoDTOResponse;
import com.deusto.strava.service.RetoService;
import com.deusto.strava.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/retos")
public class RetoController {

	@Autowired
    private final RetoService retoService;
	@Autowired
    private final TokenService tokenService;

    public RetoController(RetoService retoService, TokenService tokenService) {
        this.retoService = retoService;
        this.tokenService = tokenService;
    }

    /**
     * Endpoint para crear un reto.
     *
     * @param token   Token del usuario autenticado.
     * @param retoDTO Información del reto.
     * @return Reto creado.
     */
    @PostMapping
    public ResponseEntity<RetoDTO> crearReto(
            @RequestHeader("token") String token,
            @RequestBody RetoDTO retoDTO) {

        // Validar el token antes de realizar la acción
        validarToken(token);

        // Crear el reto
        RetoDTO retoCreado = retoService.crearReto(retoDTO);
        return ResponseEntity.ok(retoCreado);
    }

    /**
     * Endpoint para obtener los retos activos.
     *
     * @param token Token del usuario autenticado.
     * @return Lista de retos activos.
     */
    @GetMapping("/activos")
    public ResponseEntity<List<RetoDTOResponse>> obtenerRetosActivos(
            @RequestHeader("token") String token) {

        // Validar el token antes de realizar la acción
        validarToken(token);

        // Obtener retos activos
        List<RetoDTOResponse> retosActivos = retoService.obtenerRetosActivos();
        return ResponseEntity.ok(retosActivos);
    }

    /**
     * Endpoint para consultar los retos aceptados por el usuario.
     *
     * @param token Token del usuario autenticado.
     * @return Lista de retos aceptados.
     */
    @GetMapping("/aceptados")
    public ResponseEntity<List<RetoDTOResponse>> consultarRetosAceptados(
            @RequestHeader("token") String token) {

        // Validar el token antes de realizar la acción
        validarToken(token);

        // Consultar retos aceptados
        List<RetoDTOResponse> retosAceptados = retoService.obtenerRetosAceptados(token);
        return ResponseEntity.ok(retosAceptados);
    }

    /**
     * Endpoint para aceptar un reto.
     *
     * @param token   Token del usuario autenticado.
     * @param retoId  ID del reto a aceptar.
     * @return Mensaje de éxito.
     */
    @PostMapping("/{retoId}/aceptar")
    public ResponseEntity<String> aceptarReto(
            @RequestHeader("token") String token,
            @PathVariable ("retoId")Long retoId) {

        // Validar el token antes de realizar la acción
        validarToken(token);

        // Aceptar el reto
        retoService.aceptarReto(retoId, token);
        return ResponseEntity.ok("Reto aceptado con éxito.");
    }

    /**
     * Valida el token proporcionado. Si el token no es válido, lanza una excepción.
     *
     * @param token Token a validar.
     */
    private void validarToken(String token) {
        if (!tokenService.validarToken(token)) {
            throw new IllegalArgumentException("Token inválido o expirado.");
        }
    }
}