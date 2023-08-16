package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SeleccionarProductoUI {

    public static Target LIST_PRODUCTOS = Target.the("lista productos")
            .locatedBy("//*[@id=\"testId-searchResults-products\"]/div/div/div[2]");
}
