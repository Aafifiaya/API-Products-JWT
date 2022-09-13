package com.javainuse.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.javainuse.model.Product;
public interface IProductService {
    public Iterable<Product> listAllProducts();
    public Product getProduct(Integer id);
    public void postProduct(Product product,MultipartFile image);
    public void deleteProduct(Integer id);
    public Optional<Product> putProduct(Product newProduct, Integer id);
   
}


