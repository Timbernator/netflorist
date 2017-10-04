/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.web;

import com.netflorist.netflorist.entity.Customer;
import com.netflorist.netflorist.services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class CustomerControl {
    
    @Autowired
    private CustomerService customerService;
    private List<Customer> customers;

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public List<Customer> getAll()
    {
        customers = new ArrayList<>();
        customerService.findAllCustomers().forEach(customers::add);
        return customers;
    }
 
    @RequestMapping("/customers/{id}")
    public Customer getCustomerbyId(@PathVariable String id) {
        
        return customerService.findCustomerBy(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public void addCustomer(@RequestBody Customer customer)
    {
        customerService.saveCustomer(customer);
    }
    
    @RequestMapping(method = RequestMethod.PUT,value = "/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer,@PathVariable String id)
    {
        customerService.updateCustomer(id, customer);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/customers/{id}")
    public void deleteCustomer(@PathVariable String id)
    {
        customerService.deleteCustomer(id);
    }
    

    @RequestMapping(method = RequestMethod.GET, value = "/login",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Customer login(@RequestParam String username, String password) {
        
        return customerService.login(username, password);
    }
       
}
