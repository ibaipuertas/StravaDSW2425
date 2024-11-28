package com.deusto.strava.service;

import org.springframework.stereotype.Service;

import com.deusto.strava.dao.UsuarioRepository;
import com.deusto.strava.entity.Usuario;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {

    private final Map<String, String> tokensActivos = new ConcurrentHashMap<>();

    UsuarioRepository usuarioRepository;
    /**
     * Genera y almacena un token para un usuario.
     * @param email Email del usuario.
     * @return Token generado.
     */
    public String generarToken(String email) {
        String token = String.valueOf(System.currentTimeMillis()+email);
        tokensActivos.put(token, email);
        return token;
    }

    /**
     * Valida si un token es válido y está asociado a un usuario.
     * @param token Token recibido.
     * @return Email asociado al token, o null si no es válido.
     */
    public Boolean validarToken(String token) {
    	return tokensActivos.containsKey(token);
    }

    /**
     * Elimina un token al realizar logout.
     * @param token Token a eliminar.
     */
    public void eliminarToken(String token) {
        tokensActivos.remove(token);
    }
    
    /**
     * Obtiene el usuario asociado a un token activo.
     *
     * @param token Token del usuario.
     * @return Usuario asociado, o null si el token no es válido.
     */
    public String getUsuarioPorToken(String token) {
        return tokensActivos.get(token);
    }

    /**
     * Encuentra un token asociado a un usuario activo.
     *
     * @param usuario Usuario cuya asociación con un token se desea buscar.
     * @return Token asociado al usuario, o null si no existe.
     */
    public String findByUser(Usuario usuario) {
        return tokensActivos.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(usuario))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
    
    public String findTokenByEmail(String email) {
        return tokensActivos.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(email))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}

