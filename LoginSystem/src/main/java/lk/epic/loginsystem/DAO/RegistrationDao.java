/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.epic.loginsystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.epic.loginsystem.Entity.Registration;
import lk.epic.loginsystem.db.DbConnection;
import lk.epic.loginsystem.listener.HibernateListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Amayuru indeewara
 */
public class RegistrationDao {
    
    DbConnection dbConnection = new DbConnection();
    
    public boolean registerUser(Registration registration) throws ClassNotFoundException, SQLException{
        SessionFactory factory = HibernateListener.getFactory();

        Session openSession = factory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.save(registration);
        beginTransaction.commit();
        openSession.close();
            
        
        return true;
       
    }
    
    public ArrayList<Registration> report() throws SQLException, ClassNotFoundException{
        List<Registration> list = new ArrayList();
        SessionFactory factory = HibernateListener.getFactory();

        Session openSession = factory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        list = openSession.createQuery("from Registration").list();
        
      
        return (ArrayList<Registration>) list;
    }
    
    public boolean updateUser(Registration registration) throws SQLException, ClassNotFoundException{
        SessionFactory factory = HibernateListener.getFactory();

        Session openSession = factory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.update(registration);
        beginTransaction.commit();
        openSession.close();
            
        
        return true;
        
    }
    
    public boolean deleteUser(String userID) throws ClassNotFoundException, SQLException{
        SessionFactory factory = HibernateListener.getFactory();

        Session openSession = factory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Registration get = openSession.get(Registration.class, userID);
        openSession.delete(get);
        beginTransaction.commit();
        openSession.close();
            
        
        return true;
        
    }
}
