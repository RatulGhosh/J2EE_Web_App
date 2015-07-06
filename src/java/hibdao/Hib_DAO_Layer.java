/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibdao;
import Action.Dealer_Detail;
import Action.EmployeeUtility;
import Entity.*;
import org.hibernate.Session ;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author P045
 */
public class Hib_DAO_Layer {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            AnnotationConfiguration cfg;
            cfg = new AnnotationConfiguration();
            cfg.addAnnotatedClass(Employee.class);
            cfg.addAnnotatedClass(Login.class);
            cfg.addAnnotatedClass(Consumer.class);
            cfg.addAnnotatedClass(Dealer.class);
            cfg.addAnnotatedClass(Dealer_Detail.class);
            cfg.addAnnotatedClass(Person.class);
            cfg.addAnnotatedClass(Person_Detail.class);
            cfg.addAnnotatedClass(Dealer_Detail.class);
            cfg.addAnnotatedClass(College.class);
            cfg.addAnnotatedClass(Student.class);
            cfg.addAnnotatedClass(MiniProject.class);
            cfg.addAnnotatedClass(Project.class);
            cfg.addAnnotatedClass(MajorProject.class);
            cfg.addAnnotatedClass(EmployeeUtility.class);
            cfg.configure();
            sessionFactory = cfg.buildSessionFactory();
           // sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("SessionFactory error : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getSession(){
        return sessionFactory.openSession();
    }
    public static void closeSession(){
        sessionFactory.close();
    }
}
