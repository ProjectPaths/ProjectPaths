package data.model;

public class search_model {

    private String comapny_name;
    private String owner_name;
    private String address;
    private  int contact_no;
    private  String email;
    private String representitive_name;
    private boolean salary_assurance;
    private boolean insurance;
    private boolean fire_safety;
    private String product_type;
    private String gsm;
    private String price_range;
    private String username;
    private String client_username;
    private int number_of_products;
    private  int price_per_product;

    public int getNumber_of_products() {
        return number_of_products;
    }

    public void setNumber_of_products(int number_of_products) {
        this.number_of_products = number_of_products;
    }

    public int getPrice_per_product() {
        return price_per_product;
    }

    public void setPrice_per_product(int price_per_product) {
        this.price_per_product = price_per_product;
    }

    public String getClient_username() {
        return client_username;
    }

    public void setClient_username(String client_username) {
        this.client_username = client_username;
    }

    public search_model() {
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

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
