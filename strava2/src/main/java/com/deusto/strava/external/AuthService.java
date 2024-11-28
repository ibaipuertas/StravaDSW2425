package com.deusto.strava.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deusto.strava.dao.UsuarioRepository;
import com.deusto.strava.entity.Usuario;


@Service
public class AuthService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean verificarLogin(String email, String password, String tipoLogin) {
        switch (tipoLogin.toUpperCase()) {
            case "GOOGLE":
                return verificarGoogle(email, password);
            case "META":
                return verificarMeta(email, password);
            case "STRAVA":
                return verificarStrava(email, password);
            default:
                throw new IllegalArgumentException("Tipo de login no soportado: " + tipoLogin);
        }
    }

    private boolean verificarGoogle(String email, String password) {
//        return googleUsers.containsKey(email) && googleUsers.get(email).equals(password);
    	return true;
    }

    private boolean verificarMeta(String email, String password) {
//        return metaUsers.containsKey(email) && metaUsers.get(email).equals(password);
    	return true;
    }
    
    private boolean verificarStrava(String email, String password) {
    	 Usuario usuario = usuarioRepository.findByEmail(email);

         // Verificar si el usuario existe y si la contraseña coincide
         if (usuario != null && usuario.getContrasena().equals(password)) {
             return true;
         }
         return false;
    }
}
