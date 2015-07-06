package Web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class FirstServlet extends GenericServlet{

    int pagehitcounter = 0;
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        
        System.out.println("Server is ready!!!!");//here output will displayed on server
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        pagehitcounter++;
        String msg = "<h1>HIT COUNT : "+pagehitcounter+"</h1>";
        out.print(msg);
        //out.print("Server is Ready");
        /*for(int i = 0;i<10;i++)
            out.println("<br>GENERIC SERVLET IS RUNNING!!");*/

    }

    //@Override
    /*public void init(ServletConfig config) throws ServletException {
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Criteria c = s.createCriteria(PageCount.class);
        c.add(Restrictions.eq("Pname","callfs"));
        List<PageCount>data = c.list();
        pagehitcounter = data.get(0).getPhit();
        super.init();
    }
    
    @Override
    public void destroy() {
        
        Session s = hibdao.Hib_DAO_Layer.getSession();
        Criteria c = s.createCriteria(PageCount.class);
        c.add(Restrictions.eq("Pname","callfs"));
        List<PageCount>data = c.list();
        int id = data.get(0).getId();
        String pname = data.get(0).getPname();
        PageCount pc = (PageCount)s.get(PageCount.class, id);
        pc.setId(id);
        pc.setPhit(pagehitcounter);
        pc.setPname(pname);
        super.destroy();
       
    }*/
    
    
}

    