/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.web;

import com.netflorist.netflorist.entity.Customer;
import com.netflorist.netflorist.entity.CustomerOrder;
import com.netflorist.netflorist.services.CustomerOrderService;
import com.netflorist.netflorist.services.ProdCopyService;
import java.util.ArrayList;
import java.util.Date;
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
public class OrderControl {
    @Autowired
    private CustomerOrderService customerOrderService;
    private List<CustomerOrder> customerOrders;
    
    @RequestMapping("/customerOrders")
    public List<CustomerOrder> getAllOrder()
    {
        customerOrders = new ArrayList<>();
        customerOrderService.findAllcustomerOrders().forEach(customerOrders::add);
        
        return customerOrders;
    }  
    @RequestMapping("/customers/{id}/customerOrders")
    public List<CustomerOrder> getAllCustomerOrder(@PathVariable String id)
    {
        
        return customerOrders;
    }
    @RequestMapping("/customerOrders/{id}")
    public CustomerOrder getOrdertById(@PathVariable Long id)
    {
        return customerOrderService.findCustomerOrderById(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/placeOrder")
    public CustomerOrder saveOder(@RequestBody CustomerOrder customerOrder)
    {
        customerOrderService.saveCustomerOrder(customerOrder);
        return customerOrder;
    }
    @RequestMapping(method = RequestMethod.PUT,value = "customers/{customerId}/customerOrders/{id}")
    public CustomerOrder updateOder(@RequestBody CustomerOrder customerOrder,@PathVariable String customerId,@PathVariable Long id)
    {
        customerOrder.setCustomer(new Customer(customerId));
        customerOrderService.updateCustomerOrder(id, customerOrder);
        return customerOrder;
    }
        @RequestMapping(method = RequestMethod.DELETE,value = "/customerOrders/{id}")
    public void removeOrder(@PathVariable Long id)
    {
        customerOrderService.deleteCustomerOrder(id);
    }
}
