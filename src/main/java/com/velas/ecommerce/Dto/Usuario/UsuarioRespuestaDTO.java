package com.velas.ecommerce.Dto.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UsuarioRespuestaDTO {
    private Long id;
    private String nombreUsuario;
    private String email;
    private String nombre;
    private String apellido;
    private String rol;
    private boolean activo;

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public boolean esAdmin() {
        return "ADMIN".equals(rol);
    }
}
