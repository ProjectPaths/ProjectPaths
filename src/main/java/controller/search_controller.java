package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import data.model.search_model;

import java.util.Map;

@ManagedBean(name = "search")
@SessionScoped
public class search_controller {

        search_model search_model= new search_model();

        public String search_initialize(){
            System.out.println("aaaa");
            Map<String,String> params =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String action = params.get("action");
            System.out.println(action);
            return "das";
        }
}
