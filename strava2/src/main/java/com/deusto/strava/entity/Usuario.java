package com.deusto.strava.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nombre;
    private LocalDate fechaNacimiento;

    private Double peso; // Opcional
    private Double altura; // Opcional
    private Integer fcMaxima; // Frecuencia cardíaca máxima
    private Integer fcReposo; // Frecuencia cardíaca en reposo

    @Enumerated(EnumType.STRING)
    private TipoLogin tipoLogin; // Tipo de login: GOOGLE o META

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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Integer getFcMaxima() {
		return fcMaxima;
	}

	public void setFcMaxima(Integer fcMaxima) {
		this.fcMaxima = fcMaxima;
	}

	public Integer getFcReposo() {
		return fcReposo;
	}

	public void setFcReposo(Integer fcReposo) {
		this.fcReposo = fcReposo;
	}

	public TipoLogin getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(TipoLogin tipoLogin) {
		this.tipoLogin = tipoLogin;
	}
    
}