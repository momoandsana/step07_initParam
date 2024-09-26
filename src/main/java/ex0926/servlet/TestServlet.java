package ex0926.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;  // Log4j Logger import

import java.io.IOException;

// initParam 은 해당 서블릿에서만 사용 가능함
// 다른 서블릿에서도 사용하고 싶다면 ServletContext 에 저장해야 된다
@WebServlet(urlPatterns = "/b", loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "fileName", value = "test.jpg"),
                @WebInitParam(name = "message", value = "hi")
        })
public class TestServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(TestServlet.class); // Log4j Logger instance

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // 부모 클래스의 init 메서드 호출
        log.info("초기화됨...");

        // 초기화 파라미터 읽기
        String fileName = config.getInitParameter("fileName");
        String message = config.getInitParameter("message");
        String id=config.getInitParameter("id");
        log.info("초기화됨: " + fileName + " / " + message+"/"+id);

        ServletContext application = config.getServletContext();
        String info = application.getInitParameter("info");
        // servletContext 다른 서블릿에서도 이 파라미터에 접근이 가능하다

        log.info(info);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
