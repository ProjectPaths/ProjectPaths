package controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import data.model.company_signup_model;
@ManagedBean(name="test")
@SessionScoped

public class company_signup_controller {
    public company_signup_controller() {
    }

   public ArrayList<company_signup_model>check() {
        ArrayList<company_signup_model>comm = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcs","projectpaths","Oracle_1");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from test");
            while(rs.next())
            {
                company_signup_model com=new company_signup_model();
                com.setId(rs.getInt(1));
                com.setName(rs.getString(2));
                comm.add(com);

            }



        }
        catch (Exception e){
            System.out.println(e);
        }
        return comm;

    }
   public String to_next(){
        return "success";

    }

}
