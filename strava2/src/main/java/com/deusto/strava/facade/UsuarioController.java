package com.deusto.strava.facade;

import com.deusto.strava.dto.RegistroUsuarioDTO;
import com.deusto.strava.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Gestión de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    @Operation(summary = "Registro de usuario")
    public ResponseEntity<String> registro(
    		@RequestParam("email") String email,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("fechaNacimiento") String fechaNacimiento,
    		@RequestParam("contrasena") String contrasena,
    		@RequestParam("peso") Double peso, // en kilogramos
    		@RequestParam("altura") Integer altura) {// en centímetros)
    	
        LocalDate nacimiento = LocalDate.parse(fechaNacimiento);
    	RegistroUsuarioDTO rUDTO = new RegistroUsuarioDTO(email, nombre, nacimiento, contrasena, peso, altura) ;
        usuarioService.registro(rUDTO);
    	return ResponseEntity.ok("Usuario correctamente registrado!");
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login de usuario")
    public ResponseEntity<String> login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("tipoLogin") String tipoLogin) {
        String token = usuarioService.login(email, password, tipoLogin);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout de usuario")
    public ResponseEntity<String> logout(@RequestParam("token") String token) {
        usuarioService.logout(token);
        return ResponseEntity.ok("Logout exitoso.");
    }
}
