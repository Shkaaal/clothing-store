package com.shkal.clothingstore.service;

import com.shkal.clothingstore.dao.OrderDAO;
import com.shkal.clothingstore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    @Transactional
    public List getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    @Transactional
    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        order.setDate(LocalDateTime.now(ZoneOffset.UTC));
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }
}
