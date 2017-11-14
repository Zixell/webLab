package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

import javaClasses.cartLop;
import dbService.OrderManager;

/**
 * Created by Roman Zhuravlev on 05.11.2017.
 */
@WebServlet(name = "servlets.orderServlet", urlPatterns = "/OrderServlet")
public class orderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        HttpSession session = request.getSession();

        cartLop clop = (cartLop) session.getAttribute("cartList");

        OrderManager orderManager = new OrderManager();
        orderManager.addOrder(request.getUserPrincipal().getName(),request.getParameter("customer_name"),request.getParameter("customer_address"), clop);


        session.removeAttribute("cartList");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
