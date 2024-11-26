package com.velas.ecommerce.Mappers;

import com.velas.ecommerce.Dto.Pedido.DetallePedidoDTO;
import com.velas.ecommerce.Entities.DetallePedido;
import com.velas.ecommerce.Entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DetallePedidoMapper {

    public DetallePedidoDTO toDTO(DetallePedido detalle) {
        if (detalle == null) return null;

        DetallePedidoDTO dto = new DetallePedidoDTO();
        Producto producto = detalle.getProducto();

        // Datos básicos del detalle
        dto.setProductoId(producto.getId());
        dto.setNombreProducto(producto.getNombre());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());

        // Información del producto
        dto.setTipoProducto(producto.getTipo());
        dto.setEsAromatico(producto.getEsAromatico());
        if (producto.getEsAromatico()) {
            dto.setAroma(producto.getAroma());
        }

        // Buscar imagen principal
        if (producto.getImagenes() != null && !producto.getImagenes().isEmpty()) {
            for (ImagenProducto img : producto.getImagenes()) {
                if (img.getEsPrincipal()) {
                    dto.setImagenProducto(img.getUrlImagen());
                    break;
                }
            }
        }

        return dto;
    }

    public List<DetallePedidoDTO> toDTOList(List<DetallePedido> detalles) {
        List<DetallePedidoDTO> dtos = new ArrayList<>();
        for (DetallePedido detalle : detalles) {
            dtos.add(toDTO(detalle));
        }
        return dtos;
    }

    // Este método generalmente no se usa ya que los detalles se crean
    // desde el carrito, pero lo mantenemos por completitud
    public DetallePedido toEntity(DetallePedidoDTO dto) {
        if (dto == null) return null;

        DetallePedido detalle = new DetallePedido();
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(dto.getPrecioUnitario());
        detalle.setSubtotal(dto.getSubtotal());
        return detalle;
    }
}