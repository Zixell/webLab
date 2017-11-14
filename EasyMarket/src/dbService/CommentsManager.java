package dbService;

import dao.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Roman Zhuravlev on 10.11.2017.
 */
public class CommentsManager {
    final static Logger logger = Logger.getLogger(CommentsManager.class);
    public void addComment(String userName, String commentText) {
        logger.info("adding customer's comment to SQL DB");

        commentsCommentsEntity orderEntity = new commentsCommentsEntity();

        Date date = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        orderEntity.setCommenItem(commentText);
        orderEntity.setDateTimeItem(sdf.format(date));
        orderEntity.setUserNameItem(userName);

        System.out.println("added!");
        System.out.println(commentText+" "+sdf.format(date));

            try {
                logger.info("Sending CommentEntity to DAO layer");
                CommentsDAO.addData(orderEntity);
                logger.info("Comment was added to DB!");
            } catch (SQLException e) {
                logger.error("EXEPTION!");
                e.printStackTrace();
            }
        }

    public JSONObject getComments(String customerName, int indicator){
        logger.info("Getting all comments and converting into JSON");
        List<commentsCommentsEntity> commentslist = (List<commentsCommentsEntity>) CommentsDAO.getCustomerComments(customerName);
        JSONObject jsonObject = new JSONObject();
        if(indicator == 1){
            logger.info("Just last comment");
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(commentslist.get(commentslist.size()-1).getCommenItem());
            jsonArray.add(commentslist.get(commentslist.size()-1).getDateTimeItem());
            System.out.println(commentslist.get(commentslist.size()-1).getCommenItem());
            System.out.println(commentslist.get(commentslist.size()-1).getDateTimeItem());
            jsonObject.put("0", jsonArray);

            return jsonObject;
        }
        else if(indicator ==2){
            logger.info("All comments going to convert");
            jsonObject = new JSONObject();
            for (int i = 0; i < commentslist.size(); i++) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(commentslist.get(i).getCommenItem());
                jsonArray.add(commentslist.get(i).getDateTimeItem());
                jsonObject.put(i, jsonArray);

            }
            return jsonObject;
        }
        return null;
    }
}
