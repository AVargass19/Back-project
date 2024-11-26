package com.velas.ecommerce.Dto.Pagos;

import lombok.Data;

@Data
public class PagoResponseDTO {
    private String id;
    private String status;
    private String initPoint; // URL de Mercado Pago para el checkout
    private String sandboxInitPoint;
}
