package data.model;

public class client_signin_signup_logout_model {
    private String client_username;
    private String password;
    private String client_name;
    private String client_address;
    private String client_country;
    private String client_contact_no;
    private String status;
    private String email;

    public client_signin_signup_logout_model() {
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClient_username() {
        return client_username;
    }

    public void setClient_username(String client_username) {
        this.client_username = client_username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getClient_country() {
        return client_country;
    }

    public void setClient_country(String client_country) {
        this.client_country = client_country;
    }

    public String getClient_contact_no() {
        return client_contact_no;
    }

    public void setClient_contact_no(String client_contact_no) {
        this.client_contact_no = client_contact_no;
    }
}
