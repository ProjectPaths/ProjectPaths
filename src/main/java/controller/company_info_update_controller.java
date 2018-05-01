package controller;
import data.model.company_info_model;
import data.model.company_signin_model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@ManagedBean (name = "updatebean")
@SessionScoped

public class company_info_update_controller {
    company_info_model up=new company_info_model();
    company_signin_model signin=new company_signin_model();

    public company_info_update_controller() {
    }

    public company_info_model getUp() {
        return up;
    }

    public void setUp(company_info_model up) {
        this.up = up;
    }

    public company_signin_model getSignin() {
        return signin;
    }

    public void setSignin(company_signin_model signin) {
        this.signin = signin;
    }
    public String update()
    {

        try{
            String user=signin.getUsename();
            String pass=signin.getPassword();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","projectpaths","Oracle_1");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from company_signup where username='"+user+"' and password='"+pass+"'");
            while (rs.next())
            {
                String a=rs.getString("name");
                up.setComapny_name("a");
                System.out.println(a);
            }


            return "company_info_update";


        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
