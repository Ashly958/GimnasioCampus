package com.gimnasiocampus.service;

import com.gimnasiocampus.dto.RutinaDTO;
import java.util.List;

public interface IRutinaService {

    // Recupera todas las rutinas registradas en el sistema.
    List<RutinaDTO> findAll();

    // Busca una rutina específica por su identificador único.
    RutinaDTO findById(Long id);

    // Registra una nueva rutina en el catálogo.
    RutinaDTO save(RutinaDTO rutinaDTO);

    // Actualiza los datos de una rutina existente (nombre o nivel).
    RutinaDTO update(Long id, RutinaDTO rutinaDTO);

    // Elimina una rutina del catálogo general.
    void delete(Long id);
}