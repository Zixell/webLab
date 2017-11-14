package dao;

import java.util.ArrayList;

/**
 * Created by Roman Zhuravlev on 10.11.2017.
 */
public class CommentsList {
    private ArrayList<CommentsItem> list = new ArrayList<CommentsItem>();

    public void setList(ArrayList<CommentsItem> lst) {

        this.list = lst;
    }

    public ArrayList<CommentsItem> getList() {
        return list;
    }

    public void append(CommentsItem p) {
        this.list.add(p);
    }
}
