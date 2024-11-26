package com.velas.ecommerce.Repositories;

import com.velas.ecommerce.Entities.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findByUsuarioId(Long usuarioId);

    @Query("SELECT c FROM Carrito c WHERE c.fechaActualizacion < :fecha")
    List<Carrito> buscarCarritosAbandonados(@Param("fecha") LocalDateTime fecha);

    void deleteByUsuarioId(Long usuarioId);
}