package com.shkal.clothingstore.dao;

import com.shkal.clothingstore.entity.Order;

import java.util.List;

public interface OrderDAO {

    public List<Object> getAllOrders();

    public Order getOrderById(int id);

    public void saveOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrder(int id);

    public List<Object> searchOrdersByCustomerSurnameAndName(String surname, String name);
}
