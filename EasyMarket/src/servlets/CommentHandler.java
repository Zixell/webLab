package servlets;

import dbService.CommentsManager;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Roman Zhuravlev on 11.11.2017.
 */
@WebServlet(name = "CommentHandler")
public class CommentHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject = new JSONObject();
        int indicator;
        CommentsManager commentManager = new CommentsManager();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");



        if(request.getParameter("all").equals("1")){
            indicator = 1;
            request.getParameter("params");


            commentManager.addComment(request.getUserPrincipal().getName(), request.getParameter("params"));
            jsonObject = commentManager.getComments(request.getUserPrincipal().getName(), indicator);


            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonObject);
        }
        else if(request.getParameter("all").equals("all")){
            indicator = 2;


            jsonObject = commentManager.getComments(request.getUserPrincipal().getName(),indicator);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonObject);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
