package com.velas.ecommerce.Repositories;

import com.velas.ecommerce.Entities.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {
    List<ItemCarrito> findByCarritoId(Long carritoId);

    @Query("SELECT ic FROM ItemCarrito ic WHERE ic.carrito.id = :carritoId AND ic.producto.id = :productoId")
    Optional<ItemCarrito> buscarItemEnCarrito(
            @Param("carritoId") Long carritoId,
            @Param("productoId") Long productoId
    );

    @Query("SELECT COUNT(ic) FROM ItemCarrito ic WHERE ic.carrito.id = :carritoId")
    Integer contarItemsEnCarrito(@Param("carritoId") Long carritoId);
}