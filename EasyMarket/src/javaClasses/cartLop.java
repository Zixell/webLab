package javaClasses;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Roman Zhuravlev on 28.10.2017.
 */
public class cartLop implements Serializable{
    private ArrayList<cartItem> list = new ArrayList<cartItem>();

    public ArrayList<cartItem> getList(){
        return list;
    }

    public int countOfItem(String id){
        int c = 0;
        for(cartItem item: list){
            if(item.getProduct().getId().equals(id)){
                c = item.getCount();
            }
        }
        return c;
    }
    public void setList(ArrayList<cartItem> lst){
        this.list = lst;
    }

    public boolean isInList(cartItem p){
        for(cartItem item: this.list){
            if(p.getProduct().getId() == item.getProduct().getId()){
                return true;
            }
        }
        return false;
    }

    public void delete(String id) {
        for(int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getProduct().getId().equals(id)){
                    this.list.remove(i);
                }
            }

    }

    public void deleteOne(cartItem p){
            for(int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).getProduct().getId().equals(p.getProduct().getId())) {
                    this.list.get(i).setCount(this.list.get(i).getCount()-1);
                    this.list.get(i).setPrice(this.list.get(i).getPrice() - p.getPrice());
                    if(this.list.get(i).getCount() == 0){
                        this.list.remove(i);
                    }
                }
            }
    }
    public int cartCost(){
        int cost = 0;
        for(cartItem it: this.list){
            cost+=it.getPrice();
        }
        return cost;
    }
    public int cartCost(String lang){
        int cost = 0;
        for(cartItem it: this.list){
            cost+=it.getPrice();
        }
        if (lang != null) {
            if (lang.equals("ru")) return cost;
            if (lang.equals("en")) return cost/58;
            if (lang.equals("es")) return cost/67;
        }
        return cost/58;
    }
    public void append(cartItem p) {
        if (!this.isInList(p)) {
            p.setCount(p.getCount() + 1);
            p.setPrice(p.getProduct().getPrice());
            this.list.add(p);
        } else {
           for(int i = 0; i<this.list.size(); i++){
               if(this.list.get(i).getProduct().getId() == p.getProduct().getId()){
                   this.list.get(i).setCount(this.list.get(i).getCount()+1);
                   this.list.get(i).setPrice(this.list.get(i).getPrice()+p.getProduct().getPrice());
               }
           }
        }
    }
}
