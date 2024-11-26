package com.velas.ecommerce.Repositories;

import com.velas.ecommerce.Entities.Pedido;
import com.velas.ecommerce.Entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Cambiar de Producto a Pedido
    Page<Pedido> findByUsuarioId(Long usuarioId, Pageable pageable);

    List<Pedido> findByEstado(String estado);

    @Query("SELECT p FROM Pedido p WHERE p.fechaCreacion BETWEEN :inicio AND :fin")
    List<Pedido> buscarPedidosPorFecha(
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado AND p.fechaCreacion <= :fecha")
    List<Pedido> buscarPedidosPendientes(
            @Param("estado") String estado,
            @Param("fecha") LocalDateTime fecha
    );
}