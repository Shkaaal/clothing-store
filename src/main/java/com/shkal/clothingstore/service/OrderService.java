package com.shkal.clothingstore.service;

import com.shkal.clothingstore.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();

    public void saveNewOrder(Order order);

    public Order getOrder(int id);

    public void deleteOrder(int id);
}
