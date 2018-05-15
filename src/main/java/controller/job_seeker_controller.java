package controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import data.model.job_post_model;
import data.model.job_seeker_model;
@ManagedBean(name = "bean")
@SessionScoped

public class job_seeker_controller {
    job_seeker_model obj=new job_seeker_model();

    public job_seeker_model getObj() {
        return obj;
    }

    public void setObj(job_seeker_model obj) {
        this.obj = obj;
    }

    public ArrayList<job_post_model> getStudent(){
        ArrayList<job_post_model>records=new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","projectpaths","Oracle_1");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select post,salary,vacancy,qualifications,name from job_post j ,company_signup c where j.username=c.username");
            while(rs.next())
            {
                job_post_model stud=new job_post_model();
                job_seeker_model seeker =new job_seeker_model();
                stud.setSalary(rs.getInt("salary"));
                stud.setPost(rs.getString("post"));
                stud.setVacancy(rs.getInt("vacancy"));
                stud.setQualifications(rs.getString("qualifications"));
                stud.setName(rs.getString("name"));

                records.add(stud);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return records;
    }
    public String Next_job_seeker()
    {
        return "job_seeker";
    }
    public String apply() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "projectpaths", "Oracle_1");
            Statement st = con.createStatement();
            String name= obj.getName();
            String father_name = obj.getFather_name();
            String mother_name = obj.getMother_name();
            int age = obj.getAge();
            String previous_exp=obj.getPrevious_experience();
            String Qualifications=obj.getQualification();

            String a = "insert into job_seeker(name,father_name,mother_name,age, PREVIOUS_EXPERIENCE,QUALIFICATION) values('" + name + "','" + father_name + "','" + mother_name + "','" + age + "','" + previous_exp + "','" + Qualifications + "')";
            st.executeUpdate(a);



        } catch (Exception var15) {
            return "false";
        }
        return "success";
    }
}

