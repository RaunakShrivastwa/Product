package com.Product.service;

import com.Product.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductServices{
//    create product
     public Product createProduct(Product product);

//     get All Products
     public List<Product> getAllProducts();

//     updateProduct

    public Product updateProduct(Product product);

//    getting Single Product
    public Product getProduct(String product_id);

}
