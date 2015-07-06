package Entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)   //By default strategy = InheritanceType.SINGLE_TABLE
public class MiniProject implements Serializable {
    
    @Id
    private int pid;
    private String projectName;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    
    
}
