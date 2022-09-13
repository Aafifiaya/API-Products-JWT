package com.javainuse.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javainuse.model.Product;
import com.javainuse.service.IProductService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
@RestController
@CrossOrigin
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/getAllProduct")
    public @ResponseBody Iterable<Product> getProducts() {
            return productService.listAllProducts();
    }
    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }
    @PostMapping("/postProduct")
    public void addProduct(@RequestBody Product product, @RequestParam MultipartFile image) {
        productService.postProduct(product,image);
    }
    @PutMapping("/putProduct/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Integer id) {
        try {
            productService.putProduct(product,id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteProduct/{id}")
    public void removeProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

}
