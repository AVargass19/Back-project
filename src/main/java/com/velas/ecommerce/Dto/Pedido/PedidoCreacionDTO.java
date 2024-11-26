package com.velas.ecommerce.Dto.Pedido;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PedidoCreacionDTO {
    @NotNull(message = "La dirección de envío es obligatoria")
    private Long direccionEnvioId;

    private String metodoEnvio;

    private BigDecimal costoEnvio;
}

