package com.velas.ecommerce.Repositories;

import com.velas.ecommerce.Entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Búsquedas básicas
    Page<Producto> findByActivoTrue(Pageable pageable);
    List<Producto> findByTipoAndActivoTrue(String tipo);

    // Búsqueda por texto
    @Query("SELECT p FROM Producto p WHERE p.activo = true AND " +
            "(LOWER(p.nombre) LIKE %:texto% OR LOWER(p.descripcion) LIKE %:texto%)")
    Page<Producto> buscarProductos(@Param("texto") String texto, Pageable pageable);

    // Búsqueda por rango de precios
    @Query("SELECT p FROM Producto p WHERE p.activo = true AND p.precio BETWEEN :min AND :max")
    Page<Producto> buscarPorRangoPrecio(
            @Param("min") BigDecimal minimo,
            @Param("max") BigDecimal maximo,
            Pageable pageable
    );

    // Control de inventario
    @Query("SELECT p FROM Producto p WHERE p.stock < :minimo AND p.activo = true")
    List<Producto> buscarProductosBajoStock(@Param("minimo") Integer stockMinimo);
}