/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.epic.loginsystem.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.epic.loginsystem.Entity.Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Amayuru indeewara
 */
public class FactoryConfiguration {
    
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    public FactoryConfiguration() {
        
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/hibernate.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FactoryConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FactoryConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
        org.hibernate.cfg.Configuration configuration = new Configuration().addAnnotatedClass(Registration.class);
        configuration.setProperties(properties);
        sessionFactory = configuration.buildSessionFactory();
    }
    
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null) ? factoryConfiguration = new FactoryConfiguration()
                :factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
