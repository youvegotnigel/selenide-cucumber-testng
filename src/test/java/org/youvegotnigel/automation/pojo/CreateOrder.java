package org.youvegotnigel.automation.pojo;

import java.util.List;

public class CreateOrder {

    private List<OrderDetail> orders;

    public List<OrderDetail> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetail> orders) {
        this.orders = orders;
    }
}
