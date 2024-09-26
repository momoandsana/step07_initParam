package ex0926.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import java.io.IOException;
//xml 기준
public class InitParamTestServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(InitParamTestServlet.class);

    private String id;
    private String pwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        id = config.getInitParameter("id");
        pwd = config.getInitParameter("pwd");

        log.info("초기화 파라미터 id: " + id);
        log.info("초기화 파라미터 pwd: " + pwd);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("요청됨... id: " + id + ", pwd: " + pwd);

    }


}
