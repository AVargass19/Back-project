package com.velas.ecommerce.Dto.Categoria;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
public class CategoriaDTO {
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String descripcion;

    private Long categoriaPadreId;

    private Boolean esPrincipal;
}
