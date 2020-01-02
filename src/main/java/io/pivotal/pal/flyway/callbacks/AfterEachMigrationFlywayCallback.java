package io.pivotal.pal.flyway.callbacks;

import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class AfterEachMigrationFlywayCallback implements Callback {

    private static final Logger log = LoggerFactory.getLogger(AfterEachMigrationFlywayCallback.class);

    public void afterEachMigrate(Connection connection, MigrationInfo info) {
        log.info("> afterEachMigrate");
    }

    @Override
    public boolean supports(Event event, Context context) {
        return false;
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return false;
    }

    @Override
    public void handle(Event event, Context context) {
        if (event.getId().equalsIgnoreCase(Event.AFTER_EACH_MIGRATE.toString())) {
            log.info(">>>>>>>>>Event Id: " + event.getId().toString());
        }
    }
}
