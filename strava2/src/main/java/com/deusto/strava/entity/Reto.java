package com.deusto.strava.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Reto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String deporte; // Ciclismo, Running
    private Double DistanciaObjetivo;
    private Integer TiempoObjetivo; // en mins

    @ManyToOne
    private Usuario creador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public Double getDistanciaObjetivo() {
		return DistanciaObjetivo;
	}

	public void setDistanciaObjetivo(Double distanciaObjetivo) {
		DistanciaObjetivo = distanciaObjetivo;
	}

	public Integer getTiempoObjetivo() {
		return TiempoObjetivo;
	}

	public void setTiempoObjetivo(Integer tiempoObjetivo) {
		TiempoObjetivo = tiempoObjetivo;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

    
    
}
