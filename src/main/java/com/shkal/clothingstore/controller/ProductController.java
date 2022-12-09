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

    @GetMapping("/productsOrderByCostAsc")
    public List<Product> getAllProductsOrderByCostAsc() {
        List<Product> productList = productService.getAllProductsOrderByCostAsc();
        return productList;
    }

    @GetMapping("/productsOrderByCostDesc")
    public List<Product> getAllProductsOrderByCostDesc() {
        List<Product> productList = productService.getAllProductsOrderByCostDesc();
        return productList;
    }

    @GetMapping("/products/findById/{id}")
    public Product getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            throw new NoSuchProductException("There is no Product with ID = " +
                    id + " in Database");
        }
        return product;
    }

    @GetMapping("/products/model/")
    public List<Product> searchProductByName(@RequestParam(value = "name", required = false) String name) {
        List<Product> product = productService.searchProductByName(name);
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
}
