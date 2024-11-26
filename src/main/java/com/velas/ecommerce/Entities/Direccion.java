package com.velas.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "direcciones")
@Getter
@Setter
public class Direccion extends EntidadBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "calle", nullable = false)
    private String calle;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "municipio", nullable = false)
    private String municipio;

    @Column(name = "departamento", nullable = false)
    private String departamento;

    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;
}
