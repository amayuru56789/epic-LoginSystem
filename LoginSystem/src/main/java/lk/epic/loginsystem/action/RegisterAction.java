/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.epic.loginsystem.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.epic.loginsystem.DAO.RegistrationDao;
import lk.epic.loginsystem.Entity.Registration;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Amayuru indeewara
 */
public class RegisterAction extends ActionSupport {
    
    Map<String, Object> result = new HashMap<String, Object>();

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
    RegistrationDao registrationDao = new RegistrationDao();
    
    @Override
    public String execute() throws ClassNotFoundException, SQLException {
        
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        
        System.out.println("Awoooooooooooooooo");
        return SUCCESS;
        
//        boolean register = false;
//        LocalDateTime time = LocalDateTime.now();  
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
//        String formatDateTime = time.format(format);   
//        String s="sa";
//          Registration registration = new Registration(
//                  request.getParameter("userID"),
//                  request.getParameter("userName"),
//                  request.getParameter("address"),
//                  request.getParameter("email"),
//                  request.getParameter("contact"),
//                  request.getParameter("password"),
//                  formatDateTime,
//                  s
//          );
//          register = registrationDao.registerUser(registration);
//          
//          if(register){                      
//              result.put("status", "200");
//              return SUCCESS;
//          }else{
//              result.put("status", "400");
//              return SUCCESS;
//          }
    }
    
    public String getAllUser() throws SQLException, ClassNotFoundException{
//        Map<String, List> data = new HashMap<String, List>();
        ArrayList<Registration> details = registrationDao.report();
        
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        
        if(details == null){         
            return SUCCESS;
        }else{
            //System.out.println("Hello ok");
            result.put("data", details);         
            return SUCCESS;
        }
    }
    
    public String updateUser() throws SQLException, ClassNotFoundException {
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        
        LocalDateTime time = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String lastDateTime = time.format(format);
        String name = request.getParameter("userID");
        System.out.println(name);
        //Registration searchUser = registrationDao.getAllRegistrationDetails(request.getParameter("userID"));
        //String createTime = searchUser.getCreateTime();
        Registration registration = new Registration(
                  request.getParameter("userID"),
                  request.getParameter("userName"),
                  request.getParameter("address"),
                  request.getParameter("email"),
                  request.getParameter("contact"),
                  request.getParameter("password"),
                  " ",
                  lastDateTime
          );
        System.out.println(registration);
        boolean updateUser = registrationDao.updateUser(registration);
        if(updateUser){
            result.put("status", "200");
            return SUCCESS;
        }else{
            result.put("status", "400");
            return SUCCESS;
        }
    }
    
    public String deleteUser() throws ClassNotFoundException, SQLException{
        
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        
        String userID = request.getParameter("userID");
        if(registrationDao.deleteUser(userID)){
                result.put("status", "200");
                return SUCCESS;
            }else{
                result.put("status", "400");
                return SUCCESS;
            }
    }
}
