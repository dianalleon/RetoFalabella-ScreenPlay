package com.falabella.interactions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.Random;

import static com.falabella.ui.SeleccionarProductoUI.LIST_PRODUCTOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickRandom implements Interaction {

    private static Integer numero;
    @Override
    public <T extends Actor> void performAs(T actor) {
        ListOfWebElementFacades listProducts = LIST_PRODUCTOS.resolveAllFor(actor);
        int indexRandom = (new Random()).nextInt(listProducts.size());
        numero = (new Random()).nextInt(20);
        listProducts.get(indexRandom).click();
    }

    public static Integer getNumero() {
        return numero;
    }

    public static Performable click(){
        return instrumented(ClickRandom.class);
    }
}
