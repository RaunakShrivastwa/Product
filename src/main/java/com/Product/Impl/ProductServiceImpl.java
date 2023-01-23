package com.Product.Impl;
import com.Product.entity.Product;
import com.Product.repositery.ProductRepositery;
import com.Product.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServices {
    @Autowired
    ProductRepositery productRepositery;
    @Override
    public Product createProduct(Product product) {
        return this.productRepositery.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepositery.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        return this.productRepositery.save(product);
    }

    @Override
    public Product getProduct(String product_id) {
       Product p= this.productRepositery.findById(product_id).get();
        System.out.println(p);
        return p;
    }
}
