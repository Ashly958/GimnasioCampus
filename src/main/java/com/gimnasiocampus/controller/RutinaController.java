package com.gimnasiocampus.controller;

import com.gimnasiocampus.dto.RutinaDTO;
import com.gimnasiocampus.service.IRutinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador REST para la gestión del catálogo de rutinas del gimnasio.
@RestController
@RequestMapping("/api/rutinas") //
public class RutinaController {

    @Autowired
    private IRutinaService rutinaService;

    // Recupera todas las rutinas disponibles en el catálogo.
    @GetMapping
    public List<RutinaDTO> getAll() {
        return rutinaService.findAll();
    }

    // Registra una nueva rutina validando los campos obligatorios del DTO.
    @PostMapping
    public ResponseEntity<RutinaDTO> create(@Valid @RequestBody RutinaDTO dto) {
        return ResponseEntity.ok(rutinaService.save(dto));
    }

    // Actualiza los parámetros de una rutina existente mediante su ID.
    @PutMapping("/{id}")
    public ResponseEntity<RutinaDTO> update(@PathVariable Long id, @RequestBody RutinaDTO dto) {
        return ResponseEntity.ok(rutinaService.update(id, dto));
    }

    // Elimina una rutina del sistema por ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rutinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
