package com.deusto.strava.dto;

import lombok.Data;

import java.time.LocalDate;

import com.deusto.strava.entity.Reto;

@Data
public class RetoDTO {

    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double distanciaObjetivo; // en km
    private Integer tiempoObjetivo; // en minutos
    private String deporte;

    public RetoDTO(String nombre, LocalDate fechaInicio, LocalDate fechaFin, Double distanciaObjetivo, Integer tiempoObjetivo, String deporte) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.distanciaObjetivo = distanciaObjetivo;
        this.tiempoObjetivo = tiempoObjetivo;
        this.deporte = deporte;
    }

    public RetoDTO() {
    	
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