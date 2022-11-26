package org.example;

import org.example.entities.mappedSuperclass.BaseEntity;
import org.example.entities.mappedSuperclass.Human;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class MappedSuperclassRunner {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Human human = new Human();
        human.setAge(50);
        human.setName("Valera");

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        session.persist(human);

//        Query<Human> query = session.createQuery("select h from Human h where id = 1", Human.class);
//        List<Human> resultList = query.getResultList();
//        System.out.println(resultList);

        Query<BaseEntity> query = session.createQuery("FROM org.example.entities.mappedSuperclass.BaseEntity", BaseEntity.class);
        var resultList = query.getResultList();
        System.out.println(resultList);


        transaction.commit();
        session.close();
    }
}