package com.netflorist.netflorist.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductCopy implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product_id")
    private Long product_id;
    private double price;
    private String name;
    private int quantity;
    private String description;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private CustomerOrder order;

    public ProductCopy() {
    }

    public ProductCopy(Long product_id, double price, String name, int quantity, String description) {
        this.product_id = product_id;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
//
//    public CustomerOrder getOrder() {
//        return order;
//    }
//
//    public void setOrder(CustomerOrder order) {
//        this.order = order;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

      

}
