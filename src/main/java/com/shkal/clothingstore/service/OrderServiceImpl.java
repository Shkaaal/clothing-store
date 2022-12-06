package com.shkal.clothingstore.service;

import com.shkal.clothingstore.dao.OrderDAO;
import com.shkal.clothingstore.dto.OrderDTO;
import com.shkal.clothingstore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    @Transactional
    public List<OrderDTO> getAllOrders() {

        Iterator itr = orderDAO.getAllOrders().iterator();

        List<OrderDTO> listOrderDTO = new ArrayList<>();

        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            Integer service1 = Integer.parseInt(String.valueOf(obj[0]));
            Integer service2 = Integer.parseInt(String.valueOf(obj[1]));
            Integer service3 = Integer.parseInt(String.valueOf(obj[2]));

            OrderDTO orderDTO = new OrderDTO(service1, service2, service3);
            listOrderDTO.add(orderDTO);
        }

        return listOrderDTO;
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
