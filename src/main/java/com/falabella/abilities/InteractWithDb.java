package com.falabella.abilities;

import com.falabella.Database.DatabaseConnectionInfo;
import com.falabella.Database.persistence.manager.JpaEntityManagerFactory;
import jakarta.persistence.EntityManager;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

public class InteractWithDb implements Ability {

    private EntityManager entityManager;

    public EntityManager getManager() {
        return entityManager;
    }

    public InteractWithDb(DatabaseConnectionInfo databaseConnectionInfo) {
        this.entityManager =
                new JpaEntityManagerFactory(databaseConnectionInfo).getEntityManager();
    }

    public static InteractWithDb using(DatabaseConnectionInfo databaseConnectionInfo) {
        return new InteractWithDb(databaseConnectionInfo);
    }

    public static InteractWithDb as(Actor actor) {
        return actor.abilityTo(InteractWithDb.class);
    }
}
