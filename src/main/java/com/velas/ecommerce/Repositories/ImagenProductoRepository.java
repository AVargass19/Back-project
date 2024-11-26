package com.velas.ecommerce.Repositories;

import com.velas.ecommerce.Entities.ImagenProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ImagenProductoRepository extends JpaRepository<ImagenProducto, Long> {
    List<ImagenProducto> findByProductoId(Long productoId);
    Optional<ImagenProducto> findByProductoIdAndEsPrincipalTrue(Long productoId);
    void deleteByProductoId(Long productoId);
}