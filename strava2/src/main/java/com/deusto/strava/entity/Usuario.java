package com.deusto.strava.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nombre;
    private String fechaNacimiento;

    // Información opcional
    private Double peso; // en kilogramos
    private Integer altura; // en centímetros
    private Integer frecuenciaCardiacaMaxima;
    private Integer frecuenciaCardiacaReposo;

    private String token; // Token actual del usuario
    private String tipoLogin; // Puede ser "Google" o "Meta"

    // Relación con los retos aceptados
    @ManyToMany
    @JoinTable(
        name = "usuario_reto",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "reto_id")
    )
    private Set<Reto> retosAceptados = new HashSet<>();

    public Usuario() {}

    // Getters y setters
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public Integer getFrecuenciaCardiacaMaxima() {
        return frecuenciaCardiacaMaxima;
    }

    public void setFrecuenciaCardiacaMaxima(Integer frecuenciaCardiacaMaxima) {
        this.frecuenciaCardiacaMaxima = frecuenciaCardiacaMaxima;
    }

    public Integer getFrecuenciaCardiacaReposo() {
        return frecuenciaCardiacaReposo;
    }

    public void setFrecuenciaCardiacaReposo(Integer frecuenciaCardiacaReposo) {
        this.frecuenciaCardiacaReposo = frecuenciaCardiacaReposo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipoLogin() {
        return tipoLogin;
    }

    public void setTipoLogin(String tipoLogin) {
        this.tipoLogin = tipoLogin;
    }

    public Set<Reto> getRetosAceptados() {
        return retosAceptados;
    }

    public void setRetosAceptados(Set<Reto> retosAceptados) {
        this.retosAceptados = retosAceptados;
    }

    public void aceptarReto(Reto reto) {
        this.retosAceptados.add(reto);
    }

    public void eliminarRetoAceptado(Reto reto) {
        this.retosAceptados.remove(reto);
    }
}