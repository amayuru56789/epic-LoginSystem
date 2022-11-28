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

//        Connection connection = dbConnection.getConnection();
//        PreparedStatement pstm = connection.prepareStatement("insert into Registration values(?,?,?,?,?,?,?,?)");
//        pstm.setObject(1, registration.getUserID());
//        pstm.setObject(2, registration.getUserName());
//        pstm.setObject(3, registration.getAddress());
//        pstm.setObject(4, registration.getEmail());
//        pstm.setObject(5, registration.getContact());
//        pstm.setObject(6, registration.getPassword());
//        pstm.setObject(7, registration.getCreateTime());
//        pstm.setObject(8, registration.getLastUpdateTime());
//        if(pstm.executeUpdate()>0){
            return true;
//        }else{
//            return false;
//        }
    }
    
    public ArrayList<Registration> report() throws SQLException, ClassNotFoundException{
        Connection connection = dbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Registration");
        ResultSet rst = pstm.executeQuery();
        //System.out.println(rst.getObject(1));
        ArrayList<Registration> load = new ArrayList<Registration>();
        while(rst.next()){
             Registration registration = new Registration(
                     rst.getString(1),
                     rst.getString(2),
                     rst.getString(3),
                     rst.getString(4),
                     rst.getString(5),
                     rst.getString(6),
                     rst.getString(7),
                     rst.getString(8)
             );
             load.add(registration);
        }
        
        return load;
    }
    
    public boolean updateUser(Registration registration) throws SQLException, ClassNotFoundException{
        Connection connection = dbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("update Registration set userName=?, address=?, email=?, contact=?, password=?, createTime=?, lastUpdateTime=? where userID=?");
        pstm.setObject(1, registration.getUserName());
        pstm.setObject(2, registration.getAddress());
        pstm.setObject(3, registration.getEmail());
        pstm.setObject(4, registration.getContact());
        pstm.setObject(5, registration.getPassword());
        pstm.setObject(6, registration.getCreateTime());
        pstm.setObject(7, registration.getLastUpdateTime());
        pstm.setObject(8, registration.getUserID());
        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deleteUser(String userID) throws ClassNotFoundException, SQLException{
        Connection connection = dbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("delete from Registration where userID=?");
        pstm.setObject(1, userID);
        
        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }
}
