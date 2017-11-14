package dao;

import javax.persistence.*;

/**
 * Created by Roman Zhuravlev on 10.11.2017.
 */
@Entity
@Table(name = "comments", schema = "history", catalog = "")
public class commentsCommentsEntity {
    private int idcomments;
    private String commenItem;
    private String dateTimeItem;
    private String userNameItem;

    @Id
    @Column(name = "idcomments")
    public int getIdcomments() {
        return idcomments;
    }

    public void setIdcomments(int idcomments) {
        this.idcomments = idcomments;
    }

    @Basic
    @Column(name = "commenItem")
    public String getCommenItem() {
        return commenItem;
    }

    public void setCommenItem(String commenItem) {
        this.commenItem = commenItem;
    }

    @Basic
    @Column(name = "dateTimeItem")
    public String getDateTimeItem() {
        return dateTimeItem;
    }

    public void setDateTimeItem(String dateTimeItem) {
        this.dateTimeItem = dateTimeItem;
    }

    @Basic
    @Column(name = "userNameItem")
    public String getUserNameItem() {
        return userNameItem;
    }

    public void setUserNameItem(String userNameItem) {
        this.userNameItem = userNameItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        commentsCommentsEntity that = (commentsCommentsEntity) o;

        if (idcomments != that.idcomments) return false;
        if (commenItem != null ? !commenItem.equals(that.commenItem) : that.commenItem != null) return false;
        if (dateTimeItem != null ? !dateTimeItem.equals(that.dateTimeItem) : that.dateTimeItem != null) return false;
        if (userNameItem != null ? !userNameItem.equals(that.userNameItem) : that.userNameItem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcomments;
        result = 31 * result + (commenItem != null ? commenItem.hashCode() : 0);
        result = 31 * result + (dateTimeItem != null ? dateTimeItem.hashCode() : 0);
        result = 31 * result + (userNameItem != null ? userNameItem.hashCode() : 0);
        return result;
    }
}
