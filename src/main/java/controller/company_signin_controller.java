package controller;
import data.model.company_signin_model;
import data.model.company_info_model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.sql.*;
@ManagedBean (name = "signin")
@SessionScoped
public class company_signin_controller {
    company_signin_model signinModel = new company_signin_model();


    public company_signin_controller() {
    }

    public company_signin_model getSigninModel() {
        return signinModel;
    }

    public void setSigninModel(company_signin_model signinModel) {
        this.signinModel = signinModel;
    }
 int p=0;

    public String company_signin()
   {
       try{
           String username=signinModel.getUsename();
           String password=signinModel.getPassword();

           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","projectpaths","Oracle_1");
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select username,password from company_signup");
           while(rs.next())
           {
              String user=rs.getString(1);
              String pass=rs.getString(2);
              if(username.equals(user) && password.equals(pass))
              {
                  p=1;
                  FacesContext facesContext = FacesContext.getCurrentInstance();
                  HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                  session.setAttribute("username", user);
                  session.setAttribute("password",pass);
                  return "company_login_done";
              }

           }
           if(p!=1)
           {
               signinModel.setStatus("username or password is invalid");
               return "company_signin_page";

           }


       }
       catch (Exception e){
           System.out.println(e);
       }
       return null;
   }



    public String goback()
    {
        signinModel.setStatus("");
        signinModel.setUsename("");
        signinModel.setPassword("");
        return "company_signin_page";
    }
}
