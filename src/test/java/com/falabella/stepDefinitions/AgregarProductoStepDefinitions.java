package com.falabella.stepDefinitions;

import com.falabella.models.Producto;
import com.falabella.questions.ValidarCantidadCarritoQuestions;
import com.falabella.questions.ValidarProductoQuestions;
import com.falabella.tasks.AgregarProductoCarritoTask;
import com.falabella.tasks.BuscarProductoTask;
import com.falabella.tasks.SeleccionarProductoTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.junit.Test;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AgregarProductoStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario abre la aplicacion y busca un producto en la barra de busqueda")
    public void queElUsuarioAbreLaAplicacionYBuscaUnProductoEnLaBarraDeBusqueda() {
        theActorCalled("User").wasAbleTo(
                Open.url("https://www.falabella.com.co/falabella-co"),
                BuscarProductoTask.on()
        );


    }

    @Cuando("el usuario selecciona un producto aleatoriamente y da click en agregar al carrito")
    public void elUsuarioSeleccionaUnProductoAleatoriamenteYDaClickEnAgregarAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarProductoTask.on()
        );
    }

    @Cuando("añade tres unidades y da click en ir al carrito")
    public void añadeTresUnidadesYDaClickEnIrAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AgregarProductoCarritoTask.on()
        );
    }
    @Entonces("el usuario visualiza su producto en el carrito")
    public void elUsuarioVisualizaSuProductoEnElCarrito() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarProductoQuestions.from(), Matchers.equalTo(true)
                ),
                seeThat(
                        ValidarCantidadCarritoQuestions.from(), Matchers.equalTo(true)
                )
        );
    }
}
