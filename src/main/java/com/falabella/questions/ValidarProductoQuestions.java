package com.falabella.questions;

import com.falabella.models.Producto;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.falabella.ui.DetallesProductoUI.TXT_NOMBRE;

public class ValidarProductoQuestions implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade nombreCarrito = TXT_NOMBRE.resolveFor(actor);
        String aux =  ( (Producto) actor.recall("producto")).getNombre();

        return nombreCarrito.getText().equals(aux);
    }

    public static Question<Boolean> from(){
        return new ValidarCantidadCarritoQuestions();
    }
}
