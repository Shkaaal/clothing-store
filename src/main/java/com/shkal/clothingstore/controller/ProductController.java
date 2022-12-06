package com.shkal.clothingstore.controller;

import com.shkal.clothingstore.entity.Product;
import com.shkal.clothingstore.exception_handling.NoSuchProductException;
import com.shkal.clothingstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return productList;
    }

    @GetMapping("/productsOrderByCost")
    public List<Product> getAllProductsOrderByCost() {
        List<Product> productList = productService.getAllProducts();
        return productList;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            throw new NoSuchProductException("There is no Product with ID = " +
                    id + " in Database");
        }
        return product;
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return product;
    }

    @DeleteMapping("/products")
    public String deleteProduct(int id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            throw new NoSuchProductException("There is no Product with ID = " +
                    id + " in Database");
        }

        productService.deleteProduct(id);
        return "Product with ID " + id + " was deleted";
    }
}
