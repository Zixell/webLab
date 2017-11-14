package dao;

import javax.persistence.*;

/**
 * Created by Roman Zhuravlev on 07.11.2017.
 */
@Entity
@Table(name = "historytable", schema = "history", catalog = "")
public class historyHistorytableEntity {
    private int id;
    private String userItem;
    private String consumerItem;
    private String orderItem;
    private String orderItemId;
    private String adressItem;
    private String dataTimeItem;
    private String orderCost;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userItem")
    public String getUserItem() {
        return userItem;
    }

    public void setUserItem(String userItem) {
        this.userItem = userItem;
    }

    @Basic
    @Column(name = "consumerItem")
    public String getConsumerItem() {
        return consumerItem;
    }

    public void setConsumerItem(String consumerItem) {
        this.consumerItem = consumerItem;
    }

    @Basic
    @Column(name = "orderItem")
    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    @Basic
    @Column(name = "orderItem_id")
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Basic
    @Column(name = "adressItem")
    public String getAdressItem() {
        return adressItem;
    }

    public void setAdressItem(String adressItem) {
        this.adressItem = adressItem;
    }

    @Basic
    @Column(name = "dataTimeItem")
    public String getDataTimeItem() {
        return dataTimeItem;
    }

    public void setDataTimeItem(String dataTimeItem) {
        this.dataTimeItem = dataTimeItem;
    }

    @Basic
    @Column(name = "orderCost")
    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        historyHistorytableEntity that = (historyHistorytableEntity) o;

        if (id != that.id) return false;
        if (userItem != null ? !userItem.equals(that.userItem) : that.userItem != null) return false;
        if (consumerItem != null ? !consumerItem.equals(that.consumerItem) : that.consumerItem != null) return false;
        if (orderItem != null ? !orderItem.equals(that.orderItem) : that.orderItem != null) return false;
        if (orderItemId != null ? !orderItemId.equals(that.orderItemId) : that.orderItemId != null) return false;
        if (adressItem != null ? !adressItem.equals(that.adressItem) : that.adressItem != null) return false;
        if (dataTimeItem != null ? !dataTimeItem.equals(that.dataTimeItem) : that.dataTimeItem != null) return false;
        if (orderCost != null ? !orderCost.equals(that.orderCost) : that.orderCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userItem != null ? userItem.hashCode() : 0);
        result = 31 * result + (consumerItem != null ? consumerItem.hashCode() : 0);
        result = 31 * result + (orderItem != null ? orderItem.hashCode() : 0);
        result = 31 * result + (orderItemId != null ? orderItemId.hashCode() : 0);
        result = 31 * result + (adressItem != null ? adressItem.hashCode() : 0);
        result = 31 * result + (dataTimeItem != null ? dataTimeItem.hashCode() : 0);
        result = 31 * result + (orderCost != null ? orderCost.hashCode() : 0);
        return result;
    }
}
