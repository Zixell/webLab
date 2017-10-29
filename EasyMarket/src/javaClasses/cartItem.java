package javaClasses;

import org.apache.taglibs.standard.lang.jstl.IntegerDivideOperator;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by Roman Zhuravlev on 28.10.2017.
 */
public class cartItem implements Serializable{

    private Product product = new Product();
    private int price= 0;
    private int count = 0;

    public Product getProduct(){
        return this.product;
    }
    public int getPrice(){
        return this.price;
    }
    public int getPrice(String lang){
        if (lang != null) {
            if (lang.equals("ru")) return price;
            if (lang.equals("en")) return price/58;
            if (lang.equals("es")) return price/67;
        }
        return price/58;
    }
    public int getCount(){
        return this.count;
    }
    public  void setProduct(Product p){
        this.product = p;
    }
    public void setPrice(int pr){
        this.price = pr;
    }

    public void setProduct(Product p, int pr){

    }
    public void setCount(int count){
        this.count = count;
    }

    public cartItem(){

    }
    public cartItem(Product p){
        this.product = p;
        this.price = p.getPrice();
    }


}
