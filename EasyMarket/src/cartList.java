import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import javaClasses.ListOfProducts;
import javaClasses.Product;
import javaClasses.cartItem;
import javaClasses.cartLop;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * Created by Roman Zhuravlev on 28.10.2017.
 */
public class cartList extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Locale locale = Locale.ENGLISH;
        String s = request.getParameter("lang");
        if(s != null) {
            if (s.equals("ru")) {
                locale = Locale.forLanguageTag("ru");
            } else if (s.equals("en")) {
                locale = Locale.forLanguageTag("en");
            } else if (s.equals("es")) {
                locale = Locale.forLanguageTag("es");
            }
        } else {
            locale = Locale.ENGLISH;
        }

        ResourceBundle myres = ResourceBundle.getBundle("locale/locales", locale);

        String requestData = request.getParameter("id");
        String add = request.getParameter("add");
        HttpSession session = request.getSession();

        if(requestData != null && add != null) {
            ListOfProducts lop = new ListOfProducts();
            ArrayList<Product> listOfProduct = new ArrayList<Product>();

            listOfProduct = lop.getList();
            Product p = new Product();
            p = listOfProduct.get(Integer.parseInt(requestData) - 1);
            //System.out.println(p.getName());
            cartItem it = new cartItem(p);

            cartLop clop1 = new cartLop();
            if (add.equals("1")) {
                if (session.getAttribute("cartList") != null) {
                    clop1 = (cartLop) session.getAttribute("cartList");
                    clop1.append(it);
                    session.setAttribute("cartList", clop1);
                } else {
                    clop1.append(it);
                    session.setAttribute("cartList", clop1);
                }
            } else if (add.equals("0")) {
                clop1 = (cartLop) session.getAttribute("cartList");
                clop1.deleteOne(it);
                session.setAttribute("cartList", clop1);
            } else if (add.equals("delete")) {
                clop1 = (cartLop) session.getAttribute("cartList");
                session.setAttribute("cartList", clop1);
                clop1.delete(requestData);
            }

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
