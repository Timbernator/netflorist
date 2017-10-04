package com.netflorist.netflorist.web;


import com.netflorist.netflorist.entity.ProductCopy;
import com.netflorist.netflorist.services.ProdCopyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reverside
 */
@RestController
public class ProductCopyCtrl {
    @Autowired
    private ProdCopyService prodsCopyService;
    private List<ProductCopy> prods;
    
    @RequestMapping("/productCopy")
    public List<ProductCopy> getAllCopies()
    {
        prods = new ArrayList<>();
        prodsCopyService.findAllprods().forEach(prods::add);
        
        return prods;
    }  
    @RequestMapping("/productCopy/{id}")
    public ProductCopy getProductCopytById(@PathVariable Long id)
    {
        return prodsCopyService.findProductCopyById(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/productCopy")
    public void saveProductCopy(@RequestBody ProductCopy productCopy)
    {
        prodsCopyService.saveProductCopy(productCopy);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/productCopy/{id}")
    public void updateProductCopy(@RequestBody ProductCopy productCopy,@PathVariable Long id)
    {
        prodsCopyService.updateProductCopy(id, productCopy);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/productCopy/{id}")
    public void removeProductCopy(@PathVariable Long id)
    {
        prodsCopyService.deleteProductCopy(id);
    }
}

