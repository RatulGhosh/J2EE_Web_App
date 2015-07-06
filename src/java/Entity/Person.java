package Entity;

import javax.persistence.*;


@Entity
public class Person {
    
    @Id
    @GeneratedValue
    private int pid;
    private String email;
    private String contact;
    
    @OneToOne
    @JoinColumn(name = "pdid_FK")
    private Person_Detail pd;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public Person_Detail getPd() {
        return pd;
    }

    public void setPd(Person_Detail pd) {
        this.pd = pd;
    }
    
    
    
    }
