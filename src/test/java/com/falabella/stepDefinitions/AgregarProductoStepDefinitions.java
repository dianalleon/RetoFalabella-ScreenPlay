package com.falabella.stepDefinitions;

import com.falabella.Database.DatabaseConnectionInfo;
import com.falabella.Database.DatabaseType;
import com.falabella.abilities.InteractWithDb;
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
import io.cucumber.messages.types.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AgregarProductoStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Test
    public void dbConnection() {
        DatabaseConnectionInfo connectionInfo = DatabaseConnectionInfo
                .builder()
                .username("l7bk4f3mdm0tx651r641")
                .databaseType(DatabaseType.MYSQL)
                .url("jdbc:mysql://aws.connect.psdb.cloud/fallabela?sslMode=VERIFY_IDENTITY")
                .password("pscale_pw_TNWObxuWBOdE3Ks0TisuNd9DvEOFbdEbGdRuBplbJXL")
                .entityNames(Stream.of(
                                Producto.class)
                        .map(Class::getName)
                        .collect(Collectors.toList()))
                .build();

        Actor actor = theActorCalled("user");
        actor.can(InteractWithDb.using(connectionInfo));

        EntityManager entityManager = InteractWithDb.as(actor).getManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Producto> criteriaQuery = criteriaBuilder
                .createQuery(Producto.class);

        Root<Producto> userRoot = criteriaQuery.from(Producto.class);

        Producto queryResult = entityManager
                .createQuery(criteriaQuery
                        .select(userRoot))
                .getSingleResult();

        System.out.println(queryResult);
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
