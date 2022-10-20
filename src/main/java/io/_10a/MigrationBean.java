package io._10a;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class MigrationBean {

    Logger logger = LoggerFactory.getLogger(MigrationBean.class);

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        long timestamp = System.nanoTime();
        logger.info("Flyway migration is started: {}", timestamp);
        Map<String, Object> properties = entityManager.getEntityManagerFactory().getProperties();
        Object datasourceObject = properties.get("hibernate.connection.datasource");
        if (!(datasourceObject instanceof DataSource)) {
            logger.error("Cannot get datasource, {}", datasourceObject);
            return;
        }
        DataSource dataSource = (DataSource) datasourceObject;

        Flyway flyway = new Flyway(
                new FluentConfiguration()
                        .table("_FLYWAY")
                        .outOfOrder(true)
                        .ignoreMissingMigrations(true)
                        .dataSource(dataSource)
                        .locations("classpath:db/migration")
//                        .outOfOrder(true)
//                        .ignoreMissingMigrations(true)
        );
        MigrationInfo migrationInfo = flyway.info().current();

        if (migrationInfo == null) {
            logger.info("There is no existing database at actual datasource.");
        } else {
            logger.info("Found the database with the version: {}", migrationInfo.getVersion() + " : "
                    + migrationInfo.getDescription());
        }
        flyway.migrate();
        logger.info("Successfully migrated to the database version: {}", flyway.info().current().getVersion());
        logger.info("Migration finished in: {} us", (System.nanoTime() - timestamp) / 1000);
    }
}