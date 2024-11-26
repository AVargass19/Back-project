package com.velas.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedido extends EntidadBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "estado", nullable = false)
    private String estado;  // PENDIENTE, CONFIRMADO, ENVIADO, ENTREGADO, CANCELADO

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles;

    // Campos para Mercado Pago
    @Column(name = "preferencia_pago_id")
    private String preferenciaPagoId;

    @Column(name = "estado_pago")
    private String estadoPago; // PENDIENTE, PAGADO, RECHAZADO

    @Column(name = "transaccion_id")
    private String transaccionId;

    // Agregar relación con Dirección
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion_id")
    private Direccion direccionEnvio;

    // Información de envío
    @Column(name = "codigo_seguimiento")
    private String codigoSeguimiento;

    @Column(name = "metodo_envio")
    private String metodoEnvio;

    @Column(name = "costo_envio")
    private BigDecimal costoEnvio;

    @PrePersist
    public void prePersist() {
        if (this.costoEnvio == null) {
            this.costoEnvio = BigDecimal.ZERO;
        }
        if (this.estado == null) {
            this.estado = "PENDIENTE";
        }
        if (this.estadoPago == null) {
            this.estadoPago = "PENDIENTE";
        }
    }
}
