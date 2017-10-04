/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.web;

import com.netflorist.netflorist.entity.Product;
import com.netflorist.netflorist.services.ProductService;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Reverside
 */
@RestController
public class ProductControl {
    @Autowired
    private ProductService productService;
    private List<Product> products;
    
    @RequestMapping("/products")
    public List<Product> getAllProducts()
    {
        products = new ArrayList<>();
        productService.findAllProducts().forEach(products::add);
        
        return products;
    }  
    @RequestMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        return productService.findProductById(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
        
        productService.saveProduct(product);
        return product;
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/products/{id}")
    public void updateProduct(@RequestBody Product product,@PathVariable Long id)
    {
        productService.updateProduct(id, product);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/products/{id}")
    public void deleteProduct(@PathVariable Long id)
    {
        productService.deleteProduct(id);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/productName/{name}")
    public Product getProductByName(@RequestParam String name) {
        
        return productService.getProductByName(name);
    }
    
    
}
