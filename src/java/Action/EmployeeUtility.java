package Action;

import Entity.Employee;
import static java.lang.System.exit;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class EmployeeUtility {

    static int count = 1;
    static int max1;

    public static void main(String[] args) {
        System.out.println("Press 4 To view employee by page");
        System.out.println("Press 5 To Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 4:
                view_by_page(0, 3);
                break;
            case 5:
                exit(0);

            default:
                System.out.println("Wrong choice");
        }

    }

    private static void view_by_page(int min, int max) {

        if (count != 1) {
            System.out.println("-----------------------------");
        }

        Scanner sc = new Scanner(System.in);
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Criteria c = s.createCriteria(Employee.class);
        List<Employee> data1 = c.list();
        System.out.println("You are viewing page no. " + count);
        System.out.println(data1.size() + " records found");
        if (count == 1) {
            max1 = data1.size() / 3;
            if (data1.size() % 3 != 0) {
                max1 = max1 + 1;
            }
        }
        c.setFirstResult(min);
        c.setMaxResults(max);
        List<Employee> data = c.list();
        for (Employee e : data) {
            System.out.println("NAME  :  " + e.getName());
            System.out.println("DEPT  :  " + e.getDept());
            System.out.println("SALARY  :  " + e.getSalary());
            System.out.println("-----------------------------");
        }
        if (count == 1) {
            System.out.println("Press N/n for next page ");
            System.out.println("Press 0 to exit ");
            String st = sc.nextLine();
            if (st.equals("N") || st.equals("n")) {

                count++;
                view_by_page(3 * (count - 1), 3);

            } else if (st.equals("0")) {
                exit(0);
            } else {
                System.out.println("Wrong Choice.   Try again");
                view_by_page(3 * (count - 1), 3);

            }

        } else if (count == max1) {
            System.out.println("Press P/p for next page ");
            System.out.println("Press 0 to exit ");
            String st = sc.nextLine();
            if (st.equals("P") || st.equals("p")) {
                count--;
                view_by_page(3 * (count - 1), 3);
            } else if (st.equals("0")) {
                exit(0);
            } else {
                System.out.println("Wrong Choice.   Try again");
                view_by_page(3 * (count - 1), 3);

            }

        } else {
            System.out.println("Press P/p for next page ");
            System.out.println("Press N/n for next page ");
            System.out.println("Press 0 to exit ");
            String st = sc.nextLine();
            if (st.equals("P") || st.equals("p")) {

                count--;
                view_by_page(3 * (count - 1), 3);
            } else if (st.equals("N") || st.equals("n")) {
                count++;
                view_by_page(3 * (count - 1), 3);
            } else if (st.equals("0")) {
                exit(0);
            } else {
                System.out.println("Wrong Choice.   Try again");
                view_by_page(3 * (count - 1), 3);

            }

        }

    }

}
