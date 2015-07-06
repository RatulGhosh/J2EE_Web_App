package Entity;
import javax.persistence.*;

@Entity
@NamedQueries({ 
    @NamedQuery (name="Emp.findAll",query="from Employee e"),
    @NamedQuery(name="Filter_Salary",query="from Employee e where e.salary > :ui")//: is must
})
public class Employee  {

    @Id
    @GeneratedValue
    private int eid;
    @Column(name = "Ename")
    private String name;
    private String dept;
    private float salary;
    

    public Employee(int eid, String name, String dept, float salary) {
        this.eid = eid;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public Employee() {
    }
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
