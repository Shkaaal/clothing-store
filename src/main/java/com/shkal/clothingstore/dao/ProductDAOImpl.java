package com.shkal.clothingstore.dao;

import com.shkal.clothingstore.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllProductsOrderByCostAsc() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("from Product order by price asc", Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllProductsOrderByCostDesc() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("from Product order by price desc", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public void saveProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }
}
