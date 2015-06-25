package Action;

import Entity.Employee;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpAction {
    public static  void main(String[] args)
    {
        //addEmp();
        //deleteEmpById(2);
        updateEmp(3,"Narendra Modi");
        selectAllEmp();
        hibdao.Hib_DAO_Layer.closeSession();
    }
    static  void addEmp(){
        Employee e = new Employee();
        e.setName("Robert");
        e.setDept("Software");
        e.setEid(6);
        e.setSalary(9800000.0f);
        
        
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
        s.update(e);//Note the rest of the fields are also updated to null
        t.commit();
         System.out.println("DATA UPDATED");
     }
     
     static  void selectAllEmp()
     {
         String query = "select * from employee";
         Session s = hibdao.Hib_DAO_Layer.getSession();
         Query q = s.createSQLQuery(query);
         List data = q.list();//disconnected architechture everythings comes out as list.
         for(Object o : data)
         {
             Object[] e = (Object[])o;  
             System.out.println(e[0]+" : "+e[1]+" : "+e[2]+" : "+e[3]);
         }
     }
}
