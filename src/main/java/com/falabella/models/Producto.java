package com.falabella.models;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "producto")
@Data
public class Producto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_producto")
    private String nombre;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "busqueda")
    private String busqueda;
}
