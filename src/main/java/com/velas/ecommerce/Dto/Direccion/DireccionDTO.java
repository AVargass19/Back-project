package com.velas.ecommerce.Dto.Direccion;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
public class DireccionDTO {
    private Long id;

    @NotBlank(message = "La calle es obligatoria")
    private String calle;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotBlank(message = "El municipio es obligatorio")
    private String municipio;

    @NotBlank(message = "El departamento es obligatorio")
    private String departamento;

    @NotBlank(message = "El código postal es obligatorio")
    @Pattern(regexp = "^[0-9]{4,6}$", message = "El código postal debe tener entre 4 y 6 dígitos")
    private String codigoPostal;

    private Long usuarioId;
}
