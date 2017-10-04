/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.services;

import com.netflorist.netflorist.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflorist.netflorist.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Reverside
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    private static List<Product> products;
    
    public List<Product> findAllProducts()
    {

 
        products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        
       
        return products; 
    }

    public Product findProductById(Long id)
    {
        return productRepository.findOne(id);
    }
    
    public void saveProduct(Product  product) {

       productRepository.save(product);
    }

    public void updateProduct(Long id, Product product)
    {

        productRepository.save(product);
    }
    
    public void deleteProduct(Long id) {

        productRepository.delete(id);
        
    }

    
    public Product getProductByName(String name)
    {
        Product product = null;
        products = findAllProducts();
        
        for(int x = 0;x<products.size();x++)
        {
            if(products.get(x).getName().equalsIgnoreCase(name))
            {
                product = products.get(x);
                break;
            }
        }
        return product;
    }
    
}

    
    
    