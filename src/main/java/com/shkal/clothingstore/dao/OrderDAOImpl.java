package com.shkal.clothingstore.dao;

import com.shkal.clothingstore.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select od.order, od.product, od.quantity " +
                "from Order as o inner join ProductRelation as od on o.id = od.id inner join Product as p on p.id = od.product" +
                " order by od.order");
        return query.getResultList();
    }

    @Override
    public Order getOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public void updateOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("delete from Order where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
