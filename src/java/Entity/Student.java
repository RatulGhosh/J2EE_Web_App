
package Entity;

import javax.persistence.*;

@Entity
public class Student {
    
    @Id
    private int sid;
    private String sname;
    
    @ManyToOne
    private College college;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
    
    
}
