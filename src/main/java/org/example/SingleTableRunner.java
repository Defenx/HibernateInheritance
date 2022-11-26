package org.example;

import org.example.entities.singleTable.MegaPerson;
import org.example.entities.singleTable.Person;
import org.example.enums.MegaSkill;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SingleTableRunner {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Person person = new Person();
        person.setName("Valera");

        MegaPerson megaPerson = new MegaPerson();
        megaPerson.setMegaSkill(MegaSkill.FIREBALL);
        megaPerson.setName("Alex");

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        session.persist(person);
//        session.persist(megaPerson);

        Query<Person> query = session.createQuery("select p from Person p where id = 1", Person.class);
        List<Person> resultList = query.getResultList();
        System.out.println(resultList);

        Query<MegaPerson> queryForSelectMegaPerson = session.createQuery("select p from MegaPerson p where id = 2", MegaPerson.class);
        List<MegaPerson> resultListOfMegaPerson = queryForSelectMegaPerson.getResultList();
        System.out.println(resultListOfMegaPerson);

        transaction.commit();
        session.close();
    }
}
