package com.gimnasiocampus.service;

import com.gimnasiocampus.dto.ClienteDTO;
import com.gimnasiocampus.dto.RutinaDTO;

import java.util.List;

public interface IClienteService {

    // CRUD Básico
    List<ClienteDTO> findAll();
    ClienteDTO save(ClienteDTO clienteDTO);
    ClienteDTO update(Long id, ClienteDTO clienteDTO);
    void delete(Long id);

    // Gestión de la relación ManyToMany
    void asignarRutina(Long clienteId, Long rutinaId);

    // Recupera el catálogo de rutinas asignadas a un cliente.
    List<RutinaDTO> listarRutinasDeCliente(Long clienteId);

    // Elimina la asociación entre un cliente y una rutina sin borrar las entidades de base.
    void quitarRutina(Long clienteId, Long rutinaId);
}