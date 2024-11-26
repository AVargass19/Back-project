package com.velas.ecommerce.Dto.Producto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductoRespuestaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private String tipo;
    private Boolean esAromatico;
    private String aroma;
    private String categoria;
    private List<String> imagenes = new ArrayList<>();
    private Boolean activo;

    public boolean tieneStock() {
        return stock != null && stock > 0;
    }

    public boolean esVelaAromatica() {
        return esAromatico != null && esAromatico && aroma != null && !aroma.isEmpty();
    }
}
