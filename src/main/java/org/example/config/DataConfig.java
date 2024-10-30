package org.example.config;

import org.example.models.Customer;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataConfig {
private static final DataConfig INSTANCE ;
private SessionFactory sessionFactory;

static {
    INSTANCE = new DataConfig();
}
private DataConfig() {
    sessionFactory = new Configuration()
            .addAnnotatedClass(Customer.class)
            .buildSessionFactory();

    Flyway.configure()
            .dataSource("jdbc:postgresql://localhost:5432/CustomerRegister","postgres","2413")
            .locations("db/migration")
            .load()
            .migrate();
}

public static DataConfig getInstance() {
    return INSTANCE;
}
public SessionFactory getSessionFactory() {
    return sessionFactory;
}

public void close()
{
    sessionFactory.close();
}


}
