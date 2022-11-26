package org.example;

import org.example.entities.joined.Linux;
import org.example.entities.joined.Windows;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class JoinedRunner {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Windows windows = new Windows();
        windows.setName("windows");
        windows.setCost(150);

        Linux linux = new Linux();
        linux.setName("linux");
        linux.setKernelVersion("20.04.5 LTS");

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        session.persist(windows);
//        session.persist(linux);

        Query<Windows> queryForSelectWindows = session.createQuery("select p from Windows p where id = 1", Windows.class);
        List<Windows> resultListOfWindows = queryForSelectWindows.getResultList();
        System.out.println(resultListOfWindows);

        Query<Linux> queryForSelectLinux = session.createQuery("select p from Linux p where id = 2", Linux.class);
        List<Linux> resultListOfLinux = queryForSelectLinux.getResultList();
        System.out.println(resultListOfLinux);

        transaction.commit();
        session.close();
    }
}
