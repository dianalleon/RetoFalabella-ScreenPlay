package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class BuscarProductoUI {

    public static final Target BTN_COOKIES = Target.the("btnCookis")
            .locatedBy("//*[@id='testId-accept-cookies-btn']");
    public static final Target TXT_BUSCADOR = Target.the("buscador")
            .locatedBy("//*[@id=\"testId-SearchBar-Input\"]");

}
