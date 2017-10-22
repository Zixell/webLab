package javaClasses;
import java.util.*;
/**
 * Created by Roman Zhuravlev on 17.10.2017.
 */
public class Product {
    private String name;
    private int price;
    private String id;
    private String[] pathToImg = new String[3];
    private String[] shortDes = new String[3];
    private String[] fullDes = new String[3];
    private String reviews;


    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public String getPath(){
        return pathToImg[0];
    }

    public String getPath(int pos){
        return pathToImg[pos];
    }

    public String getShortDes(String lang) {
        if (lang != null) {
            if (lang.equals("ru")) return shortDes[0];
            if (lang.equals("en")) return shortDes[1];
            if (lang.equals("es")) return shortDes[2];
        }
        return shortDes[1];

    }
    public String getFullDes(String lang) {
        if (lang != null) {
            if (lang.equals("ru")) return fullDes[0];
            if (lang.equals("en")) return fullDes[1];
            if (lang.equals("es")) return fullDes[2];
        }
        return fullDes[1];
    }

    public String getReviews(){
        return reviews;
    }

    public String getId(){
        return id;
    }

    public void setName(String nm){
        this.name = nm;
    }

    public void setPath(String pt){
        this.pathToImg[0] = pt;
    }

    public void setPrice(int pr){
        this.price = pr;
    }

    public void setId(String id){
        this.id = id;
    }

    public Product(){

    }

    public Product(String id, String name, int price, String path1, String path2, String path3, String shortDes,  String shortDes1 , String shortDes2, String fullDes, String fullDes1, String fullDes2, String reviews){
        this.id = id;
        this.name = name;
        this.price = price;
        this.pathToImg[0] = path1;
        this.pathToImg[1] = path2;
        this.pathToImg[2] = path3;
        this.shortDes[0] = shortDes;
        this.shortDes[1] = shortDes1;
        this.shortDes[2] = shortDes2;
        this.fullDes[0] = fullDes;
        this.fullDes[1] = fullDes1;
        this.fullDes[2] = fullDes2;
        this.reviews = reviews;
    }
}
