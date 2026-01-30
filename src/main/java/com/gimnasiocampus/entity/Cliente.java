package com.gimnasiocampus.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Entidad JPA que representa la tabla 'clientes' en la base de datos.
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String documento;

    @Column(nullable = false)
    private boolean activo = true;

    // Implementación de relación Muchos a Muchos con Rutinas.
    @ManyToMany
    @JoinTable(
            name = "cliente_rutina",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "rutina_id")
    )
    private List<Rutina> rutinas = new ArrayList<>();

    // Constructor vacío.
    public Cliente() {

    }

    // Getters y Setters manuales.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public List<Rutina> getRutinas() { return rutinas; }
    public void setRutinas(List<Rutina> rutinas) { this.rutinas = rutinas; }
}