package com.gimnasiocampus.repository;

import com.gimnasiocampus.entity.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Long> {
    // Consulta para localizar una rutina por su nombre exacto.
    Optional<Rutina> findByNombre(String nombre);
}
