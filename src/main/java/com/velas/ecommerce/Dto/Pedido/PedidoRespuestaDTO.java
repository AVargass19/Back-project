package com.velas.ecommerce.Dto.Pedido;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoRespuestaDTO {
    private Long id;
    private String estado;
    private String estadoPago;
    private LocalDateTime fechaCreacion;
    private BigDecimal total;
    private List<DetallePedidoDTO> detalles = new ArrayList<>();
    private String direccionEnvio;
    private String preferenciaPagoId;
    private String urlPago;
    private String transaccionId;
    private String codigoSeguimiento;
    private String metodoEnvio;
    private BigDecimal costoEnvio;

    public boolean estaPagado() {
        return "PAGADO".equals(estadoPago);
    }

    public boolean puedeSerCancelado() {
        return !estaPagado() && !"CANCELADO".equals(estado);
    }

    public BigDecimal calcularTotalConEnvio() {
        return total.add(costoEnvio != null ? costoEnvio : BigDecimal.ZERO);
    }
}