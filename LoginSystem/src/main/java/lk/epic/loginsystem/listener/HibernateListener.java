/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.epic.loginsystem.listener;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author Amayuru indeewara
 */
public class HibernateListener {
    
    private static SessionFactory factory = getSessionFactory();

    public static synchronized SessionFactory getSessionFactory()
    {
            try {                        

                                Configuration cfg = new Configuration();
                                cfg.configure("hibernate.cfg.xml"); 

                                SessionFactory sessionFactory = cfg.buildSessionFactory();
                                System.out.println(" ----------   Factory Object Created  ------------");
                                return sessionFactory;

                  }             catch (HibernateException ex) {
                                 System.err.println("Initial SessionFactory creation failed." + ex);
                                 throw new ExceptionInInitializerError(ex);
                  }
      }

    public static SessionFactory getFactory() {
        return factory;
    }
    
//    private static HibernateListener hibernateListener;
//  private SessionFactory sessionFactory;
//
//   private HibernateListener() {
//        StandardServiceRegistry build = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//      
//        Metadata meta = new MetadataSources(build).getMetadataBuilder().build();
//
//       
//        sessionFactory = meta.getSessionFactoryBuilder().build();
//
//    }
//
//    public static HibernateListener getInstance() {
//        return hibernateListener == null ? hibernateListener = new HibernateListener() : hibernateListener;
//    }
//
//    public Session getSession() {
//
//        return sessionFactory.openSession();
//    }
}
