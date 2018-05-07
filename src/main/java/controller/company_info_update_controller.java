package controller;
import data.model.company_info_model;
import data.model.company_signin_model;
import data.model.job_post_model;
import data.model.product_model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@ManagedBean (name = "updatebean")
@SessionScoped

public class company_info_update_controller extends company_signin_model{
    company_info_model up=new company_info_model();
    company_signin_model signin=new company_signin_model();
    job_post_model job=new job_post_model();
    data.model.product_model product_model=new product_model();

    public job_post_model getJob() {
        return job;
    }

    public void setJob(job_post_model job) {
        this.job = job;
    }

    public data.model.product_model getProduct_model() {
        return product_model;
    }

    public void setProduct_model(data.model.product_model product_model) {
        this.product_model = product_model;
    }

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
        // String user=signin.getUsename();
       // String pass=signin.getPassword();
        //System.out.println(user);
        //System.out.println(pass);
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
           String user=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcs","projectpaths","Oracle_1");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from company_signup where username='"+user+"' and password='"+pass+"'");
            while (rs.next())
            {

                up.setComapny_name(rs.getString("name"));
                up.setOwner_name(rs.getString("owner_name"));
                up.setAddress(rs.getString("address"));
                up.setContact_no(rs.getInt("contact_no"));
                up.setEmail(rs.getString("email"));
                up.setRepresentitive_name(rs.getString("REPRESENTITIVE_NAME"));
                up.setUsername(rs.getString("username"));
                up.setPassword(rs.getString("password"));
                up.setSalary_assurance(rs.getBoolean("SALARY_ASSUARNCE"));
                up.setFire_safety(rs.getBoolean("fire_safety"));
                up.setInsurance(rs.getBoolean("INSUARNCE"));


            }


            return "company_info_update";


        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void update_info()
    {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            String user=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcs", "projectpaths", "Oracle_1");
            Statement st = con.createStatement();
            String b = up.getComapny_name();
            String c = up.getOwner_name();
            String add = up.getAddress();
            int contact = up.getContact_no();
            String email = up.getEmail();
            String representitive = up.getRepresentitive_name();
           // String username = up.getUsername();
          //  String pass = up.getPassword();
            boolean salary = up.isSalary_assurance();
            boolean ins = up.isInsurance();
            boolean fire = up.isFire_safety();
            String a="UPDATE  company_signup set name='"+b+"',owner_name='"+c+"',address='"+add+"',contact_no='"+contact+"'," +
                    "email='"+email+"',representitive_name='"+representitive+"',salary_assuarnce='"+salary+"'," +
                    "insuarnce='"+ins+"',fire_safety='"+fire+"' where username='"+user+"' and password='"+pass+"'" +
                    "";
            st.executeUpdate(a);
            System.err.println(b);
        } catch (Exception var15) {
            System.out.println("e");
        }
    }
    public String product()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "projectpaths", "Oracle_1");
            Statement st = con.createStatement();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            String user=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");
            String product =product_model.getProduct_type();
            String gsm=product_model.getGsm();
            String price=product_model.getPrice();
            String a="insert into product(product_type,gsm,price_range,username) " +
                    "values('"+product+"','"+gsm+"','"+price+"',"+user+"') " ;
            st.executeUpdate(a);
            String status="job is posted";



        }  catch (Exception e){
            System.out.println(e);
        }
        return null;

    }
    public String job_post()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "projectpaths", "Oracle_1");
            Statement st = con.createStatement();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            String user=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");
            String post=job.getPost();
            int salary=job.getSalary();
            int vacancy=job.getVacancy();
            String qual=job.getQualifications();
            String a="insert into job_post(post,salary,vacancy,qualifications,username) " +
                    "values('"+post+"','"+salary+"','"+vacancy+"','"+qual+"','"+user+"') " ;
            st.executeUpdate(a);
           // String status="job is posted";



        }  catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public String job_next()
    {
        return "job_post";
    }
}
