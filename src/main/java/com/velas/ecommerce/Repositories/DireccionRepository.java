package com.velas.ecommerce.Repositories;

import com.velas.ecommerce.Entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    List<Direccion> findByUsuarioId(Long usuarioId);

    @Query("SELECT d FROM Direccion d WHERE d.municipio = :municipio AND d.departamento = :departamento")
    List<Direccion> buscarPorUbicacion(
            @Param("municipio") String municipio,
            @Param("departamento") String departamento
    );

    Long countByUsuarioId(Long usuarioId);
}
