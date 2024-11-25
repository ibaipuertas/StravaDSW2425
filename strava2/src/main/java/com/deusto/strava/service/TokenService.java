package com.deusto.strava.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {

    private final Map<String, String> tokensActivos = new ConcurrentHashMap<>();

    /**
     * Genera y almacena un token para un usuario.
     * @param email Email del usuario.
     * @return Token generado.
     */
    public String generarToken(String email) {
        String token = String.valueOf(System.currentTimeMillis());
        tokensActivos.put(token, email);
        return token;
    }

    /**
     * Valida si un token es válido y está asociado a un usuario.
     * @param token Token recibido.
     * @return Email asociado al token, o null si no es válido.
     */
    public String validarToken(String token) {
        return tokensActivos.get(token);
    }

    /**
     * Elimina un token al realizar logout.
     * @param token Token a eliminar.
     */
    public void eliminarToken(String token) {
        tokensActivos.remove(token);
    }
}

