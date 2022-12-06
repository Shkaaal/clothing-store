package com.shkal.clothingstore.controller;

import com.shkal.clothingstore.dto.OrderDTO;
import com.shkal.clothingstore.entity.Order;
import com.shkal.clothingstore.exception_handling.NoSuchOrderException;
import com.shkal.clothingstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return orders;
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id);

        if (order == null) {
            throw new NoSuchOrderException("There is no Order with ID = " +
                    id + " in Database");
        }

        return order;
    }

    @PostMapping("/orders")
    public Order saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return order;
    }

    @PutMapping("/orders")
    public Order updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id) {
        Order order = orderService.getOrderById(id);

        if (order == null) {
            throw new NoSuchOrderException("There is no Order with ID = " +
                    id + " in Database");
        }

        return "Order with ID " + id + " was deleted";
    }
}
