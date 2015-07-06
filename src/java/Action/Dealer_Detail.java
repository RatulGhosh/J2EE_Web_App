package Action;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable //Can be embedded to another Entity Class
public class Dealer_Detail implements Serializable{//to write object as files in data base
    private String address;
    private String contact;
    private String email;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
