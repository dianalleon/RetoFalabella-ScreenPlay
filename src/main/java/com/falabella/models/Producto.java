package com.falabella.models;

import lombok.*;

//@EqualsAndHashCode( exclude = {"cantidad"}) //no tiene en cuenta ese dato
//@EqualsAndHashCode
//@ToString
@Data
public class Producto {

    private String nombre;
    private String cantidad;
}
