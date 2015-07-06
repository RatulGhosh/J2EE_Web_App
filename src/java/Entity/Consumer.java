package Entity;
import javax.persistence.*;

@Entity
@SecondaryTable(name = "Consumer_Detail")
public class Consumer {

    @Id
    @GeneratedValue
    private int cid;
    private String name;
    
    
    @Column(table="Consumer_Detail")
    private String address;
    @Column(table="Consumer_Detail")
    private String email;
    @Column(table="Consumer_Detail")
    private String contact;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
