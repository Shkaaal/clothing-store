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
        return productDAO.getAllProducts();
    }

    @Transactional
    @Override
    public List<Product> getAllProductsOrderByCostAsc() {
        return productDAO.getAllProductsOrderByCostAsc();
    }

    @Transactional
    @Override
    public List<Product> getAllProductsOrderByCostDesc() {
        return productDAO.getAllProductsOrderByCostDesc();
    }

    @Transactional
    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Transactional
    @Override
    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    @Transactional
    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Transactional
    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }
}
