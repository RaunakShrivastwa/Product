package com.Product.controller;

import com.Product.entity.Product;
import com.Product.repositery.ProductRepositery;
import com.Product.service.ProductServices;
import com.Product.service.saveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    String intArray[];

    @Autowired
    saveProductService saveProductService;

    @Autowired
    ProductRepositery productRepositery;

    @Autowired
    ProductServices productServices;

    @GetMapping("/add")
    public String Add(Model model){
        model.addAttribute("product",new Product());
        return "AddProduct";
    }

    @PostMapping("/product")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> createProduct(@RequestParam("file")MultipartFile file,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("size") String size,
                                                 @RequestParam("prise") String prise){

       return this.saveProductService.saveData(file,name,size,prise);
    }

    @GetMapping("/product")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> allProducts = this.productServices.getAllProducts();
        return ResponseEntity.ok().body(allProducts);
    }

    @GetMapping("/list")
    public String viewuserList(Model model){
        List<Product> productList=this.productRepositery.findAll();
        model.addAttribute("productList",productList);

        return "ListProduct";
    }

    @GetMapping("product/{intArray}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Product>> getAll(@PathVariable String[] intArray){
        int length = intArray.length;
        List<Product> p=new ArrayList<Product>();
        String s[]=new String[length];
        for(int i=0;i<length;i++){
            Product product = this.productServices.getProduct(intArray[i]);
            p.add(product);

             s[i]=product.toString();


         }

        return ResponseEntity.ok().body(p);
    }

    @GetMapping("products/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") String product_id){
        Product product = this.productServices.getProduct(product_id);
        return ResponseEntity.ok().body(product);
    }

}
