
package Action;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestData {
    public static void main(String[] args) {
        //consumer();
        //dealer();
        person();
        //inheritance();
        hibdao.Hib_DAO_Layer.closeSession();
        
    }
    static  void consumer(){
        Consumer c = new Consumer();
        c.setName("hpes");
        c.setAddress("Gurgaon");
        c.setContact("999999999");
        c.setEmail("abc.@");
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Transaction t = s.beginTransaction();
        s.save(c);
        t.commit();
        System.out.println("Consumer Data Saved");
    }

    static void dealer() {
      
        Dealer_Detail details = new Dealer_Detail();
        details.setAddress("Mumbai");
        details.setEmail("reliance.@gmail.com");
        details.setContact("958566569554");
        
        Dealer dealer = new Dealer();
        dealer.setName("Relaince");
        dealer.setDd(details);
        
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Transaction t = s.beginTransaction();
        s.save(dealer);
        t.commit();
        System.out.println("Dealer Data Saved");
    }

    static void person() {
        
        Person p = new Person();
        Person_Detail pd = new Person_Detail();
        p.setEmail("abg.gmail");
        p.setContact("982526533");
        pd.setContact("9+89+95");
        pd.setEmail("cgwjgw@jhj.com");
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Transaction t = s.beginTransaction();
        s.save(p);
        s.save(pd);
        t.commit();
        System.out.println("Data Saved");

    }

    static void inheritance() {
        MiniProject ob1 = new MiniProject();
        Project ob2 = new Project();
        MajorProject ob3 = new MajorProject();
        ob1.setPid(101);
        ob1.setProjectName("Online Bill System");
        ob2.setPid(102);
        ob2.setProjectName("Reservation System");
        ob2.setModules("PNR Enquiry");
        ob3.setPid(103);
        ob3.setProjectName("Online Voting System");
        ob3.setModules("Admin Module");
        ob3.setTask("Vote Count");
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Transaction t = s.beginTransaction();
        s.save(ob1);
        s.save(ob2);
        s.save(ob3);
        t.commit();
        System.out.println("All Projects Saved");
        
    }

}
