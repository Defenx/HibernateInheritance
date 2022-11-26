package org.example;

import org.example.entities.tablePerClass.Animal;
import org.example.entities.tablePerClass.Elephant;
import org.example.entities.tablePerClass.Whale;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TablePerClassRunner {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Elephant elephant = new Elephant();
        elephant.setName("Roberto");
        elephant.setWalkingSpeed(5);

        Whale whale = new Whale();
        whale.setName("Bob");
        whale.setSwimmingSpeed(30);

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(elephant);
        session.persist(whale);

        Query<Elephant> queryForSelectElephant = session.createQuery("select p from Elephant p where id = 1", Elephant.class);
        List<Elephant> resultListOfElephant = queryForSelectElephant.getResultList();
        System.out.println(resultListOfElephant);

        Query<Whale> queryForSelectWhale = session.createQuery("select p from Whale p where id = 2", Whale.class);
        List<Whale> resultListOfWhale = queryForSelectWhale.getResultList();
        System.out.println(resultListOfWhale);

        transaction.commit();
        session.close();
    }
}
