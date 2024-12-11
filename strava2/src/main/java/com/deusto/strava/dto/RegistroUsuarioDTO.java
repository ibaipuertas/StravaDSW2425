package com.deusto.strava.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegistroUsuarioDTO {
    private String email;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String contrasena;

    // Información opcional
    private Double peso; // en kilogramos
    private Integer altura; // en centímetros
    
	public RegistroUsuarioDTO(String email, String nombre, LocalDate fechaNacimiento, String contrasena, Double peso,
			Integer altura) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
		this.peso = peso;
		this.altura = altura;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getContraseña() {
		return contrasena;
	}

	public void setContraseña(String contrasena) {
		this.contrasena = contrasena;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	
    
    
}
