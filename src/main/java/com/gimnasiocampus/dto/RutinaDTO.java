package com.gimnasiocampus.dto;

import jakarta.validation.constraints.NotBlank;

//Data Transfer Object para la entidad Rutina.

public class RutinaDTO {
    private Long id;

    @NotBlank(message = "El nombre de la rutina es obligatorio")
    private String nombre;

    @NotBlank(message = "El nivel es obligatorio")
    private String nivel;

    // Constructor vacío necesario para la serialización/deserialización JSON.
    public RutinaDTO() {

    }

    // Getters y Setters manuales.

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNivel() { return nivel; }

    public void setNivel(String nivel) { this.nivel = nivel; }

}
