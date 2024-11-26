package com.velas.ecommerce.Mappers;

import com.velas.ecommerce.Dto.Pedido.DetallePedidoDTO;
import com.velas.ecommerce.Dto.Pedido.PedidoRespuestaDTO;
import com.velas.ecommerce.Entities.DetallePedido;
import com.velas.ecommerce.Entities.Direccion;
import com.velas.ecommerce.Entities.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoMapper {
    private final DetallePedidoMapper detallePedidoMapper;

    public PedidoRespuestaDTO toDTO(Pedido pedido) {
        PedidoRespuestaDTO dto = new PedidoRespuestaDTO();

        // Datos básicos
        dto.setId(pedido.getId());
        dto.setEstado(pedido.getEstado());
        dto.setEstadoPago(pedido.getEstadoPago());
        dto.setFechaCreacion(pedido.getFechaCreacion());
        dto.setTotal(pedido.getTotal());

        // Convertir detalles del pedido
        if (pedido.getDetalles() != null) {
            List<DetallePedidoDTO> detallesDTO = new ArrayList<>();
            for (DetallePedido detalle : pedido.getDetalles()) {
                detallesDTO.add(detallePedidoMapper.toDTO(detalle));
            }
            dto.setDetalles(detallesDTO);
        }

        // Datos de envío y dirección
        if (pedido.getDireccionEnvio() != null) {
            Direccion dir = pedido.getDireccionEnvio();
            String direccionCompleta = dir.getCalle() + ", " +
                    dir.getDescripcion() + ", " +
                    dir.getMunicipio() + ", " +
                    dir.getDepartamento();
            dto.setDireccionEnvio(direccionCompleta);
        }

        // Datos de pago y envío
        dto.setPreferenciaPagoId(pedido.getPreferenciaPagoId());
        dto.setTransaccionId(pedido.getTransaccionId());
        dto.setCodigoSeguimiento(pedido.getCodigoSeguimiento());
        dto.setMetodoEnvio(pedido.getMetodoEnvio());
        dto.setCostoEnvio(pedido.getCostoEnvio());

        return dto;
    }
}
