package com.velas.ecommerce.Dto.Pagos;

import lombok.Data;

@Data
public class PagoRequestDTO {
    private Long pedidoId;
    private String descripcion;
    private String successUrl;
    private String failureUrl;
    private String pendingUrl;
}
