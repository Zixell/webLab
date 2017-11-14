package dao;/**
 * Created by Roman Zhuravlev on 06.11.2017.
 */
import javaClasses.*;

import java.util.ArrayList;

public class HistoryItem {
    private cartItem item;
//
    private String consumer;
    private String adress;
    private String dateTime;


    public String getConsumer(){
        return consumer;
    }
    public String getDateTime(){
        return dateTime;
    }
    public void setConsumer(String consumer){
        this.consumer = consumer;
    }
    public void setDateTime(String date){
        this.dateTime = date;
    }
    public String getAdress(){
        return adress;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }
    public cartItem getItem(){
        return item;
    }
    public void setItem(cartItem consumer){
        this.item = consumer;
    }

    public HistoryItem(){

    }

    public HistoryItem(cartItem item, String consumer, String dateTime, String adress){
        this.item = item;
        this.consumer = consumer;
        this.dateTime = dateTime;
        this.adress = adress;
    }
}
