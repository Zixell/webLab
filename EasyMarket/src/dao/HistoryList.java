package dao;

import javaClasses.cartItem;

import java.util.ArrayList;

/**
 * Created by Roman Zhuravlev on 06.11.2017.
 */
public class HistoryList {
    private ArrayList<HistoryItem> list = new ArrayList<HistoryItem>();

    public void setList(ArrayList<HistoryItem> lst) {

        this.list = lst;
    }

    public ArrayList<HistoryItem> getList() {
        return list;
    }

    public void append(HistoryItem p) {

        p.getItem().setCount(p.getItem().getCount() + 1);
        p.getItem().setPrice(p.getItem().getProduct().getPrice());
        this.list.add(p);
    }
}