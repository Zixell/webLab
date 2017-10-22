package javaClasses;

/**
 * Created by Roman Zhuravlev on 17.10.2017.
 */
public class Product {
    private String name;
    private int price;
    private String pathToImg;
    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public String getPath(){
        return pathToImg;
    }

    public void setName(String nm){
        this.name = nm;
    }

    public void setPath(String pt){
        this.pathToImg = pt;
    }

    public void setPrice(int pr){
        this.price = pr;
    }

    public Product(){

    }

    public Product(String name, int price, String path){
        this.name = name;
        this.price = price;
        this.pathToImg = path;
    }
}
