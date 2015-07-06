package Action;

import Entity.Login;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Login_System {

    public static void main(String[] args) throws Exception {
        System.out.println("USER MENU");
        System.out.println("--------------");
        System.out.println("Press 1 for login.");
        System.out.println("Press 2 for signup.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter Username :");
                String us = sc.nextLine();

                System.out.println("Enter Password :");
                String pw = sc.nextLine();
                search(us, pw);
                break;
            case 2:
                System.out.println("Enter Username :");
                String us1 = sc.nextLine();
                System.out.println("Enter Password :");
                String pw1 = sc.nextLine();
                System.out.println("Confirm Password :");
                String pw2 = sc.nextLine();
                if (pw1.equals(pw2)) {
                    add(us1, pw1);
                }
                break;
            default:
                System.out.println("Wrong Choice");
        }
        hibdao.Hib_DAO_Layer.closeSession();
    }

    static void search(String name, String pwd) throws Exception {
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Criteria c = s.createCriteria(Login.class);
        c.add(Restrictions.eq("userid", name));
        try {
            List<Login> data = c.list();
            if (data.get(0).getPass().equals(pwd)) {
                System.out.println("Welcome " + data.get(0).getRole());
            } else {
                System.out.println("Wrong password");
            }
        } catch (Exception e) {
            System.out.println("Username doesnot exists");
        }

    }

    static void add(String name, String pwd) throws Exception {
        Login l = new Login();
        l.setUserid(name);
        l.setPass(pwd);
        l.setRole("User");
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Transaction t = s.beginTransaction();
        s.save(l);
        t.commit();
        System.out.println("DATA SAVED");

    }

    public static String encrypt(String pwd) {
        char c[] = pwd.toCharArray();
        String a = "";
        int d = 0;
        for (char i : c) {
            a = i + a;
        }
        return a;
    }

}
