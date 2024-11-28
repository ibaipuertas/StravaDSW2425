package com.deusto.strava.dto;

import java.time.LocalDateTime;

public class SesionEntrenamientoDTO {

    private String titulo;
    private String deporte;
    private Double distancia; // en km
    private LocalDateTime fechaInicio;
    private Integer duracion; // en minutos

    public SesionEntrenamientoDTO() {
    }
    
    public SesionEntrenamientoDTO(String titulo, String deporte, Double distancia, LocalDateTime fechaInicio, Integer duracion) {
        this.titulo = titulo;
        this.deporte = deporte;
        this.distancia = distancia;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
    }


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

    
}