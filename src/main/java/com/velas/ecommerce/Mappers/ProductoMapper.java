package com.velas.ecommerce.Mappers;

import com.velas.ecommerce.Dto.Producto.ProductoCreacionDTO;
import com.velas.ecommerce.Dto.Producto.ProductoRespuestaDTO;
import com.velas.ecommerce.Entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductoMapper {

    public ProductoRespuestaDTO toDTO(Producto producto) {
        if (producto == null) return null;

        ProductoRespuestaDTO dto = new ProductoRespuestaDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setTipo(producto.getTipo());
        dto.setEsAromatico(producto.getEsAromatico());
        dto.setAroma(producto.getAroma());

        if (producto.getCategoria() != null) {
            dto.setCategoria(producto.getCategoria().getNombre());
        }

        dto.setActivo(producto.getActivo());

        List<String> imagenes = new ArrayList<>();
        if (producto.getImagenes() != null) {
            for (ImagenProducto img : producto.getImagenes()) {
                imagenes.add(img.getUrlImagen());
            }
        }
        dto.setImagenes(imagenes);

        return dto;
    }
}
