package Action;

import Entity.Employee;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class Pagination {
    public static  void  main(String[] args)
    {
        selectAllEmp(0,3);
        selectAllEmp(3,3);
        selectAllEmp(6,3);
        hibdao.Hib_DAO_Layer.closeSession();
    }
     static  void selectAllEmp(int i,int max)
     {
         Session s = hibdao.Hib_DAO_Layer.getSession();
         Criteria c = s.createCriteria(Employee.class);
         c.setFirstResult(i);
         c.setMaxResults(max);
         List<Employee> data = c.list();
         System.out.println("Data Fetched");
         for(Employee e : data)
         {
             //Employee e = (Employee)o;
             System.out.println("NAME  :  "+e.getName());
             System.out.println("DEPT  :  "+e.getDept());
             System.out.println("SALARY  :  "+e.getSalary());
             System.out.println("-----------------------------");
         }
     }
}