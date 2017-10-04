/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.services;

import com.netflorist.netflorist.entity.ProductCopy;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflorist.netflorist.repository.ProdCopyRepository;

/**
 *
 * @author Reverside
 */
@Service
public class ProdCopyService {
    @Autowired
    private ProdCopyRepository prodCopyRepository;
    
    private List<ProductCopy> prods;
    
    public List<ProductCopy> findAllprods()
    {

 
        prods = new ArrayList<>();
        prodCopyRepository.findAll().forEach(prods::add);
        
       
        return prods; 
    }

    public ProductCopy findProductCopyById(Long id)
    {
        return prodCopyRepository.findOne(id);
    }
    
    public void saveProductCopy(ProductCopy  prods) {

       prodCopyRepository.save(prods);
    }

    public void updateProductCopy(Long id, ProductCopy prods)
    {

        prodCopyRepository.save(prods);
    }
    
    public void deleteProductCopy(Long id) {

        prodCopyRepository.delete(id);
        
    }
    
}
