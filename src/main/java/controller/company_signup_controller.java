
package controller;

import data.model.company_signup_model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(
        name = "test"
)
@SessionScoped
public class company_signup_controller {
    company_signup_model obj = new company_signup_model();


    public company_signup_controller() {
    }

    public company_signup_model getObj() {
        return this.obj;
    }

    public void setObj(company_signup_model obj) {
        this.obj = obj;
    }

    public String signup() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "projectpaths", "Oracle_1");
            Statement st = con.createStatement();
            String b = obj.getComapny_name();
            String c = obj.getOwner_name();
            String add = obj.getAddress();
            int contact = obj.getContact_no();
            String email = obj.getEmail();
            String representitive = obj.getRepresentitive_name();
            String username = obj.getUsername();
            String pass = this.obj.getPassword();
            boolean salary = obj.isSalary_assurance();
            boolean ins = obj.isInsurance();
            boolean fire = obj.isFire_safety();
            String a = "insert into company_signup(name,owner_name,address,contact_no,email,representitive_name,username,password,salary_assuarnce,insuarnce,fire_safety) values('" + b + "','" + c + "','" + add + "','" + contact + "','" + email + "','" + representitive + "','" + username + "','" + pass + "','" + salary + "','" + ins + "','" + fire + "')";
            st.executeUpdate(a);
            return "success";
        } catch (Exception var15) {
            return "false";
        }
    }

    public String to_next() {
        return "success";
    }
}
