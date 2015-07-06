package Action;

import Entity.Consumer;
import Entity.Dealer;
import Entity.Employee;
import Entity.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TableCreater {
    public static void main(String[] args) {
        AnnotationConfiguration cfg;
        cfg = new AnnotationConfiguration();
        //cfg.addAnnotatedClass(Consumer.class);
        //cfg.addAnnotatedClass(Login.class);
        cfg.addAnnotatedClass(PageCount.class);
        //cfg.addAnnotatedClass(Dealer_Detail.class);
        //cfg.addAnnotatedClass(Dealer.class);
        //cfg.addAnnotatedClass(Person.class);
        //cfg.addAnnotatedClass(Person_Detail.class);
        //cfg.addAnnotatedClass(Student.class);
        //cfg.addAnnotatedClass(College.class);
        //cfg.addAnnotatedClass(MiniProject.class);
        //cfg.addAnnotatedClass(Project.class);
       // cfg.addAnnotatedClass(MajorProject.class);
        
        cfg.configure();//use driver name,user name other database informations
        //cfg.configure("mycfg.xml"); if we change the name of the xml file inside the default package
        SchemaExport se = new SchemaExport(cfg);
        se.create(true,true);//first argument Query Building and Display in Log if it is false no logs will be displayed
        //second argument displays the query in the output screen
        System.out.println("TABLE CREATED!!");
    }
    
}
