package com.deusto.strava.dto;

import com.deusto.strava.entity.TipoLogin;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    private String email;
    private String nombre;
    private TipoLogin tipoLogin;

    public UsuarioRequestDTO(String email, String nombre, TipoLogin tipoLogin) {
        this.email = email;
        this.nombre = nombre;
        this.tipoLogin = tipoLogin;
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
