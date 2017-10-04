/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.services;

import com.netflorist.netflorist.entity.CustomerOrder;
import com.netflorist.netflorist.repository.CustomerOrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reverside
 */
@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    
    private List<CustomerOrder> customerOrders;
    
    public List<CustomerOrder> findAllcustomerOrders()
    {

 
        customerOrders = new ArrayList<>();
        customerOrderRepository.findAll().forEach(customerOrders::add);
        
       
        return customerOrders; 
    }
    public List<CustomerOrder> findAllOrders(String customerId)
    {
        customerOrders = new ArrayList<>();
        customerOrderRepository.findByCustomerId(customerId).forEach(customerOrders::add);
        
       
        return customerOrders; 
    }

    public CustomerOrder findCustomerOrderById(Long id)
    {
        return customerOrderRepository.findOne(id);
    }
    
    public void saveCustomerOrder(CustomerOrder  customerOrders) {

       customerOrderRepository.save(customerOrders);
    }

    public void updateCustomerOrder(Long id, CustomerOrder customerOrders)
    {

        customerOrderRepository.save(customerOrders);
    }
    
    public void deleteCustomerOrder(Long id) {

        customerOrderRepository.delete(id);
        
    }
    
}
