package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.event.CaretListener;

import data.model.client_signin_signup_logout_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@ManagedBean(name = "client")
@SessionScoped

public class client_signin_signup_logout_controller {

    public client_signin_signup_logout_controller() {
    }
    client_signin_signup_logout_model client_model = new client_signin_signup_logout_model();

    public client_signin_signup_logout_model getClient_model() {
        return client_model;
    }

    public void setClient_model(client_signin_signup_logout_model client_model) {
        this.client_model = client_model;
    }

    public  String Signup(){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcs", "projectpaths", "Oracle_1");
            Statement st = con.createStatement();
            String name = client_model.getClient_name();

            String add = client_model.getClient_address();
            String contact = client_model.getClient_contact_no();
            String email = client_model.getEmail();
            String country= client_model.getClient_country();
            String username = client_model.getClient_username();
            String pass = client_model.getPassword();

            String a = "insert into client(username,password,client_name,contact_no,email,address,country) values('" + username + "','" + pass + "','" + name + "','" + contact + "','" + email + "','" + add + "','" + country + "')";
            st.executeUpdate(a);
            client_model.setStatus("Registration Successful");
            return "client_signin_signup";
        } catch (Exception var15) {
            client_model.setStatus("Failed");
            return "client_signin_signup";
        }



    }

    public String signin(){
int p=0;
        try{
            String username=client_model.getClient_username();
            String password=client_model.getPassword();
            System.out.println(username);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcs","projectpaths","Oracle_1");
            Statement st=con.createStatement();
            System.out.println("asdasda");
            ResultSet rs=st.executeQuery("select username,password from client");
            while(rs.next())
            {

                String user=rs.getString("username");
                String pass=rs.getString("password");
                System.out.println(user);
                System.out.println(pass);
                if(username.equals(user) && password.equals(pass))
                {
                    p=1;
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                    session.setAttribute("c_username", user);
                    session.setAttribute("c_password",pass);
                    client_model.setStatus("Login Successful.....Hello");

                    return "client_login_done";
                }

            }
            if(p!=1)
            {
                client_model.setStatus("username or password is invalid");
                return "client_signin_signup";

            }


        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        client_model.setStatus("");
        client_model.setClient_username("");
        client_model.setPassword("");
        return "client_signin_signup";
    }

    public void loginsearch(){


    }
}
