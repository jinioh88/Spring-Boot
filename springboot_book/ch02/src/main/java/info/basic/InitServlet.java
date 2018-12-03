package info.basic;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "init", urlPatterns = {"/init"}, initParams = {@WebInitParam(name = "siteName", value="jpub")})
public class InitServlet extends HttpServlet {
    private String myParam = "";

    @Override
    public void init(ServletConfig servletConfig) throws ServletException { ;
        System.out.println("init call");
        this.myParam = servletConfig.getInitParameter("siteName");
        System.out.println(myParam);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello");
    }
}
