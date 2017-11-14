package dao;/**
 * Created by Roman Zhuravlev on 10.11.2017.
 */
public class CommentsItem {
    private String comment;
    private String dateTime;
    private String user;

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setUser(String user) {
        this.user = user;
    }



    public String getDateTime() {
        return dateTime;
    }

    public String getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
