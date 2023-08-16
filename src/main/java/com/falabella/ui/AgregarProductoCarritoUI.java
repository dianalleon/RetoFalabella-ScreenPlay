package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AgregarProductoCarritoUI {

    public static final Target TXT_CANTIDAD = Target.the("cantidad")
            .locatedBy("//*[@id='testId-stepper-input']");
    public static final Target BTN_AGREGAR_CARRITO = Target.the("btn carrito")
            .locatedBy("//*[@id='add-to-cart-button']");

    public static final Target BTN_IR_CARRITO = Target.the("btn ir carrito")
            .locatedBy("//*[@id='linkButton']");

}
