package dbService;/**
 * Created by Roman Zhuravlev on 05.11.2017.
 */
import dao.HistoryItem;
import dao.HistoryList;
import javaClasses.*;
//import javaClasses.cartItem;
//import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

import dao.historyHistorytableEntity;

import dbService.OrderDAO;
import org.apache.log4j.Logger;

public class OrderManager implements Serializable{
    final static Logger logger = Logger.getLogger(OrderManager.class);
    public void addOrder(String userName,String customer_name, String customer_address, cartLop list) {
        logger.info("adding customers Order to SQL DB");

        historyHistorytableEntity orderEntity = new historyHistorytableEntity();
        for (int i = 0; i < list.getList().size(); i++) {
            Date date = new Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(date);
            orderEntity.setUserItem(userName);
            orderEntity.setDataTimeItem(currentTime);
            orderEntity.setConsumerItem(customer_name);
            orderEntity.setAdressItem(customer_address);
            orderEntity.setOrderItem(list.getList().get(i).getProduct().getName());
            orderEntity.setOrderItemId(list.getList().get(i).getProduct().getId());
            orderEntity.setOrderCost(Integer.toString(list.cartCost("en")));

            try {
                logger.info("Sending OrderEntity to DAO layer");
                OrderDAO.addData(orderEntity);
                logger.info("Order was added to DB!");
            } catch (SQLException e) {
                logger.error("EXEPTION!");
                e.printStackTrace();
            }
        }
    }

    public HistoryList getOrders(String customerName){
        logger.info("Gettin all orders from DB");
        List<historyHistorytableEntity> items = (List<historyHistorytableEntity>)OrderDAO.getCustomerOrders();
        logger.info("Gettin all orders from DB -> Success!");
        ListOfProducts lop = new ListOfProducts();
        ArrayList<Product> listOfProduct = new ArrayList<Product>();
        HistoryList lst = new HistoryList();
        listOfProduct = lop.getList();
        for (historyHistorytableEntity item : items) {
            if(customerName.equals(item.getUserItem())) {
                cartItem itt = new cartItem(listOfProduct.get(Integer.parseInt(item.getOrderItemId()) - 1));
                HistoryItem it = new HistoryItem(itt, item.getConsumerItem(), item.getDataTimeItem(), item.getAdressItem());
                lst.append(it);
            }
        }
        return lst;
    }
}