import javaClasses.ListOfProducts;
import javaClasses.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Roman Zhuravlev on 01.10.2017.
 */

public class RofelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Locale locale = Locale.ENGLISH;
        String s = request.getParameter("lang");
        String ID = request.getParameter("id");
        Product pr = new Product();
        if(ID != null) {
            ListOfProducts a = new ListOfProducts();

            for(int i = 0; i < a.getList().size(); i++){
                if(a.getList().get(i).getId().equals(ID)){
                    pr = a.getList().get(i);
                }
            }
        }
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
        ResourceBundle myres = ResourceBundle.getBundle("locale/locales",
                locale);

        String sb = "<head>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href = \"style.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "   \n" +
                "</head>\n" +
                "\n" +
                "<body>\n"+
                "<div class=\"navbar\">"+"\n" +
                "<div href=\"#\" class=\"navbar-item\">"+"\n" +
                    "<a href = \"productsList.jsp\">SneakShop</a>"+"\n" +
                    "<a href = \"#\" style = \"font-size: 15px;\">"+myres.getString("cart")+"</a>"+"\n" +
                    "<a href = \"#\" style = \"font-size: 15px;\">"+myres.getString("history")+"</a>"+"\n" +
                    "<a href = \"#\" style = \"font-size: 15px;\">"+myres.getString("signin")+"</a>"+"\n" +
                "</div>"+
                 "       <div class = \"navbar-languages\">"+"\n" +
                  "          <a href=\"?id="+pr.getId()+"&lang=ru\">ru</a>"+"\n" +
                   "         <a href=\"?id="+pr.getId()+"&lang=en\">en</a>"+"\n" +
                    "        <a href=\"?id="+pr.getId()+"&lang=es\">es</a>"+"\n" +
                     "   </div>"+"\n" +
                    "</div>"+"\n" +
                "<hr>" +"\n" +

                "        <div class=\"name\">\n" + pr.getName() +
                "            \n" +
                "        </div>\n" +
                "<div class = \"img_box\">     \n" +
                "    <div class=\"w3-content w3-display-container\" style=\"max-width:500px\" style=\"margin-top: 50px\">\n" +
                "                <img class=\"mySlides\" src=\""+pr.getPath(0)+"\" style=\"width:100%\">\n" +
                "                <img class=\"mySlides\" src=\""+pr.getPath(1)+"\" style=\"width:100%\">\n" +
                "                <img class=\"mySlides\" src=\""+pr.getPath(2)+"\" style=\"width:100%\">\n" +
                "        <div class=\"w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle\" style=\"width:100%\">\n" +
                "            <div class=\"w3-left w3-hover-text-khaki\" onclick=\"plusDivs(-1)\">&#10094;</div>\n" +
                "            <div class=\"w3-right w3-hover-text-khaki\" onclick=\"plusDivs(1)\">&#10095;</div>\n" +
                "            <span class=\"w3-badge demo w3-border w3-transparent w3-hover-white\" onclick=\"currentDiv(1)\"></span>\n" +
                "            <span class=\"w3-badge demo w3-border w3-transparent w3-hover-white\" onclick=\"currentDiv(2)\"></span>\n" +
                "            <span class=\"w3-badge demo w3-border w3-transparent w3-hover-white\" onclick=\"currentDiv(3)\"></span>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class = \"buy_button\">\n" +
                "            <a href=\"#\" style = \"text-decoration: none\">"+"" +
                "<a href=\"#openModal\">"+myres.getString("buy_button")+"</a>\n" +
                "<div id=\"openModal\" class=\"modalDialog\">\n" +
                "    <div>\n" +
                "        <a href=\"#close\" title=\"Закрыть\" class=\"close\">X</a>\n" +
                "        <h2>Модальное окно</h2>\n" +
                "        <p>Пример простого модального окна, которое может быть создано с использованием CSS3.</p>\n" +
                "        <p>Его можно использовать в широком диапазоне, начиная от вывода сообщений и заканчивая формой регистрации.</p>\n" +
                "    </div>\n" +
                "</div>"+"</a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<hr>\n" +
                "<div class = \"purchase\" style=\"margin-top:20px\">\n" +
                "            <div id=\"tabs\" class=\"c-tabs no-js\">\n" +
                "                <div class=\"c-tabs-nav\">\n" +
                "                    <a href=\"#\" class=\"c-tabs-nav__link is-active\">"+myres.getString("short_des")+"</a>\n" +
                "                    <a href=\"#\" class=\"c-tabs-nav__link\">"+myres.getString("full_des")+"</a>\n" +
                "                    <a href=\"#\" class=\"c-tabs-nav__link\">"+myres.getString("reviews")+"</a>\n" +
                "                    \n" +
                "                </div>\n" +
                "                \n" +
                "                <div class=\"c-tab is-active\">\n" +
                "                    <div class=\"c-tab__content\">"+pr.getShortDes(s)+"</div>\n" +
                "                </div>\n" +
                "                <div class=\"c-tab\">\n" +
                "                    <div class=\"c-tab__content\">\n" +pr.getFullDes(s)+

                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"c-tab\">\n" +
                "                    <div class=\"c-tab__content\">"+"\n" +pr.getReviews()+
                "\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "           </div>\n" +
                "     </div>\n" +
                "    \n" +
                "     <hr>\n" +
                "     <div class = \"footer\">\n" +
                "         <table class=\"w3-table\" style=\"text-decoration: none\">\n" +
                "            <tr>\n" +
                "                <th>"+myres.getString("help")+"</th>\n" +
                "                <th>"+myres.getString("info")+"</th>\n" +
                "                <th>"+myres.getString("about")+"</th>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td><a href = \"#\">"+myres.getString("shipping")+"</a></td>\n" +
                "                <td><a href = \"#\">"+myres.getString("sizes")+"</a></td>\n" +
                "                <td><a href = \"#\">"+myres.getString("us")+"</a></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td><a href = \"#\">"+myres.getString("payment")+"</a></td>\n" +
                "                <td><a href = \"#\">"+myres.getString("care")+"</a></td>\n" +
                "                <td><a href = \"#\">"+myres.getString("vacancies")+"</a></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td><a href = \"#\">"+myres.getString("ordering")+"</a></td>\n" +
                "                \n" +
                "                <td><a href = \"#\">"+myres.getString("shops")+"</a></td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "     </div>\n" +
                "<script src=\"script.js\"></script>\n" +
                "<script>\n" +
                "  var myTabs = tabs({\n" +
                "    el: '#tabs',\n" +
                "    tabNavigationLinks: '.c-tabs-nav__link',\n" +
                "    tabContentContainers: '.c-tab'\n" +
                "  });\n" +
                "\n" +
                "  myTabs.init();\n" +
                "</script>\n" +
                "</body>";


        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(sb);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

