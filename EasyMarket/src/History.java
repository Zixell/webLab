
import dao.HistoryList;
import dbService.OrderManager;
import javaClasses.Product;
import javaClasses.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "History", urlPatterns = "/History")
public class History extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        HistoryList history = new HistoryList();
        OrderManager orderManager = new OrderManager();

        if(request.isUserInRole("tomcat")) {
            history = orderManager.getOrders(request.getUserPrincipal().getName());
            session.setAttribute("historyList", history);
        } else {

        }
        //************************************************************************************







    }
}
