package com.javainuse.service;
import java.io.IOException;
import java.net.FileNameMap;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Optional;
import com.google.common.io.Files;
import com.javainuse.model.Product;
import com.javainuse.repositories.ProductRepository;

@Service
@Transactional
public class ProductService implements IProductService{
    public static String uploadDirectory=System.getProperty("product.dir")+"src/main/assets/imageData";
    @Autowired
    private ProductRepository repo;

    public Iterable<Product> listAllProducts() {
        return repo.findAll();
    }
    public Product getProduct(Integer id){
        return repo.findById(id).get();
    }
   

    /* (non-Javadoc)
     * @see com.javainuse.service.IProductService#postProduct(com.javainuse.model.Product, org.springframework.web.multipart.MultipartFile)
     */
    public void postProduct(Product product,MultipartFile image) {
        // StringBuilder fileNames=new StringBuilder();
        // String filename=product.getId()+image.getOriginalFilename().substring(image.getOriginalFilename().length()-4);
        // io.swagger.models.Path fileNamePath= (io.swagger.models.Path) Paths.get(uploadDirectory,filename);
        // product.setImage(filename);
        repo.save(product);
    }
    public void deleteProduct(Integer id) {
        repo.deleteById(id);
    }
    public java.util.Optional<Product> putProduct(Product newProduct, Integer id){
        java.util.Optional<Product> userProduct=repo.findById(id).map(prod->{
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
            return repo.save(prod);
        });
        return  userProduct;
    }
}
