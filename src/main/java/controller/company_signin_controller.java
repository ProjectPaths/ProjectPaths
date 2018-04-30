package controller;
import data.model.company_signin_model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
@ManagedBean (name = "signin")
@SessionScoped
public class company_signin_controller {
    company_signin_model signin = new company_signin_model();

    public company_signin_controller() {
    }

    public company_signin_model getSignin() {
        return signin;
    }

    public void setSignin(company_signin_model signin) {
        this.signin = signin;
    }

   public void company_signin()
   {
       try{
           String username=signin.getUsename();
           String password=signin.getPassword();
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","projectpaths","Oracle_1");
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select* from company_signup");
           while(rs.next())
           {
              String user=rs.getString("username");
              String pass=rs.getString("password");
              if(user.equals(username) && pass.equals(password))
              {
                  login();
              }
              else unsucessful();
           }

       }
       catch (Exception e){
           System.out.println(e);
       }
   }
    public String login()
    {
        return "company_login_done";
    }
    public String unsucessful()
    {
        return "company_login_failed";
    }
    public String goback()
    {
        return "back";
    }
}
