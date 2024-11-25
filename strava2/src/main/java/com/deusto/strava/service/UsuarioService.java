package com.deusto.strava.service;

import com.deusto.strava.dao.UsuarioRepository;
import com.deusto.strava.entity.Usuario;
import com.deusto.strava.external.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthService externalAuthService;

    @Autowired
    private TokenService tokenService;

    /**
     * Lógica para realizar el login de un usuario.
     * @param email Email del usuario.
     * @param password Contraseña (validada con Google/Meta).
     * @param tipoLogin Tipo de login (GOOGLE o META).
     * @return Token generado si el login es exitoso.
     */
    public String login(String email, String password, String tipoLogin) {
        boolean autenticado = externalAuthService.verificarLogin(email, password, tipoLogin);
        if (!autenticado) {
            throw new IllegalArgumentException("Login fallido. Credenciales incorrectas.");
        }

        Optional<Usuario> usuarioOpt = Optional.of(usuarioRepository.findByEmail(email));
        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuario no registrado en el sistema.");
        }

        // Generar y devolver el token.
        return tokenService.generarToken(email);
    }

    /**
     * Lógica para realizar logout de un usuario.
     * @param token Token a invalidar.
     */
    public void logout(String token) {
        tokenService.eliminarToken(token);
    }
}