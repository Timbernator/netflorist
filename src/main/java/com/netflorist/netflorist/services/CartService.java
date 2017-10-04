///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.netflorist.netflorist.services;
//
//import com.netflorist.netflorist.entity.Cart;
//import com.netflorist.netflorist.repository.CartRepository;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Reverside
// */
//@Service
//public class CartService {
//     @Autowired
//    private CartRepository cartRepository;
//    private static List<Cart> carts;
//    
//
//
//    public List<Cart> getAllInCart()
//    {
//        carts = new ArrayList<>();
//        cartRepository.findAll().forEach(carts::add);
//        
//       
//        return carts; 
//    }
//    public Cart findCartById(Long id)
//    {
//
//        return cartRepository.findOne(id);
//    }
//
//    public void AddToCart(Cart  cart) {
//
//       cartRepository.save(cart);
//    }
//    public void updateCart(Long id, Cart cart)
//    {
//
//        cartRepository.save(cart);
//    }
//
//    public void removeFromCart(Long id) {
//
//        cartRepository.delete(id);
//        
//    }
//    
//    public double getTotal()
//    {
//       
//        carts = getAllInCart();
//        double totalInCart = 0;
//        for(int i = 0 ; i < carts.size();i++)
//        {
//            totalInCart = carts.get(i).getQuntity() * carts.get(i).getTotal();
//        }
//       
//        return totalInCart;
//    }
//    public int getItemsInCart()
//    {
//       
//        carts = getAllInCart();
//              
//        int products = carts.size();
//        
//        return products ;
//    }
//    
//}
