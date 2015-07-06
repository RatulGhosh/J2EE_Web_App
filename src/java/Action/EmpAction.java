package Action;

import Entity.Employee;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EmpAction {
    public static  void main(String[] args)
    {
        //addEmp();
        //deleteEmpById(2);
        //updateEmp(3,"Narendra Modi");
        selectAllEmp();
        //selectAllEmp_Using_Criteria();
        //selectAllEmp_Using_Criteria_Restriction();
        //HQLDemo();
        hibdao.Hib_DAO_Layer.closeSession();
    }
    static  void addEmp(){
        Employee e = new Employee();
        e.setName("Bill");
        e.setDept("Marketing");
        e.setEid(4);
        e.setSalary(7950000.0f);
        
        
        Session s =hibdao.Hib_DAO_Layer.getSession();
        Transaction t = s.beginTransaction();
        //for(Employee e : arr)
        s.save(e);
        t.commit();
        System.out.println("DATA SAVED");

    }

     static void deleteEmpById(int id) {
        Employee e = new Employee();
        e.setEid(id);
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Transaction t = s.beginTransaction();
        s.delete(e);
        t.commit();
         System.out.println("DATA DELETED");
    }
     static void updateEmp(int id,String n) {
        /*Employee e = new Employee();
        e.setEid(id);
        e.setName(n);*/
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Employee e = (Employee)s.get(Employee.class, id);//pass the primary key,here it is id
        
        e.setName(n);
        s.update(e);
        
        
        Transaction t = s.beginTransaction();
        s.update(e);//Note the rest of the fields are also updated to null if we omit * statement above
        t.commit();
         System.out.println("DATA UPDATED");
     }
     
     static  void selectAllEmp()
     {
         //String query = "select * from employee";
         String query = "from Employee";//write the class name not the table name
         //if we need only name write "name from Employee"
         Session s = hibdao.Hib_DAO_Layer.getSession();
         //Query q = s.createSQLQuery(query);
         Query q = s.getNamedQuery("Filter_Salary");//using HQL
         q.setFloat("ui",50000.0f);
         List<Employee> data = q.list();//disconnected architechture everythings comes out as list.
         System.out.println("Data Fetched");
         /*for(Object o : data)
         {
             Object[] e = (Object[])o;  
             System.out.println(e[0]+" : "+e[1]+" : "+e[2]+" : "+e[3]);
         }*/
         for(Employee e : data)
         {
             //Employee e = (Employee)o;
             System.out.println("NAME  :  "+e.getName());
             System.out.println("DEPT  :  "+e.getDept());
             System.out.println("SALARY  :  "+e.getSalary());
             System.out.println("-----------------------------");
         }
     }

    private static void HQLDemo() {
        String query = "select count(*),max(e.salary) from Employee e";
        //String query = "select max(e.salary)  from Employee e";
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Query q = s.createQuery(query);
        List data = q.list();
        for(Object o : data){
            Object[] d = (Object[])o;
            System.out.println(d[0]+" : "+d[1]);
        
        }  
        //System.out.println(data);
        
        
    }
    static  void selectAllEmp_Using_Criteria()
     {
        
         Session s = hibdao.Hib_DAO_Layer.getSession();
         Criteria c = s.createCriteria(Employee.class);
         List<Employee> data = c.list();
         for(Employee e : data)
         {
             //Employee e = (Employee)o;
             System.out.println("NAME  :  "+e.getName());
             System.out.println("DEPT  :  "+e.getDept());
             System.out.println("SALARY  :  "+e.getSalary());
             System.out.println("-----------------------------");
         }
     }
    static  void selectAllEmp_Using_Criteria_Restriction()
     {
        
         Session s = hibdao.Hib_DAO_Layer.getSession();
         Criteria c = s.createCriteria(Employee.class);
         c.add(Restrictions.gt("salary",98000.0f));
         c.addOrder(Order.desc("salary"));
         List<Employee> data = c.list();
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
