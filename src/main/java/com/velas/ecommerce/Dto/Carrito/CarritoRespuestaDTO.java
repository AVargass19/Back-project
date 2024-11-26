package com.velas.ecommerce.Dto.Carrito;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class CarritoRespuestaDTO {
    private Long id;
    private List<ItemCarritoDetalleDTO> items;
    private BigDecimal total;
}
