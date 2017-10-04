///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.netflorist.netflorist.web;
//
//import com.netflorist.netflorist.entity.Cart;
//import com.netflorist.netflorist.services.CartService;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author Reverside
// */
//@RestController
//public class CartControl {
//    @Autowired
//    private CartService cartService;
//    private List<Cart> carts;
//    
//    @RequestMapping(method = RequestMethod.GET, value = "/carts")
//    public List<Cart> getAllInCart()
//    {
//        carts = new ArrayList<>();
//        cartService.getAllInCart().forEach(carts::add);
//        return carts;
//    }
// 
//    @RequestMapping("/carts/{id}")
//    public Cart getCartById(@PathVariable Long id) {
//        
//        return cartService.findCartById(id);
//    }
//    
//    @RequestMapping(method = RequestMethod.POST, value = "/addToCart",produces = {MediaType.APPLICATION_JSON_VALUE})
//    public void addToCart(@RequestBody Cart cart)
//    {
//        cartService.AddToCart(cart);
//    }
//    
//    @RequestMapping(method = RequestMethod.PUT,value = "/cart/{id}")
//    public void updateCart(@RequestBody Cart cart,@PathVariable Long id)
//    {
//        cartService.updateCart(id, cart);
//    }
//    
//    @RequestMapping(method = RequestMethod.DELETE,value = "/cart/{id}")
//    public void removeFromCart(@PathVariable Long id)
//    {
//        cartService.removeFromCart(id);
//    }
//    
//
//    @RequestMapping(method = RequestMethod.GET, value = "/totalInCart")
//    public double TotalPrice() {
//        
//        return cartService.getTotal();
//    }
//    @RequestMapping(method = RequestMethod.GET, value = "/items")
//    public int Items() {
//        
//        return cartService.getItemsInCart();
//    }
//}
