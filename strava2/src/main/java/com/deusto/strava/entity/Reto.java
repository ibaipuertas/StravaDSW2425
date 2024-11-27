package com.deusto.strava.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String deporte; // ciclismo o running
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double distanciaObjetivo; // en kilómetros
    private Integer tiempoObjetivo; // en minutos

    @ManyToMany(mappedBy = "retosAceptados")
    private Set<Usuario> usuariosAceptaron = new HashSet<>();

    public Reto() {}

    // Getters y setters
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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
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

	public Set<Usuario> getUsuariosAceptaron() {
        return usuariosAceptaron;
    }

    public void setUsuariosAceptaron(Set<Usuario> usuariosAceptaron) {
        this.usuariosAceptaron = usuariosAceptaron;
    }
}
