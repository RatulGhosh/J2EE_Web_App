package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Authentication extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String name = request.getParameter("name");
            name = name.replace("'", "\\'");

            String password = request.getParameter("password");
            password = password.replace("'", "\\'");

            String q = "Select *from login where userid='" + name + "' and pass='" + password + "'";
            //out.println(q);

            // int a = 5/0; server side error code 500
            ResultSet rs = jdbcdao.DAOLayer.selectData(q);
            if (rs.next()) {
                //HttpSession session = request.getSession();
                out.println("Successfully signed in ");
                if (rs.getString(3).equalsIgnoreCase("admin")) {

                    HttpSession session = request.getSession();
                    /*out.println("Welcome admin");//*
                     RequestDispatcher rd;
                     rd = request.getRequestDispatcher("cp");//sending login.html data to cp
                    
                     //in request dispatcher the url doesnot change but in redirection the url get changed
                     rd.forward(request, response);
                     rd.include(request, response);//here * Welcome admin will be visible*/
                    //ADMIN   
                    //response.sendRedirect("cp");
                    session.setAttribute("uid", name);
                    String dm = "WELCOME ADMIN : AUTHENTICATION SERVLET";
                    ServletConfig cfg = getServletConfig();
                    String am = cfg.getInitParameter("email");
                    out.println("ADMIN EMAIL : " + am);

                    ServletContext ctx = getServletContext();
                    String copy = ctx.getInitParameter("crs");
                    out.println("<br>COPYRIGHT : " + copy);

                    request.setAttribute("msg", dm);
                    RequestDispatcher rd;
                    rd = request.getRequestDispatcher("cp");
                    rd.include(request, response);
                    //response.sendRedirect("control_panel");
                } else {

                    //out.println("<center>Username doesnot exists.<br>Please register below.</center>");
                    HttpSession session = request.getSession();
                    session.setAttribute("uid", name);
                    RequestDispatcher rd;
                    rd = request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);
                    //response.sendRedirect("home.html?check=hp");
                    /*RequestDispatcher rd;
                     rd = request.getRequestDispatcher("cp");
                     rd.include(request, response);*/

                }

            } else {
                //out.print("<font size=5 color=red>INVALID LOGIN ID or PASSWORD</font>");
                String str = "INVALID LOGIN ID OR PASSWORD";
                request.setAttribute("msg", str);
                RequestDispatcher rd = request.getRequestDispatcher("loginpage.jsp");
                out.println("Hello");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            out.print(e);

            out.print("<hr>");

            e.printStackTrace(out);
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
