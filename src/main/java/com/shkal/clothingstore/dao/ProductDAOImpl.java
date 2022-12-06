package com.shkal.clothingstore.dao;

import com.shkal.clothingstore.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getAllProductsOrderByCost() {
        return null;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }
}
