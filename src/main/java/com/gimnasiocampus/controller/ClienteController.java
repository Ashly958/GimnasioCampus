package com.gimnasiocampus.controller;

import com.gimnasiocampus.dto.ClienteDTO;
import com.gimnasiocampus.dto.RutinaDTO;
import com.gimnasiocampus.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Controlador REST para la gestión de clientes y sus asignaciones.
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    // Se obtiene el listado completo de clientes registrados.
    @GetMapping
    public List<ClienteDTO> getAll() {
        return clienteService.findAll();
    }

    // Retorna las rutinas asociadas a un cliente específico (Relación ManyToMany).
    @GetMapping("/{clienteId}/rutinas")
    public ResponseEntity<List<RutinaDTO>> listarRutinas(@PathVariable Long clienteId) {
        return ResponseEntity.ok(clienteService.listarRutinasDeCliente(clienteId));
    }

    // Gestiona la asignación de una rutina a un cliente en la tabla intermedia.
    @PostMapping("/{clienteId}/rutinas/{rutinaId}")
    public ResponseEntity<String> asignar(@PathVariable Long clienteId, @PathVariable Long rutinaId) {
        clienteService.asignarRutina(clienteId, rutinaId);
        return ResponseEntity.ok("Rutina asignada con éxito");
    }

    // Crea un nuevo registro de cliente en la base de datos.
    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.save(dto));
    }

    // Actualiza la información de un cliente existente por su ID.
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.update(id, dto));
    }

    // Elimina un cliente y sus relaciones asociadas.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}