package data.model;

public class company_info_model {
    private String comapny_name;
    private String owner_name;
    private String address;
    private  int contact_no;
    private  String email;
    private String representitive_name;
    private  String username;
    private String password;
    private boolean salary_assurance;
    private boolean insurance;
    private boolean fire_safety;

    public company_info_model() {
    }

    public String getComapny_name() {
        return comapny_name;
    }

    public void setComapny_name(String comapny_name) {
        this.comapny_name = comapny_name;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepresentitive_name() {
        return representitive_name;
    }

    public void setRepresentitive_name(String representitive_name) {
        this.representitive_name = representitive_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSalary_assurance() {
        return salary_assurance;
    }

    public void setSalary_assurance(boolean salary_assurance) {
        this.salary_assurance = salary_assurance;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public boolean isFire_safety() {
        return fire_safety;
    }

    public void setFire_safety(boolean fire_safety) {
        this.fire_safety = fire_safety;
    }
}
