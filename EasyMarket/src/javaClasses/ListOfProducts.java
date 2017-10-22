package javaClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Roman Zhuravlev on 17.10.2017.
 */
public class ListOfProducts implements Serializable{
    private ArrayList<Product> list = new ArrayList<Product>(Arrays.asList(
            new Product("EQT 93/17 SUPPORT", 9000, "img/eqt9317_2.jpg"),
            new Product("EQT 93/17 SUPPORT", 7000, "img/eqt 9317 black.jpg"),
            new Product("SNEAKER BOOT", 6000, "img/sneakerboost.jpg"),
            new Product("JEANS SUPER", 5000, "img/jeans super.jpg"),
            new Product("PARLEY EQT", 8000, "img/parley eqt.jpg")
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
