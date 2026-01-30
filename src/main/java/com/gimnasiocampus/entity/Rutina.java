package com.gimnasiocampus.entity;

import jakarta.persistence.*;
import java.util.List;

// Entidad JPA que representa las rutinas disponibles en el sistema.
@Entity
@Table(name = "rutinas")
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String nivel;

    // Relación inversa Muchos a Muchos.
    @ManyToMany(mappedBy = "rutinas")
    private List<Cliente> clientes;

    public Rutina() {}

    // Getters y Setters manuales5
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public List<Cliente> getClientes() { return clientes; }
    public void setClientes(List<Cliente> clientes) { this.clientes = clientes; }
}