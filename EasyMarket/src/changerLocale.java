import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


/**
 * Created by Roman Zhuravlev on 29.10.2017.
 */
@WebServlet(name = "changerLocale")
public class changerLocale extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("lang");
        String path = request.getParameter("re");
        String new_str = path.replaceAll ("http://localhost:8080/" , "");
        HttpSession session = request.getSession();
        session.setAttribute("locale", s);
        RequestDispatcher dispatcher = request.getRequestDispatcher(new_str);
        dispatcher.forward(request, response);
    }
}
