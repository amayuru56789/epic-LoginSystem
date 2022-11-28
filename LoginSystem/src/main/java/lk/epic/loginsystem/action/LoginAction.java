/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.epic.loginsystem.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.epic.loginsystem.DAO.LoginDao;
import lk.epic.loginsystem.Entity.Registration;
import org.apache.struts2.ServletActionContext;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Amayuru indeewara
 */
public class LoginAction extends ActionSupport {
    Map<String, String> result = new HashMap<String, String>();

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }
    
    LoginDao loginDao = new LoginDao();
    
    @Override
    public String execute() throws ClassNotFoundException, SQLException{
        
//        HttpServletResponse response = ServletActionContext.getResponse();
//        HttpServletRequest request = ServletActionContext.getRequest();
//        
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        boolean bool = loginDao.checkEqualityUser(userName, password);
//        if(bool){
//            result.put("status", "200");
//            return SUCCESS;
//        }else{
//            result.put("status", "400");
//            return SUCCESS;
//        }
System.out.println("2");
        List<Registration> list = new ArrayList();
        
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println("3");
        Session openSession = sessionFactory.openSession();
        System.out.println("4");
        list = openSession.createQuery("from Registration").list();
        System.out.println("5");
        return null;
    }
}
