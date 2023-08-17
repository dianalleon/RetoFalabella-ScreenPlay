package com.falabella.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.falabella.ui.DetallesProductoUI.TXT_CANTIDAD;

public class ValidarCantidadCarritoQuestions implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade cantidadCarrito = TXT_CANTIDAD.resolveFor(actor);
        return cantidadCarrito.getValue().equals("3");
    }

    public static Question<Boolean> from(){
        return new ValidarCantidadCarritoQuestions();
    }
}
