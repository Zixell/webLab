package javaClasses;

import java.util.ArrayList;

/**
 * Created by Roman Zhuravlev on 22.10.2017.
 */
public class filtredList {
    private ArrayList<Product> list = new ArrayList<Product>();

    public ArrayList<Product> getList(){
        return list;
    }

    public void setList(ArrayList<Product> lst){
        this.list = lst;
    }

    public void append(Product p){
       this.list.add(p);
    }

    public filtredList(){

    }

}
