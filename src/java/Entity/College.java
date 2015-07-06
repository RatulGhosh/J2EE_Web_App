
package Entity;

import java.util.List;
import javax.persistence.*;

@Entity
public class College {
    
    @Id
    private int cid;
    private String cname;
    
    @OneToMany(targetEntity = Student.class,mappedBy = "college")
    private List<Student> students;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    
    
}
