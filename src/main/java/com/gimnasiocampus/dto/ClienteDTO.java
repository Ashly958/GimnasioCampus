package com.gimnasiocampus.dto;

import jakarta.validation.constraints.NotBlank;

//Data Transfer Object para la entidad Cliente.

public class ClienteDTO {

    private Long id;

    @NotBlank(message = "Nombre obligatorio")
    private String nombre;

    @NotBlank(message = "Documento obligatorio")
    private String documento;

    private boolean activo;

    // Constructor vacío necesario para la serialización/deserialización JSON.
    public ClienteDTO() {

    }

    // Getters y Setters manuales.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}