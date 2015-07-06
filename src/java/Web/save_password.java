package Web;

import Entity.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class save_password extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession s = request.getSession(false);

        if (s == null) {
            request.setAttribute("msg", "Please login to change password");
            RequestDispatcher rd = request.getRequestDispatcher("changepassword.jsp");
            rd.forward(request, response);
        } else {
            String opass = request.getParameter("opass");

            String npass = request.getParameter("npass");

            String cpass = request.getParameter("cpass");

            if (!(npass.equals(cpass))) {
                /*out.println("<center>");
                 out.println("Password did not match");
                 out.println("<br>");
                 out.println("<a href=\"change_password.html\">Try Again</a>");
                 out.println("</center>");*/
                request.setAttribute("msg", "  Password Didnot Match");
                RequestDispatcher rd = request.getRequestDispatcher("changepassword.jsp");
                rd.forward(request, response);

            } else {

                String name = (String) s.getAttribute("uid");
                Session session = hibdao.Hib_DAO_Layer.getSession();
                Criteria c = session.createCriteria(Login.class);
                c.add(Restrictions.eq("userid", name));
                try {
                    List<Login> data = c.list();
                    if (data.get(0).getPass().equals(opass)) {

                        int id = data.get(0).getLid();
                        Login l = (Login) session.get(Login.class, id);//pass the primary key,here it is id
                        l.setLid(id);
                        l.setPass(npass);
                        l.setRole(data.get(0).getRole());
                        l.setUserid(data.get(0).getUserid());

                        Transaction t = session.beginTransaction();
                        session.update(l);//Note the rest of the fields are also updated to null if we omit * statement above
                        t.commit();
                        out.println("<center>Data successfully saved</center><br>");
                        RequestDispatcher rd;
                        request.setAttribute("msg"," Please login to continue");
                        rd = request.getRequestDispatcher("LogOut");
                        rd.include(request, response);

                    } else {

                        out.println("<center>");
                        out.println("Old Password doesnot exists");
                        out.println("<br>");
                        out.println("<a href=\"change_password.html\">Try Again</a>");
                        out.println("</center>");

                    }
                } catch (HibernateException | ServletException | IOException e) {
                    out.print(e.getMessage());
                }

            }
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
