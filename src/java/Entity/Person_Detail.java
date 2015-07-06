
package Entity;

import javax.persistence.*;

@Entity
public class Person_Detail {
    
    @Id
    @GeneratedValue
    private int pidid;
    private String email;
    private String contact;

    public int getPidid() {
        return pidid;
    }

    public void setPidid(int pidid) {
        this.pidid = pidid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
}
