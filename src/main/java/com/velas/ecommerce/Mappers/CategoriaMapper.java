package com.velas.ecommerce.Mappers;

import com.velas.ecommerce.Dto.Categoria.CategoriaDTO;
import com.velas.ecommerce.Entities.Categoria;
import com.velas.ecommerce.Repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoriaMapper {
    private final CategoriaRepository categoriaRepository;

    public CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        dto.setEsPrincipal(categoria.getEsPrincipal());

        if (categoria.getCategoriaPadre() != null) {
            dto.setCategoriaPadreId(categoria.getCategoriaPadre().getId());
        }

        return dto;
    }

    public List<CategoriaDTO> toDTOList(List<Categoria> categorias) {
        List<CategoriaDTO> dtos = new ArrayList<>();
        for(Categoria categoria : categorias) {
            dtos.add(toDTO(categoria));
        }
        return dtos;
    }
}
