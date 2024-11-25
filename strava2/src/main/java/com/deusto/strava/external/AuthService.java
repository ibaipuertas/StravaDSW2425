package com.deusto.strava.external;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    // Simulación de usuarios registrados en Google y Meta para pruebas
    private final Map<String, String> googleUsers;
    private final Map<String, String> metaUsers;

    public AuthService() {
        googleUsers = new HashMap<>();
        metaUsers = new HashMap<>();

        // Usuarios de prueba en Google
        googleUsers.put("user1@gmail.com", "password123");
        googleUsers.put("user2@gmail.com", "securePass");

        // Usuarios de prueba en Meta
        metaUsers.put("user3@facebook.com", "metaPass");
        metaUsers.put("user4@facebook.com", "1234abcd");
    }

    /**
     * Verifica las credenciales del usuario con Google o Meta.
     * 
     * @param email Email del usuario.
     * @param password Contraseña del usuario.
     * @param tipoLogin Tipo de autenticación ("GOOGLE" o "META").
     * @return True si las credenciales son válidas, false en caso contrario.
     */
    public boolean verificarLogin(String email, String password, String tipoLogin) {
        switch (tipoLogin.toUpperCase()) {
            case "GOOGLE":
                return verificarGoogle(email, password);
            case "META":
                return verificarMeta(email, password);
            default:
                throw new IllegalArgumentException("Tipo de login no soportado: " + tipoLogin);
        }
    }

    /**
     * Verifica las credenciales del usuario en Google.
     * 
     * @param email Email del usuario.
     * @param password Contraseña del usuario.
     * @return True si las credenciales son válidas, false en caso contrario.
     */
    private boolean verificarGoogle(String email, String password) {
        return googleUsers.containsKey(email) && googleUsers.get(email).equals(password);
    }

    /**
     * Verifica las credenciales del usuario en Meta.
     * 
     * @param email Email del usuario.
     * @param password Contraseña del usuario.
     * @return True si las credenciales son válidas, false en caso contrario.
     */
    private boolean verificarMeta(String email, String password) {
        return metaUsers.containsKey(email) && metaUsers.get(email).equals(password);
    }
}
