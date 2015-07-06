package Web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        String data = request.getParameter("check");
        if (data != null) {//cannot access html page as long as the id(check) is not hp(for this example)
            if (data.equals("hp")) {//Thus to access login.html we have to write login.html?check=hp
                chain.doFilter(request, response);
            } else {
                out.println("INVALID CHECK VALUE!! ");
            }
        } else {
            out.println("INVALID REQUEST!! ");
        }
    }

    @Override
    public void destroy() {

    }

}
