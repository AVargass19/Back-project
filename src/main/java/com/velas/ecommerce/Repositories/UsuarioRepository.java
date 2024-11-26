package com.velas.ecommerce.Repositories;

import com.velas.ecommerce.Entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    @Query("SELECT u FROM Usuario u WHERE " +
            "LOWER(u.nombre) LIKE %:busqueda% OR " +
            "LOWER(u.apellido) LIKE %:busqueda% OR " +
            "LOWER(u.email) LIKE %:busqueda%")
    Page<Usuario> buscarUsuarios(@Param("busqueda") String textoBusqueda, Pageable pageable);

    Page<Usuario> findByActivo(boolean activo, Pageable pageable);

    Long countByRolNombreRol(String nombreRol);
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario);
}