package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DetallesProductoUI {

    public static Target TXT_NOMBRE = Target.the("Detalle Producto")
            .locatedBy("//a[@class=\"chakra-link css-qpfo7l\"]");
    public static Target TXT_CANTIDAD = Target.the("cantidad Producto")
            .locatedBy("//input[@class=\"chakra-input css-1k2vvg6\"]");
}
