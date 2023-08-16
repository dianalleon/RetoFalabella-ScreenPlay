package com.falabella.tasks;

import com.falabella.interactions.ClickRandom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarProductoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickRandom.click()
        );

    }
    public static SeleccionarProductoTask on(){
        return instrumented(SeleccionarProductoTask.class);
    }
}
