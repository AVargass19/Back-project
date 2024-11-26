package com.velas.ecommerce.Mappers;

import com.velas.ecommerce.Dto.Carrito.*;
import com.velas.ecommerce.Entities.*;
import com.velas.ecommerce.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarritoMapper {
    private final ProductoService productoService;

    public CarritoRespuestaDTO toDTO(Carrito carrito) {
        if (carrito == null) return null;

        CarritoRespuestaDTO dto = new CarritoRespuestaDTO();
        dto.setId(carrito.getId());

        // Convertir items y calcular totales
        List<ItemCarritoDetalleDTO> items = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (ItemCarrito item : carrito.getItems()) {
            ItemCarritoDetalleDTO itemDTO = toItemDTO(item);
            items.add(itemDTO);
            total = total.add(itemDTO.getSubtotal());
        }

        dto.setItems(items);
        dto.setTotal(total);
        return dto;
    }

    private ItemCarritoDetalleDTO toItemDTO(ItemCarrito item) {
        ItemCarritoDetalleDTO dto = new ItemCarritoDetalleDTO();
        Producto producto = item.getProducto();

        dto.setId(item.getId());
        dto.setProductoId(producto.getId());
        dto.setNombreProducto(producto.getNombre());
        dto.setPrecioUnitario(producto.getPrecio());
        dto.setCantidad(item.getCantidad());
        dto.setSubtotal(calcularSubtotal(producto.getPrecio(), item.getCantidad()));

        return dto;
    }

    private BigDecimal calcularSubtotal(BigDecimal precio, Integer cantidad) {
        return precio.multiply(new BigDecimal(cantidad));
    }
}