package org.example.dao;


import org.example.config.DataConfig;
import org.example.models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
private SessionFactory sessionFactory = DataConfig.getInstance().getSessionFactory();

public void save (Customer customer) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        }
    }
}
