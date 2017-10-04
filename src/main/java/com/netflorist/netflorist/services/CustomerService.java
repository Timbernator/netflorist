 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflorist.netflorist.entity.Customer;
import com.netflorist.netflorist.repository.CustomerRepository;
import java.util.ArrayList;

/**
 *
 * @author Reverside
 */


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    //private Customer customer;
    private static List<Customer> customers;
    


    public List<Customer> findAllCustomers()
    {

 
        customers = new ArrayList<>();
        
        //convert the Iterator of entities into a List
        customerRepository.findAll().forEach(customers::add);
        
       
        return customers; 
    }
    public Customer findCustomerBy(String id)
    {

        return customerRepository.findOne(id);
    }

    public void saveCustomer(Customer  customer) {

       customerRepository.save(customer);
    }
    public void updateCustomer(String id, Customer customer)
    {

        customerRepository.save(customer);
    }

    public void deleteCustomer(String id) {

        customerRepository.delete(id);
        
    }
    
    public Customer login(String username, String password)
    {
        Customer customer = null;
       
        List<Customer> customers = findAllCustomers();
        
        for(int x = 0 ; x < customers.size() ; x++)
        {
            if (customers.get(x).getUsername().equalsIgnoreCase(username) &&customers.get(x).getPassword().equalsIgnoreCase(password) )
            {
                customer=customers.get(x);
                break;
            }
            
        }
       
        return customer;
    }
    
    
    
}
