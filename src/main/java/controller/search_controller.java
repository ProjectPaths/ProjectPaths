package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.lang.*;
import data.model.search_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

@ManagedBean(name = "search")
@SessionScoped
public class search_controller {
        public  boolean showlogin;
    public  boolean showlogout;


        search_model search_model= new search_model();

    public boolean isShowlogin() {
        return showlogin;
    }

    public void setShowlogin(boolean showlogin) {
        this.showlogin = showlogin;
    }

    public boolean isShowlogout() {
        return showlogout;
    }

    public void setShowlogout(boolean showlogout) {
        this.showlogout = showlogout;
    }

    public data.model.search_model getSearch_model() {
        return search_model;
    }

    public void setSearch_model(data.model.search_model search_model) {
        this.search_model = search_model;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserr() {
        return userr;
    }

    public void setUserr(String userr) {
        this.userr = userr;
    }

    private String action;
        private String userr;
        public String search_initialize(){
            System.out.println("aaaa");
            Map<String,String> params =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
           action = params.get("action");
            System.out.println(action);
            search_model.setProduct_type(action);

            return "search_result_1";
        }

    public ArrayList<search_model> getSearchResult(){
        ArrayList<search_model>records=new ArrayList<>();
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            String user=(String) session.getAttribute("c_username");


            int state=0;
            if(user==null)state=1;
            if(state==0){setShowlogin(false);setShowlogout(true); }
            else {
                setShowlogin(true);setShowlogout(false);
            }
            System.out.println(state);

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcs","projectpaths","Oracle_1");
            Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("with a_b as  (select * from product p inner join company_signup c on p.username=c.username and p.product_type='"+action+"') select * from a_b");
                //ResultSet rs = st.executeQuery("Select * from product p ,company_singup c where p.username=c.username and p.product_type='"+action+"'");


            while(rs.next())
            {
                search_model search_model1 = new search_model();
                search_model1.setProduct_type(rs.getString("PRODUCT_TYPE"));

                search_model1.setGsm(rs.getString("GSM"));

                userr = rs.getString("USERNAME");

                search_model1.setUsername(userr);
                search_model1.setClient_username(user);
                search_model1.setPrice_range(rs.getString("PRICE_RANGE"));
                    String set = "Login to view details";
                if(state==1){
                    search_model1.setComapny_name(set);
                    search_model1.setOwner_name(set);
                    search_model1.setAddress(set);
                   // search_model1.setContact_no();
                    search_model1.setEmail(set);
                    //search_model1.setRepresentitive_name(set);
                   // search_model1.setSalary_assurance();
                   // search_model1.setInsurance(rs.getBoolean("INSUARNCE"));
                    //search_model1.setFire_safety(rs.getBoolean("FIRE_SAFETY"));

                }

              else {
                    search_model1.setComapny_name(rs.getString("NAME"));
                    search_model1.setOwner_name(rs.getString("OWNER_NAME"));
                    search_model1.setAddress(rs.getString("ADDRESS"));
                    search_model1.setContact_no(rs.getInt("CONTACT_NO"));
                    search_model1.setEmail(rs.getString("EMAIL"));
                    search_model1.setRepresentitive_name(rs.getString("REPRESENTITIVE_NAME"));
                    search_model1.setSalary_assurance(rs.getBoolean("SALARY_ASSUARNCE"));
                    search_model1.setInsurance(rs.getBoolean("INSUARNCE"));
                    search_model1.setFire_safety(rs.getBoolean("FIRE_SAFETY"));


                }
                    records.add(search_model1);

            }
            return records;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return records;
    }

    search_model  sm =new search_model();

    public data.model.search_model getSm() {
        return sm;
    }

    public void setSm(data.model.search_model sm) {
        this.sm = sm;
    }

    public boolean isbutton1(){
            System.out.println(showlogin);
           return showlogin;

    }

    public  String order(){
        String company_username = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("company");
        String client_username = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("client");
        String product_type = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("product_type");
        sm.setClient_username(client_username);
        sm.setUsername(company_username);
        sm.setProduct_type(product_type);


        return "order2ndpage";
    }
    public  String placeOrder(){
           String CompanyUsername = sm.getUsername();
           String ClientUsername = sm.getClient_username();
           String Product_type = sm.getProduct_type();
           int number_of_products = sm.getNumber_of_products();
           int price = sm.getPrice_per_product();
           System.out.println(CompanyUsername + price);
        return "search_home";
    }
    /*public boolean button2(){
        return showlogout;
    }*/

}
