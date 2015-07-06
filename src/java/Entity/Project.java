package Entity;

import javax.persistence.*;


@Entity
public class Project extends MiniProject{
    
    private String modules;

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }
    
}
