/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.epic.loginsystem.listener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.epic.loginsystem.DAO.RegistrationDao;
import lk.epic.loginsystem.Entity.Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Amayuru indeewara
 */
public class Test {
    public static void main(String args[]) throws ClassNotFoundException{
//        Registration registration = new Registration(
//                  "userIDhd",
//                  "userName",
//                  "address",
//                  "email",
//                  "contact",
//                 "password",
//                  "formatDateTime",
//                  "s"
//          );
        //System.out.println(registration.getContact());
//        System.out.println("2");
//        List<Registration> list = new ArrayList();
//        
//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        System.out.println("3");
//        Session openSession = sessionFactory.openSession();
//         org.hibernate.Transaction t = openSession.beginTransaction();
//
//        openSession.save(registration);
//        t.commit();
//         openSession.close();
//        System.out.println("4");
//        SessionFactory factory = HibernateListener.getFactory();
//
//        Session openSession = factory.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//            openSession.save(registration);
//            beginTransaction.commit();
//            openSession.close();
//        RegistrationDao dao = new RegistrationDao();
//        try {
//            dao.registerUser(registration);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
SessionFactory factory = HibernateListener.getFactory();

        Session openSession = factory.openSession();
        System.out.println("open");
        Query createQuery = openSession.createQuery("from Registration where userName=:userName and password=:password");
        System.out.println("hi");
        createQuery.setParameter("userName", "kamal");
        createQuery.setParameter("password", "asasa");
        System.out.println("hello");
        Registration registration = (Registration) createQuery.uniqueResult();
        if(registration != null){
         
            System.out.println("Harii");
        }
        
    }
}
