package com.deusto.strava.service;

import com.deusto.strava.dto.RetoDTO;
import com.deusto.strava.dto.RetoDTOResponse;
import com.deusto.strava.entity.Reto;
import com.deusto.strava.dao.RetoRepository;
import com.deusto.strava.entity.Usuario;
import com.deusto.strava.dao.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RetoService {

	@Autowired
    private RetoRepository retoRepository;
	@Autowired
    private  UsuarioRepository usuarioRepository;
	@Autowired
    private TokenService tokenService;


    /**
     * Crea un nuevo reto.
     *
     * @param retoDTO Información del reto a crear.
     * @return El DTO del reto creado.
     */
    public RetoDTO crearReto(RetoDTO retoDTO) {
        Reto reto = new Reto();
        reto.setNombre(retoDTO.getNombre());
        reto.setDeporte(retoDTO.getDeporte());
        reto.setFechaInicio(retoDTO.getFechaInicio());
        reto.setFechaFin(retoDTO.getFechaFin());
        reto.setDistanciaObjetivo(retoDTO.getDistanciaObjetivo());
        reto.setTiempoObjetivo(retoDTO.getTiempoObjetivo());
        retoRepository.save(reto);

        return convertirEntidadADTO(reto);
    }

    /**
     * Obtiene la lista de retos activos (retos cuya fecha de fin es posterior a la actual).
     *
     * @return Lista de retos activos en formato DTO.
     */
    public List<RetoDTOResponse> obtenerRetosActivos() {
        LocalDate fechaActual = LocalDate.now();
        List<Reto> retosActivos = retoRepository.findByFechaFinAfter(fechaActual);
        return retosActivos.stream().map(this::convertirEntidadADTOResponse).collect(Collectors.toList());
    }

    /**
     * Obtiene la lista de retos aceptados por un usuario.
     *
     * @param token Token del usuario autenticado.
     * @return Lista de retos aceptados en formato DTO.
     */
    public List<RetoDTOResponse> obtenerRetosAceptados(String token) {
        // Validar el token y obtener el usuario correspondiente
        Usuario usuario = tokenService.getUsuarioPorToken(token);

        // Retos aceptados por el usuario
        return usuario.getRetosAceptados()
                .stream()
                .map(this::convertirEntidadADTOResponse)
                .collect(Collectors.toList());
    }

    /**
     * Permite a un usuario aceptar un reto.
     *
     * @param retoId ID del reto a aceptar.
     * @param token  Token del usuario autenticado.
     */
    public void aceptarReto(Long retoId, String token) {
        // Validar el token y obtener el usuario correspondiente
        Usuario usuario = tokenService.getUsuarioPorToken(token);

        // Buscar el reto a aceptar
        Reto reto = retoRepository.findById(retoId)
                .orElseThrow(() -> new IllegalArgumentException("Reto no encontrado"));

        // Añadir el reto a la lista de retos aceptados del usuario
        usuario.getRetosAceptados().add(reto);
        usuarioRepository.save(usuario);
    }

    /**
     * Convierte un objeto entidad `Reto` a su correspondiente DTO.
     *
     * @param reto Entidad Reto.
     * @return DTO correspondiente.
     */
    private RetoDTO convertirEntidadADTO(Reto reto) {
        return new RetoDTO(
                reto.getNombre(),
                reto.getFechaInicio(),
                reto.getFechaFin(),
                reto.getDistanciaObjetivo(),
                reto.getTiempoObjetivo(),
                reto.getDeporte()
        );
    }
    private RetoDTOResponse convertirEntidadADTOResponse(Reto reto) {
    	return new RetoDTOResponse(
    			reto.getId(),
                reto.getNombre(),
                reto.getFechaInicio(),
                reto.getFechaFin(),
                reto.getDistanciaObjetivo(),
                reto.getTiempoObjetivo(),
                reto.getDeporte()
        );
    }
}