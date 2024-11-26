package com.velas.ecommerce.Repositories;

import com.velas.ecommerce.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNombre(String nombre);
    List<Categoria> findByEsPrincipal(boolean esPrincipal);

    @Query("SELECT c FROM Categoria c WHERE c.categoriaPadre IS NULL")
    List<Categoria> buscarCategoriasPrincipales();

    @Query("SELECT c FROM Categoria c WHERE c.categoriaPadre.id = :idPadre")
    List<Categoria> buscarSubcategorias(@Param("idPadre") Long idCategoriaPadre);

    @Query("SELECT c FROM Categoria c WHERE c.categoriaPadre.id = :idCategoriaPadre")
    List<Categoria> findSubcategoriasPorCategoriaPadre(@Param("idCategoriaPadre") Long idCategoriaPadre);

    boolean existsByNombre(String nombre);
}