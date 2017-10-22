package javaClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Roman Zhuravlev on 17.10.2017.
 */
public class ListOfProducts implements Serializable{
    private ArrayList<Product> list = new ArrayList<Product>(Arrays.asList(
            new Product("1","EQT 93/17 SUPPORT", 9000, "img/eqt9317_2.jpg", "img/eqt9317_1.jpg", "img/eqt9317.jpg","shortDes","shortDes1","shortDes2", "full1", "full2", "full3","reviews"),
            new Product("2","EQT 93/17 SUPPORT", 7000, "img/eqt 9317 black.jpg", "img/eqt 9317 black_1.jpg","img/eqt 9317 black_2.jpg","shortDes","shortDes1","shortDes2", "full1", "full2", "full3","reviews"),
            new Product("3","SNEAKER BOOT", 6000, "img/sneakerboost.jpg","img/sneakerboost_1.jpg","img/sneakerboost_2.jpg","shortDes","shortDes1","shortDes2", "full1", "full2", "full3","reviews"),
            new Product("4","JEANS SUPER", 5000, "img/jeans super.jpg", "img/jeans super_1.jpg","img/jeans super_2.jpg","shortDes","shortDes1","shortDes2", "full1", "full2", "full3","reviews"),
            new Product("5","PARLEY EQT", 8000, "img/parley eqt.jpg", "img/parley eqt_1.jpg","img/parley eqt_2.jpg","shortDes","shortDes1","shortDes2", "full1", "full2", "full3","reviews")
    ));

    public ArrayList<Product> getList(){
        return list;
    }

    public void setList(ArrayList<Product> lst){
        this.list = lst;
    }

    public ListOfProducts(){

    }

}
