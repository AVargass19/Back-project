package com.velas.ecommerce.Mappers;

import com.velas.ecommerce.Dto.Direccion.DireccionDTO;
import com.velas.ecommerce.Entities.Direccion;
import com.velas.ecommerce.Entities.Usuario;
import com.velas.ecommerce.Exceptions.Generales.ResourceNotFoundException;
import com.velas.ecommerce.Repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DireccionMapper {
    private final UsuarioRepository usuarioRepository;

    public DireccionDTO toDTO(Direccion direccion) {
        if (direccion == null) return null;

        DireccionDTO dto = new DireccionDTO();
        dto.setId(direccion.getId());
        dto.setCalle(direccion.getCalle());
        dto.setDescripcion(direccion.getDescripcion());
        dto.setMunicipio(direccion.getMunicipio());
        dto.setDepartamento(direccion.getDepartamento());
        dto.setCodigoPostal(direccion.getCodigoPostal());

        if (direccion.getUsuario() != null) {
            dto.setUsuarioId(direccion.getUsuario().getId());
        }

        return dto;
    }

    public List<DireccionDTO> toDTOList(List<Direccion> direcciones) {
        List<DireccionDTO> dtos = new ArrayList<>();
        for(Direccion direccion : direcciones) {
            dtos.add(toDTO(direccion));
        }
        return dtos;
    }
}
