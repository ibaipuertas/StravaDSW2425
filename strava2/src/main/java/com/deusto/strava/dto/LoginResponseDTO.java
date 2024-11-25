package com.deusto.strava.dto;

import com.deusto.strava.entity.TipoLogin;
import lombok.Data;

@Data
public class LoginResponseDTO {

    private Long id;
    private String email;
    private String nombre;
    private TipoLogin tipoLogin;

    public LoginResponseDTO(Long id, String email, String nombre, TipoLogin tipoLogin) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.tipoLogin = tipoLogin;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoLogin getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(TipoLogin tipoLogin) {
		this.tipoLogin = tipoLogin;
	}
    
}