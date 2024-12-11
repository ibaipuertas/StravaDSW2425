package com.deusto.strava.dto;

import java.time.LocalDate;

public class RetoDTOResponse {
	private Long id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double distanciaObjetivo; // en km
    private Integer tiempoObjetivo; // en minutos
    private String deporte;

    public RetoDTOResponse(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, Double distanciaObjetivo, Integer tiempoObjetivo, String deporte) {
        this.id = id;
    	this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.distanciaObjetivo = distanciaObjetivo;
        this.tiempoObjetivo = tiempoObjetivo;
        this.deporte = deporte;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RetoDTOResponse() {
    	
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getDistanciaObjetivo() {
		return distanciaObjetivo;
	}

	public void setDistanciaObjetivo(Double distanciaObjetivo) {
		this.distanciaObjetivo = distanciaObjetivo;
	}

	public Integer getTiempoObjetivo() {
		return tiempoObjetivo;
	}

	public void setTiempoObjetivo(Integer tiempoObjetivo) {
		this.tiempoObjetivo = tiempoObjetivo;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
  
}
