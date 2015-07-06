
package Entity;

import javax.persistence.*;


@Entity
public class MajorProject extends Project
{
   
    private String task;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
