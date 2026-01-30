package com.gimnasiocampus.service;

import com.gimnasiocampus.dto.ClienteDTO;
import com.gimnasiocampus.entity.Cliente;
import com.gimnasiocampus.entity.Rutina;
import com.gimnasiocampus.repository.ClienteRepository;
import com.gimnasiocampus.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO save(ClienteDTO dto) {
        // Verificar si el documento ya existe antes de guardar
        if (clienteRepository.findByDocumento(dto.getDocumento()).isPresent()) {
            throw new RuntimeException("El documento ya existe");
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setDocumento(dto.getDocumento());
        cliente.setActivo(true);
        Cliente guardado = clienteRepository.save(cliente);
        return convertToDTO(guardado);
    }

    @Override
    public void asignarRutina(Long clienteId, Long rutinaId) {
        // Gestión de la relación Muchos a Muchos mediante la tabla intermedia.
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
        Rutina rutina = rutinaRepository.findById(rutinaId).orElseThrow();
        cliente.getRutinas().add(rutina);
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<com.gimnasiocampus.dto.RutinaDTO> listarRutinasDeCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return cliente.getRutinas().stream().map(rutina -> {
            com.gimnasiocampus.dto.RutinaDTO rdto = new com.gimnasiocampus.dto.RutinaDTO();
            rdto.setId(rutina.getId());
            rdto.setNombre(rutina.getNombre());
            rdto.setNivel(rutina.getNivel());
            return rdto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void quitarRutina(Long clienteId, Long rutinaId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Rutina rutina = rutinaRepository.findById(rutinaId)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        cliente.getRutinas().remove(rutina);

        clienteRepository.save(cliente);
    }

    @Override
    public ClienteDTO update(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        cliente.setNombre(dto.getNombre());
        cliente.setActivo(dto.isActivo());

        Cliente actualizado = clienteRepository.save(cliente);
        return convertToDTO(actualizado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Limpieza de relaciones para mantener la integridad referencial
        cliente.getRutinas().clear();
        clienteRepository.delete(cliente);
    }

    // Método para convertir una entidad Cliente en su DTO correspondiente.
    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setDocumento(cliente.getDocumento());
        dto.setActivo(cliente.isActivo());
        return dto;
    }
}