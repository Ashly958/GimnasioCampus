package com.gimnasiocampus.repository;

import com.gimnasiocampus.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Para validar que no se repita el documento.
    Optional<Cliente> findByDocumento(String documento);
}