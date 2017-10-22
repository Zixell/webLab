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
                "<body>\n" +
                "        <div class=\"navbar\">\n" +
                "            <div href=\"#\" class=\"navbar-item\">\n" +
                "                <a href = \"productCard.jsp\">" + myres.getString("home")+"</a>\n" +
                "            </div> \n" +
                "            <div class = \"navbar-languages\">\n" +
                "                <a href=\"?lang=ru\">ru</a>  \n" +
                "                <a href=\"?lang=en\">en</a>\n" +
                "                <a href=\"?lang=es\">es</a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <hr>\n" +
                "        <div class=\"name\">\n" + myres.getString("product_name")+
                "            \n" +
                "        </div>\n" +
                "<div class = \"img_box\">     \n" +
                "    <div class=\"w3-content w3-display-container\" style=\"max-width:500px\" style=\"margin-top: 50px\">\n" +
                "                <img class=\"mySlides\" src=\"img/eqt9317.jpg\" style=\"width:100%\">\n" +
                "                <img class=\"mySlides\" src=\"img/eqt9317_1.jpg\" style=\"width:100%\">\n" +
                "                <img class=\"mySlides\" src=\"img/eqt9317_2.jpg\" style=\"width:100%\">\n" +
                "        <div class=\"w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle\" style=\"width:100%\">\n" +
                "            <div class=\"w3-left w3-hover-text-khaki\" onclick=\"plusDivs(-1)\">&#10094;</div>\n" +
                "            <div class=\"w3-right w3-hover-text-khaki\" onclick=\"plusDivs(1)\">&#10095;</div>\n" +
                "            <span class=\"w3-badge demo w3-border w3-transparent w3-hover-white\" onclick=\"currentDiv(1)\"></span>\n" +
                "            <span class=\"w3-badge demo w3-border w3-transparent w3-hover-white\" onclick=\"currentDiv(2)\"></span>\n" +
                "            <span class=\"w3-badge demo w3-border w3-transparent w3-hover-white\" onclick=\"currentDiv(3)\"></span>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class = \"buy_button\">\n" +
                "            <a href=\"#\" style = \"text-decoration: none\">"+myres.getString("buy_button")+"</a>\n" +
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
                "                    <div class=\"c-tab__content\">"+myres.getString("short_des_content")+"</div>\n" +
                "                </div>\n" +
                "                <div class=\"c-tab\">\n" +
                "                    <div class=\"c-tab__content\">\n" +
                "                        &bull; "+myres.getString("full_des_content_1")+"<br>\n" +
                "                        &bull; "+myres.getString("full_des_content_2")+"<br>\n" +
                "                        &bull; "+myres.getString("full_des_content_3")+"<br>\n" +
                "                        &bull; "+myres.getString("full_des_content_4")+"<br>\n" +
                "                        &bull; "+myres.getString("full_des_content_5")+"<br>\n" +
                "                        &bull; "+myres.getString("full_des_content_6")+"<br>\n" +
                "                        &bull; "+myres.getString("full_des_content_7")+"\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"c-tab\">\n" +
                "                    <div class=\"c-tab__content\">"+myres.getString("reviews_content")+"\n" +
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

