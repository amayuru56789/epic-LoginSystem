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
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author Amayuru indeewara
 */
public class LoginDao {
    
    public boolean checkEqualityUser(String userName, String password) throws ClassNotFoundException, SQLException{
        List<Registration> list = new ArrayList();
        SessionFactory factory = HibernateListener.getFactory();

        Session openSession = factory.openSession();
        System.out.println("open");
        Query createQuery = openSession.createQuery("from Registration where userName=:userName and password=:password");
        System.out.println("hi");
        createQuery.setParameter("userName", userName);
        createQuery.setParameter("password", password);
        System.out.println("hello");
        Registration registration = (Registration) createQuery.uniqueResult();
        if(registration != null){
         
            return true;
        }
        return false;
    }
}
