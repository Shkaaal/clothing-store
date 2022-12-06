package com.shkal.clothingstore.service;

import com.shkal.clothingstore.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public List<Product> getAllProductsOrderByCost();

    public Product getProductById(int id);

    public void saveProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(int id);
}
