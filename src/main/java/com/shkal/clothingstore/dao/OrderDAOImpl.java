package com.shkal.clothingstore.dao;

import com.shkal.clothingstore.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();

//        List<Order> orders = session.createQuery("from ", Order.class).getResultList();
        Query<Order> orders = session.createQuery("from Order", Order.class);
        return orders.getResultList();
    }

    @Override
    public void saveNewOrder(Order order) {

    }

    @Override
    public Order getOrder(int id) {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

    }
}
