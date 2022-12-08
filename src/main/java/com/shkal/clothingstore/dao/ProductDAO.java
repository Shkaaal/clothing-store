package com.shkal.clothingstore.dao;

import com.shkal.clothingstore.entity.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> getAllProducts();

    public List<Product> getAllProductsOrderByCostAsc();

    public List<Product> getAllProductsOrderByCostDesc();

    public Product getProductById(int id);

    public void saveProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(int id);
}
