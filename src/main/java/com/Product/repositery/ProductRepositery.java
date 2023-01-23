package com.Product.repositery;

import com.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositery extends JpaRepository<Product,String> {

}
