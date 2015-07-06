
package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PageCount {
    
    @Id
    @GeneratedValue
    private int id;
    private String pname;
    private int phit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPhit() {
        return phit;
    }

    public void setPhit(int phit) {
        this.phit = phit;
    }

    
}
