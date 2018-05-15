package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "homepage_to_company")
@SessionScoped
public class hompage_to_company_link {
    public String homepage_to_company()
    {
        return  "company_first_page";
    }
}
