package com.Product.service;

import com.Product.entity.Product;
import com.Product.repositery.ProductRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class saveProductService {

    @Autowired
    ProductRepositery productRepositery;
    public ResponseEntity<Product> saveData(MultipartFile file, String name, String size, String prise){
        Product product=new Product();
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setName(name);
        product.setPrise(prise);
        product.setSize(size);
        Product save = this.productRepositery.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}

