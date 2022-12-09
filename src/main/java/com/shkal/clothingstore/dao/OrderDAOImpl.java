package com.shkal.clothingstore.dao;

import com.shkal.clothingstore.entity.Customer;
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
    public List<Object> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("select od.order.id, od.product.id, od.quantity " +
                "from Order as o " +
                "inner join ProductRelation as od on o.id = od.order.id " +
                "inner join Product as p on p.id = od.product.id" +
                " order by od.order.id");

        List<Object> result = (List<Object>) query.list();
        return result;
    }

    @Override
    public Order getOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
    }

    @Override
    public void updateOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
//        Query<Order> query = session.createQuery("delete from Order where id =:id");
//        query.setParameter("id", id);
//        query.executeUpdate();
        session.remove(session.get(Order.class, id));
    }

    public List<Object> searchOrdersByCustomerSurnameAndName(String surname, String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c.name, c.surname, pd.product.id, pd.order.id, pd.quantity " +
                                                    "from Customer c " +
                                                    "join Order o on c.id = o.customer.id " +
                                                    "join ProductRelation pd on o.id = pd.order.id " +
                                                    "where c.name = :name and c.surname = :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);

        List<Object> list = (List<Object>) query.list();
        return list;
    }
}
