package com.velas.ecommerce.Mappers;

import com.velas.ecommerce.Dto.Usuario.UsuarioActualizacionDTO;
import com.velas.ecommerce.Dto.Usuario.UsuarioRegistroDTO;
import com.velas.ecommerce.Dto.Usuario.UsuarioRespuestaDTO;
import com.velas.ecommerce.Entities.Usuario;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    public UsuarioRespuestaDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioRespuestaDTO dto = new UsuarioRespuestaDTO();
        dto.setId(usuario.getId());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setEmail(usuario.getEmail());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());

        if (usuario.getRol() != null) {
            dto.setRol(usuario.getRol().getNombreRol());
        }

        dto.setActivo(usuario.getActivo());
        return dto;
    }

    public Usuario toEntity(UsuarioActualizacionDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());

        // Solo actualizar contraseña si se proporciona una nueva
        if (dto.getContrasena() != null && !dto.getContrasena().isEmpty()) {
            usuario.setContrasena(dto.getContrasena());
        }

        return usuario;
    }
}
