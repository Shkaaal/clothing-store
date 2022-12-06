package com.shkal.clothingstore.service;

import com.shkal.clothingstore.dto.OrderDTO;
import com.shkal.clothingstore.entity.Order;

import java.util.List;

public interface OrderService {

    public List<OrderDTO> getAllOrders();

    public Order getOrderById(int id);

    public void saveOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrder(int id);

}
