package com.netflorist.netflorist.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerOrder implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total_amount")
    private double amount;
    @Column(name = "status", updatable = true)
    private String status;
    @Temporal(TemporalType.DATE)
    @Column(name = "ordered_date")    
    private Date orderedDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "delivery_date")    
    private Date deliveryDate;
    
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<ProductCopy> productCopy = new ArrayList<ProductCopy>();
    
    @OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    public CustomerOrder() {
    }
    public Long getId() {
        return id;
    }

    public CustomerOrder(int quantity, double amount, String status, Date orderedDate, Date deliveryDate) {
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.orderedDate = orderedDate;
        this.deliveryDate = deliveryDate;
    }



    public Collection<ProductCopy> getProductCopy() {
        return productCopy;
    }

    public void setProductCopy(Collection<ProductCopy> productCopy) {
        this.productCopy = productCopy;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        
        this.orderedDate = orderedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
 
    
}
