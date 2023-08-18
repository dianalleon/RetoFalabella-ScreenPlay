package com.falabella.tasks;

import com.falabella.models.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.falabella.ui.AgregarProductoCarritoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProductoCarritoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("nombreProducto", LB_NOMBRE.toString());

        Producto productoValidar = new Producto();
        productoValidar.setNombre(LB_NOMBRE.toString());
        productoValidar.setCantidad("3");

        actor.remember("producto", productoValidar);
        actor.attemptsTo(
                Click.on(BTN_AGREGAR_CARRITO),
                Enter.theValue("3").into(TXT_CANTIDAD).thenHit(Keys.ENTER),
                Click.on(BTN_IR_CARRITO)
        );
    }

    public static AgregarProductoCarritoTask on(){
        return instrumented(AgregarProductoCarritoTask.class);
    }
}
