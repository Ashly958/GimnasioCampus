package com.gimnasiocampus.service;

import com.gimnasiocampus.dto.RutinaDTO;
import com.gimnasiocampus.entity.Cliente;
import com.gimnasiocampus.entity.Rutina;
import com.gimnasiocampus.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RutinaServiceImpl implements IRutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Override
    public List<RutinaDTO> findAll() {
        return rutinaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RutinaDTO findById(Long id) {
        return rutinaRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    @Override
    public RutinaDTO save(RutinaDTO dto) {
        Rutina rutina = new Rutina();
        if (dto.getId() != null) rutina.setId(dto.getId());
        rutina.setNombre(dto.getNombre());
        rutina.setNivel(dto.getNivel());

        Rutina guardada = rutinaRepository.save(rutina);
        return convertToDTO(guardada);
    }

    @Override
    public RutinaDTO update(Long id, RutinaDTO dto) {
        Rutina rutina = rutinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        rutina.setNombre(dto.getNombre());
        rutina.setNivel(dto.getNivel());

        Rutina actualizada = rutinaRepository.save(rutina);
        return convertToDTO(actualizada);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Rutina rutina = rutinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        // Antes de eliminar la rutina, se remueve de la lista de cada cliente asociado para mantener la integridad de la tabla intermedia 'cliente_rutina'.
        for (Cliente cliente : rutina.getClientes()) {
            cliente.getRutinas().remove(rutina);
        }

        rutinaRepository.delete(rutina);
    }

    // Mapeador interno para convertir la entidad Rutina al DTO de salida.
    private RutinaDTO convertToDTO(Rutina rutina) {
        RutinaDTO dto = new RutinaDTO();
        dto.setId(rutina.getId());
        dto.setNombre(rutina.getNombre());
        dto.setNivel(rutina.getNivel());
        return dto;
    }
}
