package com.shkal.clothingstore.service;

import com.shkal.clothingstore.dao.ProductDAO;
import com.shkal.clothingstore.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Transactional
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Transactional
    @Override
    public List<Product> getAllProductsOrderByCost() {
        return null;
    }

    @Transactional
    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Transactional
    @Override
    public void saveProduct(Product product) {

    }

    @Transactional
    @Override
    public void updateProduct(Product product) {

    }

    @Transactional
    @Override
    public void deleteProduct(int id) {

    }
}
