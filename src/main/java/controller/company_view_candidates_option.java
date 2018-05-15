package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import data.model.job_post_model;
import data.model.job_seeker_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@ManagedBean (name = "view_candidates")
@SessionScoped
public class company_view_candidates_option {
    public company_view_candidates_option() {
    }
    public ArrayList<job_seeker_model> getView_candidates(){
        ArrayList<job_seeker_model>records=new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","projectpaths","Oracle_1");
            Statement st=con.createStatement();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            String user=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");
            System.out.println(user);
            ResultSet rs=st.executeQuery("select * from job_seeker where job_id in(select job_id from job_post where username='"+user+"')");

            while(rs.next())
            {
                System.out.println("hi");
                job_seeker_model job_seeker_model=new job_seeker_model();
                job_seeker_model.setJob_id(rs.getInt("JOB_ID"));
job_seeker_model.setName(rs.getString("NAME"));
job_seeker_model.setFather_name(rs.getString("FATHER_NAME"));
job_seeker_model.setMother_name(rs.getString("MOTHER_NAME"));
job_seeker_model.setAge(rs.getInt("AGE"));
job_seeker_model.setPrevious_experience(rs.getString("PREVIOUS_EXPERIENCE"));
job_seeker_model.setQualification(rs.getString("QUALIFICATION"));

                records.add(job_seeker_model);

            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return records;
    }
    public String login_view_to_view_candidates_page()
    {
        return "view_candidates";
    }
}
