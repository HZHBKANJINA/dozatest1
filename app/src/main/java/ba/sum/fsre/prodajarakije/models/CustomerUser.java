package ba.sum.fsre.prodajarakije.models;

import com.google.firebase.firestore.PropertyName;

public class CustomerUser {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public CustomerUser(){}

    public CustomerUser(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    @PropertyName("firstName")
    public String getFirstName() {
        return firstName;
    }
    @PropertyName("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @PropertyName("lastName")
    public String getLastName() {
        return lastName;
    }
    @PropertyName("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @PropertyName("email")
    public String getEmail() {
        return email;
    }
    @PropertyName("email")
    public void setEmail(String email) {
        this.email = email;
    }
    @PropertyName("phone")
    public String getPhone() {
        return phone;
    }
    @PropertyName("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

