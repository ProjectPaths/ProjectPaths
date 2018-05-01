package data.model;

public class company_signin_model {
    private String usename;
    private String password;
    private String status;

    public company_signin_model() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getUsename() {
        System.out.println(usename);return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
